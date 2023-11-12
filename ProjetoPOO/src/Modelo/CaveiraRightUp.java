/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import java.io.Serializable;

/**
 *
 * @author lucas
 */
public class CaveiraRightUp extends Personagem implements Serializable{
    private int iContaIntervalos;
    
    public CaveiraRightUp(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bTransponivel = false;
        this.iContaIntervalos = 0;
    }

    public void autoDesenho() {
        super.autoDesenho();

        this.iContaIntervalos++;
        if(this.iContaIntervalos == Consts.TIMER_DISPARO){
            this.iContaIntervalos = 0;
            FogoRight fx = new FogoRight("fire_right.png");
            FogoUp fy = new FogoUp("fire_up.png");
            fx.setPosicao(pPosicao.getLinha(),pPosicao.getColuna()+1);
            fy.setPosicao(pPosicao.getLinha()-1,pPosicao.getColuna());
            Desenho.acessoATelaDoJogo().addPersonagem(fx);
            Desenho.acessoATelaDoJogo().addPersonagem(fy);
        }
    }
}
