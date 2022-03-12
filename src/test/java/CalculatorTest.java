
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CalculatorTest {

    Calculator sut;

    @BeforeEach
    public void init() {
        System.out.println("test started");
        sut = new Calculator();
    }

    @BeforeAll
    public static void startedAll() {
        System.out.println("tests started");
    }

    @AfterEach
    public void finished() {
        System.out.println("test completed");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("tests completed");
    }


    @Test
    public void testTrue() {
        //arrange
        double value1 = 0.33;
        float value2 = 0.33F;

        //act
        boolean result = sut.compareNumbers(value1, value2);

        //assert
        assertTrue(result);

    }

    @Test
    public void testRoundNumbers() {
        // given:
        double value = 134.45, expected = 134.0;

        // when:
        double result = sut.roundNumbers(value);

        // then:
        assertEquals(expected, result);

    }

    @ParameterizedTest
    @MethodSource("value")

    public void testCut(double value1, long expected) {

        long result = sut.cut(value1);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> value() {
        return Stream.of(
                Arguments.of(134.297, 134),
                Arguments.of(1234.888, 1234),
                Arguments.of(34.50, 34)
        );

    }


    @Test
    public void testConvertTimes() {
        // given:
        int days = 2, hours = 4, minutes = 53, expected = 190380;

        // when:
        double result = sut.convertToSeconds(days, hours, minutes);

        // then:
        assertEquals(expected, result);

    }

    @ParameterizedTest
    @MethodSource("source")

    public void testConvertRubToUsd(double rub, double rate, double expected) {

        double result = sut.convertRubToUsd(rub, rate);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> source() {
        return Stream.of(Arguments.of(134290.00, 134.29, 1000.00), Arguments.of(662824.00, 114.28, 5800.00));

    }

}
