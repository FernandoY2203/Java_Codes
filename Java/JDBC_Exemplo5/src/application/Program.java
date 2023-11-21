
package application;

import db.DB;
import db.DbIntegrityException;
import java.sql.*;

public class Program {
    public static void main(String[] args) {
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        try{
            conn = DB.getConnection();
            
            pst = conn.prepareStatement(
                    "DELETE FROM department " + 
                    "WHERE Id = ?"
            );
            
            pst.setInt(1, 5);
            
            int rowsAffected = pst.executeUpdate(); 
            
            System.out.println("Done!, Rows affected: " + rowsAffected);
        }
        catch(SQLException e){
            throw new DbIntegrityException(e.getMessage()); // Captura de Exceção de integridade do JDBC e lançando uma Exceção personalizada
        }
        finally{
            DB.closeStatement(pst);
            DB.closeConnection();
        }
    }
}
