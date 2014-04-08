package org.kevinkoshiol.boggle.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.kevinkoshiol.boggle.BoggleDieFactory;
import org.kevinkoshiol.boggle.BoggleGrid;

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
