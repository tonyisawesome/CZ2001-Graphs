import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DataSynthesis 
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
		int randomInt = randomNumGenerator.nextInt(ReadFile.SIZE);
			
		return randomInt;
	}
	
	// generate a graph
	public static void insertData()
	{
        File file = new File("Graph (" + ReadFile.SIZE + ").txt");
	        try {
	            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	            
	            for (int i = 0; i < ReadFile.SIZE; i++){
	            	writer.write(String.valueOf(generateData()) + "," + String.valueOf(generateData()));
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

