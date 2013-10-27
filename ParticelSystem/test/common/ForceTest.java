package common;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ForceTest
{

	@DataProvider
	protected Object[][] someTestValues()
	{
		// xForce/yForce/Seconds/Expected Velocity
		return new Object[][]
		{
		{ 0, 0, 0, new Velocity(0, 0) },//
				{ 0, 0, 100, new Velocity(0, 0) }, //
				{ 10, 0, 0, new Velocity(0, 0) },//
				{ 10, 0, 10 } };
	}

	@Test(dataProvider = "someTestValues")
	public void over_someValues_computesCorrectResult(final double aXForce, final double aYForce, final double aTime, final Velocity aExpectedResult)
	{
		Force force = new Force(aXForce, aYForce);
		Velocity resultingVelocity = force.over(aTime);
		Assert.assertEquals(resultingVelocity, aExpectedResult, "Computed velocity is not correct.");
	}
}
