package joost.luijben.domain;

import org.junit.Assert;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.Stream;

import static junit.framework.TestCase.assertFalse;

@ExtendWith(SpringExtension.class)
class WordTest {
    @ParameterizedTest
    @MethodSource("provideValidWords")
    void isWordValid() {
        String inputWord = "preek";
        boolean result = Word.isWordValid(inputWord);
        Assert.assertTrue(result);
    }

    private static Stream<Arguments> provideValidWords() {
        return Stream.of(
                Arguments.of(new Word("flora")),
                Arguments.of(new Word("floret")),
                Arguments.of(new Word("floraal"))
        );
    }


    @ParameterizedTest
    @MethodSource("provideInvalidWords")
    void isWordInValid(Word word) {
        boolean result = Word.isWordValid(word.getValue());
        assertFalse(result);
    }

    private static Stream<Arguments> provideInvalidWords() {
        return Stream.of(
                Arguments.of(new Word("")),
                Arguments.of(new Word("pree!")),
                Arguments.of(new Word("pree?")),
                Arguments.of(new Word("preek.")),
                Arguments.of(new Word("preek&")),
                Arguments.of(new Word("preek@")),
                Arguments.of(new Word("pree,")),
                Arguments.of(new Word("pree")),
                Arguments.of(new Word("Preek")),
                Arguments.of(new Word("pree'")),
                Arguments.of(new Word(null)));
    }
}
