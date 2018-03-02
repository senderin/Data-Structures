//Test.class
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
	static Bulk bulk;
	static Tree tree;
	public static void main(String[] args) throws FileNotFoundException
	{
		bulk=new Bulk();
		tree=bulk.createTreeFromBulk();
		
		Scanner user=new Scanner(System.in);
		System.out.println("MENU");
		System.out.println("S-Search");
		System.out.println("D-Delete");
		System.out.println("Q-Quit");
		char userChoice;
		String userInput;
		while(true)
		{
			System.out.println("User input:");
			userInput=user.nextLine();
			userChoice=userInput.charAt(0);
			if(userChoice=='Q' || userChoice=='q')
				break;
			//ex: "S 4E*||5E*" is converted to "4E*||5E*"
			userInput=userInput.replace(" ", "").substring(1);
			System.out.println("Output: ");
			switch(userChoice) 
			{
				case 'S':
				case 's':
					System.out.println(userInput+" found in BST in "+tree.search(userInput)+" in steps");
					System.out.println(userInput+" found in Bulk in "+bulk.search(userInput)+" in steps");
					break;
				case 'D':
				case 'd':
					System.out.println("Found in BST in total "+tree.delete(userInput)+" in steps.");
					System.out.println("Found in Bulk in total "+bulk.delete(userInput)+" int steps.");
					break; 		
			}		
		}
	}
}
