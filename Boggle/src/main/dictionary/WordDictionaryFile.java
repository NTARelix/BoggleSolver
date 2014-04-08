package main.dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordDictionaryFile extends WordDictionary
{
	public WordDictionaryFile(File file)
	{
		super();
		Scanner sc;
		try
		{
			sc = new Scanner(file);
			String word;
			while (sc.hasNextLine())
			{
				word = sc.nextLine();
				this.addWord(word);
			}
			sc.close();
		}
		catch (FileNotFoundException e)
		{ }
	}
}
