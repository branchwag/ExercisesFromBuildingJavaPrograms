import javax.swing.*;
import java.awt.*;

public class BullsEye extends JPanel {
	private static final int WINDOW_WIDTH = 400;
	private static final int WINDOW_HEIGHT = 400;
	private static final int NUMBER_OF_RINGS = 5;

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int width = getWidth();
		int height = getHeight();
		int centerX = width / 2;
		int centerY = height / 2;

		int maxRadius = Math.min(width, height) / 2;

		int ringWidth = maxRadius / NUMBER_OF_RINGS;

		for (int i = 0; i < NUMBER_OF_RINGS; i++) {
			int radius = maxRadius - (i * ringWidth);

			if ( i % 2 == 0) {
				g.setColor(Color.BLACK);
			} else {
				g.setColor(Color.WHITE);
			}

			g.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
		}
	}

	public Dimension getPreferredSize() {
		return new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("Bull's Eye");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			BullsEye bullsEye = new BullsEye();
			frame.add(bullsEye);
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		});
	}
}
