import java.io.IOException;
import java.util.Scanner;

public class MainApp 
{
	public static void main(String[] args)
	{
		LinkedList[] adjList;
		long time;
		long counter[]   = new long[2];
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
			
			System.out.printf("Each sorting using the modified mergeSort() method took an average of %d ns\n", time/runs);
			System.out.println();

			sc.close();
		}
	}
}
