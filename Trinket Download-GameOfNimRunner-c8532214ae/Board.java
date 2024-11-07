import java.util.Scanner;
public class Board 
{
    //initializng the scanner
    private Scanner input;

    private int pile; //the amount of objects on the field

    //creating the 2 players
    private Player player1;
    private Player player2;

    public Board()
    {
        //creating the scanner
        input = new Scanner(System.in);

        //setting the pile to a random number between 10 - 50
        pile = (int) (10 + 41 * Math.random());

        //initializng the players
        playerMaker();
    }

    private void playerMaker()
    {
        //goofy code that I didn't want to make into a loop as that would be a waste of memory that I already have
        System.out.println("Enter name for player 1");
        String playerName = input.nextLine();
        player1 = new Player(playerName);
        System.out.println("Enter name for player 2");
        playerName = input.nextLine();
        player2 = new Player(playerName);
    }

    void numberInput()
    {
        while(true)
        {
            try 
            {
                String numberStr = input.nextLine();
                int number = Integer.valueOf(numberStr);
                if (number >= 0)
                {
                    break;
                }
                else
                {
                    System.out.println("Please enter a positive number");
                }
            }
            catch (Exception e)
            {
                System.out.println("Please enter a valid number");    
            }
            
        }
    }

    public void play()
    {
        boolean playing = true;
        //add a quick tutorial with print statements
        int looper = 1; //will help me keep track of who's turn it is
        while (playing)
        {
        }
    }
}
