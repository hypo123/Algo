package com.hypo.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/9/11.
 */

/**
 * 给定二叉树结点个数n,其值为1...n,给出不同的BST.
 */
public class UniqueBSTII
{
    private List<TreeNode> generateTrees(int n)
    {
        if(n == 0) return generate(1 , 0);

        return generate(1 , n);
    }

    private ArrayList<TreeNode> generate(int start , int end)
    {
        ArrayList<TreeNode> subTree = new ArrayList<TreeNode>();

        if(start > end)
        {
            subTree.add(null); //BUG,一开始直接return subTree.add(null),其实ArrayList的add方法返回值为boolean.
            return subTree;
        }

        for(int k = start ; k <= end ; ++k)//以k为根结点.
        {
            ArrayList<TreeNode> leftSubs = generate(start , k - 1);//左子树的所有形式
            ArrayList<TreeNode> rightSubs = generate(k + 1 , end); //右子树的所有形式.

            //由左子树.右子树和根节点组成一颗BST
            for(TreeNode left : leftSubs)
            {
                for(TreeNode right : rightSubs)
                {
                    TreeNode head = new TreeNode(k);

                    head.left = left;
                    head.right = right;

                    subTree.add(head);
                }
            }
        }
        return subTree;
    }


    public static void main(String[] args)
    {
        UniqueBSTII ubst2 = new UniqueBSTII();

        int n = 3;

        ArrayList<TreeNode> result =(ArrayList)ubst2.generateTrees(n);

        System.out.println(result.size());
    }
}

