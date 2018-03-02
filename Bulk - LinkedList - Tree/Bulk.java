import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bulk {
	
	String[] datas=new String[1000];
	
	Bulk() throws FileNotFoundException
	{
		Scanner input=new Scanner(new File("input.txt")); 
		for(int i=0; input.hasNext(); i++)
			datas[i]=input.next();
	}
	
	public Tree createTreeFromBulk()
	{
		Tree tree=new Tree();
		for(int i=0; i<datas.length; i++)
			tree.insert(datas[i]);
		return tree;
	}
	
	public int search(String data)
	{
		int step=0;
		if(data.contains("*"))
		{
			String[] array;
			if(data.indexOf('|')<data.indexOf("*"))
				array=data.replace("||", "*").split("\\*");
			else
				array=data.replace("|", "").split("\\*");
			for(int i=0; i<array.length; i++)
				step+=search(array[i]);
		}
		else if(data.length()<5)
		{
			for(int i=0; i<datas.length; i++)
			{
				if(datas[i].equals("-1"))
					continue;
				else
					step++;
			}
		}	
		else
		{
			for(int i=0; i<datas.length; i++)
			{
				if(datas[i].equals("-1"))
					continue;
				else
				{
					step++;
					if(datas[i].equals(data))
							break;
				}
			}
		}
		return step;
	}

	public int delete(String data)
	{
		int step=0;
		if(data.contains("*"))
		{
			String[] array;
			if(data.indexOf('|')<data.indexOf("*"))
				array=data.replace("||", "*").split("\\*");
			else
				array=data.replace("|", "").split("\\*");
			for(int i=0; i<array.length; i++)
				step+=delete(array[i]);
		}
		else if(data.length()<5)
		{
			for(int i=0; i<datas.length; i++)
			{
				if(datas[i].equals("-1"))
					continue;
				else
				{
					step++;
					if(datas[i].startsWith(data))
						datas[i]="-1";
				}
			}
		}	
		else
		{
			for(int i=0; i<datas.length; i++)
			{
				if(datas[i].equals("-1"))
					continue;
				else if(datas[i].equals(data))
				{
					step++;
					datas[i]="-1";
					break;
				}
				else
					step++;
			}
		}
		return step;
	}
}
