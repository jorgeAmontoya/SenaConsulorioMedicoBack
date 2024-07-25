package sena.centromedico.modelo.servicios;

import sena.centromedico.modelo.entidad.Medico;

import java.util.List;
public interface IMedicoServicio {
    //Agregar medico
    public Medico agregarMedico(Medico medico);
    //Consultar medicos por cedula o id
    public Medico buscarMedicoPorCedula(Integer cedulaMedico);
    //Consultar medicos
    public List<Medico> listarMedicos();
    //Actuaizar medico
    // eliminar medico
    public void eliminarMedicoPorId(Integer idMedico);
}
