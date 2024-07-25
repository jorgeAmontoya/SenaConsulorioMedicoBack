package sena.centromedico.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sena.centromedico.excepcion.RecursoNoEncontradoExcepcion;
import sena.centromedico.modelo.entidad.Consultorio;
import sena.centromedico.modelo.servicios.ConsultorioServicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController                              // se utiliza para marcar una clase como un controlador en una aplicación Spring MVC
@RequestMapping("centromedico-app")          //permite definir la URL de la solicitud, el método HTTP
@CrossOrigin(value="http://localhost:4200")  //  se utiliza para habilitar el soporte de CORS en tu aplicación
public class ConsultorioControlador {

    private static final Logger logger = LoggerFactory.getLogger(ConsultorioControlador.class);
    @Autowired
    private ConsultorioServicio consultorioServicio;
    @GetMapping("/consultorios")      //http://localhost:8080/centromedico-app/medicos
    public List<Consultorio> obtenerConsultorios() {
        List<Consultorio> consultorios = this.consultorioServicio.listarConsultorios();
        logger.info("Consultorios obtenidos");
        consultorios.forEach((consultorio -> logger.info(consultorio.toString())));
        return consultorios;
    }
    @GetMapping("/consultorios/{id}")
    public ResponseEntity<Consultorio> obtenerEmpleadoPorCedula(@PathVariable int id){
        Consultorio consultorio = this.consultorioServicio.buscarConsultorioPorId(id);
        if (consultorio != null){
            return ResponseEntity.ok(consultorio);
        }else {
            throw new RecursoNoEncontradoExcepcion("No se encontro el Id: " + id);
        }
    }
    @PostMapping("/consultorios")
    public Consultorio agregarConsultorio (@RequestBody Consultorio consultorio) {
        logger.info("consultorio a agregar: " + consultorio);
        return this.consultorioServicio.agregarConsultorio(consultorio);
    }
    @DeleteMapping("/consultorios/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarConsultorio(@PathVariable int id){
        Consultorio consultorio = consultorioServicio.buscarConsultorioPorId(id);
        if(consultorio == null){
            throw new RecursoNoEncontradoExcepcion("No se encontro el id : " + id);
        }
        this.consultorioServicio.eliminarConsultorioPorId(consultorio.getNumeroConsultorio());
        Map<String,Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
