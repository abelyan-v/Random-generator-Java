import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class CharsCaretListener implements CaretListener {
	JTextField lengthTextField;
	JSlider lengthSlider;
	
	public CharsCaretListener(JTextField lengthTextField, JSlider lengthSlider) {
		this.lengthTextField = lengthTextField;
		this.lengthSlider = lengthSlider;
	}
	
	@Override
	public void caretUpdate(CaretEvent e) {
		try {
			String wordsLengthString = this.lengthTextField.getText();
			int wordsLengthInteger = Integer.parseInt(wordsLengthString);
			this.lengthSlider.setValue(wordsLengthInteger);
		}
		catch (NumberFormatException e1) {
			
		}
	}
}