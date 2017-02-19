import java.awt.Color;
import javax.swing.*;
import javax.swing.border.Border;
public class ElseStatement extends BaseComponent
{
	public ElseStatement()
	{
		name=" Else Statement";
		this.setText(name);
		baseText="else{";
		setOuterText();
		// Wat.
	}
	public void setOuterText()
	{
		OuterText=baseText;
	}
	public void setInnerText(String text)
	{
		InnerText=text+"}";
	}

}
