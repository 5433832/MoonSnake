import Mobile.Mobile;
import Userkey.User_keyboard;
import len.len;

public class suicide {
  //贪吃蛇吃掉自己身体后执行的方法
  public static void suicide() {
    for (int j = 1; j < len.len; j++)  //循环判断蛇头是否与蛇任何一格身体坐标一致
    {
      if (Mobile.Snakex[0] == Mobile.Snakex[j] && Mobile.Snakey[0] == Mobile.Snakey[j]) {
        User_keyboard.isFailed = true;
        break;
      }
    }
  }
}
