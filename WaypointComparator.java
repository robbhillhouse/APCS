import java.util.Comparator;

public class WaypointComparator implements Comparator<Waypoint> {
    private int category;
    private boolean asc;

    public WaypointComparator(int c, boolean a) {
        category = c;
        asc = a;
    }

    public WaypointComparator(int c)    {
        category = c;
        asc = true;
    }

    public WaypointComparator() {
        category = 4;
        asc = true;
    }

    public int compare(Waypoint one, Waypoint two)  {
        int diff = 0;
        if(category == 1)  // TYPE
            diff = one.getType().compareTo(two.getType());
        else if(category == 2)  // NAME
            diff = one.getName().compareTo(two.getName());
        else if(category == 3)  // STATE
            diff = one.getState().compareTo(two.getState());
        else if(category == 4) { // DTK
            Double d1 = one.getToKatahdin();
            Double d2 = two.getToKatahdin();
            diff = d1.compareTo(d2);
        }
        else if(category == 5) {  // DTS
            Double d1 = one.getToSpringer();
            Double d2 = two.getToSpringer();
            diff = d1.compareTo(d2);
        }
        else if(category == 6) // DTS
            diff = one.getElevation() - two.getElevation();

        return (asc) ? diff : -diff;
    }
}
