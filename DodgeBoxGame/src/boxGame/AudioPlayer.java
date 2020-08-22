package boxGame;

import java.io.*;
import javax.sound.sampled.*;

public class AudioPlayer {

    private static Clip play;
    private static Clip play2;

    public static void playMenuSound(){
        try{

            AudioInputStream menuSound = AudioSystem.getAudioInputStream(new File("src/Resources/0218.wav"));
            play = AudioSystem.getClip();
            play.open(menuSound);
            FloatControl volume = (FloatControl) play.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(0.5f);
            play.loop(Clip.LOOP_CONTINUOUSLY);

        }catch (LineUnavailableException | IOException |UnsupportedAudioFileException e){

            e.printStackTrace();
        }
    }

    public static void playGameSound(){
        try{

            AudioInputStream gameSound = AudioSystem.getAudioInputStream(new File("src/Resources/1782.wav"));
            play2 = AudioSystem.getClip();
            play2.open(gameSound);
            FloatControl volume = (FloatControl) play2.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(0.5f);
            play2.loop(Clip.LOOP_CONTINUOUSLY);

        }catch (LineUnavailableException | IOException |UnsupportedAudioFileException e){

            e.printStackTrace();
        }
    }

    public static void stopMenuMusic(){
        play.close();
    }

    public static void stopGameMusic(){
        play2.close();
    }
}
