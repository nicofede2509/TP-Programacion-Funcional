package CasoPractico4;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class Empleado {
    private String nombre;
    private String departamento;
    private int salario;
    private int edad;
}
