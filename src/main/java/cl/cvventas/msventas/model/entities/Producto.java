package cl.cvventas.msventas.model.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name ="producto")
public class Producto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)    
  @Column( name = "id" )
  private int id;
  
  @Basic
  @Column( name = "name" )
  private String name;
  
  @Basic
  @Column( name = "description" )
	private String description;

  @Basic
  @Column( name = "price" )
	private double price;

  @Basic
  @Column( name = "url_image" )
	private String urlImage;	

  @Basic
  @Column( name = "active" )
	private boolean active;

  @ManyToOne
  @JoinColumn(name = "venta_id")
  private Venta venta;

}
