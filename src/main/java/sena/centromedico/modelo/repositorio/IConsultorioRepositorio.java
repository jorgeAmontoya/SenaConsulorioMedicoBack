package sena.centromedico.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sena.centromedico.modelo.entidad.Consultorio;
public interface IConsultorioRepositorio extends JpaRepository<Consultorio,Integer> {
}
