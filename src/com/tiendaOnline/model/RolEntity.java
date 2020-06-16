package com.tiendaOnline.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

@Entity
@Table(name = "Rol")
public class RolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRol")
    private int idRol;

    @Column(name = "nombreRol")
    private String nombreRol;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Cliente_Rol", joinColumns = @JoinColumn(name = "idRol"), inverseJoinColumns = @JoinColumn(name = "idCliente"))
    private Set<ClienteEntity> clientes;

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public Set<ClienteEntity> getClientes() {
        return clientes;
    }

    public void setClientes(Set<ClienteEntity> cliente) {
        clientes = cliente;
    }


}