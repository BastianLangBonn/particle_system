package common;

/**
 * A set of objects that change their behavior given time and {@link ForceTest}.
 * 
 * @author PaulPC
 * 
 */
public interface Movable
{
	/**
	 * A method that applies force over time to an object to affect its current
	 * velocity and position.
	 * 
	 * @param aForce
	 * @param aTime
	 */
	public void update(Force aForce, double aTime);
}
