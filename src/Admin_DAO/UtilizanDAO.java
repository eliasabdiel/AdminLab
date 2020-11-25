/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin_DAO;

import AdminLab.Ingreso;
import Admin_VO.HorasVO;
import Admin_VO.ResultadoVO;
import Admin_VO.UtilizanVO;
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
public class UtilizanDAO {

    Connection con;

    public UtilizanDAO(Connection conn) {
        this.con = conn;
    }

    public int insertarReserva(UtilizanVO utlvo) {
        PreparedStatement ps = null;
        int i = 0;
        String sql = "INSERT INTO Utilizan (dRut,nomLab,idAsignatura,Fecha,idHorario,idHora) "
                + "VALUES (?,?,?,?,?,?)";

        try {

            ps = con.prepareStatement(sql);

            ps.setString(1, utlvo.getdRut());
            ps.setString(2, utlvo.getNomLab());
            ps.setInt(3, utlvo.getIdAsignatura());
            ps.setDate(4, utlvo.getFecha());
            ps.setInt(5, utlvo.getIdHorario());
            ps.setInt(6, utlvo.getIdHora());
            i = ps.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL Utilizan" + e.getMessage());
        } finally {

            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error SQL" + e.getMessage());
            }
        }

        return i;
    }

    public ArrayList getReservas() {
        PreparedStatement ps = null;
        ResultSet res = null;
        ArrayList listaR = new ArrayList();
        ResultadoVO rvo = null;
        String sql = "SELECT u.idUtilizan,u.dRut, u.nomLab, a.Materia, u.Fecha, hor.desHorario, h.Hora \n"
                + "FROM utilizan u \n"
                + "JOIN asignaturas a ON u.idAsignatura = a.idAsignatura\n"
                + "JOIN horarios hor ON u.idHorario = hor.idHorario\n"
                + "JOIN horas h ON u.idHora = h.idHora\n"
                + "ORDER BY Fecha";

        try {
            ps = con.prepareStatement(sql);
            res = ps.executeQuery();

            while (res.next()) {
                rvo = new ResultadoVO();
                rvo.setIdUtilizan(res.getInt("idUtilizan"));
                rvo.setdRut(res.getString("dRut"));
                rvo.setNomLab(res.getString("nomLab"));
                rvo.setMateria(res.getString("Materia"));
                rvo.setFecha(res.getDate("Fecha"));
                rvo.setDesHorario(res.getString("desHorario"));
                rvo.setHora(res.getString("Hora"));
                listaR.add(rvo);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL Utilizan: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error SQL: " + e.getMessage());
            }
        }

        return listaR;
    }

    public int eliminaReserva(int id) {
        Ingreso ing = new Ingreso();
        PreparedStatement ps = null;
        int i = 0;
        String sql = "DELETE FROM Utilizan WHERE idUtilizan = " + id;

        try {

            ps = con.prepareStatement(sql);
            i = ps.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL Utilizan" + e.getMessage());
        } finally {

            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error SQL" + e.getMessage());
            }
        }

        return i;
    }

    public int repetirReserva(UtilizanVO utlvo) {
        PreparedStatement ps = null;
        ResultSet result = null;
        String sql = "select count(*) from utilizan where nomLab=? and Fecha = ? and idHorario = ? and idHora= ?";

        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, utlvo.getNomLab());
            ps.setDate(2, utlvo.getFecha());
            ps.setInt(3, utlvo.getIdHorario());
            ps.setInt(4, utlvo.getIdHora());
            result = ps.executeQuery();

            if (result.next()) {
                return result.getInt(1);
            }
            return 1;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL Utilizan" + e.getMessage());
            return 1;
        } finally {

            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error SQL" + e.getMessage());
            }
        }
    }

    public int repetirHora(HorasVO utlvo) {
        PreparedStatement ps = null;
        ResultSet result = null;
        String sql = "SELECT idHora FROM horas where hora = ?";

        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, utlvo.getHora());
            result = ps.executeQuery();

            if (result.next()) {
                return result.getInt(1);
            }
            return 1;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL Utilizan" + e.getMessage());
            return 1;
        }
    }

}
