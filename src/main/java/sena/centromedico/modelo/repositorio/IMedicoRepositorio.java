package sena.centromedico.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sena.centromedico.modelo.entidad.Medico;
public interface IMedicoRepositorio extends JpaRepository<Medico,Integer> {
}
