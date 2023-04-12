package pl.rodzyn.lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

class LottoTest {

    @Test
    void should_return_correct_result_for_six_hit_numbers() {
        //given
        LottoGame lotto = mock(LottoGame.class);
        doNothing().when(lotto).start();
        //when
        lotto.start();
        //then
        verify(lotto, times(1)).start();

    }

    private Set<Integer> generateSet() {
        return new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    private Set<Integer> userSetWithSixCorrectNumber() {
        return new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

}