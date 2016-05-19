package customer;

import javax.swing.JOptionPane;

public class NameInput {
	public String nameInput(){
		String tmp = JOptionPane.showInputDialog
						("Please state your name");
		return tmp;
	}
}
