package sena.centromedico.modelo.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sena.centromedico.modelo.entidad.Consultorio;
import sena.centromedico.modelo.repositorio.IConsultorioRepositorio;

import java.util.List;
@Service
public class ConsultorioServicio implements IConsultorioServicio {
    @Autowired
    private IConsultorioRepositorio iConsultorioRepositorio;
    @Override
    public Consultorio agregarConsultorio(Consultorio consultorio) {
        return this.iConsultorioRepositorio.save(consultorio);
    }
    @Override
    public Consultorio buscarConsultorioPorId(Integer idConsultorio) {
        return this.iConsultorioRepositorio.findById(idConsultorio).orElse(null);
    }
    @Override
    public List<Consultorio> listarConsultorios() {
        return this.iConsultorioRepositorio.findAll();
    }
    @Override
    public void eliminarConsultorioPorId(Integer idConsultorio) {
        this.iConsultorioRepositorio.deleteById(idConsultorio);
    }
}
