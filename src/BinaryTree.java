
public class BinaryTree {
	
	private WordNode root;
	private WordNode current;
	private int nodeCount;
	
	//Binary Tree Constructor
	public BinaryTree() {
		root = null;
		nodeCount = 0;
	}
	
	//Add Word to the Binary Tree
	public boolean add(String word) {
		
		WordNode n = new WordNode();
		n.setWord(word);

		//If the tree is empty, add the root node
		if (nodeCount == 0) {
			root = n;
			nodeCount++;
			n.setWordInstanceCount(1);
			return true;
		}
		
		//Check if data already in tree
		//if it does, do not add but increase word instance count instead
		if (search(word) == true){
			n.setWordInstanceCount(n.getWordInstanceCount()+1);
			return false;
		}
			
		// iteratively locate place for this data
		WordNode tmp = root;
		
		while (tmp != null) {
//			returns neg int if nodeOne is < nodeTwo, returns 0 if equal
//			returns pos int if nodeOne is > nodetwo*/			
			int result = word.compareTo(tmp.getWord());

			if (result > 0) {
				if (tmp.getRchild() == null) {
					tmp.setRchild(n);
					nodeCount++;
					n.setWordInstanceCount(1);
					return true;
				} else {
					tmp = tmp.getRchild();
				}
			} else {
				if (tmp.getLchild() == null) {
					tmp.setLchild(n);
					nodeCount++;
					n.setWordInstanceCount(1);
					return true;
				} else {
					tmp = tmp.getLchild();
				}
				
			}
		}
		
		return false;
		
	}
	

	public void print() {
		printTree(root);
	}
	
	private void printTree(WordNode root) {
		if (root == null) {
			System.out.print(".");
			return;
		}
		
		printTree(root.getLchild());
		System.out.print(root.getWord());
		printTree(root.getRchild());
		
	}
	
	//display the data part of root element
	//traverse the left subtree by recursively calling the pre-order function
	//traverse the right subtree by recursively calling the pre-order function
	//aka start at root and go downwards on left and go downwards on right
	public void preOrder() {
		preOrderTraversal(root);
		System.out.println();
	}
	
	private void preOrderTraversal(WordNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.getWord() + " ");
		preOrderTraversal(root.getLchild());
		preOrderTraversal(root.getRchild());
	}
	
	//traverse the left subtree by calling the in-order function
	//display the data part of the root element
	//traverse the right subtree by recursively calling the in-order function
	//aka start from left bottom and work your way up and right
	public void inOrder() {
		inOrderTraversal(root);
		System.out.println();
	}
	
	private void inOrderTraversal(WordNode root) {
		if (root == null) {
			return;
		}
		preOrderTraversal(root.getLchild());
		System.out.print(root.getWord() + " ");
		preOrderTraversal(root.getRchild());
	}
	
	//traverse the left subtree by recursively calling the post-order function
	//traverse the right subtree by recursively calling the post-order function
	//display the data part of root element (or current element)
	//left most bottom nodes first, up, then right side. 
	public void postOrder() {
		postOrderTraversal(root);
		System.out.println();
	}
	
	private void postOrderTraversal(WordNode root) {
		if (root == null) {
			return;
		}
		postOrderTraversal(root.getLchild());
		postOrderTraversal(root.getRchild());
		System.out.print(root.getWord() + " ");
	}
	

	//search word and return that node to access
	public WordNode searchWord(String word){
		WordNode wn = new WordNode();
		return wn;
	}
	
	public boolean search(String word) {
		return bsearch(root, word);
	}
	
	private boolean bsearch(WordNode root, String word) {
		if (root == null) {
			return false;
		}
		
		if (root.getWord() == word) {
			return true;
		} 
		else {
			//	returns neg int if nodeOne is < nodeTwo, returns 0 if equal
			//	returns pos int if nodeOne is > nodetwo*/
			int result = word.compareTo(root.getWord());
			
			if (result < 0) {
				return bsearch(root.getLchild(), word);
			} 
			else {
				return bsearch(root.getRchild(), word);
			}
		}	
	}

	public WordNode getNodeContainingWord(WordNode root, String word){
		if (root == null) {
			return null;
		}
		
		if (root.getWord() == word) {
			WordNode current = new WordNode();
			current = root;
			return current;
		} 
		else {
			//	returns neg int if nodeOne is < nodeTwo, returns 0 if equal
			//	returns pos int if nodeOne is > nodetwo
			int result = word.compareTo(root.getWord());
			
			if (result < 0) {
				bsearch(root.getLchild(), word);
			} 
			else {
				bsearch(root.getRchild(), word);
			}
		}
		return null;
	}
	
	//What is the depth of the tree?
	public void findDepth(){
		
	}
	
	//How many unique words are there in the book?
	public int getUniqueWordsCount(){
		return nodeCount;
	}
	
	//Which word occurs most frequently?
	public String findMostFrequentWord(){
		return null;
	}
	
	//What word is at the root of the tree?
	public String getRoot(){
		return root.getWord();
	}
	
	//What word is at the deepest of the tree?
	public void findDeepestLeaf(){
		
	}
	

 }