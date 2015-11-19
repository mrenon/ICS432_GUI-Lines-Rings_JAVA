/*
 * Mauricio Renon
 * ICS432
 * 
 * TwoRing.java
 * 
 * a GUI that displays a two black panels. one that has a red ring
 * another that has a blue ring. Both rings start blinking when start button is pressed
 * blinking time is based on P1 and P2, which are positive command line arguments
 * program runs until closed
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TwoRings extends JPanel {

	boolean click; // changes to true when start button is clicked
	private static int sleeptime1; // grabs the first argument from command line
	private static int sleeptime2; // grabs the second argument from command line

	/*
	 * main
	 * 
	 * takes in two command line arguments and sets it as P1 P2
	 * then creates a new TwoRings 
	 * 
	 * @param String args[] - the command line argument
	 * @return nothing
	 */
	public static void main(String[] args) {
		try{
			sleeptime1 = Integer.parseInt(args[0]);  // grabs the first argument from command line
			sleeptime2 = Integer.parseInt(args[1]); // grabs the second argument from command line
			
			if(sleeptime1 < 0 || sleeptime2 < 0){
				System.out.println("needs to positive arguments");
			}
			else{
				new TwoRings();
			}	
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("needs two arguments");
		}
	}

	/*
	 * creates an TwoRing GUI that creates two seperate threads to run it
	 */
	public TwoRings() {

		JFrame frame = new JFrame(); 
		final JButton startButton = new JButton("Start");  
		final redRing ring = new redRing();  
		final blueRing ring2 = new blueRing(); 
		frame.setLayout(new FlowLayout()); 
		
		frame.setTitle("Mauricio's BLINKING GUI");
		frame.add(startButton);  
		frame.add(ring);  
		frame.add(ring2);  
		
		startButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent event) {
				
				startButton.setEnabled(false);
				
				Thread T1 = new Thread (){  

					public void run(){
						while(true)
						{
							click = true; 
							ring.repaint();  
							try {
								Thread.sleep(sleeptime1); // sleep for P1 time
							} 
							catch (InterruptedException e) {						
								System.err.println("Thread 1 has been interrupted: user entered time");
							}
							click = false; 
							ring.repaint();  
							try {
								Thread.sleep(200);  
							} 
							catch (InterruptedException e) {
								System.err.println("Thread 1 has been interrupted: 200ms time");
							}
						}
					}
				};			
				Thread T2 = new Thread (){  

					public void run(){
						while(true)
						{
							click = true;  
							ring2.repaint();  
							try {
								Thread.sleep(sleeptime2);  //sleep for P2 time
							} 
							catch (InterruptedException e) {						
								System.err.println("Thread 2 has been interrupted: user entered time");
							}
							click = false;  
							ring2.repaint();  
							try {
								Thread.sleep(200); 
							} catch (InterruptedException e) {
								System.err.println("Thread 2 has been interrupted: 200ms time");
							}
						}
					}
				};
				T1.start();	//start Red 
				T2.start(); //start Blue 
			}
		});
		frame.pack();
		frame.setVisible(true); 
	}

	/*
	 * This is the redRing class that creates
	 * the black background to set the red ring on
	 * 
	 */
	public class redRing extends JPanel {
		public redRing() {
			super();
			this.setBackground(Color.BLACK);
			this.setPreferredSize(new Dimension(200,200));
		}

		/*
		 * paints the red ring on the black background
		 * when the user presses the start button
		 * 
		 * when click is set to true we color the circle black
		 * when false we color the circle red, with a smaller black circle
		 * in the center
		 * 
		 * @param Graphics g - the graphic component
		 * @return nothing
		 */
		public void paintComponent(Graphics g) {
			if(click == true) {
				super.paintComponent(g);
				g.setColor(Color.BLACK);
				g.fillOval(50, 50, 100, 100);
			}
			else {
				super.paintComponent(g);
				g.setColor(Color.RED);
				g.fillOval(50, 50, 100, 100);
				g.setColor(Color.BLACK);
				g.fillOval(65, 65, 70, 70);
			}
		}
	}
	
	/*
	 * This is the blueRing class that creates
	 * the black background to set the blue ring on
	 * 
	 */
	public class blueRing extends JPanel {
		public blueRing() {
			super();
			this.setBackground(Color.BLACK);
			this.setPreferredSize(new Dimension(200,200));
		}
		
		/*
		 * paints the blue ring on the black background
		 * when the user presses the start button
		 * 
		 * when click is set to true we color the circle black
		 * when false we color the circle blue, with a smaller black circle
		 * in the center
		 * 
		 * @param Graphics g - the graphic component
		 * @return nothing
		 */
		public void paintComponent(Graphics g) {
			if(click == true) {
				super.paintComponent(g);
				g.setColor(Color.BLACK);
				g.fillOval(50, 50, 100, 100);
			}
			else {
				super.paintComponent(g);
				g.setColor(Color.BLUE);
				g.fillOval(50, 50, 100, 100);
				g.setColor(Color.BLACK);
				g.fillOval(65, 65, 70, 70);
			}
		}
	}
}