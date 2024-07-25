package sena.centromedico.modelo.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado {
    @Id
    private int cedula;
    private String nombres;
    private String apellidos;
    @Column(length = 10)
    private String telefono;
    @Column(name = "tipo_cargo")
    private String tipoCargo;
    public Empleado() {
    }
    public Empleado(int cedula, String nombres, String apellidos, String telefono, String tipoCargo) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.tipoCargo = tipoCargo;
    }
    public int getCedula() {
        return cedula;
    }
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getTipoCargo() {
        return tipoCargo;
    }
    public void setTipoCargo(String tipoCargo) {
        this.tipoCargo = tipoCargo;
    }
}
