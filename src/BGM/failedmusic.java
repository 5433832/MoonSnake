package BGM;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class failedmusic {
  public static Player failedplayer = null;

  //失败的音乐加载方法
  public static void loadfailed() {

    File failed = new File("./res/sound/snake-kill.mp3");
    try {
      FileInputStream failedInputStream = new FileInputStream(failed);
      BufferedInputStream failBufferedInputStream = new BufferedInputStream(failedInputStream);
      failedplayer = new Player(failBufferedInputStream);
    } catch (FileNotFoundException | JavaLayerException e) {
      throw new RuntimeException(e);
    }
  }

  //失败音乐播放方法
  public static void playerfailed() {
    try {
      failedplayer.play();
    } catch (JavaLayerException e) {
      throw new RuntimeException(e);
    }
  }
}
