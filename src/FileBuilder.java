import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import java.io.*;

public class FileBuilder
{
	JPanel logicPanel;
	JButton buildButton;
	Component[] allLogicComponents;
	ArrayList<Component> trimmedComponentList;
	File jsFile = new File("program.js");
	
	public FileBuilder(JPanel main)
	{
		logicPanel = main;
		buildButton = new JButton("Build and Run");
		buildButton.addActionListener(buildFile());
	}
	
	private ActionListener buildFile()
	{
		ActionListener submitListen=new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				allLogicComponents = logicPanel.getComponents();
				trimmedComponentList = GetEssentials();
				GenerateJSFile();
			}
		};
		return submitListen;
	}
	
	private ArrayList<Component> GetEssentials()
	{
		ArrayList<Component> componentList = new ArrayList<Component>();
		
		String subClassName;
		String superClassName;
		
		for(int i = 0; i < allLogicComponents.length; i++)
		{
			superClassName = allLogicComponents[i].getClass().getSuperclass().getSimpleName();
			subClassName = allLogicComponents[i].getClass().getSimpleName();
			
			if(superClassName.equals("BaseComponent") 
			   || (subClassName.equals("JLabel") && ((JLabel)allLogicComponents[i]).getText().equals(" {")) 
			   || (subClassName.equals("JLabel") && ((JLabel)allLogicComponents[i]).getText().equals(" }")))
			{
				componentList.add(allLogicComponents[i]);
			}
				
		}
		
		return componentList;
	}
	
	private void GenerateJSFile()
	{
		try
		{
			jsFile.createNewFile();
			
			FileWriter writer = new FileWriter(jsFile);
			
			int elementsToSkip = 0;
			
			for(int i = 0; i < trimmedComponentList.size(); i++)
			{
				elementsToSkip = GetNestedElements(trimmedComponentList.get(i), i, writer);
				i += elementsToSkip;
			}
			
			writer.close();
		}
		catch(Exception exc)
		{
			System.out.println("Trouble generating js file!" + exc.getMessage());
		}
	}
	
	private int GetNestedElements(Component comp, int startIndex, FileWriter fWriter)
	{
		int skip = 0;
		int currentIndex = startIndex;
		boolean foundClosing = false;
		
		try
		{
			if(!comp.getClass().getSimpleName().equals("JLabel"))
			{
				fWriter.write(((BaseComponent)comp).getOuterText() + "\n");
			}
			ArrayList<Component> needClosing = new ArrayList<Component>();
			
			if(!comp.getClass().getSimpleName().equals("JVar"))
			{
				needClosing.add(comp);
				currentIndex += 2;
				skip += 2;
				
				Component currentComponent = trimmedComponentList.get(currentIndex);
				
				while(!currentComponent.getClass().getSimpleName().equals("JLabel"))
				{			
					System.out.println(currentComponent.getClass().getSimpleName());
					
					fWriter.write(((BaseComponent)currentComponent).getOuterText() + "\n");
					
					if(!currentComponent.getClass().getSimpleName().equals("JVar")) needClosing.add(currentComponent);
					currentIndex++;
					skip++;
					currentComponent = trimmedComponentList.get(currentIndex);
				}
				for(int i = 0; i < needClosing.size(); i++)
					fWriter.write("}\n");
			}
		}
		catch(Exception exc)
		{
			System.out.println("Trouble generating js file in Nest!" + exc.getMessage());
		}
		return skip;
	}
	
	public JButton GetButton()
	{
		return buildButton;
	}
}
