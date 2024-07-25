package sena.centromedico.modelo.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sena.centromedico.modelo.entidad.Medicamento;
import sena.centromedico.modelo.repositorio.IMedicamentoRepositorio;

import java.util.List;

@Service
public class MedicamentoServicio implements IMedicamentoServicio{
    @Autowired
    private IMedicamentoRepositorio iMedicamentoRepositorio;
    @Override
    public Medicamento agregarMedicamento(Medicamento medicamento) {
        return this.iMedicamentoRepositorio.save(medicamento);
    }
    @Override
    public Medicamento buscarMedicamentoPorReferencia(Integer referenciaMedicamento) {
        return this.iMedicamentoRepositorio.findById(referenciaMedicamento).orElse(null);
    }
    @Override
    public List<Medicamento> listarMedicamentos() {
        return  this.iMedicamentoRepositorio.findAll();
    }
    @Override
    public void eliminarMedicamentoPorReferencia(Integer referenciaMedicamento) {
        this.iMedicamentoRepositorio.deleteById(referenciaMedicamento);
    }
}
