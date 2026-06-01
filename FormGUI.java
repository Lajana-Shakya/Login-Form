import javax.swing.*;
import java.awt.*;

/**
 * Write a description of class FormGUI here.
 * 
 * GUI for a Login form
 *
 * @author Lajana Shakya
 * @version 06/01
 */

public class FormGUI extends JFrame
{
    // camelCasting
    
    // gui components
    private JPanel topPanel, leftPanel, centerPanel;
    private JLabel firstNameLabel, familyNameLabel, doBLabel, emailLabel, genderLabel, passwordLabel;    
    private JTextField firstNameField, familyNameField, emailField;
    private JButton submitButton, clearButton;
    private JRadioButton genderRadio;
    
    //gui
    public FormGUI()
    {
        setTitle("Log In Form");    // window title
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());
        
        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        
        centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        add(centerPanel, BorderLayout.CENTER);
        add(leftPanel, BorderLayout.WEST);
        add(topPanel, BorderLayout.NORTH);
        
        setSize(600,600);   // length,breadth
    }
    
    //main
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() ->
        {
            FormGUI window = new FormGUI();
            window.setVisible(true);
        });
    }
}