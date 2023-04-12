package pl.rodzyn.lotto;

import pl.rodzyn.lotto.service.LottoGame;

public class Games {

    public static void main(String[] args) {
        Game lotto = new LottoGame();
        lotto.start();
    }
}
