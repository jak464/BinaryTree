import java.io.IOException;


public class Driver {
	
	public void doIt() throws IOException{

		FileHandler fh = new FileHandler();
		fh.readFile();
		fh.formatFile();
		fh.writeFormattedStringtoFile();
		
		BinaryTree bt = new BinaryTree();
		fh.addFileToBinaryTree(bt);
		
		System.out.printf("Unique Words: %d%n", bt.getUniqueWordsCount());
		System.out.println("Unique words: " + bt.getUniqueWordsCount() + "\n");
		System.out.println("transylvia occurs: " + bt.searchAndReturnInstanceCount("transylvia"));
		System.out.println("harker occurs: " + bt.searchAndReturnInstanceCount("harker"));
		System.out.println("renfield occurs: " + bt.searchAndReturnInstanceCount("renfield"));
		System.out.println("harker occurs: " + bt.searchAndReturnInstanceCount("harker"));
		System.out.println("vampire occurs: " + bt.searchAndReturnInstanceCount("vampire"));
		System.out.println("expostulate occurs: " + bt.searchAndReturnInstanceCount("expostulate"));
		System.out.println();
		
//		bt.print();
	}
	
	public static void main(String[] args) {
		
		Driver me = new Driver();
		try {
			me.doIt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
