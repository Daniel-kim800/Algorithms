import java.util.Scanner;
import java.io.*;

public class WordSearch
{

    //Instance Variables
    private char[][] WSearchchar;
    private String[] WSearchstring;
    private int row;
    private int col;
    private int words;


    //Constructor
    public WordSearch()
    {

    }

    //x change
    public int add1(int a, int ax)
    {
        a += ax;
        if(a < 0) a = row - 1;
        if(a >= row) a = 0;
        return a;
    }

    //y change
    public int add2(int b, int bx)
    {
        b += bx;
        if(b < 0) b = col - 1;
        if(b >= col) b = 0;
        return b;
    }

    //Function checking directions
    public boolean testing(int a, int b, int d,String word, int ax, int bx)
    {
        if(d == word.length()) return true;
        if(WSearchchar[a][b] == word.charAt(d))
        {
            return testing(add1(a, ax), add2(b, bx), d+1, word, ax, bx);
        }
        return false;
    }

//Uses the matrix of words to check if in the jumbled words.
    public void Findword()
    {
        for(int x = 0; x < words; x++)
        {
            String word = WSearchstring[x];
            boolean found = false;
            for(int y = 0; y < row; y++)
            {
                if(found == true)
                {
                    break;
                }
                for(int z = 0; z < col; z++)
                {
                    if(WSearchchar[y][z] == word.charAt(0))
                    {
                        if(testing(y, z, 0, word, 1, 0) == true)
                        {
                            System.out.println(y +" "+ z);
                            found = true;
                        }
                        else if(testing(y, z, 0, word, -1, 0) == true)
                        {
                            System.out.println(y +" "+ z);
                            found = true;
                        }
                        else if(testing(y, z, 0, word, 0, 1) == true)
                        {
                            System.out.println(y +" "+ z);
                            found = true;
                        }
                        else if(testing(y, z, 0, word, 0, -1) == true)
                        {
                            System.out.println(y +" "+ z);
                            found = true;
                        }
                        else if(testing(y, z, 0, word, 1, 1) == true)
                        {
                            System.out.println(y +" "+ z);
                            found = true;
                        }
                        else if(testing(y, z, 0, word, -1, -1) == true)
                        {
                            System.out.println(y +" "+ z);
                            found = true;
                        }
                        else if(testing(y, z, 0, word, -1, 1) == true)
                        {
                            System.out.println(y +" "+ z);
                            found = true;
                        }
                        else if(testing(y, z, 0, word, 1, -1) == true)
                        {
                            System.out.println(y +" "+ z);
                            found = true;
                        }
                    }
                }
            }

            if(found == false)
            {
                System.out.println("Word not found");
            }

        }
    }

    //Function that reads in the WordSearch File
    public void readWord()
    {
        String inputLine;

        Scanner fileInput;
        File inputfile = new File("Test.txt");

        try
        {
            fileInput = new Scanner(inputfile);

            row = fileInput.nextInt();
            col = fileInput.nextInt();
            WSearchchar = new char[row][col];

            fileInput.nextLine();

            for(int i = 0; i < row; i++)
            {
                inputLine = fileInput.nextLine();
                for(int j = 0; j < col; j++)
                {
                    WSearchchar[i][j] = inputLine.charAt(j);
                }
            }

            words = fileInput.nextInt();
            WSearchstring = new String[words];

            fileInput.nextLine();
            for(int i = 0; i < words; i++)
            {
                WSearchstring[i] = fileInput.nextLine();
            }
            fileInput.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println();
            System.exit(1);
        }
    }
}

