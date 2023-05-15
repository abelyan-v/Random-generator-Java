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
			this.lengthSlider.setValue(Integer.parseInt(this.lengthTextField.getText()));
		}
		catch (NumberFormatException e1) {
			this.lengthTextField.setText("0");
		}
	}

}