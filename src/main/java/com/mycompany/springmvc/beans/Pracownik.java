/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvc.beans;

public class Pracownik {
    private int id;
    private String nazwisko;
    private float pensja;
    private String firma;

    public Pracownik() {
    }

    
    public String getFirma() {
        return firma;
    }

    public int getId() {
        return id;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public float getPensja() {
        return pensja;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setPensja(float pensja) {
        this.pensja = pensja;
    }
    
    
}
