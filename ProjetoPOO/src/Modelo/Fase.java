/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author lucas
 */
class Fase {
    private final ArrayList<Personagem> elementos;

    public Fase() {
        elementos = new ArrayList<>();
    }
    
    public void addElemento(Personagem elemento){
        elementos.add(elemento);
    }
    
    public void removeElemento(Personagem elemento){
        elementos.remove(elemento);
    }

    public ArrayList<Personagem> getElementos() {
        return elementos;
    }
}
