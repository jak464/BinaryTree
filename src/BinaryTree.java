
public class BinaryTree {
	
	private WordNode root;
	private int nodeCount;
	
	public BinaryTree() {
		root = null;
		nodeCount = 0;
	}
	
	public boolean add(String data) {
		
		WordNode n = new WordNode();
		n.setData(data);

		// What if tree is empty?
		if (nodeCount == 0) {
			root = n;
			nodeCount++;
			return true;
		}
		
		// See if data already in tree
		if (search(data)){
			n.setWordInstanceCount(n.getWordInstanceCount()+1);
			return false;
		}
			
		// iteratively locate place for this data
		WordNode tmp = root;
		
		while (tmp != null) {
//			returns neg int if nodeOne is < nodeTwo, returns 0 if equal
//			returns pos int if nodeOne is > nodetwo*/			
			int result = data.compareTo(tmp.getData());

			if (result > 0) {
				if (tmp.getRchild() == null) {
					tmp.setRchild(n);
					nodeCount++;
					return true;
				} else {
					tmp = tmp.getRchild();
				}
			} else {
				if (tmp.getLchild() == null) {
					tmp.setLchild(n);
					nodeCount++;
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
		System.out.print(root.getData());
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
		System.out.print(root.getData() + " ");
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
		System.out.print(root.getData() + " ");
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
		System.out.print(root.getData() + " ");
	}
	

	public boolean search(String data) {
		return bsearch(root, data);
	}
	
	private boolean bsearch(WordNode root, String word) {
		if (root == null) {
			return false;
		}
		
		if (root.getData() == word) {
			return true;
		} else {
			//	returns neg int if nodeOne is < nodeTwo, returns 0 if equal
			//	returns pos int if nodeOne is > nodetwo*/
			int result = word.compareTo(root.getData());
			
			if (result < 0) {
				return bsearch(root.getLchild(), word);
			} 
			else {
				return bsearch(root.getRchild(), word);
			}
		}	
	}
 }
