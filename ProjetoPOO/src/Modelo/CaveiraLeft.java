package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class CaveiraLeft extends Personagem implements Serializable{
    private int iContaIntervalos;
    
    public CaveiraLeft(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bTransponivel = false;
        this.iContaIntervalos = 0;
    }

    public void autoDesenho() {
        super.autoDesenho();

        this.iContaIntervalos++;
        if(this.iContaIntervalos == Consts.TIMER_DISPARO){
            this.iContaIntervalos = 0;
            FogoLeft f = new FogoLeft("fire_left.png");
            f.setPosicao(pPosicao.getLinha(),pPosicao.getColuna()-1);
            Desenho.acessoATelaDoJogo().addPersonagem(f);
        }
    }    
}
