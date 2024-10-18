
package travel.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class BookHotel extends JFrame implements ActionListener{
    Choice chotel,cac,cfood;
    JLabel lblusername,lblid,lblph,lbltotal,lblnum;
    JTextField tfperson,tfdays; 
    JButton checkprice , bookpackage, back;
    String usern;
    BookHotel(String usern){
        this.usern = usern;
          setBounds(350,200,1100,600);
          setLayout(null);  
          getContentPane().setBackground(Color.white);
          JLabel text = new JLabel("BOOK HOTEL");
          text.setBounds(100,10,200,30);
          text.setFont(new Font("Tahoma",Font.BOLD,20));
          
          
         JLabel username = new JLabel("Username");
         username.setFont(new Font("Tahoma",Font.BOLD,16));
        username.setBounds(40,70,100,20);
        add(username); 
        
        lblusername = new JLabel();
        lblusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblusername.setBounds(250, 70, 100, 20);
        add(lblusername);
        
        JLabel lblpakcage = new JLabel("Select Hotel");
        lblpakcage.setFont(new Font("Tahoma",Font.BOLD,16));
        lblpakcage.setBounds(40,110,150,20);
        add(lblpakcage);
        
         chotel = new Choice();
         chotel.setBounds(250,110,150,20);
         add(chotel);
          try{
             Conn c = new Conn();
             ResultSet rs = c.s.executeQuery("select * from hotel");
             while(rs.next()){
                 chotel.add(rs.getString("name"));
             }
             
         }catch(Exception e){
             e.printStackTrace();
         }
          
          JLabel lblpersons = new JLabel("Total People");
        lblpersons.setFont(new Font("Tahoma",Font.BOLD,16));
        lblpersons.setBounds(40,150,150,25);
        add(lblpersons);
        
        tfperson = new JTextField("1");
        tfperson.setBounds(250,150,200,25);
        add(tfperson);
        
         JLabel lbldays = new JLabel("Total Days");
        lbldays.setFont(new Font("Tahoma",Font.BOLD,16));
        lbldays.setBounds(40,190,150,25);
        add(lbldays);
        
        tfdays = new JTextField("1");
        tfdays.setBounds(250,190,200,25);
        add(tfdays);
        
         JLabel lblac = new JLabel("AC/NOM AC");
        lblac.setFont(new Font("Tahoma",Font.BOLD,16));
        lblac.setBounds(40,230,150,25);
        add(lblac);
        
        cac = new Choice();
        cac.add("Yes");
        cac.add("No");
        cac.setBounds(250,230,200,25);
        add(cac);
         
        JLabel lblfood = new JLabel("Food Included");
        lblfood.setFont(new Font("Tahoma",Font.BOLD,16));
        lblfood.setBounds(40,270,150,25);
        add(lblfood);
        
        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250,270,200,25);
        add(cfood);
        
       
        
        JLabel id = new JLabel("ID");
        id.setFont(new Font("Tahoma",Font.BOLD,16));
        id.setBounds(40, 310, 150, 25);
        add(id);
          
        lblid = new JLabel();
        lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblid.setBounds(250,310,150,25);
        add(lblid);
        
        JLabel number = new JLabel("Number");
        number.setFont(new Font("Tahoma",Font.BOLD,16));
        number.setBounds(40, 350, 150, 25);
        add(number);
          
        lblnum = new JLabel();
        lblnum.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblnum.setBounds(250,350,150,25);
        add(lblnum);
        
        JLabel phone = new JLabel("Phone");
        phone.setFont(new Font("Tahoma",Font.BOLD,16));
        phone.setBounds(40, 390, 150, 25);
        add(phone);
          
        lblph = new JLabel();
        lblph.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblph.setBounds(250,390,150,25);
        add(lblph);
        
        JLabel total= new JLabel("Total prices");
        total.setFont(new Font("Tahoma",Font.BOLD,16));
        total.setBounds(40, 430, 150, 25);
        add(total);
          
        lbltotal = new JLabel();
        lbltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbltotal.setBounds(250,430,150,25);
        add(lbltotal);
        

          try{
            Conn c = new Conn();
            String query = "select * from customer where username = '"+usern+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                lblusername.setText(rs.getString("username"));
                lblid.setText(rs.getString("id"));
                lblnum.setText(rs.getString("number"));
                lblph.setText(rs.getString("phone"));
               
            }
        }catch(Exception e){
            e.printStackTrace();
        }
          
       
        
        bookpackage = new JButton("Book Package");
        bookpackage.setBackground(Color.black);
        bookpackage.setForeground(Color.white);
        bookpackage.setBounds(200,500,120,25);
         bookpackage.addActionListener(this);
        add(bookpackage);
          
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(360,500,120,25);
         back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage();
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(550,50,500,300);
        add(l12);
        
          setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkprice){
            String packg = chotel.getSelectedItem();
            int cost = 0;
            if(packg.equals("GOLD PACKAGE")){
                cost += 120000;
            }
            else if(packg.equals("SILVER PACKAGE")){
                  cost += 200000;
            }
            else {
                cost += 150000;
            }
           
        
        int persons = Integer.parseInt(tfperson.getText());
        cost *= persons;
        lbltotal.setText("Rs. "+cost);
        }
        else if(ae.getSource() == bookpackage){
            try{
                Conn c= new Conn();
                c.s.executeUpdate("insert into bookedpackages values('"+lblusername.getText()+"','"+chotel.getSelectedItem()+"','"+tfperson.getText()+"','"+lblid.getText()+"','"+lblnum.getText()+"','"+lblph.getText()+"','"+lbltotal.getText()+"')");
                JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                setVisible(false);
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }
    public static void main(String args[]){
        new BookHotel("");
    }
}
