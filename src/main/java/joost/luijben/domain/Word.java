package joost.luijben.domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class Word {
    private final String value;

    public Word(String value) {
        this.value = value;
    }

    public static boolean isWordValid(String word) {
        if (!isNullOrEmpty(word)) {
            int wordLength = word.length();
            if (
                    (wordLength == 5 || wordLength == 6 || wordLength == 7) &&
                            Character.isLowerCase(word.charAt(0))
            ) {
                boolean hasSpecialCharacters = false;
                for (int i = 0; i < wordLength; i++) {
                    char letter = word.charAt(i);
                    if (!(Pattern.matches("\\p{L}", String.valueOf(letter)))) {
                        hasSpecialCharacters = true;
                    }
                }
                return !hasSpecialCharacters;
            }
        }
        return false;
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public String getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(value, word.value);
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + value + '\'' +
                '}';
    }
}
