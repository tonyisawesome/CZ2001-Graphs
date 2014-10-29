package main;

import java.io.IOException;
import java.util.Scanner;

public class MainApp implements ConstantsInterface
{
	public static void main(String[] args)
	{
		long time;
		long start  	 	 = 0;
		long runs        	 = 10000;
		LinkedList[] adjList = new LinkedList[DESTINATIONS];
		Scanner sc       	 = new Scanner(System.in);

		/* please edit the directory accordingly */
		String file_name = "C:/Users/Tony/Documents/GitHub/CZ2001-Graphs/Graph (" + DESTINATIONS + ") TEST.txt";

		try{
			ReadFile file = new ReadFile(file_name);
			adjList = file.OpenFile();
		} 
		catch (IOException e){
			System.out.println(e.getMessage());
		}
		finally{
			//printAdjList(adjList);
			System.out.println("Total number of cities: " + DESTINATIONS);
			System.out.println("Total number of edges: "  + countEdge(adjList));
			
			/*for (int i = -10000; i < runs; i++) { 		// measure average CPU time taken
			    if (i == 0) start = System.nanoTime();
				// function to test here
			}
			time = System.nanoTime() - start;
			
			System.out.printf("Each sorting using the modified mergeSort() method took an average of %d ns\n", time/runs);
			System.out.println();*/

			sc.close();
		}
	}
	
	public static void printAdjList(LinkedList[] adjList)
	{
		LinkedList cur = null;
		
		for(int i = 0; i < DESTINATIONS; i++){
			cur = adjList[i];
			System.out.print("[" + i + "] " + cur.city);
			
			while(cur.next != null){
				cur = cur.next;
				System.out.print(" -> " + cur.city);
			}
			
			System.out.println();
		}
	}
	
	public static long countEdge(LinkedList[] adjList)
	{
		LinkedList cur = null;
		long count = 0;

		for (int i = 0; i < adjList.length; i++){
			cur = adjList[i];
			
			while(cur != null){
				count++;
				cur = cur.next;
			}
		}
		
		return count/2;
	}
}
