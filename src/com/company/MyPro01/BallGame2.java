package com.company.MyPro01;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * @author �ƽ���
 */
public class BallGame2 extends JFrame{
	/**
	 * ͼƬ����
	 */
	Image ball = Toolkit.getDefaultToolkit().getImage("src/com/company/MyPro01/imges/images/ball.png");
	Image desk = Toolkit.getDefaultToolkit().getImage("src/com/company/MyPro01/imges/images/desk.jpg");

	/**
	 * С��ĺ�����
	 */
	double x = 100;
	/**
	 * С���������
	 */
	double y = 100;
	/**
	 * ���ȣ��˴���ʾ60��
	 */
	double degree = 3.14/3;

	/**
	 * �����ڷ���
	 * @param g
	 */
	@Override
	public void paint(Graphics g) {
		System.out.println("���ڱ�����һ��");
		//�Ȼ������ٻ���
		g.drawImage(desk, 0, 0, null);
		g.drawImage(ball, (int)x, (int)y, null);
		
		x = x + 10*Math.cos(degree);
		y = y + 10*Math.sin(degree);
		
		//�������±߽�
		if(y > 430 || y < 80) {
			degree = -degree;
		}
		
		//�������ұ߽�
		if(x < 0 || x > 880) {
			degree = 3.14-degree;
		}
		
	}

	/**
	 * ���ڼ���
	 */
	void lanceFrame() {
		//���ڵĴ�С��300*300
		setSize(856,500);
		//���ھ���Ļ���Ͻǵ�λ�ã�50*50
		setLocation(50,50);
		//�Ƿ�ɼ�
		setVisible(true);
		
		//�ػ�����
		while(true) {
			repaint();
			try {
				//40ms��1s=1000ms
				Thread.sleep(40);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Ԣ�����֣�");
		BallGame2 game = new BallGame2();
		game.lanceFrame();
		
	}
}
