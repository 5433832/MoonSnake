package Userkey;

import BGM.BGM;
import initsnake.initsnake;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class User_keyboard extends JPanel {
  public static boolean isStarted = false;  //定义一个布尔值来表示和控制游戏启动状态
  public static boolean isFailed = false;  //添加一个变量判断是否已经输掉游戏
  public static int j = 1;//用此变量让显示的"开始游戏"只在第一次和贪吃蛇死后才显示
  public static String fx = "R";//定义蛇头方向：R,L,U,D


  public static void User_keyboard(int keyCode) {
    switch (keyCode) {
      case KeyEvent.VK_ESCAPE:  //按下esc键后初始化整个游戏
        isStarted = false;    //游戏启动状态恢复为假
        isFailed = false;  //游戏结束状态恢复为假
        BGM.stopBGM();
        initsnake.initSnake();   //引用初始化方法
//        repaint();  //重绘画布
        j = 1;

        break;
      case KeyEvent.VK_SPACE:   //判断键盘事件中的数值是否等于keyEvent类中VK_SPACE(表示空格键)的值
        j = 0;
        if (!isFailed)  //判断游戏结束是否为假，为真则不再能进行空格暂停
        {
          isStarted = !isStarted;   //取反值如果本来是true就变成false反之
        }
        //判断游戏启动状态为真则播放bgm否则停止bgm
        if (isStarted) {
          BGM.playBGM();
        } else {
          BGM.stopBGM();
        }
        break;
      case KeyEvent.VK_A: //判断键盘事件中的数值是否等于keyEvent类中VK_A的值,等于则将fx值设为L

        if (fx != "R") //判断蛇是否在往相反方向移动如果为真则不执行用户按键事件
        {
          fx = "L";
        }
        break;
      case KeyEvent.VK_D:
        if (fx != "L") {
          fx = "R";
        }
        break;
      case KeyEvent.VK_W:
        if (fx != "D") {
          fx = "U";
        }
        break;

      case KeyEvent.VK_S:
        if (fx != "U") {
          fx = "D";
        }
        break;
    }
  }
}
