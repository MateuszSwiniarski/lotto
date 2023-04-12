package pl.rodzyn.lotto.service;

import pl.rodzyn.lotto.Game;
import pl.rodzyn.lotto.model.Lotto;

import java.util.Set;

public class LottoGame implements Game {

    private final static int NUMBERS_TO_HIT = 6;
    private NumberGenerator generator = new NumberGenerator();
    private MessagePrinter writer = new MessagePrinter();
    private Lotto lotto = new Lotto();

    @Override
    public void start() {
        lotto.setListOfGeneratedRandomNumber(generator.generateRandomNumbers(NUMBERS_TO_HIT));
        lotto.setListOfNumberProvidedByUser(generator.provideNumberByUser(NUMBERS_TO_HIT));
        printGenerateSets();
        writer.printText(showResult(checkHitNumbers()));

    }

    public String showResult(int hitSize) {
        return writer.printMessage(hitSize);
    }

    private void printGenerateSets(){
        writer.formatString("Drawn numbers: ");
        printNumberFromList(lotto.getListOfGeneratedRandomNumber());

        writer.formatString("Entered numbers by User: ");
        printNumberFromList(lotto.getListOfNumberProvidedByUser());
    }

    private void printNumberFromList(Set<Integer> list) {
        list.forEach(i -> writer.formatInteger(i));
        System.out.println();
    }

    private int checkHitNumbers() {
        lotto.getListOfNumberProvidedByUser().retainAll(lotto.getListOfGeneratedRandomNumber());
        return lotto.getListOfNumberProvidedByUser().size();
    }
}
