package main;

import java.util.Vector;

public class City
{
	private int id;
	private int index;
	private boolean visited;
	private Vector<Integer> neighbourIndex;
	private Vector<City> neighbours;
	
	// constructor
	public City(int index){
		this.index 	   = index;
		id         	   = -1;
		visited    	   = false;
		neighbours     = new Vector<City>(0);
		neighbourIndex = new Vector<Integer>(0);
	}
	
	// accessors
	public int getId(){
		return id;
	}
	
	public int getIndex(){
		return index;
	}
	
	public Vector<Integer> getNeighbourIndex(){
		return neighbourIndex;
	}
	
	public Vector<City> getNeighbours(){
		return neighbours;
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
	
	public void addEdge(City city){
		neighbours.add(city);
	}
	
	public void addNeighbourIndex(int index){
		neighbourIndex.add(index);
	}
	
	// instance methods
	public boolean isVisited(){
		return visited;
	}
}
