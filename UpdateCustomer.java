package travel.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class UpdateCustomer extends JFrame implements ActionListener{
    JLabel lblusername,lblname;
    JComboBox comboid;
    JTextField tfnumber,tfcountry,tfaddress,tfphone,tfemail,tfid,tfgender; 
//    JRadioButton male,female;
    JButton add,back;
    
    UpdateCustomer(String user){
        System.out.println(user);
        System.out.println("Hello");
        setBounds(500,200,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(200,0,450,25);
        text.setFont(new Font("Tahoma",Font.BOLD,25));
        add(text);
        
        JLabel username = new JLabel("Username");
        username.setBounds(30,50,150,25);
        add(username);
        
        lblusername = new JLabel();
        lblusername.setBounds(220, 50, 150, 25);
        add(lblusername);
        
        JLabel id = new JLabel("ID");
        id.setBounds(30, 90, 150, 25);
        add(id);
        
        tfid = new JTextField();
        tfid.setBounds(220,90,150,25);
        add(tfid);
        
        comboid = new JComboBox(new String[] {"Passport","Aadhar card","Pan card","Ration card"});
        comboid.setBounds(220,90,150,25);
        comboid.setBackground(Color.white);
        add(comboid);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30,130,150,25);
        add(lblnumber);
        
        tfnumber = new JTextField();
        tfnumber.setBounds(220,130,150,25);
        add(tfnumber);
        
        JLabel name = new JLabel("Name");
        name.setBounds(30,170,150,25);
        add(name);
        
        lblname = new JLabel();
        lblname.setBounds(220, 170, 150, 25);
        add(lblname);
        
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(30,210,150,25);
        add(gender);
        
        tfgender = new JTextField();
        tfgender.setBounds(220,210,150,25);
        add(tfgender);
        
//        male = new JRadioButton("Male");
//        male.setBounds(220, 210, 70, 25);
//        add(male);
//        
//        female = new JRadioButton("Female");
//        female.setBounds(300, 210, 70, 25);
//        add(female);
//        
//        ButtonGroup bg = new ButtonGroup(); //To at a time slect a=only one button this is necessary other wise selection of both will be allowed
//        bg.add(male);
//        bg.add(female);
        
        JLabel country = new JLabel("Country");
        country.setBounds(30,250,150,25);
        add(country);
        
        tfcountry = new JTextField();
        tfcountry.setBounds(220,250,150,25);
        add(tfcountry);
        
        JLabel address = new JLabel("Address");
        address.setBounds(30,290,150,25);
        add(address);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(220,290,150,25);
        add(tfaddress);
        
        JLabel phone = new JLabel("Phone No");
        phone.setBounds(30,330,150,25);
        add(phone);
        
        tfphone = new JTextField();
        tfphone.setBounds(220,330,150,25);
        add(tfphone);
        
        JLabel email = new JLabel("Email");
        email.setBounds(30,370,150,25);
        add(email);
        
        tfemail = new JTextField();
        tfemail.setBounds(220,370,150,25);
        add(tfemail);
        
        add = new JButton("Add");
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.setBounds(70,430,100,25);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(220,430,100,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png "));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(400,40,450,600);
        add(img);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '"+user+"' ");
            while(rs.next()){
                lblusername.setText(rs.getString("username"));
                lblname.setText(rs.getString("name"));
                tfid.setText(rs.getString("id"));
                tfnumber.setText(rs.getString("number"));
                tfgender.setText(rs.getString("gender"));
                tfcountry.setText(rs.getString("country"));
                tfaddress.setText(rs.getString("address"));
                tfemail.setText(rs.getString("email"));
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String username = lblusername.getText();
            String id = tfid.getText();
            String number = tfnumber.getText();
            String name = lblname.getText();
            String gender = tfgender.getText();
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            
            try{
                Conn c = new Conn();
                  String query = "update customer set username = '" + username + "', id = '" + id + "', number = '" + number + "', name = '" + name + "', gender = '" + gender + "', country = '" + country + "', address = '" + address + "', phone =  '" + phone + "', email = '" + email + "'";

                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
         
            
        }
    }
    public static void main(String args[]){
        new UpdateCustomer("");
    }
}
