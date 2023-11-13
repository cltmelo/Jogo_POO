/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import Auxiliar.Consts;
import static Auxiliar.Consts.RES;
import Auxiliar.Consts;

/**
 *
 * @author lucas
 */

/*SCRIPT DOS MAPAS

    -1: borda
    99: hero
    0: background
    1: brick
    5: passa-fase
    8: ziguezague vertical
    7: passafase
    9: ziguezague horizontal
    6: random
    2: perseguehorizontal
    -3: porta fechada*
    3: porta aberta*
    4: chave*
    10: caveira left
    11: caveira right
    12: caveira up
    13: caveira down
    20: caveira left up
    21: caveira right up
    66(6): persegue vertical
    

*/
public class Fase {
    public int[][][] fases = new int[Consts.FASE_NUMBER][][];

    public Fase() {
        fases[0] = fase1;
        fases[1] = fase2;
        fases[2] = fase3;
        fases[3] = fase4;
        fases[4] = faseBonus;
    }

    public int[][] getFase(int faseIndex) {
        int[][] fase = fases[faseIndex];
        return fase;
    }
    
    
   
    /*Criar de 1 até FASE_NUMBER matrizes*/
    
    int[][] fase1 = {
        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
        
        {-1, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0,-1},
        
        {-1, 0, 1, 7, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 7, 1, 0,-1},
        
        {-1, 0, 1, 0, 0, 0, 0, 1, 9, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0,-1},
        
        {-1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 1, 0, 1, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 8, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 8, 0, 0,-1},
        
        {-1, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 1, 0, 1, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0,-1},
        
        {-1, 0, 1, 0, 0, 0, 0, 1, 9, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0,-1},
        
        {-1, 0, 1, 7, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 7, 1, 0,-1},
        
        {-1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8,-1},
        
        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
    };
    
    int[][] fase2 = {
        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
        
        {-1, 0, 0, 0, 0, 0, 8, 0, 8, 0, 8, 0, 99, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 7, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 7,-1},
        
        {-1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0,-1},
        
        {-1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0,-1},
        
        {-1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0,-1},
        
        {-1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0,-1},
        
        {-1, 0, 1, 1, 1, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0,-1},
        
        {-1, 0, 0, 1, 1, 1, 1, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 1, 1, 1, 1, 0,-1},
        
        {-1, 0, 0, 0, 0, 1, 1, 1, 1, 8, 0, 0, 0, 0, 0, 0, 8, 1, 1, 1, 1, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 8, 0, 0, 8, 1, 1, 1, 1, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1, 1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 7, 1, 1, 7, 0, 0, 0, 2, 0, 0, 0, 0, 0,-1},
        
        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
    };
    
    int[][] fase3 = { 
        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
        
        {-1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 99, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1,-1},
        
        {-1, 1, 13, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 13, 0, 0, 1,-1},
        
        {-1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1,-1},
        
        {-1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1,-1},
        
        {-1, 1, 11, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 10, 1,-1},
        
        {-1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1,-1},
        
        {-1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1,-1},
        
        {-1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1,-1},
        
        {-1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 8, 0, 0, 0, 8, 1, 1, 1, 1, 1, 0, 1, 1, 1,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 9, 1, 1, 50, 1, 1, 9, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 7, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 9, 1, 1, 1, 1, 1, 9, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 8, 0, 0, 0, 8, 1, 1, 0, 1, 1, 1, 1, 1, 1,-1},
        
        {-1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1,-1},
        
        {-1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 80, 0, 0, 0, 0, 0, 1,-1},
        
        {-1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 1,-1},
        
        {-1, 1, 0, 0, 0, 4, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 4, 0, 0, 0, 1,-1},
        
        {-1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1,-1},
        
        {-1, 1, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1,-1},
        
        {-1, 1, 0, 0, 0, 0, 0, 0, 12, 1, 0, 0, 0, 0, 0, 1, 0, 12, 0, 0, 0, 0, 0, 1,-1},
        
        {-1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1,-1},
        
        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
    };
    
    int[][] fase4 = { 
        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
        
        {-1, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 8, 99, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0,-1},
        
        {-1, 11, 7, 0, 7, 7, 0, 7, 7, 7, 7, 0, 0, 0, 7, 7, 7, 7, 0, 7, 7, 0, 7, 10,-1},
        
        {-1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0,-1},
        
        {-1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0,-1},
        
        {-1, 11, 7, 0, 7, 7, 0, 7, 7, 7, 7, 0, 0, 0, 7, 7, 7, 7, 0, 7, 7, 0, 7, 10,-1},
        
        {-1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0,-1},
        
        {-1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0,-1},
        
        {-1, 11, 7, 0, 7, 7, 0, 7, 7, 7, 7, 0, 0, 0, 7, 7, 7, 7, 0, 7, 7, 0, 7, 10,-1},
        
        {-1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0,-1},
        
        {-1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0,-1},
        
        {-1, 11, 7, 0, 7, 7, 0, 7, 7, 7, 7, 0, 0, 0, 7, 7, 7, 7, 0, 7, 7, 66, 7, 10,-1},
        
        {-1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0,-1},
        
        {-1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0,-1},
        
        {-1, 11, 7, 66, 7, 7, 0, 7, 7, 7, 7, 0, 0, 0, 7, 7, 7, 7, 0, 7, 7, 0, 7, 10,-1},
        
        {-1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0,-1},
        
        {-1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0,-1},
        
        {-1, 11, 7, 0, 7, 7, 66, 7, 7, 7, 7, 0, 0, 0, 7, 7, 7, 7, 0, 7, 7, 0, 7, 10,-1},
        
        {-1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0,-1},
        
        {-1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0,-1},
        
        {-1, 11, 7, 0, 7, 7, 0, 7, 7, 7, 7, 0, 0, 0, 7, 7, 7, 7, 0, 7, 7, 0, 7, 10,-1},
        
        {-1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0,-1},
        
        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
    };
    
    int[][] faseBonus = { 
        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
        
        {-1, 999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 999,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 999, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 999, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 999,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 66,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 999, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 66, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 66,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 12, 21, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 7, 11, 0, 0, 0,-1},
        
        {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 0, 11, 0, 0, 0,-1},
        
        {-1, 999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 999,-1},
        
        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
    };

}
