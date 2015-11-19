/*
 * Mauricio Renon
 * ICS432
 * 
 * OnePanel.java
 * 
 * a GUI that displays a gray panel that has a black line that starts at the top and moves to the bottom
 * of the panel. This function starts when the start button is pressed
 * the time it takes to travel is based on P a positive command line argument
 * program runs for 3 mins
 *
 */

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

/*
 * ran on my windows desktop
 * P=1300, Thread ran 3638 times
 * P=1500, Thread ran 3052 times
 * 
 * ran on my macbook pro
 * P=35, Thread ran 329 times
 * P=40, Thread ran 289 times
 * P=37, Thread ran 315 times
 */

public class OnePanel extends JPanel{
	
	// global variables 
	boolean clicked;
	boolean run = true;
	static int P;
	int lineUpdateCounter =0;
	int threadRunCounter = 0;
	long threeMinRun;
	//long start;
	
	/*
	 * main
	 * 
	 * takes in a command line argument and sets it as P
	 * then creates a new OnePanel 
	 * 
	 * @param String args[] - the command line argument
	 * @return nothing
	 */
	public static void main(String args[]) {
		try{
			P = Integer.parseInt(args[0]);
			if(P < 0){
				System.out.println("needs a positive argument");
			}
			else{
				OnePanel panel = new OnePanel();
			}

		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("needs one argument");
		}
	}
	
	/*
	 * creates an OnePanel GUI that creates a seperate thread to run it
	 */
	public OnePanel()
	{
		JFrame frame = new JFrame();
		final LinePanel line = new LinePanel(); // instance of line class, draws line and grey box
		final JButton start = new JButton("Start");
		frame.setLayout(new FlowLayout());
		frame.setTitle("Mauricio's One Panel");
		frame.add(start);
		frame.add(line);
		
		start.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				start.setEnabled(false);
				clicked = true;
				Thread T1 = new Thread (){
				public void run(){
					threeMinRun = System.currentTimeMillis() + 3 * 60000; // 60,000 ms in 1 minute
					while(run){
						System.out.println("running...");
						if (System.currentTimeMillis() >= threeMinRun){
							System.out.print("Thread ran " + threadRunCounter + " times across panel");
							run = false;
						}	
						
						for(int i = 0; i < P; i++){
							for(int j = 0; j < 1000; j++) {
								Math.cos(j);
							}
						}
						
						
						
						lineUpdateCounter++;
						Graphics test = line.getGraphics(); // gets the line compenent inside instance of OneLine class, stores
															// it in variable Test
						line.updateGraphics(test,0,lineUpdateCounter,100,lineUpdateCounter);
						
						if(lineUpdateCounter == 100) {
							lineUpdateCounter = 0;
							threadRunCounter++;
						} 
					} 
				}
            }; 
				
		T1.start();
			} //action performed
		}); // action listener

		frame.pack();
		frame.setVisible(true);
	}
	
	/*
	 * This is the LinePanel class that creates
	 * the grey background to set the black line on it
	 * 
	 */
	public class LinePanel extends JPanel 
	{
		javax.swing.border.Border line;
		
		public LinePanel() {
			super();
			line = BorderFactory.createLineBorder(Color.BLACK, 3);
			
			this.setBackground(Color.GRAY);
			this.setBorder(line);
			this.setPreferredSize(new Dimension(50,100));
		}
		
		/*
		 * paintComponent 
		 * 
		 * sets the black line to the top of the grey panel
		 * 
		 * @param Graphics graphics - the line component
		 * @return nothing
		 * 
		 */
		public void paintComponent(Graphics graphics) 
		{
				super.paintComponent(graphics);
				graphics.drawLine(0, lineUpdateCounter, 100, lineUpdateCounter);
		}
		
		/*
		 * updateGraphics
		 * 
		 * sets the black line to the new position in the grey panel
		 * 
		 * @param Graphics graphics - the line component
		 * @param top - the top of the panel
		 * @param counter1 - the updateCounter
		 * @param btm - the bottom of the panel
		 * @param coounter2 - the updateCounter
		 * @return nothing
		 * 
		 */
		public void updateGraphics(Graphics graphics, int top, int counter1, int botm, int counter2)
		{
			graphics.drawLine(top, counter1, botm, counter2);
			repaint();	
		}
	}
	}
	



