package cl.cvventas.msventas.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.cvventas.msventas.model.dto.ProductoDTO;
import cl.cvventas.msventas.model.dto.VentaDTO;
import cl.cvventas.msventas.model.entities.Producto;
import cl.cvventas.msventas.model.entities.Venta;
import cl.cvventas.msventas.model.repositories.VentaRepository;

@Service
@Transactional
public class VentaService {
  
  @Autowired
  VentaRepository ventaRepository;

    private Producto translateProductoDto(ProductoDTO productoDTO) {
        Producto producto = new Producto();
        producto.setName(productoDTO.getName());
        // ... establecer otros atributos
        return producto;
    }
    
    private List<Producto> translateProductosDto(List<ProductoDTO> productoDTOs) {
        return productoDTOs.stream()
            .map(this::translateProductoDto)
            .collect(Collectors.toList());
    }

    
    public Venta translateVentaDto(VentaDTO ventaDTO){
        Venta venta = new Venta();
        venta.setTotal(ventaDTO.getTotal());
        venta.setDescuento(ventaDTO.getDescuento());
        venta.setFecha(ventaDTO.getFecha());
        return venta;
    }

    public String crearVenta(VentaDTO ventaDTO){
        Venta venta = translateVentaDto(ventaDTO);
        // Asociar productos con la venta
        List<Producto> productos = translateProductosDto(ventaDTO.getProductos());
        productos.forEach(producto -> producto.setVenta(venta));
        venta.setProductos(productos);
        ventaRepository.save(venta);
        return "Venta creada";
    }
    
    public Optional<Venta> findSaleById(int id){
        return ventaRepository.findById(id);
    }
}
