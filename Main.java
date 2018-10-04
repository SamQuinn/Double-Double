/**
*
*Le Main Class
*
*@author Double-Double
*@version 03/15/2016
*
*/
//Comment
import javax.swing.*;

public class Main
{

	public static void main( String[] args )
	{	

		SwingUtilities.invokeLater( new Runnable()
		{
			@Override public void run()
			{
				FileChooser fc = new FileChooser();
				fc.runFileChooser();
			}
		});

	}

}
	
