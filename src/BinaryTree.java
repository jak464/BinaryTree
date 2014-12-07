import java.util.ArrayList;

public class BinaryTree {
	
	private WordNode root;
	private WordNode current;
	private int nodeCount;
	private int currentDepth = 0;
	private int maxDepth = 0;
	private int mostFrequentCount = 0;
	private WordNode mostFrequentWord;
	private ArrayList<String> deepestNodes = new ArrayList<String>();
	
	//binary tree constructor
	public BinaryTree() {
		root = null;
		nodeCount = 0;
	}
	
	//add word to the binary tree
	public boolean add(String word) {
		
		WordNode n = new WordNode();
		n.setWord(word);

		//if the tree is empty, add the root node
		if (nodeCount == 0) {
			root = n;
			nodeCount++;
			n.setWordInstanceCount(1);
			return true;
		}
		
		//check if data already in tree. if it does, do 
		//not add but instead increase word instance count 
		if (searchWord(word) != null){
			n = bsearchReturnNode(root, n.getWord());
			n.setWordInstanceCount(n.getWordInstanceCount()+1);
			return false;
		}
			
		//iteratively locate place for this data
		WordNode tmp = root;
		
		while (tmp != null) {
			//returns neg int if node1 is < node2 and pos int if node1 is > node2
			int result = word.compareTo(tmp.getWord());

			if (result > 0) {
				if (tmp.getRchild() == null) {
					tmp.setRchild(n);
					nodeCount++;
					n.setWordInstanceCount(1);
					return true;
				} 
				else {
					tmp = tmp.getRchild();
				}
			} 
			else {
				if (tmp.getLchild() == null) {
					tmp.setLchild(n);
					nodeCount++;
					n.setWordInstanceCount(1);
					return true;
				} 
				else {
					tmp = tmp.getLchild();
				}
				
			}
		}
		return false;
	}
	

	public void print() {
		printTree(root);
	}
	
	//traverses the tree in order and prints
	private void printTree(WordNode root) {
		if (root == null) {
			System.out.print(".");
			return;
		}
		
		printTree(root.getLchild());
		System.out.print(root.getWord());
		printTree(root.getRchild());
		
	}
	
	//returns how many unique words are in the book
	public int getUniqueWordsCount(){
		return nodeCount;
	}
	
	//returns root of the binary tree
	public String getRoot(){
		return root.getWord();
	}
	
	//search word and return instance count
	public int searchAndReturnInstanceCount(String word){
		if(bsearchReturnNode(root, word) != null){
			return current.getWordInstanceCount();
		}
		return 0;
	}
	
	//search word and return that node to access
	public WordNode searchWord(String word){
		return bsearchReturnNode(root, word);
	}
	
	//search if word exists and returns the wordnode
	private WordNode bsearchReturnNode(WordNode root, String word) {
		if (root == null) {
			return null;
		}
		
		if (root.getWord().equals(word)) {
			current = root;
			return current;
		} 
		
		else {
			//returns neg int if node1 is < node2, 0 if equal
			//pos int if node1 is > node2
			int result = word.compareTo(root.getWord());
			
			if (result < 0) {
				current = bsearchReturnNode(root.getLchild(), word);
				return current;
			} 
			else {
				current = bsearchReturnNode(root.getRchild(), word);
				return current;
			}
		}	
	}
	
	//finds depth of tree
	public int findDepth() {
		currentDepth = 0;
		maxDepth = 0;
		findDepth(root);
		return maxDepth;
	}
	
	//finds depth of tree by keeping track of current depth 
	//and total depth while traversing the tree
	public void findDepth(WordNode root){
		
		if(root != null) {
			currentDepth++;
			
			//records total depth if current depth is > total depth
			if(currentDepth > maxDepth) {
				maxDepth = currentDepth;
			}
			
			//recursively traverses the tree
			findDepth(root.getLchild());
			findDepth(root.getRchild());
			
			//decrements as we traverse upwards
			//no more nodes and we go 1 level up
			currentDepth--;
		}
		
	}
	
	//finds deepest words
	public ArrayList<String> findDeepestWord() {
		maxDepth = 0;
		currentDepth = 0;
		findDepth();
		findDeepestWord(root);
		return deepestNodes;
	}
	
	//finds depth of tree by recursively traversing the tree
	//and keeping track of current depth and total depth
	public void findDeepestWord(WordNode root){
		if(root != null) {
			
			currentDepth++;
			
			//check if current depth is equal to max depth, 
			//add it to a list of deepestNodes
			if(currentDepth == maxDepth) {
				deepestNodes.add(root.getWord());
			}
			
			//recursively traverses the tree
			findDeepestWord(root.getLchild());
			findDeepestWord(root.getRchild());
			
			//decrements as we traverse upwards
			//no more nodes and we go 1 level up
			currentDepth--;
		}
	}
	
	//returns most frequent word
	public WordNode findMostFrequentWord(){
		return findMostFrequentWord(root);
	}
	
	//finds most frequent word by recursively traversing the 
	//tree and compares each nodes word instance count to the highest
	private WordNode findMostFrequentWord(WordNode root){
		if(root == null){
			return mostFrequentWord;
		}
		
		if(root.getWordInstanceCount() >= mostFrequentCount){
			mostFrequentWord = root;
			mostFrequentCount = root.getWordInstanceCount();
		}
			
		 findMostFrequentWord(root.getLchild());
		 findMostFrequentWord(root.getRchild());
	
		 return mostFrequentWord;
	}
	

	
 }
