package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Vehiculo;
import com.example.demo.repository.IVehiculoRepository;
import com.example.demo.service.to.VehiculoTO;

@Service
public class VehiculoServiceImpl implements IVehiculoService{
	
	@Autowired
	private IVehiculoRepository iVehiculoRepository;



	@Override
	public Vehiculo consultarPorPlaca(String placa) {
		// TODO Auto-generated method stub
		return this.iVehiculoRepository.buscarPorPlaca(placa);
	}

	@Override
	public List<VehiculoTO> buscarTodosHateoas() {
		// TODO Auto-generated method stub
		List<Vehiculo> lista=this.iVehiculoRepository.buscarTodos();
		List<VehiculoTO>listaTO=lista.stream().map(vehiculo->this.convertir(vehiculo)).collect(Collectors.toList());
		
		return listaTO;
		
		
	}
	
	private VehiculoTO convertir(Vehiculo vehiculo) {
		
		VehiculoTO vehi= new VehiculoTO();
		vehi.setId(vehiculo.getId());
		vehi.setPlaca(vehiculo.getPlaca());
		vehi.setModelo(vehiculo.getModelo());
		vehi.setFabrica(vehiculo.getFabrica());
		vehi.setAnio(vehiculo.getAnio());
		
		
		
		
		return vehi;
	}

}
