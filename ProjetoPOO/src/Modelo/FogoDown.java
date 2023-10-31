package Modelo;

import Auxiliar.Desenho;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class FogoDown extends Personagem implements Serializable{
            
    public FogoDown(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bMortal = true;
    }

    @Override
    public void autoDesenho() {
        super.autoDesenho();
        if(!this.moveDown())
            Desenho.acessoATelaDoJogo().removePersonagem(this);
    }
    
}
