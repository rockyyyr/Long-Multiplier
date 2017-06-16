
package com.longmath.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.longmath.model.Multiplier;
import com.longmath.model.Result;
import com.longmath.view.Display;
import com.longmath.view.MathTableModel;

public class DisplayController {

	private Multiplier multiplier;
	private Display display;

	public DisplayController(Display display) {
		this.display = display;
		initDisplay();
	}

	private void initDisplay() {
		display.setButtonActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String a = display.getFieldAText();
				String b = display.getFieldBText();

				Result result = Multiplier.longMultiply(a, b);

				display.setTableModel(new MathTableModel(result.getTable()));
				display.setTotalLabel(result.getTotal());

				display.pack();
			}

		});
	}

}
