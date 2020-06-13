package joost.luijben.infrastructure.controllers;

import joost.luijben.application.WordProcessor;
import joost.luijben.domain.Word;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/words")
public class WordController {
    private final WordProcessor wordProcessor;

    public WordController(WordProcessor wordProcessor) {
        this.wordProcessor = wordProcessor;
    }

    @GetMapping
    public Set<Word> getWords(@RequestParam(required = false) Integer wordLength) {
        return wordProcessor.loadWordsFromOutput(wordLength);
    }

    @GetMapping("randomWord")
    public Word getRandomWord(@RequestParam(required = false) Integer wordLength) {
        return wordProcessor.getRandomWordFromOutput(wordLength);
    }
}
