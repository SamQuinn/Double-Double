/**
*
*
* the GUI for CPSC101 final project
*
*
*@author Scott Howes
*@version 03/13/2016
*
*/

import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;



public class Gui extends JFrame{

	//JFrame Variables
	private int width = 1100;
	private int height = 600; //550
	private String title = "CPCS101 Final Project by Double-Double";
	private Boolean resizable = true;
	private int minWidth = 700;
	private int minHeight = 350;

	//Color Variables Array
	private Color[]  colorArray= { Color.WHITE, Color.BLUE, Color.CYAN, Color.GREEN, 
    							Color.MAGENTA, Color.ORANGE, Color.PINK, Color.YELLOW, Color.RED };
	
	//Font variables
	private Font headerFont = new Font( "Monospace", Font.BOLD, 12);
	private Font timeTableFont = new Font( "Monospace", Font.BOLD, 10);
	
	//Panel Variables
	private JPanel contentPanel;
	private JPanel mainPanel;
	private JPanel daysOfWeek;
	private JPanel temp;
	private JPanel times;
	private JPanel timeTable;
	private GridBagConstraints gbc;
	private JPanel wPanel;

	//TimeTable Variables
	//border stuff
	private int borderThickness = 1;
	private Color borderColor = Color.BLACK;
	//days of the week dimensions
	private Dimension daysDim = new Dimension( 300, 40 );
	private Dimension minDaysDim = new Dimension( 10, 20 );
	//times dimensions
	private Dimension timesDim = new Dimension( 100, 40 );
	private Dimension minTimesDim = new Dimension( 10, 20 );	
	//Days of the Week Labels
	private JLabel empty;
	private JLabel mon;
	private JLabel tues;
	private JLabel weds;
	private JLabel thurs;
	private JLabel fri;
	private JLabel sat;
	private JLabel sun;
	//times labels
	private JLabel hour1;
	private JLabel hour2;
	private JLabel hour3;
	private JLabel hour4;
	private JLabel hour5;
	private JLabel hour6;
	private JLabel hour7;
	private JLabel hour8;
	private JLabel hour9;
	private JLabel hour10;
	private JLabel hour11;
	private JLabel hour12;
	private JLabel hour13;
	private JLabel hour14;
	//Array of Labels for where courses go
	private JLabel[][] labelArray = new JLabel[28][7];
	//dimensions for those labels
	private JButton button;
	private Dimension courseDim = new Dimension( 100, 20 );
	private Dimension minCourseDim = new Dimension( 90, 20 );
	//Backend Variables
	private static File file;
	private static MasterSchedule master;
	
	

	//Main method for running the program
	public static void main( String[] args )
	{	
		file = new File("January 2017 First Draft.csv");
		master = new MasterSchedule(file);
		SwingUtilities.invokeLater( new Runnable()
		{
			@Override
			public void run()
			{
				new Gui();
			}
		});
	}
	
	
	//Constructor
	public Gui()
	{	
		//making the Panels
		makePanels();
		//calling the timetable panel
		timeTable();
		//makes the west panel
		add(new WestPanel(master.getCourses()),BorderLayout.WEST);
		
		//JFrame Stuff
		this.setTitle( title );
		this.setResizable( resizable );
		this.setSize( width, height );
		this.setMinimumSize( new Dimension( minWidth, minHeight ) );
		this.setDefaultCloseOperation( this.EXIT_ON_CLOSE );
		this.setVisible(true);
	}
	
	
	
	//makes the Panels
	private void makePanels()
	{
	
		//creates the content Panels which Holds ALL other Panels for the timetable
		contentPanel = new JPanel( new BorderLayout() );
		contentPanel.setBorder( BorderFactory.createLineBorder( colorArray[0], 2 ) );
		this.add( contentPanel, BorderLayout.CENTER );
		
		//This mainPanel is for the days of the week header and where the course info will go
		mainPanel = new JPanel( new BorderLayout() );
		//mainPanel.setBorder( BorderFactory.createLineBorder( colorArray[0], 2 ) );
		contentPanel.add( mainPanel, BorderLayout.CENTER );

		//creating the panel for the days of the week header ---> Horizontal BoxLayout
		//also adds it to the mainPanel
		daysOfWeek = new JPanel();
		daysOfWeek.setLayout( new BoxLayout( daysOfWeek, BoxLayout.X_AXIS ) );
		mainPanel.add( daysOfWeek, BorderLayout.NORTH );
		
		//creating stuff for the Times Column
		// a temp Panel for formatting
		temp = new JPanel( new BorderLayout() );
		contentPanel.add( temp, BorderLayout.WEST );
		//adds it to the main Panel
		times = new JPanel();
		times.setLayout( new GridLayout( 14, 1) );
		temp.add( times, BorderLayout.CENTER );
		
		//for the stuff where courses go
		timeTable = new JPanel();
		timeTable.setLayout( new GridBagLayout() );
		timeTable.setBackground( colorArray[0] );
		mainPanel.add( timeTable, BorderLayout.CENTER );

		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;

		//the west Panel
		wPanel = new JPanel( new BorderLayout() );
		wPanel.setBorder( BorderFactory.createLineBorder( colorArray[0], 2 ) );
		this.add( wPanel, BorderLayout.WEST );

	}
	
	
	
