import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.*;

public class MainWindow 
{	
	public static ArrayList<String> variables = new ArrayList<String>();
	
	public static void main(String[] args) 
	{
		UIManager.put("List.font", new Font("Courier", Font.BOLD, 18));
		UIManager.put("Button.font", new Font("Courier", Font.BOLD, 18));
		UIManager.put("Label.font", new Font("Courier", Font.BOLD, 18));
		
		// Set up the window frame.
		JFrame frame = new JFrame("Dropping Logic");
		frame.setSize(1080, 920);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Main panel container.
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		DragPanels dragPanels = new DragPanels(frame);
		
		FileBuilder fb = new FileBuilder(dragPanels.GetLogicPanel());
		
		mainPanel.add(dragPanels.GetComponentPanel(), BorderLayout.WEST);
		mainPanel.add(dragPanels.GetLogicPanel(), BorderLayout.CENTER);
		mainPanel.add(fb.GetButton(), BorderLayout.SOUTH);
		
		frame.getContentPane().add(mainPanel);
		frame.pack();
		frame.setVisible(true);
	}
	
	
}
