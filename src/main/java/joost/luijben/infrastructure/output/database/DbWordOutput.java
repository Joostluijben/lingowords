package joost.luijben.infrastructure.output.database;

import joost.luijben.domain.Word;
import joost.luijben.domain.WordOutput;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DbWordOutput implements WordOutput {
    private final ModelMapper modelMapper;
    private final WordRepository wordRepository;

    public DbWordOutput(ModelMapper modelMapper, WordRepository wordRepository) {
        this.modelMapper = modelMapper;
        this.wordRepository = wordRepository;
    }

    @Override
    public void save(Set<Word> words) {
        Set<WordEntity> wordEntities = words.stream().map(word -> modelMapper.map(word, WordEntity.class)).collect(Collectors.toSet());
        wordRepository.saveAll(wordEntities);
    }
}
