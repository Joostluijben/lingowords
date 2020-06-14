package joost.luijben.domain;

import org.junit.Assert;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

@ExtendWith(SpringExtension.class)
public class WordSetTest {
    private static final Word fifeLetterWord = new Word("flora");
    private static final Set<Word> words = new HashSet<>(Set.of(new Word("flor"), fifeLetterWord, new Word("floraa"), new Word("floraaa"), new Word("floraaaa")));

    @ParameterizedTest
    @MethodSource("provideLengthAndResultArray")
    public void testWordLength(Integer wordLength, Set<Word> resultArray) {
        WordSet wordSet = new WordSet(words);
        Assert.assertArrayEquals(wordSet.getWords(wordLength).toArray(), resultArray.toArray());
    }

    private static Stream<Arguments> provideLengthAndResultArray() {
        return Stream.of(
                Arguments.of(null, new HashSet<>(Set.of(
                        new Word("flora"),
                        new Word("floraa"),
                        new Word("floraaa")
                ))),
                Arguments.of(5, new HashSet<>(Set.of(new Word("flora")))),
                Arguments.of(6, new HashSet<>(Set.of(new Word("floraa")))),
                Arguments.of(7, new HashSet<>(Set.of(new Word("floraaa")))));
    }
}
