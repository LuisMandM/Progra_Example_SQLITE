package com.ikasgela;

public class Corredor {

    private long id;
    private String nombre;
    private int dorsal;
    private double mejorMarca;

    public Corredor(long id, String nombre, int dorsal, double mejorMarca) {
        this.id = id;
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.mejorMarca = mejorMarca;
    }

    @Override
    public String toString() {
        return "Corredor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", dorsal=" + dorsal +
                ", mejorMarca=" + mejorMarca +
                '}';
    }
}
