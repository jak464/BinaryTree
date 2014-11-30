import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileHandler {

	private BufferedReader fileInput;
	private PrintWriter writer;
	
	//read in text file
	public void fileReader(){
		try {
			fileInput = new BufferedReader(new FileReader("Dracula"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	//remove punctuation and converts to lower case
	//create new formatted file
	public void formattedFile() throws IOException{
		String line;
		String str = "";
		try {
			writer = new PrintWriter("formattedDracula.txt");
			while((line = fileInput.readLine()) != null){
				if (line.isEmpty() || line.equals(" ")){
				    continue;
				}
				
				str = line.replaceAll("['_*!]", "").replaceAll("[^a-zA-Z0-9]+"," ");
				str = str.toLowerCase();
				
				writer.println(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		writer.close();
		fileInput.close();
		
	}

	//print the file
	public void filePrinter(BufferedReader in) throws IOException{
		String line;
		while((line = in.readLine()) != null){
			System.out.println(line);
		}
		in.close();
	}
	
	public static void main(String[] args) throws IOException {

	}
	
}
