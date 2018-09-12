/* 
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
如果是则输出Yes,否则输出No。

假设输入的数组的任意两个数字都互不相同。 */

public class Solution {
	
    public boolean VerifySquenceOfBST(int[] sequence) {
        
        if ( sequence == null || sequence.length == 0 ) {
			return false;
		}
		
		return VerifySquenceOfBSTHelper(sequence, 0, sequence.length - 1);
    }
	
	private boolean VerifySquenceOfBSTHelper(int[] sequence, int startIndex, int endIndex) {
		
		if ( startIndex >= endIndex ) {
			return true;
		}
		
		int rootValue = sequence[endIndex];
		
		int i = 0;
		for (i = startIndex; i < endIndex; i++) {
			
			if (sequence[i] > rootValue) {
				break;
			}
		}
		
		int newStartIndex = i;
		for (; i < endIndex; i++) {
			
			if (sequence[i] < rootValue) {
				return false;
			}
		}
		
		return VerifySquenceOfBSTHelper(sequence, startIndex, newStartIndex - 1) 
		    && VerifySquenceOfBSTHelper(sequence, newStartIndex, endIndex - 1);
	}
}