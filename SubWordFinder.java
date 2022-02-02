import java.util.*;
import java.io.*;

/**
 * @author 23hillhouse
 * @version 02/01/22
 * Finds smaller words that are inside of already existing words and prints them out
 */
public class SubWordFinder implements WordFinder {
    private final ArrayList<ArrayList<String>> dictionary;
    private final String alpha = "abcdefghijklmnopqrstuvwxyz";

    public SubWordFinder()  {
        dictionary = new ArrayList<>();
        for (int i = 0; i < alpha.length(); i++) {
            dictionary.add(new ArrayList<String>());
        }
        populateDictionary();
    }

    /**
     * opens and reads the specified file
     */
    public void populateDictionary()    {
        try{
            Scanner in = new Scanner (new File("words_all_os.txt"));
            while(in.hasNext()) {
                String word = in.nextLine();
                dictionary.get(alpha.indexOf(word.charAt(0))).add(word);
            }
            in.close();
        }
        catch(Exception e)  {
            e.printStackTrace();
        }

    }

    /**
     * student made method for indexOf
     * @param temp
     * @param word
     * @return
     */
    private int indexOf(ArrayList<String> temp, String word)    {
        int low = 0, high = temp.size()-1;
        while(low <= high)  {
            int mid = (low + high)/2;
            if(temp.get(mid).compareTo(word) == 0) {
                return mid;
            }
            else if(temp.get(mid).compareTo(word) < 0)   {
                low = mid + 1;
            }
            else    {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * uses student made indexOf method to check if a word is in the text file words_all_os.txt
     * @param word The item to be searched for in dictionary
     * @return
     */
    public boolean inDictionary(String word)    {
        int index = alpha.indexOf(word.charAt(0));
        ArrayList<String> bucket = dictionary.get(index);
        return indexOf(bucket, word) >= 0;
    }

    /**
     * checks to see if a bucket is in the dictionary and then if a word is in that bucket and checks to see if a subword that is 3 letters or more is in the dictionary. If it is then the two subwords are added together
     * @return
     */
    public ArrayList<SubWord> getSubWords()  {
        ArrayList<SubWord> subWords = new ArrayList<>();
        for(ArrayList<String> bucket : dictionary)  {
            for(String word : bucket)   {
                for(int i = 3; i<word.length()-2; i++)  {
                    String sub1 = word.substring(0, i);
                    String sub2 = word.substring(i);
                    if(inDictionary(sub1) && inDictionary(sub2))    {
                        subWords.add(new SubWord(word, sub1, sub2));
                        System.out.println(word + " = " + sub1 + " + " + sub2);
                    }
                }
            }
        }
        return subWords;
    }

    /**
     * runs app.getSubWords and prints all words if they are true in getSubWords method
     * @param args
     */
    public static void main(String[] args) {
        SubWordFinder app = new SubWordFinder();
        ArrayList<SubWord> temp = app.getSubWords();

        for(SubWord w : temp)   {
            System.out.println(w);
        }

        System.out.println(temp.size());
    }
}
