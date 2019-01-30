import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;

public class HShape extends AbstractShape {
	public HShape(int x, int y, int size, Color color, int level) {
		super(x, y, size, color, level);
		children = new Shape[7];
	}

	@Override
	public boolean createChildren() {
		// size of the children
		int childSize = size / 3;
		if (childSize > 10) {
			int index = 0;
			for (int row = 0; row < 3; row++) {
				for (int col = 0; col < 3; col++) {
					
					int xChild = x + size * col / 3;
					int yChild = y + size * row / 3;
					// create a new H (except at row = 0,2 and col = 1)
					if (col != 1 || row == 1) {
						children[index] = new HShape(xChild, yChild, size / 3, color, level);
						index++;					
					}
				}
			}
			return true;
		} else {
			// too small to create new children
			return false;
		}
	}


	@Override
	public void draw(Graphics g) {

		// draw an H by displaying
		// seven squares starting at location (x,y) and with
		// the given size

		// draw the H if it has no children
		if (children[0] == null) {
//			int sizeH = size / (3 * (int)Math.pow(3, (level - 1)));
			for (int i = 0; i < 3; i++) {
				drawSquare(g, color, x, y + i * size / 3, size / 3 + 1);
				drawSquare(g, Color.WHITE, x + size / 3, y + i * size / 3, size / 3 + 1);
				drawSquare(g, color, x + size / 3 * 2, y + i * size / 3, size / 3 + 1);
			}
			drawSquare(g, color, x + size / 3, y + size / 3, size / 3 + 1);
		} else {
			for (Shape child : children) {
				child.draw(g);
			}
		}
	}

	public static void drawSquare(Graphics g, Color c, int x, int y, int sizeH) {
		g.setColor(c);
		g.fillRect(x, y, sizeH, sizeH);
	}

	@Override
	public boolean contains(int x, int y) {
		return x >= MainClass.WIDTH / 2;
	}


	public void resetShape() {
		children = new Shape[7];	
		this.level = 1;
	}
}
