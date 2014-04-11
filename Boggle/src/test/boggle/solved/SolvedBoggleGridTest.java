package test.boggle.solved;

import java.io.File;

import main.boggle.BoggleDieFactory;
import main.boggle.solved.SolvedBoggleGrid;

import org.junit.Test;

public class SolvedBoggleGridTest
{

	@Test
	public void testSolvedBoggleGrid()
	{
		int width = 4;
		int height = 4;
		SolvedBoggleGrid boggle = new SolvedBoggleGrid(
				new BoggleDieFactory(6, width * height),
				width, height,
				new File("data/nouns.txt")
		);
		boggle.print(System.out);
		if (boggle.getWordCount() == 0)
			System.out.println("No words found");
		for (int i=0; i<boggle.getWordCount(); i++)
		{
			String word = boggle.getWord(i);
			System.out.println(word);
		}
	}

}
