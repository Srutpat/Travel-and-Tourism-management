package travel.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener  {
    static String username;
    JButton addDetails,viewDetails,updateDetails,checkpackages,bookpackage,viewpackage,viewhotels,destinations;
    Dashboard(String username){
        this.username = username;
        System.out.println(username);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // for full screen
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1600,65);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5, 0, 70, 70);
        
        p1.add(icon);
        
        JLabel text = new JLabel("Travel and Tourism System");
        text.setBounds(580,15,1000,55);
        text.setForeground(Color.white);
        text.setFont(new Font("Calibri",Font.BOLD,55));
        p1.add(text);
        
        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80,10,300,40);
        heading.setFont(new Font("Tahoma",Font.BOLD,22));
        heading.setForeground(Color.WHITE);
        p1.add(heading);
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,300,900);
        add(p2);
        
        addDetails = new JButton("Add Personal Details");
        addDetails.setBounds(0,0,300,50);
        addDetails.setBackground(new Color(0,0,102));
        addDetails.setForeground(Color.WHITE);
        addDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        addDetails.setMargin((new Insets(0,0,0,50)));
        addDetails.addActionListener(this);
        p2.add(addDetails);
        
        updateDetails = new JButton("Update Personal Details");
        updateDetails.setBounds(0,50,300,50);
        updateDetails.setBackground(new Color(0,0,102));
        updateDetails.setForeground(Color.WHITE);
        updateDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        updateDetails.setMargin((new Insets(0,0,0,25)));
        updateDetails.addActionListener(this);
        p2.add(updateDetails);
        
        viewDetails = new JButton("View Details");
        viewDetails.setBounds(0,100,300,50);
        viewDetails.setBackground(new Color(0,0,102));
        viewDetails.setForeground(Color.WHITE);
        viewDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewDetails.setMargin((new Insets(0,0,0,130)));
        viewDetails.addActionListener(this);
        p2.add(viewDetails);
        
        JButton deleteDetails = new JButton("Delete Personal Details");
        deleteDetails.setBounds(0,150,300,50);
        deleteDetails.setBackground(new Color(0,0,102));
        deleteDetails.setForeground(Color.WHITE);
        deleteDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        deleteDetails.setMargin((new Insets(0,0,0,35)));
        p2.add(deleteDetails);
        
        checkpackages = new JButton("Check package");
        checkpackages.setBounds(0,200,300,50);
        checkpackages.setBackground(new Color(0,0,102));
        checkpackages.setForeground(Color.WHITE);
        checkpackages.setFont(new Font("Tahoma",Font.PLAIN,20));
        checkpackages.setMargin((new Insets(0,0,0,100)));
        checkpackages.addActionListener(this);
        p2.add(checkpackages);
        
        bookpackage = new JButton("Book package");
        bookpackage.setBounds(0,250,300,50);
        bookpackage.setBackground(new Color(0,0,102));
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookpackage.setMargin((new Insets(0,0,0,110)));
        bookpackage.addActionListener(this);
        p2.add(bookpackage);
        
        viewpackage = new JButton("View package");
        viewpackage.setBounds(0,300,300,50);
        viewpackage.setBackground(new Color(0,0,102));
        viewpackage.setForeground(Color.WHITE);
        viewpackage.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewpackage.setMargin((new Insets(0,0,0,110)));
        viewpackage.addActionListener(this);
        p2.add(viewpackage);
        
        viewhotels = new JButton("View Hotels");
        viewhotels.setBounds(0,350,300,50);
        viewhotels.setBackground(new Color(0,0,102));
        viewhotels.setForeground(Color.WHITE);
        viewhotels.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewhotels.setMargin((new Insets(0,0,0,130)));
        viewhotels.addActionListener(this);
        p2.add(viewhotels);
        
        JButton bookhotel = new JButton("Book Hotel");
        bookhotel.setBounds(0,400,300,50);
        bookhotel.setBackground(new Color(0,0,102));
        bookhotel.setForeground(Color.WHITE);
        bookhotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookhotel.setMargin((new Insets(0,0,0,135)));
        p2.add(bookhotel);
       
        JButton viewbookedhotel = new JButton("View Booked Hotel");
        viewbookedhotel.setBounds(0,450,300,50);
        viewbookedhotel.setBackground(new Color(0,0,102));
        viewbookedhotel.setForeground(Color.WHITE);
        viewbookedhotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewbookedhotel.setMargin((new Insets(0,0,0,65 )));
        p2.add(viewbookedhotel);
        
        destinations = new JButton("View Booked Hotel");
        destinations.setBounds(0,450,300,50);
        destinations.setBackground(new Color(0,0,102));
        destinations.setForeground(Color.WHITE);
        destinations.setFont(new Font("Tahoma",Font.PLAIN,20));
        destinations.setMargin((new Insets(0,0,0,65 )));
        destinations.addActionListener(this);
        p2.add(destinations);
        
        JButton payments = new JButton("Payments");
        payments.setBounds(0,500,300,50);
        payments.setBackground(new Color(0,0,102));
        payments.setForeground(Color.WHITE);
        payments.setFont(new Font("Tahoma",Font.PLAIN,20));
        payments.setMargin((new Insets(0,0,0,148 )));
        p2.add(payments);
        
        JButton calculator = new JButton("Calculator");
        calculator.setBounds(0,550,300,50);
        calculator.setBackground(new Color(0,0,102));
        calculator.setForeground(Color.WHITE);
        calculator.setFont(new Font("Tahoma",Font.PLAIN,20));
        calculator.setMargin((new Insets(0,0,0,145 )));
        p2.add(calculator);
        
        JButton notepad = new JButton("Notepad");
        notepad.setBounds(0,600,300,50);
        notepad.setBackground(new Color(0,0,102));
        notepad.setForeground(Color.WHITE);
        notepad.setFont(new Font("Tahoma",Font.PLAIN,20));
        notepad.setMargin((new Insets(0,0,0,155)));
        p2.add(notepad);
        
        JButton about = new JButton("About ");
        about.setBounds(0,650,300,50);
        about.setBackground(new Color(0,0,102));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("Tahoma",Font.PLAIN,20));
        about.setMargin((new Insets(0,0,0,173 )));
        p2.add(about);
       
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0,0,1650,1000);
        add(image);

        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addDetails){
            new AddCustomer(username);
        }
        else if(ae.getSource() == viewDetails){
            new ViewCustomer(username);
        }
        else if(ae.getSource() == updateDetails){
            new UpdateCustomer(username);
        }else if(ae.getSource() == checkpackages){
            new CheckPackage();
        }else if(ae.getSource() == bookpackage){
            new BookPackage(username);
        }else if(ae.getSource() == viewpackage){
            new ViewPackage(username);
            
        }else if(ae.getSource() == viewhotels){
            new CheckHotels();
        }
        else if(ae.getSource() == destinations){
            new Destinations();
        }
    }
    public static void main(String args[]){
        new Dashboard("");
//        System.out.println(username);
//        new AddCustomer(username);
    }
}
