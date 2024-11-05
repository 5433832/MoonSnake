package initsnake;

import BGM.*;
import Mobile.Mobile;
import Userkey.User_keyboard;
import food.food;
import len.len;
import rand.rand;
import score.score;

public class initsnake {
  //贪吃蛇初始化方法
  public static void initSnake() {  //定义贪吃蛇初始化方法
    len.len = 3;  //定义初始化长度
    Mobile.Snakex[0] = 100;  //初始化蛇头x坐标
    Mobile.Snakey[0] = 100; //初始化蛇头y坐标
    Mobile.Snakex[1] = 75;  //初始化蛇身1x坐标
    Mobile.Snakey[1] = 100;  //初始化蛇身1y坐标
    Mobile.Snakex[2] = 50;  //初始化蛇身2x坐标
    Mobile.Snakey[2] = 100;  //初始化蛇身2y坐标
    User_keyboard.fx = "R"; //初始化蛇头方向
    food.foodx = 25 + 25 * rand.rand.nextInt(34);//重新分配食物坐标
    food.foody = 75 + 25 * rand.rand.nextInt(24);
    score.score = 0;//将分数初始化
    BGM.loadBGM();//加载背景音乐
    failedmusic.loadfailed();//加载失败音乐
    foodmusic.loadfood();//加载吃食物音乐
    dufoodmusic.loaddufood();//加载吃到毒食物的音乐
    superfoodmusic.loadsuperfood();//加载吃到超级食物的音乐
  }
}
