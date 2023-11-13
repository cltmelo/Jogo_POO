/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author jean
 */
public class PersegueHorizontal extends Personagem implements Serializable{
    private Hero jogador;
    private boolean bRight;

    public PersegueHorizontal(String sNomeImagePNG, Hero jogador) {
        super(sNomeImagePNG);
        this.bMortal = true;
        this.jogador = jogador;
    }

    
    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
    
    
    public boolean setPosicao(int linha, int coluna){
        if(this.pPosicao.setPosicao(linha, coluna)){
            if (!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao())) {
                this.voltaAUltimaPosicao();
            }
            return true;
        }
        return false;       
    }

    /*TO-DO: este metodo pode ser interessante a todos os personagens que se movem*/
    private boolean validaPosicao(){
        if (!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao())) {
            this.voltaAUltimaPosicao();
            return false;
        }
        return true;       
    }
    
    public boolean moveUp() {
        if(super.moveUp())
            return validaPosicao();
        return false;
    }

    public boolean moveDown() {
        if(super.moveDown())
            return validaPosicao();
        return false;
    }

    public boolean moveRight() {
        if(super.moveRight())
            return validaPosicao();
        return false;
    }

    public boolean moveLeft() {
        if(super.moveLeft())
            return validaPosicao();
        return false;
    }
    
    public void autoDesenho() {
        if (jogador.getPosicao().getLinha() == this.getPosicao().getLinha()) {
            // O jogador está na mesma linha vertical
            if (jogador.getPosicao().getColuna() < this.getPosicao().getColuna()) {
                // Mova o inimigo para a esquerda (em direção ao jogador)
                this.moveLeft();
            } else if (jogador.getPosicao().getColuna() > this.getPosicao().getColuna()) {
                // Mova o inimigo para a direita (em direção ao jogador)
                this.moveRight();
            }
        } else {
                
            if (pPosicao.getColuna() == Auxiliar.Consts.RES - 2) {
                bRight = false; // Se chegou ao limite direito, mude a direção para a esquerda
            } else if (pPosicao.getColuna() == 1) {
                bRight = true; // Se chegou ao limite esquerdo, mude a direção para a direita
            }

            if (bRight) {
                if(!this.moveRight()){
                    bRight = false;
                }
            } else {
                if(!this.moveLeft()){
                    bRight = true;
                }
            }
        }
            super.autoDesenho();
        // Se o jogador não estiver na mesma linha, o inimigo pode se mover de outra forma.
        // Implemente o comportamento desejado nesse caso.
    }
    

}

