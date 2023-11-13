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
import Modelo.CaveiraLeftUp;
import Modelo.CaveiraRightUp;
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
import Modelo.ChaosMonster;
import Modelo.Chave;
import Modelo.Porta;


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
    int msg = 0;
    public Tela() {
        Desenho.setCenario(this);
        initComponents();
        this.addMouseListener(this); /*mouse*/
        isPaused = false;
        this.addKeyListener(this);   /*teclado*/
        hero = new Hero("guts.png");
        
        /*Cria a janela do tamanho do tabuleiro + insets (bordas) da janela*/
        this.setSize(Consts.RES * Consts.CELL_SIDE + getInsets().left + getInsets().right,
                Consts.RES * Consts.CELL_SIDE + getInsets().top + getInsets().bottom);

        
        faseAtual = new ArrayList<Personagem>();
        index = 0;
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
                    Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "floor.png");
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
                Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "edge.png");
                g2.drawImage(newImage,
                        j * Consts.CELL_SIDE, 0 * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
                
                Image newnewImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "edge.png");
                g2.drawImage(newnewImage,
                        j * Consts.CELL_SIDE, (Consts.RES-1) * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

            } catch (IOException ex) {
                Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for (int i = 0; i < Consts.RES; i++) {
            try {
                Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "edgey.png");
                g2.drawImage(newImage,
                        0 * Consts.CELL_SIDE, i * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
                
                Image newnewImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "edgey.png");
                g2.drawImage(newnewImage,
                        (Consts.RES-1) * Consts.CELL_SIDE, i * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

            } catch (IOException ex) {
                Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "void.png");
            g2.drawImage(newImage, 0 * Consts.CELL_SIDE, 0 * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

        } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "void.png");
            g2.drawImage(newImage, (Consts.RES-1) * Consts.CELL_SIDE, 0 * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

        } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "void.png");
            g2.drawImage(newImage, 0 * Consts.CELL_SIDE, (Consts.RES-1) * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

        } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "void.png");
            g2.drawImage(newImage, (Consts.RES-1) * Consts.CELL_SIDE, (Consts.RES-1) * Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

        } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (!isPaused){
            if (!this.faseAtual.isEmpty()) {
                this.cj.desenhaTudo(faseAtual);
                
                
                if (index == 0 && msg == 0){
                    
                    isPaused = !isPaused;
                    hero.nome = JOptionPane.showInputDialog(null, "Por favor, insira o nome do seu personagem:", "Nome do Personagem", JOptionPane.INFORMATION_MESSAGE);
        
                    JOptionPane.showMessageDialog(
                    null,
                    "Bem-vindo, " + hero.nome + "! Prepare-se para uma jornada emocionante e desafiadora como um destemido Herói. Enfrente inimigos ferozes, desvende mistérios e conquiste o mundo com sua coragem e força.\n" +
                    "\n" +
                    "Lembre-se, o caminho dos Berserkers é árduo, e somente os mais corajosos e habilidosos terão sucesso. Esteja pronto para lutar até o fim e se tornar uma lenda!\n" +
                    "\nConquiste todos os Baldes de Hidromel para prosseguir para a próxima fase!",
                    "Dark Sonia",
                    JOptionPane.INFORMATION_MESSAGE
                    );
                    msg++;
                    System.out.println(hero.nome + ". Quantidade de Vidas: " + hero.vidas + ". \nPegue os baldes de Hidromel para prosseguir e as chaves para superar os obstáculos da masmorra. \nDesvie dos Inimigos e Conquiste a glória!");
                    System.out.println("Use as setas do teclado para se movimentar!\nR - Reinicia Fase\nS - Salva o jogo\nL - Carrega o último Save\nBotão Esquedo do Mouse - Passa de Fase Automaticamente (Solução de covardes!)");
                    isPaused = !isPaused;
                }
                if (this.cj.processaTudo(faseAtual) == 0){
                    restart(hero.vidas, this.index); //AJEITAR PARA PASSAR O INDEX COMO PARAMETRO AO INVES DE '1'
                }



                if(this.cj.processaTudo(faseAtual) == 1){ 
                    this.index++;
                    if (index == 5){
                        JOptionPane.showMessageDialog(
                                null, 
                                "Você, destemido Berserker, superou todos os desafios, derrotou os inimigos mais temíveis e provou ser verdadeiramente lendário."
                                 + "\n\nSeu nome ecoará na história como o Berserker invencível. Parabéns, você completou o jogo de Berserker!\n\nJogo Feito por Jean Cassiano e Lucas Corlete",
                                
                                "Parabéns!", 
                                JOptionPane.INFORMATION_MESSAGE);
                        this.faseAtual.clear();
                        System.exit(0);
                    }
                    else {
                        this.faseAtual.clear();
                        setFase(index);
                    }
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
    public boolean carregarJogo() {
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
            return true;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Save não encontrado!");
            return false;
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
        index++;
        this.faseAtual.clear();
        if (index == 5){
                        JOptionPane.showMessageDialog(
                                null, 
                                "Você, destemido Berserker, superou todos os desafios, derrotou os inimigos mais temíveis e provou ser verdadeiramente lendário."
                                 + "\n\nSeu nome ecoará na história como o Berserker invencível. Parabéns, você completou o jogo de Berserker!\n\nJogo Feito por Jean Cassiano e Lucas Corlete",
                                
                                "Parabéns!", 
                                JOptionPane.INFORMATION_MESSAGE);
                        this.faseAtual.clear();
                        System.exit(0);
        }
        this.setFase(index);
        repaint();
        
         //this.hero.getPosicao().setPosicao(y/Consts.CELL_SIDE, x/Consts.CELL_SIDE);
         
        repaint();
    }
    
    
    public void setFase(int index){
        this.index = index;
        
        /*Cria faseAtual adiciona personagens*/
        
        hero.setPosicao(linhaHero, colunaHero);
        this.addPersonagem(hero);             //SEMPRE ADD O HEOI PRIMEIRO SE NAO O CODIGO QUEBRA!!!!!!!!!!!!!!
        
        
        //index começa como zero para a primeira fase, depois vamos incrmentando para mudar para fase seguinte
    
        int[][] fase = map.getFase(index);
        
        
        for(int i=0; i<Consts.RES; i++){
            for (int j=0; j<Consts.RES; j++){
                if(!(i == linhaHero && j == colunaHero)){

                    int elem = fase[i][j];

                    switch(elem){
                        case 1:
                            Cenario tijolo = new Cenario("bricks.png");
                            tijolo.setPosicao(i, j);
                            this.addPersonagem(tijolo);
                            break;
                        case 8:
                            BichinhoVaiVemVertical bBichinhoVertical = new BichinhoVaiVemVertical("ziguezague.png");
                            bBichinhoVertical.setPosicao(i,j);
                            this.addPersonagem(bBichinhoVertical);
                            break;
                        case 9:
                            BichinhoVaiVemHorizontal bBichinhoHorizontal = new BichinhoVaiVemHorizontal("ziguezague.png");
                            bBichinhoHorizontal.setPosicao(i,j);
                            this.addPersonagem(bBichinhoHorizontal);
                            break;
                        case 7:
                            PassaFase pf = new PassaFase("corona.png");
                            pf.setPosicao(i, j);
                            this.addPersonagem(pf);
                            break;
                        case 6:
                            Randomico random = new Randomico("randomico.png");
                            random.setPosicao(i, j);
                            this.addPersonagem(random);
                        case 2:
                            PersegueHorizontal bPersegueHorizontal = new PersegueHorizontal("persegue_h.png", hero);
                            bPersegueHorizontal.setPosicao(i, j);
                            this.addPersonagem(bPersegueHorizontal);
                            break;
                        case 4:
                            /*add chave*/
                            /*Sugiro usar o ícone de explosao*/
                            break;
                        case -3:
                            /*add porta fechada*/
                            /*Sugiro apagar esse case e deixar um brick normal, mas quando pegar o explosão(chave) ele some e só omstra o plano de fundo mesmo*/
                            break;
                        case 10:
                            CaveiraLeft bCaveiraLeft = new CaveiraLeft("caveira.png");
                            bCaveiraLeft.setPosicao(i, j);
                            this.addPersonagem(bCaveiraLeft);
                            break;
                        case 11:
                            CaveiraRight bCaveiraRight = new CaveiraRight("caveira.png");
                            bCaveiraRight.setPosicao(i, j);
                            this.addPersonagem(bCaveiraRight);
                            break;
                        case 12:
                            CaveiraUp bCaveiraUp = new CaveiraUp("caveira.png");
                            bCaveiraUp.setPosicao(i, j);
                            this.addPersonagem(bCaveiraUp);
                            break;
                        case 13:
                            CaveiraDown bCaveiraDown = new CaveiraDown("caveira.png");
                            bCaveiraDown.setPosicao(i, j);
                            this.addPersonagem(bCaveiraDown);
                            break;
                        case 66:
                            PersegueVertical bPersegueVertical = new PersegueVertical("persegue_v.png", hero);
                            bPersegueVertical.setPosicao(i, j);
                            this.addPersonagem(bPersegueVertical);
                            break;
                        case 20:
                            CaveiraLeftUp bCaveiraLeftUp = new CaveiraLeftUp("caveira.png");
                            bCaveiraLeftUp.setPosicao(i, j);
                            this.addPersonagem(bCaveiraLeftUp);
                            break;
                        case 21:
                            CaveiraRightUp bCaveiraRightUp = new CaveiraRightUp("caveira.png");
                            bCaveiraRightUp.setPosicao(i, j);
                            this.addPersonagem(bCaveiraRightUp);
                            break;
                        case 50:
                            Porta door = new Porta("door.png");
                            door.setPosicao(i, j);
                            this.addPersonagem(door);
                            break;
                        case 80:
                            Chave key = new Chave("key.png");
                            key.setPosicao(i, j);
                            this.addPersonagem(key);
                            break;
                        
                           
                        case 999:
                            ChaosMonster bChaosMonster = new ChaosMonster("ghost.png");
                            bChaosMonster.setPosicao(i, j);
                            this.addPersonagem(bChaosMonster);
                        default:
                            break;
                        }
                }
            }
        }
        
        
        
        /*
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
        
        */
        
        
//        PassaFase pf = new PassaFase("coco.png");
//        pf.setPosicao(2, 23);
//        this.addPersonagem(pf);
//        PassaFase pf = new PassaFase("coco.png");
//        pf.setPosicao(12, 14);
//        this.addPersonagem(pf);
//        PassaFase pf2 = new PassaFase("coco.png");
//        pf2.setPosicao(12, 12);
//        this.addPersonagem(pf2);
       
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
