package Modelo;

import Auxiliar.Desenho;
import java.util.Random;

public class ZigueZague extends Personagem{
    
    public ZigueZague(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bMortal = true;
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
    
    public void autoDesenho(){
        Random rand = new Random();
        int iDirecao = rand.nextInt(5);
        
        if(iDirecao == 1)
            this.moveRight();
        else if(iDirecao == 2)
            this.moveDown();
        else if(iDirecao == 3)
            this.moveLeft();
        else if(iDirecao == 4)
            this.moveUp();
        
        super.autoDesenho();
    }
       
}
