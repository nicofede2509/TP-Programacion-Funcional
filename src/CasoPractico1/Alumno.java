package CasoPractico1;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class Alumno {
    private String nombre;
    private String curso;
    private int nota;
}
