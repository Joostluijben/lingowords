package joost.luijben.infrastructure.input.file;

import joost.luijben.domain.Word;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface WordDeserializer {
    Set<Word> getWords();
}
