/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Lenovo
 */
public class ProductoFac {
    private int numeroFac;
    private String codigoProducto;
    private String  nombreProducto;
    private int cantidad;
    private double precio;
    private double subtotal;

    public ProductoFac() {
    }

    public ProductoFac(int numeroFac, String codigoProducto, String nombreProducto, int cantidad, double precio, double subtotal) {
        this.numeroFac = numeroFac;
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
    }
    

    public int getNumeroFac() {
        return this.numeroFac;
    }

    public void setNumeroFac(int numeroFac) {
        this.numeroFac = numeroFac;
    }

    public String getCodigoProducto() {
        return this.codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return this.nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getSubtotal() {
        return this.subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
}
