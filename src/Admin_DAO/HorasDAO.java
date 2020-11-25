/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin_DAO;

import Admin_VO.HorasVO;
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
public class HorasDAO {
    
    Connection con;
    
    public HorasDAO(Connection conn){
        this.con=conn;
    }
    
public ArrayList getHoras(){
        PreparedStatement ps=null;
        ResultSet res=null;
        ArrayList listaHr=new ArrayList();
        HorasVO hrvo=null;
        String sql = "SELECT * FROM Horas";
        
        try {
            ps=con.prepareStatement(sql);
            res=ps.executeQuery();
            
            while(res.next()){
                hrvo=new HorasVO();
                hrvo.setIdHoras(res.getInt("idHora"));
                hrvo.setHora(res.getString("Hora"));
                listaHr.add(hrvo);
           } 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error SQL Horas: "+e.getMessage());
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
        
        
        return listaHr;
    }
    
}
