
package minesweepers;

// @author MrRit

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import minesweepers.Menus.OptionMenu;
import minesweepers.Menus.TitleMenu;

public class Mouse implements MouseListener{
    protected MineSweepers game;
    public boolean mode = true;
    public Mouse(MineSweepers game){
         this.game = game;
         game.addMouseListener(this);
    }
    
    public void tick(){
    }
    
    public void toggle(MouseEvent e){
        if(mode){
           int x = e.getX();
           int y = e.getY();
           if(x >= 1 && x <= 20 && y >= 1 && y <= 20){
               System.out.println("MOUSE Party!");
               game.setMenu(new TitleMenu());
           }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e){
    }

    @Override
    public void mousePressed(MouseEvent e){
        toggle(e);
    }

    @Override
    public void mouseReleased(MouseEvent e){
    }

    @Override
    public void mouseEntered(MouseEvent e){
    }

    @Override
    public void mouseExited(MouseEvent e){
    }
    
}
