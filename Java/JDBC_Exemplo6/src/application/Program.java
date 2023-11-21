
package application;

import db.DB;
import db.DbException;
import java.sql.*;

public class Program {
    public static void main(String[] args) {
        
        Connection conn = null;
        Statement st = null;
        
        try{
            conn = DB.getConnection();
            conn.setAutoCommit(false); // Não Confirma as operações automaticamente usado false, fazendo com que as operações fiquem pendente até que o programador confirme a execução
            
            st = conn.createStatement();
            
            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");

            //Erro Fake para Teste de Transação
//            int x = 1;
//            if(x < 2){
//                throw new SQLException("Fake Error");
//            }
            
            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");
            
            conn.commit(); // Confirma o termino da transação
            
            System.out.println("Rows1: " + rows1);
            System.out.println("Rows2: " + rows2);
        }
        catch(SQLException e){
            try{
                conn.rollback(); // Retorna ao estado inicial do banco de dados, desfaz alterações
                
                throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
            } 
            catch(SQLException e2) {
                throw new DbException("Error trying to rollback! Coused by: " + e2.getMessage());
            }
        }
        finally{
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
