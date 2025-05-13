package me.gonzager.ex.Modelos;

public class UmbralUnico extends AnalisisPrestamoDecorator {
    
    private static Double umbral = 0.0;

    public UmbralUnico(AnalisisPrestamoStrategy decorado) {
        super(decorado);
    }

    public static void setUmbral(Double nuevoUmbral) {
        umbral = nuevoUmbral;
    }

    public static Double getUmbral() {
        return umbral;
    }

    @Override
    public Boolean condicionEspecifica(Socio socio) {
        return socio.getDeuda() < umbral;
    }
    
}
