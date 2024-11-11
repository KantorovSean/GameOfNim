/**
 * Project 2.5.11
 *
 * GameRunner Class for the Game of Nim 
*/
import java.util.Scanner;

public class GameRunner
{
  public static void main(String[] args)
  {
    Scanner playAgain = new Scanner(System.in);
    Board nim = new Board(); 
    while (true)
    {
      nim.play();
      System.out.println("play again?");
      String playin = playAgain.nextLine();
      if (playin.toLowerCase().equals("yes"))
      {
        continue;
      }
      else
      {
        break;
      }
    }
  }
}