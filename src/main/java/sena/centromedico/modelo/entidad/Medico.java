package sena.centromedico.modelo.entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;


@Entity
@Table(name = "medico")
public class Medico {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cedula;
    @NotEmpty(message = "no puede estar vacio")
    private String nombres;
    @NotEmpty(message = "no puede estar vacio")
    private String apellidos;
    @Column(length = 10)
    @NotEmpty(message = "no puede estar vacio")
    private String telefono;
    @NotEmpty(message = "no puede estar vacio")
    @Email(message = "no es una direcion de correo valida")
    private String email;
    @NotEmpty(message = "no puede estar vacio")
    private String especialidad;
    public Medico() {
    }
    public Medico(int cedula, String nombres, String apellidos, String telefono, String email, String especialidad) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
        this.especialidad = especialidad;
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
        this.apellidos= apellidos;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
