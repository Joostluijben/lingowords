package joost.luijben.infrastructure.output.memory;

import joost.luijben.domain.Word;
import joost.luijben.domain.WordOutput;
import joost.luijben.domain.WordSet;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MemoryWordOutput implements WordOutput {
    private WordSet words;

    @Override
    public void save(WordSet words) {
        this.words = words;
    }

    public Set<Word> getWords(Integer wordLength) {
        return words.getWords(wordLength);
    }

    public Word getRandomWord(Integer wordLength) {
        return words.getRandomWord(wordLength);
    }
}
