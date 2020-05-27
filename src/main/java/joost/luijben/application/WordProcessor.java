package joost.luijben.application;

import joost.luijben.domain.Word;
import joost.luijben.domain.WordInput;
import joost.luijben.domain.WordOutput;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class WordProcessor {
    private final WordOutput wordOutput;
    private final WordInput wordInput;

    public WordProcessor(WordOutput wordOutput, WordInput wordInput) {
        this.wordOutput = wordOutput;
        this.wordInput = wordInput;
    }

    public Set<Word> getWords() {
        return wordInput.load();
    }

    public void saveWords(Set<Word> words) {
        wordOutput.save(words);
    }
}
