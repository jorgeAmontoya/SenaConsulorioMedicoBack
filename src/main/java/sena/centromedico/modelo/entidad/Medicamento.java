package sena.centromedico.modelo.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "medicamento")
public class Medicamento {
    @Id
    private int referencia;
    private String nombre;
    private int cantidad;
    @Column(name = "fechavencimiento")
    private String fechaVencimiento;
    @Column(name = "empleado_cedula")
    private int empleadoCedula;
    public Medicamento() {
    }
    public Medicamento(int referencia, String nombre, int cantidad, String fechaVencimiento) {
        this.referencia = referencia;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.fechaVencimiento = fechaVencimiento;
    }
    public int getReferencia() {
        return referencia;
    }
    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public String getFechaVencimiento() {
        return fechaVencimiento;
    }
    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    public int getEmpleadoCedula() {
        return empleadoCedula;
    }
    public void setEmpleadoCedula(int empleadoCedula) {
        this.empleadoCedula = empleadoCedula;
    }
}
