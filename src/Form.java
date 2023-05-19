import java.awt.BorderLayout;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.io.FileWriter;
import java.io.IOException;
import java.awt.datatransfer.StringSelection;
import javax.swing.text.PlainDocument;

public class Form extends JFrame{
	public Form() {
		super("Random");
		pack();
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		setLocationRelativeTo(null);
		Container container = getContentPane();
		setVisible(true);
		final JPanel panel = new JPanel();
		container.add(panel);
		panel.setLayout(new BorderLayout());
		
		final JTextArea text = new JTextArea();
		
		JMenuBar menuBar = new JMenuBar();
		panel.add(menuBar, BorderLayout.NORTH);
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('f');
		menuBar.add(fileMenu);
		JMenu editMenu = new JMenu("Edit");
		editMenu.setMnemonic('e');
		menuBar.add(editMenu);
		JMenu helpJMenu = new JMenu("Help");
		helpJMenu.setMnemonic('h');
		menuBar.add(helpJMenu);
		
		//File menu
		JMenuItem newMenuItem = new JMenuItem("New");
		newMenuItem.setAccelerator(KeyStroke.getKeyStroke('N', KeyEvent.CTRL_MASK));
		newMenuItem.setMnemonic('n');
		ActionListener newActionListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				text.setText(null);
				
			}
		};
		newMenuItem.addActionListener(newActionListener);
		fileMenu.add(newMenuItem);
		JMenuItem saveMenuItem = new JMenuItem("Save");
		saveMenuItem.setAccelerator(KeyStroke.getKeyStroke('S', KeyEvent.CTRL_MASK));
		saveMenuItem.setMnemonic('s');
		ActionListener saveActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser fileChooser = new JFileChooser();
					
					fileChooser.setAcceptAllFileFilterUsed(false);
				    FileNameExtensionFilter saveFileFilter = new FileNameExtensionFilter("TXT", "txt");
				    fileChooser.addChoosableFileFilter(saveFileFilter);
					
					fileChooser.showDialog(panel, "Save");
					
					@SuppressWarnings("resource")
					FileWriter writer = new FileWriter(fileChooser.getSelectedFile() + ".txt");
					writer.write(text.getText());
					writer.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		};
		saveMenuItem.addActionListener(saveActionListener);
		fileMenu.add(saveMenuItem);
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.setAccelerator(KeyStroke.getKeyStroke('Q', KeyEvent.CTRL_MASK));
		exitMenuItem.setMnemonic('e');
		fileMenu.add(exitMenuItem);
		ActionListener exitMenuActionListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		};
		exitMenuItem.addActionListener(exitMenuActionListener);
		
		//Edit menu
		JMenuItem copyMenuItem = new JMenuItem("Copy");
		copyMenuItem.setAccelerator(KeyStroke.getKeyStroke('C', KeyEvent.CTRL_MASK));
		copyMenuItem.setMnemonic('c');
		editMenu.add(copyMenuItem);
		ActionListener copyActionListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		        StringSelection selection = new StringSelection(text.getSelectedText());
		        clipboard.setContents(selection, null);
				
			}
		};
		copyMenuItem.addActionListener(copyActionListener);
		
		//Popup menu
		JPopupMenu textPopupMenu = new JPopupMenu();
		text.setComponentPopupMenu(textPopupMenu);
		JMenuItem copyPopupMenuItem = new JMenuItem("Copy");
		copyPopupMenuItem.setAccelerator(KeyStroke.getKeyStroke('C', KeyEvent.CTRL_MASK));
		copyPopupMenuItem.setMnemonic('c');
		textPopupMenu.add(copyPopupMenuItem);
		copyPopupMenuItem.addActionListener(copyActionListener);

		panel.add(text);
		GridLayout bottomPanelLayout = new GridLayout(2, 0, 0, 0);
		JPanel panelBottom = new JPanel();
		panelBottom.setLayout(bottomPanelLayout);
		panel.add(panelBottom, BorderLayout.SOUTH);
		JPanel panelSlider = new JPanel();
		JPanel panelCharacters = new JPanel();
		panelBottom.add(panelSlider);
		panelBottom.add(panelCharacters);
		panelSlider.add(new JLabel("String length:"));
		final JSlider words_number = new JSlider(0, 100, 16);
		panelSlider.add(words_number);
		final JTextField words_number_text = new JTextField(3);
		PlainDocument lengthWordsDoc = (PlainDocument) words_number_text.getDocument();
		lengthWordsDoc.setDocumentFilter(new DigitFilter());
		words_number_text.setText("16");
		final CaretListener number_text_listener = new CharsCaretListener(words_number_text, words_number);
		words_number_text.addCaretListener(number_text_listener);
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
		
		panelSlider.add(new JLabel("Words number:"));
		JTextField numberOfWordsTextField = new JTextField(2);
		PlainDocument numberOfWordsDoc = (PlainDocument) numberOfWordsTextField.getDocument();
		numberOfWordsDoc.setDocumentFilter(new DigitFilter());
		numberOfWordsTextField.setText("10");
		panelSlider.add(numberOfWordsTextField);
		
		JButton generateButton = new JButton("Generate");
		panelCharacters.add(generateButton);

		
		RandomGenerator random = new RandomGenerator(text, list_checkBox, words_number_text, numberOfWordsTextField);
		
		//debug
		lower_letters.setSelected(true);
		upper_letters.setSelected(false);
		numbers.setSelected(true);
		//end debug
		
		ActionListener generateListener = new GenerateActionListener(random);
		generateButton.addActionListener(generateListener);
		
		ChangeListener wordsLenthChangeListener = new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				int wordsLengthInteger = words_number.getValue();
				String wordsLengthString = Integer.toString(wordsLengthInteger);
				
				try {
					words_number_text.setText(wordsLengthString);
				}
				catch (Exception e1) {
					
				}
				
			}
		};
		words_number.addChangeListener(wordsLenthChangeListener);
		
		setSize(500, 350);
	}
}