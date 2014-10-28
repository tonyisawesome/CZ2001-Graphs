public class Queue
{
	LinkedList list;
	Queue next;
	
	public Queue(LinkedList list)
	{
		this.list = list;
	}
	
	public void addLinkedList(LinkedList list)
	{
		next = new Queue(list);
	}
}
