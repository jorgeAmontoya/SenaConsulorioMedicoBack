package sena.centromedico.controlador;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sena.centromedico.excepcion.RecursoNoEncontradoExcepcion;
import sena.centromedico.modelo.entidad.Medico;
import sena.centromedico.modelo.servicios.MedicoServicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController                              // se utiliza para marcar una clase como un controlador en una aplicación Spring MVC
@RequestMapping("centromedico-app")          //permite definir la URL de la solicitud, el método HTTP
@CrossOrigin(value="http://localhost:4200")  //  se utiliza para habilitar el soporte de CORS en tu aplicación
public class MedicoControlador {

    private static final Logger logger = LoggerFactory.getLogger(MedicoControlador.class);
    @Autowired
    private MedicoServicio medicoServicio;
    @GetMapping("/medicos")                                   //http://localhost:8080/centromedico-app/medicos
    public List<Medico> obtenerMedicos() {
        List<Medico> medicos = this.medicoServicio.listarMedicos();
        logger.info("medicos obtenidos");
        medicos.forEach((medico -> logger.info(medico.toString())));
        return medicos;
    }
    @GetMapping("/medicos/{cedula}")
    public ResponseEntity<Medico> obtenerMedicoPorCedula(@PathVariable int cedula){
        Medico medico = this.medicoServicio.buscarMedicoPorCedula(cedula);
        if (medico != null){
            return ResponseEntity.ok(medico);
        }else {
            throw new RecursoNoEncontradoExcepcion("No se encontro el Id: " + cedula);
        }
    }
//    @PostMapping("/medicos")
//    public Medico agregarMedico (@RequestBody Medico medico) {
//        logger.info("producto a agregar: " + medico);
//        return this.medicoServicio.agregarMedico(medico);
//    }

    @PostMapping("/medicos")
    public ResponseEntity<?> agregarMedico (@Valid @RequestBody Medico medico, BindingResult result) {
        Medico medicoNew = null;
        Map<String, Object> response = new HashMap<>();
        if(result.hasErrors()){

            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "el campo ' " + err.getField() + " ' " +err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity< Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        try {
            logger.info("producto a agregar: " + medico);
            medicoNew = medicoServicio.agregarMedico(medico);
        }catch (DataAccessException e){
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El medico ha sido creado con éxito");
        response.put("medico", medicoNew);

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
    @DeleteMapping("/medicos/{cedula}")
    public ResponseEntity<Map<String,Boolean>> eliminarMedico(@PathVariable int cedula){
        Medico medico = medicoServicio.buscarMedicoPorCedula(cedula);
        if(medico == null){
            throw new RecursoNoEncontradoExcepcion("No se encontro el id : " + cedula);
        }
        this.medicoServicio.eliminarMedicoPorId(medico.getCedula());
        Map<String,Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
