package sena.centromedico.modelo.servicios;

import sena.centromedico.modelo.entidad.Medicamento;

import java.util.List;
public interface IMedicamentoServicio {
    //Agregar Medicamento
    public Medicamento agregarMedicamento(Medicamento medicamento);
    //Consultar Medicamentos por referencia
    public Medicamento buscarMedicamentoPorReferencia(Integer referenciaMedicamento);
    //Consultar Medicamento
    public List<Medicamento> listarMedicamentos();
    //Actuaizar Medicamento
    // eliminar Medicamento
    public void eliminarMedicamentoPorReferencia(Integer referenciaMedicamento);
}
