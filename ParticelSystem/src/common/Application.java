package common;

import display.FrameMain;
import display.Scene;

public class Application
{
	public static void main(String[] args) throws InterruptedException
	{
		Scene scene = new Scene();
		FrameMain frameMain = new FrameMain(scene);
		long startTime = System.currentTimeMillis();
		while (true)
		{
			long currentTimeMillis = System.currentTimeMillis();
			double timeIntervall = currentTimeMillis - startTime;
			startTime = currentTimeMillis;
			scene.update(timeIntervall);
			frameMain.mPanelMain.repaint();
			Thread.sleep(50);
		}
	}
}
