package sena.centromedico.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sena.centromedico.modelo.entidad.Medicamento;
public interface IMedicamentoRepositorio extends JpaRepository<Medicamento,Integer> {
}
