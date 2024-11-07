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

    public void  take(int pile, int amount)
    {
        if (!(amount > pile/2))
        {
            pile -= amount;
            balance += amount; 
        }
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
        if(turn)
        {
            int odds = (int) (4 * Math.random() + 1); 
            balance -= 25;
            if (odds == 4)
            {
                turn = true;   
            }
            else
            {
                turn = false;
            }
        }
    }
}
