package finals;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class DigitalBoard_6 {

	
	public DigitalBoard_6()
	{
		JFrame frame = new JFrame();
		frame.setTitle("Self Ordering Digital Board\r\n");
		frame.setSize(480,852);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setVisible(true);
		
		JPanel panelNorth = new JPanel();
		panelNorth.setBackground(Color.LIGHT_GRAY);
		panelNorth.setPreferredSize(new Dimension(480,50));
		frame.getContentPane().add(panelNorth,BorderLayout.NORTH);
		panelNorth.setLayout(new BoxLayout(panelNorth, BoxLayout.X_AXIS));

		JPanel panelSouth = new JPanel();
		panelSouth.setBackground(Color.LIGHT_GRAY);
		panelSouth.setPreferredSize(new Dimension(0,50));
		frame.getContentPane().add(panelSouth,BorderLayout.SOUTH);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setBackground(Color.PINK);
		panelNorth.setPreferredSize(new Dimension(50,50));
		frame.getContentPane().add(panelCenter,BorderLayout.CENTER);
		panelCenter.setLayout(new BorderLayout());
		
		panelCenter.addMouseListener(new MouseListener() 
		{

			@Override
			public void mouseClicked(MouseEvent e) 
			{
				frame.setVisible(false);
				new DigitalBoard_1();
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JPanel panelCenterN = new JPanel();
		panelCenterN.setBackground(Color.PINK);
		panelCenterN.setPreferredSize(new Dimension(0,330));
		panelCenter.add(panelCenterN,BorderLayout.NORTH);
		
		
		JPanel panelCenterN_N = new JPanel();
		panelCenterN_N.setBackground(Color.PINK);
		panelCenterN_N.setPreferredSize(new Dimension(480,150));
		panelCenterN.add(panelCenterN_N,BorderLayout.NORTH);
		
		JPanel panelCenterN_S = new JPanel();
		panelCenterN_S.setBackground(Color.PINK);
		panelCenterN_S.setPreferredSize(new Dimension(480,210));
		panelCenterN.add(panelCenterN_S,BorderLayout.SOUTH);
		
		JLabel label = new JLabel("CHANGES IN THE MENU HAS BEEN MADE ");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Segoe UI", Font.BOLD, 20));
		panelCenterN_S.add(label);
		
		JPanel panelCenterS = new JPanel();
		panelCenterS.setBackground(Color.PINK);
		panelCenterS.setPreferredSize(new Dimension(0, 380));
		panelCenter.add(panelCenterS,BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("PRESS ANYWHERE TO CONTINUE ");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		panelCenterS.add(lblNewLabel);
		
		
		
	}

}
