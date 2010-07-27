package com.github.mfs.crazyclick;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Robot;
import java.awt.event.InputEvent;

/**
 * 
 */

/**
 * @author Meisam Fathi Salmi
 * 
 */
public final class RefresherMainClass {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(final String[] args) throws Exception {
		final GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		final GraphicsDevice graphicsDevice = graphicsEnvironment
				.getDefaultScreenDevice();
		final Robot robot = new Robot(graphicsDevice);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		for (int waitTime = 10; waitTime >0 ; waitTime--) {
			System.out.printf("%d seconds to start...\n", waitTime);
			Thread.sleep(1000);
		}
		
		int clickCount = 0;
		final long startMillis = System.currentTimeMillis();
		while (++clickCount < 20000) {
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
		}
		final long endMillis = System.currentTimeMillis();
		long totalTime = endMillis - startMillis;
		System.out.printf("%d clicks in %d milli seconds (%f seconds)\n",clickCount, totalTime, totalTime/1000f);
		System.out.printf("That is %f clicks per second\n", ((clickCount  * 1000f) /totalTime ));
		
	}

}
