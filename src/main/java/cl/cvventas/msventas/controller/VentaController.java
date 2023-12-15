package cl.cvventas.msventas.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.cvventas.msventas.model.dto.VentaDTO;
import cl.cvventas.msventas.model.entities.Venta;
import cl.cvventas.msventas.service.VentaService;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@Log4j2
public class VentaController {
  
  @Autowired
  VentaService ventaService;

  @PostMapping(path = "/create-sale")
  public String crearVenta(@RequestBody VentaDTO ventaDTO){
    log.info("Creando venta en el database");
    return ventaService.crearVenta(ventaDTO);
  }

  @GetMapping(path = "/sale/{id}")
  public Optional<Venta> findSaleById(@PathVariable int id){
    Optional<Venta> optionalVenta = ventaService.findSaleById(id);
    if(!optionalVenta.isPresent()) throw new SaleNotFoundExcpetion("No existe una venta con el id: "+ id);
    return optionalVenta;
  }

}

class SaleNotFoundExcpetion extends RuntimeException{
  public SaleNotFoundExcpetion(String message){
    super(message);
  }
}
