/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin_VO;

import java.sql.Date;

/**
 *
 * @author SMK GAMING
 */
public class UtilizanVO {

    private int idUtilizan;
    private String dRut;
    private String nomLab;
    private int idAsignatura;
    private Date fecha;
    private int idHorario;
    private int idHora;

    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public int getIdHora() {
        return idHora;
    }

    public void setIdHora(int idHora) {
        this.idHora = idHora;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getdRut() {
        return dRut;
    }

    public void setdRut(String dRut) {
        this.dRut = dRut;
    }

    public String getNomLab() {
        return nomLab;
    }

    public void setNomLab(String nomLab) {
        this.nomLab = nomLab;
    }

    public int getIdUtilizan() {
        return idUtilizan;
    }

    public void setIdUtilizan(int idUtilizan) {
        this.idUtilizan = idUtilizan;
    }

}
