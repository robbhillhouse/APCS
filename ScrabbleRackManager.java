import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author 23hillhouse
 * @version 3/25/22
 * Generate a random Scrabble rack of seven letters, picked to be as unique as possible
 * and find all words that can be made from the letters and which words are bingos
 */
public class ScrabbleRackManager {
    private ArrayList<ArrayList<String>> dictionary;
    private String alpha;
    private ArrayList<String> scrabbleRack;

    /**
     * class constructor
     */

    public ScrabbleRackManager() {
        alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        dictionary = new ArrayList<>();
        for (int i = 0; i < 26; i++)
            dictionary.add(new ArrayList<>());
        buildDictionary();
        buildTileRack();
    }

    /**
     * opens the specified file and gets words from it
     */

    public void buildDictionary()   {
        try {
            Scanner filein = new Scanner(new File("2019_collins_scrabble.txt"));
            while(filein.hasNext()) {
                String temp = filein.nextLine();
                dictionary.get(alpha.indexOf(temp.charAt(0))).add(temp);
            }
            filein.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

        /**
         * builds arraylist of random letters
         */

    public void buildTileRack() {
        scrabbleRack = new ArrayList<>();
        int[] frequencies = {9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1};
        ArrayList<String> allTiles = new ArrayList<>();
        int index = 0;
        for (int count : frequencies) {
            for (int i = 0; i < count; i++) {
                allTiles.add(alpha.substring(index, index + 1));
            }
            index++;
        }
        Collections.shuffle(allTiles);
        for(int i = 0; i < 7; i++)
            scrabbleRack.add(allTiles.remove((int)(Math.random()*allTiles.size())));
    }

    /** displays the contents of the player's tile rack */

    public void printRack() {
        System.out.println("Letters in the rack: " + scrabbleRack);
    }

    /** print all the playable words based on the letters in the tile rack */

    public void printMatches()  {
        ArrayList<String> plays = getPlaylist();
        boolean bingo = false;
        System.out.println("You can play the following words from the letters in your rack");
        if(plays.isEmpty())
            System.out.println("Sorry, NO words can be played from those tiles.");
        for(int i = 0; i<plays.size(); i++) {
            String word = plays.get(i);
            if(word.length() == 7)  {
                word += "*";
                bingo = true;
            }
            System.out.printf("%-10s", word);
            if((i+1) % 10 == 0)
                System.out.println();
        }
        if(bingo)
            System.out.println("\n* Denotes BINGO");
    }

    /**
     * checks if a word is playable and returns true if it is and false if not
     * @param word word being checked to see if it is playable
     * @return true or false depending on if a word is playable or not
     */

    private boolean isPlayable(String word)  {
        ArrayList<String> copy = new ArrayList<>(scrabbleRack);
        for(int i = 0; i < word.length(); i++)
            if(!copy.remove(word.substring(i, i+1)))    {
                if(!copy.remove(" "))
                    return false;
            }
        return true;
    }

    /** builds and returns an ArrayList of String objects that are values pulled
     from
     * the dictionary/database based on the available letters in the user's tile
     * rack
     * @return an array list of all the playable words
     * */

    public ArrayList<String> getPlaylist()  {
        ArrayList<String> plays = new ArrayList<>();
        for(ArrayList<String> bucket : dictionary)  {
            if(scrabbleRack.contains(bucket.get(0).substring(0,1)) || scrabbleRack.contains(" ")) {
                for(String word : bucket)   {
                    if(isPlayable(word))
                        plays.add(word);
                }
            }
        }
        return plays;
    }

    /** main method for the class; use only 3 command lines in main */

    public static void main(String[] args)  {
        ScrabbleRackManager app = new ScrabbleRackManager();
        app.printRack();
        app.printMatches();

    }
}
