package me.gonzager.ex;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import me.gonzager.ex.Modelos.*;


public class AnalisisPrestamoTest {
    
    @Test
    public void socioSinDeuda(){

        Libro libro1 = new Libro("El arte de la guerra");
        Socio pedro = new Socio(LocalDate.of(1999, 12,31), LocalDate.of(2020, 1, 1));

        libro1.setAnalizadorPrestamoStrategy(new SinDeudaStrategy(new DefaultStrategy()));

        assertTrue(libro1.puedePrestarse(pedro));
    }

    @Test
    public void socioSinDeudaBuilder(){

        Libro libro = new LibroConAnalizador("El arte de la guerra").sinDeuda().build();
        Socio pedro = new Socio(LocalDate.of(2015, 12,31), LocalDate.of(2020, 1, 1));

        assertTrue(libro.puedePrestarse(pedro));
    }

    @Test
    public void socioQueNoSupereUmbral(){
        UmbralUnico.setUmbral(100.0);
        Libro libro = new LibroConAnalizador("El arte de la guerra").umbral().build();
        Socio pedro = new Socio(LocalDate.of(2015, 12,31), LocalDate.of(2020, 1, 1));
        pedro.setDeuda(50.0);
        assertTrue(libro.puedePrestarse(pedro));
    }

    
}
