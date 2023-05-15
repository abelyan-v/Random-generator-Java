import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.TextListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Form extends JFrame{
	public Form() {
		super("Random");
		pack();
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		setLocationRelativeTo(null);
		Container container = getContentPane();
		setVisible(true);
		JPanel panel = new JPanel();
		container.add(panel);
		panel.setLayout(new BorderLayout());
		JTextArea text = new JTextArea();
		panel.add(text);
		GridLayout bottomPanelLayout = new GridLayout(2, 0, 0, 0);
		JPanel panelBottom = new JPanel();
		panelBottom.setLayout(bottomPanelLayout);
		panel.add(panelBottom, BorderLayout.SOUTH);
		JPanel panelSlider = new JPanel();
		JPanel panelCharacters = new JPanel();
		panelBottom.add(panelSlider);
		panelBottom.add(panelCharacters);
		JSlider words_number = new JSlider(0, 100, 16);
		panelSlider.add(words_number);
		JTextField words_number_text = new JTextField(3);
		CaretListener number_text_listener = new CharsCaretListener(words_number_text, words_number);
		words_number_text.addCaretListener(number_text_listener);
		//SliderLiListener lengthSliderListener = new LengthSliderChangeListener(words_number_text, words_number);
		//CaretListener lengthSliderListener = new LengthSliderCaretListener(words_number_text, words_number);
		words_number.addChangeListener(null);
		
		panelSlider.add(words_number_text);
		JCheckBox lower_letters = new JCheckBox("a...z");
		JCheckBox upper_letters = new JCheckBox("A...Z");
		JCheckBox numbers = new JCheckBox("0...9");
		//JCheckBox special_characters = new JCheckBox(".,/\#!?^&*?");
		panelCharacters.add(lower_letters);
		panelCharacters.add(upper_letters);
		panelCharacters.add(numbers);
		ArrayList<JCheckBox> list_checkBox = new ArrayList<JCheckBox>();
		list_checkBox.add(lower_letters);
		list_checkBox.add(upper_letters);
		list_checkBox.add(numbers);
		
		JButton generateButton = new JButton("Generate");
		panelCharacters.add(generateButton);

		
		RandomGenerator random = new RandomGenerator(text, list_checkBox, words_number_text);
		
		//debug
		lower_letters.setSelected(true);
		upper_letters.setSelected(false);
		numbers.setSelected(true);
		//random.debug2();
		//random.debug();
		//end debug
		
		ActionListener generateListener = new GenerateActionListener(random);
		generateButton.addActionListener(generateListener);
		
		
		setSize(400, 350);
	}
}