	//Everything that has to do with the Timetable
	private void timeTable()
	{
	
		
		//---------------------------------------------creating Days of the week Labels and adds them to the daysOfWeek panel
		//monday Label
		mon = new JLabel( "Monday", SwingConstants.CENTER );
		mon.setFont( headerFont );
		mon.setPreferredSize( daysDim );
		mon.setMinimumSize( minDaysDim );
		mon.setBorder( BorderFactory.createLineBorder( borderColor, borderThickness ) );
		//tuesday Label
		tues = new JLabel( "Tuesday", SwingConstants.CENTER );
		tues.setFont( headerFont );
		tues.setPreferredSize( daysDim );
		tues.setMinimumSize( minDaysDim );
		tues.setBorder( BorderFactory.createLineBorder( borderColor, borderThickness ) );
		//wednesday Label
		weds = new JLabel( "Wednesday", SwingConstants.CENTER );
		weds.setFont( headerFont );
		weds.setPreferredSize( daysDim );
		weds.setMinimumSize( minDaysDim );
		weds.setBorder( BorderFactory.createLineBorder( borderColor, borderThickness ) );
		//Thursday Label
		thurs = new JLabel( "Thursday", SwingConstants.CENTER );
		thurs.setFont( headerFont );
		thurs.setPreferredSize( daysDim );
		thurs.setMinimumSize( minDaysDim );
		thurs.setBorder( BorderFactory.createLineBorder( borderColor, borderThickness ) );
		//friday Label
		fri = new JLabel( "Friday", SwingConstants.CENTER );
		fri.setFont( headerFont );
		fri.setPreferredSize( daysDim );
		fri.setMinimumSize( minDaysDim );
		fri.setBorder( BorderFactory.createLineBorder( borderColor, borderThickness ) );
		//saturday Label
		sat = new JLabel( "Saturday", SwingConstants.CENTER );
		sat.setFont( headerFont );
		sat.setPreferredSize( daysDim );
		sat.setMinimumSize( minDaysDim );
		sat.setBorder( BorderFactory.createLineBorder( borderColor, borderThickness ) );
		//sunday Label
		sun = new JLabel( "Sunday", SwingConstants.CENTER );
		sun.setFont( headerFont );
		sun.setPreferredSize( daysDim );
		sun.setMinimumSize( minDaysDim );
		sun.setBorder( BorderFactory.createLineBorder( borderColor, borderThickness ) );
		
		//adding them to the panel
		daysOfWeek.add( mon );
		daysOfWeek.add( tues );
		daysOfWeek.add( weds );
		daysOfWeek.add( thurs );
		daysOfWeek.add( fri );
		daysOfWeek.add( sat );
		daysOfWeek.add( sun );
		
		
		
		//------------------------------------------------------------------creating Time Labels and adding them to the times panel
		//empty label for a buffer that will be added to the NORTH part of the temp Panel
		empty = new JLabel( "\t\t" );
		empty.setPreferredSize( timesDim );
		empty.setMinimumSize( minTimesDim );
		//hour1
		hour1 = new JLabel( "8:30-9:20", SwingConstants.CENTER );
		hour1.setVerticalAlignment( SwingConstants.TOP );
		hour1.setFont( headerFont );
		hour1.setPreferredSize( timesDim );
		hour1.setMinimumSize( minTimesDim );
		hour1.setBorder( BorderFactory.createLineBorder( borderColor, borderThickness ) );
		//hour2
		hour2 = new JLabel( "9:30-10:20", SwingConstants.CENTER );
		hour2.setVerticalAlignment( SwingConstants.TOP );
		hour2.setFont( headerFont );
		hour2.setPreferredSize( timesDim );
		hour2.setMinimumSize( minTimesDim );
		hour2.setBorder( BorderFactory.createLineBorder( borderColor, borderThickness ) );
		//hour3
		hour3 = new JLabel( "10:30-11:20", SwingConstants.CENTER );
		hour3.setVerticalAlignment( SwingConstants.TOP );
		hour3.setFont( headerFont );
		hour3.setPreferredSize( timesDim );
		hour3.setMinimumSize( minTimesDim );
		hour3.setBorder( BorderFactory.createLineBorder( borderColor, borderThickness ) );
		//hour4
		hour4 = new JLabel( "11:30-12:20", SwingConstants.CENTER );
		hour4.setVerticalAlignment( SwingConstants.TOP );
		hour4.setFont( headerFont );
		hour4.setPreferredSize( timesDim );
		hour4.setMinimumSize( minTimesDim );
		hour4.setBorder( BorderFactory.createLineBorder( borderColor, borderThickness ) );
		//hour5
		hour5 = new JLabel( "12:30-1:20", SwingConstants.CENTER );
		hour5.setVerticalAlignment( SwingConstants.TOP );
		hour5.setFont( headerFont );
		hour5.setPreferredSize( timesDim );
		hour5.setMinimumSize( minTimesDim );
		hour5.setBorder( BorderFactory.createLineBorder( borderColor, borderThickness ) );
		//hour6
		hour6 = new JLabel( "1:30-2:20", SwingConstants.CENTER );
		hour6.setVerticalAlignment( SwingConstants.TOP );
		hour6.setFont( headerFont );
		hour6.setPreferredSize( timesDim );
		hour6.setMinimumSize( minTimesDim );
		hour6.setBorder( BorderFactory.createLineBorder( borderColor, borderThickness ) );
		//hour7
		hour7 = new JLabel( "2:20-3:20", SwingConstants.CENTER );
		hour7.setVerticalAlignment( SwingConstants.TOP );
		hour7.setFont( headerFont );
		hour7.setPreferredSize( timesDim );
		hour7.setMinimumSize( minTimesDim );
		hour7.setBorder( BorderFactory.createLineBorder( borderColor, borderThickness ) );
		//hour8
		hour8 = new JLabel( "3:30-4:20", SwingConstants.CENTER );
		hour8.setVerticalAlignment( SwingConstants.TOP );
		hour8.setFont( headerFont );
		hour8.setPreferredSize( timesDim );
		hour8.setMinimumSize( minTimesDim );
		hour8.setBorder( BorderFactory.createLineBorder( borderColor, borderThickness ) );
		//hour9
		hour9 = new JLabel( "4:30-5:20", SwingConstants.CENTER );
		hour9.setVerticalAlignment( SwingConstants.TOP );
		hour9.setFont( headerFont );
		hour9.setPreferredSize( timesDim );
		hour9.setMinimumSize( minTimesDim );
		hour9.setBorder( BorderFactory.createLineBorder( borderColor, borderThickness ) );
		//hour10
		hour10 = new JLabel( "5:30-6:20", SwingConstants.CENTER );
		hour10.setVerticalAlignment( SwingConstants.TOP );
		hour10.setFont( headerFont );
		hour10.setPreferredSize( timesDim );
		hour10.setMinimumSize( minTimesDim );
		hour10.setBorder( BorderFactory.createLineBorder( borderColor, borderThickness ) );
		//hour11
		hour11 = new JLabel( "6:30-7:20", SwingConstants.CENTER );
		hour11.setVerticalAlignment( SwingConstants.TOP );
		hour11.setFont( headerFont );
		hour11.setPreferredSize( timesDim );
		hour11.setMinimumSize( minTimesDim );
		hour11.setBorder( BorderFactory.createLineBorder( borderColor, borderThickness ) );
		//hour12
		hour12 = new JLabel( "7:30-8:20", SwingConstants.CENTER );
		hour12.setVerticalAlignment( SwingConstants.TOP );
		hour12.setFont( headerFont );
		hour12.setPreferredSize( timesDim );
		hour12.setMinimumSize( minTimesDim );
		hour12.setBorder( BorderFactory.createLineBorder( borderColor, borderThickness ) );
		//hour13
		hour13 = new JLabel( "8:30-9:20", SwingConstants.CENTER );
		hour13.setVerticalAlignment( SwingConstants.TOP );
		hour13.setFont( headerFont );
		hour13.setPreferredSize( timesDim );
		hour13.setMinimumSize( minTimesDim );
		hour13.setBorder( BorderFactory.createLineBorder( borderColor, borderThickness ) );
		//hour14
		hour14 = new JLabel( "9:30-10:20", SwingConstants.CENTER );
		hour14.setVerticalAlignment( SwingConstants.TOP );
		hour14.setFont( headerFont );
		hour14.setPreferredSize( timesDim );
		hour14.setMinimumSize( minTimesDim );
		hour14.setBorder( BorderFactory.createLineBorder( borderColor, borderThickness ) );
		
		//adding them to the panel
		temp.add( empty, BorderLayout.NORTH ); 
		times.add( hour1 );
		times.add( hour2 );
		times.add( hour3 );
		times.add( hour4 );
		times.add( hour5 );
		times.add( hour6 );
		times.add( hour7 );
		times.add( hour8 );
		times.add( hour9 );
		times.add( hour10 );
		times.add( hour11 );
		times.add( hour12 );
		times.add( hour13 );
		times.add( hour14 );
		
		
		//-------------------------------------------------------loop for creating the timetable where the courses will go
		for( int i=0; i < 28; i++ )
		{
			for( int j=0; j < 7; j++ )
			{
				labelArray[i][j] = new JLabel( "\t\t", SwingConstants.CENTER );
				labelArray[i][j].setFont( timeTableFont );
				labelArray[i][j].setBorder( BorderFactory.createLineBorder( borderColor, borderThickness ) );
				labelArray[i][j].setPreferredSize( courseDim );
				labelArray[i][j].setMinimumSize( minCourseDim );
				labelArray[i][j].setBackground( colorArray[0] );
				labelArray[i][j].setOpaque(true);

				gbc.fill = GridBagConstraints.HORIZONTAL;
				gbc.fill = GridBagConstraints.VERTICAL;
				gbc.weightx = 0.5;
				gbc.weighty = 0.5;
				gbc.anchor = GridBagConstraints.CENTER;
				gbc.gridx = j;
				gbc.gridy = i;

				timeTable.add( labelArray[i][j], gbc );
				//repaint();
			}
		}
	}

