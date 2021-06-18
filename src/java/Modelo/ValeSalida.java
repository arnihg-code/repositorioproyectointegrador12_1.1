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
public class ValeSalida {
    
    private int idValeSalida;
    private int idConcepto;
    private int idProveedores;
    private int idDetalleValeSalida;
    private String observacion;
    private String fecha;

    public int getIdValeSalida() {
        return idValeSalida;
    }

    public void setIdValeSalida(int idValeSalida) {
        this.idValeSalida = idValeSalida;
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

    public int getIdDetalleValeSalida() {
        return idDetalleValeSalida;
    }

    public void setIdDetalleValeSalida(int idDetalleValeSalida) {
        this.idDetalleValeSalida = idDetalleValeSalida;
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
