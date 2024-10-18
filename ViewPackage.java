package travel.management;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewPackage extends JFrame implements ActionListener{
    JButton back;
    ViewPackage(String usern){
        setBounds(420,200,900,450);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("VIEW PACKAGE DETAILS");
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        heading.setBounds(60,0,300,30);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        
        JLabel username = new JLabel();
        username.setBounds(220,50,150,25);
        add(username); 
        
        JLabel lblpackage = new JLabel("Package");
        lblpackage.setBounds(30,90,150,25);
        add(lblpackage);
        
        JLabel packg = new JLabel();
        packg.setBounds(220,90,150,25);
        add(packg ); 
        
        JLabel lblnumber = new JLabel("Total Persons");
        lblnumber.setBounds(30,130,150,25);
        add(lblnumber);
        
        JLabel number = new JLabel();
        number.setBounds(220,130,150,25);
        add(number); 
        
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30,170,150,25);
        add(lblid);
        
        JLabel id = new JLabel();
        id.setBounds(220,170,150,25);
        add(id); 
         
        
         JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30,210,150,25);
        add(lblphone);
        
        JLabel phone = new JLabel();
        phone.setBounds(220,210,150,25);
        add(phone); 
        
         JLabel lblprice = new JLabel("Price");
        lblprice.setBounds(30,250,150,25);
        add(lblprice);
        
        JLabel price = new JLabel();
        price.setBounds(220,250,150,25);
        add(price); 
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white); 
        back.setBounds(40,350,100,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewPackage.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(400,-20,400,400);
        add(img);

        try{
            Conn c = new Conn();
            String query = "select * from bookedpackage where username = '"+usern+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                username.setText(rs.getString("username"));
                packg.setText(rs.getString("package"));
                id.setText(rs.getString("id"));
                number.setText(rs.getString("persons"));
                phone.setText(rs.getString("phone"));
                price.setText(rs.getString("price"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
//        if(ae.getSource() == back){
//            
//        }
        setVisible(false);
        
    }
    public static void main(String args[]){
        new ViewPackage("");
    }
}
