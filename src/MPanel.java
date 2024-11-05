import BGM.BGM;
import BGM.dufoodmusic;
import BGM.failedmusic;
import BGM.superfoodmusic;
import Mobile.Mobile;
import Userkey.User_keyboard;
import food.dufood;
import food.food;
import food.superfood;
import initsnake.initsnake;
import len.len;
import rand.rand;
import score.score;
import 贪吃蛇头部图片和标题图片.title_snakehead_img;
import 随机出现超级食物和毒食物.suiji;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MPanel extends JPanel implements KeyListener, ActionListener {
  /*
  继承JPanel类
  继承keylistener接口使MPanel获得可以使用监听器的能力，使用keylistener接口需要有固定方法
  继承ActionListener接口使MPanel获得可以使用定时器的能力，使用ActionListener接口需要有固定方法
   */


  Timer timer = new Timer(200, this); //设置一个定时器指定时候后找到了之后找自己

  public MPanel() {
    initsnake.initSnake();//调用初始化方法
    this.setFocusable(true);//设置具备获取焦点的能力这样也就可以获取键盘事件
    this.addKeyListener(this);//给自己注册一个键盘监听器
    timer.start();//启动定时器
  }

  public void paintComponent(Graphics g) {  //定义一个公共画布组件（并传入一支画笔）
    super.paintComponent(g);  //调用父类方法进行界面重绘
    this.setBackground(Color.WHITE);  //设置背景色
    title_snakehead_img.title.paintIcon(this, g, 25, 11); //设置标题图片属性（画在哪里（this表示当前），使用画笔（g），x值，y值）
    g.fillRect(25, 75, 850, 600);//使用画笔（g）进行填充一个矩形（x，y，宽，高）
    food.foodimg.paintIcon(this, g, food.foodx, food.foody);
    if (len.len > 8)  //如果蛇长度大于8则开始出现超级食物和毒食物
    {
      //调用随机类的随机超级食物方法计算结果为true还是false
      suiji.suijisuperfood();
      //超级食物显示为true时显示超级食物
      if (superfood.superfood_look) {
        if (suiji.i == 1) {   //i为1表示开始为超级食物初始坐标后续分配完毕后将i复位0不在执行
          superfood.superfoodx = 25 + 25 * rand.rand.nextInt(34);
          superfood.superfoody = 75 + 25 * rand.rand.nextInt(24);
          suiji.i = 0;
        }
        superfoodmusic.superfood.paintIcon(this, g, superfood.superfoodx, superfood.superfoody);
      }
      //调用随机类的随机毒食物方法计算结果为true还是false
      suiji.suijidufood();
      // 结果为true时显示毒食物
      if (dufood.dufood_look) {
        if (suiji.idu == 1) {   //i为1表示开始为毒食物初始坐标后续分配完毕后将i复位0不在执行
          dufood.dufoodx = 25 + 25 * rand.rand.nextInt(34);
          dufood.dufoody = 75 + 25 * rand.rand.nextInt(24);
          suiji.idu = 0;
        }
//        渲染毒食物图片
        dufoodmusic.dufood.paintIcon(this, g, dufood.dufoodx, dufood.dufoody);
      }
    }
    //初始渲染
    switch (User_keyboard.fx) {
      case "D":
        title_snakehead_img.down.paintIcon(this, g, Mobile.Snakex[0], Mobile.Snakey[0]);
        break;
      case "R":
        title_snakehead_img.right.paintIcon(this, g, Mobile.Snakex[0], Mobile.Snakey[0]);
        break;
      case "L":
        title_snakehead_img.left.paintIcon(this, g, Mobile.Snakex[0], Mobile.Snakey[0]);
        break;
      case "U":
        title_snakehead_img.up.paintIcon(this, g, Mobile.Snakex[0], Mobile.Snakey[0]);
        break;
    }
    for (int i = 1; i < len.len; i++) {//初始渲染贪吃蛇身体
      title_snakehead_img.body.paintIcon(this, g, Mobile.Snakex[i], Mobile.Snakey[i]);
    }

    g.setColor(Color.WHITE);//设置画笔颜色
    g.setFont(new Font("宋体", Font.BOLD, 13));//设置字体，是否加粗，大小
    g.drawString("按下空格键暂停/继续", 700, 25);//设置提示语
    g.drawString("按下Esc键重新开始游戏", 700, 38);
    if (!User_keyboard.isStarted)  //如果游戏未启动则显示主标题提示语
    {
      if (User_keyboard.j == 1) {
        g.setColor(Color.WHITE);//设置画笔颜色
        g.setFont(new Font("宋体", Font.BOLD, 40));//设置字体，是否加粗，大小
        g.drawString("按下空格键开始游戏!", 300, 300);//设置提示语
        g.setColor(Color.WHITE);//设置画笔颜色
      }
    }

    if (!User_keyboard.isFailed)//游戏没结束就一直显示分数提示语
    {
      g.setColor(Color.WHITE);//设置画笔颜色
      g.setFont(new Font("宋体", Font.BOLD, 13));//设置字体，是否加粗，大小
      g.drawString("分数：" + score.score, 50, 25);//设置提示语
      g.drawString("长度：" + len.len, 50, 38);
    }
    //将按键提醒始终显示
    g.setColor(Color.WHITE);//设置画笔颜色
    g.setFont(new Font("宋体", Font.BOLD, 13));//设置字体，是否加粗，大小
    g.drawString("W：上;A：左;S：下;D：右", 700, 56);
    if (User_keyboard.isFailed)  //如果游戏结束为真提示用户重新开始游戏并播放失败音乐和停止背景音乐
    {
      BGM.stopBGM();
      failedmusic.playerfailed();
      g.setColor(Color.RED);//设置画笔颜色
      g.setFont(new Font("宋体", Font.BOLD, 40));//设置字体，是否加粗，大小
      g.drawString("游戏结束！！！", 250, 200);//设置提示语
      g.drawString("按下Esc重新开始游戏", 250, 300);//设置提示语
      g.drawString("这场游戏得分：" + score.score, 250, 400);//设置提示语
      g.drawString("这场贪吃蛇长度：" + len.len, 250, 500);//设置提示语
    }
  }

//  必须有以下三个方法才可以使用KeyListener监听器（必须有三个方法但不一定要写其功能）

  /**
   * @param e the event to be processed
   */
  @Override
  public void keyTyped(KeyEvent e) {   //按下按键

  }

  /**
   * @param e the event to be processed
   */
  @Override
  //如果isStarted为false；按下空格后将画面进行重绘并进入游戏同时将启动状态更新
  public void keyPressed(KeyEvent e) {   //将按键按到底； KeyEvent e的意思是键盘事件
    int keyCode = e.getKeyCode();  //定义变量利用getKeyCode获取键盘事件e中的键码赋值给keycode
    User_keyboard.User_keyboard(keyCode);//将获取到的按键作为形参传入用户键盘事件方法
//    如果用户按下的esc键则执行一次重绘
    if (keyCode == KeyEvent.VK_ESCAPE) {
      repaint();
    }
  }

  /**
   * @param e the event to be processed
   */
  @Override
  public void keyReleased(KeyEvent e) {   //松开按键


  }
//  必须有以下方法才可以使用定时器

  /**
   * @param e the event to be processed
   */
  @Override
  public void actionPerformed(ActionEvent e) {   //定时器到点后执行
    if (User_keyboard.isStarted && !User_keyboard.isFailed)//如果isStarted为true则蛇前进，以此实现游戏暂停
    {
      Mobile.Snake_Mobile();//调用贪吃蛇移动方法
      food.food();//吃掉普通食物调用的方法
      superfood.superfood();//吃掉超级食物调用的方法
      dufood.dufood();//吃掉毒食物调用的方法
      suicide.suicide();//吃掉自己身体后执行的方法
      repaint();//重绘画布方法
    }
    timer.start();//重新启动定时器以此来进行循环使贪吃蛇每一百毫秒更新一次
  }
}
