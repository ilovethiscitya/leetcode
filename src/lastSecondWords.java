/**
 * Created by jianzhe on 11/14/18.
 */
public class lastSecondWords {
    public String lastSecond(String sentence) {
        String[] words = sentence.split("\\s+");
        return (words[words.length - 2]);
    }
}
