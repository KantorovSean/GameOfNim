public class Player
{
    private String name;
    private int balance;

    public Player(String name)
    {
        this.name = name;
        this.balance = 0;
    }

    public String getName()
    {
        return name;
    }

    public int getBalance() 
    {
        return balance;
    }

    public void take(Board board, int amount)
    {

    }
}
