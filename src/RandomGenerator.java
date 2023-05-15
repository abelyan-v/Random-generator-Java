import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RandomGenerator {
	String chars_upper_letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String chars_lower_letters = "abcdefghijklmnopqrstuvwxyz";
	String chars_num = "0123456789";
	String chars_input = "";
	
	String ready_string = "";
	JTextArea text;
	ArrayList<JCheckBox> list_checkBox;
	JTextField lengthText;
	
	public RandomGenerator(JTextArea text, ArrayList<JCheckBox> list_checkBox, JTextField lengthText) {
		this.text = text;
		this.list_checkBox = list_checkBox;
		this.lengthText = lengthText;
	}
	
	void debug() {

		int min = 0;  
		int max = this.chars_input.length() - 1;
		int b;
		
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < Integer.parseInt(this.lengthText.getText()); j++) {
				b = (int)(Math.random()*(max-min+1)+min);
				System.out.println(b);
				this.ready_string += this.chars_input.charAt(b);
			}
			this.text.append(ready_string + "\n");
			this.ready_string = "";
		}
		
		System.out.println(this.ready_string);
		
	}
	
	void debug2 () {
		this.chars_input = "";
		
		if (this.list_checkBox.get(0).isSelected())
			this.chars_input = this.chars_input + this.chars_lower_letters;
		
		if (this.list_checkBox.get(1).isSelected())
			this.chars_input = this.chars_input + this.chars_upper_letters;
		
		if (this.list_checkBox.get(2).isSelected())
			this.chars_input = this.chars_input + this.chars_num;
		
		System.out.println("debug 2: " + this.chars_input);
	}
}
