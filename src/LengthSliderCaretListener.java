import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class LengthSliderCaretListener implements CaretListener {
	JTextField lengthTextField;
	JSlider lengthSlider;
	
	public LengthSliderCaretListener(JTextField lengthTextField, JSlider lengthSlider) {
		this.lengthTextField = lengthTextField;
		this.lengthSlider = lengthSlider;
	}
	
	@Override
	public void caretUpdate(CaretEvent e) {
		System.out.println("debug");
	}

}
