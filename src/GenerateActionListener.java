import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenerateActionListener implements ActionListener {
	RandomGenerator random;
	
	public GenerateActionListener(RandomGenerator random) {
		this.random = random;
		/*
		random.debug2();
		random.debug();
		*/
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.random.text.setText(null);
		this.random.debug2();
		this.random.debug();
		
	}

}
