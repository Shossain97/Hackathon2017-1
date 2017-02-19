import javax.swing.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.util.Arrays;

// @author Colby Hughes
// Class DragPanels is responsible for managing the panel containing
// each available component that may be added to the logic panel
// as well as updating the logic panel when new components are added.
public class DragPanels 
{
	JFrame mainWindow; // Main frame of the application.
	
	JPanel componentPanel; // Contains all available logic components.
	JLabel componentsLabel; // Label for the component panel.
	JList<String> components = new JList<String>(new DefaultListModel<>()); // List of component names.
	String[] componentNames = { "Variable", "Reassign Variable", "If", "Else If",
			"Else", "For Loop", "Print Value" };
	
	JPanel logicPanel; // Panel for receiving objects from the component panel.
	JLabel programLabel; // Label denoting the start of a program.
	JList<String> destination = new JList<String>(new DefaultListModel<>()); // List capture drag events from component panel.
	String dragPrompt = "v--- Drag Components Here ---v";
	
	// Constructor for the drag panels.
	public DragPanels(JFrame window)
	{
		mainWindow = window;
		
		// Initialize component panel.
		componentPanel = new JPanel();
		componentPanel.setLayout(new BoxLayout(componentPanel, BoxLayout.Y_AXIS));
		componentPanel.setBorder(BorderFactory.createLineBorder(new Color(0,255,0)));
		componentPanel.setBackground(Color.BLACK);
		componentPanel.setPreferredSize(new Dimension((mainWindow.getWidth() / 3) - 10,
				mainWindow.getHeight() - 20));
		componentPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		// Initialize logic panel.
		logicPanel = new JPanel();
		logicPanel.setLayout(new GridLayout(0,1));
		logicPanel.setBorder(BorderFactory.createLineBorder(new Color(0,255,0)));
		logicPanel.setPreferredSize(new Dimension(((2*mainWindow.getWidth() / 3)) - 10,
				mainWindow.getHeight() - 10));
		logicPanel.setBackground(Color.BLACK);
		logicPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		logicPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		
		// Populate components panel.
		componentsLabel = new JLabel("Componenets");
		componentsLabel.setFont(new Font("Courier", Font.BOLD,24));
		componentsLabel.setHorizontalAlignment(JLabel.LEFT);
		componentsLabel.setForeground(new Color(0,255,0));
		
		for(int i = 0; i < componentNames.length; i++)
			((DefaultListModel<String>) components.getModel()).add(i, componentNames[i]);
		
		components.setForeground(new Color(0,255,0));
		components.setBackground(Color.BLACK);
		
		((DefaultListModel<String>) destination.getModel()).add(0, dragPrompt);
		
		componentPanel.add(componentsLabel);
		componentPanel.add(components);
		
		components.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		components.setDragEnabled(true);
		ListTransferHandler componentsHandler = new ListTransferHandler();
		componentsHandler.SetLogicPanel(logicPanel);
		componentsHandler.SetMainWindow(mainWindow);
		components.setTransferHandler(componentsHandler);
		
		// Populate logic panel.
		programLabel = new JLabel(" Program");
		programLabel.setFont(new Font("Courier", Font.BOLD,24));
		programLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		programLabel.setForeground(new Color(0,255,0));
		
		destination.setForeground(new Color(0,255,0));
		destination.setBackground(Color.black);
		
		logicPanel.add(programLabel);
		logicPanel.add(destination);
		
		ListTransferHandler destinationHandler = new ListTransferHandler();
		destinationHandler.SetLogicPanel(logicPanel);
		destinationHandler.SetMainWindow(mainWindow);
		destination.setDropMode(DropMode.INSERT);
		destination.setTransferHandler(destinationHandler);
	}
	
	public JPanel GetComponentPanel()
	{
		return componentPanel;
	}
	public JPanel GetLogicPanel()
	{
		return logicPanel;
	}
}

// ListTransferHandler has been modified from the code provided at
// this link. http://www.java2s.com/Tutorials/Java/Java_Swing/1550__Java_Swing_Drag_Drop.htm
class ListTransferHandler extends TransferHandler 
{
	JFrame mainWindow; // Main frame for the project.
	JPanel logic; // Panel for the logic components.
	Component[] comps; // Components within the logic panel.
	
	public void SetLogicPanel(JPanel logicPanel)
	{
		logic = logicPanel;
		comps = logic.getComponents();
	}
	
	public void SetMainWindow(JFrame main)
	{
		mainWindow = main;
	}
	
	  @Override
	  public int getSourceActions(JComponent c) 
	  {
	    return TransferHandler.COPY_OR_MOVE;
	  }
	  @Override
	  protected Transferable createTransferable(JComponent source) 
	  {
	    JList<String> sourceList = (JList<String>) source;
	    String data = sourceList.getSelectedValue();
	    Transferable t = new StringSelection(data);
	    return t;
	  }

	  @Override
	  protected void exportDone(JComponent source, Transferable data, int action) {
	    /*@SuppressWarnings("unchecked")
	    JList<String> sourceList = (JList<String>) source;
	    String movedItem = sourceList.getSelectedValue();
	    if (action == TransferHandler.MOVE) {
	      DefaultListModel<String> listModel = (DefaultListModel<String>) sourceList
	          .getModel();
	      //listModel.removeElement(movedItem);
	    }*/
	  }
	  
