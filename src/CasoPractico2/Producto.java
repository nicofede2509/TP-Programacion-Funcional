package CasoPractico2;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class Producto {
    private String nombre;
    private String categoria;
    private int precio;
    private int stock;
}
