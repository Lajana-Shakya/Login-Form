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
    private JPanel topPanel, leftPanel, centerPanel, givenNamePanel, familyNamePanel, emailPanel, passwordPanel, messagePanel;
    private JLabel titleLabel, givenNameLabel, familyNameLabel, doBLabel, emailLabel, genderLabel, passwordLabel, messageLabel;    
    private JTextField givenNameField, familyNameField, emailField, passwordField;
    private JButton submitButton, clearButton;
    private JRadioButton genderRadio;
    
    //gui
    public FormGUI()
    {
        //adds components to the gui of the form
        setTitle("Log In Form");    // window title
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());
        
        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        titleLabel = new JLabel("<html><h2>Log In Form</h2></html>");
        topPanel.add(titleLabel);
        
        leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(100,20,100,30));
        
        submitButton = buttonStyle("Submit");
        submitButton.addActionListener(e -> submit());
        leftPanel.add(submitButton);
        
        leftPanel.add(Box.createVerticalStrut(10));
        
        clearButton = buttonStyle("Clear");
        clearButton.addActionListener(e -> clear());
        leftPanel.add(clearButton);
        
        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(50,20,10,20));
        
        givenNamePanel = new JPanel();
        givenNamePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        givenNameLabel = labelFormat("Given Name");
        givenNamePanel.add(givenNameLabel);
        
        givenNameField = fieldFormat("given name");
        givenNamePanel.add(givenNameField);
        
        familyNamePanel = new JPanel();
        familyNamePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        familyNameLabel = labelFormat("Family Name");
        familyNamePanel.add(familyNameLabel);
        
        familyNameField = fieldFormat("family name");
        familyNamePanel.add(familyNameField);
        
        emailPanel = new JPanel();
        emailPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        emailLabel = labelFormat("Email");
        emailPanel.add(emailLabel);
        
        emailField = fieldFormat("email");
        emailPanel.add(emailField);
        
        passwordPanel = new JPanel();
        passwordPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        passwordLabel = labelFormat("Password");
        passwordPanel.add(passwordLabel);
        
        passwordField = fieldFormat("password");
        passwordPanel.add(passwordField);
        
        messagePanel = new JPanel();
        messagePanel.setPreferredSize(new Dimension(200,200));
        
        centerPanel.add(givenNamePanel);
        centerPanel.add(familyNamePanel);
        centerPanel.add(emailPanel);
        centerPanel.add(passwordPanel);
        centerPanel.add(messagePanel);
        
        add(centerPanel, BorderLayout.CENTER);
        add(leftPanel, BorderLayout.WEST);
        add(topPanel, BorderLayout.NORTH);
        
        setSize(600,600);   // length,breadth
        setLocationRelativeTo(null);
    }
    
    public JButton buttonStyle(String btn)
    {
        // formats buttons
        JButton bt = new JButton("<html><center>"+btn+"</center></html>");
        bt.setPreferredSize(new Dimension(150,45));
        bt.setToolTipText("Click to "+btn);
        bt.setBackground(Color.BLACK);
        bt.setForeground(Color.WHITE);
        bt.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered(MouseEvent e)
            {
                bt.setBackground(Color.GRAY);
                bt.setForeground(Color.WHITE);
            }
            
            public void mouseExited(MouseEvent e)
            {
                bt.setBackground(Color.BLACK);
                bt.setForeground(Color.WHITE);
            }
        });
        return bt;
    }
    
    public JLabel labelFormat(String lbl)
    {
        // formats labels
        JLabel lb = new JLabel(lbl);
        lb.setPreferredSize(new Dimension(100,35));
        return lb;
    }
    
    public JTextField fieldFormat(String fld)
    {
        // formats text fields
        JTextField fd = new JTextField("Enter your "+fld);
        fd.setPreferredSize(new Dimension(200,35));
        fd.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (fd.getText().equals("Enter your "+fld))
                {
                    fd.setText("");
                }
            }
            
            @Override
            public void focusLost(FocusEvent e)
            {
                if (fd.getText().trim().isEmpty())
                {
                    fd.setText("Enter your "+fld);
                }
            }
        });
        return fd;
    }
    
    public void message(String msg)
    {
        // shows error or success message
        messageLabel = new JLabel(msg);
        messagePanel.add(messageLabel);
    }
    
    public void submit()
    {
        // validates the form
        
    }
    
    public void clear()
    {
        // clears the previous data from the form
        givenNameField.setText("Enter your given name");
        familyNameField.setText("Enter your family name");
        emailField.setText("Enter your email");
        passwordField.setText("Enter your password");
    }
    
    //main
    public static void main(String[] args)
    {
        // executes FormGUI
        SwingUtilities.invokeLater(() ->
        {
            FormGUI window = new FormGUI();
            window.setVisible(true);
        });
    }
}