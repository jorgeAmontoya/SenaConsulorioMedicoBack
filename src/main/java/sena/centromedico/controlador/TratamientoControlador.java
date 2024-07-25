package sena.centromedico.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sena.centromedico.excepcion.RecursoNoEncontradoExcepcion;
import sena.centromedico.modelo.entidad.Tratamiento;
import sena.centromedico.modelo.servicios.TratamientoServicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController                               // se utiliza para marcar una clase como un controlador en una aplicación Spring MVC
@RequestMapping("centromedico-app")           //permite definir la URL de la solicitud, el método HTTP
@CrossOrigin(value="http://localhost:4200")  //  se utiliza para habilitar el soporte de CORS en tu aplicación
public class TratamientoControlador {
    private static final Logger logger = LoggerFactory.getLogger(TratamientoControlador.class);
    @Autowired
    private TratamientoServicio tratamientoServicio;
    @GetMapping("/tratamientos")      //http://localhost:8080/centromedico-app/medicos
    public List<Tratamiento> obtenerTratamientos() {
        List<Tratamiento> tratamientos = this.tratamientoServicio.listarTratamientos();
        logger.info("Tratamientos obtenidos");
        tratamientos.forEach((tratamiento -> logger.info(tratamiento.toString())));
        return tratamientos;
    }
    @GetMapping("/tratamientos/{id}")
    public ResponseEntity<Tratamiento> obtenerTratamientoPorId(@PathVariable int id){
        Tratamiento tratamiento = this.tratamientoServicio.buscarTratamientoPorId(id);
        if (tratamiento != null){
            return ResponseEntity.ok(tratamiento);
        }else {
            throw new RecursoNoEncontradoExcepcion("No se encontro el Id: " + id);
        }
    }
    @PostMapping("/tratamientos")
    public Tratamiento agregarTratamiento (@RequestBody Tratamiento tratamiento) {
        tratamiento.setIdPaciente(tratamiento.getCedulaPaciente());
        logger.info("tratamiento a agregar: " + tratamiento);
        return this.tratamientoServicio.agregarTratamiento(tratamiento);
    }
    @DeleteMapping("/tratamientos/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarEmpleado(@PathVariable int id){
        Tratamiento tratamiento = tratamientoServicio.buscarTratamientoPorId(id);
        if(tratamiento == null){
            throw new RecursoNoEncontradoExcepcion("No se encontro el id : " + id);
        }
        this.tratamientoServicio.eliminarTratamientoPorId(tratamiento.getIdTratamiento());
        Map<String,Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
