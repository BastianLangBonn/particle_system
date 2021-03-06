package common;

import java.awt.Color;
import java.awt.Graphics;

/**
 * A class representing a simple particle with a position, a velocity, a color
 * and a lifetime.
 * 
 * @author PaulPC
 * 
 */
public class Particle implements Drawable, Movable
{
	private static final int HEIGHT = 2;
	private static final int WIDTH = 2;
	private Velocity mVelocity;
	private Position mPosition;
	private Color mStartColor;
	private Color mEndColor;
	private Color mCurrentColor;
	private double mInitialLifeTime;
	private double mRemainingLifeTime;

	private Particle(final Builder aBuilder)
	{
		mVelocity = aBuilder.getVelocity();
		mPosition = aBuilder.mPosition;
		mStartColor = aBuilder.mStartColor;
		mEndColor = aBuilder.mEndColor;
		mInitialLifeTime = aBuilder.mLifeTime;
		mRemainingLifeTime = aBuilder.mLifeTime;
	}

	@Override
	public void update(final Force aForce, final double aTimeInMilliSeconds)
	{
		double timeInSeconds = aTimeInMilliSeconds / 1000;
		final Velocity velocityChange = aForce.over(timeInSeconds);
		mVelocity = mVelocity.add(velocityChange);
		final Position positionChange = mVelocity.over(timeInSeconds);
		mPosition = mPosition.add(positionChange);
		mRemainingLifeTime = getLifeTime() - aTimeInMilliSeconds;
		mCurrentColor = computeCurrentColor();
	}

	private Color computeCurrentColor()
	{
		final double lifeTimeRatio = 1 - mRemainingLifeTime / mInitialLifeTime;

		final int red = interpolateColorValue(mStartColor.getRed(), mEndColor.getRed(), lifeTimeRatio);
		final int green = interpolateColorValue(mStartColor.getGreen(), mEndColor.getGreen(), lifeTimeRatio);
		final int blue = interpolateColorValue(mStartColor.getBlue(), mEndColor.getBlue(), lifeTimeRatio);
		final int alpha = interpolateColorValue(mStartColor.getAlpha(), mEndColor.getAlpha(), lifeTimeRatio);

		return new Color(red, green, blue, alpha);
	}

	private int interpolateColorValue(int aStartValue, int aEndValue, final double aRatio)
	{
		int result = aStartValue + (int) ((aEndValue - aStartValue) * aRatio);
		if (result > 255)
		{
			return 255;
		}
		if (result < 0)
		{
			return 0;
		}
		return result;
	}

	@Override
	public void draw(final Graphics aGraphicsContext, final double aMagnifier)
	{
		int x = (int) (mPosition.getHorizontalPosition() * aMagnifier);
		int y = (int) (mPosition.getVerticalPosition() * aMagnifier);
		int width = (int) (WIDTH * aMagnifier);
		int height = (int) (HEIGHT * aMagnifier);

		aGraphicsContext.setColor(mCurrentColor);
		aGraphicsContext.fillArc(x, y, width, height, 0, 360);
	}

	/**
	 * @return the lifeTime
	 */
	public double getLifeTime()
	{
		return mRemainingLifeTime;
	}

	/**
	 * @return The {@link Position} of the {@link Particle}.
	 */
	public Position getPosition()
	{
		return mPosition;
	}

	/**
	 * BuilderClass for {@link Particle}'s
	 * 
	 * @author PaulPC
	 * 
	 */
	@SuppressWarnings(value =
	{ "javadoc" })
	public static class Builder
	{
		private final Velocity mVelocity;
		private final Position mPosition;
		private Color mStartColor = Color.black;
		private Color mEndColor = Color.black;
		private double mLifeTime = 5000;

		public Builder(final Velocity aVelocity, final Position aPosition)
		{
			mVelocity = aVelocity;
			mPosition = new Position(aPosition.getHorizontalPosition(), aPosition.getVerticalPosition());
		}

		public Particle build()
		{
			return new Particle(this);
		}

		public Builder lifeTime(final double aLifeTime)
		{
			mLifeTime = aLifeTime;
			return this;
		}

		public Velocity getVelocity()
		{
			return mVelocity;
		}

		public Builder startColor(final Color aStartColor)
		{
			mStartColor = aStartColor;
			return this;
		}

		public Builder endColor(final Color aEndColor)
		{
			mEndColor = aEndColor;
			return this;
		}
	}
}
