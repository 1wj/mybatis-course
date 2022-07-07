package cn.bj.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * 耕达 有关于容器的图形化界面
 */
public class wuguan {
    public static void main(String[] args) {

        try {
            int num= JOptionPane.showConfirmDialog(null,"请求控制对方电脑","最帅",JOptionPane.YES_NO_OPTION);
      /* if((num == JOptionPane.NO_OPTION) || (JOptionPane.CLOSED_OPTION)){
          return;
       }*/
            JOptionPane.showInputDialog("输入端口号","192.168.1.1");


            //创建一个容器
            JFrame jFrame=new JFrame("远程监控");
            jFrame.setSize(688,600);
            //设置窗口是否可见
            jFrame.setVisible(true);
            //点击关闭推出系统
            jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
            //设置窗口居中显示
            jFrame.setLocationRelativeTo(null);
            //设置是否zhiding
            jFrame.setAlwaysOnTop(true);

            //查询本机的系统
            Toolkit tk=Toolkit.getDefaultToolkit();
            //获取屏幕大小
            Dimension dm = tk.getScreenSize();

            // System.out.println(dm.getHeight());
            //设置一块面版
            JLabel imageLabel=new JLabel();
            jFrame.add(imageLabel);
            //创建一个机器人
            Robot robot=new Robot();
            //不停的截图
           /* while (true){

            }*/
            //创建Rectangle
            Rectangle rectangle=new Rectangle(0,0,(int)dm.getWidth()-jFrame.getWidth(),(int)dm.getHeight());
            //截图
            BufferedImage screenCapture = robot.createScreenCapture(rectangle);

            //将截图添加到容器中
            imageLabel.setIcon(new ImageIcon(screenCapture));
        } catch (AWTException e) {
            e.printStackTrace();
        }


    }
}
