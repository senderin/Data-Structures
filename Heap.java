//MinHeap
public class Heap {
	
	private static int currentSize;
	private byte[] heapArray;
	public byte[] sortedArray;
	
	Heap(int size)
	{
		heapArray=new byte[size+1];
		sortedArray=new byte[size];
	}

	public void construct(byte[] array)
	{
		heapArray[0]=0;
		for(int i=1; i<heapArray.length; i++)
		{
			heapArray[i]=array[i-1];
			if(i==1)
				continue;
			heapifyForConstruct(i);
		}
		System.out.println("Heap was created...");
	}
	
	private void heapifyForConstruct(int index)
	{
		byte parent=heapArray[index/2];
		byte child=heapArray[index];
		if(child<parent)
		{
			byte temp;
			temp=heapArray[index];
			heapArray[index]=heapArray[index/2];
			heapArray[index/2]=temp;
		}
		if(index>1)
			heapifyForConstruct(index/2);
	}
	
	public void sort()
	{
		for(int i=1; i<heapArray.length; i++)
		{
			sortedArray[i-1]=heapArray[1];
			heapArray[1]=heapArray[heapArray.length-1-i];
			heapifyForSort(1, heapArray.length-1-i);
		}
		System.out.println("Heap was sorted...");
	}	
	
	private void heapifyForSort(int index, int lastIndex)
	{
		int parent=index;
		int leftChild=2*index;
		int rightChild=2*index+1;
		if(leftChild<currentSize && rightChild<currentSize)
		{
			if(heapArray[parent]>heapArray[leftChild] && heapArray[parent]>heapArray[rightChild])
			{
				int minIndex= heapArray[leftChild]<heapArray[rightChild] ? leftChild:rightChild;
				byte temp=heapArray[parent];
				heapArray[parent]=heapArray[minIndex];
				heapArray[minIndex]=temp;
				heapifyForSort(minIndex, lastIndex);	
			}
		}
		
		if(leftChild<currentSize)
		{
			if(heapArray[parent]>heapArray[leftChild])
			{
				byte temp;
				temp=heapArray[parent];
				heapArray[parent]=heapArray[leftChild];
				heapArray[leftChild]=temp;
				heapifyForSort(leftChild, lastIndex);
			}
		}
		
		if(rightChild<currentSize)
		{
			if(heapArray[parent]>heapArray[rightChild])
			{
				byte temp;
				temp=heapArray[parent];
				heapArray[parent]=heapArray[rightChild];
				heapArray[rightChild]=temp;
				heapifyForSort(rightChild, lastIndex);
			}
		}		
	}
}
