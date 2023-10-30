package Modelo;

import Auxiliar.Desenho;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class FogoLeft extends Personagem implements Serializable{
            
    public FogoLeft(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bMortal = true;
    }

    @Override
    public void autoDesenho() {
        super.autoDesenho();
        if(!this.moveLeft())
            Desenho.acessoATelaDoJogo().removePersonagem(this);
    }
    
}
