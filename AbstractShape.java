import java.awt.Color;
import java.util.ArrayList;

public abstract class AbstractShape implements Shape {
	protected int x, y, size, level;
	protected Color color;
	// the children of this shape
	protected Shape[] children;
	public AbstractShape(int x, int y, int size, Color color, int level) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.color = color;
		this.level = level;
	}

	@Override
	public boolean addLevel() {
		
		if (children[0] == null) {
			// possibly add a level
			// write a method createChildren() (declared in Shape
			// and implemented in Fibonacci and HShape)
			this.level++;
			return createChildren();
		} else {
			for (int i = 0; i <children.length-1; i++) {
				children[i].addLevel();
			}
			this.level++;
			return children[children.length-1].addLevel();
			}
		}

	@Override
	public String toString() {
		return "Shape = " +this.getClass() + ", Location: (" + x + ", " + y + "), Color = "
				+ color + ", Level = " + level;
	}

}

