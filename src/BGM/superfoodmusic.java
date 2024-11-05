package BGM;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class superfoodmusic {
  public static ImageIcon superfood = new ImageIcon("./res/images/superfood.png");
  public static Player superfoodplayer = null;

  //加载吃掉超级食物后的音乐
  public static void loadsuperfood() {
    File superfood = new File("./res/sound/superfood.mp3");
    try {
      FileInputStream superfoodfileinputstream = new FileInputStream(superfood);
      BufferedInputStream superfoodbufferedinputstream = new BufferedInputStream(superfoodfileinputstream);
      superfoodplayer = new Player(superfoodbufferedinputstream);
    } catch (FileNotFoundException | JavaLayerException e) {
      throw new RuntimeException(e);
    }
  }

  public static void playersuperfood() {
    try {
      superfoodplayer.play();
    } catch (JavaLayerException e) {
      throw new RuntimeException(e);
    }
  }
}
