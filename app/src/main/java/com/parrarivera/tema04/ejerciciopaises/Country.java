package com.parrarivera.tema04.ejerciciopaises;

public class Country {

    private String nombre;
    private String codigo;
    private String capital;
    private String poblacion;

    public Country(String nombre, String codigo, String capital, String poblacion) {
        this.nombre = nombre;
        this.capital = capital;
        this.poblacion = poblacion;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCapital() {
        return capital;
    }

    public String getPoblacion() {
        return poblacion;
    }

    @Override
    public String toString() {
        return "Country{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", capital='" + capital + '\'' +
                ", poblacion='" + poblacion + '\'' +
                '}';
    }
}
