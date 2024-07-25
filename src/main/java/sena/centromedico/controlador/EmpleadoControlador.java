package sena.centromedico.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sena.centromedico.excepcion.RecursoNoEncontradoExcepcion;
import sena.centromedico.modelo.entidad.Empleado;
import sena.centromedico.modelo.servicios.EmpleadoServicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController                              // se utiliza para marcar una clase como un controlador en una aplicación Spring MVC
@RequestMapping("centromedico-app")          //permite definir la URL de la solicitud, el método HTTP
@CrossOrigin(value="http://localhost:4200")  //  se utiliza para habilitar el soporte de CORS en tu aplicación
public class EmpleadoControlador {
    private static final Logger logger = LoggerFactory.getLogger(EmpleadoControlador.class);
    @Autowired
    private EmpleadoServicio empleadoServicio;
    @GetMapping("/empleados")      //http://localhost:8080/centromedico-app/medicos
    public List<Empleado> obtenerEmpleados() {
        List<Empleado> empleados = this.empleadoServicio.listarEmpleados();
        logger.info("Empleados obtenidos");
        empleados.forEach((empleado -> logger.info(empleado.toString())));
        return empleados;
    }
    @GetMapping("/empleados/{cedula}")
    public ResponseEntity<Empleado> obtenerEmpleadoPorCedula(@PathVariable int cedula){
        Empleado empleado = this.empleadoServicio.buscarEmpleadoPorCedula(cedula);
        if (empleado != null){
            return ResponseEntity.ok(empleado);
        }else {
            throw new RecursoNoEncontradoExcepcion("No se encontro el Id: " + cedula);
        }
    }
    @PostMapping("/empleados")
    public Empleado agregarEmpleado (@RequestBody Empleado empleado) {
        logger.info("producto a agregar: " + empleado);
        return this.empleadoServicio.agregarEmpleado(empleado);
    }
    @DeleteMapping("/empleados/{cedula}")
    public ResponseEntity<Map<String,Boolean>> eliminarEmpleado(@PathVariable int cedula){
        Empleado empleado = empleadoServicio.buscarEmpleadoPorCedula(cedula);
        if(empleado == null){
            throw new RecursoNoEncontradoExcepcion("No se encontro el id : " + cedula);
        }
        this.empleadoServicio.eliminarEmpleadoPorCedula(empleado.getCedula());
        Map<String,Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
