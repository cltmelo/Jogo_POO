package Controler;

import Modelo.PassaFase;
import Modelo.Personagem;
import Modelo.CaveiraRight;
import Modelo.CaveiraLeft;
import Modelo.CaveiraUp;
import Modelo.CaveiraDown;
import Modelo.Hero;
import Modelo.BichinhoVaiVemHorizontal;
import Modelo.BichinhoVaiVemVertical;
import Auxiliar.Consts;
import Auxiliar.Desenho;
import Modelo.PersegueHorizontal;
import Modelo.Randomico;
import Auxiliar.Posicao;
import Modelo.Cenario;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.swing.JButton;
import Modelo.PersegueVertical;
import Modelo.Fase;
import javax.swing.JOptionPane;
import Modelo.PassaFase;


public class Tela extends javax.swing.JFrame implements MouseListener, KeyListener {
    private boolean isPaused;
    private Hero hero;
    private ArrayList<Personagem> faseAtual;
    private ControleDeJogo cj = new ControleDeJogo();
    private Graphics g2;
    private Fase map = new Fase();
    int linhaHero = 1;
    int colunaHero = 12;
    int index;
    
    public Tela() {
        Desenho.setCenario(this);
        initComponents();
        this.addMouseListener(this); /*mouse*/
        isPaused = false;
        this.addKeyListener(this);   /*teclado*/
        hero = new Hero("skoot.png");
        
        /*Cria a janela do tamanho do tabuleiro + insets (bordas) da janela*/
        this.setSize(Consts.RES * Consts.CELL_SIDE + getInsets().left + getInsets().right,
                Consts.RES * Consts.CELL_SIDE + getInsets().top + getInsets().bottom);

        
        faseAtual = new ArrayList<Personagem>();
        index = 1;
        setFase(index);     
        
    }
    
    public boolean ehPosicaoValida(Posicao p){
        return cj.ehPosicaoValida(this.faseAtual, p);
    }
    public void addPersonagem(Personagem umPersonagem) {
        faseAtual.add(umPersonagem);
    }

    public void removePersonagem(Personagem umPersonagem) {
        faseAtual.remove(umPersonagem);
    }

    public Graphics getGraphicsBuffer(){
        return g2;
    }
    
    public void restart(int vidas, int index) { //ALTERAR PARA DESENHAR TODA FASEATUAL
        faseAtual.clear();  // Limpa a lista de personagens da fase
        setFase(index);
    }

