import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
    private JPanel topPanel, leftPanel, centerPanel, givenNamePanel, familyNamePanel, emailPanel, passwordPanel;
    private JLabel titleLabel, givenNameLabel, familyNameLabel, doBLabel, emailLabel, genderLabel, passwordLabel;    
    private JTextField givenNameField, familyNameField, emailField, passwordField;
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
        
        titleLabel = new JLabel("Log In Form");
        topPanel.add(titleLabel);
        
        leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        
        submitButton = buttonStyle("Submit");
        submitButton.addActionListener(e -> submit());
        leftPanel.add(submitButton);
        
        clearButton = buttonStyle("Clear");
        clearButton.addActionListener(e -> clear());
        leftPanel.add(clearButton);
        
        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        
        givenNamePanel = new JPanel();
        
        givenNameLabel = labelFormat("Given Name");
        givenNamePanel.add(givenNameLabel);
        
        givenNameField = fieldFormat("given name");
        givenNamePanel.add(givenNameField);
        
        familyNamePanel = new JPanel();
        
        familyNameLabel = labelFormat("Family Name");
        givenNamePanel.add(givenNameLabel);
        
        familyNameField = fieldFormat("family name");
        familyNamePanel.add(familyNameField);
        
        emailPanel = new JPanel();
        
        emailLabel = labelFormat("Email");
        emailPanel.add(emailLabel);
        
        emailField = fieldFormat("email");
        emailPanel.add(emailField);
        
        passwordPanel = new JPanel();
        
        passwordLabel = labelFormat("Password");
        passwordPanel.add(passwordLabel);
        
        passwordField = fieldFormat("password");
        passwordPanel.add(passwordField);
        
        centerPanel.add(passwordPanel);
        centerPanel.add(emailPanel);
        centerPanel.add(familyNamePanel);
        centerPanel.add(givenNamePanel);
        
        add(centerPanel, BorderLayout.CENTER);
        add(leftPanel, BorderLayout.WEST);
        add(topPanel, BorderLayout.NORTH);
        
        setSize(600,600);   // length,breadth
        setLocationRelativeTo(null);
    }
    
    public JButton buttonStyle(String btn)
    {
        JButton bt = new JButton("<html><center>"+btn+"</center></html>");
        bt.setPreferredSize(new Dimension(150,40));
        bt.setToolTipText("Click to "+btn);
        return bt;
    }
    
    public JLabel labelFormat(String lbl)
    {
        JLabel lb = new JLabel(lbl);
        return lb;
    }
    
    public JTextField fieldFormat(String fld)
    {
        JTextField fd = new JTextField(fld);
        return fd;
    }
    
    public void submit()
    {
        
    }
    
    public void clear()
    {
        givenNameField.setText("Enter your given name");
        familyNameField.setText("Enter your family name");
        emailField.setText("Enter your email");
        passwordField.setText("Enter your password");
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