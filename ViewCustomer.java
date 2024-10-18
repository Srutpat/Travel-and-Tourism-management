package travel.management;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewCustomer extends JFrame implements ActionListener{
    JButton back;
    ViewCustomer(String usern){
        setBounds(450,180,870,625);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        
        JLabel username = new JLabel();
        username.setBounds(220,50,150,25);
        add(username); 
        
         JLabel lblid = new JLabel("ID");
        lblid.setBounds(30,110,150,25);
        add(lblid);
        
        JLabel id = new JLabel("");
        id.setBounds(220,110,150,25);
        add(id); 
        
         JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30,170,150,25);
        add(lblnumber);
        
        JLabel number = new JLabel("");
        number.setBounds(220,170,150,25);
        add(number); 
        
         JLabel lblname = new JLabel("Name");
        lblname.setBounds(30,230,150,25);
        add(lblname);
        
        JLabel name = new JLabel("");
        name.setBounds(220,230,150,25);
        add(name); 
        
         JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30,290,150,25);
        add(lblgender);
        
        JLabel gender = new JLabel("");
        gender.setBounds(220,290,150,25);
        add(gender); 
        
         JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(500,50,150,25);
        add(lblcountry);
        
        JLabel country = new JLabel("");
        country.setBounds(690,50,150,25);
        add(country); 
        
         JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(500,110,150,25);
        add(lbladdress);
        
        JLabel address = new JLabel("");
        address.setBounds(690,110,150,25);
        add(address); 
        
         JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(500,170,150,25);
        add(lblphone);
        
        JLabel phone = new JLabel("");
        phone.setBounds(690,170,150,25);
        add(phone); 
        
         JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(500,230,150,25);
        add(lblemail);
        
        JLabel email = new JLabel("");
        email.setBounds(690,230,150,25);
        add(email); 
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white); 
        back.setBounds(350,350,100,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(140,400,600,200);
        add(img);

        try{
            Conn c = new Conn();
            String query = "select * from customer where username = '"+usern+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                username.setText(rs.getString("username"));
                id.setText(rs.getString("id"));
                number.setText(rs.getString("number"));
                name.setText(rs.getString("name"));
                gender.setText(rs.getString("gender"));
                country.setText(rs.getString("country"));
                address.setText(rs.getString("address"));
                phone.setText(rs.getString("phone"));
                email.setText(rs.getString("email"));
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
        new ViewCustomer("");
    }
}
