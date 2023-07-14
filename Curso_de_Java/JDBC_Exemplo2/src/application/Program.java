
package application;

import db.DB;
import java.sql.*;

public class Program {
    public static void main(String[] args) {
        
        Connection conn = null; // Connection, Statement e ResultSet são recursos externos não controlados pela JVM 
        Statement st = null;
        ResultSet rs = null;
        
        try{
            conn = DB.getConnection();
            
            st = conn.createStatement();
            
            rs = st.executeQuery("Select * From department");
            
            while(rs.next()){
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{ // Fechamento dos recurso para evitar Vazamento de Memória
            DB.closeResultSet(rs); 
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
