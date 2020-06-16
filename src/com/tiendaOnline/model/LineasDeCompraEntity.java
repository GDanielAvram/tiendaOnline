package com.tiendaOnline.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "lineasdecompra", schema = "tiendaonline", catalog = "")
public class LineasDeCompraEntity {
    private long idLineaCompra;
    private long idProducto;
    private long idVenta;
    private double precioProducto;

    @Id
    @Column(name = "idLineaCompra")
    public long getIdLineaCompra() {
        return idLineaCompra;
    }

    public void setIdLineaCompra(long idLineaCompra) {
        this.idLineaCompra = idLineaCompra;
    }

    @Basic
    @Column(name = "idProducto")
    public long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }

    @Basic
    @Column(name = "idVenta")
    public long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(long idVenta) {
        this.idVenta = idVenta;
    }

    @Basic
    @Column(name = "precioProducto")
    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineasDeCompraEntity that = (LineasDeCompraEntity) o;
        return idLineaCompra == that.idLineaCompra &&
                idProducto == that.idProducto &&
                idVenta == that.idVenta &&
                Double.compare(that.precioProducto, precioProducto) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLineaCompra, idProducto, idVenta, precioProducto);
    }
}
