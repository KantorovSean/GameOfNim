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

    public int numberInput()
    {
        while(true)
        {
            try 
            {
                String numberStr = input.nextLine();
                int number = Integer.valueOf(numberStr);
                if (number > 0)
                {
                    return number;
                }
                else
                {
                    System.out.println("Please enter a positive number");
                    continue;
                }
            }
            catch (Exception e)
            {
                System.out.println("Please enter a valid number");    
            } 
        }
    }

    private void tutorial()
    {
        //add a quick tutorial with print statements
        System.out.println("This is the game of Nim with some slight changes.");
        System.out.println("You and another player will take turns to pile, and whoever takes the last thing from the pile loses");
        System.out.println("There is one rule to this simple game, you can only take up to half of the remaining amount in the pile");
        System.out.println("So if there was 4 left, I can take up to 2");
        System.out.println("There is a slight modification made to the game where you can gamble the amount you have taken to get more, or to gamble to skip your opponent's turn");
        System.out.println("However you risk using the amount you have taken so far, but your turn as well");
    }

    private boolean turn(Player player, Player playerWhosTurnItIsnt)
    {
        System.out.println("It's " + player.getName() + "'s turn");
        System.out.println("The amount left in the pile is: " + pile);
        System.out.println("Choose an amount to take:");
        int amount = numberInput();
        if (pile != 1)
        {
            while (amount > pile/2)
            {
                System.out.println("Enter a valid amount it can be no greater than 1/2 the pile");
                amount = numberInput();
            }
        }
        else
        {
            System.out.println("it doesn't matter what you do, as you lose!");
            return false;
        }
        pile = player.take(pile, amount);
        System.out.println("your balance: " + player.getBalance());
        System.out.println("Would you like to gamble?");
        String choice = input.nextLine();
        while(!(choice.toLowerCase().equals("yes")) && !(choice.toLowerCase().equals("no")))
        {
            System.out.println("Make sure to enter a valid input yes, or no.");
            choice = input.nextLine();
        }
        if (choice.toLowerCase().equals("yes"))
        {
            System.out.println("Would you like to gamble away your turn, or amount");
            String secondChoice = input.nextLine();
            while(!(secondChoice.toLowerCase().equals("amount")) && !(secondChoice.toLowerCase().equals("turn")))
            {
                System.out.println("Please enter a valid command, turn or amount.");
                secondChoice = input.nextLine();
            }
            if (secondChoice.toLowerCase().equals("turn"))
            {
                player.gamblin();
                if (player.getTurn() == true)
                {
                    System.out.println("You won!!!!!!! The gamble. " + playerWhosTurnItIsnt.getName() + " has lost their turn!");
                    playerWhosTurnItIsnt.setTurnFalse();
                }
            }
            else
            {
                System.out.println("Enter an amount of your balance to gamble");
                int stake = numberInput();
                while (stake > player.getBalance())
                {
                    System.out.println("make sure to enter an amount you actually have");
                    stake = numberInput();
                }
                player.gamblin(stake);
            }
        }
        return true;
    }
/**
 * Precondition: The pile must be made for the game to start and 
 * for the method to execute
 * Postcondition: For the next player to continue the game,
 * the remaining pile should be half of the previous pile
 * 
 */
    public void play()
    {  
        tutorial(); //quick tutorial so the people know how to play
        while (pile > 0)
        {
            boolean end = true;
            boolean end2 = true; 
            if (player1.getTurn() == true)
            {
                end = turn(player1, player2);
            }
            else
            {
                player1.setTurnTrue();
            }
            if (!end)
            {
                System.out.println("Player " + player2.getName() + " wins!");
                break;
            }
            if (player2.getTurn() == true)
            {
                end2 = turn(player2, player1);
            }
            else
            {
                player2.setTurnTrue();
            }
            if (!end2)
            {
                System.out.println("Player " + player1.getName() + " wins!");
                break;
            }

        }
    }
}
