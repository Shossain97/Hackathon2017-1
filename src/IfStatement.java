import java.awt.Color;
import javax.swing.*;
import java.awt.Component;
import java.awt.event.*;

public class IfStatement extends BaseComponent 
{
	private String[] operatorsList;
	private String[] statementList;

	public IfStatement()
	{
		name="If Statement";
		this.setText(name);
		baseText="if(";
		frame=new JFrame(name);
		inputText=new JTextField(5);
		inputLabel=new JLabel();
		inputPanel=new JPanel();
		inputPanel.setOpaque(true);
		inputPanel.setBackground(borderColor);
		inputLabel.setForeground(borderColor);
		Button.addActionListener(submitListener());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inputPanel.add(inputLabel);
		inputPanel.add(inputText);
		inputPanel.add(Button);
		frame.setSize(500,300);
	/*	operatorsList=new String[]*/
	}
	private ActionListener submitListener()
	{
		ActionListener submitListen=new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{

				String userInput=inputText.getText();
				
			}
		};
		return submitListen;
	}
	
}
