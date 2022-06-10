import java.util.Comparator;

/**
 * @version April 27 2022
 * @author 23hillhouse
 * Comparator class for waypoints
 */
public class WaypointComparator implements Comparator<Waypoint> {
    private int category;
    private boolean asc;

    /**
     * parameter constructor for a waypoint comparator
     * @param c - category used for comparing
     * @param a - a boolean counting the ascending or descending values
     */
    public WaypointComparator(int c, boolean a){
        category = c;
        asc = a;
    }

    /**
     * parameter constructor for a waypoint comparator
     * @param c - category used for comparing
     */
    public WaypointComparator(int c){
        category = c;
        asc= true;
    }

    /**
     * constructor for waypoint comparator
     */
    public WaypointComparator(){
        category = 4;
        asc = true;
    }

    /**
     * returns waypoint one minus waypoint two
     * @param one - waypoint being compared 1
     * @param two - waypoint being compared 2
     * @return - outcome of waypoint one minus waypoint two
     */
    public int compare(Waypoint one, Waypoint two){
        int diff = 0;
        if(category ==1){
            diff = one.getType().compareTo(two.getType());
        }
        else if(category == 2){
            diff = one.getName().compareTo(two.getName());
        }
        else if(category == 3){
            diff = one.getState().compareTo(two.getState());
        }
        else if(category == 4){
            Double d1= one.getToSpringer();
            Double d2 = two.getToSpringer();
            diff = d1.compareTo(d2);
        }
        else if(category == 5){
            Double d1= one.getToKatahdin();
            Double d2 = two.getToKatahdin();
            diff = d1.compareTo(d2);
        }
        else if(category == 6){
            diff = one.getElevation()- two.getElevation();
        }

        return(asc)? diff: -diff;
    }
}