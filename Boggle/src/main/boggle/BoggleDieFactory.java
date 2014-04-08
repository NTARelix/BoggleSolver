package main.boggle;

import java.util.Random;

public class BoggleDieFactory
{
	private static final String[] possibleSides = {
		"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
		"N", "O", "P", "Qu", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
	};
	
	private final BoggleDie[] dieBag;
	private int current;
	
	/**
	 * Preloads factory with given number of dice
	 * 
	 * @param sideCount	number of sides per die
	 * @param dieCount	number of dice to preload
	 */
	public BoggleDieFactory(final int sideCount, final int dieCount)
	{
		this.current = 0;
		dieBag = new BoggleDie[dieCount];
		for (int n=0; n<dieCount; n++)
		{
			String[] sides = new String[sideCount];
			for (int side=0; side<sideCount; side++)
				sides[side] = getRandomSide();
			dieBag[n] = new BoggleDie(sides);
		}
	}
	
	/**
	 * Takes and removes a single die from the factory
	 * 
	 * @return	Taken die
	 */
	public BoggleDie get()
	{
		if (this.current == this.dieBag.length)
			return null;
		else
		{
			BoggleDie die = dieBag[this.current];
			dieBag[this.current++] = null;
			return die;
		}
	}
	
	protected static String getRandomSide()
	{
		Random rand = new Random();
		return possibleSides[rand.nextInt(possibleSides.length)];
	}
}
