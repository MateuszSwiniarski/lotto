package pl.rodzyn.games;

import pl.rodzyn.games.lotto.Game;
import pl.rodzyn.games.lotto.input.InputNumber;
import pl.rodzyn.games.lotto.service.LottoGame;
import pl.rodzyn.games.lotto.service.MessagePrinter;
import pl.rodzyn.games.lotto.service.NumberGenerator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Game lotto = new LottoGame(new NumberGenerator(),
                new InputNumber(),
                new MessagePrinter(),
                new Scanner(System.in));
        lotto.start();
    }
}
