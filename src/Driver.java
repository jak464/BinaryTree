import java.io.IOException;

public class Driver {
	
	public void doIt() throws IOException{

		//reads in and formats file. writes formatted string to a new file.
		FileHandler fh = new FileHandler();
		fh.readFile();
		fh.formatFile();
		fh.writeFormattedStringtoFile();
		
		//creates a binary tree and adds the file to it
		BinaryTree bt = new BinaryTree();
		fh.addFileToBinaryTree(bt);
		
		//query for the times the following words appear in the text
		System.out.println("The following words appear these # of times");
		System.out.println("-------------------------------------------");
		System.out.printf( "%-25s %s %n", "transylvania:", bt.searchAndReturnInstanceCount("transylvania"));
		System.out.printf( "%-25s %s %n", "harker:", bt.searchAndReturnInstanceCount("harker"));
		System.out.printf( "%-25s %s %n", "renfield:", bt.searchAndReturnInstanceCount("renfield"));
		System.out.printf( "%-25s %s %n", "vampire:", bt.searchAndReturnInstanceCount("vampire"));
		System.out.printf( "%-25s %s %n %n", "expostulate:", bt.searchAndReturnInstanceCount("expostulate"));
		
		//gets the depth of the binary tree
		System.out.printf( "%-25s %s %n %n", "Depth of Tree:", bt.findDepth());

		//gets unique word count in the book
		System.out.printf( "%-25s %s %n %n", "Unique Words:", bt.getUniqueWordsCount());
		
		//gets word at root of the tree
		System.out.printf( "%-25s %s %n %n", "Root:", bt.getRoot());
		
		
		//gets the deepest leaves of the tree
		System.out.printf( "%-25s %s %n %n", "Deepest Word(s):", bt.findDeepestWord());
			
		//gets the most frequent word and a count
		System.out.printf( "%-25s %s %n", "Most Frequent Word:", bt.findMostFrequentWord().getWord());
		System.out.printf( "%-25s %s %n %n", "Most Frequent Count:", bt.findMostFrequentWord().getWordInstanceCount());
	
		System.out.println("-------------------------------------------");
		//prints the binary tree
		System.out.println("Printing Binary Tree... \n");
		bt.print();
	
	}
	
	public static void main(String[] args) {
		
		Driver me = new Driver();
		try {
			me.doIt();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
