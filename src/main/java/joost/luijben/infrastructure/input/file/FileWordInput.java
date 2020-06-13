package joost.luijben.infrastructure.input.file;

import joost.luijben.domain.Word;
import joost.luijben.domain.WordInput;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FileWordInput implements WordInput {
    private final WordDeserializer wordDeserializer;

    public FileWordInput(WordDeserializer wordDeserializer) {
        this.wordDeserializer = wordDeserializer;
    }

    @Override
    public Set<Word> load(Integer wordLength) {
        return wordDeserializer.getWords();
    }
}
