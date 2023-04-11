package pl.rodzyn.lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class NumberGeneratorTest {

    @Test
    void should_generate_six_random_numbers(){
        //given
        NumberGenerator generator = new NumberGenerator();
        //when
        Set<Integer> generateSet = generator.generateRandomNumbers(6);
        //then
        assertThat(generateSet, hasSize(6));
    }

    @Test
    void random_set_should_be_between_range_1_to_100(){
        //given
        NumberGenerator generator = new NumberGenerator();
        //when
        Set<Integer> generateSet = generator.generateRandomNumbers(6);
        //then
        assertThat(generateSet, not(contains(101,0, -3, 164, "a")));
    }

    @Test
    void user_should_provide_six_number(){
        //given
        NumberGenerator generator = mock(NumberGenerator.class);
        when(generator.provideNumberByUser(6)).thenReturn(exampleSet());
        //when
        Set<Integer> userSet = generator.provideNumberByUser(6);
        //then
        assertThat(userSet.size(), equalTo(6));
        assertThat(userSet, not(empty()));
    }

    private Set<Integer> exampleSet(){
        return new HashSet<>(Arrays.asList(1,2,3,4,5,6));

    }
}