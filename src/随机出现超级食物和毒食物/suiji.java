package 随机出现超级食物和毒食物;

import food.dufood;
import food.superfood;
import rand.rand;

public class suiji {
  public static int superfood_time;//超级食物求素数变量
  public static int dufood_time;
  public static int i = 1;//用此变量让第一次显示的超级食物只显示一次
  public static int idu = 1;  //同上不过是毒食物

  public static void suijisuperfood() {
    //超级食物显示false时进行下一轮素数计算为素数则将超级食物显示修改为true
    if (!superfood.superfood_look) {
      superfood_time = 1 + rand.rand.nextInt(98);//给一个随机数+1是因为防止给予0
      //求给的随机数是不是素数,是则出现超级食物，否则不出现
      for (int j = 2; j < superfood_time; j++) {
        if (superfood_time % j != 0) {
          if (j == superfood_time - 1) {
            superfood.superfood_look = true;
            break;
          }
        } else {
          break;
        }
      }
    }
  }

  public static void suijidufood() {
    //毒食物显示false时进行下一轮素数计算为素数则将超级食物显示修改为true
    if (!dufood.dufood_look) {
      dufood_time = 1 + rand.rand.nextInt(98);//给一个随机数+1是因为防止给予0
      //求给的随机数是不是素数,是则出现du食物，否则不出现
      for (int j = 2; j < dufood_time; j++) {
        if (dufood_time % j != 0) {
          if (j == dufood_time - 1) {
            dufood.dufood_look = true;
            break;
          }
        } else {
          break;
        }
      }
    }
  }
}
