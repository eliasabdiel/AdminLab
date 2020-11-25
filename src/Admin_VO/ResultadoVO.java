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
public class ResultadoVO {
    private int idUtilizan;
    private String dRut;
    private String nomLab;
    private String materia;
    private Date fecha;
    private String desHorario;
    private String Hora;

    public String getdRut() {
        return dRut;
    }

    public void setdRut(String dRut) {
        this.dRut = dRut;
    }

    public int getIdUtilizan() {
        return idUtilizan;
    }

    public void setIdUtilizan(int idUtilizan) {
        this.idUtilizan = idUtilizan;
    }

    public String getNomLab() {
        return nomLab;
    }

    public void setNomLab(String nomLab) {
        this.nomLab = nomLab;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDesHorario() {
        return desHorario;
    }

    public void setDesHorario(String desHorario) {
        this.desHorario = desHorario;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }
    
    
}
