package travel.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener{
    //to have access of all these outside constructor we are declaring them globally
    JButton create,back;
    JTextField tfname, tfusername, tfpwd, tfAns;
    Choice security;
    Signup(){
        setBounds(350,200,900,360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        //unless set layout is set to null we cant correctly implement setbound of panel

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133,193,233));
        p1.setBounds(0, 0, 500, 400);
        p1.setLayout(null);
        add(p1);

        JPanel p2 = new JPanel();
        p2.setBounds(500, 0, 400, 400);
        p2.setLayout(null);
        add(p2);

        JLabel userName = new JLabel("Username");
        userName.setFont(new Font("Times New Roman",Font.BOLD,14));
        userName.setBounds(50,20,125,25);
        p1.add(userName);

        tfusername = new JTextField();
        tfusername.setBounds(190, 20, 180, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Times New Roman",Font.BOLD,14));
        name.setBounds(50,60,125,25);
        p1.add(name);

        tfname = new JTextField();
        tfname.setBounds(190, 60, 180, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        JLabel password = new JLabel("Password");
        password.setFont(new Font("Times New Roman",Font.BOLD,14));
        password.setBounds(50,100,125,25);
        p1.add(password);

        tfpwd = new JTextField();
        tfpwd.setBounds(190, 100, 180, 25);
        tfpwd.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpwd);

        JLabel securityQ = new JLabel("Security Question");
        securityQ.setFont(new Font("Times New Roman",Font.BOLD,14));
        securityQ.setBounds(50,140,125,25);
        p1.add(securityQ);

        security = new Choice();
        security.add("Favorite serial");
        security.add("Favorite past time");
        security.add("Which type of film you like");
        security.add("Favorite song");
        security.setBounds(190,140,180,25);
        p1.add(security);

        JLabel securityAns = new JLabel("Security Answer");
        securityAns.setFont(new Font("Times New Roman",Font.BOLD,14));
        securityAns.setBounds(50,180,125,25);
        p1.add(securityAns);

        tfAns = new JTextField();
        tfAns.setBounds(190, 180, 180, 25);
        tfAns.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfAns);

        create = new JButton("Create");
        create.setBackground(Color.blue);
        create.setForeground(Color.WHITE);
        create.setFont(new Font("Times New Roman",Font.BOLD,14));
        create.setBorder(BorderFactory.createEmptyBorder());
        create.setBounds(80,250,100,30);
        //*********************** Action on create button here we pnly specify that we want to perform some action on clicking this button
        //But what action is defined in actionPerformed method
        create.addActionListener(this);
        p1.add(create);

        back = new JButton("Back");
        back.setBackground(Color.blue);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Times New Roman",Font.BOLD,14));
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setBounds(250,250,100,30);
        back.addActionListener(this);
        p1.add(back);
        

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100,40,200,250);
        p2.add(image);

        
        
        setVisible(true);
    }
    
    //this is all to store the data input by user into database once user clicks 'create' button
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == create){
            //get text helps to get the value entered in that field
            String username = tfusername.getText(); 
            String name = tfname.getText();
            String password = tfpwd.getText();
            String question = security.getSelectedItem(); // for dropdown menu getselecteitem method
            String ans = tfAns.getText();
            
            String query = "insert into account values('"+username+"','"+name+"','"+password+"','"+question+"','"+ans+"')";
            try{
                Conn c = new Conn(); // whenever we want to execute mysql query, jdbc connection is required which is done in conn class
                c.s.executeUpdate(query); //dml command 4th step of jdbc - execution of mysql queries
                JOptionPane.showMessageDialog(null, "Account Created Successfully!");
                setVisible(false);
                new Login();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == back){
            setVisible(false);
            new Login();
        }
    }
    public static void main(String[] args) {
        new Signup();
    }
}
 