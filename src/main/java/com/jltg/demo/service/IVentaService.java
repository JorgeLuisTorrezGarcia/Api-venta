package com.jltg.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.jltg.demo.model.Producto;
import com.jltg.demo.model.Venta;
import com.jltg.demo.repo.Cliente;

public interface IVentaService extends ICRUD<Venta, Integer>{
	
	Venta registrarTransaccional(Venta venta);
	//List<Producto> obtenerProductosMasVendidosEnIntervaloDeFechas(LocalDateTime fechaInicio,
	//	LocalDateTime fechaFin);
	//Cliente obtenerClienteQueMasGastoEnIntervaloDeFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin);
}
