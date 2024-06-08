package edu.atlas.oop.week10;


import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;




public class Tester extends JFrame{
	private DrawingPanel dp;
	private JPanel jpBottom;
	private JButton saveButton;
	private ArrayList<Point> points;
	private ArrayList<ArrayList<Point>> listOfLists;
	Tester(){
		jpBottom = new JPanel();
		saveButton = new JButton("Save");
		saveButton.addActionListener(new SaveButtonListener());
		jpBottom.add(saveButton);
		listOfLists = new ArrayList<ArrayList<Point>>();
		dp = new DrawingPanel();
		dp.addMouseListener(new MyMouseListener());
		dp.addMouseMotionListener(new MyMouseMotionListener());
		this.setLayout(new BorderLayout());
		this.add(dp, BorderLayout.CENTER);
		this.add(jpBottom, BorderLayout.SOUTH);
		this.setSize(600,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tester t = new Tester();
	}
	//inner class (nested class)
	//JPanel is used for two purposes: (1) a container
	//that contains buttons, textboxes, tables, etc...
	//(2) for drawing 
	class DrawingPanel extends JPanel{
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			//g.drawString("Java String", 250, 200);
			for(int i = 0; i < listOfLists.size(); i++) {
				for(int j = 0; j < listOfLists.get(i).size()-1;j++) {
					g.drawLine(listOfLists.get(i).get(j).x, 
						listOfLists.get(i).get(j).y, 
						listOfLists.get(i).get(j+1).x, 
						listOfLists.get(i).get(j+1).y);
				}
			}
			
		}
	}
	class SaveButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JFileChooser j = new JFileChooser();
			 
			// Open the save dialog
			j.showSaveDialog(null);
			//after getting the file name save all the contents
			//of listOfLists in the file in such a way that
			//you given the file should be able to create
			//the same drawing on the drawingPanel
		}
		
	}
	class MyMouseMotionListener implements MouseMotionListener{

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			/*for(int i = 0; i < points.size();i++)
				System.out.printf("X: %d, Y:%d\n",
					points.get(i).x, points.get(i).y);
			*/
			listOfLists.get(listOfLists.size()-1).add(
				new Point(e.getX(),e.getY()));
			dp.repaint();
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			//System.out.printf("x:%d, y:%d\n",e.getX(),e.getY());
		}
		
	}
	class MyMouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			//System.out.printf("x:%d, y:%d\n",e.getX(),e.getY());
			
			//points.add(new Point(e.getX(),e.getY()));
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			listOfLists.add(new ArrayList<Point>());
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			//dp.repaint();
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
