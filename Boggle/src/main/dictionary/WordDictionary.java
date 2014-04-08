package main.dictionary;

/**
 * Container for possible words in boggle game.
 * 
 * @author Kevin
 *
 */
public class WordDictionary
{
	private final WordDictionaryNode start;
	
	/**
	 * Constructor
	 */
	public WordDictionary()
	{
		start = new WordDictionaryNode((char) 0, false);
	}
	
	/**
	 * Adds a word to the dictionary
	 * 
	 * @param word	word to add
	 */
	public void addWord(final String word)
	{
		this.start.addWord(word.toLowerCase());
	}
	
	/**
	 * Returns whether the dictionary contains a word or not.
	 * 
	 * @param word	search word
	 * @return		true if word found, false otherwise
	 */
	public boolean hasWord(final String word)
	{
		return this.start.hasWord(word.toLowerCase());
	}
	
	/**
	 * Returns whether the dictionary contains a word prefix or not.
	 * 
	 * @param prefix	search prefix
	 * @return			true if prefix found, false otherwise
	 */
	public boolean hasPrefix(final String prefix)
	{
		return this.start.hasPrefix(prefix.toLowerCase());
	}
}
