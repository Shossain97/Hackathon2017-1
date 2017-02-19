import java.awt.Color;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class JVar extends BaseComponent
{
	private JTextField assignText;
	private JLabel assignLabel;
	private String varName;
	private JPanel namingPanel;
	private JPanel assigningPanel;
	//private String assignedName;
	private String assignedValue;
	public JVar()
	{
		name="Declare Variable";
		this.setText(name);
		this.setBorder(compBorder);
		this.setBackground(Color.BLACK);
		this.setForeground(borderColor);
		Button.addActionListener(submitListener());
		baseText="var ";
		///////////////////////////////////////////////////////////////////////////////////////////////
		//////
		//////Initial Assignment vars
		//////
		///////////////////////////////////////////////////////////////////////////////////////////////
		inputLabel=new JLabel();
		inputLabel.setForeground(borderColor);
		inputLabel.setBackground(Color.BLACK);
		inputLabel.setText("Input a name for the variable: ");
		////TextField for var name
		inputText=new JTextField(3);
		namingPanel=new JPanel();
		namingPanel.setBackground(Color.BLACK);
		namingPanel.setOpaque(true);
		namingPanel.setLayout(new BoxLayout(namingPanel,BoxLayout.Y_AXIS));
		namingPanel.setBorder(compBorder);
		namingPanel.add(inputLabel);
		namingPanel.add(inputText);
		//////////////////////////////////////////////////////////////////////////////////////////
		/////
		//// SEcond half of panel
		/////
		//////////////////////////////////////////////////////////////////////////////////////////
		assignLabel=new JLabel();
		assignLabel.setForeground(borderColor);
		assignLabel.setBackground(Color.BLACK);
		assignLabel.setText("Input a value to set the variable to: ");
		assignText=new JTextField(3);
		assigningPanel=new JPanel();
		assigningPanel.setBackground(Color.BLACK);
		assigningPanel.setOpaque(true);
		assigningPanel.setLayout(new BoxLayout(assigningPanel,BoxLayout.Y_AXIS));
		assigningPanel.setBorder(compBorder);
		assigningPanel.add(assignLabel);
		assigningPanel.add(assignText);
		//////////////////////////////////////////////////////////////////////////////
		////
		///Main Panel
		////
		/////////////////////////////////////////////////////////////////////////////////
		inputPanel=new JPanel();
		inputPanel.setOpaque(true);
		inputPanel.setBackground(Color.BLACK);
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
		inputPanel.add(namingPanel);
		inputPanel.add(assigningPanel);
		inputPanel.add(Button);
		frame=new JFrame(name);
		frame.setContentPane(inputPanel);
		frame.setSize(800,450);
		run();
		
	}
	public void setOuterText()
	{
		OuterText=baseText+varName+"="+assignedValue+";";
		frame.setVisible(false);
		this.setText("Var "+varName+"="+assignedValue+";");
	}
	public String getVarName()
	{
		return varName;
	}
	private ActionListener submitListener()
	{
		ActionListener submitListen=new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				
				varName=inputText.getText();
				assignedValue=assignText.getText();
				setOuterText();
				
			}
		};
		return submitListen;
	}
	public void run()
	{
		frame.setVisible(true);
	}
}
