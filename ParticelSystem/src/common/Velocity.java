package common;

/**
 * A class representing an object's velocity in two-dimensional space.
 * 
 * @author PaulPC
 * 
 */
public class Velocity
{
	private double mHorizontalVelocity;
	private double mVerticalVelocity;

	/**
	 * @param aHorizontalVelocity
	 * @param aVerticalVelocity
	 */
	public Velocity(final double aHorizontalVelocity, final double aVerticalVelocity)
	{
		mHorizontalVelocity = aHorizontalVelocity;
		mVerticalVelocity = aVerticalVelocity;
	}

	/**
	 * @return the horizontalVelocity
	 */
	public double getHorizontalVelocity()
	{
		return mHorizontalVelocity;
	}

	/**
	 * @return the verticalVelocity
	 */
	public double getVerticalVelocity()
	{
		return mVerticalVelocity;
	}

	/**
	 * Applies a change in {@link Velocity} to the current value.
	 * 
	 * @param aVelocityChange
	 * @return The sum of two {@link Velocity}s as a new instance.
	 */
	public Velocity add(Velocity aVelocityChange)
	{
		double horizontalVelocity = mHorizontalVelocity + aVelocityChange.getHorizontalVelocity();
		double verticalVelocity = mVerticalVelocity + aVelocityChange.getVerticalVelocity();
		return new Velocity(horizontalVelocity, verticalVelocity);
	}

	/**
	 * Computes the resulting change in {@link Position} if applying a certain
	 * {@link Velocity} over a certain amount of time.
	 * 
	 * @param aSeconds
	 * @return The change in Position.
	 */
	public Position over(final double aSeconds)
	{
		final double horizontalPosition = getHorizontalVelocity() * aSeconds;
		final double verticalPosition = getVerticalVelocity() * aSeconds;
		return new Position(horizontalPosition, verticalPosition);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(mHorizontalVelocity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(mVerticalVelocity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Velocity other = (Velocity) obj;
		if (mHorizontalVelocity != other.mHorizontalVelocity)
			return false;
		if (mVerticalVelocity != other.mVerticalVelocity)
			return false;
		return true;
	}
}
