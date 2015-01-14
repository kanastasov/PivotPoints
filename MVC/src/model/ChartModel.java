package model;

import java.awt.Color;
import java.awt.event.*;
import java.util.*;

public class ChartModel {
	/** Property radius. */
	private double radius = 70;

	/** Property filled. */
	private boolean filled;

	/** Property color. */
	private java.awt.Color color;

	/** Property chart */
	private double data[] = { 200, 40, 50, 100, 40, 20 };

	/** Property dataNames */
	private String dataName[] = { "CS", "Math", "Chem", "Biol", "Psyc", "Duss" };

	Color[] colors = new Color[] { Color.RED,
			Color.YELLOW, Color.GREEN, Color.BLUE, Color.CYAN, Color.MAGENTA,
			Color.orange, Color.PINK, Color.DARK_GRAY };
	
	/** Utility field used by event firing mechanism. */
	private ArrayList<ActionListener> actionListenerList;

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;

		// Notify the listener for the change on radius
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED,
				"radius"));
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;

		// Notify the listener for the change on filled
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED,
				"filled"));
	}

	public java.awt.Color getColor() {
		return color;
	}

	public void setColor(java.awt.Color color) {
		this.color = color;

		// Notify the listener for the change on color
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED,
				"color"));
		
	}
	

	public Color[] getColors() {
		return colors;
	}

	public void setColors(Color[] colors) {
		this.colors = colors;
	}

	public double[] getData() {
		return data;
	}

	public String[] getDataName() {
		return dataName;
	}
	
	public void setChartData(String[] newDataName, double[] newData) {
		this.dataName = newDataName;
		this.data = newData;
		
		// Notify the listener for the change on color
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED,
				"chartData"));
	}

	/** Register an action event listener */
	public synchronized void addActionListener(ActionListener l) {
		if (actionListenerList == null)
			actionListenerList = new ArrayList<ActionListener>();

		actionListenerList.add(l);
	}

	/** Remove an action event listener */
	public synchronized void removeActionListener(ActionListener l) {
		if (actionListenerList != null && actionListenerList.contains(l))
			actionListenerList.remove(l);
	}

	/** Fire TickEvent */
	private void processEvent(ActionEvent e) {
		ArrayList list;

		synchronized (this) {
			if (actionListenerList == null)
				return;
			list = (ArrayList) actionListenerList.clone();
		}

		for (int i = 0; i < list.size(); i++) {
			ActionListener listener = (ActionListener) list.get(i);
			listener.actionPerformed(e);
		}
	}
}
