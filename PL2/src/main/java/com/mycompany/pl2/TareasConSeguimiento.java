/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pl2;

import java.time.*;
public class TareasConSeguimiento extends TareasPendientes{
    
    private LocalDate fecha_limite;
    private String responsables_asig;

    public TareasConSeguimiento(LocalDate fecha_limite, String responsables_asig, String descripcion, String prioridad, String estado) {
        super(descripcion, prioridad, estado);
        this.fecha_limite = fecha_limite;
        this.responsables_asig = responsables_asig;
    }

    public String getResponsables_asig() {
        return responsables_asig;
    }

    public void setResponsables_asig(String responsables_asig) {
        this.responsables_asig = responsables_asig;
    }

    public LocalDate getFecha_limite() {
        return fecha_limite;
    }

    public void setFecha_limite(LocalDate fecha_limite) {
        this.fecha_limite = fecha_limite;
    }

    @Override
    public String toString() {
        return "TareasConSeguimiento{" + "fecha_limite=" + fecha_limite + ", responsables_asig=" + responsables_asig + '}';
    }

}
