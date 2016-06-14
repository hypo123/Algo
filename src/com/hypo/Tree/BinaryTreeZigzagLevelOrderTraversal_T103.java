package com.hypo.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.hypo.Utils.TreeNode;

//之字形层次遍历.
public class BinaryTreeZigzagLevelOrderTraversal_T103
{
    public List<List<Integer>> zigzagLevelOrder(TreeNode root)
    {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    	
    	if(root == null) return (ArrayList)res;
    	
    	queue.add(root);
    	int prev = 1;//上一层结点个数
    	int curr = 0;//当前层结点个数.
    	boolean flag = true;//层次遍历要从左到右，否则从右到左
    	int len = 1;
    	Stack<Integer> stack = new Stack<Integer>();
    	while(!queue.isEmpty())
    	{
    		TreeNode now = queue.poll();
    		
    		if(flag)//Zig顺序时
    		{
    			path.add(now.val);
    		}
    		else//Zig逆序时.
    		{
//    			path.add(len + prev , now.val );
    			stack.push(now.val);
    		}
    		
    		if(now.left != null) 
    		{
    			curr++;
    			queue.add(now.left);
    		}
    		if(now.right != null)
    		{
    			curr++;
    			queue.add(now.right);
    		}
    		
    		if(--prev == 0)//上一层结点处理完了
    		{
    			prev = curr;//下一层的几点个数确定，赋给prev
    			curr  = 0;
    			len = path.size();
    			if(flag) flag =false;
    			else //逆序时，要从stack中倒到path中.
    			{
    				flag = true;
    				while(!stack.isEmpty())
    				{
    					path.add(stack.pop());
    				}
    			}
    			res.add(new ArrayList<Integer>(path));
    			while(path.size() > 0) path.remove(path.size()-1);//清空path
    		}
    	}
        
        return (List)res;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		//建树
//	      1
//		 /  \
//	     2   3
//			/
//	       5
		TreeNode root = new TreeNode(1);
		TreeNode l11 = new TreeNode(2);//p
		TreeNode l12 = new TreeNode(3);
		root.left = l11;
		root.right = l12;
		TreeNode l21 = new TreeNode(5);//q
		l12.left = l21;
		
		BinaryTreeZigzagLevelOrderTraversal_T103 t103 = new BinaryTreeZigzagLevelOrderTraversal_T103();
		
		ArrayList<ArrayList<Integer>> print = (ArrayList)t103.zigzagLevelOrder(root);
		
		
		for(int i = 0 ; i < print.size() ; ++i)
		{
			ArrayList<Integer> mid = print.get(i);
			
			for(int j = 0 ; j < mid.size(); ++j)
			{
				System.out.print(mid.get(j)+" ");
			}
			System.out.println();
		}
	}

}
