package com.jltg.demo.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jltg.demo.exception.ModeloNotFoundException;
import com.jltg.demo.model.Producto;
import com.jltg.demo.model.Venta;
import com.jltg.demo.repo.Cliente;
import com.jltg.demo.service.IVentaService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/ventas")
public class VentaController {

	@Autowired
	private IVentaService service;
	
	@GetMapping
	public ResponseEntity<List<Venta>> listar(){
		List<Venta> lista = service.listar();
		return new ResponseEntity<List<Venta>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public EntityModel<Venta> listarPorId(@PathVariable("id") Integer id) throws Exception {
		Venta venta = service.listarPorId(id);
		if (venta == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: ".concat(id.toString()));
		}
		EntityModel<Venta> recurso = EntityModel.of(venta);
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).listarPorId(id));
		recurso.add(link.withRel("venta-recurso"));
		return recurso;
	}
	
	@PostMapping
	public ResponseEntity<Venta> registrar(@Valid @RequestBody Venta venta){
		Venta ven = service.registrarTransaccional(venta);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ven.getIdVenta()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Venta> modificar(@Valid @RequestBody Venta venta){
		Venta ven = service.modificar(venta);
		return new ResponseEntity<Venta>(ven, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id){
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	/*// Endpoint para obtener los productos más vendidos en un rango de fechas
	@GetMapping("/productos-mas-vendidos")
	public ResponseEntity<List<Producto>> obtenerProductosMasVendidosEnIntervaloDeFechas(
			@RequestParam LocalDateTime fechaInicio, @RequestParam LocalDateTime fechaFin) {
		List<Producto> productosMasVendidos = service.obtenerProductosMasVendidosEnIntervaloDeFechas(fechaInicio,
				fechaFin);
		return new ResponseEntity<>(productosMasVendidos, HttpStatus.OK);
	}

	// Endpoint para obtener el cliente que más gastó en un rango de fechas
	@GetMapping("/cliente-mas-gastador")
	public ResponseEntity<Cliente> obtenerClienteQueMasGastoEnIntervaloDeFechas(@RequestParam LocalDateTime fechaInicio,
			@RequestParam LocalDateTime fechaFin) {
		Cliente clienteMasGastador = service.obtenerClienteQueMasGastoEnIntervaloDeFechas(fechaInicio, fechaFin);
		return new ResponseEntity<>(clienteMasGastador, HttpStatus.OK);
	}*/
}
