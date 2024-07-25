package sena.centromedico.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sena.centromedico.excepcion.RecursoNoEncontradoExcepcion;
import sena.centromedico.modelo.entidad.Cita;
import sena.centromedico.modelo.servicios.CitaServicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController                               // se utiliza para marcar una clase como un controlador en una aplicación Spring MVC
@RequestMapping("centromedico-app")          //permite definir la URL de la solicitud, el método HTTP
@CrossOrigin(value="http://localhost:4200")  //  se utiliza para habilitar el soporte de CORS en tu aplicación
public class CitaControlador {
    private static final Logger logger = LoggerFactory.getLogger(CitaControlador.class);
    @Autowired
    private CitaServicio citaServicio;
    @GetMapping("/cita")      //http://localhost:8080/centromedico-app/medicos
    public List<Cita> obtenerCitas() {
        List<Cita> citas = this.citaServicio.listarCitas();
        logger.info("citas obtenidas");
        citas.forEach((cita -> logger.info(cita.toString())));
        return citas;
    }
    @GetMapping("/cita/{id}")
    public ResponseEntity<Cita> obtenerCitaPorId(@PathVariable int id){
        Cita cita = this.citaServicio.buscarCitaPorId(id);
        if (cita != null){
            return ResponseEntity.ok(cita);
        }else {
            throw new RecursoNoEncontradoExcepcion("No se encontro el Id: " + id);
        }
    }
    @PostMapping("/cita")
    public Cita agregarCita (@RequestBody Cita cita) {
        cita.setCedulaMedicos(cita.getCedulaMedico());
        cita.setCedulaPacientes(cita.getCedulaPaciente());
        cita.setCedulaMedicoTratamiento(cita.getCedulaMedico());
        cita.setConsultorioAsignadoAMedico(cita.getCedulaMedico());
        logger.info("Cita a agregar: " + cita);
        return this.citaServicio.agregarCita(cita);
    }

    @DeleteMapping("/cita/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarCita(@PathVariable int id){
        Cita cita = citaServicio.buscarCitaPorId(id);
        if(cita == null){
            throw new RecursoNoEncontradoExcepcion("No se encontro el id : " + id);
        }
        this.citaServicio.eliminarCitaPorId(cita.getIdCita());
        Map<String,Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
