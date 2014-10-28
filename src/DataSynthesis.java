import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class DataSynthesis implements ConstantsInterface
{
	Random randomNumGenerator = new Random();
	
	public static void main(String[] args) 
	{
		insertData();
		System.out.println("Finish.");
    }
	
	// generate a random integer
	public static int generateData()
	{
		Random randomNumGenerator = new Random();
		int randomInt = randomNumGenerator.nextInt(COUNTRIES);
			
		return randomInt;
	}
	
	// generate edges
	public static void insertData()
	{
		int a, b;
		
        File file = new File("Graph (" + SIZE + ") TEST.txt");
	    try {
	    	BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	            
	    	for (int i = 0; i < SIZE; i++){
	    		do{
		    		a = generateData();
		    		b = generateData();
	            } while(a == b);
	            	
	            writer.write(String.valueOf(a) + "," + String.valueOf(b));
				writer.newLine();
				writer.flush();
	        }
	    	writer.close();
	    } 
	    catch (IOException e) {
	    	e.printStackTrace();
	    } 
	}
	
	// write adjacency list to text file
	public static void writeAdjList(LinkedList[] adjList)
	{
        File file = new File("Graph (" + SIZE + ") TEST.txt");
	    try {
	    	BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	    	LinkedList cur;
	            
	        for (int i = 0; i < COUNTRIES; i++){
	        	cur = adjList[i];
	        	
	            while(cur != null){
		            writer.write(String.valueOf(cur.country));
		            
		            if ((cur = cur.next) != null){
		            	writer.write( " -> ");
		            }
	            }
	            
				writer.newLine();
				writer.flush();
	        }
	        
	    	writer.close();
	    } 
	    catch (IOException e) {
	        e.printStackTrace();
	    } 
	}
}

