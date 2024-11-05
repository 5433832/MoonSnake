package BGM;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class foodmusic {
  private static Player foodplayer = null;

  //加载吃掉食物的声音的方法
  public static void loadfood() {
    File food = new File("./res/sound/food.mp3");
    try {
      FileInputStream foodFileInputStream = new FileInputStream(food);
      //定义普通食物缓冲流对象
      BufferedInputStream foodBufferedInputStream = new BufferedInputStream(foodFileInputStream);
      foodplayer = new Player(foodBufferedInputStream);
    } catch (FileNotFoundException | JavaLayerException e) {
      throw new RuntimeException(e);
    }
  }


  public static void playerfood() {
    try {
      foodplayer.play();
    } catch (JavaLayerException e) {
      throw new RuntimeException(e);
    }
  }
}
