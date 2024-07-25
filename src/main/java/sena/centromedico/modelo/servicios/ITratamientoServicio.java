package sena.centromedico.modelo.servicios;

import sena.centromedico.modelo.entidad.Tratamiento;

import java.util.List;
public interface ITratamientoServicio {
    //Agregar Tratamiento
    public Tratamiento agregarTratamiento(Tratamiento tratamiento);
    //Consultar Tratamiento por cedula o id
    public Tratamiento buscarTratamientoPorId(Integer idTratamiento);
    //Consultar Tratamientos
    public List<Tratamiento> listarTratamientos();
    //Actuaizar Tratamiento
    // eliminar Tratamiento
    public void eliminarTratamientoPorId(Integer idTratamiento);
}
