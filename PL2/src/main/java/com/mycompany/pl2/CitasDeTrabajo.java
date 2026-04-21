/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pl2;

import java.time.LocalDate;
import java.time.LocalTime;

public class CitasDeTrabajo extends Citas{
    
    private String agenda_temas;
    private int duracion_est;

    public CitasDeTrabajo(String agenda_temas, int duracion_est, LocalDate fecha, LocalTime hora, String lugar, String personas_involucradas) {
        super(fecha, hora, lugar, personas_involucradas);
        this.agenda_temas = agenda_temas;
        this.duracion_est = duracion_est;
    }

    public int getDuracion_est() {
        return duracion_est;
    }

    public void setDuracion_est(int duracion_est) {
        this.duracion_est = duracion_est;
    }

    public String getAgenda_temas() {
        return agenda_temas;
    }

    public void setAgenda_temas(String agenda_temas) {
        this.agenda_temas = agenda_temas;
    }
    
    public boolean validarAgendaTemas(String agenda) {
    return agenda != null && agenda.length() > 0;
    }

    public boolean validarDuracionEst(int duracion) {
        return duracion > 0;
    }
    
    public boolean seSolapa(CitasDeTrabajo otraCita) {
    if (otraCita == null) return false;

    if (!this.getFecha().equals(otraCita.getFecha())) {
        return false;
    }

    LocalTime inicio1 = this.getHora();
    LocalTime fin1 = this.getHora().plusMinutes(this.getDuracion_est());

    LocalTime inicio2 = otraCita.getHora();
    LocalTime fin2 = otraCita.getHora().plusMinutes(otraCita.getDuracion_est());

    return inicio1.isBefore(fin2) && inicio2.isBefore(fin1);
}
    
    @Override
    public String toString() {
        return "CitasDeTrabajo{" + "agenda_temas=" + agenda_temas + ", duracion_est=" + duracion_est + '}';
    }

}
