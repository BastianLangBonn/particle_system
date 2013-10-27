package common;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Unit tests for {@link Position}.
 * 
 * @author PaulPC
 * 
 */
public class PositionTest
{
	@DataProvider
	protected Object[][] addTestValues()
	{
		return new Object[][]
		{
		{ new Position(0, 0), new Position(0, 0), new Position(0, 0) },//
				{ new Position(1, 0), new Position(0, 0), new Position(1, 0) },//
				{ new Position(0, 1), new Position(0, 0), new Position(0, 1) },//
				{ new Position(1, 1), new Position(0, 0), new Position(1, 1) },//
				{ new Position(0, 0), new Position(10, 0), new Position(10, 0) },//
				{ new Position(0, 0), new Position(0, 10), new Position(0, 10) },//
				{ new Position(0, 0), new Position(10, 10), new Position(10, 10) },//
				{ new Position(0, 0), new Position(0, -10), new Position(0, -10) },//
				{ new Position(0, 0), new Position(-10, 0), new Position(-10, 0) },//
				{ new Position(-10, 0), new Position(10, 0), new Position(0, 0) },//
		};
	}

	/**
	 * Validates that the sum of two {@link Position}s is computed correctly.
	 * 
	 * @param aInitialPosition
	 * @param aPositionChange
	 * @param aExpectedResult
	 */
	@Test(dataProvider = "addTestValues")
	public void add_givenValues_returnsCorrectPosition(final Position aInitialPosition, final Position aPositionChange, final Position aExpectedResult)
	{
		// Act
		final Position result = aInitialPosition.add(aPositionChange);

		Assert.assertEquals(aExpectedResult, result, "Sum of both positions expected to be");
	}
}
