package test.dictionary;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import main.dictionary.WordDictionaryFile;

import org.junit.Test;

public class WordDictionaryFileTest
{
	private static File wordfile = new File("data/nouns.txt");
	private WordDictionaryFile wdf;
	
	public WordDictionaryFileTest()
	{
		this.wdf = new WordDictionaryFile(wordfile);
	}
	
	@Test
	public void testValidWords() throws FileNotFoundException
	{
		Scanner sc = new Scanner(wordfile);
		while (sc.hasNextLine())
			assertEquals(true, wdf.hasWord(sc.nextLine()));
		sc.close();
	}
	
	@Test
	public void testInvalidWords()
	{
		String[] invalids = {"engrish", "zoned", "englis"};
		for (String word : invalids)
			assertEquals(false, wdf.hasWord(word));
	}
	
	@Test
	public void testValidPrefixes()
	{
		String[] valids = {"dresser", "dresse", "dress", "dres", "d"};
		for (String prefix : valids)
			assertEquals(true, wdf.hasPrefix(prefix));
	}
	
	@Test
	public void testInvalidPrefixes()
	{
		String[] valids = {"bq", "dresserr", "coim", "cokn", "shpp"};
		for (String prefix : valids)
			assertEquals(false, wdf.hasPrefix(prefix));
	}
}
