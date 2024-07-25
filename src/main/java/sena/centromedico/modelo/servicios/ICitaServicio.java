package sena.centromedico.modelo.servicios;

import sena.centromedico.modelo.entidad.Cita;

import java.util.List;

public interface ICitaServicio {

    //Agregar Cita
    public Cita agregarCita(Cita cita);
    //Consultar Cita por cedula o id
    public Cita buscarCitaPorId(Integer idCita);
    //Consultar Citas
    public List<Cita> listarCitas();
    //Actuaizar Empleado
    // eliminar Empleado
    public void eliminarCitaPorId(Integer idCita);
}
