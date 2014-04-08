package test.boggle;

import main.boggle.BoggleDieFactory;
import main.boggle.BoggleGrid;

import org.junit.Test;

public class BoggleGridTest
{

	@Test
	public void test()
	{
		int width = 4;
		int height = 4;
		BoggleDieFactory factory = new BoggleDieFactory(6, width * height);
		BoggleGrid boggle = new BoggleGrid(factory, width, height);
		boggle.print(System.out);
	}

}
