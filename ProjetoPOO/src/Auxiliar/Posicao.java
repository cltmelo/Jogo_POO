package Auxiliar;

import java.io.Serializable;

public class Posicao  implements Serializable{
    private int	linha;
    private int coluna;
    
    private int linhaAnterior;
    private int colunaAnterior;

    public Posicao(int linha, int coluna){
        this.setPosicao(linha,coluna);
    }

    public boolean setPosicao(int linha, int coluna){       
        if(linha < 0 || linha >= Auxiliar.Consts.RES)
            return false;
        linhaAnterior = this.linha;
        this.linha = linha;
        
        if(coluna < 0 || coluna >= Auxiliar.Consts.RES)
            return false;
        colunaAnterior = this.coluna;
        this.coluna = coluna;
        
        return true;
    }
    
    public int getLinha(){
        return linha;
    }
   
    public boolean volta(){
        return this.setPosicao(linhaAnterior,colunaAnterior);
    }

    public int getColuna(){
        return coluna;
    }

    public boolean igual(Posicao posicao){
        return (linha == posicao.getLinha() && coluna == posicao.getColuna());
    }

    public boolean copia(Posicao posicao){
        return this.setPosicao(posicao.getLinha(),posicao.getColuna());
    }
    
    
    public boolean moveUp(){
        if (this.getLinha() - 1 > 0){
            return this.setPosicao(this.getLinha()-1, this.getColuna());
        } else {
            return false;
        }
        
    }
    public boolean moveDown(){
        if (this.getLinha() + 1 < Auxiliar.Consts.RES - 1){
            return this.setPosicao(this.getLinha()+1, this.getColuna());
        } else {
            return false;
        }
    }
    public boolean moveRight(){
        if (this.getColuna() + 1 < Auxiliar.Consts.RES - 1){
            return this.setPosicao(this.getLinha(), this.getColuna()+1);
        } else {
            return false;
        }
    }
    public boolean moveLeft(){
        if (this.getColuna() - 1 > 0){
            return this.setPosicao(this.getLinha(), this.getColuna()-1);  
        } else {
            return false;
        }
    }
}
