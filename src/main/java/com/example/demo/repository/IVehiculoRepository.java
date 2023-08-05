package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Vehiculo;

public interface IVehiculoRepository {
	
	public void insertarVehiculo(Vehiculo vehiculo);
	
	public Vehiculo buscarPorPlaca(String placa);
	
	public List<Vehiculo> buscarTodos();
	
	

}
