/*
 * Mauricio Renon
 * ICS432
 * 
 * OneRing.java
 * 
 * a GUI that displays a black panel that has a red ring that blinks when start button is pressed
 * blinking time is based on P a positive command line argument
 * program runs until closed
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OneRing extends JPanel {

	boolean click; 
	private static int sleeptime; //command line argument

	/*
	 * main
	 * 
	 * takes in a command line argument and sets it as P
	 * then creates a new OneRing
	 * 
	 * @param String args[] - the command line argument
	 * @return nothing
	 */
	public static void main(String[] args){ //does checks to see if arguments are valid
		try{
			sleeptime = Integer.parseInt(args[0]);
			if(sleeptime < 0){
				System.out.println("needs a positive argument");
			}
			else{
				new OneRing();
			}

		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("needs one argument");
		}
	}

	/*
	 * creates an OneRing GUI that creates a seperate thread to run it
	 */
	public OneRing() {

		JFrame frame = new JFrame(); //create the GUI components
		final JButton startButton = new JButton("Start"); 
		final redRing ring = new redRing(); 
		frame.setLayout(new FlowLayout()); 

		frame.setTitle("Mauricio's BLINKING GUI");
		frame.add(startButton);  //adds components to GUI
		frame.add(ring);  

		startButton.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent event) {
				
				startButton.setEnabled(false);  //disables the button
				Thread T = new Thread (){ //start new thread method

					public void run(){
						while(true)
						{
							click = true; 
							ring.repaint(); 
							try {
								Thread.sleep(sleeptime);  //P time
							} 
							catch (InterruptedException e) {						
								e.getLocalizedMessage();
							}
							click = false; 
							ring.repaint();  
							try {
								Thread.sleep(200); // sleep for 200 ms
							} 
							catch (InterruptedException e) {}
						}
					}
				};
				T.start();	//start the thread
			}
		});
		frame.pack(); //pack and show GUI
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
}