import java.util.ArrayList;
import java.util.AbstractCollection;
import java.awt.Color;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;

public class RenameVariable extends BaseComponent
{
	//private ArrayList<String> varsList;
	private String renameValue;
	//private String variableName;
	private String selectedString;
	private JLabel reassignLabel;
	private JComboBox dropDown;
	private JPanel Panel1;
	private JPanel Panel2;

	public RenameVariable()
	{
		String[] tempArray=new String[MainWindow.variables.size()];
		for(int i =0; i<1+(MainWindow.variables.size());i++)
		{
			if(i==0)
			{
				tempArray[i]="";
			}
			tempArray[i]=MainWindow.variables.get(i-1);
		}
		dropDown=new JComboBox(tempArray);
		dropDown.addActionListener(comboListener());
		//varsList.addAll(List,0);
		inputPanel=new JPanel();
		inputLabel=new JLabel();
		inputText=new JTextField(5);
		Panel1=new JPanel();
		reassignLabel=new JLabel("Select a variable: ");
		reassignLabel.setForeground(borderColor);
		Panel1.setBackground(Color.BLACK);
		Panel1.add(reassignLabel);
		Panel1.add(dropDown);
		Panel2=new JPanel();
		Panel2.setBackground(Color.BLACK);
		inputLabel.setText("Input the value you would like to set to: ");
		Panel2.add(inputLabel);
		Panel2.add(inputText);
		inputLabel.setForeground(borderColor);
		Button.addActionListener(submitListener());
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
		inputPanel.add(Panel1);
		inputPanel.add(Panel2);
		inputPanel.add(Button);
		inputPanel.setBackground(Color.BLACK);
		inputPanel.setBorder(compBorder);
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
				renameValue=inputText.getText();
				setOuterText();
			}
		};
		return submitListen;
	}
	private ActionListener comboListener()
	{
		ActionListener ComboListen=new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String tempString=(String)dropDown.getSelectedItem();
				if(tempString=="")
				{
					inputLabel.setText("Invalid choice try again!");
				}
				else
				{
					selectedString=tempString;
				}
			}
		};
		return ComboListen;
		
	}
	public void setOuterText()
	{
		OuterText=selectedString+"="+renameValue+";";
		frame.setVisible(false);
		this.setText(selectedString+"="+renameValue);
	}
	public void run()
	{
		frame.setVisible(true);
	}
}
