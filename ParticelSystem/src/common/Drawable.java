package common;
import java.awt.Graphics;

/**
 * A set of objects that provide a method to get drawn to a given context.
 * 
 * @author PaulPC
 * 
 */
public interface Drawable
{
	/**
	 * Draws the object to the given {@link Graphics} context.
	 * 
	 * @param aGraphicsContext
	 * @param aMagnifier
	 *            A multiplier to adjust sizes and dimensions to the current
	 *            screen.
	 */
	public void draw(Graphics aGraphicsContext, double aMagnifier);
}