    // Vai sempre desenhar nosso sprite que tem o fundo e a borda
    public void paint(Graphics gOld) {
        Graphics g = this.getBufferStrategy().getDrawGraphics();
        /*Criamos um contexto gráfico*/
        g2 = g.create(getInsets().left, getInsets().top, getWidth() - getInsets().right, getHeight() - getInsets().top);
        /*************Desenha cenário de fundo**************/
        for (int i = 0; i < Consts.RES; i++) {
            for (int j = 0; j < Consts.RES; j++) {
                try {
                    Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "water.gif");
                    g2.drawImage(newImage,
                            j * Consts.CELL_SIDE, i * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

                } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        /*Loops para as bordas do mapa*/
        for (int j = 0; j < Consts.RES; j++) {
            try {
                Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "grass_top.png");
                g2.drawImage(newImage,
                        j * Consts.CELL_SIDE, 0 * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
                
                Image newnewImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "grass_bottom.png");
                g2.drawImage(newnewImage,
                        j * Consts.CELL_SIDE, (Consts.RES-1) * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

            } catch (IOException ex) {
                Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for (int i = 0; i < Consts.RES; i++) {
            try {
                Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "grass_left.png");
                g2.drawImage(newImage,
                        0 * Consts.CELL_SIDE, i * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
                
                Image newnewImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "grass_right.png");
                g2.drawImage(newnewImage,
                        (Consts.RES-1) * Consts.CELL_SIDE, i * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

            } catch (IOException ex) {
                Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "grass_00.png");
            g2.drawImage(newImage, 0 * Consts.CELL_SIDE, 0 * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

        } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "grass_0n.png");
            g2.drawImage(newImage, (Consts.RES-1) * Consts.CELL_SIDE, 0 * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

        } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "grass_n0.png");
            g2.drawImage(newImage, 0 * Consts.CELL_SIDE, (Consts.RES-1) * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

        } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "grass_nn.png");
            g2.drawImage(newImage, (Consts.RES-1) * Consts.CELL_SIDE, (Consts.RES-1) * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

        } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (!isPaused){
            if (!this.faseAtual.isEmpty()) {
                this.cj.desenhaTudo(faseAtual);

                if (this.cj.processaTudo(faseAtual) == 0){
                    restart(hero.vidas, 1); //AJEITAR PARA PASSAR O INDEX COMO PARAMETRO AO INVES DE '1'
                }



                if(this.cj.processaTudo(faseAtual) == 1){ 
                    this.index++;
                    this.faseAtual.clear();
                    setFase(index);
                }

            }
        } else {
        // O jogo está pausado, desenhe uma mensagem de pausa ou faça o que desejar
        g2.drawString("Jogo Pausado", 100, 100); // Exemplo de mensagem de pausa
        }
        g.dispose();
        g2.dispose();
        if (!getBufferStrategy().contentsLost()) {
            getBufferStrategy().show();
        }
        
            
    }

    public void go() {
        TimerTask task = new TimerTask() {
            public void run() {
                repaint();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 0, Consts.PERIOD);
    }

    public void salvarJogo() {
        SaveState gameState = new SaveState(index, faseAtual);
        try {
            FileOutputStream fileOut = new FileOutputStream("savestate.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(gameState); // Salva o estado do jogo
            out.close();
            fileOut.close();
            System.out.println("O jogo foi salvo com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void carregarJogo() {
        try {
            FileInputStream fileIn = new FileInputStream("savestate.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            SaveState gameState = (SaveState) in.readObject(); // Carrega o estado do jogo
            in.close();
            fileIn.close();
            index = gameState.getIndex(); // Atualiza o índice
            faseAtual = gameState.getFaseAtual(); // Atualiza a fase atual
            if (!faseAtual.isEmpty()) {
                // Define o herói como o primeiro personagem na fase atual
                if (faseAtual.get(0) instanceof Hero) {
                    hero = (Hero) faseAtual.get(0);
                }
            }
            System.out.println("Jogo carregado com sucesso!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_R) {
            isPaused = !isPaused;
            Object[] options = { "Reiniciar Fase", "Voltar"};
                int escolha = JOptionPane.showOptionDialog(
                    null, 
                    "Jogo Pausado!!! Deseja Reiniciar a Fase?",
                    "Pause", 
                    JOptionPane.INFORMATION_MESSAGE,
                    JOptionPane.YES_NO_OPTION, 
                    null, 
                    options, 
                    options[0]);
                if (escolha == 0){
                    this.faseAtual.clear();
                    setFase(this.index);
                    isPaused = !isPaused;
                } else {
                    isPaused = !isPaused;
                }
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            this.salvarJogo();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            hero.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            hero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_L) {
            isPaused = !isPaused;
            Object[] options = { "Carregar Jogo", "Voltar"};
                int escolha = JOptionPane.showOptionDialog(
                    null, 
                    "Jogo Pausado!!! Deseja carregar o último save?",
                    "Pause", 
                    JOptionPane.INFORMATION_MESSAGE,
                    JOptionPane.YES_NO_OPTION, 
                    null, 
                    options, 
                    options[0]);
                if (escolha == 0){
                    this.faseAtual.clear();
                    isPaused = !isPaused;
                    this.carregarJogo();
                } else {
                    isPaused = !isPaused;
                }
            
        }

        this.setTitle("-> Cell: " + (hero.getPosicao().getColuna()) + ", "
                + (hero.getPosicao().getLinha()));

        //repaint(); /*invoca o paint imediatamente, sem aguardar o refresh*/
    }

    public void mousePressed(MouseEvent e) {
        /* Clique do mouse desligado*/
         int x = e.getX();
         int y = e.getY();
     
         this.setTitle("X: "+ x + ", Y: " + y +
         " -> Cell: " + (y/Consts.CELL_SIDE) + ", " + (x/Consts.CELL_SIDE));
        
         //this.hero.getPosicao().setPosicao(y/Consts.CELL_SIDE, x/Consts.CELL_SIDE);
         
        repaint();
    }
    
    
    public void setFase(int index){
        /*Cria faseAtual adiciona personagens*/
        
        hero.setPosicao(linhaHero, colunaHero);
        this.addPersonagem(hero);             //SEMPRE ADD O HEOI PRIMEIRO SE NAO O CODIGO QUEBRA!!!!!!!!!!!!!!
        
        
        //index começa como zero para a primeira fase, depois vamos incrmentando para mudar para fase seguinte
    
        int[][] fase = map.getFase(index);
        
        
        for(int i=0; i<Consts.RES; i++){
            for (int j=0; j<Consts.RES; j++){
                int elem = fase[i][j];
                
                switch(elem){
                    case 5:
                        Cenario tijoloteste = new Cenario("bricks.png");
                        tijoloteste.setPosicao(i, j);
                        this.addPersonagem(tijoloteste);
                    case 40:
                        break;
//                        default:
//                            break;
                    }
            }
        }
        
        
        
        Randomico zz = new Randomico("robo.png");
        zz.setPosicao(5, 5);
        this.addPersonagem(zz);

        BichinhoVaiVemVertical bBichinhoH = new BichinhoVaiVemVertical("roboPink.png");
        bBichinhoH.setPosicao(3, 3);
        this.addPersonagem(bBichinhoH);

        BichinhoVaiVemHorizontal bBichinhoH2 = new BichinhoVaiVemHorizontal("roboPink.png");
        bBichinhoH2.setPosicao(6, 6);
        this.addPersonagem(bBichinhoH2);

        CaveiraUp bV = new CaveiraUp("caveira.png");
        bV.setPosicao(9, 1);
        this.addPersonagem(bV);
        
        
        CaveiraRight bV2 = new CaveiraRight("caveira.png");
        bV2.setPosicao(12, 1);
        this.addPersonagem(bV2);
        
        PersegueHorizontal pj = new PersegueHorizontal("roboPink.png", hero);
        pj.setPosicao(15, 15);
        this.addPersonagem(pj);
        
        
//        PersegueVertical pv = new PersegueVertical("roboPink.png", hero);
//        pv.setPosicao(17, 15);
//        this.addPersonagem(pv);
        
        Cenario tijolo1 = new Cenario("bricks.png");
        tijolo1.setPosicao(3, 10);
        this.addPersonagem(tijolo1); //Isso aqui ta cagando o vaievemhorizontal, pois ele bate no cenário e não volta

        for(int i=10; i<16; i++){
            Cenario tijolos = new Cenario("bricks.png");
            tijolos.setPosicao(i, 10);
            this.addPersonagem(tijolos);
        }
        
        PassaFase pf = new PassaFase("coco.png");
        pf.setPosicao(23, 23);
        this.addPersonagem(pf);
       
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("POO2023-1 - Skooter");
        setAlwaysOnTop(true);
        setAutoRequestFocus(false);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
    

}
