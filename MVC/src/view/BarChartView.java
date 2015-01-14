package view;



import java.awt.*;
import java.awt.event.*;

import model.ChartModel;

public class BarChartView extends javax.swing.JPanel
    implements ActionListener {
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
//    setLayout(new FlowLayout());
    if (model == null) return;

    g.setColor(model.getColor());


//    if (model.isFilled()) {
//      g.fillOval(xCenter - radius, yCenter - radius,
//        2 * radius, 2 * radius);
//    }	
//    else {
//      g.drawOval(xCenter - radius, yCenter - radius,
//        2 * radius, 2 * radius);
//    }
    
      drawBar((Graphics2D) g, getBounds(), model.getData(), model.getDataName());
//      g.drawString("CS", 10, 10);
//      
//      g.fillRect(10, 10, 20, 150);
  }
  
  public void drawBar(Graphics2D g, Rectangle area, double data[], String dataNames[]){
		 
		double total = 0.0D;
		for (int i=0; i<data.length; i++) {
			total += model.getData()[i];
		}
		
		System.out.println("total:" + total);
		double curValue = 0.0D;
		int startAngle = 100;
		for(int i=0; i<data.length; i++) {
			startAngle = (int) (curValue * 360 / total);
			int barAngle = (int) (model.getData()[i] * 360 / total);
			g.setColor(model.getColors()[i]);
//			g.fillRect(10 * i, 10 * i, 20 * i, 160);
			g.fillRect((int) (100 * 0.35 * i), 10 , 25, barAngle);
			g.setColor(Color.black);
//			barAngle
			g.drawString(model.getDataName()[i], (int) (100 * 0.35 * i), 10);
			curValue += model.getData()[i];
			
			System.out.println(" barAngle: " + barAngle  + "startAngle: " + startAngle  + " curValue: " + curValue );
		}
		
//		g.drawString("CS", 10, 10);
//	     g.fillRect(10, 10, 20, 160);
	     
	}
}
