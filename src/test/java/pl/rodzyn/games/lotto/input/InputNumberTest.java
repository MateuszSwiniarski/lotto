package pl.rodzyn.games.lotto.input;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class InputNumberTest {

    @Test
    void should_return_six_number_from_user_which_in_range_from_one_to_one_hundred() {
        //given
        Set<Integer> expectedSet = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        InputNumber inputNumber = new InputNumber();
        String givenNumber = "1 2 3 4 5 6";
        Scanner scanner = mockGivenNumber(givenNumber);
        //then
        Set<Integer> inputSet = inputNumber.loadNumberFromUSer(scanner);
        //when
        assertThat(inputSet, equalTo(expectedSet));
    }

    @Test
    void should_return_six_numbers_when_user_provide_one_number_out_of_range() {
        //given
        Set<Integer> expectedSet = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        InputNumber inputNumber = new InputNumber();
        String givenNumber = "1 2 3 4 5 101 6";
        Scanner scanner = mockGivenNumber(givenNumber);
        //then
        Set<Integer> inputSet = inputNumber.loadNumberFromUSer(scanner);
        //when
        assertThat(inputSet, equalTo(expectedSet));
    }

    @Test
    void should_return_empty_set_when_all_out_of_range() {
        Set<Integer> expectedSet = Collections.emptySet();
        InputNumber inputNumber = new InputNumber();
        String givenNumber = "-1 -2 -32 423 105 101 642";
        Scanner scanner = mockGivenNumber(givenNumber);
        //then
        Set<Integer> inputSet = inputNumber.loadNumberFromUSer(scanner);
        //when
        assertThat(inputSet, equalTo(expectedSet));
    }

    private Scanner mockGivenNumber(String givenNumber) {
        InputStream inputStream = System.in;
        System.setIn(new ByteArrayInputStream(givenNumber.getBytes()));
        Scanner scanner = new Scanner(System.in);
        System.setIn(inputStream);
        return scanner;
    }

}