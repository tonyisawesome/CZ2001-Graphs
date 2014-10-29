package main;

public class LinkedList
{
	protected int city;
	protected LinkedList next;
	
	protected LinkedList(int city)
	{
		this.city = city;
	}
	
	protected void addNeighbour(int neighbour)
	{
		next = new LinkedList(neighbour);
	}
}