		public void addBlocks(ArrayList<Meeting> a){
			String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
			String[] times = {"08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00"};
			String[] durations = {"00:30", "01:00", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00", "04:30", "05:00", "05:30", "06:00", "06:30", "07:00", "07:30", "08:00",};
			int day = 0;
			int startTime = 0;
			int numberOfBlocks = 0;
			int numberOfNonExams = 0;
			for(int i=0; i<a.size(); i++){
				if(!a.get(i).checkExam()) numberOfNonExams++;
			}
			for(int i=0; i<numberOfNonExams; i++){

				for(int j=0; j<days.length; j++){
					if(days[j].equals(a.get(i).getDayOfWeek())) day = j;
				}

				for(int j=0; j<times.length; j++){
					if(times[j].equals(a.get(i).getStartTime())) startTime = j;
				}

				for(int j=0; j<durations.length; j++){
					if(durations[j].equals(a.get(i).getDuration())) numberOfBlocks = j+1;
				}

				for(int j=0; j<numberOfBlocks; j++){
					System.out.println(labelArray[startTime][day].getText());
					if(j==0){
						if(labelArray[startTime][day].getText().equals("\t\t")){
							labelArray[startTime][day].setText(a.get(i).getCourseID());
							labelArray[startTime][day].setToolTipText(a.get(i).toString());
							labelArray[startTime][day].setBorder( BorderFactory.createLineBorder( colorArray[2], borderThickness ) );
							labelArray[startTime][day].setBackground( colorArray[2] );
						}
						else{
							labelArray[startTime][day].setText(labelArray[startTime][day].getText() + " + " + a.get(i).getCourseID());
							labelArray[startTime][day].setToolTipText("CONFLICT! " + labelArray[startTime][day].getToolTipText() + " Conflicts With " + a.get(i).toString());
							labelArray[startTime][day].setBorder( BorderFactory.createLineBorder( colorArray[8], borderThickness ) );
							labelArray[startTime][day].setBackground( colorArray[8] );
						}
					}
					else{
						if(labelArray[startTime+j][day].getBackground().equals(colorArray[0])){
							labelArray[startTime+j][day].setBorder( BorderFactory.createLineBorder( colorArray[2], borderThickness ) );
							labelArray[startTime+j][day].setBackground( colorArray[2] );
						}
						else{
							labelArray[startTime+j][day].setBorder( BorderFactory.createLineBorder( colorArray[8], borderThickness ) );
							labelArray[startTime+j][day].setBackground( colorArray[8] );
						}
						if(!labelArray[startTime+j][day].getText().equals("\t\t")){
							labelArray[startTime+j][day].setToolTipText("CONFLICT! " + labelArray[startTime][day].getToolTipText() + " Conflicts With " + a.get(i).toString());
						}
					}
				}
			}
			repaint();
		}

		//test stuff
		/**labelArray[12][2].setText("CPSC101");
		labelArray[12][2].setBackground( colorArray[7] );
		labelArray[12][2].setBorder( BorderFactory.createLineBorder( colorArray[7], borderThickness ) );
		labelArray[13][2].setBackground( colorArray[7] );
		labelArray[13][2].setBorder( BorderFactory.createLineBorder( colorArray[7], borderThickness ) );
		labelArray[14][2].setBackground( colorArray[7] );
		labelArray[14][2].setBorder( BorderFactory.createLineBorder( colorArray[7], borderThickness ) );*/
		
		

	
	
	
	//westPanel Panel for the main Frame (this)
	private class WestPanel extends JPanel
	{
		
	private ArrayList<JComboBox> boxes;
	private ArrayList<JButton> addButtons;
	private ArrayList<RButton> removeButtons;
	private Dimension cBDimensions = new Dimension(200, 40);
	private Dimension jBDimensions = new Dimension(40, 40);
	private GridBagLayout layout = new GridBagLayout();
	private GridBagConstraints gbc = new GridBagConstraints();
	private Object[] courseList;

	public WestPanel(Object[] a) {
		boxes = new ArrayList<JComboBox>();
		addButtons = new ArrayList<JButton>();
		removeButtons = new ArrayList<RButton>();
		courseList = a;

		setLayout(layout);

		addComboBox();
		addRemoveButton();
		addAddButton();
		addComponents();

	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g2);
	}

	private void addComboBox() {
		boxes.add(new JComboBox(courseList));
	}

	// I apologize for this terrible method name -Erik
	private void addAddButton() {
		addButtons.add(new AButton(addButtons.size()));
	}

	private void addRemoveButton() {
		removeButtons.add(new RButton(removeButtons.size()));
	}

	private void removeComboBox(int a) {
		boxes.remove(a);
	}

	private void removeAddButton(int a) {
		addButtons.remove(a);
	}

	private void removeRemoveButton(int a) {
		removeButtons.remove(a);
	}

	private void addComponents() {
		for (int i = 0; i < boxes.size(); i++) {
			gbc.gridy = i;
			gbc.gridx = 0;
			gbc.fill = GridBagConstraints.NONE;
			gbc.weighty = 0;
			if(i==boxes.size()-1) gbc.weighty = 1;
			gbc.anchor = GridBagConstraints.NORTH;
			add(boxes.get(i), gbc);
			gbc.gridx = 1;
			add(addButtons.get(i), gbc);
			gbc.gridx = 2;
			add(removeButtons.get(i), gbc);
		}
	}
	private class AButton extends JButton{
		int index;

		public AButton(int a){
			super("Add");
			index = a;
			addMouseListener(new AddButtonListener());
		}
		private class AddButtonListener implements MouseListener {
			boolean hasBeenClicked = false;

			public void mouseClicked(MouseEvent e) {
				if (!hasBeenClicked) {
					//WestPanel specific stuff
					addComboBox();
					addAddButton();
					addRemoveButton();
					removeAll();
					addComponents();
					revalidate();
					repaint();
					hasBeenClicked = true;

					//TimeTable specific
					addBlocks(((Course) boxes.get(index).getSelectedItem()).getMeetings());
				}
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

		}
	}


	private class RButton extends JButton {
		int index;
	
		public RButton(int b){
			super("Remove");
			index = b;
			addMouseListener(new RemoveButtonListener());
		}
	
		public int getIndex(){
			return index;
		}
		
		public void shiftUp(){
			index--;
		}
	
		private class RemoveButtonListener implements MouseListener {


			public void mouseClicked(MouseEvent e) {
				
				System.out.println(index);
				if (boxes.size() > 1) {
					removeComboBox(index);
					removeAddButton(index);
					removeRemoveButton(index);
					removeAll();
					addComponents();
					revalidate();
					repaint();
					shiftAllUp(index);
				}
				else{
					System.out.println("In");
					removeComboBox(index);
					removeAddButton(index);
					removeRemoveButton(index);
					addComboBox();
					addRemoveButton();
					addAddButton();
					removeAll();
					addComponents();
					revalidate();
					repaint();
					//shiftAllUp(index);
				}

			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

		}

	}
	
	private void shiftAllUp(int a){
		for(int i=a; i<removeButtons.size(); i++){
			removeButtons.get(i).shiftUp();
		}
	}
}
}



