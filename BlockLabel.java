import javax.swing.*;
import java.awt.*;
import java.util.*;

public class BlockLabel extends JLabel{
	ArrayList<String> allLabelText = new ArrayList<String>();
	ArrayList<String> allToolTipText = new ArrayList<String>();
	String labelText = "";
	String toolTipText = "";


	public BlockLabel(){
		allLabelText = new ArrayList<String>();
		allToolTipText = new ArrayList<String>();
	}

	public BlockLabel(String a, int b){
		super(a,b);
		allLabelText = new ArrayList<String>();
		allToolTipText = new ArrayList<String>();
	}

	public boolean setCustomText(String a){
		for(int i=0; i<allLabelText.size(); i++){
			if(a.equals(allLabelText.get(i))) return true;
		}
		allLabelText.add(a);
		labelText = "";
		if(allLabelText.size() > 0){
			for(int i=0; i<allLabelText.size(); i++){
				if(i==0){
					labelText += allLabelText.get(i);
				}
				else labelText += " + " + allLabelText.get(i);
			}
		}
		super.setText(labelText);
		return false;
	}

	public void removeCustomText(String a){
		labelText = "";
		for(int i=0; i<allLabelText.size(); i++){
			if(allLabelText.get(i).equals(a)) allLabelText.remove(i);
		}
		if(allLabelText.size() > 0){
			for(int i=0; i<allLabelText.size(); i++){
				if(i==0){
					labelText += allLabelText.get(i);
				}
				else labelText += " + " + allLabelText.get(i);
			}
			super.setText(labelText);
		}
		else super.setText("\t\t");
	}

	public void setToolTipText(String a){
		allToolTipText.add(a);
		toolTipText = "";
		if(allToolTipText.size() > 0){
			for(int i=0; i<allToolTipText.size(); i++){
				if(i==0){
					toolTipText += allToolTipText.get(i);
				}
				else toolTipText += " Conflicts with " + allToolTipText.get(i);
			}
		}
		super.setToolTipText(toolTipText);
	}

	public void removeToolTipText(String a){
		toolTipText = "";
		if(allToolTipText.size() > 0){
			for(int i=0; i<allToolTipText.size(); i++){
				if(i==0){
					toolTipText += allToolTipText.get(i);
				}
				else toolTipText += " Conflicts with " + allToolTipText.get(i);
			}
		}
		super.setToolTipText(toolTipText);
	}

	public void setColor(){
		if(getBackground().equals(Color.WHITE)){
			setBorder(BorderFactory.createLineBorder( Color.CYAN, 1 ));
			setBackground(Color.CYAN);
		}
		else if(getBackground().equals(Color.CYAN)){
			setBorder(BorderFactory.createLineBorder( Color.RED, 1 ));
			setBackground(Color.RED);
		}
	}

	public void resetColor(){
		if(getBackground().equals(Color.CYAN)){
			setBorder(BorderFactory.createLineBorder( Color.BLACK, 1 ));
			setBackground(Color.WHITE);
		}
		else if(getBackground().equals(Color.RED) && allToolTipText.size() == 1){
			setBorder(BorderFactory.createLineBorder( Color.CYAN, 1 ));
			setBackground(Color.CYAN);
		}
	}
}
