package BGM;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class BGM {
  //定义Clip(音乐播放器)类型的对象背景音乐对象
  public static Clip bgm;

  public static void loadBGM() {
    //加载某个东西时软件会提示进行异常捕捉；如果没有加载成功执行什么
    try {
//      创建一个音乐播放器
      bgm = AudioSystem.getClip();
      //声明一个文件对象获取指定资源
      File is = new File("./res/sound/bgm.wav");


      //这里是将获取的音乐转成输入字节流
      //定义输入流变量 获取当前类.获取当前类加载器（加载器可以在当前项目文件夹寻找指定资源）.获取要找的资源的路径（“路径”）赋值给is
//      InputStream is = this.getClass().getClassLoader().getResourceAsStream("res/sound/bgm2.wav");  这条方法找不到res/sound/下的文件会报空指针错误null；只支持在src目录下（同时这条方法不支持mp3文件）
/*
  注意：
  BGM和失败的音乐播放方法不一样：
  BGM利用Clip类创建播放器对象->利用File类获取资源文件->利用AudioInputStream类将获取的资源文件转为音频输入流->
     利用open方法将音频输入流文件添加到播放器对象->之后可以利用play方法播放一次或是用loop方法循环播放
  失败音乐是首先利用File类获取资源文件->利用FileInputStream类将其转为文件输入流->
     利用BufferedInputStream类将其放入缓冲流（内存）【可以不放入缓冲流，但这样会经常读写硬盘】->
     利用Player类将缓冲流内的文件传入Player->最后利用play方法播放，这种方法暂没发现可以用的循环播放方法
*/


      //将文件转换为音频输入流
      AudioInputStream ais = AudioSystem.getAudioInputStream(is);//不支持mp3
      //利用前面创建的音乐播放器打开转换好的音频输入流
      bgm.open(ais);
//      这里没有加载成功会进行打印错误
    } catch (LineUnavailableException | UnsupportedAudioFileException e) {
      e.printStackTrace();
      //如果出现以下错误就执行以下语句
    } catch (IOException e) {
      e.printStackTrace();
    }
//    mp3文件使用方法目前发现loop方法不支持File类型的对象
//    try {
//      //声明file类型的对象来获取指定音乐文件
//      File mp3 = new File("res/sound/bgm.mp3");
//      //创建输入流对象将获取的文件转换为输入流
//      FileInputStream fileInputStream = new FileInputStream(mp3);
//      //创建缓冲流对象将输入流送进缓冲流（内存）准备随时引用；这样可以避免经常读取硬盘（此方法只支持File类型）
//      BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
//      player = new Player(bufferedInputStream);
//      player.play();
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
  }

  public static void playBGM() {
    //将前面创建的音乐播放器播放（此时里面已经有一个音乐）
    //bgm.start();
    //循环播放（一直播）
    bgm.loop(Clip.LOOP_CONTINUOUSLY);
  }

  //停止背景音乐方法
  public static void stopBGM() {
    bgm.stop();
  }

}
