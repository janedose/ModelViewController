import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Controller for only the reset button
 * @author yolanda
 *
 */
public class ResetController implements ActionListener{
	private DrawingModel model;
	
	public ResetController(DrawingModel model) {
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		model.reset();
		System.out.println("Model has been reset.");
	}
}
