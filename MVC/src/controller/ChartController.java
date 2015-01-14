package controller;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import model.ChartModel;

public class ChartController extends JPanel {
	private ChartModel model;
	private JTextField jtfRadius = new JTextField();
	private JComboBox jcboFilled = new JComboBox(new Boolean[] {
			new Boolean(false), new Boolean(true) });

	public JComboBox jcboColor = new JComboBox(new Color[] { Color.RED,
			Color.YELLOW, Color.GREEN, Color.BLUE, Color.CYAN, Color.MAGENTA,
			Color.orange, Color.PINK, Color.DARK_GRAY });

	// Color[] c1 = {Color.RED,Color.WHITE,Color.BLUE};
	/** Creates new form CircleController */
	public ChartController() {
		// Panel to group labels
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(3, 1));
		panel1.add(new JLabel("Radius"));
		panel1.add(new JLabel("Filled"));
		panel1.add(new JLabel("Color"));

		// Panel to group text field, combo box, and another panel
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(3, 1));
		panel2.add(jtfRadius);
		panel2.add(jcboFilled);
		panel2.add(jcboColor);

		setLayout(new BorderLayout());
		add(panel1, BorderLayout.WEST);
		add(panel2, BorderLayout.CENTER);

		// Register listeners
		jtfRadius.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (model == null)
					return; // No model associated yet. Do nothing
				model.setRadius(new Double(jtfRadius.getText()).doubleValue());
				System.out.println("Radius: "
						+ new Double(jtfRadius.getText()).doubleValue());
			}
		});
		jcboFilled.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (model == null)
					return; // No model associated yet. Do nothing
				model.setFilled(((Boolean) jcboFilled.getSelectedItem())
						.booleanValue());
			}
		});

		jcboColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (model == null)
					return; // No model associated yet. Do nothing
				model.setColor((Color) jcboColor.getSelectedItem());
			}
		});

	}

	public void setModel(ChartModel newModel) {
		model = newModel;
	}

	public ChartModel getModel() {
		return model;
	}

	public JComboBox getJcboColor() {
		return jcboColor;
	}

	public void setJcboColor(JComboBox jcboColor) {
		this.jcboColor = jcboColor;
	}
	
	
}
