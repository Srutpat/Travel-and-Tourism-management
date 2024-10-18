
package travel.management;
import java.sql.*;
//5 steps : 1 - Register driver of mysql

public class Conn {
    Connection c;
    Statement s;
    Conn(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelmanagement","root","1234"); //1 - Register driver of mysql
        //2 - mysql setup creation of databse
        s = c.createStatement(); //3 - statement creation
        //jdbc helps in executing mysql queries with java
        
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


}
