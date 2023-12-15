package cl.cvventas.msventas.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductoDTO {
  
  private int id;
  private String name;
	private String description;
	private double price;
	private String urlImage;	
	private boolean active;

}
