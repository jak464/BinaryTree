import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileHandler {

	private String originalText;
	private String formattedText;
	
	//reads in dracula text file to a string
	public String readFile() throws IOException{
		
		BufferedReader fileInput = new BufferedReader((new FileReader("dracula.txt")));
	
		StringBuilder draculaTextSB = new StringBuilder();
		String line = fileInput.readLine();
		
		while(line != null){
			draculaTextSB.append(line);
			draculaTextSB.append("\n");
			line = fileInput.readLine();
		}
		
		originalText = draculaTextSB.toString();
		return originalText;
	}

	//formats String to remove bad chars 
	public String formatFile(){
		
		Character n;
		String minimizeWhiteSpace = "";
		StringBuilder noBadCharactersSB = new StringBuilder();
		
		//matches 1+ whitespace character and replaces with 1 space to 
		//allow the string's words to have a delimiter of 1 space. 
		minimizeWhiteSpace = originalText.replaceAll("\\s+", " ");

		//loops through each char and the string and only adds if it's 
		//a whitespace character, letter, or digit.
		for(int i = 0; i < minimizeWhiteSpace.length(); i++){
			n = minimizeWhiteSpace.charAt(i);
			if(Character.isWhitespace(n) || Character.isLetterOrDigit(n)){
				noBadCharactersSB.append(n);
			}

		}

		formattedText = noBadCharactersSB.toString().toLowerCase();
		return formattedText;
	}
	
	//writes the formatted String to a file
	public void writeFormattedStringtoFile(){
		try {
			PrintWriter out = new PrintWriter("formattedDracula.txt");
			out.print(formattedText);
			out.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	//add contents of file to a binary tree
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
