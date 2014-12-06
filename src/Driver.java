import java.io.IOException;


public class Driver {
	
	public void doIt() throws IOException{

		FileHandler fh = new FileHandler();
		fh.readFile();
		fh.formatFile();
		fh.writeFormattedStringtoFile();
		
		BinaryTree bt = new BinaryTree();
		fh.addFileToBinaryTree(bt);
		
		System.out.println("Unique words: " + bt.getUniqueWordsCount() + "\n");
		System.out.println("transylvania occurs: " + bt.searchAndReturnInstanceCount("transylvania"));
		System.out.println("harker occurs: " + bt.searchAndReturnInstanceCount("harker"));
		System.out.println("renfield occurs: " + bt.searchAndReturnInstanceCount("renfield"));
		System.out.println("harker occurs: " + bt.searchAndReturnInstanceCount("harker"));
		System.out.println("vampire occurs: " + bt.searchAndReturnInstanceCount("vampire"));
		System.out.println("expostulate occurs: " + bt.searchAndReturnInstanceCount("expostulate"));
		System.out.println();
		System.out.println("Depth of Tree: " + bt.findDepth());
//		bt.inOrder();
		System.out.println("Most Frequent Word: " + bt.findMostFrequentWord().getWord() + " occurs " + bt.findMostFrequentWord().getWordInstanceCount());
//		bt.print();
		
		System.out.println("deepest node: " + bt.findDeepestWord());
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
