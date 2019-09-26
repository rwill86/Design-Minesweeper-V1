
package minesweepers;

// @author MrRit

import java.util.List;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Input implements KeyListener{
    public List<Controls> controls = new ArrayList();
    public Controls up = new Controls();
    public Controls down = new Controls();
    public Controls left = new Controls();
    public Controls right = new Controls();
    public Controls enter = new Controls();
    public Controls reset = new Controls();
    public Controls flag = new Controls(); 
    public Controls menu = new Controls(); 
    public Controls help = new Controls(); 
    public Controls pause = new Controls(); 
    public Controls switchmode = new Controls(); 
    
    public class Controls{
        public int absorbs;
        public int presses;
        public boolean down;
        public boolean clicked;
        
        public Controls(){
            controls.add(this);
        }

        public void toggle(boolean pressed){
            if(pressed != down){
                down = pressed;
            }
	    if(pressed){
		presses++;
	    }
        }
        
        public void tick(){
            if(absorbs < presses){
                absorbs++;
                clicked = true;
	    } else{
                clicked = false;
	    }     
        }
    }
    
    public void releaseAll(){
        for(int i = 0; i < controls.size(); i++){
            controls.get(i).down = false;
        }
    }
    
    public void tick(){
        for(int i = 0; i < controls.size(); i++){
            controls.get(i).tick();        
        }
    }
    
    public Input(MineSweepers game){
        game.addKeyListener(this);
    }
    
    public void toggle(KeyEvent e, boolean pressed){
        if(e.getKeyCode() == KeyEvent.VK_W){
            up.toggle(pressed);
        }
        
        if(e.getKeyCode() == KeyEvent.VK_UP){
            up.toggle(pressed);
        }
        
        if(e.getKeyCode() == KeyEvent.VK_S){
            down.toggle(pressed);
        }
        
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            down.toggle(pressed);
        }
        
        if(e.getKeyCode() == KeyEvent.VK_A){
            left.toggle(pressed);
        }    
        
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
             left.toggle(pressed);
        }
        
        if(e.getKeyCode() == KeyEvent.VK_D){
            right.toggle(pressed);
        }
        
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            right.toggle(pressed);
        }
        
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            enter.toggle(pressed);
        }    
        
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            menu.toggle(pressed);
        } 
        
        if(e.getKeyCode() == KeyEvent.VK_R){
            reset.toggle(pressed);
        } 
        
        if(e.getKeyCode() == KeyEvent.VK_F){
            flag.toggle(pressed);
        } 
        
        if(e.getKeyCode() == KeyEvent.VK_Q){
            pause.toggle(pressed);
        } 
        
        if(e.getKeyCode() == KeyEvent.VK_H){
            help.toggle(pressed);
        }
        
         if(e.getKeyCode() == KeyEvent.VK_T){
            switchmode.toggle(pressed);
        }
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke){
        toggle(ke, true);
    }

    @Override
    public void keyReleased(KeyEvent ke){
        toggle(ke, false);
    }
    
}
