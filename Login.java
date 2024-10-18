
package travel.management;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*; 
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JTextField userNBox,passWBox;
    JButton login,signUp,forgotPwd;
    Login(){
        setSize(900,400);
        setLocation(350,200);
        setLayout(null); //not using swing layout but customising our own
        getContentPane().setBackground(Color.WHITE);
        //Panel devides frame into 2 parts 
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131,193,233)); //obj of color class to give any rgb color
        p1.setBounds(0,0,400,400);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        
        //One use Of JLabel is to add text over frame
        p1.setLayout(null);
        image.setBounds(100, 120, 200, 200);
        p1.add(image);
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30,450,300);
        
        add(p2);
        JLabel userName = new JLabel("Username"); //In parenthesis we give name we want to see
        userName.setBounds(60,20,100,25);
        userName.setFont(new Font("Calibri",Font.BOLD,20));
        p2.add(userName);
        //Font class takes 3 arg - font fam, font type, font size
        
        userNBox = new JTextField();
        userNBox.setBounds(60, 60, 320, 30);
        userNBox.setBorder(BorderFactory.createEmptyBorder());
        p2.add(userNBox);
        
        JLabel password = new JLabel("Password"); //In parenthesis we give name we want to see
        password.setBounds(60,110,100,25);
        password.setFont(new Font("Calibri",Font.BOLD,20));
        p2.add(password);
        //Font class takes 3 arg - font fam, font type, font size
        
        passWBox = new JTextField();
        passWBox.setBounds(60, 150, 320, 30);
        passWBox.setBorder(BorderFactory.createEmptyBorder());
        p2.add(passWBox);
        
        login = new JButton("Login");
        login.setBounds(60, 220,130, 30);
        login.setBackground(new Color(133,193,233));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(133,193,233))); //this will make border of same color
        login.addActionListener(this);
        p2.add(login);
        
        signUp = new JButton("Signup");
        signUp.setBounds(210, 220,130, 30);
        signUp.setBackground(new Color(133,193,233));
        signUp.setForeground(Color.WHITE);
        signUp.setBorder(new LineBorder(new Color(133,193,233))); //this will make border of same color
        signUp.addActionListener(this);
        p2.add(signUp);
        
        forgotPwd = new JButton("Forgot Password?");
        forgotPwd.setBounds(130, 260,130, 30);
        forgotPwd.setBackground(new Color(133,193,233));
        forgotPwd.setForeground(Color.WHITE);
        forgotPwd.setBorder(new LineBorder(new Color(133,193,233))); 
        forgotPwd.addActionListener(this);
        p2.add(forgotPwd);
        
        JLabel text = new JLabel("Trouble in signing in...");
        text.setBounds(300,270,150,20);
        text.setForeground(Color.red);
        p2.add(text);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            try{
           String username = userNBox.getText();
           String password = passWBox.getText();
           
            String query = "select * from account where username = '"+username+"' AND password = '"+password+"'";
             Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Loading(username);
            }
            else{
                JOptionPane.showMessageDialog(null, "Incorrect username or password");
                
            }
            
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource() == signUp){
            setVisible(false);
            new Signup();
        }else{
            setVisible(false);
            new ForgetPassword();
        }
    }
    public static void main(String args[]){
        Login l1 = new Login();
    }
}  
  