import java.util.*;
import java.io.*;

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

    /*public ArrayList<String> findShortestWord() {
        ArrayList<String> shorts = new ArrayList<>();
        for(ArrayList<String> bucket : dictionary)  {
            for(String word : bucket)   {
                if(word.length() == 3)
                    shorts.add(word);
            }
        }
        return shorts;
    }*/
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
    private int indexOf(ArrayList<String> temp, String word)    {
        int low = 0, high = temp.size()-1;
        while(low <= high)  {
            int mid = (low + high)/2;
            if(temp.get(mid).compareTo(word) == 0) {
                return mid;
            }
            else if(temp.get(mid).compareTo(word) > 0)   {
                low = mid + 1;
            }
            else    {
                high = mid - 1;
            }
        }
        return -1;
    }

    public boolean inDictionary(String word)    {
        int index = alpha.indexOf(word.charAt(0));
        ArrayList<String> bucket = dictionary.get(index);
        return indexOf(bucket, word) >= 0;
    }

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
    /*public void printDictionary()   {
        for(ArrayList<String> bucket : dictionary)
            System.out.println(bucket);
        int MAXLEN = dictionary.get(0).size();
        int MAXINDEX = 0;
        for(int i = 1; i<dictionary.size(); i++)    {
            if(dictionary.get(i).size() > MAXLEN)   {
                MAXLEN = dictionary.get(i).size();
                MAXINDEX = i;
            }
        }
        System.out.println("the longest sublist is at Index " + MAXINDEX + " starting with " + "the letter " + alpha.charAt(MAXINDEX));
    }*/
    public static void main(String[] args) {
        SubWordFinder app = new SubWordFinder();
        //app.populateDictionary();
        app.getSubWords();
    }
}
