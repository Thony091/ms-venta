package cl.cvventas.msventas.model.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VentaDTO {
      
    private int id;
    private int total;
    private double descuento;
    private String fecha;
    private List<ProductoDTO> productos;

}
