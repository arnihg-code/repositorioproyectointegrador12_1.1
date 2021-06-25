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
    private concepto Concepto;
    private Proveedores nombresProveedor;
    private Producto nomProducto;
    private String observacion;
    private String fecha;

    public int getIdValeSalida() {
        return idValeSalida;
    }

    public void setIdValeSalida(int idValeSalida) {
        this.idValeSalida = idValeSalida;
    }


    public concepto getConcepto() {
        return Concepto;
    }

    public void setConcepto(concepto Concepto) {
        this.Concepto = Concepto;
    }

    public Proveedores getNombresProveedor() {
        return nombresProveedor;
    }

    public void setNombresProveedor(Proveedores nombresProveedor) {
        this.nombresProveedor = nombresProveedor;
    }

    public Producto getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(Producto nomProducto) {
        this.nomProducto = nomProducto;
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
