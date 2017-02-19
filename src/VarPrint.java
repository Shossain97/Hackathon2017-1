import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class VarPrint extends BaseComponent
{
	private String stringToPrint;
	private JLabel SecondLabel;
	public VarPrint()
	{
		inputLabel=new JLabel("Input a variable or a phrase you would like to print.");
		SecondLabel=new JLabel("If you would like a phrase please put quotes around it. e.g: \"A phrase\"");
		SecondLabel.setForeground(borderColor);
		name = " Print";
		inputPanel=new JPanel();
		this.setText(name);
		inputText=new JTextField(7);
		Button.addActionListener(submitListener());
		inputPanel.setBackground(Color.BLACK);
		inputPanel.setBorder(compBorder);
		inputLabel.setBackground(Color.BLACK);
		inputLabel.setForeground(borderColor);
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
		inputPanel.add(inputLabel);
		inputPanel.add(SecondLabel);
		inputPanel.add(inputText);
		inputPanel.add(Button);
		frame=new JFrame(name);
		frame.setContentPane(inputPanel);
		frame.setSize(950,150);
		run();
	}
	private ActionListener submitListener()
	{
		ActionListener submitListen=new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				stringToPrint=inputText.getText();
				setOuterText();
			}
		};
		return submitListen;
	}
	public void setOuterText()
	{
		OuterText="chalk.println("+stringToPrint+".toString());";
		this.setText(" Print "+stringToPrint);
		frame.setVisible(false);
		
	}
	public void run()
	{
		frame.setVisible(true);
	}
}
