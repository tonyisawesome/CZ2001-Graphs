public class LinkedList
{
	public int country;
	public LinkedList next;
	
	public LinkedList(int country)
	{
		this.country = country;
	}
	
	public void addNeighbour(int neighbour)
	{
		next = new LinkedList(neighbour);
	}
}
