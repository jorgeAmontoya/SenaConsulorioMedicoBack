package sena.centromedico.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sena.centromedico.excepcion.RecursoNoEncontradoExcepcion;
import sena.centromedico.modelo.entidad.Paciente;
import sena.centromedico.modelo.servicios.PacienteServicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController                              // se utiliza para marcar una clase como un controlador en una aplicación Spring MVC
@RequestMapping("centromedico-app")          //permite definir la URL de la solicitud, el método HTTP
@CrossOrigin(value="http://localhost:4200")  //  se utiliza para habilitar el soporte de CORS en tu aplicación
public class PacienteControlador {

    private static final Logger logger = LoggerFactory.getLogger(PacienteControlador.class);
    @Autowired
    private PacienteServicio pacienteServicio;

    @GetMapping("/pacientes")                                   //http://localhost:8080/centromedico-app/medicos
    public List<Paciente> obtenerPacientes() {
        List<Paciente> pacientes = this.pacienteServicio.listarPacientes();
        logger.info("pacientes obtenidos");
        pacientes.forEach((paciente -> logger.info(paciente.toString())));
        return pacientes;
    }
    @GetMapping("/pacientes/{cedula}")
    public ResponseEntity<Paciente> obtenerPacientePorCedula(@PathVariable int cedula){
        Paciente paciente = this.pacienteServicio.buscarPacientePorCedula(cedula);
        if (paciente != null){
            return ResponseEntity.ok(paciente);
        }else {
            throw new RecursoNoEncontradoExcepcion("No se encontro el Id: " + cedula);
        }
    }
    @PostMapping("/pacientes")
    public Paciente agregarPaciente (@RequestBody Paciente paciente) {
        logger.info("Paciente a agregar: " + paciente);
        return this.pacienteServicio.agregarPaciente(paciente);
    }
    @DeleteMapping("/pacientes/{cedula}")
    public ResponseEntity<Map<String,Boolean>> eliminarPaciente(@PathVariable int cedula){
        Paciente paciente = pacienteServicio.buscarPacientePorCedula(cedula);
        if(paciente == null){
            throw new RecursoNoEncontradoExcepcion("No se encontro el id : " + cedula);
        }
        this.pacienteServicio.eliminarPacientePorCedula(paciente.getCedula());
        Map<String,Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
