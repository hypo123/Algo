package com.hypo.Tree;

/**
 * Created by Administrator on 2015/8/31.
 */

/**
 * 给定二叉树结点个数n,其值为1...n,判断有多少个不同的BST.
 *
 * 以i为根节点的树，其左子树由[1,i-1]构成，其右子树有[i+1,n]构成.
 *
 * 以i为根节点的BST的个数等于左子树的个数乘以右子树的个数.
 *
 * 递推公式：f(i) = 求和f(k-1)*f(i-k)(k从1到i的)
 *
 * 问题划归为一维动态规划.
 *
 * 如果数组有两个元素1,2，那么f[2] = f[0] * f[1] , //以1为根的情况
 *                              + f[1] * f[0] , //以2为根的情况.
 * 再看3个元素的数组，不同BST的个数：
 *                         f[3] = f[0] * f[2] , //1为根
 *                              + f[1] * f[1] , //2为根
 *                              + f[2] * f[0] , //3为根.
 *
 */
public class UniqueBST
{
    public int numTrees(int n)
    {
        int[] f = new int[n+1];

        f[0] = 1;//数组为空，只有一种BST，即空树，f[0]=1
        f[1] = 1;//数组仅有一个元素，只有一种BST，单个结点,f[1]=1

        for(int i = 2 ; i <= n ; ++i)
        {
            for(int k = 1;  k <= i ; ++k)//分别以1到i为根结点.
            {
                f[i] += f[k - 1] * f[i - k];
            }
        }
        return f[n];
    }

    public static void main(String[] args)
    {
        UniqueBST ubst = new UniqueBST();

        int n = 3;

        System.out.println(ubst.numTrees(n));
    }
}