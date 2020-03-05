package com.company.MyPro01;

import java.awt.*;
import javax.swing.*;

/**
 * С����Ϸ1
 * @author �ƽ���
 */
public class BallGame extends JFrame {

	/**
	 * ͼƬ����
	 */
	Image ball = Toolkit.getDefaultToolkit().getImage("src/com/company/MyPro01/imges/images/ball.png");
	Image desk = Toolkit.getDefaultToolkit().getImage("src/com/company/MyPro01/imges/images/desk.jpg");

	/**
	 * С�������
	 */
	double x = 100;
	/**
	 * С���������
	 */
	double y = 100;
	/**
	 * ����
	 */
	boolean right = true;


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
		BallGame game = new BallGame();
		game.lanceFrame();
		
	}
}
