import java.io.IOException;
import java.util.Scanner;

public class CheckGraph implements ConstantsInterface
{
	public static void main(String[] args)
	{
		LinkedList[] adjList = new LinkedList[COUNTRIES];
		Scanner sc       	 = new Scanner(System.in);

		/* please edit the directory accordingly */
		String file_name = "C:/Users/Tony/Documents/GitHub/CZ2001-Graphs/Graph (" + SIZE + ") TEST.txt";

		try{
			//ReadFile file = new ReadFile(file_name);
			//adjList = file.OpenFile();
			adjList = ReadFile.OpenFile(file_name);
		} 
		catch (IOException e){
			System.out.println(e.getMessage());
		}
		finally{
			for(int i = 0; i < COUNTRIES; i++){
				if(adjList[i] == null) System.out.println(i);
			}

			for(int i = 0; i < COUNTRIES; i++){
				removeDuplicate(adjList[i]);
			}
			
			//printAdjList(adjList);
			//DataSynthesis.writeAdjList(adjList);
			System.out.println("Fin.");
			
			sc.close();
		}
	}
	
	public static void printAdjList(LinkedList[] adjList)
	{
		LinkedList cur = null;
		
		for(int i = 0; i < COUNTRIES; i++){
			cur = adjList[i];
			System.out.print("[" + i + "] " + cur.country);
			
			while(cur.next != null){
				cur = cur.next;
				System.out.print(" -> " + cur.country);
			}
			
			System.out.println();
		}
	}
	
	private static void removeDuplicate(LinkedList linkedList)
	{
		LinkedList cur = linkedList;
		LinkedList tmp, next;
		
		while(cur != null && cur.next != null){
			tmp = cur;
			
			while(tmp != null && (next = tmp.next) != null){
				if(cur.country == next.country){ 	// duplicate found
					tmp.next = next.next;
				}
				
				tmp = tmp.next;
			}
			
			cur = cur.next;
		}
	}
}