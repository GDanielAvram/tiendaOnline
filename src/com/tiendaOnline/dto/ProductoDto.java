package com.tiendaOnline.dto;

public class ProductoDto {
    private long idProducto;
    private String nombreProducto;
    private double precio;
    private long stock;
    private float descuento;
    private String tipoProducto;

    public long getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }
    public String getNombreProducto() {
        return nombreProducto;
    }
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public long getStock() {
        return stock;
    }
    public void setStock(long stock) {
        this.stock = stock;
    }
    public float getDescuento() {
        return descuento;
    }
    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }
    public String getTipoProducto() {
        return tipoProducto;
    }
    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
}