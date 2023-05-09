import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class uniqueWords {

    public static int uniqueKeys(Map<String, Integer> uniqueWords) {
        //keys of map are always unique
        return uniqueWords.size();
    }

    public static void main(String[] args) throws IOException {

        Map<String, Integer> uniqueWords = new HashMap<>();
        // Create a reader to read the text file
        BufferedReader br = new BufferedReader(new FileReader(args[0]));

        // Reader loop through text
        String line;
        while ((line = br.readLine()) != null) {
            String[] lineArray = line.split(" ");

            for (String word : lineArray) {
                word = word.replace(",", "");
                word = word.replaceAll("\\p{Punct}", "");
                if (word.trim().toLowerCase().length() != 0) {

                    if (!Stopwords.STOPWORDS_SET.contains(word)) {
                        //System.out.println("##" + word);

                        //if word is not in map, put the word + count: 1
                        if (!uniqueWords.containsKey(word)) {
                            uniqueWords.put(word, 1);
                        } else {
                            //if word is inside, get the value + 1
                            int number = uniqueWords.get(word) + 1;
                            uniqueWords.put(word, number);
                        }

                    }
                }

            }
        }
        br.close();
        // find whether a word is in the set

        // Remove stop words

        // Print out unique words and frequency of words
        System.out.println(uniqueWords);
        System.out.println("Unique Words: " + uniqueKeys(uniqueWords));
    }

}