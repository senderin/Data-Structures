import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class LinkedList {

	private Node head;
	
	private static class Node
	{
		private AudioCDInfo data;
		private Node next;
		public Node(AudioCDInfo info, Node next)
		{
			this.data = info;
			this.next= next;
		}
	}
	
	public LinkedList() throws IOException
	{
		head = null;
	}
	
	
	public void add(AudioCDInfo newAlbum)
	{
		
		if( head== null)
		{
			head = new Node(newAlbum, head);
		}
		
		else
		{
			Node tmp= head;
			while(tmp.next!= null)
				tmp= tmp.next;
			tmp.next= new Node(newAlbum, null);
		}
		System.out.println("Added...");
	}
	
	public void remove(String string)
	{
		if(head == null) 
			System.out.println("There is not album register to remove...");
		
		else if( head.data.getTitle().equalsIgnoreCase(string))
		{
			head = head.next;
			System.out.println("Removed...");
		}
		
		else
		{
			Node cur = head;
			Node prev= null;
		
			while(cur != null && !cur.data.getTitle().equalsIgnoreCase(string) )
			{
				prev= cur;
				cur = cur.next;
			}
		
			if(cur == null)
				System.out.println("There is not the album that you want to remove...");
			
			else
			{
				prev.next= cur.next; //delete cur node
				System.out.println("Removed...");
			}
			 
		}
	
	}
	
	public void display()
	{
		if(head==null)
			System.out.println("There is not album register to be displayed...");
		else
		{
			Node temp=head;
			String time[];
			int hour=0;
			int minute=0;
			int second=0;
			while(temp!=null)
			{
				AudioCDInfo tmp=temp.data;
				System.out.printf("%-20s%-20s%-18s%-10s%-10s\n", tmp.getTitle(), tmp.getArtist(), tmp.getGenre(),
						tmp.getReleaseDate(), tmp.getTotalTime());
				time=tmp.getTotalTime().split(":");
				hour+=Integer.parseInt(time[0]);
				minute+=Integer.parseInt(time[1]);
				second+=Integer.parseInt(time[2]);
				temp=temp.next;
			}
			
			int x=second;
			minute+=x/60;
			second=second%60;
			x=minute;
			hour+=x/60;
			minute=minute%60;
			System.out.println("Total time="+(hour==0? "00": hour)+":"
											+(minute==0? "00": minute)+":"
											+(second==0? "00": second));
		}
		
	}
	
	public void search(String string)
	{
		Node temp = head;
		boolean isFound=false;
		while (isFound!=true && temp != null) {
			if (temp.data.getTitle().equalsIgnoreCase(string))
			{
				System.out.println("Found...");
				System.out.printf("%-20s%-20s%-18s%-10s%-10s\n", temp.data.getTitle(), temp.data.getArtist(), temp.data.getGenre(),
						temp.data.getReleaseDate(), temp.data.getTotalTime());
				isFound=true;
			}	
			else
				temp = temp.next;
		}
		if(isFound!=true)
			System.out.println("Not found...");	
	}
	
	public void list(String string)
	{
		Node temp = head;
		while (temp != null) {
			if (temp.data.getGenre().equalsIgnoreCase(string))
			{
				System.out.printf("%-20s%-20s%-20s%-18s%-10s\n", temp.data.getGenre(), temp.data.getTitle(), temp.data.getArtist(), 
						temp.data.getReleaseDate(), temp.data.getTotalTime());
			}	
			temp = temp.next;
		}
	}
	
	public void save() throws FileNotFoundException
	{
		Node temp=head;
		if(temp==null)
			System.out.println("There is not any album register to save...");
		else
		{
			PrintWriter writer=new PrintWriter("Albums.txt");
			while(temp!=null)
			{
				writer.printf("%-20s%-20s%-18s%-10s%-10s", temp.data.getTitle(), temp.data.getArtist(), temp.data.getGenre(),
					temp.data.getReleaseDate(), temp.data.getTotalTime());
				writer.println("");
				temp=temp.next;
			}
			writer.close();
			System.out.println("Saved...");
		}
	}
	
	public void load(String fileName) throws IOException
	{
		BufferedReader file=new BufferedReader(new FileReader(fileName));
		AudioCDInfo info;
		String temp;
		temp=file.readLine();
		while(temp!=null)
		{	
			String tempArr[]=temp.split(", ");
			info=new AudioCDInfo(tempArr);
			add(info);
			temp=file.readLine();			
		}
		file.close();
	}		
}
