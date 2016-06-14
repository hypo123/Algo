package com.hypo.Tree;

import java.util.ArrayList;
import java.util.Stack;

public class RecoverBST_T99
{
//方案一：使用单栈来实现中序遍历，然后得到错误的两个结点.空间复杂度O(n)-------------------------------------------------------
    private void recoverTree(TreeNode root) 
    {
        ArrayList<TreeNode> path = new ArrayList<TreeNode>();
        Stack<TreeNode> sta = new Stack<TreeNode>();
        
        TreeNode node = root;
        
        while(!sta.isEmpty() || node != null)
        {
        	if(node != null)
        	{
        		sta.push(node);
        		node = node.left;
        	}
        	else
        	{
        		node = sta.pop();
        		path.add(node);
        		node = node.right;
        	}
        }
        
        int previndex = -1;
        int lastindex = -1;
        
        for(int i = 0 ; i < path.size()-1; ++i)
        {
        	if(path.get(i).val > path.get(i+1).val)
        	{
        		previndex = i;
        		break;
        	}
        }
        
        for(int i = path.size()-1 ; i >= 1 ; --i)
        {
        	if(path.get(i).val < path.get(i-1).val)
        	{
        		lastindex = i;
        		break;
        	}
        }
        
        TreeNode prevError = path.get(previndex);
        TreeNode lastError = path.get(lastindex);
        
        int temp = prevError.val;
        prevError.val = lastError.val;
        lastError.val = temp;
        
    }
//-----------------------------------------------------------------------------------------
    
//方案二： 如果要使用常数空间实现，则需使用Morris中序遍历.---------------------------------------------------
    
    
    
    
// ----------------------------------------------------------------------------------------   
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
