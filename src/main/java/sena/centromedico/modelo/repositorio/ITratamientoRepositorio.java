package sena.centromedico.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sena.centromedico.modelo.entidad.Tratamiento;
public interface ITratamientoRepositorio extends JpaRepository<Tratamiento,Integer> {
}
