package joost.luijben.domain;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public interface WordOutput {
    public void save(Set<Word> words);
}
