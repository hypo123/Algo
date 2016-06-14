package com.hypo.Trie;

class TrieNode
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

public class Trie
{
	private TrieNode root;//根结点,根结点不放字符.

	public Trie()
	{
		root = new TrieNode();
	}

	// Inserts a word into the trie.
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

	// Returns if the word is in the trie.
	public boolean search(String word)
	{
		if(word == null) return false;
		
		TrieNode node = root;
		
		for(int i = 0;  i < word.length() ; i++)
		{
			char c = word.charAt(i);
			
			if(node.next[c - 'a'] == null)
			{
				return false;
			}
			else
			{
				node = node.next[c - 'a'];
			}
		}
		
		return node.getFlag();
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix)
	{
		TrieNode node = root;
		
		for(int i = 0 ; i < prefix.length() ; i++)
		{
			char c = prefix.charAt(i);
			
			if(node.next[c - 'a'] == null) return false;
			
			node = node.next[c - 'a'];
		}
			
		return true;
	}
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");