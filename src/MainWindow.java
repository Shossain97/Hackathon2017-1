import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;

public class MainWindow 
{	
	public static void main(String[] args) 
	{
		// Set up the window frame.
		JFrame frame = new JFrame("Dropping Logic");
		frame.setSize(1080, 920);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Main panel container.
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		DragPanels dragPanels = new DragPanels(frame);
		
		mainPanel.add(dragPanels.GetComponentPanel(), BorderLayout.WEST);
		mainPanel.add(dragPanels.GetLogicPanel(), BorderLayout.EAST);
		
		frame.getContentPane().add(mainPanel);
		frame.pack();
		frame.setVisible(true);
		System.out.println("Hello fucker, mother world.");
		System.out.println("We have anal beads");
		System.out.println("Nooooo fuckery.");
		ForLoop text = new ForLoop();
		text.setOuterText();
	}
}
