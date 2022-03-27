import javax.swing.plaf.FontUIResource;
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
    private ArrayList<String> wordList = new ArrayList<String>();
    private boolean win = true;
    private int attempts;
    public void importDictionary()// imports dictionary
    {
        String[] tmp = null;
        try
        {
            FileReader fileReader = new FileReader(".//src//dictionary.txt");
            //FileReader fileReader = new FileReader(".//src//dictionary.txt");
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
    public void start()throws InterruptedException { // main logic of program
        importDictionary();
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello, what is your name");
        name = scan.nextLine();
        Player one = new Player(0, name);
        attempts = one.getAttempts();
        System.out.println("Hello" + " " + name);
        boolean go = true;
        while (go) {
            System.out.println("What are the dimensions you wish to play(must be divisible by 2)");
            dimension = scan.nextInt();
            if (dimension % 2 == 0) {
                go = false;
            } else {
                System.out.println("This number is invalid, please pick again");
            }
        }
        board = new String[dimension][dimension];
        emptyBoard = new String[dimension][dimension];
        wordCount = dimension * dimension / 2;
        for (int i = 0; i < wordCount; i++) {
            int position = (int)(Math.random() * dictionary.size());
            wordList.add(dictionary.get(position));
            dictionary.remove(position);
        }
        int doubling = wordList.size();
        for (int z = 0; z < doubling; z++) {
            wordList.add(wordList.get(z));
        }
        Collections.shuffle(wordList);
        int adding = wordList.size() - 1;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] = wordList.get((adding));
                adding--;
            }
        }
        int temp =0;
        printBoard(board);
        Thread.sleep(4000);
        System.out.println("" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n");
        printBoard(emptyBoard);
        scan.nextLine();
        while (win == true) {
            int check = 0;
            System.out.println("Pick a tile to pick(With a comma and space in between)");
            String firstTile = scan.nextLine();
            int comma = firstTile.indexOf(",");
            int firstNum = Integer.parseInt(firstTile.substring(0, comma));
            int secondNum = Integer.parseInt(firstTile.substring(comma + 2));
            System.out.println("Pick a tile to pick(With a comma and space in between)");
            String secondTile = scan.nextLine();
            int comma1 = secondTile.indexOf(",");
            int thirdNum = Integer.parseInt(secondTile.substring(0, comma1));
            int fourthNum = Integer.parseInt(secondTile.substring(comma1 + 2));
            if(firstNum == thirdNum && secondNum == fourthNum)
            {
                System.out.println("You cannot match a card with itself");
            }
            else if(firstNum >= dimension || secondNum >= dimension || thirdNum >= dimension || fourthNum >= dimension)
            {
                System.out.println("Invalid Index");
            }
            else if(board[firstNum][secondNum] == board[thirdNum][fourthNum]) {
                emptyBoard[firstNum][secondNum] = board[firstNum][secondNum];
                emptyBoard[thirdNum][fourthNum] = board[thirdNum][fourthNum];
                attempts++;
                System.out.println("There is a match");
            }
            else {
                System.out.println("There is not a match");
                Thread.sleep(1000);
                attempts ++;
            }
            System.out.println("This is your board now");
            printBoard(emptyBoard);
            win = isWin(check);
        }
        System.out.println("Congratulations you won it took you " + attempts + " attempts");
    }
    public void printBoard(String [][] boards) //Prints a specific board of choice
    {
        for(int row = 0; row < boards.length; row++)
        {
            for(int col = 0; col < boards[0].length; col++)
            {
                if(col + 1 == boards[0].length)
                {
                    System.out.print(boards[row][col]);
                    System.out.println();
                }
                else{
                    System.out.print(boards[row][col] + " ");
                }
            }
        }
    }
    public boolean isWin(int checks) // checks to see if the win is achieved
    {
        for (int row = 0; row < emptyBoard.length; row++) {
            for (int col = 0; col < emptyBoard[0].length; col++) {
                if (emptyBoard[row][col] != null) {
                    checks++;
                }
            }
        }
        if (checks == (dimension * dimension)) {
            return false;
        }
        else
        {
            return true;
        }
    }
}
