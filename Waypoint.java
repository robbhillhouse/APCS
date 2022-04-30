public class Waypoint implements Comparable<Waypoint> {
    private String type, name, state;
    private double toSpringer, toKatahdin;
    private int elevation;

    public Waypoint(String t, String n, String s, double ts, double tk, int e) {
        type = t;
        name = n;
        state = s;
        toSpringer = ts;
        toKatahdin = tk;
        elevation = e;
    }

    public Waypoint(Waypoint temp) {
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public double getToSpringer() {
        return toSpringer;
    }

    public double getToKatahdin() {
        return toKatahdin;
    }

    public int getElevation() {
        return elevation;
    }

    @Override
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
    public int compareTo(Waypoint other)  {
        Double d1 = this.toKatahdin;
        Double d2 = other.toKatahdin;
        return d1.compareTo(d2);
    }
}
