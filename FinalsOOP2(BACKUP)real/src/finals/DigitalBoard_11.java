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
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.JScrollPane;

public class DigitalBoard_11 {


	public DigitalBoard_11() throws IOException
	{
		JFrame frame = new JFrame();
		frame.setTitle("Self Ordering Digital Board\r\n");
		frame.setSize(480,852);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
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
		panelCenter.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("<html>\r\n<head>\r\n<style>\r\nh1 {text-align: center;}\r\np {text-align: center;}\r\ndiv {text-align: center;}\r\n</style>\r\n</head>\r\n<body>\r\n\r\n<h1>THANK YOU  FOR ORDERING </h1>\r\n<p>HAVE A NICE DAY</p>\r\n<div></div>\r\n\r\n</body>\r\n</html>");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_1.setBounds(0, 147, 464, 213);
		panelCenter.add(lblNewLabel_1);
		
		
		

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
		
	}
}
