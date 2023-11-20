package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public abstract class Caveira extends Personagem implements Serializable{
    private int iContaIntervalos;
    
    public Caveira(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bTransponivel = false;
        this.iContaIntervalos = 0;
    }

    public abstract void autoDesenhoFogo();
    
//    public void autoDesenho() {
//        super.autoDesenho();
//
//        this.iContaIntervalos++;
//        if(this.iContaIntervalos == Consts.TIMER_DISPARO){
//            this.iContaIntervalos = 0;
//            FogoDown f = new FogoDown("fire_down.png");
//            f.setPosicao(pPosicao.getLinha()+1,pPosicao.getColuna());
//            Desenho.acessoATelaDoJogo().addPersonagem(f);
//        }
//    }

    @Override
    public void autoDesenho(){
        super.autoDesenho();
        this.iContaIntervalos++;
        if(this.iContaIntervalos == Consts.TIMER_DISPARO){
            this.iContaIntervalos = 0;
            autoDesenhoFogo();
        }
    }
}
