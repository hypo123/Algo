package com.hypo.Tree;

//将升序的数组转换为BST.
//分治法
public class ConvertSortedArraytoBST_T108
{
    private TreeNode sortedArrayToBST(int[] nums)
    {
        return toBST(0 , nums.length - 1 , nums);
    }
    
    private TreeNode toBST(int start , int end , int[] nums)
    {
    	if(start > end) return null;
    	
    	int mid = start + ((end - start)>>1);
    	
    	TreeNode node = new TreeNode(nums[mid]);
    	
    	node.left = toBST(start, mid-1, nums);
    	node.right = toBST(mid + 1, end, nums);
    	
    	return node;
    	
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,2,3,4,5,6,7};
		
		ConvertSortedArraytoBST_T108 t108 = new ConvertSortedArraytoBST_T108();
		
		TreeNode root = t108.sortedArrayToBST(nums);
		
		System.out.println(root.val);
	}

}
