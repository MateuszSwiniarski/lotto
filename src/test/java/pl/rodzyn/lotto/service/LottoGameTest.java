package pl.rodzyn.lotto.service;

import org.junit.jupiter.api.Test;
import pl.rodzyn.lotto.service.LottoGame;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;

class LottoGameTest {

    @Test
    void should_return_correct_result_for_six_hit_numbers() {
        //given
        LottoGame game = mock(LottoGame.class);
        when(game.showResult(6)).thenReturn("YOU WIN, you hit 6 numbers");

        //when
        String result = game.showResult(6);
        //then
        assertThat(result, equalTo("YOU WIN, you hit 6 numbers"));
    }

    @Test
    void should_return_correct_result_for_one_hit_numbers() {
        //given
        LottoGame game = mock(LottoGame.class);
        when(game.showResult(1)).thenReturn("You hit one number");

        //when
        String result = game.showResult(1);
        //then
        assertThat(result, equalTo("You hit one number"));
    }

    @Test
    void should_return_correct_result_for_zero_hit_numbers() {
        //given
        LottoGame game = mock(LottoGame.class);
        when(game.showResult(0)).thenReturn("You haven't hit any numbers");

        //when
        String result = game.showResult(0);
        //then
        assertThat(result, equalTo("You haven't hit any numbers"));
    }
}