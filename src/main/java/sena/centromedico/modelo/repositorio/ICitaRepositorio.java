package sena.centromedico.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sena.centromedico.modelo.entidad.Cita;
public interface ICitaRepositorio extends JpaRepository<Cita,Integer> {
}
