package common;

/**
 * A Class representing a two-dimensional (physical) force.
 * 
 * @author PaulPC
 * 
 */
public class Force
{
	private final double mHorizontalForce;
	private final double mVerticalForce;

	/**
	 * @param aHorizontalForce
	 * @param aVerticalForce
	 */
	public Force(final double aHorizontalForce, final double aVerticalForce)
	{
		mHorizontalForce = aHorizontalForce;
		mVerticalForce = aVerticalForce;
	}

	/**
	 * @return the mHorizontalForce
	 */
	public double getHorizontalForce()
	{
		return mHorizontalForce;
	}

	/**
	 * @return the verticalForce
	 */
	public double getVerticalForce()
	{
		return mVerticalForce;
	}

	/**
	 * Computes the {@link Velocity} resulting of applying this amount of
	 * {@link ForceTest} over a given amount of time.
	 * 
	 * @param aSeconds
	 * @return A new instance of {@link Velocity}.
	 */
	public Velocity over(final double aSeconds)
	{
		final double horizontalVelocity = getHorizontalForce() * aSeconds;
		final double verticalVelocity = getVerticalForce() * aSeconds;
		return new Velocity(horizontalVelocity, verticalVelocity);
	}
}
