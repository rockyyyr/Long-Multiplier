
package com.longmath.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.miginfocom.swing.MigLayout;

/**
 * Display.
 * 
 */
@SuppressWarnings("serial")
public class Display extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldB;
	private JTextField textFieldA;
	private JTable table;
	private JButton multiply;
	private JSeparator separator_1;
	private JLabel totalLabel;
	private DefaultTableCellRenderer rightRenderer;
	private Font font;
	private JButton clearButton;

	/**
	 * Create the frame.
	 */
	public Display() {
		setTitle("Long Multiplication");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][][][][][][][][][][][][grow]", "[][][grow]"));

		font = new Font("Arial", Font.PLAIN, 24);

		buildUI();
	}

	public void setButtonActionListener(ActionListener actionListener) {
		multiply.addActionListener(actionListener);
	}

	public String getFieldAText() {
		return textFieldA.getText();
	}

	public String getFieldBText() {
		return textFieldB.getText();
	}

	public void setTableModel(TableModel tableModel) {
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
	}

	public void setTotalLabel(String total) {
		totalLabel.setText(total);
	}

	private void buildUI() {
		textFieldA = new JTextField();
		textFieldA.setFont(font);
		textFieldA.addKeyListener(new DisplayKeyListener());
		textFieldA.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(textFieldA, "cell 15 0,growx");
		textFieldA.setColumns(20);

		multiply = new JButton("Multiply");
		contentPane.add(multiply, "cell 1 1 11 1,growx");

		JLabel lblX = new JLabel("X");
		contentPane.add(lblX, "cell 13 1");

		textFieldB = new JTextField();
		textFieldB.addKeyListener(new DisplayKeyListener());
		textFieldB.setFont(font);
		textFieldB.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(textFieldB, "flowy,cell 15 1,growx");
		textFieldB.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.DARK_GRAY);
		contentPane.add(separator, "cell 15 1,growx");

		rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);

		clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textFieldA.setText("");
				textFieldB.setText("");
				table.setModel(new DefaultTableModel());
				totalLabel.setText("Total");
			}
		});

		contentPane.add(clearButton, "cell 1 2 11 1,growx,aligny bottom");

		table = new JTable();
		table.setFont(font);
		table.setRowHeight(28);
		contentPane.add(table, "flowy,cell 15 2,growx,aligny top");

		separator_1 = new JSeparator();
		contentPane.add(separator_1, "cell 15 2");

		totalLabel = new JLabel("Total");
		totalLabel.setFont(font);
		totalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(totalLabel, "cell 15 2,growx");
	}

	public class DisplayKeyListener implements KeyListener {

		/*
		 * (non-Javadoc)
		 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
		 */
		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_ENTER:
				multiply.doClick();
				break;
			case KeyEvent.VK_ESCAPE:
				clearButton.doClick();
				break;
			}
		}

		/*
		 * (non-Javadoc)
		 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
		 */
		@Override
		public void keyReleased(KeyEvent arg0) {
		}

		/*
		 * (non-Javadoc)
		 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
		 */
		@Override
		public void keyTyped(KeyEvent arg0) {
		}

	}

}
