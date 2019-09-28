
package minesweepers;

import java.applet.Applet;
import java.applet.AudioClip;

 //@author MrRit
 
public class Music {
    public static final Music board = new Music("/Board.wav");
    public static final Music title = new Music("/Title.wav");
    public static final Music gameover = new Music("/Gameover.wav");
    public static final Music click = new Music("/Click.wav");
    public static final Music bomb = new Music("/Bomb.wav");
    private AudioClip clip;
    //Create Sounds
    public Music(String name){
        try {
	    clip = Applet.newAudioClip(Music.class.getResource(name));
	} catch (Throwable e){
	    System.out.println(e);
	}

    }
    //Play sounds
    public void play(){
        try{
	    new Thread(){
                @Override
	        public void run(){
		    clip.play();
	         }
	    }.start();
        } catch(Throwable e){
	    System.out.println(e);
        }
    }
    //Loop sounds
    public void loop(){
        try{
	   new Thread(){
                @Override
	        public void run(){
		    clip.loop();
	        }
           }.start();
	} catch (Throwable e) {
	   System.out.println(e);
	}
    } 
    //Stop sounds
    public void stop(){
        try{
	   new Thread(){
                @Override
	        public void run(){
		    clip.stop();
	        }
           }.start();
	} catch(Throwable e){
	   System.out.println(e);
	}
    }
}