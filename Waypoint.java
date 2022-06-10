/**
 * @version April 27 2022
 * @author 23hillhouse
 * turns all parameters used to sort into objects to be used in other code
 */
public class Waypoint {
    private String type, name, state;
    private double toSpringer, toKatahdin;
    private int elevation;

    /**
     * parameterized constructor of the Waypoint class
     * @param t type
     * @param n name
     * @param s state
     * @param ts distance to springer
     * @param tk distance to Katahdin
     * @param e elevation
     */
    public Waypoint(String t, String n, String s, double ts, double tk, int e){
        type = t;
        name = n;
        state = s;
        toSpringer = ts;
        toKatahdin = tk;
        elevation = e;
    }

    /**
     * constructor for Waypoint
     */
    public Waypoint(){
        type = "";
        name = "";
        state = "";
        toSpringer = 0.0;
        toKatahdin = 0.0;
        elevation = 0;
    }

    /**
     * gets "type" when the method is called
     * @return type
     */
    public String getType() {
        return type;
    }
    /**
     * gets "name" when the method is called
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * gets "state" when the method is called
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * gets "toSpringer" when the method is called
     * @return toSpringer
     */
    public double getToSpringer() {
        return toSpringer;
    }

    /**
     * gets "toKatahdin" when the method is called
     * @return toKatahdin
     */
    public double getToKatahdin() {
        return toKatahdin;
    }

    /**
     * gets "elevation" when the method is called
     * @return elevation
     */
    public int getElevation() {
        return elevation;
    }

    /**
     * turns object into a usable String format
     * @return string of object that was called
     */
    public String toString() {
        return "Waypoint{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", toSpringer=" + toSpringer +
                ", toKatahdin=" + toKatahdin +
                ", elevation=" + elevation +
                '}';
    }

}