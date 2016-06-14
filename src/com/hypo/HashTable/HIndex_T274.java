package com.hypo.HashTable;

import java.util.Arrays;

public class HIndex_T274
{
    private int hIndex(int[] citations) 
    {
    	int len = citations.length;
    	if(len == 0) return 0;
    	
    	int[] arr = new int[len+1];
    	
    	for(int i = 0 ; i < len ; i++)
    	{
    		if(citations[i] >= len)
    		{
    			arr[len]++;
    		}
    		else
    		{
    			arr[citations[i]]++;
    		}
    	}
    	
    	if(arr[len] >= len) return len;
    	
    	for(int j = len-1 ; j >= 0 ; j--)
    	{
    		arr[j] += arr[j+1];
    		
    		if(arr[j] >= j)
    		{
    			return j;
    		}
    	}
    	
    	return 0;
    }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		HIndex_T274 t274 = new HIndex_T274();
		
		int[] citations = {3, 0, 6, 1, 5};
		int[] citations2 = {100};
		int[] citations3 = {0};
		int[] citations4 = {0,1};
		int[] citations5 = {11 ,15};
		
		System.out.println(t274.hIndex(citations));
	}

}
