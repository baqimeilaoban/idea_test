package com.company.MyPro01;

import java.awt.*;
import javax.swing.*;

/**
 * 小球游戏1
 * @author 黄建波
 */
public class BallGame extends JFrame {

	/**
	 * 图片加载
	 */
	Image ball = Toolkit.getDefaultToolkit().getImage("src/com/company/MyPro01/imges/images/ball.png");
	Image desk = Toolkit.getDefaultToolkit().getImage("src/com/company/MyPro01/imges/images/desk.jpg");

	/**
	 * 小球横坐标
	 */
	double x = 100;
	/**
	 * 小球的纵坐标
	 */
	double y = 100;
	/**
	 * 方向
	 */
	boolean right = true;


	/**
	 * 画窗口方法
	 * @param g
	 */
	@Override
	public void paint(Graphics g) {
		System.out.println("窗口被画了一次");
		//先画桌面再画球
		g.drawImage(desk, 0, 0, null);
		g.drawImage(ball, (int)x, (int)y, null);
		
		if(right) {
			x = x + 10;
		}else {
			x = x - 10;
		}
		
		if(x > 780) {
			right = false;
		}
		
		if(x < 40) {
			right = true;
		}
	}

	/**
	 * 窗口加载
	 */
	void lanceFrame() {
		//窗口的大小，300*300
		setSize(856,500);
		//窗口距屏幕左上角的位置，50*50
		setLocation(50,50);
		//是否可见
		setVisible(true);
		
		//重画窗口
		while(true) {
			repaint();
			try {
				//40ms，1s=1000ms
				Thread.sleep(40);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("寓教于乐！");
		BallGame game = new BallGame();
		game.lanceFrame();
		
	}
}
