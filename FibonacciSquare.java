import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

public class FibonacciSquare extends AbstractShape {
	private int n; // position in the fibonacci sequence
	private int quadrant; // 1, 2, 3, or 4

	public FibonacciSquare(int x, int y, int n, int quadrant, Color color, int level) {
//		super(x, y, fibonacci(n), color, level);
//		children = new Shape[1];
		super(x, y, fibonacci(n), color, level);
		children = new Shape[1];
		this.x = x;
		this.y = y;
		this.color = color;
		this.n = n;
		if (quadrant > 4 || quadrant < 1) {
			this.quadrant = 1;
		}else {
		this.quadrant = quadrant;
		}
		
	}

	public static int fibonacci(int n) {
		// returns the value of the nth Fibonacci number
		int fn;
		if (n <= 2) {
			fn = 1;
		}else {
			fn = fibonacci(n - 2) + fibonacci(n - 1);
		}
		return fn;
	}

	@Override
	public void draw(Graphics g) {
		// draw a square of side length = size
		// g.drawRect(arg0, arg1, arg2, arg3);
		// draw an arc (depend on the quadrant)
		// g.drawArc(x1, y1, width, height, startAngle, arcAngle);
		g.drawRect(x, y, size, size);
		if (quadrant == 1) {
			g.drawArc(x - size, y, 2 * size, 2 * size, 0, 90);
		} else if (quadrant == 2) {
			g.drawArc(x, y, 2 * size, 2 * size, 90, 90);
		} else if (quadrant == 3) {
			g.drawArc(x, y - size, 2 * size, 2 * size, 180, 90);
		} else if (quadrant == 4) {
			g.drawArc(x - size, y - size, 2 * size, 2 * size, 270, 90);
		}
		if (children[0] == null) {
			g.drawRect(x, y, size, size);
			if (quadrant == 1) {
				g.drawArc(x - size, y, 2*size, 2*size, 0,90);
			}
			if (quadrant == 2) {
				g.drawArc(x, y, 2*size, 2*size, 90, 90);
				}
			if (quadrant == 3) {
				g.drawArc(x, y - size, 2*size, 2*size, 180, 90);
				}
			else if (quadrant == 4) {
				g.drawArc(x - size, y - size, 2*size, 2*size, 270, 90);
			}
		} else {
			for (Shape child : children) {
				child.draw(g);
			}
		}
	}

	@Override
	public boolean contains(int x, int y) {
		return x <= MainClass.WIDTH / 2;
	}

	@Override
	public boolean createChildren() {
		int newx = 0 ;
		int newy = 0;
		if (fibonacci(n+1)<350) {
			int newN = n + 1;
			if (quadrant == 1) {
				newx = x - fibonacci(newN);
				newy = y;
			} else if (quadrant == 2) {
				newx = x;
				newy = y + size;
			} else if (quadrant == 3) {
				newx = x + size;
				newy = y + size - fibonacci(newN);
			} else if (quadrant == 4) {
				newx = x - fibonacci(newN) + size;
				newy = y - fibonacci(newN);
			}
			children[0] = new FibonacciSquare(newx, newy, newN, quadrant + 1, color, level);
			return true;
		}else {
		return false;
		}
	}
	
	public void resetShape() {
		children = new Shape[1];	
		this.level = 1;
	}
}
