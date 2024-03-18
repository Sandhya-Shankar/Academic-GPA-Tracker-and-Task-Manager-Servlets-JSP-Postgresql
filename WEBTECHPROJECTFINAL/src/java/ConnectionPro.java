import java.sql.*;


public class ConnectionPro {
    public Connection con;
    
    public Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bhaarathi?zeroDateTimeBehavior=CONVERT_TO_NULL","root","leomessi10");
            
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(con);
        return con;
    }
}
