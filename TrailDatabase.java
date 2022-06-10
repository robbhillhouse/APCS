import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

/**
 * @version April 27 2022
 * @author 23hillhouse
 * first imports databse and then finds certain terms in a chosen order
 * uses mergesort to sort
 */
public class TrailDatabase {
    private static ArrayList<Waypoint> database;
    private boolean asc;
    private int searchTerm;
    private static ArrayList<Integer> temp;

    /**
     * initializes arrayList and adds items to it from apptrailDB.txt file
     */
    public TrailDatabase() {
        database = new ArrayList<>();
        populateDatabase();
    }

    /**
     * imports text from apptrailDB.txt file
     */
    public void getSearchTerm() {
        System.out.println("+ Menu of search terms to use for sorting waypoints +\n" +
                "\tNA: by name\n" +
                "\tDS: by distance to Springer\n" +
                "\tDK: by distance to Katahdin\n" +
                "\tEL: by elevation");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your prefered sort by term or 'Q' to quit: ");
        String term = in.nextLine();
        if (term.equals("TY"))
            searchTerm = 1;
        else if (term.equals("NA"))
            searchTerm = 2;
        else if (term.equals("ST"))
            searchTerm = 3;
        else if (term.equals("DS"))
            searchTerm = 4;
        else if (term.equals("DK"))
            searchTerm = 5;
        else if (term.equals("EL"))
            searchTerm = 6;
        else
            searchTerm = 0;
        if (searchTerm != 0) {
            System.out.print("Enter 'A' to sort in ascending order or 'D' to sort in descending order: ");
            term = in.nextLine();
            asc = (term.equals("A")) ? true : false;
        }
    }

    /**
     * prints the database arraylist using a for each loop
     */
    public void printDatabase() {
        for (Waypoint w : database)
            System.out.println(w);
    }

    /**
     * creates waypoint from the items from apptrailDB.txt file using a scanner
     * puts the waypoint in arrayList.
     */
    public void populateDatabase() {
        try {
            Scanner in = new Scanner(new File("apptrailDB (1).txt"));
            while (in.hasNext()) {
                String[] line = in.nextLine().split("\t");
                database.add(new Waypoint(line[0], line[1], line[2], Double.parseDouble(line[5]), Double.parseDouble(line[6]), Integer.parseInt(line[7])));
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * implements the MergeSort and WaypointComparator classes to sort the database
     */
    public void sortDB() {
        WaypointComparator wc = new WaypointComparator(searchTerm, asc);
        MergeSort m1 = new MergeSort(database, wc);
        m1.mergeSort(database);
    }

    /**
     * prints the output based on what user chooses.
     *
     * @param args
     */
    public static void main(String[] args) {
        TrailDatabase t1 = new TrailDatabase();
        t1.sortDB();
        t1.printDatabase();
    }
}
