package main.boggle;

import java.util.Random;

public class BoggleDie
{
	private final String[] sides;
	private int upIndex;
	
	public BoggleDie(final String[] sides)
	{
		this.sides = sides.clone();
		this.upIndex = 0;
	}
	
	/**
	 * Randomizes the upward facing side of the die
	 * 
	 * @return New upward-facing side
	 */
	public String roll()
	{
		Random rand = new Random();
		this.upIndex = rand.nextInt(this.sides.length);
		return getUp();
	}
	
	/**
	 * @return Upward facing side
	 */
	public String getUp()
	{
		return this.sides[this.upIndex];
	}
	
	@Override
	public String toString()
	{
		return getUp();
	}
}
