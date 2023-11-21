
package application;

import db.DB;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Program {
    public static void main(String[] args) {
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        try{
            conn = DB.getConnection();
            
            pst = conn.prepareStatement(
                    "INSERT INTO seller " + 
                    "(Name, Email, BirthDate, BaseSalary, DepartmentId)" +
                    "VALUES (?, ?, ?, ?, ?)", // "?" Place Holder, O valor é colocado posteriorimente e cada campo corresponde a um "?" 
                    Statement.RETURN_GENERATED_KEYS // Retorna o Id do vendedor inserido
            );
            
            pst.setString(1, "Carl Purple");
            pst.setString(2, "carl@gmail.com");
            pst.setObject(3, LocalDate.parse("22/04/1985", DateTimeFormatter.ofPattern("dd/MM/yyyy"))); 
            pst.setDouble(4, 3000.00);
            pst.setInt(5, 4);
            
            int rowsAffected = pst.executeUpdate(); // Executa o PreparedStatement, e retorna um numero inteiro indicando quantas linhas foram alteradas
            
            if(rowsAffected > 0){
                ResultSet rs = pst.getGeneratedKeys(); // Retorna um ResultSet com as Chaves geradas na inserção
                
                while(rs.next()){
                    int id = rs.getInt(1); // Pega o inteiro na primeira posição
                    
                    System.out.println("Done!, Id = " + id);
                }
            }
            else{
                System.out.println("No rows affected!");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            DB.closeStatement(pst);
            DB.closeConnection();
        }
    }
}
