package test.boggle;

import static org.junit.Assert.*;
import main.boggle.BoggleDie;
import main.boggle.BoggleDieFactory;

import org.junit.Test;

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
