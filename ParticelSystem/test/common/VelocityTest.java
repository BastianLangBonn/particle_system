package common;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Unit test for {@link Velocity}.
 * 
 * @author PaulPC
 * 
 */
public class VelocityTest
{
	@DataProvider
	protected Object[][] addTestValues()
	{
		return new Object[][]
		{
		{ new Velocity(0, 0), new Velocity(0, 0), new Velocity(0, 0) },//
				{ new Velocity(1, 0), new Velocity(0, 0), new Velocity(1, 0) },//
				{ new Velocity(0, 1), new Velocity(0, 0), new Velocity(0, 1) },//
				{ new Velocity(1, 1), new Velocity(0, 0), new Velocity(1, 1) },//
				{ new Velocity(0, 0), new Velocity(10, 0), new Velocity(10, 0) },//
				{ new Velocity(0, 0), new Velocity(0, 10), new Velocity(0, 10) },//
				{ new Velocity(0, 0), new Velocity(10, 10), new Velocity(10, 10) },//
				{ new Velocity(0, 0), new Velocity(0, -10), new Velocity(0, -10) },//
				{ new Velocity(0, 0), new Velocity(-10, 0), new Velocity(-10, 0) },//
				{ new Velocity(-10, 0), new Velocity(10, 0), new Velocity(0, 0) },//
		};
	}

	/**
	 * Validates that the sum is computed correctly.
	 * 
	 * @param aInitialValue
	 * @param aValueToAdd
	 * @param aExpectedResult
	 */
	@Test(dataProvider = "addTestValues")
	public void add_variousValues_returnCorrectSum(final Velocity aInitialValue, final Velocity aValueToAdd, final Velocity aExpectedResult)
	{
		// Act
		final Velocity result = aInitialValue.add(aValueToAdd);

		// Assert
		Assert.assertEquals(aExpectedResult, result, "Sum");
	}
}
