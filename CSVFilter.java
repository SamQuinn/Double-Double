import javax.swing.filechooser.FileFilter;
import java.io.*;

public class CSVFilter extends FileFilter {

	public static class CSVDef{
		public static final String csv = "csv";
		
		public static String getExtension(File f) {
	        String ext = null;
	        String s = f.getName();
	        int i = s.lastIndexOf('.');

	        if (i > 0 &&  i < s.length() - 1) {
	            ext = s.substring(i+1).toLowerCase();
	        }
	        return ext;
	    }
	}
	
	public boolean accept(File f){
		if(f.isDirectory() == true){
			return true;
		}
		
		String extension = CSVDef.getExtension(f);
		if(extension.equals(CSVDef.csv)){
			return true;
		} else {
			return false;
		}
	}
	
	public String getDescription(){
		return ".csv files";
	}
}
