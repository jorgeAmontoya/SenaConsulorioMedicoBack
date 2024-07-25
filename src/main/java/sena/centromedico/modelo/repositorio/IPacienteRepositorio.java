package sena.centromedico.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sena.centromedico.modelo.entidad.Paciente;
public interface IPacienteRepositorio extends JpaRepository<Paciente,Integer> {
}
