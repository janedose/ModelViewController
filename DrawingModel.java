import java.util.ArrayList;

public class DrawingModel {
	// the list of the shapes
	private ArrayList<Shape> shapes = new ArrayList<Shape>();

	// the list of the views connected to this model
	private ArrayList<View> views = new ArrayList<View>();
	protected boolean changed = false;		//flag for TextViewer
	
	// A client should be able to add a Shape to the model
	public void addShape(Shape s) {
		shapes.add(s);
		updateAll();
	}

	// A viewer should be able to register with the model
	public void addView(View v) {
		views.add(v);
		v.update(this);
	}
	
	public void addTextViewer(TextViewer tv) {
		views.add(tv);
		tv.update(this);
	}

	// It should notify all viewers when something in the model changes.
	public void updateAll() {
		for (View v : views) {
			v.update(this);
		}
	}
	
	// Returns the list of the shapes
	public ArrayList<Shape> getShapes() {
		return shapes; 
	}
	

	public boolean addLevel(int x, int y) {
		boolean b = true;
		for(Shape s : shapes) {
			// if (x,y) is within s, add a level to s
			if (s.contains(x,y)) {
				b = s.addLevel();
				changed = b;
			}
		}
		updateAll();
		return b;
	}

	public void reset() {

		for(Shape s : shapes) {
			s.resetShape();
		}
		changed = true;

	}

}









