import java.io.IOException;
import java.util.Scanner;

public class CheckGraph 
{
	public static void main(String[] args)
	{
		LinkedList[] adjList = new LinkedList[ReadFile.COUNTRIES];
		Scanner sc       	 = new Scanner(System.in);

		/* please edit the directory accordingly */
		String file_name = "C:/Users/Tony/workspace/ExampleClass_4/Graph (" + ReadFile.SIZE + ").txt";

		try{
			ReadFile file = new ReadFile(file_name);
			adjList = file.OpenFile();
		} 
		catch (IOException e){
			System.out.println(e.getMessage());
		}
		finally{
			for(int i = 0; i < ReadFile.COUNTRIES; i++){
				if(adjList[i] == null) System.out.println(i);
			}
			
			printAdjList(adjList);
			
			System.out.println("Fin");
			
			sc.close();
		}
	}
	
	public static void printAdjList(LinkedList[] linkedList)
	{
		LinkedList cur = null;
		
		for(int i = 0; i < ReadFile.COUNTRIES; i++){
			cur = linkedList[i];
			System.out.print("[" + i + "] " + cur.country);
			
			while(cur.next != null){
				cur = cur.next;
				System.out.print(" -> " + cur.country);
			}
			
			System.out.println();
		}
	}
}