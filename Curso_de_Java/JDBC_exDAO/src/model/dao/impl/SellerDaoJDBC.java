
package model.dao.impl;

import db.DB;
import db.DbException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao{

    private Connection conn;

    public SellerDaoJDBC(Connection conn) {
        this.conn = conn;
    }
    
    //------------------------------------------------------------------------//
    
    @Override
    public void insert(Seller obj) {
        
        PreparedStatement pst = null;
        
        try{
            pst = conn.prepareStatement("INSERT INTO seller " +
                                        "(Name, Email, BirthDate, BaseSalary, DepartmentId) " +
                                        "VALUES " +
                                        "(?, ?, ?, ?, ?)",
                                        Statement.RETURN_GENERATED_KEYS
            );
            
            pst.setString(1, obj.getName());
            pst.setString(2, obj.getEmail());
            pst.setObject(3, obj.getBirthDate());
            pst.setDouble(4, obj.getBaseSalary());
            pst.setInt(5, obj.getDepartment().getId());
            
            int rowsAdded = pst.executeUpdate();
            
            if(rowsAdded > 0){
                ResultSet rs = pst.getGeneratedKeys();
                
                if(rs.next()){
                    int id = rs.getInt(1);
                    
                    obj.setId(id);
                }
                
                DB.closeResultSet(rs);
            }
            else{
                throw new DbException("Unexpected error!! No rows added!!!");
            }
        }
        catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            DB.closeStatement(pst);
        }
    }

    @Override
    public void update(Seller obj) {
        PreparedStatement pst = null;
        
        try{
            pst = conn.prepareStatement("UPDATE seller " +
                                        "SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ? " +
                                        "WHERE Id = ? " 
            );
            
            pst.setString(1, obj.getName());
            pst.setString(2, obj.getEmail());
            pst.setObject(3, obj.getBirthDate());
            pst.setDouble(4, obj.getBaseSalary());
            pst.setInt(5, obj.getDepartment().getId());
            
            pst.setInt(6, obj.getId());
            
            pst.executeUpdate();
        }
        catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            DB.closeStatement(pst);
        }
    }

    @Override
    public void deleteById(Integer id) {
        
        PreparedStatement pst = null;
        
        try{
            pst = conn.prepareStatement("DELETE FROM seller " +
                                        "WHERE Id = ?"
            );
            
            pst.setInt(1, id);
            
            pst.executeUpdate();
        }
        catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            DB.closeStatement(pst);
        }
    }

    @Override
    public Seller findById(Integer id) {
        
        PreparedStatement pst = null;
        ResultSet rs = null;
            
        try{
            pst = conn.prepareStatement("SELECT s.*, d.Name AS DepName " +
                                        "FROM seller AS s " +
                                        "INNER JOIN department AS d ON s.DepartmentId = d.Id " +
                                        "WHERE s.Id = ?"
            );
            
            pst.setInt(1, id);
            
            rs = pst.executeQuery();
 
            if(rs.next()){
                Department dep = instantieateDepartment(rs);
                Seller sel = instantieateSeller(rs, dep);
                
                return sel;
            }
            
            return null;
        } 
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally{
            DB.closeResultSet(rs);
            DB.closeStatement(pst);
        }
    }

    @Override
    public List<Seller> findAll() {
       
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try{
            pst = conn.prepareStatement("SELECT s.*, d.Name AS DepName " +
                                        "FROM seller s " +
                                        "INNER JOIN department d ON s.DepartmentId = d.Id " +
                                        "ORDER BY Name"
            );
            
            rs = pst.executeQuery();
            
            List<Seller> list = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>(); 
            
            while(rs.next()){
                Department dep = map.get(rs.getInt("DepartmentId"));
                
                if(dep == null){
                    dep = instantieateDepartment(rs);
                    
                    map.put(rs.getInt("DepartmentId"), dep); 
                }
                
                Seller sel = instantieateSeller(rs, dep);
                
                list.add(sel);
            }
            
            return list;
        }
        catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            DB.closeResultSet(rs);
            DB.closeStatement(pst);
        }
    }

    @Override
    public List<Seller> findByDepartment(Department department) {
        
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try{
            pst = conn.prepareStatement("SELECT s.*, d.Name AS DepName " +
                                        "FROM seller s " +
                                        "INNER JOIN department AS d ON s.DepartmentId = d.Id " +
                                        "WHERE DepartmentId = ? " +
                                        "ORDER BY Name"
            );
            
            pst.setInt(1, department.getId());
            
            rs = pst.executeQuery();
            
            List<Seller> list = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>(); 
            
            while(rs.next()){
                Department dep = map.get(rs.getInt("DepartmentId"));
                
                if(dep == null){
                    dep = instantieateDepartment(rs);
                    
                    map.put(rs.getInt("DepartmentId"), dep); 
                }
                
                Seller sel = instantieateSeller(rs, dep);
                
                list.add(sel);
            }
            
            return list;
        }
        catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            DB.closeResultSet(rs);
            DB.closeStatement(pst);
        }
    }
    
    //------------------------------------------------------------------------//

    private Department instantieateDepartment(ResultSet rs) throws SQLException{
        Department dep = new Department(rs.getInt("DepartmentId"), rs.getString("DepName"));

        return dep;
    }

    private Seller instantieateSeller(ResultSet rs, Department dep) throws SQLException{
        Seller sel = new Seller(rs.getInt("Id"), rs.getString("Name"), 
                                rs.getString("Email"), rs.getDate("BirthDate").toLocalDate(), // Pode ser usado tambem rs.getObject("BirthDate", LocalDate.class)
                                rs.getDouble("BaseSalary"), dep);

        return sel;
    }
}
