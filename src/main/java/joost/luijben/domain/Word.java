package joost.luijben.domain;

import java.util.regex.Pattern;

public class Word {
    private String word;

    public Word(String word) {
        if (!Pattern.matches("\\p{Punct}", word) && Character.isLowerCase(word.charAt(0))) {
            this.word = word;
        }
    }

//    public Optional<String> getWord() {
//        if (!Pattern.matches("\\p{Punct}", word) && Character.isLowerCase(word.charAt(0))) {
//            return Optional.of(word);
//        }
//        return Optional.empty();
//    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                '}';
    }
}
