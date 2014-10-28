import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
	
	 public void removeLineFromFile(String file, String lineToRemove) {

		    try {

		      File inFile = new File(file);

		      if (!inFile.isFile()) {
		        System.out.println("Parameter is not an existing file");
		        return;
		      }

		      //Construct the new file that will later be renamed to the original filename.
		      File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

		      BufferedReader br = new BufferedReader(new FileReader(file));
		      PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

		      String line = null;

		      //Read from the original file and write to the new
		      //unless content matches data to be removed.
		      while ((line = br.readLine()) != null) {

		        if (!line.trim().equals(lineToRemove)) {

		          pw.println(line);
		          pw.flush();
		        }
		      }
		      pw.close();
		      br.close();

		      //Delete the original file
		      if (!inFile.delete()) {
		        System.out.println("Could not delete file");
		        return;
		      }

		      //Rename the new file to the filename the original file had.
		      if (!tempFile.renameTo(inFile))
		        System.out.println("Could not rename file");

		    }
		    catch (FileNotFoundException ex) {
		      ex.printStackTrace();
		    }
		    catch (IOException ex) {
		      ex.printStackTrace();
		    }
		  }
}

