//The for loop class
import java.awt.Color;
import javax.swing.*;
import java.awt.Component;
import java.awt.event.*;

public class ForLoop extends BaseComponent 
{
	protected int startVar;
	protected int endVar;
	private String startVarString;
	private String endVarString;
	private String increaseDecrease;
	private String comparisonOperatorString;
	private String userInput;
	private String userInput2;
	private JTextField textBox2;
	private JLabel label2;
	public ForLoop()
	{
		name="For Loop";
		this.setText(name);
		baseText="for(var i=";
		frame=new JFrame(name);
		label2=new JLabel();
		inputText=new JTextField(5);
		inputLabel=new JLabel();
		inputPanel=new JPanel();
		textBox2=new JTextField(5);
		inputPanel.setOpaque(true);
		inputPanel.setBackground(Color.BLACK);
		inputLabel.setForeground(borderColor);
		Button.addActionListener(submitListener());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inputPanel.add(inputLabel);
		inputPanel.add(inputText);
		inputPanel.add(label2);
		inputPanel.add(Button);
		inputPanel.setBorder(compBorder);
		frame.getContentPane().add(inputPanel);
		frame.setSize(450,200);		
		
		
	}
	private void setStartVar()
	{
			
			inputLabel.setForeground(borderColor);
			inputLabel.setText("Input an initial integer to start from");
			frame.setVisible(true);
			

			try
			{
				userInput=startVarString;
				startVar=Integer.parseInt(startVarString);
				frame.setVisible(false);
				System.out.println("End of first try in setSTartVAR");
			}
			catch(Exception e)
			{
				inputLabel.setText("Invalid not Input");
				System.out.println("End of first catch in setSTartVAR");
				//setStartVar();
			}
			
		
	}
	private void setEndVar()
	{
		inputLabel.setForeground(borderColor);
		inputLabel.setText("Input an initial integer to end at");
		frame.setVisible(true);
		try
		{
			userInput=endVarString;
			startVar=Integer.parseInt(endVarString);
			frame.setVisible(false);
			System.out.println("End of try in setEndVar");
		}
		catch(Exception e)
		{
			inputLabel.setText("Invalid input");
			System.out.println("End of catch in setEndVar");
			//setEndVar();
		}
	}
	public void setOuterText()
	{
		System.out.println("in set outer text");
		setStartVar();
		setEndVar();
		if(startVar>endVar)
		{
			increaseDecrease="--";
			comparisonOperatorString=">";
		}
		else
		{
			increaseDecrease="++";
			comparisonOperatorString="<";
		}
		String beginning=baseText+startVarString+";i";
		String middle=startVar+comparisonOperatorString+endVarString+";i";
		OuterText=beginning+middle+increaseDecrease+"){";
	}

	private ActionListener submitListener()
	{
		ActionListener submitListen=new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{

				userInput=inputText.getText();
				setStartVar();
				
			}
		};
		return submitListen;
	}
}
