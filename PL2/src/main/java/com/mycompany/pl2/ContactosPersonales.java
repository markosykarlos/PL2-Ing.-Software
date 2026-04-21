/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pl2;

public class ContactosPersonales {
    
    private String nombre;
    private int telefono;
    private String correo_electronico;
    private int direccion_postal;

    public ContactosPersonales(String nombre, int telefono, String correo_electronico, int direccion_postal) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo_electronico = correo_electronico;
        this.direccion_postal = direccion_postal;
    }

    public int getDireccion_postal() {
        return direccion_postal;
    }

    public void setDireccion_postal(int direccion_postal) {
        this.direccion_postal = direccion_postal;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public boolean validarNombre(String nombre) {
    return nombre != null && nombre.length() > 0;
    }

    public boolean validarTelefono(int telefono) {
        return telefono > 0;
    }

    public boolean validarCorreo(String correo) {
        return correo != null && correo.length() > 0 && correo.contains("@");
    }

    public boolean validarDireccionPostal(int direccion) {
        return direccion > 0;
    }

    @Override
    public String toString() {
        return "ContactosPersonales{" + "nombre=" + nombre + ", telefono=" + telefono + ", correo_electronico=" + correo_electronico + ", direccion_postal=" + direccion_postal + '}';
    }

}
