import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class CharsTextListener implements TextListener {

	@Override
	public void textValueChanged(TextEvent e) {
		System.out.println("debug");

	}

}
