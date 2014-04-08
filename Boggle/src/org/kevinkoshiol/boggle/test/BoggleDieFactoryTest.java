package org.kevinkoshiol.boggle.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.kevinkoshiol.boggle.BoggleDie;
import org.kevinkoshiol.boggle.BoggleDieFactory;

public class BoggleDieFactoryTest
{

	@Test
	public void testBoggleDieFactory()
	{
		int count = 100;
		BoggleDieFactory factory = new BoggleDieFactory(6, count);
		for (int i=0; i<count; i++)
			if (factory.get() == null)
				fail("Factory created premature null die on die number " + i);
		BoggleDie die = factory.get();
		if (die != null)
			fail("Factory created non-null die (" + die + ") after completion");
	}

}
