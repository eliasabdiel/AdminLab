/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin_DAO;

import Admin_VO.AsignaturaVO;
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
public class AsignaturaDAO {
    
    Connection con;
    
    public AsignaturaDAO(Connection conn){
        this.con=conn;
    }
    
    
    public ArrayList getAsignatura(){
        PreparedStatement ps=null;
        ResultSet res=null;
        ArrayList listaA=new ArrayList();
        AsignaturaVO avo=null;
        String sql = "SELECT * FROM Asignaturas";
        
        try {
            ps=con.prepareStatement(sql);
            res=ps.executeQuery();
            
            while(res.next()){
                avo=new AsignaturaVO();
                avo.setIdAsignatura(res.getInt("idAsignatura"));
                avo.setMateria(res.getString("Materia"));
                listaA.add(avo);
           } 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error SQL Asignatura: "+e.getMessage());
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
        
        
        return listaA;
    }
}
