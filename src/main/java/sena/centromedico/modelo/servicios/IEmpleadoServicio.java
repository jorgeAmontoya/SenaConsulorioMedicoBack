package sena.centromedico.modelo.servicios;

import sena.centromedico.modelo.entidad.Empleado;

import java.util.List;
public interface IEmpleadoServicio {
    //Agregar Empleado
    public Empleado agregarEmpleado(Empleado empleado);
    //Consultar Empleado por cedula o id
    public Empleado buscarEmpleadoPorCedula(Integer cedulaEmpleado);
    //Consultar Empleados
    public List<Empleado> listarEmpleados();
    //Actuaizar Empleado
    // eliminar Empleado
    public void eliminarEmpleadoPorCedula(Integer cedulaEmpleado);
}
