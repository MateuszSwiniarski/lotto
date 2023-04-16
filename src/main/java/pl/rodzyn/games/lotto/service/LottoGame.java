package pl.rodzyn.games.lotto.service;

import lombok.Data;
import pl.rodzyn.games.lotto.Game;
import pl.rodzyn.games.lotto.config.Config;
import pl.rodzyn.games.lotto.input.InputNumber;

import java.util.Scanner;
import java.util.Set;

@Data
public class LottoGame implements Game {

    private final NumberGenerator generator;
    private final InputNumber inputNumber;
    private final MessagePrinter printer;
    private final Scanner scanner;

    @Override
    public LottoResult start() {
        LottoResult result = lottoResult();
        printer.printText(result.toString());
        return result;
    }

    private LottoResult lottoResult() {
        Set<Integer> generatedRandomSet = generator.generateRandomNumbers();
        Set<Integer> loadNumbersFromUser = inputNumber.loadNumberFromUSer(scanner);
        String stringFromSets = generateMessageWithCreatedSets(generatedRandomSet, loadNumbersFromUser);
        String result = showResult(checkHitNumbers(generatedRandomSet, loadNumbersFromUser));
        String finalResult = showFinalResult(stringFromSets, result);
        return new LottoResult(finalResult);
    }

    private String showFinalResult(String stringFromSet, String result) {
        return stringFromSet
                + "\n"
                + result;
    }

    private String showResult(int hitSize) {
        return printer.printMessage(hitSize);
    }

    private int checkHitNumbers(Set<Integer> randomSet, Set<Integer> userSet) {
        userSet.retainAll(randomSet);
        return userSet.size();
    }

    private String generateMessageWithCreatedSets(Set<Integer> randomSet, Set<Integer> userSet) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%25s", Config.DRAW_MESSEGE))
                .append(generateStringFromSet(randomSet))
                .append("\n")
                .append(String.format("%25s", Config.ENTER_MESSAGE))
                .append(generateStringFromSet(userSet));
        return sb.toString();
    }

    private String generateStringFromSet(Set<Integer> set) {
        StringBuilder sb = new StringBuilder();
        set.forEach(i -> sb.append(String.format("%2s", i)).append(" "));
        return sb.toString();
    }
}
