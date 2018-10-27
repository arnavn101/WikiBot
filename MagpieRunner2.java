import java.util.Scanner;

/**
 * A simple class to run the Magpie class.
 * @author Laurie White
 * @version April 2012
 */
public class MagpieRunner2
{
    public static Scanner in = new Scanner (System.in);
    /**
     * Create a Magpie, give it user input, and print its replies.
     */
    public static void main(String[] args) throws java.io.IOException
    {
		Magpie2 maggie = new Magpie2();
		
		System.out.println (maggie.getGreeting());


		String statement = in.nextLine();
		statement = statement.toLowerCase();
		
		while (!statement.equals("Bye")&&!statement.equals("bye")) 
		{
		       
		       System.out.println (maggie.getResponse(statement));
		       statement = in.nextLine();
		       statement = statement.toLowerCase(); 
		       
			
		}
	}

}
