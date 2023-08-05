package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Vehiculo;
import com.example.demo.service.to.VehiculoTO;

public interface IVehiculoService {

public void guardarVehiculo(Vehiculo vehiculo);
	
	public Vehiculo consultarPorPlaca(String placa);
	
	public List<VehiculoTO> buscarTodosHateoas();
}
