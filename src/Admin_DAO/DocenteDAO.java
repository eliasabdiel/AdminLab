/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin_DAO;

import Admin_VO.DocenteVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author SMK GAMING
 */
public class DocenteDAO {
    
    Connection con;
    
    public DocenteDAO(Connection conn){
        this.con=conn;
    }
    
public ArrayList getDocente(){
        PreparedStatement ps=null;
        ResultSet res=null;
        ArrayList listaD=new ArrayList();
        DocenteVO dovo=null;
        String sql = "SELECT * FROM Docentes";
        
        try {
            ps=con.prepareStatement(sql);
            res=ps.executeQuery();
            
            while(res.next()){
                dovo=new DocenteVO();
                dovo.setRut(res.getString("Rut"));
                dovo.setNombre(res.getString("Nombre"));
                dovo.setApellido(res.getString("Apellido"));
                dovo.setEdad(res.getInt("Edad"));
                listaD.add(dovo);
           } 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error SQL Categoria: "+e.getMessage());
        }
        finally
        {
            try{
                if(ps != null) ps.close();
            }
            catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error SQL: "+e.getMessage());
            }
        }
        
        
        return listaD;
    }

}
