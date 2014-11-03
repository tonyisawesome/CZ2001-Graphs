package main;

import java.util.Vector;

public class City
{
	private int id;
	private int index;
	private boolean visited;
	private Vector<Integer> neighbourIndex;
	
	// constructor
	public City(int index){
		this.index 	   = index;
		id         	   = -1;
		visited    	   = false;
		neighbourIndex = new Vector<Integer>(0);
	}
	
	// accessors
	public int getId(){
		return id;
	}
	
	public int getIndex(){
		return index;
	}
	
	public Vector<Integer> getNeighbours(){
		return neighbourIndex;
	}
	
	public int getEdges(){
		return neighbourIndex.size();
	}
	
	// mutators
	public void setId(int id){
		this.id = id;
	}
	
	public void visited(boolean visited){
		this.visited = visited;
	}
	
	public void addNeighbour(int neighbour){
		neighbourIndex.add(neighbour);
	}
	
	// instance methods
	public boolean isVisited(){
		return visited;
	}
}