	  @Override
	  public boolean canImport(TransferHandler.TransferSupport support) {
	    if (!support.isDrop()) {
	      return false;
	    }
	    return support.isDataFlavorSupported(DataFlavor.stringFlavor);
	  }
	  @Override
	  public boolean importData(TransferHandler.TransferSupport support) {
		  
		comps = logic.getComponents();
		  
	    if (!this.canImport(support)) {
	      return false;
	    }
	    Transferable t = support.getTransferable();
	    String data = null;
	    try {
	      data = (String) t.getTransferData(DataFlavor.stringFlavor);
	      if (data == null) {
	        return false;
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	      return false;
	    }
	    /*JList.DropLocation dropLocation = (JList.DropLocation) support
	        .getDropLocation();
	    int dropIndex = dropLocation.getIndex();*/
	    JList<String> targetList = (JList<String>) support.getComponent();
	    int dropIndex = Arrays.asList(comps).indexOf(targetList) + 1;
	    //DefaultListModel<String> listModel = (DefaultListModel<String>) targetList
	    //    .getModel();
	    /*if (dropLocation.isInsert()) {
	      listModel.add(dropIndex, data);
	    } else {
	      listModel.set(dropIndex, data);
	    }*/
	    MakeNewLabel(data, dropIndex);
	    return true;
	  }
	  
	  // MakeNewLabel creates an array of components to add to the
	  // logic panel based on the component dragged in from the components panel.
	  void MakeNewLabel(String labelType, int startIndex)
	  {
		  JList<String> destination1 = new JList<String>(new DefaultListModel<>());
		  JList<String> destination2 = new JList<String>(new DefaultListModel<>());
		  JLabel leftBracket = new JLabel(" {");
		  JLabel rightBracket = new JLabel(" }");
		  String dragPrompt = "v--- Drag Components Here ---v";
		  ((DefaultListModel<String>) destination2.getModel()).add(0, dragPrompt);
		  
		  destination1.setForeground(new Color(0,255,0));
		  destination1.setBackground(Color.black);
		  destination2.setForeground(new Color(0,255,0));
		  destination2.setBackground(Color.black);
		  leftBracket.setForeground(new Color(0,255,0));
		  leftBracket.setBackground(Color.BLACK);
		  rightBracket.setForeground(new Color(0,255,0));
		  rightBracket.setBackground(Color.BLACK);
		  
		  Component[] newComponents = new Component[5];
		  
		  ListTransferHandler destinationHandler = new ListTransferHandler();
		  destinationHandler.SetLogicPanel(logic);
		  destination1.setDropMode(DropMode.INSERT);
		  destination1.setTransferHandler(destinationHandler);
		  destination2.setDropMode(DropMode.INSERT);
		  destination2.setTransferHandler(destinationHandler);
		  
		  switch(labelType)
		  {
		  	case "For Loop":
		  		((DefaultListModel<String>) destination1.getModel()).add(0, "    v--- For Loop Body ---v");
		  		newComponents[0] = new ForLoop();
		  		newComponents[1] = leftBracket;
		  		newComponents[2] = destination1;
		  		newComponents[3] = rightBracket;
		  		newComponents[4] = destination2;
		  		break;
		  	case "If":
		  		((DefaultListModel<String>) destination1.getModel()).add(0, "    v--- If Body ---v");
		  		newComponents[0] = new IfStatement();
		  		newComponents[1] = leftBracket;
		  		newComponents[2] = destination1;
		  		newComponents[3] = rightBracket;
		  		newComponents[4] = destination2;
		  		break;
		  	case "Else If":
		  		((DefaultListModel<String>) destination1.getModel()).add(0, "    v--- Else If Body ---v");
		  		newComponents[0] = new ElseIf();
		  		newComponents[1] = leftBracket;
		  		newComponents[2] = destination1;
		  		newComponents[3] = rightBracket;
		  		newComponents[4] = destination2;
		  		break;
		  	case "Else":
		  		((DefaultListModel<String>) destination1.getModel()).add(0, "    v--- Else Body ---v");
		  		newComponents[0] = new ElseStatement();
		  		newComponents[1] = leftBracket;
		  		newComponents[2] = destination1;
		  		newComponents[3] = rightBracket;
		  		newComponents[4] = destination2;
		  		break;
		  	case "Variable":
		  		newComponents = new Component[2];
		  		newComponents[0] = new JVar();
		  		newComponents[1] = destination2;
		  		break;
		  	case "Reassign Variable":
		  		newComponents = new Component[2];
		  		newComponents[0] = new RenameVariable();
		  		newComponents[1] = destination2;
		  		break;
		  	case "Print Value":
		  		newComponents = new Component[2];
		  		newComponents[0] = new VarPrint();
		  		newComponents[1] = destination2;
		  		break;
		  	default:
		  		break;
		  }
		  comps = logic.getComponents();
		  RebuildPanel(startIndex, newComponents);
		  logic.revalidate();
		  logic.repaint();
	  }
	  
	  // Rebuild panel rearranges the components of the logic panel after
	  // new components have been added to it.
	  void RebuildPanel(int startIndex, Component[] addedComponents)
	  {
		  Component[] newComponents = new Component[comps.length + addedComponents.length];
		  
		  int currentIndex = 0;
		  
		  // Add all the components before the new additions.
		  for(currentIndex = 0; currentIndex < startIndex; currentIndex++)
			  newComponents[currentIndex] = comps[currentIndex];
		  
		  // Add all of the new components.
		  for(int i = 0; i < addedComponents.length; i++, currentIndex++)
			  newComponents[currentIndex] = addedComponents[i];
		  
		  // Add all of the components following the new additions.
		  for(int i = startIndex; i < comps.length; i++, currentIndex++)
			  newComponents[currentIndex] = comps[i];
		  
		  // Update the logic frame.
		  for(int i = 0; i < newComponents.length; i++)
			  logic.add(newComponents[i]);
	  }
	}
