import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent; //actual event that occurs
import java.awt.event.ActionListener; //listening
import java.text.DecimalFormat;

public class Currency extends JFrame {

	private JTextField euroField;
	private JTextField dollarField;
	private final double CONVERSION_RATE = 1.10; // 1 euro = 1.10 usd
	private DecimalFormat df = new DecimalFormat("#.##");

	public Currency() {
		super("Currency Converter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 100);
		setLocationRelativeTo(null);
		setResizable(false);

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); //align, hgap, vgap
		
		JLabel euroLabel = new JLabel("Euro (€):");
		euroField = new JTextField(10); //num of col/chars to display

		JButton euroToDollarButton = new JButton(">");
		JButton dollarToEuroButton = new JButton("<");

		JLabel dollarLabel = new JLabel("Dollar ($):");
		dollarField = new JTextField(10);

		euroToDollarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				convertEuroToDollar();
			}
		});

		dollarToEuroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				convertDollarToEuro();
			}
		});

		panel.add(euroLabel);
		panel.add(euroField);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2, 1, 5, 5)); //rows, col, hgap, vgap
		buttonPanel.add(euroToDollarButton);
		buttonPanel.add(dollarToEuroButton);
		panel.add(buttonPanel);

		panel.add(dollarLabel);
		panel.add(dollarField);

		add(panel);

		pack();

		setVisible(true);
	}

	private void convertEuroToDollar() {
		try {
			double euroAmount = Double.parseDouble(euroField.getText());
			double dollarAmount = euroAmount * CONVERSION_RATE;
			dollarField.setText(df.format(dollarAmount));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Please enter a valid number.",
				"Invalid Input", JOptionPane.ERROR_MESSAGE);
			euroField.setText("");
		}
	}

	private void convertDollarToEuro() {
		try {
			double dollarAmount = Double.parseDouble(dollarField.getText());
			double euroAmount = dollarAmount / CONVERSION_RATE;
			euroField.setText(df.format(euroAmount));
		} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Please enter a valid number.",
				"Invalid Input", JOptionPane.ERROR_MESSAGE);
			dollarField.setText("");
		}
	}



	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Currency();
			}
		});
	}
}
