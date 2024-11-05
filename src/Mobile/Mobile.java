package Mobile;

import Userkey.User_keyboard;
import len.len;

public class Mobile {
  public static int[] Snakex = new int[750];//定义贪吃蛇x坐标位置数组变量
  public static int[] Snakey = new int[750];//定义贪吃蛇y坐标位置数组变量

  //贪吃蛇移动方法
  public static void Snake_Mobile() {
    for (int i = len.len - 1; i > 0; i--)  //将蛇后一格身体继承前一个身体的坐标
    {
      Snakex[i] = Snakex[i - 1];
      Snakey[i] = Snakey[i - 1];
    }
    switch (User_keyboard.fx) {
      case "R":
        Snakex[0] = Snakex[0] + 25;
        if (Snakex[0] > 850) //如果蛇头超出边界则结束游戏
        {
//                Snakex[0] = 25;
          User_keyboard.isFailed = true;
        }
        break;

      case "L":
        Snakex[0] = Snakex[0] - 25;
        if (Snakex[0] < 25) //如果蛇头超出边界则重置游戏
        {
//                Snakex[0] = 850;
          User_keyboard.isFailed = true;
        }
        break;
      case "U":
        Snakey[0] = Snakey[0] - 25;
        if (Snakey[0] < 75) //如果蛇头超出边界则重置游戏
        {
//                  Snakey[0] = 650;
          User_keyboard.isFailed = true;
        }
        break;
      case "D":
        Snakey[0] = Snakey[0] + 25;
        if (Snakey[0] > 670) //如果蛇头超出边界则重置游戏
        {
//                    Snakey[0] = 75;
          User_keyboard.isFailed = true;
        }
        break;

    }
  }
}
