package BGM;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class dufoodmusic {
  public static ImageIcon dufood = new ImageIcon("./res/images/dufood.png");
  public static Player dufoodplayer = null;

  //加载吃掉毒食物后的音乐方法
  public static void loaddufood() {
    File dufood = new File("./res/sound/dufood.mp3");
    try {
      FileInputStream dufoodfileinputstream = new FileInputStream(dufood);
      BufferedInputStream dufoodbufferedinputstream = new BufferedInputStream(dufoodfileinputstream);
      dufoodplayer = new Player(dufoodbufferedinputstream);
    } catch (FileNotFoundException | JavaLayerException e) {
      throw new RuntimeException(e);
    }
  }

  public static void playerdufood() {
    try {
      dufoodplayer.play();
    } catch (JavaLayerException e) {
      throw new RuntimeException(e);
    }
  }
}
