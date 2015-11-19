/*
 * Mauricio Renon
 * ICS432
 * 
 * ManyPanels.java
 * 
 * a GUI that displays 16 gray panels that has a black line that starts at the top and moves to the bottom
 * of the panel. This function starts the checkbox under the corresponding
 * panel is pressed, then start button is pressed
 * will run based on priority settings which is found at the top of
 * each panel 
 * the time it takes to travel is based on P a positive command line argument
 * program runs for 3 mins
 *
 */
import java.awt.*;
import java.util.*;

import javax.swing.*;

import java.awt.event.*;

/*
 * P=1300, Thread ran 3638 times
 * P=1500, Thread ran 3052 times
 */

public class ManyPanels extends JPanel{
	
	// global variables 
	boolean clicked;
	boolean run = true;
	static int P;
	int lineUpdateCounter1 = 0;
	int lineUpdateCounter2 = 0;
	int lineUpdateCounter3 = 0;
	int lineUpdateCounter4 = 0;
	int lineUpdateCounter5 = 0;
	int lineUpdateCounter6 = 0;
	int lineUpdateCounter7 = 0;
	int lineUpdateCounter8 = 0;
	int lineUpdateCounter9 = 0;
	int lineUpdateCounter10 = 0;
	int lineUpdateCounter11 = 0;
	int lineUpdateCounter12 = 0;
	int lineUpdateCounter13 = 0;
	int lineUpdateCounter14 = 0;
	int lineUpdateCounter15 = 0;
	int lineUpdateCounter16 = 0;
	
	int threadRunCounter1 = 0;
	int threadRunCounter2 = 0;
	int threadRunCounter3 = 0;
	int threadRunCounter4 = 0;
	int threadRunCounter5 = 0;
	int threadRunCounter6 = 0;
	int threadRunCounter7 = 0;
	int threadRunCounter8 = 0;
	int threadRunCounter9 = 0;
	int threadRunCounter10 = 0;
	int threadRunCounter11 = 0;
	int threadRunCounter12 = 0;
	int threadRunCounter13 = 0;
	int threadRunCounter14 = 0;
	int threadRunCounter15 = 0;
	int threadRunCounter16 = 0;
	
	long threeMinRun;
	static int createCounter;
	
