package joost.luijben.domain;

import joost.luijben.application.WordProcessor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.mock;

@ExtendWith(SpringExtension.class)
public class WordProcessorTest {
    @Test
    public void testLoadWordsFromInput() {
        WordInput wordInput = mock(WordInput.class);
        WordOutput wordOutput = mock(WordOutput.class);
        WordProcessor wordProcessor = new WordProcessor(wordOutput, wordInput);
        Assert.assertNotNull(wordProcessor.loadWordsFromInput(null));
    }

    @Test
    public void testLoadWordsFromOutput() {
        WordInput wordInput = mock(WordInput.class);
        WordOutput wordOutput = mock(WordOutput.class);
        WordProcessor wordProcessor = new WordProcessor(wordOutput, wordInput);
        Assert.assertNotNull(wordProcessor.loadWordsFromOutput(null));
    }
}
