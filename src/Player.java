public class Player {
    public String name = "";
    public int dimension = 0;
    public Player(int dimension, String name)
    {
        this.dimension = dimension;
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    public int getDimension()
    {
        return dimension;
    }

}
