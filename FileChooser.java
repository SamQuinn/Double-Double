import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class FileChooser extends JFrame
{
	//class variables
	//components
	private JButton button;
	private JLabel background;
	private ImageIcon icon;

	//Panels
	private JPanel logoPanel;
	private JPanel inputPanel;

	//grid bag stuff
	private GridBagConstraints gbc;
	
	private Gui gui;

	public FileChooser()
	{
		//setting the layout
		this.setLayout(new BorderLayout());
		this.setTitle( "CPCS101 Final Project by Double-Double");

		//initializing panels
		logoPanel = new JPanel();
		inputPanel = new JPanel();
		button = new JButton("Choose File");

		//creating the background label
		background = new JLabel( new ImageIcon("Logo_Images/LogoPopUp2.jpeg") );
		icon = new ImageIcon("Logo_Images/LogoIconSize.jpeg");

	}


	public void runFileChooser()
	{

		//panel for the button n stuff
		inputPanel.setLayout( new GridBagLayout() );
		inputPanel.setBackground( Color.WHITE );
		//inputPanel.setBorder( BorderFactory.createLineBorder( Color.GRAY, 1 ) );
		inputPanel.setBorder( BorderFactory.createLoweredBevelBorder() );
		logoPanel.setBorder( BorderFactory.createLoweredBevelBorder() );

		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;

		//adding a actionlistener to the button
		button.addActionListener(new ActionListener()
		{
			@Override public void actionPerformed(ActionEvent e) 
			{			
				JFileChooser fc = new JFileChooser();

				fc.setAcceptAllFileFilterUsed(false);
				fc.addChoosableFileFilter(new CSVFilter());

				int returnValue = fc.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fc.getSelectedFile();
					boolean fileWorks = true;
					try{
						Scanner sc = new Scanner(selectedFile);
					}catch(FileNotFoundException f){
						fileWorks = false;
					}
					if(fileWorks){
						setVisible( false );

						gui = new Gui(selectedFile);
					}
				}	
			}
		});

		inputPanel.add(button);
		
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
	
}
