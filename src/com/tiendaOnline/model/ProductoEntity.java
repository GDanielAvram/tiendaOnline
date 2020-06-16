package com.tiendaOnline.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Objects;

@Entity
@Table(name = "producto", schema = "tiendaonline", catalog = "")
public class ProductoEntity {
    private long idProducto;
    private String nombreProducto;
    private Double precio;
    private long stock;
    
	@ManyToOne()
	/*@JoinTable(name = "Producto_Categoria", 
   	joinColumns = @JoinColumn(name = "idProducto"))*/
	private String categoria;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idProducto", nullable = false)
    public long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }

    @Basic
    @Column(name = "nombreProducto", nullable = true, length = 45)
    @Size(min = 4, max = 45)
    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    @Basic
    @Column(name = "Precio", nullable = true, precision = 0)
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Basic
    @Column(name = "Stock", nullable = true)
    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }
    
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoEntity that = (ProductoEntity) o;
        return idProducto == that.idProducto &&
                Double.compare(that.precio, precio) == 0 &&
                stock == that.stock &&
                Objects.equals(nombreProducto, that.nombreProducto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProducto, nombreProducto, precio, stock);
    }

	@Override
	public String toString() {
		return "ProductoEntity [idProducto=" + idProducto + ", nombreProducto=" + nombreProducto
			 + ", precio=" + precio + ", stock=" + stock + "]";
	}
    
}
