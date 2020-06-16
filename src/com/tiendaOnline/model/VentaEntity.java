package com.tiendaOnline.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "venta", schema = "tiendaonline", catalog = "")
public class VentaEntity {
    private long idVenta;
    private Timestamp fechaVenta;
    private double descuento;
    private long idCliente;

    @Id
    @Column(name = "idVenta")
    public long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(long idVenta) {
        this.idVenta = idVenta;
    }

    @Basic
    @Column(name = "fechaVenta")
    public Timestamp getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Timestamp fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    @Basic
    @Column(name = "descuento")
    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Basic
    @Column(name = "idCliente")
    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VentaEntity that = (VentaEntity) o;
        return idVenta == that.idVenta &&
                Double.compare(that.descuento, descuento) == 0 &&
                idCliente == that.idCliente &&
                Objects.equals(fechaVenta, that.fechaVenta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVenta, fechaVenta, descuento, idCliente);
    }
}