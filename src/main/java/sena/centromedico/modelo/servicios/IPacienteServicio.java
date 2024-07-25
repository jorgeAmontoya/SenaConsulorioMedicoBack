package sena.centromedico.modelo.servicios;

import sena.centromedico.modelo.entidad.Paciente;
import java.util.List;
public interface IPacienteServicio {
    //Agregar paciente
    public Paciente agregarPaciente(Paciente paciente);
    //Consultar Paciente por cedula o id
    public Paciente buscarPacientePorCedula(Integer cedulaPaciente);
    //Consultar Pacientes
    public List<Paciente> listarPacientes();
    //Actuaizar Paciente
    // eliminar Paciente
    public void eliminarPacientePorCedula(Integer cedulaPaciente);
}
