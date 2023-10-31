package Controler;

import Modelo.Personagem;
import Modelo.Hero;
import Auxiliar.Posicao;
import Modelo.PassaFase;
import java.util.ArrayList;
import javax.swing.JOptionPane;



public class ControleDeJogo {
    public void desenhaTudo(ArrayList<Personagem> e){
        for(int i = 0; i < e.size(); i++){
            e.get(i).autoDesenho();
        }
    }
    public int processaTudo(ArrayList<Personagem> umaFase){
        Hero hero = (Hero)umaFase.get(0);
        int aux = 0;
        Personagem pIesimoPersonagem;
        for(int i = 1; i < umaFase.size(); i++){
            pIesimoPersonagem = umaFase.get(i);
            
            if (pIesimoPersonagem instanceof PassaFase){
                aux++;
            }
            
            
                 
            if(hero.getPosicao().igual(pIesimoPersonagem.getPosicao()))
                if(pIesimoPersonagem.isbTransponivel())
                    /*TO-DO: verificar se o personagem eh mortal antes de retirar*/  
                    if (!pIesimoPersonagem.isbMortal()){
                        umaFase.remove(pIesimoPersonagem);
                    } else {
                        umaFase.clear();
                        Object[] options = { "Reiniciar Fase", "Sair do Jogo"};
                        if (hero.vidas != 0){
                            int escolha = JOptionPane.showOptionDialog(
                                null, 
                                "Fim de Jogo! Reinicie a Fase e tente novamente!\nVidas Restantes: " + hero.vidas ,
                                "Você Morreu!", 
                                JOptionPane.INFORMATION_MESSAGE,
                                JOptionPane.YES_NO_OPTION, 
                                null, 
                                options, 
                                options[0]);
                            if (escolha == 0){
                                hero.vidas--;
                                /*Reiniciar Fase*/
                                return 0;
                            } else {
                                System.exit(0);
                            }
                        } else {
                            JOptionPane.showMessageDialog(
                                null, 
                                "Fim de Jogo! Suas vidas acabaram e o mal sucumbiu neste mundo!",
                                "GAME OVER", 
                                JOptionPane.INFORMATION_MESSAGE);
                            System.exit(0);
                        }
          
                
                        
                    
        }
        
    }
        
    if (aux == 0){
        return 1;
    }
    
    return 2;
}

    /*Retorna true se a posicao p é válida para Hero com relacao a todos os personagens no array*/
    public boolean ehPosicaoValida(ArrayList<Personagem> umaFase, Posicao p){
        Personagem pIesimoPersonagem;
        for(int i = 1; i < umaFase.size(); i++){
            pIesimoPersonagem = umaFase.get(i);            
            if(!pIesimoPersonagem.isbTransponivel())
                if(pIesimoPersonagem.getPosicao().igual(p))
                    return false;
        }        
        return true;
    }
}
