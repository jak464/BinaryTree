
public class WordNode {

	private String word;
	private int wordInstanceCount;
	private WordNode lchild;
	private WordNode rchild;
	
	public WordNode() {
		lchild = null;
		rchild = null;
	}
	
	public String getWord() {
		return word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public WordNode getLchild() {
		return lchild;
	}
	
	public void setLchild(WordNode lchild) {
		this.lchild = lchild;
	}
	
	public WordNode getRchild() {
		return rchild;
	}
	
	public void setRchild(WordNode rchild) {
		this.rchild = rchild;
	}

	public int getWordInstanceCount() {
		return wordInstanceCount;
	}

	public void setWordInstanceCount(int wordInstanceCount) {
		this.wordInstanceCount = wordInstanceCount;
	}

}
