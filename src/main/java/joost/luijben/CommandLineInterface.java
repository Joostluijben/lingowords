package joost.luijben;

import joost.luijben.application.WordProcessor;
import joost.luijben.domain.Word;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class CommandLineInterface
        implements CommandLineRunner {
    private final WordProcessor wordProcessor;

    public CommandLineInterface(WordProcessor wordProcessor) {
        this.wordProcessor = wordProcessor;
    }

    private static Logger LOG = LoggerFactory
            .getLogger(CommandLineInterface.class);

    public static void main(String[] args) {
        SpringApplication.run(CommandLineInterface.class, args);
    }

    @Override
    public void run(String... args) {
//        Set<Word> words = new HashSet<>();
//        words.add(new Word("hoi"));
//        wordProcessor.saveWords(words);
        System.out.println(wordProcessor.getWords());
    }
}
