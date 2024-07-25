package sena.centromedico.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sena.centromedico.modelo.entidad.Empleado;
public interface IEmpleadoRepositorio extends JpaRepository<Empleado,Integer> {
}
