package joost.luijben.infrastructure.input.file;

import joost.luijben.domain.Word;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TxtWord implements WordDeserializer{

    @Override
    public Set<Word> getWords() {
        try {
            InputStream inputStream = new ClassPathResource("basiswoorden-gekeurd.txt").getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            return bufferedReader.lines().filter(Word::isWordValid).map(Word::new).collect(Collectors.toSet());
        } catch (IOException e) {
            return Set.of();
        }
    }
}
