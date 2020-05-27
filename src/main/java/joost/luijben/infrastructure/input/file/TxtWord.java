package joost.luijben.infrastructure.input.file;

import joost.luijben.domain.Word;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TxtWord implements WordDeserializer{

    @Override
    public Set<Word> getWords() {
        File file = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("basiswoorden-gekeurd.txt")).getFile());
        try {
            return Files.lines(file.toPath()).map(Word::new).collect(Collectors.toSet());
        } catch (IOException e) {
            //TODO foutafhandeling
            e.printStackTrace();
        }
        return Set.of();
    }
}
