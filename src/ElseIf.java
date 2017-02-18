import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.border.Border;
import javax.swing.*;
import java.awt.Component;
import java.awt.event.*;
import java.lang.Object;

import java.util.ArrayList;
public class ElseIf extends BaseComponent 
{
	private String[] operatorsList;
	private String comparisonStatement;
	private String firstHalfStatement;
	private String secondHalfStatment;
	private JComboBox dropDown;
	private String selectedOperator;
	private JTextField text2;
	private JLabel comboLabel;
	private JLabel label2;
	private JPanel Panel1;
	private JPanel Panel2;
	private JPanel Panel3;
	private JPanel higherInputPanel;
	private JPanel ButtonPanel;
	
	

	public ElseIf()
	{
		name="ElseIf Statement";
		this.setText(name);
		//String[] ComparatorList={ ">","<", "==","!=",">=","=<"};
		dropDown=new JComboBox();
		dropDown.addItem(">");
		dropDown.addItem("<");
		dropDown.addItem("==");
		dropDown.addItem("!=");
		dropDown.addItem(">=");
		dropDown.addItem("=<");
		dropDown.addActionListener(comboListener());
		baseText="else if(";
		/////////////////////////////////////////////////////////////////////////////////////////
		///
		///Labels
		///
		////////////////////////////////////////////////////////////////////////////////////////
		///combolabel
		comboLabel=new JLabel();
		comboLabel.setForeground(borderColor);
		comboLabel.setBackground(Color.BLACK);
		comboLabel.setText("Select a comparison");
		//comboLabel.setBorder(compBorder);
		///the second half if statement label
		label2=new JLabel();
		label2.setForeground(borderColor);
		label2.setBackground(Color.BLACK);
		label2.setText("Input a variable name or number");
		//label2.setBorder(compBorder);
		///first half if statment label
		inputLabel=new JLabel();
		inputLabel.setForeground(borderColor);
		inputLabel.setBackground(Color.BLACK);
		inputLabel.setText("Input a variable name or number");
		//inputLabel.setBorder(compBorder);
		//////////////////////////////////////////////////////////////////////////////////////////
		///
		///Text Fields
		///
		/////////////////////////////////////////////////////////////////////////////////////////
		text2=new JTextField(5);
		inputText=new JTextField(5);
		////////////////////////////////////////////////////////////////////////////////////////
		////
		///Panels
		///
		////////////////////////////////////////////////////////////////////////////////////////////
		////Panel1 for the first half of if statement
		Panel1=new JPanel();
		Panel1.setBackground(Color.BLACK);
		Panel1.setOpaque(true);
		Panel1.setLayout(new BoxLayout(Panel1, BoxLayout.Y_AXIS));
		Panel1.setBorder(compBorder);
		Panel1.add(inputLabel);
		Panel1.add(inputText);
		///Panel2 for the dropdown and its label
		Panel2=new JPanel();
		Panel2.setBackground(Color.BLACK);
		Panel2.setOpaque(true);
		Panel2.setLayout(new BoxLayout(Panel2, BoxLayout.Y_AXIS));
		Panel2.setBorder(compBorder);
		Panel2.add(comboLabel);
		Panel2.add(dropDown);
		///Panel3
		Panel3=new JPanel();
		Panel3.setBackground(Color.BLACK);
		Panel3.setOpaque(true);
		Panel3.setLayout(new BoxLayout(Panel3,BoxLayout.Y_AXIS));
		Panel3.setBorder(compBorder);
		Panel3.add(label2);
		Panel3.add(text2);
		///Higher INput panel which just adds the three Panels
		higherInputPanel=new JPanel();
		higherInputPanel.setBackground(Color.BLACK);
		higherInputPanel.add(Panel1);
		higherInputPanel.add(Panel2);
		higherInputPanel.add(Panel3);
		///ButtonPanel
		ButtonPanel=new JPanel();
		ButtonPanel.setBackground(Color.BLACK);
		ButtonPanel.add(Button);
		///Main panel
		inputPanel=new JPanel();
		inputPanel.setOpaque(true);
		inputPanel.setBackground(Color.BLACK);
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
		inputPanel.add(higherInputPanel);
		inputPanel.add(ButtonPanel);
		///Frame and button stuff
		Button.addActionListener(submitListener());
		frame=new JFrame(name);
		frame.setContentPane(inputPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,300);
		runElseIfStatement();

	}
///////////////////////////////////////////////////////////////////////////////////////////
////
////Action Listeners
////
/////////////////////////////////////////////////////////////////////////////////////////////
	private ActionListener submitListener()
	{
		ActionListener submitListen=new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				
				firstHalfStatement=inputText.getText();
				secondHalfStatment=text2.getText();
				StatementMaker();
				
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
				selectedOperator=(String)dropDown.getSelectedItem();
			}
		};
		return ComboListen;
		
	}
	////////////////////////////////////////////////////////////////////////////////////////////
	//////////
	//////////Text gens
	//////////
	///////////////////////////////////////////////////////////////////////////////////////////
	private void StatementMaker()
	{
		comparisonStatement=firstHalfStatement+selectedOperator+secondHalfStatment;
		setOuterText();
	}
	public void setOuterText()
	{
		OuterText=baseText+comparisonStatement+"){";
		frame.setVisible(false);
		System.out.println(OuterText);
	}
	public void runElseIfStatement()
	{
		frame.setVisible(true);
	}
	public void setInnerText(String text)
	{
		InnerText=text+"}";
	}
}
