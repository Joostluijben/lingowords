package joost.luijben.application;

import joost.luijben.domain.Word;
import joost.luijben.domain.WordInput;
import joost.luijben.domain.WordOutput;
import joost.luijben.domain.WordSet;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class WordProcessor {
    private final WordOutput wordOutput;
    private final WordInput wordInput;

    public WordProcessor(WordOutput wordOutput, WordInput wordInput) {
        this.wordOutput = wordOutput;
        this.wordInput = wordInput;
    }

    public Set<Word> loadWordsFromInput(Integer wordLength) {
        if (wordLength != null) {
            return wordInput.load(wordLength).stream().filter(
                    word -> word.getValue() != null && wordLength.equals(word.getValue().length())).
                    collect(Collectors.toSet());
        }
        return wordInput.load(wordLength).stream().filter(word -> word.getValue() != null).collect(Collectors.toSet());
    }

    public void saveWordsToOutput(Set<Word> words) {
        wordOutput.save(new WordSet(words));
    }

    public Set<Word> loadWordsFromOutput(Integer wordLength) {
        return wordOutput.getWords(wordLength);
    }

    public Word getRandomWordFromOutput(Integer wordLength) {
        return wordOutput.getRandomWord(wordLength);
    }
}
