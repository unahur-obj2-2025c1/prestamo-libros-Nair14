package me.gonzager.ex.Modelos;

public class DefaultStrategy extends AnalisisPrestamoStrategy {

    public Boolean puedePrestarse(Socio socio){
        return true;
    }

}