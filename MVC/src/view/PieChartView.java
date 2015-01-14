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

public class PieChartView extends javax.swing.JPanel implements ActionListener {
	private ChartModel model;

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

		drawPie((Graphics2D) g, getBounds(), model.getData(), model.getDataName());
//		if (model.isFilled()) {
//			g.fillOval(xCenter - radius, yCenter - radius, 2 * radius,
//					2 * radius);
//
//		} else {
//			g.drawOval(xCenter - radius, yCenter - radius, 2 * radius,
//					2 * radius);
//		}
		
//		drawBar((Graphics2D) g, getBounds(), model.getData(), model.getDataName());

	}
	public void drawPie(Graphics2D g, Rectangle area, double data[], String dataNames[]) {
		double total = 0.0D;
		for (int i=0; i<data.length; i++) {
			total += model.getData()[i];
		}
		System.out.println("total:" + total);
		double curValue = 0.0D;
		int startAngle = 0;
		for(int i=0; i<data.length; i++) {
			startAngle = (int) (curValue * 360 / total);
			int arcAngle = (int) (model.getData()[i] * 360 / total);
			g.setColor(model.getColors()[i]);
			g.fillArc(area.x + area.width/2 , area.y, area.width/2, area.height, 
			         startAngle, arcAngle);
			//the text is not displayed properly
			g.setColor(Color.black);
			curValue += model.getData()[i];
			g.drawString(model.getDataName()[i], (int) curValue, arcAngle + 60 );
//			System.out.println("Areax: " + area.x + " areaY: " + area.y);
//			System.out.println("width: " + area.width + " height: " + area.height);
			System.out.println("startAngle: " + startAngle + " arcAngle: " + arcAngle  + " curValue: " + curValue);
			
		}

	}

}
