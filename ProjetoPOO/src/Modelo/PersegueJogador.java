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
public class PersegueJogador extends Personagem implements Serializable{
    private Hero jogador;
    private boolean bMortal;
    private boolean bRight;

    public PersegueJogador(String sNomeImagePNG, Hero jogador) {
        super(sNomeImagePNG);
        this.bMortal = true;
        this.jogador = jogador;
        this.bTransponivel = true;
        bRight = true;
    }

    public void autoDesenho() {
        if (jogador.getPosicao().getLinha() == this.getPosicao().getLinha()) {
            // O jogador está na mesma linha vertical
            if (jogador.getPosicao().getColuna() < this.getPosicao().getColuna()) {
                // Mova o inimigo para a esquerda (em direção ao jogador)
                this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna()-1);
            } else if (jogador.getPosicao().getColuna() > this.getPosicao().getColuna()) {
                // Mova o inimigo para a direita (em direção ao jogador)
                this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna()+1);
            }
        }
                

        if(bRight)
            this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna()+1);
        else
            this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna()-1);           

        super.autoDesenho();
        bRight = !bRight;
        // Se o jogador não estiver na mesma linha, o inimigo pode se mover de outra forma.
        // Implemente o comportamento desejado nesse caso.
    }
}

