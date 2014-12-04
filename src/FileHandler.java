import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileHandler {

	private BufferedReader fileInput;
	private StringBuilder draculaText;
	private String originalText;
	private String formattedText;
	
	//read in text file to String
	public String readFile() throws IOException{
		fileInput = new BufferedReader((new FileReader("dracula.txt")));
	
		draculaText = new StringBuilder();
		String line = fileInput.readLine();
		
		while(line != null){
			draculaText.append(line);
			draculaText.append("\n");
			line = fileInput.readLine();
		}
		originalText = draculaText.toString();
		return originalText;
	}

	//formats String to remove bad chars
	public String formatFile(){
		
		String sansMultipleSpacesString = "";
		StringBuilder sansBadCharacters = new StringBuilder();
		Character n;
		
		sansMultipleSpacesString = originalText.replaceAll("\\s+", " ");

		for(int i = 0; i < sansMultipleSpacesString.length(); i++){
			n = sansMultipleSpacesString.charAt(i);
			if(Character.isWhitespace(n) || Character.isLetterOrDigit(n)){
				sansBadCharacters.append(n);
			}

		}

		formattedText = sansBadCharacters.toString().toLowerCase();
		return formattedText;
	}
	
	public void writeFormattedStringtoFile(){
		try {
			PrintWriter out = new PrintWriter("formattedDracula.txt");
			out.print(formattedText);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	//add contents of file to binary tree
	public void addFileToBinaryTree(BinaryTree bt){
		
		Scanner scanny;
		
		try {
			scanny = new Scanner(new BufferedReader(new FileReader("formattedDracula.txt")));
			while(scanny.hasNext()){
				bt.add(scanny.next());
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
