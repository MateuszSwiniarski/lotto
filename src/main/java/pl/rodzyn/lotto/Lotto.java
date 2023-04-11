package pl.rodzyn.lotto;

import lombok.Data;
import java.util.Set;

@Data
public class Lotto implements Game {

    private final static int NUMBERS_TO_HIT = 6;
    private MessagePrinter writer = new MessagePrinter();
    NumberGenerator generator = new NumberGenerator();
    private static Set<Integer> listOfGeneratedRandomNumber;
    private static Set<Integer> listOfNumberProvidedByUser;

    @Override
    public void start() {
        listOfGeneratedRandomNumber = getGenerator().generateRandomNumbers(NUMBERS_TO_HIT);
        listOfNumberProvidedByUser = getGenerator().provideNumberByUser(NUMBERS_TO_HIT);
        checkHowManyNumberHit();
    }

    private void checkHowManyNumberHit() {
        getWriter().formatString("Drawn numbers: ");
        printNumberFromList(listOfGeneratedRandomNumber);

        getWriter().formatString("Entered numbers by User: ");
        printNumberFromList(listOfNumberProvidedByUser);

        int size = checkHitNumbers();
        getWriter().printMessage(size);
    }

    private void printNumberFromList(Set<Integer> list){
        list.forEach(i -> getWriter().formatInteger(i));
        System.out.println();
    }

    private int checkHitNumbers() {
        listOfNumberProvidedByUser.retainAll(listOfGeneratedRandomNumber);
        return listOfNumberProvidedByUser.size();
    }
}
