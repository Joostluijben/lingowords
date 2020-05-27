package joost.luijben.infrastructure.controllers;

import joost.luijben.application.WordProcessor;
import joost.luijben.domain.Word;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController("/words")
public class WordController {
    private final WordProcessor wordProcessor;

    public WordController(WordProcessor wordProcessor) {
        this.wordProcessor = wordProcessor;
    }

    @GetMapping
    public Set<Word> getWords() {
        return wordProcessor.getWords();
    }

    @PostMapping
    public void saveWords(Set<Word> words) {
        wordProcessor.saveWords(words);
    }
}
