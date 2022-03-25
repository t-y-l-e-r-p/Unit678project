public class Player {
    public String name = "";
    public int attempts = 0;
    public Player(int attempts, String name)
    {
        this.attempts = attempts;
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    public int getAttempts()
    {
        return attempts;
    }

}
