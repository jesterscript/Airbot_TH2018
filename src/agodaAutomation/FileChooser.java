package agodaAutomation;

import javax.swing.JFileChooser;

public class FileChooser {
	
	String someString="secili degil";
	JFileChooser newfile = new JFileChooser();
	
	public String pick() {
		if(newfile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			someString = newfile.getSelectedFile().toString();
			System.out.println(someString);
			
		}
		return someString;
		
	}
	
	

}
