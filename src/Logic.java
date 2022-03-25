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
    private int check = 0;
    private int attempts = 0;
    public void importDictionary()
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
    public void start()throws InterruptedException {
        importDictionary();
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello, what is your name");
        name = scan.nextLine();
        System.out.println("Hello" + " " + name);
        boolean go = true;
        while (go) {
            System.out.println("What are the dimensions you wish to play(must be divisble by 2)");
            dimension = scan.nextInt();
            if (dimension % 2 == 0) {
                go = false;
            } else {
                System.out.println("This number is invalid, please pick again");
            }
        }
        System.out.println("dimension");
        board = new String[dimension][dimension];
        emptyBoard = new String[dimension][dimension];
        wordCount = dimension * dimension / 2;
        System.out.println(dictionary.get(6));
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
        for(int row = 0; row < board.length; row++)
        {
            for(int col = 0; col < board[0].length; col++)
            {
                System.out.println(board[row][col]);
            }
        }
       /* Thread.sleep(2500);
        System.out.print("\033[H\033[2J");
        System.out.flush();

        for (String[] row : emptyBoard) {
            for (String element : row) {
                System.out.println(element);
            }
        }
        while (win) {
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
            if (board[firstNum][secondNum] == board[thirdNum][fourthNum]) {
                emptyBoard[firstNum][secondNum] = board[firstNum][secondNum];
                emptyBoard[thirdNum][fourthNum] = board[thirdNum][fourthNum];
                attempts++;
            } else {
                System.out.println("There is not a match");
                Thread.sleep(1000);
                attempts ++;
            }
            System.out.println("This is your board now");
            for (String[] row : emptyBoard) {
                for (String element : row) {
                    System.out.println(element);
                }
            }
            for (int row = 0; row < emptyBoard.length; row++) {
                for (int col = 0; col < emptyBoard[0].length; col++) {
                    if (emptyBoard[row][col] != null) {
                        check++;
                    }
                    if (check == (dimension * dimension)) {
                        win = false;
                    }
                }
            }
        }
        System.out.println("Congraulations you won it took you " + attempts + " attempts"); */
    }
}
