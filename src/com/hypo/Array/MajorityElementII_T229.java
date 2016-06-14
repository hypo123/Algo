package com.hypo.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定大小为n的数组，找出其中出现次数超过[n/3]次的元素 
//要求线性时间，空间复杂度O(1)
public class MajorityElementII_T229
{
	//暴力破解
    public List<Integer> majorityElement(int[] nums) //这个不是线性时间
    {
    	List<Integer> res = new ArrayList<Integer>();
    	int times = nums.length / 3 ;//数组元素小于3个是times = 0要特殊处理
    	
    	Arrays.sort(nums);//n*log(n) 改进的快速排序
    	
    	for(int i = 0 ; i < nums.length ;)
    	{
    		if(i + times < nums.length)
    		{
    			if(nums[i] == nums[i + times])
    			{
    				if(!res.contains(nums[i]))
					{
    					res.add(nums[i]);
					}
    				if(times == 0)//times = 0要特殊处理
    				{
    					i++;
    				}
    				else
    				{
    					i += times ;
    				}
    			}
    			else
    			{
    				i++;
    			}
    		}
    		else
    		{
    			break;
    		}
    	}
    	
    	return res;
    }
    
//  Majority Vote algorithm  //多数投票算法
    public List<Integer> majorityElement2(int[] nums)//O(n)时间,O(1)空间
    {
//    	多数投票算法
//    	数组中至多可能会有2个出现次数超过 [n/3] 的众数
       	List<Integer> res = new ArrayList<Integer>();
       	
    	int times = nums.length / 3 ;
       	
       	int n1 = 1 ; //候选众数1
       	int n2 = 1 ; //候选众数2
       	int c1 = 0;//候选众数1出现的次数
       	int c2 = 0;//候选众数2出现的次数
       	
       	for(int n : nums)//第一步：找出数组出现次数最多的两个数，即选出两个众数
       	{
       		if(n1 == n)
       		{
       			c1++;
       		}
       		else if(n2 == n)
       		{
       			c2++;
       		}
       		else if(c1 == 0)
       		{
       			n1 = n;
       			c1 = 1;
       		}
       		else if(c2 == 0)
       		{
       			n2 = n;
       			c2 = 1;
       		}
       		else
       		{
       			c1--;
       			c2--;
       		}
       	}
       	
//      第二步：判断两个众数出现的次数是否符合要求
       	int count1 = 0;//众数n1在数组中出现的次数
       	int count2 = 0;//众数n2在数组中出现的次数
       	
       	for(int m : nums)
       	{
       		if(m == n1)
       		{
       			count1++;
       		}
       		else if(m == n2)
       		{
       			count2++;
       		}
       	}
       	
       	if(count1 > times)
       	{
       		res.add(n1);
       	}
    	
       	if(count2 > times)
       	{
       		res.add(n2);
       	}
       	
    	return res;
    }
    
    
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		MajorityElementII_T229 t229 = new MajorityElementII_T229();
		
//		int[] nums = {1,1,1,1,1,2,2,2,2,2,2,2,2,2,2};
		int[] nums2 = {1,1,1,1,1,1,1};
		ArrayList<Integer> result = (ArrayList<Integer>)t229.majorityElement2(nums2);
		
		for(int i = 0 ;i < result.size() ;  i++)
		{
			System.out.println(result.get(i) + " ");
		}
	}

}
