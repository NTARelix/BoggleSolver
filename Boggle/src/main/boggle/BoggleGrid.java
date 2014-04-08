package main.boggle;

import java.io.PrintStream;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * A grid containing Boggle dice
 * 
 * @author Kevin
 *
 */
public class BoggleGrid
{
	private BoggleDie[][] dice;
	
	/**
	 * Constructor
	 * 
	 * @param factory	die factory used to populate grid
	 * @param width		width of grid; must be positive integer
	 * @param height	height of grid; must be positive integer
	 */
	public BoggleGrid(BoggleDieFactory factory, int width, int height)
	{
		this.dice = new BoggleDie[width][height];
		for (int x=0; x<width; x++)
			for (int y=0; y<height; y++)
				this.dice[x][y] = factory.get();
	}
	
	/**
	 * Retrieves die at given position on grid
	 * 
	 * @param 	x	grid's x position
	 * @param 	y grid's y position
	 * @return	die at given position
	 */
	public BoggleDie get(int x, int y)
	{
		return this.dice[x][y];
	}
	
	/**
	 * Shakes board, mixing up and re-rolling each existing die on the grid
	 */
	public void shake()
	{
		// Empties grid into List and shuffles List
		List<BoggleDie> upInTheAir = new LinkedList<BoggleDie>();
		for (int x=0; x<this.dice.length; x++)
			for (int y=0; y<this.dice[0].length; y++)
				upInTheAir.add(this.dice[x][y]);
		Collections.shuffle(upInTheAir);
		// Put dice back into grid and roll each die
		for (int x=0; x<this.dice.length; x++)
			for (int y=0; y<this.dice[0].length; y++)
			{
				BoggleDie die = upInTheAir.remove(0);
				die.roll();
				this.dice[x][y] = die;
			}
	}
	
	/**
	 * @return	grid width
	 */
	public int getWidth()
	{
		return this.dice.length;
	}
	
	/**
	 * @return	grid height
	 */
	public int getHeight()
	{
		return this.dice[0].length;
	}
	
	/**
	 * Prints logical representation to a PrintStream
	 * 
	 * @param stream	output stream
	 */
	public void print(PrintStream stream)
	{
		for (int row=0; row<this.getHeight(); row++)
		{
			BoggleDie firstDie = this.dice[0][row];
			String out = String.format("%-2s", firstDie);
			stream.print(out);
			for (int col=1; col<this.getWidth(); col++)
			{
				BoggleDie die = this.get(col, row);
				out = String.format(" %-2s", die.getUp());
				stream.print(out);
			}
			stream.print("\n");
		}
	}
}
