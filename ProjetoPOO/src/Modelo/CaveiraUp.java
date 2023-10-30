package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class CaveiraUp extends Personagem implements Serializable{
    private int iContaIntervalos;
    
    public CaveiraUp(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bTransponivel = false;
        this.iContaIntervalos = 0;
    }

    public void autoDesenho() {
        super.autoDesenho();

        this.iContaIntervalos++;
        if(this.iContaIntervalos == Consts.TIMER_DISPARO){
            this.iContaIntervalos = 0;
            FogoUp f = new FogoUp("fire_up.png");
            f.setPosicao(pPosicao.getLinha()-1,pPosicao.getColuna());
            Desenho.acessoATelaDoJogo().addPersonagem(f);
        }
    }    
}
