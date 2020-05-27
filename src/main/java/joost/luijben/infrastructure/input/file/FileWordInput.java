package joost.luijben.infrastructure.input.file;

import joost.luijben.domain.Word;
import joost.luijben.domain.WordInput;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FileWordInput implements WordInput {
    private final WordDeserializer wordDeserializer;

    public FileWordInput(WordDeserializer wordDeserializer) {
        this.wordDeserializer = wordDeserializer;
    }

    @Override
    public Set<Word> load() {
        return wordDeserializer.getWords();
    }
}
