package sena.centromedico.modelo.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sena.centromedico.modelo.entidad.Cita;
import sena.centromedico.modelo.repositorio.ICitaRepositorio;

import java.util.List;
@Service
public class CitaServicio implements ICitaServicio{
    @Autowired
    private ICitaRepositorio iCitaRepositorio;
    @Override
    public Cita agregarCita(Cita cita) {
        return this.iCitaRepositorio.save(cita);
    }
    @Override
    public Cita buscarCitaPorId(Integer idCita) {
        return this.iCitaRepositorio.findById(idCita).orElse(null);
    }
    @Override
    public List<Cita> listarCitas() {
        return this.iCitaRepositorio.findAll();
    }
    @Override
    public void eliminarCitaPorId(Integer idCita) {
        this.iCitaRepositorio.deleteById(idCita);
    }
}
