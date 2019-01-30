/**
 * Text viewer just to display the shapes if the model changed
 * @author yolanda
 *
 */
public class TextViewer implements View {
	private DrawingModel model;
	public void update(DrawingModel model) {
		this.model = model;

		if (model.changed) {
			for (Shape s : model.getShapes()) {
				System.out.println(s);
			}
			model.changed = false;
		}
	}
}

