package view;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import model.ChartModel;

public class MainView extends javax.swing.JPanel implements ActionListener {
	private ChartModel model;
	private PieChartView pieView;
	private BarChartView barView;
	public void actionPerformed(ActionEvent actionEvent) {
		repaint();
	}

	/** Set a model */
	public void setModel(ChartModel newModel) {
		model = newModel;

		if (model != null)
			// Register the view as listener for the model
			model.addActionListener(this);

		repaint();
	}

	public ChartModel getModel() {
		return model;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// setLayout(new FlowLayout());
		if (model == null)
			return;
		g.setColor(model.getColor());
		int xCenter = getWidth() / 2;
		int yCenter = getHeight() / 2;
		int radius = (int) model.getRadius();

		pieView.drawPie((Graphics2D) g, getBounds(), model.getData(), model.getDataName());
		
		barView.drawBar((Graphics2D) g, getBounds(), model.getData(), model.getDataName());

	}

	
	
	
	


}
