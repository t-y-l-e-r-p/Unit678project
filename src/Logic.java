import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
public class Logic {
    private int dimension = 0;
    private String name = "";
    private String[][] board;
    private String[][] emptyBoard;
    private ArrayList<String> dictionary;
    private int wordCount = 0;
    private ArrayList<String> wordList;
    private void importDictionary()
    {
        String[] tmp = null;
        try
        {
            FileReader fileReader = new FileReader("src\\dictionary.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            ArrayList<String> lines = new ArrayList<String>();
            String line = null;

            while ((line = bufferedReader.readLine()) != null)
            {
                lines.add(line);
            }

            bufferedReader.close();
            tmp = lines.toArray(new String[lines.size()]);
            System.out.println("\nFile imported successfully!");
        }
        catch (IOException e)
        {
            System.out.println("Error importing file; unable to access "+ e.getMessage());
        }

        dictionary = new ArrayList<String>(Arrays.asList(tmp));
    }
    public void start()
    {
        importDictionary();
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello, what is your name");
        name = scan.nextLine();
        boolean go = true;
        while(go)
        {
            System.out.println("What are the dimensions you wish to play(must be divisble by 2)");
            dimension = scan.nextInt();
            if(dimension % 2 == 0)
            {
                go = false;
            }
            else
            {
                System.out.println("This number is invalid, please pick again");
            }
        }
        board = new String[dimension][dimension];
        emptyBoard = new String[dimension][dimension];
        wordCount = dimension * dimension/2;
        for(int i = 0; i < wordCount; i ++)
        {
            wordList.set(i,dictionary.get((int)(Math.random() * dictionary.size())));
        }
        int doubling = wordList.size();
        for(int z = 0; z < doubling; z++)
        {
            wordList.add(wordList.get(z));
        }
        Collections.shuffle(wordList);
        int adding = wordList.size()-1;
        for(int row = 0; row < board.length; row++)
        {
            for(int col = 0; col < board[0].length; col++)
            {
                board[row][col] = wordList.get((adding));
                adding --;
            }
        }
        for(String[] row : board)
        {
            for(String element : row)
            {
                System.out.println(element);
            }
        }
         



    }


}
