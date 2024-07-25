package sena.centromedico.modelo.servicios;

import sena.centromedico.modelo.entidad.Consultorio;

import java.util.List;

public interface IConsultorioServicio {
    //Agregar Consultorio
    public Consultorio agregarConsultorio(Consultorio consultorio);
    //Consultar Consultorio por cedula o id
    public Consultorio buscarConsultorioPorId(Integer idConsultorio);
    //Consultar Consultorios
    public List<Consultorio> listarConsultorios();
    //Actuaizar Consultorio
    // eliminar Consultorio
    public void eliminarConsultorioPorId(Integer idConsultorio);
}
