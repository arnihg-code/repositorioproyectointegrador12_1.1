/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author SUITE
 */
public class valeIngreso {
    
    
    private int idValeIngreso;
    private int idConcepto;
    private int idProveedores;
    private int idDetalleVaIngreso;
    private String observacion;
    private String fecha;
    

    public int getIdValeIngreso() {
        return idValeIngreso;
    }

    public void setIdValeIngreso(int idValeIngreso) {
        this.idValeIngreso = idValeIngreso;
    }

    public int getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(int idConcepto) {
        this.idConcepto = idConcepto;
    }

    public int getIdProveedores() {
        return idProveedores;
    }

    public void setIdProveedores(int idProveedores) {
        this.idProveedores = idProveedores;
    }

    public int getIdDetalleVaIngreso() {
        return idDetalleVaIngreso;
    }

    public void setIdDetalleVaIngreso(int idDetalleVaIngreso) {
        this.idDetalleVaIngreso = idDetalleVaIngreso;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
   
    
    

    
}
