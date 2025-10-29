package CasoPractico3;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class Libro {
    private String titulo;
    private String autor;
    private int paginas;
    private int precio;
}