	/*
	 * main
	 * 
	 * takes in a command line argument and sets it as P
	 * then creates a new ManyPanels 
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
					ManyPanels panels = new ManyPanels();
			}
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("needs one argument");
		}
	}
	
	/*
	 * creates an ManyPanel GUI that creates 16 seperate thread to run on each panel
	 */
	public ManyPanels()
	{
		JFrame mainframe = new JFrame();
		final LinePanel line1 = new LinePanel(); // instance of line class, draws line and grey box
		final LinePanel line2 = new LinePanel(); // 16 times
		final LinePanel line3 = new LinePanel();	
		final LinePanel line4 = new LinePanel();	
		final LinePanel line5 = new LinePanel();	
		final LinePanel line6 = new LinePanel();	
		final LinePanel line7 = new LinePanel();	
		final LinePanel line8 = new LinePanel();	
		final LinePanel line9 = new LinePanel();	
		final LinePanel line10= new LinePanel();			
		final LinePanel line11= new LinePanel();	
		final LinePanel line12= new LinePanel();	
		final LinePanel line13= new LinePanel();	
		final LinePanel line14= new LinePanel();	
		final LinePanel line15= new LinePanel();	
		final LinePanel line16= new LinePanel();	
		

		final JButton start = new JButton("Start");
		mainframe.setLayout(new FlowLayout());
		mainframe.setTitle("Mauricio's Many Panels");
		
		Integer[] priorityList = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
	    JPanel linePanel1 = new JPanel(); //create panel 1
		final JComboBox priority1 = new JComboBox(priorityList);
		final JLabel showCounter1 = new JLabel("0");
		final JCheckBox checkBox1 = new JCheckBox();
		linePanel1.setLayout(new BoxLayout(linePanel1, BoxLayout.Y_AXIS));
		linePanel1.add(priority1);
		linePanel1.add(line1);
		linePanel1.add(showCounter1);
		linePanel1.add(checkBox1);
		
	    JPanel linePanel2 = new JPanel(); //create panel 2
		final JComboBox priority2 = new JComboBox(priorityList);
		final JLabel showCounter2 = new JLabel("0");
		final JCheckBox checkBox2 = new JCheckBox();
		linePanel2.setLayout(new BoxLayout(linePanel2, BoxLayout.Y_AXIS));
		linePanel2.add(priority2);
		linePanel2.add(line2);
		linePanel2.add(showCounter2);
		linePanel2.add(checkBox2);
		
	    JPanel linePanel3 = new JPanel(); //create panel 3
		final JComboBox priority3 = new JComboBox(priorityList);
		final JLabel showCounter3 = new JLabel("0");
		final JCheckBox checkBox3 = new JCheckBox();
		linePanel3.setLayout(new BoxLayout(linePanel3, BoxLayout.Y_AXIS));
		linePanel3.add(priority3);
		linePanel3.add(line3);
		linePanel3.add(showCounter3);
		linePanel3.add(checkBox3);
		
	    JPanel linePanel4 = new JPanel(); //create panel 4
		final JComboBox priority4 = new JComboBox(priorityList);
		final JLabel showCounter4 = new JLabel("0");
		final JCheckBox checkBox4 = new JCheckBox();
		linePanel4.setLayout(new BoxLayout(linePanel4, BoxLayout.Y_AXIS));
		linePanel4.add(priority4);
		linePanel4.add(line4);
		linePanel4.add(showCounter4);
		linePanel4.add(checkBox4);
		
	    JPanel linePanel5 = new JPanel(); //create panel 5
	    final JComboBox priority5 = new JComboBox(priorityList);
	    final JLabel showCounter5 = new JLabel("0");
	    final JCheckBox checkBox5 = new JCheckBox();
		linePanel5.setLayout(new BoxLayout(linePanel5, BoxLayout.Y_AXIS));
		linePanel5.add(priority5);
		linePanel5.add(line5);
		linePanel5.add(showCounter5);
		linePanel5.add(checkBox5);

	    JPanel linePanel6 = new JPanel(); //create panel 6
	    final JComboBox priority6 = new JComboBox(priorityList);
	    final JLabel showCounter6 = new JLabel("0");
	    final JCheckBox checkBox6 = new JCheckBox();
		linePanel6.setLayout(new BoxLayout(linePanel6, BoxLayout.Y_AXIS));
		linePanel6.add(priority6);
		linePanel6.add(line6);
		linePanel6.add(showCounter6);
		linePanel6.add(checkBox6);

	    JPanel linePanel7 = new JPanel(); //create panel 7
	    final JComboBox priority7 = new JComboBox(priorityList);
	    final JLabel showCounter7 = new JLabel("0");
	    final JCheckBox checkBox7 = new JCheckBox();
		linePanel7.setLayout(new BoxLayout(linePanel7, BoxLayout.Y_AXIS));
		linePanel7.add(priority7);
		linePanel7.add(line7);
		linePanel7.add(showCounter7);
		linePanel7.add(checkBox7);

	    JPanel linePanel8 = new JPanel(); //create panel 8
	    final JComboBox priority8 = new JComboBox(priorityList);
	    final JLabel showCounter8 = new JLabel("0");
	    final JCheckBox checkBox8 = new JCheckBox();
		linePanel8.setLayout(new BoxLayout(linePanel8, BoxLayout.Y_AXIS));
		linePanel8.add(priority8);
		linePanel8.add(line8);
		linePanel8.add(showCounter8);
		linePanel8.add(checkBox8);

	    JPanel linePanel9 = new JPanel(); //create panel 9
	    final JComboBox priority9 = new JComboBox(priorityList);
	    final JLabel showCounter9 = new JLabel("0");
	    final JCheckBox checkBox9 = new JCheckBox();
		linePanel9.setLayout(new BoxLayout(linePanel9, BoxLayout.Y_AXIS));
		linePanel9.add(priority9);
		linePanel9.add(line9);
		linePanel9.add(showCounter9);
		linePanel9.add(checkBox9);

	    JPanel linePanel10 = new JPanel(); //create panel 10
	    final JComboBox priority10 = new JComboBox(priorityList);
	    final JLabel showCounter10 = new JLabel("0");
	    final JCheckBox checkBox10 = new JCheckBox();
		linePanel10.setLayout(new BoxLayout(linePanel10, BoxLayout.Y_AXIS));
		linePanel10.add(priority10);
		linePanel10.add(line10);
		linePanel10.add(showCounter10);
		linePanel10.add(checkBox10);
 
	    JPanel linePanel11 = new JPanel(); //create panel 11
	    final JComboBox priority11 = new JComboBox(priorityList);
	    final JLabel showCounter11 = new JLabel("0");
	    final JCheckBox checkBox11 = new JCheckBox();
		linePanel11.setLayout(new BoxLayout(linePanel11, BoxLayout.Y_AXIS));
		linePanel11.add(priority11);
		linePanel11.add(line11);
		linePanel11.add(showCounter11);
		linePanel11.add(checkBox11);

	    JPanel linePanel12 = new JPanel(); //create panel 12
	    final JComboBox priority12 = new JComboBox(priorityList);
	    final JLabel showCounter12 = new JLabel("0");
	    final JCheckBox checkBox12 = new JCheckBox();
		linePanel12.setLayout(new BoxLayout(linePanel12, BoxLayout.Y_AXIS));
		linePanel12.add(priority12);
		linePanel12.add(line12);
		linePanel12.add(showCounter12);
		linePanel12.add(checkBox12);

	    JPanel linePanel13 = new JPanel(); //create panel 13
	    final JComboBox priority13 = new JComboBox(priorityList);
	    final JLabel showCounter13 = new JLabel("0");
	    final JCheckBox checkBox13 = new JCheckBox();
		linePanel13.setLayout(new BoxLayout(linePanel13, BoxLayout.Y_AXIS));
		linePanel13.add(priority13);
		linePanel13.add(line13);
		linePanel13.add(showCounter13);
		linePanel13.add(checkBox13);

	    JPanel linePanel14 = new JPanel(); //create panel 14
	    final JComboBox priority14 = new JComboBox(priorityList);
	    final JLabel showCounter14 = new JLabel("0");
	    final JCheckBox checkBox14 = new JCheckBox();
		linePanel14.setLayout(new BoxLayout(linePanel14, BoxLayout.Y_AXIS));
		linePanel14.add(priority14);
		linePanel14.add(line14);
		linePanel14.add(showCounter14);
		linePanel14.add(checkBox14);

	    JPanel linePanel15 = new JPanel(); //create panel 15
	    final JComboBox priority15 = new JComboBox(priorityList);
	    final JLabel showCounter15 = new JLabel("0");
	    final JCheckBox checkBox15 = new JCheckBox();
		linePanel15.setLayout(new BoxLayout(linePanel15, BoxLayout.Y_AXIS));
		linePanel15.add(priority15);
		linePanel15.add(line15);
		linePanel15.add(showCounter15);
		linePanel15.add(checkBox15);

	    JPanel linePanel16 = new JPanel(); //create panel 16
	    final JComboBox priority16 = new JComboBox(priorityList);
	    final JLabel showCounter16 = new JLabel("0");
	    final JCheckBox checkBox16 = new JCheckBox();
		linePanel16.setLayout(new BoxLayout(linePanel16, BoxLayout.Y_AXIS));
		linePanel16.add(priority16);
		linePanel16.add(line16);
		linePanel16.add(showCounter16);
		linePanel16.add(checkBox16);

		mainframe.add(start); //add start button
		mainframe.add(linePanel1);  //add all 16 created panels
		mainframe.add(linePanel2);
		mainframe.add(linePanel3);
		mainframe.add(linePanel4);
		mainframe.add(linePanel5);
		mainframe.add(linePanel6);
		mainframe.add(linePanel7);
		mainframe.add(linePanel8);
		mainframe.add(linePanel9);
		mainframe.add(linePanel10);
		mainframe.add(linePanel11);
		mainframe.add(linePanel12);
		mainframe.add(linePanel13);
		mainframe.add(linePanel14);
		mainframe.add(linePanel15);
		mainframe.add(linePanel16);
		
		
		start.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				start.setEnabled(false);
				clicked = true;
				if(checkBox1.isSelected()){
					Thread T1 = new Thread (){				
						public void run(){
							System.out.println("created thread: " +createCounter);
							threeMinRun = System.currentTimeMillis() + 3 * 60000; // 60,000 ms in 1 minute
							while(run){
							//	System.out.println("running...");
								if (System.currentTimeMillis() >= threeMinRun){
									System.out.println("Thread 1 ran " + threadRunCounter1 + " times across panel");
									run = false;
								}	
								
								for(int i = 0; i < P; i++){
									for(int j = 0; j < 1000; j++) {
										Math.cos(j);
									}
								}
								
								
								
								lineUpdateCounter1++;
								Graphics test = line1.getGraphics(); // gets the line compenent inside instance of OneLine class, stores
																	// it in variable Test
								line1.updateGraphics(test,0,lineUpdateCounter1,100,lineUpdateCounter1);
								
								if(lineUpdateCounter1 == 100) {
									lineUpdateCounter1 = 0;
									threadRunCounter1++;
									showCounter1.setText("" + threadRunCounter1);
								} 
							} 
						}
		            }; 	
		            T1.setPriority((Integer) priority1.getSelectedItem());
		            T1.start();	
				}
				if(checkBox2.isSelected()){
					Thread T2 = new Thread (){				
						public void run(){
							System.out.println("created thread: " +createCounter);
							threeMinRun = System.currentTimeMillis() + 3 * 60000; // 60,000 ms in 1 minute
							while(run){
							//	System.out.println("running...");
								if (System.currentTimeMillis() >= threeMinRun){
									System.out.println("Thread 2 ran " + threadRunCounter2 + " times across panel");
									run = false;
								}	
								
								for(int i = 0; i < P; i++){
									for(int j = 0; j < 1000; j++) {
										Math.cos(j);
									}
								}
								
								
								
								lineUpdateCounter2++;
								Graphics test = line2.getGraphics(); // gets the line compenent inside instance of OneLine class, stores
																	// it in variable Test
								line2.updateGraphics(test,0,lineUpdateCounter2,100,lineUpdateCounter2);
								
								if(lineUpdateCounter2 == 100) {
									lineUpdateCounter2 = 0;
									threadRunCounter2++;
									showCounter2.setText("" + threadRunCounter2);
								} 
							} 
						}
		            }; 	
		            T2.setPriority((Integer) priority2.getSelectedItem());
		            T2.start();	
				}
				if(checkBox3.isSelected()){
					Thread T3 = new Thread (){				
						public void run(){
							System.out.println("created thread: " +createCounter);
							threeMinRun = System.currentTimeMillis() + 3 * 60000; // 60,000 ms in 1 minute
							while(run){
							//	System.out.println("running...");
								if (System.currentTimeMillis() >= threeMinRun){
									System.out.println("Thread 3 ran " + threadRunCounter3 + " times across panel");
									run = false;
								}	
								
								for(int i = 0; i < P; i++){
									for(int j = 0; j < 1000; j++) {
										Math.cos(j);
									}
								}
								
								
								
								lineUpdateCounter3++;
								Graphics test = line3.getGraphics(); // gets the line compenent inside instance of OneLine class, stores
																	// it in variable Test
								line3.updateGraphics(test,0,lineUpdateCounter3,100,lineUpdateCounter3);
								
								if(lineUpdateCounter3 == 100) {
									lineUpdateCounter3 = 0;
									threadRunCounter3++;
									showCounter3.setText("" + threadRunCounter3);
								} 
							} 
						}
		            }; 
		            T3.setPriority((Integer) priority3.getSelectedItem());
		            T3.start();	
				}
				if(checkBox4.isSelected()){
					Thread T4 = new Thread (){				
						public void run(){
							System.out.println("created thread: " +createCounter);
							threeMinRun = System.currentTimeMillis() + 3 * 60000; // 60,000 ms in 1 minute
							while(run){
							//	System.out.println("running...");
								if (System.currentTimeMillis() >= threeMinRun){
									System.out.println("Thread 4 ran " + threadRunCounter4 + " times across panel");
									run = false;
								}	
								
								for(int i = 0; i < P; i++){
									for(int j = 0; j < 1000; j++) {
										Math.cos(j);
									}
								}
								
								
								
								lineUpdateCounter4++;
								Graphics test = line4.getGraphics(); // gets the line compenent inside instance of OneLine class, stores
																	// it in variable Test
								line4.updateGraphics(test,0,lineUpdateCounter4,100,lineUpdateCounter4);
								
								if(lineUpdateCounter4 == 100) {
									lineUpdateCounter4 = 0;
									threadRunCounter4++;
									showCounter4.setText("" + threadRunCounter4);
								} 
							} 
						}
		            }; 	
		            T4.setPriority((Integer) priority4.getSelectedItem());
		            T4.start();	
				}
				if(checkBox5.isSelected()){
					Thread T5 = new Thread (){				
						public void run(){
							System.out.println("created thread: " +createCounter);
							threeMinRun = System.currentTimeMillis() + 3 * 60000; // 60,000 ms in 1 minute
							while(run){
							//	System.out.println("running...");
								if (System.currentTimeMillis() >= threeMinRun){
									System.out.println("Thread 5 ran " + threadRunCounter5 + " times across panel");
									run = false;
								}	
								
								for(int i = 0; i < P; i++){
									for(int j = 0; j < 1000; j++) {
										Math.cos(j);
									}
								}
								
								
								
								lineUpdateCounter5++;
								Graphics test = line5.getGraphics(); // gets the line compenent inside instance of OneLine class, stores
																	// it in variable Test
								line5.updateGraphics(test,0,lineUpdateCounter5,100,lineUpdateCounter5);
								
								if(lineUpdateCounter5 == 100) {
									lineUpdateCounter5 = 0;
									threadRunCounter5++;
									showCounter5.setText("" + threadRunCounter5);
								} 
							} 
						}
		            }; 	
		            T5.setPriority((Integer) priority5.getSelectedItem());
		            T5.start();	
				}
				if(checkBox6.isSelected()){
					Thread T6 = new Thread (){				
						public void run(){
							System.out.println("created thread: " +createCounter);
							threeMinRun = System.currentTimeMillis() + 3 * 60000; // 60,000 ms in 1 minute
							while(run){
							//	System.out.println("running...");
								if (System.currentTimeMillis() >= threeMinRun){
									System.out.println("Thread 6 ran " + threadRunCounter6 + " times across panel");
									run = false;
								}	
								
								for(int i = 0; i < P; i++){
									for(int j = 0; j < 1000; j++) {
										Math.cos(j);
									}
								}
								
								
								
								lineUpdateCounter6++;
								Graphics test = line6.getGraphics(); // gets the line compenent inside instance of OneLine class, stores
																	// it in variable Test
								line6.updateGraphics(test,0,lineUpdateCounter6,100,lineUpdateCounter6);
								
								if(lineUpdateCounter6 == 100) {
									lineUpdateCounter6 = 0;
									threadRunCounter6++;
									showCounter6.setText("" + threadRunCounter6);
								} 
							} 
						}
		            }; 	
		            T6.setPriority((Integer) priority6.getSelectedItem());
		            T6.start();	
				}
				if(checkBox7.isSelected()){
					Thread T7 = new Thread (){				
						public void run(){
							System.out.println("created thread: " +createCounter);
							threeMinRun = System.currentTimeMillis() + 3 * 60000; // 60,000 ms in 1 minute
							while(run){
							//	System.out.println("running...");
								if (System.currentTimeMillis() >= threeMinRun){
									System.out.println("Thread 7 ran " + threadRunCounter7 + " times across panel");
									run = false;
								}	
								
								for(int i = 0; i < P; i++){
									for(int j = 0; j < 1000; j++) {
										Math.cos(j);
									}
								}
								
								
								
								lineUpdateCounter7++;
								Graphics test = line7.getGraphics(); // gets the line compenent inside instance of OneLine class, stores
																	// it in variable Test
								line7.updateGraphics(test,0,lineUpdateCounter7,100,lineUpdateCounter7);
								
								if(lineUpdateCounter7 == 100) {
									lineUpdateCounter7 = 0;
									threadRunCounter7++;
									showCounter7.setText("" + threadRunCounter7);
								} 
							} 
						}
		            }; 	
		            T7.setPriority((Integer) priority7.getSelectedItem());
		            T7.start();	
				}
				if(checkBox8.isSelected()){
					Thread T8 = new Thread (){				
						public void run(){
							System.out.println("created thread: " +createCounter);
							threeMinRun = System.currentTimeMillis() + 3 * 60000; // 60,000 ms in 1 minute
							while(run){
							//	System.out.println("running...");
								if (System.currentTimeMillis() >= threeMinRun){
									System.out.println("Thread 8 ran " + threadRunCounter8 + " times across panel");
									run = false;
								}	
								
								for(int i = 0; i < P; i++){
									for(int j = 0; j < 1000; j++) {
										Math.cos(j);
									}
								}
								
								
								
								lineUpdateCounter8++;
								Graphics test = line8.getGraphics(); // gets the line compenent inside instance of OneLine class, stores
																	// it in variable Test
								line8.updateGraphics(test,0,lineUpdateCounter8,100,lineUpdateCounter8);
								
								if(lineUpdateCounter8 == 100) {
									lineUpdateCounter8 = 0;
									threadRunCounter8++;
									showCounter8.setText("" + threadRunCounter8);
								} 
							} 
						}
		            }; 	
		            T8.setPriority((Integer) priority8.getSelectedItem());
		            T8.start();	
				}
				if(checkBox9.isSelected()){
					Thread T9 = new Thread (){				
						public void run(){
							System.out.println("created thread: " +createCounter);
							threeMinRun = System.currentTimeMillis() + 3 * 60000; // 60,000 ms in 1 minute
							while(run){
							//	System.out.println("running...");
								if (System.currentTimeMillis() >= threeMinRun){
									System.out.println("Thread ran " + threadRunCounter9 + " times across panel");
									run = false;
								}	
								
								for(int i = 0; i < P; i++){
									for(int j = 0; j < 1000; j++) {
										Math.cos(j);
									}
								}
								
								
								
								lineUpdateCounter9++;
								Graphics test = line9.getGraphics(); // gets the line compenent inside instance of OneLine class, stores
																	// it in variable Test
								line9.updateGraphics(test,0,lineUpdateCounter9,100,lineUpdateCounter9);
								
								if(lineUpdateCounter9 == 100) {
									lineUpdateCounter9 = 0;
									threadRunCounter9++;
									showCounter9.setText("" + threadRunCounter9);
								} 
							} 
						}
		            }; 	
		            T9.setPriority((Integer) priority9.getSelectedItem());
		            T9.start();	
				}
				if(checkBox10.isSelected()){
					Thread T10 = new Thread (){				
						public void run(){
							System.out.println("created thread: " +createCounter);
							threeMinRun = System.currentTimeMillis() + 3 * 60000; // 60,000 ms in 1 minute
							while(run){
							//	System.out.println("running...");
								if (System.currentTimeMillis() >= threeMinRun){
									System.out.println("Thread 10 ran " + threadRunCounter10 + " times across panel");
									run = false;
								}	
								
								for(int i = 0; i < P; i++){
									for(int j = 0; j < 1000; j++) {
										Math.cos(j);
									}
								}
								
								
								
								lineUpdateCounter10++;
								Graphics test = line10.getGraphics(); // gets the line compenent inside instance of OneLine class, stores
																	// it in variable Test
								line10.updateGraphics(test,0,lineUpdateCounter10,100,lineUpdateCounter10);
								
								if(lineUpdateCounter10 == 100) {
									lineUpdateCounter10 = 0;
									threadRunCounter10++;
									showCounter10.setText("" + threadRunCounter10);
								} 
							} 
						}
		            }; 	
		            T10.setPriority((Integer) priority10.getSelectedItem());
		            T10.start();	
				}
				if(checkBox11.isSelected()){
					Thread T11 = new Thread (){				
						public void run(){
							System.out.println("created thread: " +createCounter);
							threeMinRun = System.currentTimeMillis() + 3 * 60000; // 60,000 ms in 1 minute
							while(run){
							//	System.out.println("running...");
								if (System.currentTimeMillis() >= threeMinRun){
									System.out.println("Thread 11 ran " + threadRunCounter11 + " times across panel");
									run = false;
								}	
								
								for(int i = 0; i < P; i++){
									for(int j = 0; j < 1000; j++) {
										Math.cos(j);
									}
								}
								
								
								
								lineUpdateCounter11++;
								Graphics test = line11.getGraphics(); // gets the line compenent inside instance of OneLine class, stores
																	// it in variable Test
								line11.updateGraphics(test,0,lineUpdateCounter11,100,lineUpdateCounter11);
								
								if(lineUpdateCounter11 == 100) {
									lineUpdateCounter11 = 0;
									threadRunCounter11++;
									showCounter11.setText("" + threadRunCounter11);
								} 
							} 
						}
		            }; 	
		            T11.setPriority((Integer) priority11.getSelectedItem());
		            T11.start();	
				}
				if(checkBox12.isSelected()){
					Thread T12 = new Thread (){				
						public void run(){
							System.out.println("created thread: " +createCounter);
							threeMinRun = System.currentTimeMillis() + 3 * 60000; // 60,000 ms in 1 minute
							while(run){
							//	System.out.println("running...");
								if (System.currentTimeMillis() >= threeMinRun){
									System.out.println("Thread 12 ran " + threadRunCounter12 + " times across panel");
									run = false;
								}	
								
								for(int i = 0; i < P; i++){
									for(int j = 0; j < 1000; j++) {
										Math.cos(j);
									}
								}
								
								
								
								lineUpdateCounter12++;
								Graphics test = line12.getGraphics(); // gets the line compenent inside instance of OneLine class, stores
																	// it in variable Test
								line12.updateGraphics(test,0,lineUpdateCounter12,100,lineUpdateCounter12);
								
								if(lineUpdateCounter12 == 100) {
									lineUpdateCounter12 = 0;
									threadRunCounter12++;
									showCounter12.setText("" + threadRunCounter12);
								} 
							} 
						}
		            }; 	
		            T12.setPriority((Integer) priority12.getSelectedItem());
		            T12.start();	
				}
				if(checkBox13.isSelected()){
					Thread T13 = new Thread (){				
						public void run(){
							System.out.println("created thread: " +createCounter);
							threeMinRun = System.currentTimeMillis() + 3 * 60000; // 60,000 ms in 1 minute
							while(run){
							//	System.out.println("running...");
								if (System.currentTimeMillis() >= threeMinRun){
									System.out.println("Thread 13 ran " + threadRunCounter13 + " times across panel");
									run = false;
								}	
								
								for(int i = 0; i < P; i++){
									for(int j = 0; j < 1000; j++) {
										Math.cos(j);
									}
								}
								
								
								
								lineUpdateCounter13++;
								Graphics test = line13.getGraphics(); // gets the line compenent inside instance of OneLine class, stores
																	// it in variable Test
								line13.updateGraphics(test,0,lineUpdateCounter13,100,lineUpdateCounter13);
								
								if(lineUpdateCounter13 == 100) {
									lineUpdateCounter13 = 0;
									threadRunCounter13++;
									showCounter13.setText("" + threadRunCounter13);
								} 
							} 
						}
		            }; 	
		            T13.setPriority((Integer) priority13.getSelectedItem());
		            T13.start();	
				}
				if(checkBox14.isSelected()){
					Thread T14 = new Thread (){				
						public void run(){
							System.out.println("created thread: " +createCounter);
							threeMinRun = System.currentTimeMillis() + 3 * 60000; // 60,000 ms in 1 minute
							while(run){
							//	System.out.println("running...");
								if (System.currentTimeMillis() >= threeMinRun){
									System.out.println("Thread 14 ran " + threadRunCounter14 + " times across panel");
									run = false;
								}	
								
								for(int i = 0; i < P; i++){
									for(int j = 0; j < 1000; j++) {
										Math.cos(j);
									}
								}
								
								
								
								lineUpdateCounter14++;
								Graphics test = line14.getGraphics(); // gets the line compenent inside instance of OneLine class, stores
																	// it in variable Test
								line14.updateGraphics(test,0,lineUpdateCounter14,100,lineUpdateCounter14);
								
								if(lineUpdateCounter14 == 100) {
									lineUpdateCounter14 = 0;
									threadRunCounter14++;
									showCounter14.setText("" + threadRunCounter14);
								} 
							} 
						}
		            }; 	
		            T14.setPriority((Integer) priority14.getSelectedItem());
		            T14.start();	
				}
				if(checkBox15.isSelected()){
					Thread T15 = new Thread (){				
						public void run(){
							System.out.println("created thread: " +createCounter);
							threeMinRun = System.currentTimeMillis() + 3 * 60000; // 60,000 ms in 1 minute
							while(run){
							//	System.out.println("running...");
								if (System.currentTimeMillis() >= threeMinRun){
									System.out.println("Thread 15 ran " + threadRunCounter15 + " times across panel");
									run = false;
								}	
								
								for(int i = 0; i < P; i++){
									for(int j = 0; j < 1000; j++) {
										Math.cos(j);
									}
								}
								
								
								
								lineUpdateCounter15++;
								Graphics test = line15.getGraphics(); // gets the line compenent inside instance of OneLine class, stores
																	// it in variable Test
								line15.updateGraphics(test,0,lineUpdateCounter15,100,lineUpdateCounter15);
								
								if(lineUpdateCounter15 == 100) {
									lineUpdateCounter15 = 0;
									threadRunCounter15++;
									showCounter15.setText("" + threadRunCounter15);
								} 
							} 
						}
		            }; 	
		            T15.setPriority((Integer) priority15.getSelectedItem());
		            T15.start();	
				}
				if(checkBox16.isSelected()){
					Thread T16 = new Thread (){				
						public void run(){
							System.out.println("created thread: " +createCounter);
							threeMinRun = System.currentTimeMillis() + 3 * 60000; // 60,000 ms in 1 minute
							while(run){
							//	System.out.println("running...");
								if (System.currentTimeMillis() >= threeMinRun){
									System.out.println("Thread 16 ran " + threadRunCounter16 + " times across panel");
									run = false;
								}	
								
								for(int i = 0; i < P; i++){
									for(int j = 0; j < 1000; j++) {
										Math.cos(j);
									}
								}
								
								
								
								lineUpdateCounter16++;
								Graphics test = line16.getGraphics(); // gets the line compenent inside instance of OneLine class, stores
																	// it in variable Test
								line16.updateGraphics(test,0,lineUpdateCounter16,100,lineUpdateCounter16);
								
								if(lineUpdateCounter16 == 100) {
									lineUpdateCounter16 = 0;
									threadRunCounter16++;
									showCounter16.setText("" + threadRunCounter16);
								} 
							} 
						}
		            }; 	
		            T16.setPriority((Integer) priority16.getSelectedItem());
		            T16.start();	
				}

		
			} //action performed
		}); // action listener
		mainframe.pack();
		mainframe.setVisible(true);
	}
	
	/*
	 * This is the LinePanel class that creates
	 * the grey background to set the black line on it
	 * 
	 */
	public class LinePanel extends JPanel 
	{
		javax.swing.border.Border line;
		int lineUpdateCounter;
		
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
		public void paintComponent(Graphics graphics, int lineUpdateCounter) 
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
	



