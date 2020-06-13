package joost.luijben.domain;

import java.util.regex.Pattern;

public class Word {
    private String value;

    public Word(String value) {
        int wordLength = value.length();
        if ((wordLength == 5 || wordLength == 6 || wordLength == 7) &&
                Character.isLowerCase(value.charAt(0)) &&
                !Pattern.matches("\\p{Punct}", value)) {
            this.value = value;
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + value + '\'' +
                '}';
    }
}
