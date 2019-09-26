
package minesweepers;

import java.applet.AudioClip;

 //@author MrRit
 
public class Music {
    private AudioClip clip;
    public static final Music background = new Music("d");
    public static final Music mineEx = new Music("d");
    public static final Music click = new Music("d");
    //Create Sounds
    public Music(String name){

    }
    //Play  sounds
    public void play(){
        clip.play();
    }
    //Loop sounds
    public void loop(){
        clip.loop();
    }
}