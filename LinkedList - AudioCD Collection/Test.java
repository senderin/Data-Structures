import java.io.IOException;
import java.util.Scanner;


public class Test {
	
	public static void main(String[] args) throws IOException
	{
		Scanner input=new Scanner(System.in);
		LinkedList obj=new LinkedList();
		boolean isExit=false;
		int userChoice;
		System.out.println("1.Add\n2.Remove\n3.Display\n4.Search\n5.List\n6.Save\n7.Load\n8.Exit");
		while(!isExit)
		{
			System.out.println("Your choice:");
			userChoice=input.nextInt();
			switch(userChoice) {
			case 1: System.out.println("Add information to be added of that order\n"
					+ "title, artist, genre, release date and total time(hh:mm:ss) :");
					String temp=input.nextLine();
					temp+=input.nextLine();
					String tempArr[]=temp.split(", ");
					AudioCDInfo newAlbum=new AudioCDInfo(tempArr);
					obj.add(newAlbum);
					System.out.println("");
					break;
			case 2: System.out.println("Enter title to be deleted:");
					obj.remove(input.nextLine()+input.nextLine());
					System.out.println("");
					break;
			case 3: obj.display();
					System.out.println();
					break;
			case 4: System.out.println("Enter the title to be searched:");
					obj.search(input.nextLine()+input.nextLine());
					System.out.println("");
					break;
			case 5: System.out.println("Enter the genre to be listed:");
					obj.list(input.nextLine()+input.nextLine());
					System.out.println("");
					break;
			case 6: obj.save();
					System.out.println("");
					break;
			case 7: obj.load("AudioCDInfos.txt");
					System.out.println("");
					break;
			case 8: isExit=true;
					System.out.println("Bye!");
					break;
			
			}
		}
			
		
		
	}
	
	
	

}
