/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pl2;
import java.time.*;
public class Citas {
    
    private LocalDate fecha;
    private LocalTime hora;
    private String lugar;
    private String personas_involucradas;

    public Citas(LocalDate fecha, LocalTime hora, String lugar, String personas_involucradas) {
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
        this.personas_involucradas = personas_involucradas;
    }

    public String getPersonas_involucradas() {
        return personas_involucradas;
    }

    public void setPersonas_involucradas(String personas_involucradas) {
        this.personas_involucradas = personas_involucradas;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    public boolean validarFecha(LocalDate fecha) {
        return fecha != null && !fecha.isBefore(LocalDate.now());
    }
    
    public boolean validarHora(LocalTime hora) {
    return hora != null;
    }

    public boolean validarLugar(String lugar) {
        return lugar != null && lugar.length() > 0;
    }

    public boolean validarPersonasInvolucradas(String personas) {
        return personas != null && personas.length() > 0;
    }

    @Override
    public String toString() {
        return "Citas{" + "fecha=" + fecha + ", hora=" + hora + ", lugar=" + lugar + ", personas_involucradas=" + personas_involucradas + '}';
    }

}
