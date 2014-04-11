package main.boggle.solved;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import main.boggle.BoggleDieFactory;
import main.boggle.BoggleGrid;
import main.dictionary.WordDictionaryFile;

/**
 * A grid containing boggle dice and a sorted list of every word found on the
 * grid from a given dictionary.
 * 
 * @author Kevin
 *
 */
public class SolvedBoggleGrid extends BoggleGrid
{
	private WordDictionaryFile wordDict;
	private List<String> foundWords;
	
	/**
	 * Constructor
	 * 
	 * @param factory	die factory used to populate grid
	 * @param width		width of grid
	 * @param height	height of grid
	 * @param wordFile	file containing dictionary words for lookups
	 */
	public SolvedBoggleGrid(BoggleDieFactory factory, int width, int height,
			                File wordFile)
	{
		super(factory, width, height);
		this.wordDict = new WordDictionaryFile(wordFile);
		this.foundWords = new ArrayList<String>();
		this.solve();
	}
	
	/**
	 * Searches for all words on grid which are stored in dictionary
	 */
	private void solve()
	{
		boolean[][] visited = new boolean[this.getWidth()][this.getHeight()];
		for (int x=0; x<this.getWidth(); x++)
			for (int y=0; y<this.getHeight(); y++)
				this.traverseGrid("", x, y, visited);
		Collections.sort(this.foundWords);
	}
	
	/**
	 * Recursive traversal of the boggle grid for finding words. Passes string
	 * of current path up to previous node
	 * 
	 * @param prevString	string of current path up to previous node
	 * @param currentx		current x position on grid
	 * @param currenty		current y position on grid
	 * @param visited		boolean cell visitation matrix
	 */
	private void traverseGrid(final String prevString,
							  final int currentx, final int currenty,
							  boolean[][] visited)
	{
		if (currentx < 0 || currentx >= this.getWidth() ||
					currenty < 0 || currenty >= this.getHeight()
					|| visited[currentx][currenty])
			return;
		visited[currentx][currenty] = true;
		String currentString = prevString +
							   this.get(currentx, currenty).getUp();
		if (this.wordDict.hasWord(currentString))
			this.foundWords.add(currentString);
		if (this.wordDict.hasPrefix(currentString))
			for (int dx=-1; dx<=1; dx++)
				for (int dy=-1; dy<=1; dy++)
					this.traverseGrid(currentString, currentx + dx,
									  currenty + dy, visited);
		visited[currentx][currenty] = false;
	}
	
	/**
	 * Shakes boggle grid, moving dice randomly and re-rolling each die
	 */
	@Override
	public void shake()
	{
		super.shake();
		this.foundWords.clear();
		this.solve();
	}
	
	/**
	 * @return	number of words found
	 */
	public int getWordCount()
	{
		return this.foundWords.size();
	}
	
	/**
	 * Returns the found word at the given position within the found word list
	 * 
	 * @param index	position of word
	 * @return	word located at given position
	 */
	public String getWord(int index)
	{
		return this.foundWords.get(index);
	}
}
