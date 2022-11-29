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

public class DigitalBoard_10 {

	public DigitalBoard_10(ArrayList<String> checkoutListReceipt, int total,ArrayList<Integer>checkoutItemPriceList) throws IOException
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
		
		JButton adminButton = new JButton("BACK");
		adminButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
		panelNorth.add(adminButton);
		
		adminButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				frame.setVisible(false);
				try {
					new DigitalBoard_7();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
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
		panelCenter.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("PRESS HERE TO PROCEED");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_1.setBounds(0, 584, 464, 129);
		panelCenter.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 26, 464, 562);
		panelCenter.add(scrollPane);
		
		JLabel lblNewLabel_Receipt = new JLabel();
		lblNewLabel_Receipt.setText("<html>\r\n\r\n<head>\r\n    <title></title>\r\n</head>\r\n\r\n<body>\r\n    <p style=\"text-align: justify;\"><br></p>\r\n    <table>\r\n        <thead>\r\n            <tr>\r\n                <th scope=\"col\" style=\"width: 25.5605%;\">\r\n                    <div style=\"text-align: justify;\">Qty</div>\r\n                </th>\r\n                <th scope=\"col\" style=\"width: 38.1166%;\">\r\n                    <div style=\"text-align: justify;\">Item</div>\r\n                </th>\r\n                <th scope=\"col\" style=\"width: 36.3229%;\">\r\n                    <div style=\"text-align: justify;\">Price</div>\r\n                </th>\r\n            </tr>\r\n        </thead>\r\n        <colgroup>\r\n            <col>\r\n        </colgroup>\r\n        <colgroup>\r\n            <col span=\"2\" class=\"batman\">\r\n        </colgroup>\r\n        <colgroup>\r\n            <col span=\"2\" class=\"flash\">\r\n        </colgroup>");
		lblNewLabel_Receipt.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_Receipt.setToolTipText("set text\r\n");
		lblNewLabel_Receipt.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_Receipt.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNewLabel_Receipt.setBackground(Color.WHITE);
		
		HashSet<String> hset = new HashSet<String>(checkoutListReceipt);
		
		ArrayList<String> listHset = new ArrayList<String>(hset);
		int[] listHsetPrice = new int[hset.size()];
		
		for(int a = 0; a<hset.size(); a++)
		{
			for (int b = 0; b < checkoutListReceipt.size();b++)
			{
				if(listHset.get(a) == checkoutListReceipt.get(b))
				{
					listHsetPrice[a] = checkoutItemPriceList.get(b);
				}
			}
		}
		
		int i = 0;
		for (String temp : hset) 
		{
			
			lblNewLabel_Receipt.setText(lblNewLabel_Receipt.getText() + "<tbody>\r\n"
					+ "            <tr>\r\n"
					+ "                <td class=\"fr-cell-fixed \" style=\"width: 25.5605%;\">\r\n"
					+ "                    <div style=\"text-align: justify;\">"+"("+Collections.frequency(checkoutListReceipt, temp)+")"+"</div>\r\n"
					+ "                </td>\r\n"
					+ "                <td style=\"width: 38.1166%;\">\r\n"
					+ "                    <div style=\"text-align: justify;\">"+temp+"</div>\r\n"
					+ "                </td>\r\n"
					+ "                <td class=\"fr-cell-handler \" style=\"width: 36.3229%;\">\r\n"
					+ "                    <div style=\"text-align: justify;\">"+"("+listHsetPrice[i]*Collections.frequency(checkoutListReceipt, temp)+")"+"</div>\r\n"
					+ "                </td>\r\n"
					+ "            </tr>");
			i++;
		}
		lblNewLabel_Receipt.setText(lblNewLabel_Receipt.getText()+"</tr>\r\n"
				+ "            <tr>\r\n"
				+ "                <td style=\"width: 25.3333%;\"><br></td>\r\n"
				+ "                <td style=\"width: 37.7778%; text-align: right;\">Total:</td>\r\n"
				+ "                <td style=\"width: 36.3229%;\">"+"\u20B1"+total+"</td>\r\n"
				+ "            </tr>\r\n"
				+ "        </tbody>\r\n"
				+ "    </table>\r\n"
				+ "</body>\r\n"
				+ "\r\n"
				+ "</html>");
		scrollPane.setViewportView(lblNewLabel_Receipt);
		
		
		

		lblNewLabel_1.addMouseListener(new MouseListener() 
		{

			@Override
			public void mouseClicked(MouseEvent e) 
			{
				frame.setVisible(false);
				try {
					new DigitalBoard_11();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
