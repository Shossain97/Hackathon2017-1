//Base label class not directly seen on the UI 
import java.awt.Color;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Component;
public class BaseComponent extends JLabel
{
	protected String name;
	protected String OuterText;
	protected Color borderColor;
	protected String InnerText;
	protected Border compBorder;
	protected Border greenLine;
	protected Border greenLine2;
	protected String baseText;
	protected JFrame frame;
	protected JTextField inputText;
	protected JLabel inputLabel;
	protected JPanel inputPanel;
	protected JButton Button;
	
	public BaseComponent()
	{
		this.setBackground(Color.BLACK);
		borderColor=new Color(0,255,0);
		greenLine=BorderFactory.createLineBorder(borderColor);
		greenLine2=BorderFactory.createLineBorder(borderColor);
		compBorder=BorderFactory.createCompoundBorder(greenLine,greenLine2);
		Button=new JButton("Submit");
		Button.setForeground(borderColor);
		Button.setBackground(Color.BLACK);
		Button.setBorder(compBorder);

		this.setForeground(borderColor);
		this.setBorder(compBorder);
		
		
	}
	public void setOuterText()
	{
		
	}
	public void setInnerText(String text)
	{
		InnerText=text;
	}
	public String getOuterText()
	{
		return OuterText;
	}
	public String getInnerText()
	{
		return InnerText;
	}

}
