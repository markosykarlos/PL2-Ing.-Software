/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pl2;

public class TareasPendientes {
    
    private String descripcion;
    private String prioridad;
    private String estado;

    public TareasPendientes(String descripcion, String prioridad, String estado) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public boolean validarDescripcion(String descripcion) {
    return descripcion != null && descripcion.length() > 0;
    }

    public boolean validarPrioridad(String prioridad) {
        return prioridad != null && prioridad.length() > 0;
    }

    public boolean validarEstado(String estado) {
        return estado != null && estado.length() > 0;
    }
    
    public int compararPorPrioridad(TareasPendientes otra) {
    int p1 = obtenerValorPrioridad(this.prioridad);
    int p2 = obtenerValorPrioridad(otra.prioridad);

    return p2 - p1;
}

private int obtenerValorPrioridad(String prioridad) {
    if (prioridad.equalsIgnoreCase("alta")) return 3;
    if (prioridad.equalsIgnoreCase("media")) return 2;
    if (prioridad.equalsIgnoreCase("baja")) return 1;
    return 0;
}

    @Override
    public String toString() {
        return "TareasPendientes{" + "descripcion=" + descripcion + ", prioridad=" + prioridad + ", estado=" + estado + '}';
    }

}
