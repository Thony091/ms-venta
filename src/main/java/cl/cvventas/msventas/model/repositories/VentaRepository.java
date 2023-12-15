package cl.cvventas.msventas.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.cvventas.msventas.model.entities.Venta;

public interface VentaRepository extends JpaRepository<Venta, Integer>{
  
}
