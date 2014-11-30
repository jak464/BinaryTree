
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
			n.setWordInstanceCount(wordInstanceCount++);
		}
			
			return false;
		
		// iteratively locate place for this data
		WordNode tmp = root;
		
		while (tmp != null) {
			if (data > tmp.getData()) {
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
	

/*	public void preOrder() {
		preOrderTraversal(root);
		System.out.println();
	}*/
	
	private void preOrderTraversal(WordNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.getData() + " ");
		preOrderTraversal(root.getLchild());
		preOrderTraversal(root.getRchild());
	}


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
			int result = word.compareTo(root.getData());
			if (result < 0) {
				return bsearch(root.getLchild(), word);
			} else {
				return bsearch(root.getRchild(), word);
			}
		}
		
		

//		returns neg int if nodeOne is < nodeTwo, returns 0 if equal
//		returns pos int if nodeOne is > nodetwo*/

	}
 }
