package minesweepers;

//@author MrRit

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import minesweepers.GUI.Colour;
import minesweepers.GUI.Font;
import minesweepers.GUI.Screen;
import minesweepers.GUI.SpriteSheet;
import minesweepers.Level.Level;
import minesweepers.Menus.Menu;
import minesweepers.Menus.TitleMenu;
import minesweepers.Menus.WonMenu;

public class MineSweepers extends Canvas implements Runnable{
    private static final long serialVersionUID = 1L;
    public static final String APP = "MineSweeper Prototype";
    public static final String ICON = "";
    private static final int WIDTH  = 200;
    private static final int HEIGHT = 200;
    private static final int SCALE = 3;
    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
    private int[] colours = new int[256];
    private Input input = new Input(this);
    private int tickCount = 0;
    private Screen screen;
    private Menu menu;
    private Level level;
    //Time
    public int time = 0; 
    //Score
    public int score = 0;
    public boolean run;
    public boolean pause;
    //Board Size
    public int boardSize = 10;
    public int mines = 10;
    public int levelNumber = 1;
    //Mode
    public boolean mode = true;
    //State
    public boolean alive = true;
    //Init
    public void init(){
        //Pointer
        int pp = 0;
        //RBG
        for(int r = 0; r < 6; r++){
            for(int g = 0; g < 6; g++){
                for(int b = 0; b < 6; b++){
                    int rr = (r * 255 / 5);
                    int gg = (g * 255 / 5);
                    int bb = (b * 255 / 5);
                    int mid = (rr * 30 + gg * 59 + bb * 11) / 100;
                    int r1 = ((rr + mid * 1) / 2) * 230 / 255 + 10;
		    int g1 = ((gg + mid * 1) / 2) * 230 / 255 + 10;
		    int b1 = ((bb + mid * 1) / 2) * 230 / 255 + 10;
		    colours[pp++] = r1 << 16 | g1 << 8 | b1;
	         }
	    }
	}
        //Init screen
        try {
           screen = new Screen(WIDTH, HEIGHT, new SpriteSheet(ImageIO.read(MineSweepers.class.getResourceAsStream("/icons.png"))));
        } catch(IOException e){
            e.printStackTrace();
         }
        reset();
        setMenu(new TitleMenu());
    }
    //Set Menu
    public void setMenu(Menu menu){
        this.menu = menu;
        if(menu != null){
            //Init Menu with input 
            menu.init(this, input);
        }
    }
    //Win
    public void won(){
        //Won menu 
        setMenu(new WonMenu(levelNumber, time, score));  
    }
    //Lost 
    public void lost(){
        alive = false;
    }
    //pause 
    public void pause(){
        if(pause == true){
            pause = false;
        } else{
            pause = true;
        }
    }
    //exit
    public void exit(){
        System.exit(0);
    }
    //reset
    public void reset(){     
        //Reset Level
        level = new Level(boardSize, boardSize, levelNumber, input, this);
        level.setMine(mines);
        level.setBoardNumber();
        alive = true;
        time = 0;
        score = 0;         
    }
    //next Level
    public void nextLevel(){
        levelNumber++;
        mines = mines * levelNumber;
        boardSize = boardSize * levelNumber;
        reset();
        setMenu(null);
    }
    //begin
    public void begin(){
        //running is true 
        run = true;
        //start a Thread 
        new Thread(this).start();
    }
    //Run function 
    @Override
    public void run(){
        long lastTime = System.nanoTime();
	double unprocessed = 0;
	double nsPerTick = 1000000000.0 / 60;
	int frames = 0;
	int ticks = 0;
	long lastTimer1 = System.currentTimeMillis();
        //Init Game
	init();
        //Run Game
	while(run){
            long now = System.nanoTime();
            unprocessed += (now - lastTime) / nsPerTick;
            lastTime = now;
            boolean shouldRender = true;
            //
            while(unprocessed >= 1){
                ticks++;
                ticks();
		unprocessed -= 1;
		shouldRender = true;
	    } 
            //Check if should render 
            if(shouldRender){
		frames++;
		render();
	    }
            //FPS
            if(System.currentTimeMillis() - lastTimer1 > 1000){
                lastTimer1 += 1000;
                //Print the FPS
		System.out.println(ticks + " ticks, " + frames + " fps");
                if(alive){
                    time += 1;
                }
		frames = 0;
		ticks = 0;
	     }
	}
    }
    //Ticks
    public void ticks(){
        tickCount++;
        input.tick();
        if(menu != null){
            menu.tick();
        } else{
            level.tick();
        }
    }
    //Render
    public void render(){
        //Get a buffer 
        BufferStrategy bs = getBufferStrategy();
        if(bs == null){
            createBufferStrategy(3);
            requestFocus();
	    return;
	}   
        //Render Level Background
        level.renderBackground(screen);
        //Render Level Board
        if(mode){
            level.renderCombBoard(screen);
        } else{
            level.renderBoard(screen);
        }
        //Render GUI
        renderGUI();
        //Place pixel colours
        for(int y = 0; y < screen.height; y++){
            for(int x = 0; x < screen.width; x++){
                int cc = screen.pixels[x + y * screen.width];
		if(cc < 255){
                    pixels[x + y * WIDTH] = colours[cc];
                }
	    }
	}    
        //Get draw graphics
        Graphics g = bs.getDrawGraphics();
	g.fillRect(0, 0, getWidth(), getHeight());
	int ww = WIDTH * 3;
	int hh = HEIGHT * 3;
	int xo = (getWidth() - ww) / 2;
	int yo = (getHeight() - hh) / 2;
        //Draw image 
	g.drawImage(image, xo, yo, ww, hh, null);
	g.dispose();
	bs.show();     
    }
    //Render GUI
    public void renderGUI(){
        if(menu != null){
            //menu screen 
            menu.render(screen);
        } else{
             //GUI of score and time 
             level.renderFace(screen);
             Font.draw("Score : " + score, screen, screen.width - 80, screen.height - 8, Colour.get(000, 555, 555, 555));
             Font.draw("Time : " + time, screen, 10, screen.height - 8, Colour.get(000, 555, 555, 555));
        }
       
    }
    //Main 
    public static void main(String[] args){
        //Minesweeer Class 
        MineSweepers game = new MineSweepers();
        //Game Size
        game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
	game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
	game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        //JFrame 
        JFrame frame = new JFrame(APP);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        //Add icon 
        frame.setIconImage(new ImageIcon(game.ICON).getImage());
        //Add game to frame 
        frame.add(game, BorderLayout.CENTER);
        frame.pack();
	frame.setResizable(false);
	frame.setLocationRelativeTo(null);
        frame.setVisible(true); 
        //Begin Game 
        game.begin();
    }
    
}
