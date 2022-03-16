public class Runner {
    public static void main(String[] args)
    {
        Logic game = new Logic();
        game.importDictionary();
        try{
            game.start();
        } catch(Exception e){}
    }

}
