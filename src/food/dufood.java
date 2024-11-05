package food;

import BGM.dufoodmusic;
import Mobile.Mobile;
import Userkey.User_keyboard;
import len.len;
import rand.rand;
import score.score;

public class dufood {
  public static int dufoodx;
  public static int dufoody;
  public static boolean dufood_look = false;  //定义毒食物显示变量初始化为false


  //这里要注意Clip类可以利用loop循环播放，而Player类不行
  //定义player类型的对象


  //贪吃蛇初始化方法

//  贪吃蛇吃掉毒食物的方法

  public static void dufood() {
    if (Mobile.Snakex[0] == dufoodx && Mobile.Snakey[0] == dufoody) //判断蛇头坐标与超级食物坐标是否一致
    {
      dufoodmusic.playerdufood();
      dufood_look = false;  //吃掉du食物后，显示变量重新复位false
      len.len = len.len - 4;  //蛇身长度-4
      score.score -= 30;
      if (len.len < 4 || score.score <= 0) {
        User_keyboard.isFailed = true;
      }
      dufoodx = 25 + 25 * rand.rand.nextInt(34);//重新分配毒食物坐标
      dufoody = 75 + 25 * rand.rand.nextInt(24);
      dufoodmusic.loaddufood();//重新加载吃食物的方法

    }
  }
}
