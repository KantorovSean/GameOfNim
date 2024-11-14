public class Player
{
    private String name;
    private int balance;
    private boolean turn;

    public Player(String name)
    {
        this.name = name;
        this.balance = 0;
        this.turn = true;
    }

    public String getName()
    {
        return name;
    }

    public int getBalance() 
    {
        return balance;
    }

    public boolean getTurn()
    {
        return turn;
    }

    public void setTurnFalse()
    {
        turn = false;
    }

    public void setTurnTrue()
    {
        turn = true;
    }
    public int  take(int pile, int amount)
    {
        if (pile == 1)
        {
            System.out.println("made it hereS");
            pile -= 1;
        }
        else if (!(amount > pile/2))
        {
            pile -= amount;
            balance += amount; 
        }
        return pile;

    }

    //come back to later to check if they valid or nah
    public void gamblin(int amountGambled)
    {
        balance -= amountGambled;
        if (!(balance < 0))
        {
            int odds = (int) (4 * Math.random() + 1); 
            if (odds == 4)
            {
                balance += amountGambled * 2;
            }
        }
        else
        {
            balance += amountGambled; //can't spend the money if you don't have it
            System.out.println("No gambling for you");
        }
    }

    public void gamblin()
    {
        if(turn && balance >= 5)
        {
            int odds = (int) (4 * Math.random() + 1); 
            if (odds == 4)
            {
                turn = true;   
            }
            else
            {
                balance -= 5;
                turn = false;
            }
        }
        else
        {
            System.out.print("You don't have enough to gamble");
        }
    }
}
