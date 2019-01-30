import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class MainClass {
	public static final int WIDTH = 800;
	public static final int HEIGHT = 500;
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> createGUI());
	}

	public static void createGUI() {
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// What goes in the frame
		Viewer v = new Viewer();
		frame.add(v);
		
		// Buttons at the top of the frame
		JRadioButton add = new JRadioButton("Add level");
		JButton reset = new JButton("Reset");
		JPanel southPanel = new JPanel();
		southPanel.setBackground(Color.WHITE);
		southPanel.add(add);
		southPanel.add(reset);
		frame.add(southPanel, BorderLayout.SOUTH);

		// Connect the view/TextViewer to a model
		DrawingModel model = new DrawingModel();
		model.addShape(new FibonacciSquare(285, 250, 4, 1, Color.BLUE, 1));
		model.addShape(new HShape(405, 15, 378, Color.GREEN, 1));
		model.addView(v);
		TextViewer tv = new TextViewer();
		model.addView(tv);

		//controllers
		ResetController resetCon = new ResetController(model);
		reset.addActionListener(resetCon);
		Controller controller = new Controller(add, model);
		add.addActionListener(controller);
		// The controller listens to the mouse clicks on the display panel
		v.addMouseListener(controller);

		// Show it (execute this line last)
		frame.setVisible(true);

	}

}




