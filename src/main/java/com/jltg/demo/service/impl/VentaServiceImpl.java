package com.jltg.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jltg.demo.model.Producto;
import com.jltg.demo.model.Venta;
import com.jltg.demo.repo.Cliente;
import com.jltg.demo.repo.IGenericRepo;
import com.jltg.demo.service.IVentaService;

@Service
public class VentaServiceImpl extends CRUDImpl<Venta, Integer> implements IVentaService {

	@Autowired
	private IGenericRepo<Venta, Integer> repo;

	@Override
	protected IGenericRepo<Venta, Integer> getRepo() {
		return repo;
	}

	@Transactional
	@Override
	public Venta registrarTransaccional(Venta venta) {
		venta.getDetalleVenta().forEach(det -> det.setVenta(venta));
		return repo.save(venta);
	}

	/*
	 * / Método para obtener los productos más vendidos en un rango de fechas
	 * public List<Producto>
	 * obtenerProductosMasVendidosEnIntervaloDeFechas(LocalDateTime fechaInicio,
	 * LocalDateTime fechaFin) {
	 * return repo.obtenerProductosMasVendidosEnIntervaloDeFechas(fechaInicio,
	 * fechaFin);
	 * }
	 * 
	 * // Método para obtener el cliente que más gastó en un rango de fechas
	 * public Cliente obtenerClienteQueMasGastoEnIntervaloDeFechas(LocalDateTime
	 * fechaInicio, LocalDateTime fechaFin) {
	 * return repo.obtenerClienteQueMasGastoEnIntervaloDeFechas(fechaInicio,
	 * fechaFin);
	 * }
	 */
}
