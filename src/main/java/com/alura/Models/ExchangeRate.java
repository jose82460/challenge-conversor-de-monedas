package com.alura.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor


public class ExchangeRate {
    private String monedaBase;
    private String monedaDestino;
    @Getter
    private double conversion_rate;

    public double getConversion_rate() {
        return conversion_rate;
    }

    @Override
    public String toString() {
        return "Tipo de cambio " +
                "Moneda Base= " + monedaBase + '\'' +
                ",Moneda Destino= " + monedaDestino + '\'' +
                ",Tasa de conversión=" + conversion_rate;
    }

}
