import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class CoinFlipTest extends JFrame{
	
	public CoinFlipTest() {
		super("Flipping Coins");
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridLayout(5, 1));
		for(int i=0; i<5; i++) {
			JLabel label = new JLabel("Label " + i);
			label.setFont(new Font("SansSerif", Font.PLAIN, 60));
			contentPane.add(label);
			System.out.println(label.getText());
		}
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// Exercise no 1
		ExecutorService taskList = Executors.newFixedThreadPool(5);
		taskList.execute(new CoinFlip());
		taskList.execute(new CoinFlip());
		taskList.execute(new CoinFlip());
		taskList.execute(new CoinFlip());
		taskList.execute(new CoinFlip());
		taskList.shutdown();
		
		//Exercise no 2
		new CoinFlip2();
		
		//Exercise no 3
		new CoinFlipTest();
		
		
	}

}
