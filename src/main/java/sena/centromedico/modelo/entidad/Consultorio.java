package sena.centromedico.modelo.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "consultorio")
public class Consultorio {
    @Id
    @Column(name = "numeroconsultorio")
    private int numeroConsultorio;
    private String especialidad;
    @Column(name = "medico_cedula")
    private int medicoAsignado;
    public Consultorio() {
    }
    public Consultorio(int numeroConsultorio, String especialidad, int medicoAsignado) {
        this.numeroConsultorio = numeroConsultorio;
        this.especialidad = especialidad;
        this.medicoAsignado = medicoAsignado;
    }
    public int getNumeroConsultorio() {
        return numeroConsultorio;
    }
    public void setNumeroConsultorio(int numeroConsultorio) {
        this.numeroConsultorio = numeroConsultorio;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public int getMedicoAsignado() {
        return medicoAsignado;
    }
    public void setMedicoAsignado(int medicoAsignado) {
        this.medicoAsignado = medicoAsignado;
    }

}
