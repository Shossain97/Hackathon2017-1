import java.util.ArrayList;
import java.util.AbstractCollection;
import java.awt.Color;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class RenameVariable extends BaseComponent
{
	private ArrayList<String> varsList;
	private String renameValue;
	private String variableName;
	private JLabel variableNameLabel;
	private JTextField variableNameText;
	public RenameVariable(ArrayList<String> List)
	{
		
		varsList=new ArrayList<String>();
		for(int i=0;i<List.size();i++)
		{
			varsList.add(List.get(i));
		}
		//varsList.addAll(List,0);
		inputText=new JTextField(5);
		inputPanel=new JPanel();
		variableNameLabel=new JLabel();
		variableNameLabel.setText("Input the name of the variable you are changing");
		variableNameLabel.setForeground(borderColor);
		variableNameLabel.setBackground(Color.BLACK);
		variableNameText=new JTextField(5);
		Button.addActionListener(submitListener());
		variableNameLabel.setText("Input the variables name you want to assign: ");
		inputPanel.add(variableNameLabel);
		inputPanel.add(variableNameText);
		inputPanel.add(inputLabel);
		inputPanel.add(inputText);
		inputPanel.add(Button);
		name = "Rename Variable";
		frame=new JFrame(name);
		frame.setContentPane(inputPanel);
		frame.setSize(400,150);
		run();
	}
	private ActionListener submitListener()
	{
		ActionListener submitListen=new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				if(varsList.contains(variableNameText.getText()))
				{
					renameValue=inputText.getText();
					variableName=variableNameText.getText();
					setOuterText();
				}
				else
				{
					variableNameLabel.setText("Invalid variable name");
				}
			}
		};
		return submitListen;
	}
	public void setOuterText()
	{
		OuterText=variableName+"="+renameValue+";";
		frame.setVisible(false);
	}
	public void run()
	{
		frame.setVisible(true);
	}
}
