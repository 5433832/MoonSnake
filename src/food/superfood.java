package food;

import BGM.superfoodmusic;
import Mobile.Mobile;
import len.len;
import rand.rand;
import score.score;

public class superfood {
  public static int superfoodx;
  public static int superfoody;
  public static boolean superfood_look = false;  //定义超级食物显示变量初始化为false

  //贪吃蛇吃掉超级食物的方法
  public static void superfood() {
    if (Mobile.Snakex[0] == superfoodx && Mobile.Snakey[0] == superfoody) //判断蛇头坐标与超级食物坐标是否一致
    {
      superfoodmusic.playersuperfood();
      superfood_look = false;  //吃掉超级食物后，显示变量重新复位false
      len.len = len.len + 3;  //蛇身长度+3
      score.score += 50;
      Mobile.Snakey[len.len - 3] = Mobile.Snakey[len.len - 4];//将新加的蛇身长度继承前一格坐标
      Mobile.Snakex[len.len - 3] = Mobile.Snakex[len.len - 4];
      Mobile.Snakey[len.len - 2] = Mobile.Snakey[len.len - 3];//将新加的蛇身长度继承前一格坐标
      Mobile.Snakex[len.len - 2] = Mobile.Snakex[len.len - 3];
      Mobile.Snakey[len.len - 1] = Mobile.Snakey[len.len - 2];//将新加的蛇身长度继承前一格坐标
      Mobile.Snakex[len.len - 1] = Mobile.Snakex[len.len - 2];
      superfoodx = 25 + 25 * rand.rand.nextInt(34);//重新分配超级食物坐标
      superfoody = 75 + 25 * rand.rand.nextInt(24);
      superfoodmusic.loadsuperfood();
    }
  }
}
