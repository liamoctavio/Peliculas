package com.peliculas.peliculas_service;

import org.springframework.web.bind.annotation.*;
import com.peliculas.peliculas_service.Pelicula;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {
    
    private List<Pelicula> peliculas = new ArrayList<Pelicula>();

    public PeliculaController() {
        peliculas.add(new Pelicula(1L, "Titanic", "James Cameron", "Drama", "Un joven artista y una joven aristócrata se enamoran a bordo del primer y mítico viaje del RMS Titanic.", 1997));
        peliculas.add(new Pelicula(2L, "El Padrino", "Francis Ford Coppola", "Drama", "Don Vito Corleone, jefe de una de las cinco familias que ejercen el mando de la Cosa Nostra en Nueva York en los años 40, se dispone a pasarle el relevo a su hijo Michael.", 1972));
        peliculas.add(new Pelicula(3L, "El Señor de los Anillos: La Comunidad del Anillo", "Peter Jackson", "Fantasía", "Un joven hobbit llamado Frodo Bolsón hereda un anillo mágico y se une a la Comunidad del Anillo para destruirlo en el Monte del Destino.", 2001));
        peliculas.add(new Pelicula(4L, "La Lista de Schindler", "Steven Spielberg", "Drama", "Oskar Schindler, un empresario alemán, salva la vida de más de mil judíos", 1993));
        peliculas.add(new Pelicula(5L, "El Rey León", "Roger Allers, Rob Minkoff", "Animación", "Un joven león llamado Simba, hijo del rey Mufasa, es injustamente acusado de la muerte de su padre y se ve obligado a exiliarse.", 1994));
        
    }

    @GetMapping("/{id}")
    public Pelicula getPelicula(@PathVariable Long id) {
        return peliculas.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    @GetMapping
    public List<Pelicula> todaslasPeliculas() {
        return peliculas;
    }

}
