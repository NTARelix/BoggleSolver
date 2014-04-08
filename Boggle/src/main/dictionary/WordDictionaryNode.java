package main.dictionary;

import java.util.HashMap;
import java.util.Map;

/**
 * Trie node containing a single letter, next letters, and whether this node
 * completes a word or not.
 * 
 * @author Kevin
 *
 */
class WordDictionaryNode
{
	private char letter;
	private Map<Character, WordDictionaryNode> nexts;
	private boolean isWord;
	
	/**
	 * Constructor
	 * 
	 * @param letter	Node's letter
	 * @param isWord	Whether current node finishes a word
	 */
	public WordDictionaryNode(char letter, boolean isWord)
	{
		this.letter = letter;
		this.nexts = new HashMap<Character, WordDictionaryNode>();
		this.isWord = isWord;
	}
	
	/**
	 * @return letter at current node
	 */
	public char getLetter()
	{
		return this.letter;
	}
	
	/**
	 * @return whether node completes a word
	 */
	public boolean isWord()
	{
		return this.isWord;
	}
	
	/**
	 * Determines whether the word prefix is contained within the subtree
	 * 
	 * @param search	search prefix
	 * @return			true if word found, false otherwise
	 */
	public boolean hasPrefix(String search)
	{
		return find(search) != null;
	}
	
	/**
	 * Determines whether the search term is contained within the subtree
	 * 
	 * @param search	search term
	 * @return			true if word found, false otherwise
	 */
	public boolean hasWord(String search)
	{
		Boolean found = find(search);
		return found != null && found.booleanValue();
	}
	
	/**
	 * Searches for a term and returns whether the term was found and whether
	 * the found term was a prefix or whole word.
	 * 
	 * @param search	search term
	 * @return			Boolean.TRUE if word
	 * 					Boolean.FALSE if prefix
	 * 					null if word not found
	 */
	protected Boolean find(String search)
	{
		if (search.length() == 0)
			return (Boolean) this.isWord;
		char firstLetter = search.charAt(0);
		if (!this.nexts.containsKey(firstLetter))
			return null;
		WordDictionaryNode next = this.nexts.get(firstLetter);
		String nextSearch = search.substring(1);
		return next.find(nextSearch);
	}
	
	/**
	 * Adds a word to the node and fills in sub-nodes with remaining characters
	 * in word.
	 * 
	 * @param word	Word to be added
	 */
	public void addWord(String word)
	{
		if (word.length() > 0)
		{
			char nextLetter = word.charAt(0);
			String restWord = word.substring(1);
			if (!this.nexts.containsKey(nextLetter))
			{
				boolean isWord = restWord.length() == 0;
				WordDictionaryNode nextNode = new WordDictionaryNode(nextLetter, isWord);
				this.nexts.put(nextLetter, nextNode);
			}
			this.nexts.get(nextLetter).addWord(restWord);
		}
	}
}
