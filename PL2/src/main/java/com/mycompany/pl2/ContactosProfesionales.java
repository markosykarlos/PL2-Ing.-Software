/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pl2;

public class ContactosProfesionales extends ContactosPersonales{
    
    private String empresa;
    private String cargo;

    public ContactosProfesionales(String empresa, String cargo, String nombre, int telefono, String correo_electronico, int direccion_postal) {
        super(nombre, telefono, correo_electronico, direccion_postal);
        this.empresa = empresa;
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    
    public boolean validarEmpresa(String empresa) {
    return empresa != null && empresa.length() > 0;
    }

    public boolean validarCargo(String cargo) {
        return cargo != null && cargo.length() > 0;
    }

    @Override
    public String toString() {
        return "ContactosProfesionales{" + "empresa=" + empresa + ", cargo=" + cargo + '}';
    }

}
