import java.io.IOException;


public class Driver {
	
	public void doIt() throws IOException{
		FileHandler fh = new FileHandler();
		fh.fileReader();
		fh.formatFile();
		
	/*	BinaryTree bt = new BinaryTree();
		bt.add("Poop");
		bt.add("Pants");
		bt.add("xvii");
		bt.print();
		System.out.println();
		System.out.println("pre order");
		bt.preOrder();
		System.out.println("in order");
		bt.inOrder();		
		System.out.println("post order");
		bt.postOrder();
		System.out.println(bt.search("Podfop"));*/

	}
	
	public static void main(String[] args) throws IOException {
		
		Driver me = new Driver();
		me.doIt();
	}

}
