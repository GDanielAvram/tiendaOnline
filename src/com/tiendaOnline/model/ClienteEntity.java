package com.tiendaOnline.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;



@Entity
@Table(name = "cliente", schema = "tiendaonline", catalog = "")
public class ClienteEntity {
	//Datos de Usuario
    private long idCliente;
    private String nombre;
    private String apellidos;
    private String email;
    private String nombreUsuario;
    private String password;
    private String fechaNacimiento;
    private String direccionEnvio;
    
    //Datos de Pago
    private String banco;
    private String numeroTarjeta;
    private String titular;
    private String codigoSeguridad;
    private String direccionFacturacion;
    
    private Set<RolEntity> roles = new HashSet<>();
    
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idCliente")
    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }
    
    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }
    
    @Basic
    @Column(name = "apellidos")
    public String getApellidos() {
        return apellidos;
    }
    
    @Basic
    @Column(name = "fechaNacimiento")
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }
    
    @Basic
    @Column(name = "nombreUsuario")
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    
    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }
    
    @Basic
    @Column(name = "direccionEnvio")
    public String getDireccionEnvio() {
        return direccionEnvio;
    }
    
    @Basic
    @Column(name = "banco")
    public String getBanco() {
        return banco;
    }
    
    @Basic
    @Column(name = "numeroTarjeta")
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }
    
    @Basic
    @Column(name = "titular")
    public String getTitular() {
        return titular;
    }
    
    @Basic
    @Column(name = "codigoSeguridad")
    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }
    
    @Basic
    @Column(name = "direccionFacturacion")
    public String getDireccionFacturacion() {
        return direccionFacturacion;
    }
    
    @ManyToMany(fetch = FetchType.EAGER)
   	@JoinTable(name = "Cliente_Rol", 
   	joinColumns = @JoinColumn(name = "idCliente"),
   	inverseJoinColumns = @JoinColumn(name = "idRol"))
    public Set<RolEntity> getRoles() {
		return roles;
	}
	public void setRoles(Set<RolEntity> roles) {
		this.roles = roles;
	}
    
    public ClienteEntity() {
    	
    };
    
    public ClienteEntity(String nombre, String apellidos, String email, String nombreUsuario,
			String password, String fechaNacimiento, String direccionEnvio, String banco, String numeroTarjeta,
			String titular, String codigoSeguridad, String direccionFacturacion) {
		super();
	
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.fechaNacimiento = fechaNacimiento;
		this.direccionEnvio = direccionEnvio;
		
		this.banco = banco;
		this.numeroTarjeta = numeroTarjeta;
		this.titular = titular;
		this.codigoSeguridad = codigoSeguridad;
		this.direccionFacturacion = direccionFacturacion;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setDireccionEnvio(String direccionEnvio) {
		this.direccionEnvio = direccionEnvio;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public void setCodigoSeguridad(String codigoSeguridad) {
		this.codigoSeguridad = codigoSeguridad;
	}

	public void setDireccionFacturacion(String direccionFacturacion) {
		this.direccionFacturacion = direccionFacturacion;
	}
}
