//The for loop class
import javax.swing.BoxLayout;
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
	private JPanel Panel1;
	private JPanel Panel2;
	private JPanel Panel3;
	
	private JTextField textBox2;
	private JLabel label2;
	public ForLoop()
	{
		//this.setBorder(compBorder);
		this.setBackground(Color.BLACK);
		this.setForeground(borderColor);
		name="For Loop";
		this.setText(" "+name);
		baseText="for(var i=";
		frame=new JFrame(name);
		label2=new JLabel();
		inputText=new JTextField(5);
		textBox2=new JTextField(5);
		inputLabel=new JLabel();
		inputPanel=new JPanel();
		Panel1=new JPanel();
		Panel1.setBackground(Color.BLACK);
		Panel1.setOpaque(true);
		//Panel1.setBorder(compBorder);
		Panel1.add(inputLabel);
		Panel1.add(inputText);
		Panel2=new JPanel();
		Panel2.setBackground(Color.BLACK);
		Panel2.setOpaque(true);
		//Panel2.setBorder(compBorder);
		Panel2.add(label2);
		Panel2.add(textBox2);
		Panel3=new JPanel();
		Panel3.add(Button);
		Panel3.setBackground(Color.BLACK);
		Panel3.setOpaque(true);
		//Panel3.setBorder(compBorder);
		inputPanel.setOpaque(true);
		inputPanel.setBackground(Color.BLACK);
		inputLabel.setForeground(borderColor);
		Button.addActionListener(submitListener());
		//inputPanel.add(inputLabel);
		//inputPanel.add(inputText);
		//inputPanel.add(label2);
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
		inputPanel.add(Panel1);
		inputPanel.add(Panel2);
		inputPanel.add(Panel3);
		//inputPanel.setBorder(compBorder);
		frame.getContentPane().add(inputPanel);
		frame.setSize(800,400);
		runForLoop();
		
		
	}
	private void setStartVar(String userInput)
	{
			
				startVarString=userInput;
				startVar=Integer.parseInt(startVarString);

	}
	private void setEndVar(String userInput2)
	{

			endVarString=userInput2;
			endVar=Integer.parseInt(endVarString);
			//System.out.println(endVar);

	}
	public void setOuterText()
	{
		
	
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
		//System.out.println(startVar);
		//System.out.println(endVar);
		String beginning=baseText+startVarString+";i";
		String middle=startVar+comparisonOperatorString+";i";
		OuterText=beginning+middle+increaseDecrease+"){";
		this.setText(baseText+startVarString+";i"+comparisonOperatorString+endVarString+";i"+increaseDecrease+")");
	}

	private ActionListener submitListener()
	{
		ActionListener submitListen=new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				try
				{
					//userInput=inputText.getText();
					//System.out.println(userInput);
					//userInput2=textBox2.getText();
					//System.out.println(userInput2);
					setStartVar(inputText.getText());
					setEndVar(textBox2.getText());
					setOuterText();
					frame.setVisible(false);
					
				}
				catch(Exception e)
				{
					inputLabel.setText("Invalid input");
					label2.setText("Invalid input");
				}
			
				
			}
		};
		return submitListen;
	}
	public void runForLoop()
	{
		inputLabel.setForeground(borderColor);
		inputLabel.setText("Input an initial integer to start from");
		label2.setForeground(borderColor);
		label2.setText("Input an integer to end at");
		frame.setVisible(true);
	}
	public void setInnerText(String text)
	{
		InnerText=text+"}";
	}
}
