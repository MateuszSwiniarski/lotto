package pl.rodzyn.games.lotto.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.rodzyn.games.lotto.input.InputNumber;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;

class LottoGameTest {

    private final Scanner scannerMock = new Scanner(System.in);
    private final NumberGenerator generatorMock = mock(NumberGenerator.class);
    private final InputNumber inputNumberMock = mock(InputNumber.class);
    private static final MessagePrinter printerMock = new MessagePrinter();

    @ParameterizedTest(name = "player gave {0}, random numbers were {1}")
    @MethodSource("provideNumbersAndMessage")
    void should_return_correct_result_for_six_hit_numbers(Set<Integer> generatedSet,
                                                          Set<Integer> userSet,
                                                          String expectedMessage) {
        //given
        when(generatorMock.generateRandomNumbers()).thenReturn(generatedSet);
        when(inputNumberMock.loadNumberFromUSer(scannerMock)).thenReturn(userSet);
        LottoGame lottoGame = new LottoGame(generatorMock, inputNumberMock, printerMock, scannerMock);
        //when
        LottoResult start = lottoGame.start();
        //then
        assertThat(start.toString(), equalTo(expectedMessage));
    }

    private static Stream<Arguments> provideNumbersAndMessage() {
        final Arguments arg1 = Arguments.of(exampleSet(),
                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                printMessage(6, exampleSet(), new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))).toString());

        final Arguments arg2 = Arguments.of(exampleSet(),
                new HashSet<>(Arrays.asList(6, 7, 8, 9, 10, 11)),
                printMessage(1, exampleSet(), new HashSet<>(Arrays.asList(6, 7, 8, 9, 10, 11))).toString());

        final Arguments arg3 = Arguments.of(exampleSet(),
                new HashSet<>(Arrays.asList(5, 6, 7, 8, 9, 10)),
                printMessage(2, exampleSet(), new HashSet<>(Arrays.asList(5, 6, 7, 8, 9, 10))).toString());

        final Arguments arg4 = Arguments.of(exampleSet(),
                new HashSet<>(Arrays.asList(4, 5, 6, 7, 8, 9)),
                printMessage(3, exampleSet(), new HashSet<>(Arrays.asList(4, 5, 6, 7, 8, 9))).toString());

        final Arguments arg5 = Arguments.of(exampleSet(),
                new HashSet<>(Arrays.asList(3, 4, 5, 6, 7, 8)),
                printMessage(4, exampleSet(), new HashSet<>(Arrays.asList(3, 4, 5, 6, 7, 8))).toString());

        final Arguments arg6 = Arguments.of(exampleSet(),
                new HashSet<>(Arrays.asList(2, 3, 4, 5, 6, 7)),
                printMessage(5, exampleSet(), new HashSet<>(Arrays.asList(2, 3, 4, 5, 6, 7))).toString());

        final Arguments arg7 = Arguments.of(exampleSet(),
                new HashSet<>(Arrays.asList(7, 8, 9, 10, 11, 12)),
                printMessage(0, exampleSet(), new HashSet<>(Arrays.asList(7, 8, 9, 10, 11, 12))).toString());


        return Stream.of(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    private static LottoResult printMessage(int number, Set<Integer> generatedSet, Set<Integer> userSet) {
        StringBuilder generatedString = new StringBuilder();
        generatedSet.forEach(i -> generatedString.append(String.format("%2s", i)).append(" "));

        StringBuilder userString = new StringBuilder();
        userSet.forEach(i -> userString.append(String.format("%2s", i)).append(" "));

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%25s", "Drawn numbers: "))
                .append(generatedString.toString())
                .append("\n")
                .append(String.format("%25s", "Entered numbers by User: "))
                .append(userString.toString())
                .append("\n")
                .append(printerMock.printMessage(number));
        return new LottoResult(sb.toString());
    }

    public static Set<Integer> exampleSet() {
        return new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    }
}