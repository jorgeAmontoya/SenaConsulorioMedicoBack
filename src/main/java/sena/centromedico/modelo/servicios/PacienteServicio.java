package sena.centromedico.modelo.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sena.centromedico.modelo.entidad.Paciente;
import sena.centromedico.modelo.repositorio.IPacienteRepositorio;

import java.util.List;
@Service
public class PacienteServicio implements IPacienteServicio{
    @Autowired
    private IPacienteRepositorio iPacienteRepositorio;
    @Override
    public Paciente agregarPaciente(Paciente paciente) {
        return this.iPacienteRepositorio.save(paciente);
    }
    @Override
    public Paciente buscarPacientePorCedula(Integer cedulaPaciente) {
        return this.iPacienteRepositorio.findById(cedulaPaciente).orElse(null);
    }
    @Override
    public List<Paciente> listarPacientes() {
        return this.iPacienteRepositorio.findAll();
    }
    @Override
    public void eliminarPacientePorCedula(Integer cedulaPaciente) {
        this.iPacienteRepositorio.deleteById(cedulaPaciente);
    }
}