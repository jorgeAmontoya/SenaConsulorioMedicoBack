package sena.centromedico.modelo.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tratamiento")
public class Tratamiento {
    @Id
    @Column(name = "idtratamiento")
    private int idTratamiento;
    @Column(name = "cedulapaciente")
    private int cedulaPaciente;
    private String medicamento;
    private String observaciones;
    @Column(name = "medico_cedula")
    private int idMedico;
    @Column(name = "medicamento_referencia")
    private int referenciaMedicamento;
    @Column(name = "paciente_cedula")
    private int idPaciente= cedulaPaciente;
    public Tratamiento() {
    }
    public Tratamiento(int idTratamiento, int cedulaPaciente, String medicamento, String observaciones, int idMedico, int referenciaMedicamento, int idPaciente) {
        this.idTratamiento = idTratamiento;
        this.cedulaPaciente = cedulaPaciente;
        this.medicamento = medicamento;
        this.observaciones = observaciones;
        this.idMedico = idMedico;
        this.referenciaMedicamento = referenciaMedicamento;
        this.idPaciente = idPaciente;
    }
    public int getIdTratamiento() {
        return idTratamiento;
    }
    public void setIdTratamiento(int idTratamiento) {
        this.idTratamiento = idTratamiento;
    }
    public int getCedulaPaciente() {
        return cedulaPaciente;
    }
    public void setCedulaPaciente(int cedulaPaciente) {
        this.cedulaPaciente = cedulaPaciente;
    }
    public String getMedicamento() {
        return medicamento;
    }
    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }
    public String getObservaciones() {
        return observaciones;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    public int getIdMedico() {
        return idMedico;
    }
    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }
    public int getReferenciaMedicamento() {
        return referenciaMedicamento;
    }
    public void setReferenciaMedicamento(int referenciaMedicamento) {
        this.referenciaMedicamento = referenciaMedicamento;
    }
    public int getIdPaciente() {
        return idPaciente;
    }
    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    //Metodos asociados al CRUD y otros
    //C = create   peticiones http  - POST
    //R = read                      - GEt
    //U= update - actualizar        - PUT , Patch
    //D = Delete - Eliminar         - Delete

    //Agregar tratamiento
    //Consultar tratamiento por cedula o id
    //Consultar tratamiento
    //Actuaizar tratamiento
}
