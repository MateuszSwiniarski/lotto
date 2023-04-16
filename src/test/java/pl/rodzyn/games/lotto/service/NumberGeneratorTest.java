package pl.rodzyn.games.lotto.service;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


class NumberGeneratorTest {

    @Test
    void should_generate_six_random_numbers() {
        //given
        NumberGenerator generator = new NumberGenerator();
        //when
        Set<Integer> generateSet = generator.generateRandomNumbers();
        //then
        assertThat(generateSet, hasSize(6));
    }

    @Test
    void random_set_should_be_between_range_1_to_100() {
        //given
        NumberGenerator generator = new NumberGenerator();
        //when
        Set<Integer> generateSet = generator.generateRandomNumbers();
        //then
        assertThat(generateSet, not(contains(101, 0, -3, 164, "a")));
    }
}