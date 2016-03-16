import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FileChooser extends JFrame
{
	//class variables
	//components
	private JButton button;
	private JLabel label;
	private JLabel background;
	private ImageIcon icon;
	private JTextField jtf;

	//Panels
	private JPanel logoPanel;
	private JPanel inputPanel;

	//grid bag stuff
	private GridBagConstraints gbc;

	//Font variables
	private Font labelFont = new Font( "Monospace", Font.BOLD, 14);
	private Font reg = new Font( "Monospace", Font.BOLD, 12);

	//file path string
	private String filepath;

	public FileChooser()
	{
		//setting the layout
		this.setLayout(new BorderLayout());
		this.setTitle( "CPCS101 Final Project by Double-Double");

		//initializing panels
		logoPanel = new JPanel();
		inputPanel = new JPanel();

		//creating the label
		label =  new JLabel();
		jtf = new JTextField();
		button = new JButton();

		//creating the background label
		background = new JLabel( new ImageIcon("Logo_Images/LogoPopUp2.jpeg") );
		icon = new ImageIcon("Logo_Images/LogoIconSize.jpeg");

	}


	public void runFileChooser()
	{

		//panel for the button n stuff
		inputPanel.setLayout( new GridBagLayout() );
		inputPanel.setBackground( Color.WHITE );
		inputPanel.setBorder( BorderFactory.createLineBorder( Color.GRAY, 1 ) );

		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;

		//adding a actionlistener to the button
		button.addActionListener(new ActionListener()
		{
			@Override public void actionPerformed(ActionEvent e) 
			{
				filepath = jtf.getText();
				setVisible( false );

				Gui gui = new Gui( getFilePath() );
			}
		});
		
		//adding the label
		label.setText( "ENTER FILE PATH:  " );
		label.setFont( labelFont );
		label.setHorizontalAlignment( SwingConstants.RIGHT );

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets( 8, 0, 0, 0 );
		gbc.weightx = 0.5;
		gbc.weighty = 0.5;
		gbc.gridx = 0;
		gbc.gridy = 0;

		inputPanel.add( label, gbc );

		//adding the textfield
		jtf.setText( "csvs/January 2017 First Draft.csv" );
		jtf.setFont( reg );

		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.weightx = 0.5;
		gbc.weighty = 0.5;
		gbc.insets = new Insets( 8, 0, 0, 8 );
		gbc.gridx = 1;
		gbc.gridy = 0;

		inputPanel.add(jtf, gbc);

		//adding the button
		button.setText( "Start" );

		gbc.anchor = GridBagConstraints.LAST_LINE_END;
		gbc.weightx = 0.5;
		gbc.weighty = 0.0;
		gbc.insets = new Insets( 15, 150, 8, 8 );
		gbc.gridx = 2;
		gbc.gridy = 1;

		inputPanel.add(button, gbc);
		
		//JFrame stuff
		this.add(logoPanel, BorderLayout.CENTER);
		logoPanel.add( background, BorderLayout.CENTER);
		this.add(inputPanel, BorderLayout.SOUTH);
		//this.setSize( 545, 535 );
		this.setIconImage(icon.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable( false );
		pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	


	public String getFilePath()
	{
		return filepath;
	}
	
}
