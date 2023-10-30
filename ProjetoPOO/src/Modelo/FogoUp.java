package Modelo;

import Auxiliar.Desenho;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class FogoUp extends Personagem implements Serializable{
            
    public FogoUp(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bMortal = true;
    }

    @Override
    public void autoDesenho() {
        super.autoDesenho();
        if(!this.moveUp())
            Desenho.acessoATelaDoJogo().removePersonagem(this);
    }
    
}
