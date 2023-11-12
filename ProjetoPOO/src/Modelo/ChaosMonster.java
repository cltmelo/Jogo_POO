package Modelo;

import Auxiliar.Desenho;
import java.util.Random;

public class ChaosMonster extends Personagem{
    
    public ChaosMonster(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bMortal = true;
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
