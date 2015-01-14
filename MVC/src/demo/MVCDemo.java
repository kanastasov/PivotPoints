package demo;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import view.BarChartView;
import view.PieChartView;
import controller.ChartController;
import model.ChartModel;

public class MVCDemo extends JApplet  {
  private JButton jbtController = new JButton("Show Controller");
  private JButton jbtView = new JButton("Show View");
  private ChartModel model = new ChartModel();

  public MVCDemo() {
    setLayout(new FlowLayout());
    add(jbtController);
    add(jbtView);

    jbtController.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JFrame frame = new JFrame("Controller");
        ChartController controller = new ChartController();
        controller.setModel(model);
        frame.add(controller);
        frame.setSize(200, 200);
        frame.setLocation(200, 200);
        frame.setVisible(true);
      }
    });

    jbtView.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JFrame frame = new JFrame("View");
        PieChartView pieView = new PieChartView();
        BarChartView barView = new BarChartView();
        
        barView.setModel(model);
        frame.add(barView);
        frame.setSize(500, 200);
        frame.setLocation(200, 200);
        frame.setVisible(true);
        
      }
    });
    
  }

  public static void main(String[] args) {
    MVCDemo applet = new MVCDemo();
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("MVCDemo");
    frame.getContentPane().add(applet, BorderLayout.CENTER);
    frame.setSize(400, 320);
    frame.setResizable(false);
    frame.setVisible(true);
  }
}
