package joost.luijben.domain;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public interface WordInput {
    Set<Word> load(Integer wordLength);
}
