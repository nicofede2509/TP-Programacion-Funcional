import CasoPractico1.Alumno;
import CasoPractico2.Producto;
import CasoPractico3.Libro;
import CasoPractico4.Empleado;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("===================================================================================================");
        System.out.println("Caso Práctico 1:");

        List<Alumno> listaAlumnos = Arrays.asList(
                Alumno.builder()
                        .nombre("Nicolas")
                        .nota(10)
                        .curso("Desarrollo de Software")
                        .build(),
        Alumno.builder()
                .nombre("Tiago")
                .nota(5)
                .curso("Desarrollo de Software")
                .build(),
        Alumno.builder()
                .nombre("Octavio")
                .nota(5)
                .curso("Sistemas operativos")
                .build(),
        Alumno.builder()
                .nombre("Alexander")
                .nota(8)
                .curso("Análisis numérico")
                .build(),
        Alumno.builder()
                .nombre("Ignacio")
                .nota(9)
                .curso("Desarrollo de Software")
                .build()
        );
        System.out.println("Alumnos aprobados:");
        listaAlumnos.stream()
                .filter(alumno -> alumno.getNota()>=7)
                .map(alumno -> alumno.getNombre().toUpperCase())
                .forEach(System.out::println);
        System.out.println("Promedio de notas de los alumnos:\n");
        OptionalDouble promedioNotas = listaAlumnos.stream()
                .mapToDouble(Alumno::getNota)
                .average();
        promedioNotas.ifPresent(promedioCurso -> System.out.println("El promedio del curso es de: " + promedioCurso + "\n"));

        Map<String, List<Alumno>> alumnosPorCurso = listaAlumnos.stream()
                .collect(Collectors.groupingBy(Alumno::getCurso));
        System.out.println(alumnosPorCurso);

        System.out.println("Lista de los alumnos que mas nota tienen \n");
        listaAlumnos.stream()
                .sorted(Comparator.comparingDouble(Alumno::getNota).reversed())
                .limit(3)
                .forEach(System.out::println);

        System.out.println("===================================================================================================");
        System.out.println("Caso Práctico 2:\n");

        List<Producto> listaProductos = Arrays.asList(
            Producto.builder().
                    nombre("Coca-Cola")
                    .categoria("Insumos")
                    .precio(50)
                    .stock(120)
                    .build(),
            Producto.builder()
                    .nombre("Papas fritas")
                    .categoria("Insumos")
                    .precio(101)
                    .stock(123)
                    .build(),
            Producto.builder()
                    .nombre("Manzanas acarameladas")
                    .categoria("Dulce")
                    .precio(50)
                    .stock(2)
                    .build(),
            Producto.builder()
                    .nombre("Mouse")
                    .categoria("Electrónica")
                    .precio(1000)
                    .stock(358)
                    .build(),
            Producto.builder()
                    .nombre("Ibuprofeno")
                    .categoria("Medicina")
                    .precio(25)
                    .stock(20)
                    .build()
        );
        listaProductos.stream()
                .filter(producto -> producto.getPrecio() > 100)
                .sorted(Comparator.comparing(Producto::getPrecio).reversed())
                .forEach(System.out::println);
        System.out.println("\n");
        Map<String, Integer> prodPorCategoria = listaProductos.stream()
                .collect(Collectors.groupingBy(Producto::getCategoria,
                        Collectors.summingInt(Producto::getStock)));
        System.out.println(prodPorCategoria);

        System.out.println("\n");
        String productosFormateados = listaProductos.stream()
                .map(p -> p.getNombre() + ": " + p.getPrecio())
                .collect(Collectors.joining(";"));
        System.out.println(productosFormateados);

        System.out.println("\n");
        Double precioPromedio = listaProductos.stream()
                .collect(Collectors.averagingDouble(Producto::getPrecio));
        Map<String, Double> precioPromedioPorCategoria = listaProductos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.averagingDouble(Producto::getPrecio)
                ));
        System.out.println("El precio promedio entre todos los productos es de: " + precioPromedio);
        System.out.println("El promedio por categoria es de:");
        System.out.println("\t" + precioPromedioPorCategoria + "\n");

        System.out.println("===================================================================================================");
        System.out.println("Caso Práctico 3:\n");

        List<Libro> listaLibros = Arrays.asList(
                Libro.builder()
                        .titulo("El Aleph")
                        .autor("Jorge Luis Borges")
                        .paginas(150)
                        .precio(350)
                        .build(),
                Libro.builder()
                        .titulo("Cien Años de Soledad")
                        .autor("Gabriel García Márquez")
                        .paginas(450)
                        .precio(600)
                        .build(),
                Libro.builder()
                        .titulo("Don Quijote de la Mancha")
                        .autor("Miguel de Cervantes")
                        .paginas(860)
                        .precio(750)
                        .build(),
                Libro.builder()
                        .titulo("Fundación")
                        .autor("Isaac Asimov")
                        .paginas(255)
                        .precio(420)
                        .build(),
                Libro.builder()
                        .titulo("1984")
                        .autor("George Orwell")
                        .paginas(320)
                        .precio(400)
                        .build()
        );

        listaLibros.stream()
                .filter(libro -> libro.getPaginas() > 300)
                .map(Libro::getTitulo)
                .sorted()
                .forEach(System.out::println);
        System.out.println("\n");

        OptionalDouble promedioPaginas = listaLibros.stream()
                .mapToDouble(Libro::getPaginas)
                .average();
        promedioPaginas.ifPresent(promedioPag -> System.out.println("El promedio del curso es de: "
                + promedioPag + "\n"));

        System.out.println("\n");

        Map<String, Long> librosPorAutor = listaLibros.stream()
                .collect(Collectors.groupingBy(
                        Libro::getAutor,
                        Collectors.counting()
                ));
        System.out.println(librosPorAutor);

        Optional<Libro> libroMasCaro = listaLibros.stream()
                .max(Comparator.comparing(Libro::getPrecio));
        System.out.println("\nEl libro mas caro es: ");
        System.out.println(libroMasCaro + "\n");

        System.out.println("===================================================================================================");
        System.out.println("Caso Práctico 4:\n");

        List<Empleado> listaEmpleados = Arrays.asList(
                Empleado.builder()
                        .nombre("Ana Gómez")
                        .departamento("Recursos Humanos")
                        .salario(2200)
                        .edad(34)
                        .build(),
                Empleado.builder()
                        .nombre("Carlos Ruiz")
                        .departamento("Ingeniería")
                        .salario(3500)
                        .edad(45)
                        .build(),
                Empleado.builder()
                        .nombre("Lucía Fernández")
                        .departamento("Marketing")
                        .salario(1900)
                        .edad(28)
                        .build(),
                Empleado.builder()
                        .nombre("Javier Torres")
                        .departamento("Ingeniería")
                        .salario(3800)
                        .edad(51)
                        .build(),
                Empleado.builder()
                        .nombre("María López")
                        .departamento("Marketing")
                        .salario(2100)
                        .edad(30)
                        .build()
        );
        listaEmpleados.stream()
                .filter(empleado -> empleado.getSalario() > 2000)
                .sorted(Comparator.comparing(Empleado::getSalario).reversed())
                .forEach(System.out::println);
        OptionalDouble salarioPromedio = listaEmpleados.stream()
                .mapToInt(Empleado::getSalario)
                .average();
        System.out.println("El promedio de salarios es de: " + salarioPromedio + "\n");

        Map<String,Double> salarioPorDepartamento = listaEmpleados.stream()
                .collect(Collectors.groupingBy(
                        Empleado::getDepartamento,
                        Collectors.summingDouble(Empleado::getSalario)
                ));
        System.out.println(salarioPorDepartamento);
        List<String> empleadosMasJovenes = listaEmpleados.stream()
                .sorted(Comparator.comparingInt(Empleado::getEdad))
                .limit(2)
                .map(Empleado::getNombre)
                .collect(Collectors.toList());
        empleadosMasJovenes.forEach(System.out::println);
    }
}