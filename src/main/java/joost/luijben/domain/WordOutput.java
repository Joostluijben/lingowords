package joost.luijben.domain;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public interface WordOutput {
    void save(WordSet words);
    Set<Word> getWords(Integer wordLength);
    Word getRandomWord(Integer wordLength);
}
