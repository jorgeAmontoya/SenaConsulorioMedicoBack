package sena.centromedico.modelo.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sena.centromedico.modelo.entidad.Empleado;
import sena.centromedico.modelo.repositorio.IEmpleadoRepositorio;

import java.util.List;

@Service
public class EmpleadoServicio implements IEmpleadoServicio{
    @Autowired
    private IEmpleadoRepositorio iEmpleadoRepositorio;
    @Override
    public Empleado agregarEmpleado(Empleado empleado) {
        return this.iEmpleadoRepositorio.save(empleado);
    }
    @Override
    public Empleado buscarEmpleadoPorCedula(Integer cedulaEmpleado) {
        return this.iEmpleadoRepositorio.findById(cedulaEmpleado).orElse(null);
    }
    @Override
    public List<Empleado> listarEmpleados() {
        return this.iEmpleadoRepositorio.findAll();
    }
    @Override
    public void eliminarEmpleadoPorCedula(Integer cedulaEmpleado) {
        this.iEmpleadoRepositorio.deleteById(cedulaEmpleado);
    }
}
