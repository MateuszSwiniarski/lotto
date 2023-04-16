package pl.rodzyn.games.lotto.service;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public class LottoResult {

    private String text;

    @Override
    public String toString() {
        return text;
    }
}
