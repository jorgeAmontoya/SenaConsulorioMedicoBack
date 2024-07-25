package sena.centromedico.modelo.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sena.centromedico.modelo.entidad.Medico;
import sena.centromedico.modelo.repositorio.IMedicoRepositorio;

import java.util.List;
@Service
public class MedicoServicio implements IMedicoServicio{
    @Autowired
    private IMedicoRepositorio iMedicoRepositorio;
    @Override
    public Medico agregarMedico(Medico medico) {
        return this.iMedicoRepositorio.save(medico);
    }
    @Override
    public Medico buscarMedicoPorCedula(Integer cedulaMedico) {
        return this.iMedicoRepositorio.findById(cedulaMedico).orElse(null);
    }
    @Override
    public List<Medico> listarMedicos() {
        return  this.iMedicoRepositorio.findAll();
    }
    @Override
    public void eliminarMedicoPorId(Integer idMedico) {
        this.iMedicoRepositorio.deleteById(idMedico);
    }
}