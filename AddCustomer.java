
package travel.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.PreparedStatement;
public class AddCustomer extends JFrame implements ActionListener {
    JLabel lblusername,lblname;
    JComboBox comboid;
    JTextField tfnumber,tfcountry,tfaddress,tfphone,tfemail; 
    JRadioButton male,female;
    JButton add,back;
    String usern;
    AddCustomer(String user){
        usern = user;
        System.out.println("Hello");
        System.out.println(user);
        System.out.println("World");
        setBounds(450,200,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel username = new JLabel("Username");
        username.setBounds(30,50,150,25);
        add(username);
        
        lblusername = new JLabel();
        lblusername.setBounds(220, 50, 150, 25);
        add(lblusername);
        
        JLabel id = new JLabel("ID");
        id.setBounds(30, 90, 150, 25);
        add(id);
        
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
        
        male = new JRadioButton("Male");
        male.setBounds(220, 210, 70, 25);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(300, 210, 70, 25);
        add(female);
        
        ButtonGroup bg = new ButtonGroup(); //To at a time slect a=only one button this is necessary other wise selection of both will be allowed
        bg.add(male);
        bg.add(female);
        
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
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg "));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(400,40,450,520);
        add(img);
        
        try{
            Conn cn = new Conn();
            String query = "select * from account where username = ? ";
            PreparedStatement st = cn.c.prepareStatement(query);
            st.setString(1, user);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                lblusername.setText(rs.getString("username"));
                lblname.setText(rs.getString("name"));
                System.out.println("Done");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String username = lblusername.getText();
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = lblname.getText();
            String gender = null;
            if(male.isSelected()){
                gender = "Male";
            }
            else{
                 gender = "Female";
            }
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            
            try{
                Conn c = new Conn();
                  String query = "INSERT INTO customer (username, id, number, name, gender, country, address, phone, email) VALUES ('" + username + "', '" + id + "', '" + number + "', '" + name + "', '" + gender + "', '" + country + "', '" + address + "', '" + phone + "', '" + email + "')";

                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
         
            
        }
        else{
            setVisible(false);
            new Dashboard(usern);
        }
    }
    public static void main(String args[]){
        new AddCustomer("");
    }
}
