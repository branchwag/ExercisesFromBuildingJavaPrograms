import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Olympics extends JPanel {

	private static final int RING_DIAMETER = 100;
	private static final int STROKE_WIDTH = 6;

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		//anti-aliasing for smoother circles
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setStroke(new BasicStroke(STROKE_WIDTH));

		// Calculate positions for the rings
		// The total width of the formation is about 3 * RING_DIAMETER
		// The total height is about 1.5 * RING_DIAMETER
		int centerX = getWidth() / 2;
		int centerY = getHeight() / 2;
		
		// Calculate the x-coordinate for the leftmost ring (blue)
		int blueX = centerX - RING_DIAMETER;
		int topRowY = centerY - RING_DIAMETER / 4;
		int bottomRowY = centerY + RING_DIAMETER / 4;
		
		// Draw the Olympic rings with their respective colors
		drawRing(g2d, blueX, topRowY, Color.BLUE);                   // Blue (top left)
		drawRing(g2d, centerX, topRowY, Color.BLACK);                // Black (top center)
		drawRing(g2d, centerX + RING_DIAMETER, topRowY, Color.RED);  // Red (top right)
		drawRing(g2d, centerX - RING_DIAMETER/2, bottomRowY, Color.YELLOW); // Yellow (bottom left)
		drawRing(g2d, centerX + RING_DIAMETER/2, bottomRowY, new Color(0, 128, 0)); // Green (bottom right)
	}

	private void drawRing(Graphics2D g2d, int x, int y, Color color) {
		// Save the current color
		Color oldColor = g2d.getColor();
		
		// Set the new color for the ring
		g2d.setColor(color);
		
		// Create and draw the ring
		Ellipse2D.Double ring = new Ellipse2D.Double(
		    x - RING_DIAMETER / 2,
		    y - RING_DIAMETER / 2,
		    RING_DIAMETER,
		    RING_DIAMETER
		);
		g2d.draw(ring);
		
		// Restore the original color
		g2d.setColor(oldColor);
	}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Olympic Rings");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 300);
            frame.add(new Olympics());
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
