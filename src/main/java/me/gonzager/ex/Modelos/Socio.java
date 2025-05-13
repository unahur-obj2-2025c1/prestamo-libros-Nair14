package me.gonzager.ex.Modelos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Socio {
    private Double deuda;
    private LocalDate fechaNacimiento;
    private LocalDate socioDesde;
    
    public Socio(LocalDate fechaNacimiento, LocalDate socioDesde) {
        this.deuda = 0.0;
        this.fechaNacimiento = fechaNacimiento;
        this.socioDesde = socioDesde;
    }

    public Double getDeuda() {
        return deuda;
    }

    public void setDeuda(Double deuda) {
        this.deuda = deuda;
    }

    public Boolean tieneDeuda() {
        return deuda > 0;
    }

    public Boolean esMayorDeEdad(){
        return ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now()) >= 18;
    }

    private Long antiguedad(){
        return ChronoUnit.MONTHS.between(socioDesde, LocalDate.now());
    }

    public Boolean antiguo(){
        return antiguedad() > 6;
    }
    
}
