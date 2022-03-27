
public class Player {
    public String name = "";
    public int attempts = 0;
    public Player(int attempts, String name) // player constructor
    {
        this.attempts = attempts;
        this.name = name;
    }
    public String getName() //getter method for name
    {
        return name;
    }
    public int getAttempts() // getter method for attempts
    {
        return attempts;
    }

}