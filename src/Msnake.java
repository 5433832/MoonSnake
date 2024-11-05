import javax.swing.*;

/*
存在问题：
1.    定义输入流变量 获取当前类.获取当前类加载器（加载器可以在当前项目文件夹寻找指定资源）.获取要找的资源的路径（“路径”）赋值给is
      InputStream is = this.getClass().getClassLoader().getResourceAsStream("res/sound/bgm2.wav");
      这条方法找不到res/sound/下的文件会报空指针错误null；只支持在src目录下（同时这条方法不支持mp3文件）

 */
public class Msnake {
  public static void main(String[] args) {
    JFrame frame = new JFrame(); //创建一个无标题窗口
    frame.setBounds(10, 10, 900, 720);//设置窗口在windows窗口内的位置和宽高
    frame.setResizable(false);//禁止用户手动拖动改变窗口大小
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//当用户点击右上角×时，游戏窗口进行关闭退出
    frame.add(new MPanel());//在窗口上面增加一层画布
    frame.setVisible(true);//设置窗口显示


  }
}
