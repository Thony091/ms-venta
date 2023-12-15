package cl.cvventas.msventas.model.entities;

import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name ="venta")
public class Venta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    @Column( name = "id" )
    private int id;

    @Basic
    @Column( name = "total" )
    private double total;

    @Basic
    @Column( name = "descuento" )
    private double descuento;

    @Basic
    @Column( name = "fecha" )
    private String fecha;
    
    @OneToMany(mappedBy = "venta", cascade = jakarta.persistence.CascadeType.ALL)
    private List<Producto> productos;
}
