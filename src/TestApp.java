import java.io.IOException;
import java.util.Scanner;

public class TestApp 
{
	public static void main(String[] args)
	{
		LinkedList[] adjList;
		long time;
		long counter[][] = new long[2][2];
		long start  	 = 0;
		long runs        = 10000;
		Scanner sc       = new Scanner(System.in);

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
			for (int i = -10000; i < runs; i++) { 		// measure average CPU time taken
			    if (i == 0) start = System.nanoTime();
				// function to test here
			}
			time = System.nanoTime() - start;
			
			System.out.println("<Modified mergeSort() method>");
			System.out.println("Number of key comparisons: " + counter[0][0]);
			System.out.println("Number of recursions: "  + counter[0][1]);
			System.out.printf("Each sorting using the modified mergeSort() method took an average of %d ns\n", time/runs);
			System.out.println();

			sc.close();
		}
	}
}
