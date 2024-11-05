package food;

import BGM.foodmusic;
import Mobile.Mobile;
import len.len;
import rand.rand;
import score.score;

import javax.swing.*;


//贪吃蛇吃掉普通食物的类
public class food {
  public static ImageIcon foodimg = new ImageIcon("./res/images/food.png");
  public static int foodx;
  public static int foody;

  public static void food() {
    if (Mobile.Snakex[0] == foodx && Mobile.Snakey[0] == foody) //判断蛇头坐标与食物坐标是否一致
    {
      foodmusic.playerfood();
      len.len++;  //蛇身长度+1
      score.score += 10;
      Mobile.Snakey[len.len - 1] = Mobile.Snakey[len.len - 2];//将新加的蛇身长度继承前一格坐标
      Mobile.Snakex[len.len - 1] = Mobile.Snakex[len.len - 2];
      foodx = 25 + 25 * rand.rand.nextInt(34);  //将食物坐标重新分配
      foody = 75 + 25 * rand.rand.nextInt(24);
      foodmusic.loadfood();//重新加载吃食物的方法
    }
  }
}
