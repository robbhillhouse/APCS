import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.io.File;
import java.util.Scanner;

public class TrailDatabase  {
    private static ArrayList<Waypoint> database;
    private boolean asc;
    private int searchTerm;
    private static ArrayList<Integer> temp;

    public TrailDatabase() {
        database = new ArrayList<>();
        populateDatabase();
    }

    /**
     * imports all data out of the apptrailDB.txt file
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
            if(term.equals("TY"))
                searchTerm = 1;
            else if(term.equals("NA"))
                searchTerm = 2;
            else if(term.equals("ST"))
                searchTerm = 3;
            else if(term.equals("DS"))
                searchTerm = 4;
            else if(term.equals("DK"))
                searchTerm = 5;
            else if(term.equals("EL"))
                searchTerm = 6;
            else
                searchTerm = 0;
        if(searchTerm != 0) {
            System.out.print("Enter 'A' to sort in ascending order or 'D' to sort in descending order: ");
            term = in.nextLine();
            asc = (term.equals("A")) ? true : false;
        }
    }
    public void printDatabase()   {
        for(Waypoint w : database)
            System.out.println(w);
    }
    public void populateDatabase()  {
        try {
            Scanner in = new Scanner(new File("apptrailDB (1).txt"));
            while(in.hasNext()) {
                String [] line = in.nextLine().split("\t");
                database.add(new Waypoint(line[0], line[1], line[2], Double.parseDouble(line[5]), Double.parseDouble(line[6]), Integer.parseInt(line[7])));
            }
            in.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static void merge(ArrayList<Integer> a, int from, int middle, int to)   {
        int i = from, j = middle + 1, k = from;
        while(i <= middle && j <= to)   {
            if(a.get(i).compareTo(a.get(j)) < 0)    {
                temp.set(k, a.get(i));
                i++;
            }
            else    {
                temp.set(k, a.get(j));
                j++;
            }
            k++;
        }
        while(i <= middle)  {
            temp.set(k, a.get(i));
            i++;
            k++;
        }
        while(j <= to)   {
            temp.set(k, a.get(j));
            j++;
            k++;
        }
        for(k = from; k <= to; k++)  {
            a.set(k, temp.get(k));
        }
    }

    private void selectionSort()    {
        WaypointComparator wc = new WaypointComparator(searchTerm, asc);
        Waypoint toSwap;
        int index;
        for(int out = 0; out < database.size(); out ++) {
            index = out;
            toSwap = database.get(out);
            for(int in = out + 1; in < database.size(); in++)   {
                Waypoint temp = database.get(in);
                if(wc.compare(temp, toSwap) < 0)    {
                    toSwap = new Waypoint(temp);
                    index = in;
                }
            }
            database.set(index, database.get(out));
            database.set(out, toSwap);
        }
    }
    public static void main(String[] args) {
        TrailDatabase db = new TrailDatabase();
        System.out.println("*** Welcome to the Appalachian Trail Database ***");
        db.getSearchTerm();
        db.selectionSort();
    }
}
