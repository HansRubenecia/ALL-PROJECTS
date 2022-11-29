package finals;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class DigitalBoard_2 {

	
	public DigitalBoard_2()
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
		
		JButton adminButton = new JButton("BACK");
		adminButton.setBackground(Color.WHITE);
		adminButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
		panelNorth.add(adminButton);
		
		adminButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				frame.setVisible(false);
				new DigitalBoard_1();
			}
		});

		
		JPanel panelSouth = new JPanel();
		panelSouth.setBackground(Color.LIGHT_GRAY);
		panelSouth.setPreferredSize(new Dimension(0,50));
		frame.getContentPane().add(panelSouth,BorderLayout.SOUTH);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setBackground(Color.PINK);
		panelNorth.setPreferredSize(new Dimension(50,50));
		frame.getContentPane().add(panelCenter,BorderLayout.CENTER);
		panelCenter.setLayout(new BorderLayout());
		
		JPanel panelCenterN = new JPanel();
		panelCenterN.setBackground(Color.PINK);
		panelCenterN.setPreferredSize(new Dimension(0,330));
		panelCenter.add(panelCenterN,BorderLayout.NORTH);
		
		JPanel panelCenterN_N = new JPanel();
		panelCenterN_N.setBackground(Color.PINK);
		panelCenterN_N.setPreferredSize(new Dimension(480, 120));
		panelCenterN.add(panelCenterN_N,BorderLayout.NORTH);
		panelCenterN_N.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("WHICH TIME SLOT WOULD YOU LIKE TO ADD/REMOVE AN ITEM?");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelCenterN_N.add(lblNewLabel, BorderLayout.SOUTH);
		
		JPanel panelCenterN_S = new JPanel();
		panelCenterN_S.setBackground(Color.PINK);
		panelCenterN_S.setPreferredSize(new Dimension(480,210));
		panelCenterN.add(panelCenterN_S,BorderLayout.SOUTH);
		panelCenterN_S.setLayout(new BoxLayout(panelCenterN_S, BoxLayout.X_AXIS));
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(Color.PINK);
		panelCenterN_S.add(panelLeft);
		panelLeft.setLayout(null);
		
		JButton btnNewButton = new JButton("BREAKFAST");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				frame.setVisible(false);
				try {
					new DigitalBoard_3();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(55, 23, 150, 150);
		panelLeft.add(btnNewButton);
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
		
		
		JPanel panelLeft_5 = new JPanel();
		panelLeft_5.setPreferredSize(new Dimension(100,100));
		
		JPanel panelRight = new JPanel();
		panelRight.setBackground(Color.PINK);
		panelCenterN_S.add(panelRight);
		panelRight.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("LUNCH");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				frame.setVisible(false);
				try {
					new DigitalBoard_4();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(38, 23, 150, 150);
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		panelRight.add(btnNewButton_1);
		
		
		
		JPanel panelCenterS = new JPanel();
		panelCenterS.setBackground(Color.PINK);
		panelCenterS.setPreferredSize(new Dimension(0, 380));
		panelCenter.add(panelCenterS,BorderLayout.SOUTH);
		panelCenterS.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("DINNER");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener()
{
			public void actionPerformed(ActionEvent e) 
			{
				frame.setVisible(false);
				try {
					new DigitalBoard_5();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(160, 0, 150, 150);
		panelCenterS.add(btnNewButton_2);
		btnNewButton_2.setFont(new Font("Segoe UI", Font.BOLD, 18));
		
		
		
		
		
		
	}
}