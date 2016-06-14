package com.hypo.Trie;

class TrieTree
{
	private TrieNode root;//根结点

	private boolean flag;//为本题加的变量，标记查找是否成功.
	
	public TrieTree()
	{
		root = new TrieNode();
	}
	
	//向Trie树中插入word
	public void insert(String word)
	{
		TrieNode node = root;
		
		for(int i = 0 ; i < word.length() ; i++)
		{
			char c = word.charAt(i);
			
			if(node.next[c - 'a'] == null)
			{
				TrieNode newnode= new TrieNode();
				newnode.setVal(c);
				node.next[c - 'a'] = newnode;
			}
			
			node = node.next[c - 'a'];
		}
		node.setFlag(true);
	}
	
	//搜索Trie树中是否含有该word
	public boolean search(String word)
	{
		if(word == null) return false;
		
		TrieNode node = root;
		
	    bfs(root , 0 , word);
	    
	    return this.flag;
	}
	
	//遇到搜索串中含有"."时需宽搜
	private void bfs(TrieNode node, int index , String word) 
	{
		if(index == word.length())
		{
			if((node.getVal() == word.charAt(index-1) && node.getFlag()) 
					|| ((word.charAt(index-1) == '.') && node.getFlag()))
			{
				this.flag = true;
			}
			return;
		}
		
		char c = word.charAt(index);
		
		if(c == '.')
		{
			for(int i = 0 ; i < node.next.length ; i++)
			{
				if(node.next[i] != null)
				{
					bfs(node.next[i] , index + 1 , word );
				}
			}
		}
		else
		{
			if(node.next[c - 'a'] == null)//c-'a'为next数组的下标
			{
				return;
			}
			else
			{
				bfs(node.next[c - 'a'] , index + 1 , word );
			}
		}
		
		return;
	}

	private class TrieNode
	{
		private static final int R = 26;
		
		private char val;
		
		private boolean flag;//是否有单词在此结点结束
		
		public TrieNode[] next;
		
		// Initialize your data structure here.
		public TrieNode()
		{
			next = new TrieNode[R];
		}
		
		public char getVal()
		{
			return val;
		}
		
		public void setVal(char val)
		{
			this.val = val;
		}
		
		public boolean getFlag()
		{
			return flag;
		}
		
		public void setFlag(boolean flag)
		{
			this.flag = flag;
		}
	}
}


//设计题
public class WordDictionary 
{
	TrieTree trietree;
	
	public WordDictionary()
	{
		trietree = new TrieTree();
	}
	
	//向trie树中添加word
    public void addWord(String word)
    {
        trietree.insert(word);
    }

    //搜索串中"."代表任意字母
    public boolean search(String word) 
    {
        return trietree.search(word);
    }
    
    public static void main(String[] args)
	{
    	WordDictionary wordDictionary = new WordDictionary();
    	
    	wordDictionary.addWord("word");
    	
    	System.out.println(wordDictionary.search("...d"));
	}
    
}
