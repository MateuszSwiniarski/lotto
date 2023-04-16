package pl.rodzyn.games.lotto.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class MessagePrinterTest {

    @ParameterizedTest(name = "given number {0}, return: {1}")
    @MethodSource("provideNumberAndMessage")
    void when_call_printMessage_method(int number, String expectedMessage) {
        //given
        MessagePrinter printer = new MessagePrinter();
        //when
        String result = printer.printMessage(number);
        //then
        assertThat(result, equalTo(expectedMessage));
    }

    private static Stream<Arguments> provideNumberAndMessage() {
        final Arguments argument1 = Arguments.of(0,
                "You haven't hit any numbers");

        final Arguments argument2 = Arguments.of(1,
                "You hit 1 number");

        final Arguments argument3 = Arguments.of(2,
                "You hit 2 numbers");

        final Arguments argument4 = Arguments.of(3,
                "You hit 3 numbers");

        final Arguments argument5 = Arguments.of(4,
                "You hit 4 numbers");

        final Arguments argument6 = Arguments.of(5,
                "You hit 5 numbers");

        final Arguments argument7 = Arguments.of(6,
                "YOU WIN, you hit 6 numbers");

        return Stream.of(argument1, argument2, argument3, argument4, argument5, argument6, argument7);
    }
}