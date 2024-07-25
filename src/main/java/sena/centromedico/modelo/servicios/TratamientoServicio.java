package sena.centromedico.modelo.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sena.centromedico.modelo.entidad.Tratamiento;
import sena.centromedico.modelo.repositorio.ITratamientoRepositorio;

import java.util.List;
@Service
public class TratamientoServicio implements ITratamientoServicio{
    @Autowired
    private ITratamientoRepositorio iTratamientoRepositorio;
    @Override
    public Tratamiento agregarTratamiento(Tratamiento tratamiento) {
        return this.iTratamientoRepositorio.save(tratamiento);
    }
    @Override
    public Tratamiento buscarTratamientoPorId(Integer id) {
        return this.iTratamientoRepositorio.findById(id).orElse(null);
    }
    @Override
    public List<Tratamiento> listarTratamientos() {
        return this.iTratamientoRepositorio.findAll();
    }
    @Override
    public void eliminarTratamientoPorId(Integer id) {
        this.iTratamientoRepositorio.deleteById(id);
    }
}
