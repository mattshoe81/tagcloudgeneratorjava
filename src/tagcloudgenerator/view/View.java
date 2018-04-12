package tagcloudgenerator.view;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import tagcloudgenerator.controller.Controller;
import tagcloudgenerator.model.Model;

/**
 * Program that will read words from a .txt file and create a fully formed html
 * page displaying a tag cloud of the words from the .txt file.
 *
 * @author Matthew Shoemaker, Andrew Petrilli, Eddy Liang
 *
 */
@SuppressWarnings("serial")
public final class View extends JFrame {

    /**
     * JLabel to display the status of upload.
     */
    public JLabel statusLabel;
    /**
     * JTextfield for the input file location.
     */
    public JTextField fileLocationField;
    /**
     * JTextfield for the output folder location.
     */
    public JTextField folderLocationField;

    /**
     * JTextField for the number of words specified by the user.
     */
    public JTextField numberOfWordsField;

    /**
     * Radio button to indicate whether to remove common words from the tag
     * cloud
     */
    public JRadioButton removeCommonWordsButton;

    /**
     * Constructor for this. Accepts a reference to the model and controller.
     *
     * @param model
     *            reference to the model component in the MVC design
     * @param controller
     *            reference to the controller component in the MVC design
     */
    public View() {
        super();
        this.statusLabel = new JLabel("Ready");
        this.fileLocationField = new JTextField(20);
        this.folderLocationField = new JTextField(20);
        this.numberOfWordsField = new JTextField(10);
        this.removeCommonWordsButton = new JRadioButton(
                "Remove Common Words: ");
    }

    /**
     * Accepts the reference to the controller to observe the generated events
     * 
     * @param controller
     */
    public void registerObserver(Controller controller) {
        this.controller = controller;
    }

    /**
     * Reference to the controller.
     */
    private Controller controller;

    /**
     * Construct the GUI.
     */
    public void buildGUI() {
        JPanel background = new JPanel();
        background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS));

        // Create panel to hold text fields
        JPanel textAreaPanel = new JPanel();
        textAreaPanel.setLayout(new BoxLayout(textAreaPanel, BoxLayout.Y_AXIS));

        // Create panel containing the file location text field
        JPanel fileLocationTextPanel = new JPanel();
        fileLocationTextPanel.setLayout(new FlowLayout());
        // Label for text box
        JLabel fileLocationText = new JLabel("File Path: ");
        fileLocationTextPanel.add(fileLocationText);
        fileLocationTextPanel.add(this.fileLocationField);

        // Create panel containing the folder location
        JPanel folderLocationTextPanel = new JPanel();
        fileLocationTextPanel.setLayout(new FlowLayout());
        // Label for text box
        JLabel folderLocationText = new JLabel("Folder:     ");
        folderLocationTextPanel.add(folderLocationText);
        folderLocationTextPanel.add(this.folderLocationField);

        // Create panel containing the number of words text field
        JPanel numberOfWordsPanel = new JPanel();
        numberOfWordsPanel.setLayout(new FlowLayout());
        // Label for text box
        JLabel numberOfWordsLabel = new JLabel("Number of words:  ");
        numberOfWordsPanel.add(numberOfWordsLabel);
        numberOfWordsPanel.add(this.numberOfWordsField);

        // Create panel containing the Remove Common Words radio button
        JPanel removeCommonWordsPanel = new JPanel();
        removeCommonWordsPanel.setLayout(new FlowLayout());
        this.removeCommonWordsButton.setSelected(true);
        this.removeCommonWordsButton.addItemListener(
                this.controller.getRemoveCommonWordsButtonListener());
        removeCommonWordsPanel.add(this.removeCommonWordsButton);

        // Create a status label and panel to hold it (to keep it centered)
        JPanel statusPanel = new JPanel();
        statusPanel.add(this.statusLabel);

        /*
         * Add file panel, folder panel, numberOfWordsPanel, and status panel to
         * the text area panel
         */
        textAreaPanel.add(fileLocationTextPanel);
        textAreaPanel.add(folderLocationTextPanel);
        textAreaPanel.add(numberOfWordsPanel);
        textAreaPanel.add(removeCommonWordsPanel);
        textAreaPanel.add(statusPanel);

        // Create the panel for buttons
        JPanel buttonPanel = new JPanel();

        // Create the reset button
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(this.controller.getResetButtonListener());
        buttonPanel.add(resetButton);

        //Create the button to run the program
        JButton goButton = new JButton("Go");
        goButton.addActionListener(this.controller.getGoButtonListener());
        buttonPanel.add(goButton);

        // Add Text area panel and go button to the background panel
        background.add(textAreaPanel);
        background.add(buttonPanel);

        // Add background to frame (this class)
        this.add(background);

        this.pack();
        this.setVisible(true);
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        view.registerObserver(controller);
        view.buildGUI();

    }

}
