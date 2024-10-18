
package travel.management;
import javax.swing.*;
import java.awt.*;
public class CheckPackage extends JFrame {
    String[] package1 = {"GOLD PACKAGE", "- 6 days & 7 nights", "- Airport Assistance", "- Half Day City Tour", "- Daily Buffet", "- Welcome drinks on Arrival", "- Full Day 3 Island Cruise", "BOOK NOW", "WINTER SPECIAL", "Rs. 120000/per", "package1.jpg"};
String[] package2 = {"SILVER PACKAGE", "- 5 days & 6 nights", "- Meet & Greet at Airport", "- Complementary breakfast", "- Campfire", "- Surprise Location ", "- English Speaking Guide", "BOOK NOW", "WINTER SPECIAL", "Rs. 200000/per", "package2.jpg"};
String[] package3 = {"BRONZE PACKAGE", "- 6 days & 5 nights", "- Return Airfare", "- Free Clubbing ", "- Horse Riding", "- Welcome drinks on Arrival",  "- Jungle Safari", "BOOK NOW", "SUMMER SPECIAL", "Rs. 150000/per", "package3.jpg"};

    CheckPackage(){
        setBounds(450,200,900,600);
        JTabbedPane tab = new JTabbedPane();
        
        JPanel p1 = createPackage(package1);
        tab.addTab("Package 1",null, p1);
        
        JPanel p2 = createPackage(package2);
        tab.addTab("Package 2",null, p2);
        
        JPanel p3 = createPackage(package3);
        tab.addTab("Package 3",null, p3); 
        
        add(tab);

        setVisible(true);
        
    }
    
    public JPanel createPackage(String[] pack){
                
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.white);
        
        JLabel l1 = new JLabel(pack[0]);
        l1.setBounds(30,5,300,30);
        l1.setForeground(new Color(255,215,0));
        l1.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(l1);
        
        JLabel l2 = new JLabel(pack[1]);
        l2.setBounds(50,60,300,30);
        l2.setForeground(new Color(245, 87, 66));
        l2.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l2);
        JLabel l3 = new JLabel(pack[2]);
        l3.setBounds(50,110,300,30);
        l3.setForeground(new Color(0,0,230));
        l3.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l3);
        
        JLabel l4 = new JLabel(pack[3]);
        l4.setBounds(50,160,300,30);
        l4.setForeground(new Color(245, 87, 66));
        l4.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l4);
        
        JLabel l5 = new JLabel(pack[4]);
        l5.setBounds(50,210,300,30);
        l5.setForeground(new Color(0,0,230));
        l5.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l5);
        
        JLabel l6 = new JLabel(pack[5]);
        l6.setBounds(50,260,300,30);
        l6.setForeground(new Color(245, 87, 66));
        l6.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l6);
        
        JLabel l7 = new JLabel(pack[6]);
        l7.setBounds(50,310,300,30);
        l7.setForeground(new Color(0,0,230));
        l7.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l7);
        
//        JLabel l8 = new JLabel(pack[7]);
//        l8.setBounds(50,360,300,30);
//        l8.setForeground(new Color(245, 87, 66));
//        l8.setFont(new Font("Tahoma",Font.BOLD,20));
//        p1.add(l8);
        
        JLabel l9 = new JLabel(pack[7]);
        l9.setBounds(60,430,300,30);
        l9.setForeground(Color.black);
        l9.setFont(new Font("Tahoma",Font.BOLD,25));
        p1.add(l9);
        
        JLabel l10 = new JLabel(pack[8]);
        l10.setBounds(300,430,300,30);
        l10.setForeground(Color.black);
        l10.setFont(new Font("Tahoma",Font.BOLD,25));
        p1.add(l10);
        
        JLabel l11 = new JLabel(pack[9]);
        l11.setBounds(600,430,300,30);
        l11.setForeground(Color.black);
        l11.setFont(new Font("Tahoma",Font.BOLD,25));
        p1.add(l11);
          
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/"+pack[10]));
        Image i2 = i1.getImage();
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(350,20,500,400);
        p1.add(l12);
        
        return p1;
    }
    public static void main(String args[]){
        new CheckPackage();
    }
}
