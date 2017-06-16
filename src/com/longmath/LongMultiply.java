package com.longmath;

import javax.swing.SwingUtilities;

import com.longmath.controller.DisplayController;
import com.longmath.view.Display;

public class LongMultiply {

	private DisplayController controller;

	public void start() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				try {
					Display display = new Display();
					controller = new DisplayController(display);
					display.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void main(String[] args) {
		new LongMultiply().start();
	}

}
