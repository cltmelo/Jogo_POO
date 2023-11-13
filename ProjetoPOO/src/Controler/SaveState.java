/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import Modelo.Personagem;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author jean
 */
class SaveState implements Serializable {
    private int index;
    private ArrayList<Personagem> faseAtual;

    public SaveState(int index, ArrayList<Personagem> faseAtual) {
        this.index = index;
        this.faseAtual = faseAtual;
    }

    public int getIndex() {
        return index;
    }

    public ArrayList<Personagem> getFaseAtual() {
        return faseAtual;
    }
}




