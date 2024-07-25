package sena.centromedico.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sena.centromedico.excepcion.RecursoNoEncontradoExcepcion;
import sena.centromedico.modelo.entidad.Empleado;
import sena.centromedico.modelo.entidad.Medicamento;
import sena.centromedico.modelo.servicios.MedicamentoServicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController                               // se utiliza para marcar una clase como un controlador en una aplicación Spring MVC
@RequestMapping("centromedico-app")           //permite definir la URL de la solicitud, el método HTTP
@CrossOrigin(value="http://localhost:4200")  //  se utiliza para habilitar el soporte de CORS en tu aplicación
public class MedicamentoControlador {
    private static final Logger logger = LoggerFactory.getLogger(MedicamentoControlador.class);
    @Autowired
    private MedicamentoServicio medicamentoServicio;
    @GetMapping("/medicamento")      //http://localhost:8080/centromedico-app/medicos
    public List<Medicamento> obtenerMedicamentos() {
        List<Medicamento> medicamentos = this.medicamentoServicio.listarMedicamentos();
        logger.info("Medicamentos obtenidos");
        medicamentos.forEach((medicamento -> logger.info(medicamento.toString())));
        return medicamentos;
    }
    @GetMapping("/medicamento/{referenciaMedicamento}")
    public ResponseEntity<Medicamento> obtenerMedicamentoPorReferencia(@PathVariable int referenciaMedicamento){
        Medicamento medicamento = this.medicamentoServicio.buscarMedicamentoPorReferencia(referenciaMedicamento);
        if (medicamento != null){
            return ResponseEntity.ok(medicamento);
        }else {
            throw new RecursoNoEncontradoExcepcion("No se encontro el referenciaMedicamento: " + referenciaMedicamento);
        }
    }
    @PostMapping("/medicamento")
    public Medicamento agregarMedicamento (@RequestBody Medicamento medicamento) {
        logger.info("Medicamento a agregar: " + medicamento);
        return this.medicamentoServicio.agregarMedicamento(medicamento);
    }
    @DeleteMapping("/medicamento/{referenciaMedicamento}")
    public ResponseEntity<Map<String,Boolean>> eliminarEmpleado(@PathVariable int referenciaMedicamento){
        Medicamento medicamento = medicamentoServicio.buscarMedicamentoPorReferencia(referenciaMedicamento);
        if(medicamento == null){
            throw new RecursoNoEncontradoExcepcion("No se encontro el referencia : " + referenciaMedicamento);
        }
        this.medicamentoServicio.eliminarMedicamentoPorReferencia(medicamento.getReferencia());
        Map<String,Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
