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

public class BichinhoVaiVemHorizontal extends Personagem  implements Serializable{
    private boolean bRight = true;
    public BichinhoVaiVemHorizontal(String sNomeImagePNG) {
        super(sNomeImagePNG);
//        bRight = true;
        this.bMortal = true;
        //this.bTransponivel = false;
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
    
    @Override
//    public void autoDesenho(){
//        if(bRight)
//            this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna()+1);
//        else
//            this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna()-1);           
//
//        super.autoDesenho();
//        
//        if(!validaPosicao())
//            bRight = !bRight;
//    }
    
    /*Com essa aqui, o ziguezague percorre toda a linha*/
    public void autoDesenho() {
        if (bRight) {
            if (this.getPosicao().getColuna() < (Consts.RES - 2) ) {
                // Move para a direita
                this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna() + 1);
            } else {
                // Chegou à borda direita, muda de direção
                bRight = false;
            }
        } else {
            if (this.getPosicao().getColuna() > 1) {
                // Move para a esquerda
                this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna() - 1);
            } else {
                // Chegou à borda esquerda, muda de direção
                bRight = true;
            }
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

        super.autoDesenho();
    }
    
}
