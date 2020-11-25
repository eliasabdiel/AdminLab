/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin_DAO;

import Admin_VO.HorariosVO;
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
public class HorariosDAO {
    
    Connection con;
    
    public HorariosDAO(Connection conn){
        this.con=conn;
    }
    
public ArrayList getHorarios(){
        PreparedStatement ps=null;
        ResultSet res=null;
        ArrayList listaLab=new ArrayList();
        HorariosVO lavo=null;
        String sql = "SELECT * FROM Horarios";
        
        try {
            ps=con.prepareStatement(sql);
            res=ps.executeQuery();
            
            while(res.next()){
                lavo=new HorariosVO();
                lavo.setIdHorario(res.getInt("idHorario"));
                lavo.setDesHorario(res.getString("desHorario"));
                listaLab.add(lavo);
           } 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error SQL Laboratorios: "+e.getMessage());
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
        
        return listaLab;
    }
}
