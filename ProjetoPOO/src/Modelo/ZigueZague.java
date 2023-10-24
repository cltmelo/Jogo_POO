package Modelo;

import Auxiliar.Desenho;
import java.util.Random;

public class ZigueZague extends Personagem{
    
    public ZigueZague(String sNomeImagePNG) {
        super(sNomeImagePNG);
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
