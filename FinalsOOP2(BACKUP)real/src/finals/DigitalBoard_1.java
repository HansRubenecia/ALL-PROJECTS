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
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;

public class DigitalBoard_1 {
	String courseMenu;
	LocalTime time;
	DateTimeFormatter formatter;
	String formattedTime;
	int hour;
	int formattedHour;
	int minutes;
	JFrame frame;
	DecimalFormat df ;
	String formattedMinutes;

	public DigitalBoard_1()
	{
		frame = new JFrame();
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
		
		JButton adminButton = new JButton("ADMIN");
		adminButton.setBackground(Color.WHITE);
		adminButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
		panelNorth.add(adminButton);
		
		
		adminButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JFrame frame_Password = new JFrame();
				frame_Password.setTitle("");
				frame_Password.setSize(300,130);

				frame_Password.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame_Password.getContentPane().setLayout(new BorderLayout());
				
				JPanel panel_Password = new JPanel();
				frame_Password.getContentPane().add(panel_Password, BorderLayout.CENTER);
				panel_Password.setLayout(null);
				
				JLabel lblNewLabel_Password = new JLabel("PLEASE INPUT THE PASSWORD");
				lblNewLabel_Password.setFont(new Font("Segoe UI", Font.BOLD, 12));
				lblNewLabel_Password.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_Password.setBounds(35, -1, 207, 34);
				panel_Password.add(lblNewLabel_Password);
				
				JTextField textField_Password = new JTextField();
				textField_Password.setBounds(27, 28, 113, 29);
				panel_Password.add(textField_Password);
				textField_Password.setColumns(10);
				
				JLabel lblPleaseTryAgain = new JLabel("");
				lblPleaseTryAgain.setForeground(Color.RED);
				lblPleaseTryAgain.setHorizontalAlignment(SwingConstants.CENTER);
				lblPleaseTryAgain.setFont(new Font("Segoe UI", Font.BOLD, 12));
				lblPleaseTryAgain.setBounds(53, 66, 179, 15);
				panel_Password.add(lblPleaseTryAgain);
				
				JButton btnNewButton_Password = new JButton("CONFIRM");
				btnNewButton_Password.setFont(new Font("Segoe UI", Font.BOLD, 11));
				btnNewButton_Password.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						if(textField_Password.getText().equals("admin123"))
						{
							
							frame_Password.setVisible(false);
							frame.setVisible(false);
							new DigitalBoard_2();
						}
						else
						{
							lblPleaseTryAgain.setText("INCORRECT PASSWORD");
							
						}
					}
				});
				btnNewButton_Password.setBounds(155, 30, 89, 23);
				panel_Password.add(btnNewButton_Password);
				
				
				frame_Password.setVisible(true);
				frame_Password.setLocationRelativeTo(null);
				
				
				
			
				
				
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
		panelCenterN_N.setPreferredSize(new Dimension(480,150));
		panelCenterN.add(panelCenterN_N,BorderLayout.NORTH);
		
		JPanel panelCenterN_S = new JPanel();
		panelCenterN_S.setBackground(Color.PINK);
		panelCenterN_S.setPreferredSize(new Dimension(480,210));
		panelCenterN.add(panelCenterN_S,BorderLayout.SOUTH);
		
		JPanel panelCenterS = new JPanel();
		panelCenterS.setBackground(Color.PINK);
		panelCenterS.setPreferredSize(new Dimension(0, 380));
		panelCenter.add(panelCenterS,BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("PRESS ANYWHERE TO CONTINUE ");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		panelCenterS.add(lblNewLabel);

		JLabel timeLabel = new JLabel();
		timeLabel.setFont(new Font("Segoe UI", Font.BOLD, 23));
		panelCenterN_S.add(timeLabel);
		
        Timer t = new Timer(500, new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) 
           {
        	courseMenu ="";
       		time = LocalTime.now();
       		formatter = DateTimeFormatter.ofPattern("a");
       		formattedTime=time.format(formatter);
       		hour = time.getHour();
       		formattedHour = hour;
       		minutes = time.getMinute();
       		
       		DecimalFormat df = new DecimalFormat("00");
       		String formattedMinutes = df.format(minutes);

       		
       		if (hour >12) 
       		{
       			formattedHour = hour%12;
       		}
       		if (hour>= 6 && hour< 10)
       		{
       			courseMenu ="Breakfast";
       		}
       		if (hour>= 10 && hour< 17)
       		{
       			courseMenu ="Lunch";
       		}
       		if (hour>= 17 && hour< 22)
       		{
       			courseMenu ="Dinner";
       		}
       		if(hour >=6 || hour <22) 
       		{
       			timeLabel.setText(
               		 "<html>Current time: " +formattedHour + ":" + formattedMinutes +formattedTime  + " <br/> We are currently serving: " + courseMenu + "<html>");
       			lblNewLabel.setText("PRESS ANYWHERE TO CONTINUE ");
       		}   		
             if(hour <6 || hour >=22)	
             {
            	 timeLabel.setText(
                		 "<html>Current time: " +formattedHour + ":" + formattedMinutes +formattedTime  + " <br/> <br/> We are currently out of service <br/> please wait or come back until 6:00AM<html>");
            	 lblNewLabel.setText("");
             }
  
           }
        });
        t.setRepeats(true);
        t.setCoalesce(true);
        t.setInitialDelay(0);
        t.start();
		
        panelCenter.addMouseListener(new MouseListener() 
  		{

  			@Override
  			public void mouseClicked(MouseEvent e) 
  			{
  				frame.setVisible(false);
  				
  				if (hour>= 6 && hour< 10)
  				{
  					
  					try {
  						new DigitalBoard_7();
  						frame.setVisible(false);
  					} catch (IOException e1) {
  						// TODO Auto-generated catch block
  						e1.printStackTrace();
  					}
  				}
  				if (hour>= 10 && hour< 17)
  				{
  					try {
  						new DigitalBoard_8();
  					} catch (IOException e1) {
  						// TODO Auto-generated catch block
  						e1.printStackTrace();
  					}
  				}
  				if (hour>= 17 && hour< 22)
  				{
  					try {
  						new DigitalBoard_9();
  					} catch (IOException e1) {
  						// TODO Auto-generated catch block
  						e1.printStackTrace();
  					}
  				}
  				
  				
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
