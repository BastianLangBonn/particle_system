package common;

/**
 * A class representing the position of an object in a two-dimensional space.
 * 
 * @author PaulPC
 * 
 */
public class Position
{
	private double mVerticalPosition;
	private double mHorizontalPosition;

	/**
	 * @param aHorizontalPosition
	 * @param aVerticalPosition
	 */
	public Position(final double aHorizontalPosition, final double aVerticalPosition)
	{
		mVerticalPosition = aVerticalPosition;
		mHorizontalPosition = aHorizontalPosition;
	}

	/**
	 * @return the verticalPosition
	 */
	public double getVerticalPosition()
	{
		return mVerticalPosition;
	}

	/**
	 * @return the horizontalPosition
	 */
	public double getHorizontalPosition()
	{
		return mHorizontalPosition;
	}

	/**
	 * Computes the sum of the current {@link Position} and the given one.
	 * 
	 * @param aPositionChange
	 *            Value to be added.
	 * @return The sum of the two {@link Position}s as a new instance.
	 */
	public Position add(final Position aPositionChange)
	{
		double horizontalPosition = mHorizontalPosition + aPositionChange.getHorizontalPosition();
		double verticalPosition = mVerticalPosition + aPositionChange.getVerticalPosition();
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
		temp = Double.doubleToLongBits(mHorizontalPosition);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(mVerticalPosition);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object aObject)
	{
		if (this == aObject)
			return true;
		if (aObject == null)
			return false;
		if (getClass() != aObject.getClass())
			return false;
		final Position other = (Position) aObject;
		if (Double.doubleToLongBits(mHorizontalPosition) != Double.doubleToLongBits(other.mHorizontalPosition))
			return false;
		if (Double.doubleToLongBits(mVerticalPosition) != Double.doubleToLongBits(other.mVerticalPosition))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Position [mVerticalPosition=" + mVerticalPosition + ", mHorizontalPosition=" + mHorizontalPosition + "]";
	}
}
