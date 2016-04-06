/**
*
*
* the GUI for CPSC101 final project
*
*
*@author Scott Howes, updated by Sam Kelly
*@version 04/04/2016
*
*/

import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;



public class Gui extends JFrame{

	//JFrame Variables
	private int width = 1060;
	private int height = 620; //550
	private String title = "CPCS101 Final Project by Double-Double";
	private Boolean resizable = true;
	private int minWidth = 700;
	private int minHeight = 350;

	//Color Variables Array
	private Color[]  colorArray= { Color.WHITE, Color.LIGHT_GRAY, Color.BLUE, Color.CYAN, Color.GREEN, 
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
	private BlockLabel[][] labelArray = new BlockLabel[28][7];
	//dimensions for those labels
	private JButton button;
	private Dimension courseDim = new Dimension( 100, 20 );
	private Dimension minCourseDim = new Dimension( 90, 2 );
	//Backend Variables
	private static File file;
	private static MasterSchedule master;
	//background image
	private JLabel background = new JLabel( new ImageIcon("Logo_Images/LogoBackground.jpeg") );
	private ImageIcon icon = new ImageIcon("Logo_Images/LogoIconSize.jpeg");
	


	//Constructor
	public Gui(File selectedFile)
	{	
		master = new MasterSchedule( selectedFile );

		//making the Panels
		makePanels();
		//calling the timetable panel
		timeTable();
		//makes the west panel
		this.add(new WestPanel(master.getCourses(),master.getProfs(),master.getRooms()),BorderLayout.WEST);

		//this.add( background );
		
		//JFrame Stuff
		this.setTitle( title );
		this.setResizable( resizable );
		this.setSize( width, height );
		this.setMinimumSize( new Dimension( minWidth, minHeight ) );
		this.setLocation(25,25);
		this.setIconImage( icon.getImage() );
		//setContentPane( background );
		this.setDefaultCloseOperation( this.EXIT_ON_CLOSE );
		this.setVisible(true);
	}
	
	
	
	//makes the Panels
	private void makePanels()
	{
	
		//creates the content Panels which Holds ALL other Panels for the timetable
		contentPanel = new JPanel( new BorderLayout() );
		contentPanel.add( background, BorderLayout.CENTER);
		//contentPanel.setBackground( Color.RED );
		contentPanel.setBorder( BorderFactory.createLoweredBevelBorder() );
		this.add( contentPanel, BorderLayout.CENTER );
		
		//This mainPanel is for the days of the week header and where the course info will go
		mainPanel = new JPanel( new BorderLayout() );
		//mainPanel.setOpaque(false);
		contentPanel.add( mainPanel, BorderLayout.CENTER );

		//creating the panel for the days of the week header ---> Horizontal BoxLayout
		//also adds it to the mainPanel
		daysOfWeek = new JPanel();
		//daysOfWeek.setBackground( colorArray[1] );
		daysOfWeek.setLayout( new BoxLayout( daysOfWeek, BoxLayout.X_AXIS ) );
		mainPanel.add( daysOfWeek, BorderLayout.NORTH );
		
		//creating stuff for the Times Column
		// a temp Panel for formatting
		temp = new JPanel( new BorderLayout() );
		temp.setBackground( colorArray[0] );
		//temp.setOpaque(false);
		contentPanel.add( temp, BorderLayout.WEST );
		//adds it to the main Panel
		times = new JPanel();
		//times.setBackground( colorArray[1] );
		times.setLayout( new GridLayout( 14, 1) );
		temp.add( times, BorderLayout.CENTER );
		
		//for the stuff where courses go
		timeTable = new JPanel();
		timeTable.setLayout( new GridBagLayout() );
		timeTable.setBackground( colorArray[0] );
		//timeTable.setOpaque(false);

		mainPanel.add( timeTable, BorderLayout.CENTER );

		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;

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
				labelArray[i][j] = new BlockLabel();
				labelArray[i][j].setText( "\t\t" );
				labelArray[i][j].setHorizontalAlignment( SwingConstants.CENTER );
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
			ArrayList<Meeting> meetings = new ArrayList<Meeting>(a);
			String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
			String[] times = {"08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00"};
			String[] durations = {"00:30", "01:00", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00", "04:30", "05:00", "05:30", "06:00", "06:30", "07:00", "07:30", "08:00",};
			int day = 0;
			int startTime = 0;
			int numberOfBlocks = 0;
			
			for(int i=0; i<meetings.size(); i++){
				if(meetings.get(i).checkExam()){
					meetings.remove(i);
					i--;
				}
			}

			for(int i=0; i<meetings.size(); i++){

				boolean allreadyAdded = false;
				for(int j=0; j<days.length; j++){
					if(days[j].equals(meetings.get(i).getDayOfWeek())) day = j;
				}

				for(int j=0; j<times.length; j++){
					if(times[j].equals(meetings.get(i).getStartTime())) startTime = j;
				}

				for(int j=0; j<durations.length; j++){
					if(durations[j].equals(meetings.get(i).getDuration())) numberOfBlocks = j+1;
				}

				for(int j=0; j<numberOfBlocks; j++){
					if(!allreadyAdded){
						if(j==0){
							allreadyAdded = labelArray[startTime][day].setCustomText(meetings.get(i).getCourseID());
							if(!allreadyAdded){
								labelArray[startTime][day].setToolTipText(meetings.get(i).toString());
								labelArray[startTime][day].setColor();
							}
						}
						else{
							labelArray[startTime+j][day].setColor();
						}
					}
				}
			}
		}

		public void removeBlocks(ArrayList<Meeting> a){
			ArrayList<Meeting> meetings = new ArrayList<Meeting>(a);
			String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
			String[] times = {"08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00"};
			String[] durations = {"00:30", "01:00", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00", "04:30", "05:00", "05:30", "06:00", "06:30", "07:00", "07:30", "08:00",};
			int day = 0;
			int startTime = 0;
			int numberOfBlocks = 0;
			
			for(int i=0; i<meetings.size(); i++){
				if(meetings.get(i).checkExam()){
					meetings.remove(i);
					i--;
				}
			}

			for(int i=0; i<meetings.size(); i++){
				for(int j=0; j<days.length; j++){
					if(days[j].equals(meetings.get(i).getDayOfWeek())) day = j;
				}

				for(int j=0; j<times.length; j++){
					if(times[j].equals(meetings.get(i).getStartTime())) startTime = j;
				}

				for(int j=0; j<durations.length; j++){
					if(durations[j].equals(meetings.get(i).getDuration())) numberOfBlocks = j+1;
				}

				for(int j=0; j<numberOfBlocks; j++){
					if(j==0){
						labelArray[startTime][day].removeCustomText(meetings.get(i).getCourseID());
						labelArray[startTime][day].removeToolTipText(meetings.get(i).toString());
						labelArray[startTime][day].resetColor();
					}
					else{
						labelArray[startTime+j][day].resetColor();
					}
				}
			}
		}


		
		

	
	
	
	//westPanel Panel for the main Frame (this)
private class WestPanel extends JPanel{
	SpringLayout sl;

	
	JComboBox courseBox;
	JComboBox profBox;
	JComboBox roomBox;
	JButton addCourseButton;
	JButton addProfButton;
	JButton addRoomButton;

	ArrayList<Object> addedObjects;
	JComboBox removeBox;
	JButton removeButton;

	//dimensions for stuff
	private Dimension buttonD = new Dimension( 120, 20 );
	private Dimension comboD = new Dimension( 190, 20 );



	public WestPanel(Object[] a, Object[] b, Object[] c){
		sl = new SpringLayout();
		setLayout(sl);
	
		courseBox = new JComboBox(a);
		courseBox.setPreferredSize( comboD );
		courseBox.setToolTipText("Select a Course");
		profBox = new JComboBox(b);
		profBox.setPreferredSize( comboD );
		profBox.setToolTipText("Select a Professor");
		roomBox = new JComboBox(c);
		roomBox.setPreferredSize( comboD );
		roomBox.setToolTipText("Select a Room");

		addCourseButton = new JButton("Add Course");
		addCourseButton.setToolTipText("Add selected course to timetable");
		addCourseButton.setPreferredSize( buttonD );
		addProfButton = new JButton("Add Prof");
		addProfButton.setToolTipText("Add courses by selected Professor to timetable");
		addProfButton.setPreferredSize( buttonD );
		addRoomButton = new JButton("Add Room");
		addRoomButton.setToolTipText("Add all course in selected room to timetable");
		addRoomButton.setPreferredSize( buttonD );

		addedObjects = new ArrayList<Object>();
		addedObjects.add("                     ");
		removeBox = new JComboBox(addedObjects.toArray());
		removeBox.setToolTipText("Select a Professor, Room, or Course to be removed");
		removeBox.setPreferredSize( comboD );
		removeButton = new JButton("Remove");
		removeButton.setToolTipText("Remove selected course from timetable");
		removeButton.setPreferredSize( buttonD );

		setBorder( BorderFactory.createLoweredBevelBorder() );

		add(courseBox);
		add(profBox);
		add(roomBox);
		add(addCourseButton);
		add(addProfButton);
		add(addRoomButton);
		add(removeBox);
		add(removeButton);


		sl.putConstraint(SpringLayout.NORTH,courseBox,40,SpringLayout.NORTH,this);
		sl.putConstraint(SpringLayout.WEST,courseBox,5,SpringLayout.WEST,this);
		sl.putConstraint(SpringLayout.WEST,addCourseButton,5,SpringLayout.EAST,courseBox);
		sl.putConstraint(SpringLayout.NORTH,addCourseButton,40,SpringLayout.NORTH,this);

		sl.putConstraint(SpringLayout.NORTH,profBox,10,SpringLayout.SOUTH,courseBox);
		sl.putConstraint(SpringLayout.WEST,profBox,5,SpringLayout.WEST,this);
		sl.putConstraint(SpringLayout.WEST,addProfButton,5,SpringLayout.EAST,profBox);
		sl.putConstraint(SpringLayout.NORTH,addProfButton,9,SpringLayout.SOUTH,courseBox);

		sl.putConstraint(SpringLayout.NORTH,roomBox,10,SpringLayout.SOUTH,profBox);
		sl.putConstraint(SpringLayout.WEST,roomBox,5,SpringLayout.WEST,this);
		sl.putConstraint(SpringLayout.NORTH,addRoomButton,9,SpringLayout.SOUTH,profBox);

		sl.putConstraint(SpringLayout.NORTH,removeBox,200,SpringLayout.SOUTH,roomBox);
		sl.putConstraint(SpringLayout.NORTH,removeButton,200,SpringLayout.SOUTH,addRoomButton);
		sl.putConstraint(SpringLayout.WEST,removeBox,5,SpringLayout.WEST,this);
		sl.putConstraint(SpringLayout.WEST,removeButton,5,SpringLayout.EAST,removeBox);


		sl.putConstraint(SpringLayout.WEST,addRoomButton,5,SpringLayout.EAST,roomBox);
		sl.putConstraint(SpringLayout.EAST,this,5,SpringLayout.EAST,addCourseButton);

		
		addButtonListeners();

	}

	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;

		super.paintComponent(g2);
		paintComponents(g2);

	}

	private void addButtonListeners(){
		addCourseButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				addBlocks(((Course) courseBox.getSelectedItem()).getMeetings());
				if(removeBox.getSelectedItem() instanceof String){
					removeBox.removeItem(removeBox.getSelectedItem());
				}
				if(removeBox.getItemCount() == 0){
					removeBox.addItem((Course) courseBox.getSelectedItem());
				}
				for(int i=0; i<removeBox.getItemCount(); i++){
					if(courseBox.getSelectedItem().equals(removeBox.getItemAt(i))) break;
					if(i == removeBox.getItemCount()-1) removeBox.addItem((Course) courseBox.getSelectedItem());
				}
			}
		});
		addProfButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				addBlocks(((Prof) profBox.getSelectedItem()).getMeetings());
				if(removeBox.getSelectedItem() instanceof String){
					removeBox.removeItem(removeBox.getSelectedItem());
				}
				if(removeBox.getItemCount() == 0){
					removeBox.addItem((Prof) profBox.getSelectedItem());
				}
				for(int i=0; i<removeBox.getItemCount(); i++){
					if(profBox.getSelectedItem().equals(removeBox.getItemAt(i))) break;
					if(i == removeBox.getItemCount()-1) removeBox.addItem((Prof) profBox.getSelectedItem());
				}
			}
		});
		addRoomButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				addBlocks(((Room) roomBox.getSelectedItem()).getMeetings());
				if(removeBox.getSelectedItem() instanceof String){
					removeBox.removeItem(removeBox.getSelectedItem());
				}
				if(removeBox.getItemCount() == 0){
					removeBox.addItem((Room) roomBox.getSelectedItem());
				}
				for(int i=0; i<removeBox.getItemCount(); i++){
					if(roomBox.getSelectedItem().equals(removeBox.getItemAt(i))) break;
					if(i == removeBox.getItemCount()-1) removeBox.addItem((Room) roomBox.getSelectedItem());
				}
			}
		});
		removeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(removeBox.getSelectedItem() instanceof Course){
					removeBlocks(((Course) removeBox.getSelectedItem()).getMeetings());
				}
				else if(removeBox.getSelectedItem() instanceof Prof){
					removeBlocks(((Prof) removeBox.getSelectedItem()).getMeetings());
				}
				else if(removeBox.getSelectedItem() instanceof Room){
					removeBlocks(((Room) removeBox.getSelectedItem()).getMeetings());
				}
				removeBox.removeItem(removeBox.getSelectedItem());
				for(int i=0; i<removeBox.getItemCount(); i++){
					if(removeBox.getItemAt(i) instanceof Course){
						addBlocks(((Course) removeBox.getItemAt(i)).getMeetings());
					}
					if(removeBox.getItemAt(i) instanceof Prof){
						addBlocks(((Prof) removeBox.getItemAt(i)).getMeetings());
					}
					if(removeBox.getItemAt(i) instanceof Room){
						addBlocks(((Room) removeBox.getItemAt(i)).getMeetings());
					}
				}
			}
		});
	}
}
}
