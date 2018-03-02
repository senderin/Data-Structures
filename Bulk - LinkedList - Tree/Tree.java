public class Tree{
	
	private class NodeTree
	{
		int data;
		LinkedList list;
		NodeTree left;
		NodeTree right;
		
		NodeTree(int data)
		{
			this.data=data;
			left=null;
			right=null;
			list=new LinkedList();
		}
	}
	
	NodeTree root;
	int x=0; //step number in deleteFromTree method
	
	public Tree()
	{
		root=null;
	} 
	
	public void insert(String stringData)
	{
		int keyValue=Integer.parseInt(stringData.substring(0, 1));
		if(root==null)
		{	
			root=new NodeTree(keyValue);
			root.list.add(stringData);
		}
			
		else
		{
			NodeTree temp=root;
			while(temp!=null)
			{
				if(keyValue==temp.data)
				{
					temp.list.add(stringData);
					break;
				}
				
				else if(keyValue<temp.data)
				{
					if(temp.left==null)
					{
						temp.left=new NodeTree(keyValue);
						temp.left.list.add(stringData);
						break;
					}
					else
						temp=temp.left;		
				}
				
				else if(keyValue>temp.data)
				{
					if(temp.right==null)
					{
						temp.right=new NodeTree(keyValue);
						temp.right.list.add(stringData);
						break;
					}
					else
						temp=temp.right;	
				}	
			}	
		}
	}
	
	public int search(String stringData)
	{
		int step=1;
		if(stringData.contains("*"))
		{
			//ex: 4E*||5E*(string input) is converted to an array of elements 4E and 5E
			int pattern = 0;
			String[] array;
			if(stringData.indexOf('|')<stringData.indexOf("*"))
				//for input in that format 4E66Z||5*
				array=stringData.replace("||", "*").split("\\*"); 
			else
				//for input in that format 5*||4E66Z
				array=stringData.replace("|", "").split("\\*");
			for(int i=0; i<array.length; i++)
			{
				step+=search(array[i]);
				pattern+=LinkedList.pattern;
				LinkedList.pattern=0;	
			}		
			System.out.println("Total number or records in pattern of "+stringData+"="+pattern);
		}
		else
		{
			NodeTree temp=root;
			int keyValue=Integer.parseInt(stringData.substring(0, 1));
			while(temp!=null)
			{	
				if(keyValue<temp.data)
					temp=temp.left;	
				else if(keyValue>temp.data)
					temp=temp.right;	
				else
					break;
				step++;
			}
			
			if(temp==null)
			{
				System.out.println("There is not such a data...");
				return -1;
			}
			else
			{
				if(stringData.length()!=1) 
					step+=temp.list.search(stringData);	
				else
					//if input is as 4*, then ignored number of step in linked list
					//but considered number of elements in linked list
					temp.list.search(stringData); 
			}		
		}
		return step;
	}
	
	public int delete(String stringData)
	{
		int step=1;
		if(!stringData.contains("*"))
		{
			int keyValue=Integer.parseInt(stringData.substring(0, 1));
			NodeTree temp=root;
			while(temp!=null)
			{
				if(temp.data==keyValue)
				{
					if(stringData.length()==1)
					{
						deleteFromTree(keyValue, root);
						step+=x; // x: step number in deleteFromTree method
						x=0;
					}
					else
						step+=temp.list.delete(stringData);		
					break;
				}			
				else if(keyValue<temp.data)
				{
					temp=temp.left;
					step++;
				}	
				else
				{
					temp=temp.right;
					step++;
				}		
			}
			if(temp==null)
				System.out.println("Node that starts with "+keyValue+"* already deleted.");
		}
		else
		{
			String[] array;
			if(stringData.indexOf('|')<stringData.indexOf("*"))
				array=stringData.replace("||", "*").split("\\*");
			else
				array=stringData.replace("|", "").split("\\*");
			for(int i=0; i<array.length; i++)
				step+=delete(array[i]);
		}
		return step;
	}

	private NodeTree deleteFromTree(int data, NodeTree temp)
	{
		if(temp==null)
			return null;
		if(data<temp.data)
			temp.left=deleteFromTree(data, temp.left);
		else if(data>temp.data)
			temp.right=deleteFromTree(data, temp.right);
		else if(temp.left!=null && temp.right!=null)
		{
			temp.data=findMin(temp.right).data;
			temp.right=deleteFromTree(data, temp.right);
		}
		else
			temp= (temp.left!=null)? temp.left : temp.right;
		x++;
		return temp;
	}
	
	
	private NodeTree findMin(NodeTree temp)
	{
		if(temp==null)
			return null;
		else if(temp.left==null)
			return temp;
		else
			return findMin(temp.left);
	}
	
	public void inorder(NodeTree temp)
	{
		if(temp!=null)
		{
			inorder(temp.left);
			System.out.print(temp.data+" ");
			inorder(temp.right);
		}
	}
}
