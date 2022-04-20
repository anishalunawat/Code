import java.io.*;
import java.util.*;

class Tries {
	static TrieNode root;
	static class TrieNode {
		public boolean isEndWord;
		public TrieNode[] children;
		TrieNode() {
			isEndWord = false;
			children = new TrieNode[26];
			for(int i=0; i<26; i++)
			{
				children[i] = null;
			}
		}
	}
	
	static TrieNode createTrie() {
		return new TrieNode();
	}
	
	static void insert(String word) {
		if(root != null){
			TrieNode node=root;
			int length = word.length(), i=0;
			while(i<length) {
				int index = word.charAt(i)-'a';
				if(node.children[index] == null) {
					node.children[index] = new TrieNode();
				}
				node = node.children[index];
				i++;
			}
			node.isEndWord = true;
		}
	}
	
	static boolean search(String word) {
		if(root == null)
			return false;
		int length = word.length(), i=0;
		TrieNode node = root;
		while(i<length) {
			int index = word.charAt(i)-'a';
			if(node.children[index] == null)
				return false;
			node = node.children[index];
			i++;
		}
		
		if(node.isEndWord)
			return true;
		else
			return false;
		
	}
	
	static boolean startsWith(String word) {
		if(root == null)
			return false;
		int length = word.length(), i=0;
		TrieNode node = root;
		while(i<length) {
			int index = word.charAt(i)-'a';
			if(node.children[index] == null)
				return false;
			node = node.children[index];
			i++;
		}
		return true;
	}

	public static void main(String args[]) {
		root = createTrie();
		insert("anisha");
		if(search("anisha")) {
			System.out.println("Word Exist.");
		} else {
			System.out.println("Word do not Exist.");
		}
		
		if(startsWith("ania")) {
			System.out.println("Prefix Exist.");
		} else {
			System.out.println("Prefix do not Exist.");
		}
	
	}


}