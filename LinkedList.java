public class LinkedList {

	private class NodeList
	{
		String data;
		NodeList next;
		
		NodeList(String data)
		{
			this.data=data;
			next=null;
		}
	}
	
	private NodeList head;
	static int pattern=0;
	LinkedList()
	{
		head=null;
	}
	
	public void add(String data)
	{
		if(head==null)
			head=new NodeList(data);
		else
		{
			NodeList temp=head;
			while(temp.next!=null)
				temp=temp.next;
			NodeList newNode=new NodeList(data);
			temp.next=newNode;
		}
	}
	
	public int search(String data)
	{
		NodeList temp=head;
		int stepInList=1;
		if(data.length()!=5)
		{
			while(temp!=null)
			{
				if(temp.data.startsWith(data)==true)
					pattern++;
				temp=temp.next;
				stepInList++;
			}
		}
		else if(data.length()==5)
		{
			while(temp!=null && !temp.data.equals(data))
			{
				temp=temp.next;
				stepInList++;
			}
		}
		return stepInList;
	}
	
	public int delete(String data)
	{
		int step=0;
		if(data.length()!=5)
		{
			NodeList cur=head;
			while(cur!=null)
			{	
				if(head.data.startsWith(data))
				{
					head=head.next;
					cur=head;
					step++;
				}
				else
				{
					NodeList prev=head;
					cur=head.next;
					step++;
					while(cur!=null)
					{
						if(cur.data.startsWith(data))
						{
							prev.next=cur.next;
							cur=prev.next;	
							continue;
						}
						prev=cur;
						cur=cur.next;
						step++;
					}
				}
			}
			System.out.println("All nodes with "+data+"* deleted.");
		}
		
		else
		{
			if(head.data.equals(data))
			{
				NodeList temp=head;
				head=head.next;
				temp.next=null;
				step++;
			}
			else
			{
				NodeList prev=head;
				NodeList cur=head.next;
				step++;
				while(cur!=null)
				{
					if(cur.data.equals(data))
						break;
					else
					{
						prev=cur;
						cur=cur.next;
						step++;
					}
				}
				
				if(cur==null)
					System.out.println("There is no such that data: "+data);
				else
				{
					prev.next=cur.next;
					cur.next=null;
					System.out.println(data+" deleted.");
					step++;
				}		
			}
		}
		return step;
	}
	
	public boolean isListEmpty()
	{
		if(head==null)
			return true;
		return	false;
	}
	
}
