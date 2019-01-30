import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
/**
 * This is the radio button controller
 * @author yolanda
 *
 */
public class Controller implements ActionListener, MouseListener {
	private DrawingModel model;
	private JRadioButton rb1;

	public Controller(JRadioButton rb1, DrawingModel model) {
		this.rb1 = rb1;
		this.model = model;
		
		ButtonGroup bg=new ButtonGroup();    
		bg.add(rb1);
		rb1.doClick();
	}

	@Override
	public void mousePressed(MouseEvent e) {
//		System.out.printf("(x,y)=(%d,%d)\n", e.getX(), e.getY());
		if (rb1.isSelected()) {
			boolean success = model.addLevel(e.getX(), e.getY());
			if (!success) {
				JOptionPane.showMessageDialog(rb1, "Cannot add any more levels."); 
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
