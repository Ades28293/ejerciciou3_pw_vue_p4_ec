package com.example.demo.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Vehiculo;
import com.example.demo.service.IVehiculoService;
import com.example.demo.service.to.VehiculoTO;

@RestController
@RequestMapping("/vehiculos")
@CrossOrigin
public class VehiculoControllerRestful {
	
	@Autowired
	private IVehiculoService iVehiculoService;
	
	
	@PostMapping
	public void guardar(@RequestBody Vehiculo vehiculo) { 
		
		this.iVehiculoService.guardarVehiculo(vehiculo);;
	}

	@GetMapping(path = "/{placa}")
	@ResponseStatus(HttpStatus.OK)
	public Vehiculo consultarPorPlaca(@PathVariable String placa) {
		
		return this.iVehiculoService.consultarPorPlaca(placa);
	}
	
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<VehiculoTO>> consultartTodosHATEOAS(){
		
		List<VehiculoTO>lista=this.iVehiculoService.buscarTodosHateoas();
		
		
		for (VehiculoTO v : lista) {
			
			Link mylink=linkTo(methodOn(VehiculoControllerRestful.class).consultarPorPlaca(v.getPlaca())).withSelfRel();	
			v.add(mylink);

		}
		
		return new ResponseEntity<>(lista,null,200);
		}
	


	
	
}
