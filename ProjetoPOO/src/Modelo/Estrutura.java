/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Auxiliar.Posicao;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author jean
 */
public class Estrutura extends Personagem implements Serializable{

    public Estrutura(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bTransponivel = false;
    }


    public void autoDesenho(){
        super.autoDesenho();
        }


}
