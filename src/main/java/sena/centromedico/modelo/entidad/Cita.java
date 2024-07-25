package sena.centromedico.modelo.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;
@Entity
@Table(name = "cita")
public class Cita {
    @Id
    @Column(name = "idcita")
    private int idCita;
    @Column(name = "cedulapaciente")
    private int cedulaPaciente;
    @Column(name = "cedulamedico")
    private int cedulaMedico;
    private Date fecha;
    @Column(name = "medico_cedula")
    private int cedulaMedicos;
    @Column(name = "tratamiento_idtratamiento")
    private int idTratamiento;
    @Column(name = "tratamiento_medico_cedula")
    private int cedulaMedicoTratamiento;
    @Column(name = "consultorio_numeroconsultorio")
    private int numeroConsultorio;
    @Column(name = "consultorio_medico_cedula")
    private int consultorioAsignadoAMedico;
    @Column(name = "paciente_cedula")
    private int cedulaPacientes;
    public Cita() {
    }
    public Cita(int idCita, int cedulaPaciente, int cedulaMedico, Date fecha, int cedulaMedicos, int idTratamiento, int cedulaMedicoTratamiento, int numeroConsultorio, int consultorioAsignadoAMedico, int cedulaPacientes) {
        this.idCita = idCita;
        this.cedulaPaciente = cedulaPaciente;
        this.cedulaMedico = cedulaMedico;
        this.fecha = fecha;
        this.cedulaMedicos = cedulaMedicos;
        this.idTratamiento = idTratamiento;
        this.cedulaMedicoTratamiento = cedulaMedicoTratamiento;
        this.numeroConsultorio = numeroConsultorio;
        this.consultorioAsignadoAMedico = consultorioAsignadoAMedico;
        this.cedulaPacientes = cedulaPacientes;
    }
    public int getIdCita() {
        return idCita;
    }
    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }
    public int getCedulaPaciente() {
        return cedulaPaciente;
    }
    public void setCedulaPaciente(int cedulaPaciente) {
        this.cedulaPaciente = cedulaPaciente;
    }
    public int getCedulaMedico() {
        return cedulaMedico;
    }
    public void setCedulaMedico(int cedulaMedico) {
        this.cedulaMedico = cedulaMedico;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public int getCedulaMedicos() {
        return cedulaMedicos;
    }
    public void setCedulaMedicos(int cedulaMedicos) {
        this.cedulaMedicos = cedulaMedicos;
    }
    public int getIdTratamiento() {
        return idTratamiento;
    }
    public void setIdTratamiento(int idTratamiento) {
        this.idTratamiento = idTratamiento;
    }
    public int getCedulaMedicoTratamiento() {
        return cedulaMedicoTratamiento;
    }
    public void setCedulaMedicoTratamiento(int cedulaMedicoTratamiento) {
        this.cedulaMedicoTratamiento = cedulaMedicoTratamiento;
    }
    public int getNumeroConsultorio() {
        return numeroConsultorio;
    }
    public void setNumeroConsultorio(int numeroConsultorio) {
        this.numeroConsultorio = numeroConsultorio;
    }
    public int getConsultorioAsignadoAMedico() {
        return consultorioAsignadoAMedico;
    }
    public void setConsultorioAsignadoAMedico(int consultorioAsignadoAMedico) {
        this.consultorioAsignadoAMedico = consultorioAsignadoAMedico;
    }
    public int getCedulaPacientes() {
        return cedulaPacientes;
    }
    public void setCedulaPacientes(int cedulaPacientes) {
        this.cedulaPacientes = cedulaPacientes;
    }
}
