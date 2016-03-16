import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class FileChooser extends JFrame{
	JButton jbt1;
	JButton jbt2;
	JTextField jtf;
	private String filepath;
	
	public FileChooser(){
		setLayout(new BorderLayout());
		jtf = new JTextField(10);
		jbt1 = new JButton("Select");
		jbt2 = new JButton("Clear");
		JPanel inputPanel = new JPanel();
		JPanel logoPanel = new JPanel(); // you can put the logo here.
		jbt1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				filepath = jtf.getText();
				
			}
			
		});
		jbt2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				jtf.setText("");
				
			}
			
		});
		
		Label label =  new Label("Please type the file path:");
		
		inputPanel.setLayout(new GridLayout(2,2));
		inputPanel.add(label);
		inputPanel.add(jbt1);
		inputPanel.add(jtf);
		inputPanel.add(jbt2);
		
		this.add(logoPanel,BorderLayout.CENTER);
		this.add(inputPanel, BorderLayout.SOUTH);
		this.setSize(400,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}
	
	public String getFilePath(){
		return filepath;
	}
	
	public static void main(String[] args) {
		new FileChooser();
	}

}