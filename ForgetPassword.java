package travel.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener {
    
    JButton search,retrieve,back;
    JTextField tfusername,tfname,tfque,tfans,tfpwd;
    
    ForgetPassword(){
        setBounds(350,200,850,380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(580,70,200,200);
        add(img);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30,30,500,280 );
        add(p1);
        
        JLabel username = new JLabel("Username");
        username.setBounds(40,20,100,25);
        username.setFont(new Font("Times new Roman",Font.BOLD,14));
        p1.add(username);
        
        tfusername = new JTextField();
        tfusername.setBounds(220,20,150,25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        search = new JButton("Serach");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.WHITE);
        search.setBounds(390,20,100,25);
        search.addActionListener(this);
        p1.add(search);
        
        JLabel name = new JLabel("Name");
        name.setFont(new Font("Times New Roman",Font.BOLD,14));
        name.setBounds(40,60,100,25);
        p1.add(name);
        
        tfname = new JTextField();
        tfname.setBounds(220,60,150,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        
        JLabel securityQ = new JLabel("Security Question");
        securityQ.setFont(new Font("Times New Roman",Font.BOLD,14));
        securityQ.setBounds(40,100,150,25);
        p1.add(securityQ);
        
        tfque = new JTextField();
        tfque.setBounds(220,100,150,25);
        tfque.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfque);
        
        JLabel ans = new JLabel("Answer ");
        ans.setFont(new Font("Times New Roman",Font.BOLD,14));
        ans.setBounds(40,140,150,25);
        p1.add(ans);
        
        tfans = new JTextField();
        tfans.setBounds(220,140,150,25);
        tfans.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfans);
        
        retrieve = new JButton("Retrieve");
        retrieve.setBackground(Color.GRAY);
        retrieve.setForeground(Color.WHITE);
        retrieve.setBounds(390,140,100,25);
        retrieve.addActionListener(this);
        p1.add(retrieve);
        
        JLabel pwd = new JLabel("Password");
        pwd.setFont(new Font("Times New Roman",Font.BOLD,14));
        pwd.setBounds(40,180,150,25);
        p1.add(pwd);
        
        tfpwd = new JTextField();
        tfpwd.setBounds(220,180,150,25);
        tfpwd.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpwd);
        
        back = new JButton("Back");
        back.setBackground(Color.blue);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Times New Roman",Font.BOLD,14));
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setBounds(150,240,100,25);
        back.addActionListener(this);
        p1.add(back);
        
        setVisible(true);

    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            try{
                String query = "select * from account where username = '"+tfusername.getText()+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    tfname.setText(rs.getString("name"));
                    tfque.setText(rs.getString("security"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == retrieve){
            try{
                String query = "select * from account where ans = '"+tfans.getText()+"' AND username = '"+tfusername.getText()+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    tfpwd.setText(rs.getString("password"));
                    
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String args[]){
        new ForgetPassword();    }
}
