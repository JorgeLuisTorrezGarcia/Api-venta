package com.jltg.demo.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import com.jltg.demo.model.Producto;

@NoRepositoryBean
public interface IGenericRepo<T, ID> extends JpaRepository<T, ID> {
    @Query("SELECT v.producto FROM Venta v WHERE v.fecha BETWEEN :fechaInicio AND :fechaFin GROUP BY v.producto ORDER BY COUNT(v.id) DESC")
    List<Producto> obtenerProductosMasVendidosEnIntervaloDeFechas(@Param("fechaInicio") LocalDateTime fechaInicio,
            @Param("fechaFin") LocalDateTime fechaFin);

    @Query("SELECT v.cliente FROM Venta v WHERE v.fecha BETWEEN :fechaInicio AND :fechaFin GROUP BY v.cliente ORDER BY SUM(v.importe) DESC")
    Cliente obtenerClienteQueMasGastoEnIntervaloDeFechas(@Param("fechaInicio") LocalDateTime fechaInicio,
            @Param("fechaFin") LocalDateTime fechaFin);
}
