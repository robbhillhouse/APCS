public abstract class Coin {
    public abstract double getValue();
    public abstract String getName();

    /**
     * Handles penny/pennies otherwise appends s to the end of the name of the coin
     * @return a String representation of the coin name
     */
    public String getPluralName()   {
        if(getName().equals("penny"))
            return "pennies";
        else
            return getName() + "s";
    }
}
