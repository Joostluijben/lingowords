package joost.luijben.domain;

import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class WordSet {
    private Set<Word> words;

    public WordSet(Set<Word> words) {
        this.words = words;
    }

    public Set<Word> getWords(Integer wordLength) {
        if (wordLength != null) {
            return words.stream().filter(word -> word.getValue().length() == wordLength).collect(Collectors.toSet());
        }
        return words;
    }

    public Word getRandomWord(Integer wordLength) {
        if (wordLength != null) {
            return getWords(wordLength).stream().skip(new Random().nextInt(getWords(wordLength).size())).findFirst().orElse(null);
        }
        return words.stream().skip(new Random().nextInt(words.size())).findFirst().orElse(null);
    }

}
