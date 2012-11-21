
public class Solution {
	int right;
	int left;
	int rot;
	
	public Solution(int right, int left, int rot){
		this.right = right;
		this.left = left;
		this.rot = rot;
	}
	
	public String toString(){
		return "rotate="+rot+", left="+left+", right="+right+", drop";
	}
}
