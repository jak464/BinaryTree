import java.io.IOException;


public class Driver {
	
	public void doIt() throws IOException{

		
/*	BinaryTree bt = new BinaryTree();
		bt.add("Poop");
		bt.add("Poop");
		bt.add("Pants");
		bt.add("Pants");
		bt.add("Pants");
		bt.add("xvii");
		System.out.println(bt.search("Pants"));
		System.out.println(bt.search("Pants"));
		bt.print();
		bt.bsearch("POONCE");
		System.out.println("unique words: " + bt.getUniqueWordsCount());
		System.out.println(bt.searchWord("Poop"));*/


		
		FileHandler fh = new FileHandler();
		fh.readFile();
		fh.formatFile();
		fh.writeFormattedStringtoFile();
		
		BinaryTree bttt = new BinaryTree();
		fh.addFileToBinaryTree(bttt);
		bttt.print();
		System.out.println("Unique words: " + bttt.getUniqueWordsCount());

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
