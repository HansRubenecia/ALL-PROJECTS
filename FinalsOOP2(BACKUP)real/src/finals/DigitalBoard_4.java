package finals;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DigitalBoard_4 {
	private JTextField textField_Item;
	private JTextField textField_Item_1;
	private JTextField textField_Item_2;
	private JTextField textField_Item_3;
	private JTextField textField_Price;
	private JTextField textField_Price_1;
	private JTextField textField_Price_2;
	private JTextField textField_Price_3;


	public DigitalBoard_4() throws IOException 
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
				new DigitalBoard_2();
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
		panelCenterN.setPreferredSize(new Dimension(0, 365));
		panelCenter.add(panelCenterN,BorderLayout.NORTH);
		
		JPanel panelCenterN_N = new JPanel();
		panelCenterN_N.setBackground(Color.PINK);
		panelCenterN_N.setPreferredSize(new Dimension(480, 120));
		panelCenterN.add(panelCenterN_N,BorderLayout.NORTH);
		panelCenterN_N.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MEAL W/ RICE");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 81, 23);
		panelCenterN_N.add(lblNewLabel);
		
		textField_Item = new JTextField();
		textField_Item.setBounds(95, 12, 71, 20);
		panelCenterN_N.add(textField_Item);
		textField_Item.setColumns(10);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(74, 53, 355, 54);
		panelCenterN_N.add(scrollPane);
		
		JList list = new JList();
		list.setFont(new Font("Segoe UI", Font.BOLD, 11));
		scrollPane.setViewportView(list);
		
		
		lunchMenuList i = new lunchMenuList();
		i.readList();
		i.readPriceList();
		
		DefaultListModel model = new DefaultListModel();
		int size = i.riceMealList.size();
		
		for (int a = 0; a< size; a++)
		{
			model.addElement(i.riceMealList.get(a)+","+i.riceMealPriceList.get(a));
			
		}
		list.setModel(model);
		
		
		JButton btnNewButton_2 = new JButton("ADD");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(textField_Item.getText().trim().isEmpty() == false && textField_Price.getText().trim().isEmpty() == false)
				{
					model.addElement(textField_Item.getText()+","+textField_Price.getText());
					list.setModel(model);
				}
				else
				{
					new ErrorTextField();
				}
				textField_Item.setText("");
				textField_Price.setText("");

				
			}
		});
		btnNewButton_2.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnNewButton_2.setBounds(258, 11, 89, 23);
		panelCenterN_N.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("REMOVE");
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				model.removeElementAt(list.getSelectedIndex());
			}
		});
		btnNewButton_3.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnNewButton_3.setBounds(357, 11, 89, 23);
		panelCenterN_N.add(btnNewButton_3);
		
		textField_Price = new JTextField();
		textField_Price.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) 
			{
				char c = e.getKeyChar();
				if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) 
				{
					e.consume();
				}
			}
		});
		textField_Price.setColumns(10);
		textField_Price.setBounds(174, 12, 71, 20);
		panelCenterN_N.add(textField_Price);
		
		JLabel lblNewLabel_1 = new JLabel("ITEM");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(93, 36, 73, 14);
		panelCenterN_N.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PRICE");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(174, 36, 73, 14);
		panelCenterN_N.add(lblNewLabel_1_1);
		
		JPanel panelCenterN_S = new JPanel();
		panelCenterN_S.setBackground(Color.PINK);
		panelCenterN_S.setPreferredSize(new Dimension(480, 240));
		panelCenterN.add(panelCenterN_S,BorderLayout.SOUTH);
		panelCenterN_S.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCenterN_S_N = new JPanel();
		panelCenterN_S.add(panelCenterN_S_N, BorderLayout.NORTH);
		panelCenterN_S_N.setPreferredSize(new Dimension(0, 120));
		panelCenterN_S_N.setBackground(Color.PINK);
		panelCenterN_S_N.setLayout(null);
		
		JLabel lblSides = new JLabel("SIDES");
		lblSides.setHorizontalAlignment(SwingConstants.CENTER);
		lblSides.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblSides.setBounds(10, 11, 81, 23);
		panelCenterN_S_N.add(lblSides);
		
		textField_Item_1 = new JTextField();
		textField_Item_1.setColumns(10);
		textField_Item_1.setBounds(95, 12, 71, 20);
		panelCenterN_S_N.add(textField_Item_1);
	
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(72, 55, 355, 54);
		panelCenterN_S_N.add(scrollPane_1);
		
		JList list_1 = new JList();
		list_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		scrollPane_1.setViewportView(list_1);
		
		DefaultListModel model_1 = new DefaultListModel();
		size = i.sidesList.size();
		
		for (int a = 0; a< size; a++)
		{
			model_1.addElement(i.sidesList.get(a)+","+i.sidesPriceList.get(a));
		}
		list_1.setModel(model_1);
		
		JButton btnNewButton_4 = new JButton("ADD");
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(textField_Item_1.getText().trim().isEmpty() == false && textField_Price_1.getText().trim().isEmpty() == false)
				{
					model_1.addElement(textField_Item_1.getText()+","+textField_Price_1.getText());
					list_1.setModel(model_1);
				}
				else
				{
					new ErrorTextField();
				}
				textField_Item_1.setText("");
				textField_Price_1.setText("");
			}
		});
		btnNewButton_4.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnNewButton_4.setBounds(258, 11, 89, 23);
		panelCenterN_S_N.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("REMOVE");
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				model_1.removeElementAt(list_1.getSelectedIndex());
			}
		});
		btnNewButton_5.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnNewButton_5.setBounds(357, 11, 89, 23);
		panelCenterN_S_N.add(btnNewButton_5);
		
		textField_Price_1 = new JTextField();
		textField_Price_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) 
			{
				char c = e.getKeyChar();
				if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) 
				{
					e.consume();
				}
			}
		});
		textField_Price_1.setColumns(10);
		textField_Price_1.setBounds(174, 12, 71, 20);
		panelCenterN_S_N.add(textField_Price_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("ITEM");
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setBounds(93, 36, 73, 14);
		panelCenterN_S_N.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("PRICE");
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setBounds(174, 36, 73, 14);
		panelCenterN_S_N.add(lblNewLabel_1_1_1);
		
		JPanel panelCenterN_S_S = new JPanel();
		panelCenterN_S.add(panelCenterN_S_S, BorderLayout.SOUTH);
		panelCenterN_S_S.setPreferredSize(new Dimension(0, 120));
		panelCenterN_S_S.setBackground(Color.PINK);
		panelCenterN_S_S.setLayout(null);
		
		JLabel lblSides_1 = new JLabel("BEVERAGE");
		lblSides_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSides_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblSides_1.setBounds(18, 15, 81, 23);
		panelCenterN_S_S.add(lblSides_1);
		
		textField_Item_2 = new JTextField();
		textField_Item_2.setColumns(10);
		textField_Item_2.setBounds(95, 12, 71, 20);
		panelCenterN_S_S.add(textField_Item_2);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(73, 45, 355, 54);
		panelCenterN_S_S.add(scrollPane_2);
		
		JList list_2 = new JList();
		list_2.setFont(new Font("Segoe UI", Font.BOLD, 11));
		scrollPane_2.setViewportView(list_2);
		
		DefaultListModel model_2 = new DefaultListModel();
		size = i.beverageList.size();
		
		for (int a = 0; a< size; a++)
		{
			model_2.addElement(i.beverageList.get(a)+","+i.beveragePriceList.get(a));
		}
		list_2.setModel(model_2);
		
		JButton btnNewButton_6 = new JButton("ADD");
		btnNewButton_6.setBackground(Color.WHITE);
		btnNewButton_6.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(textField_Item_2.getText().trim().isEmpty() == false && textField_Price_2.getText().trim().isEmpty() == false)
				{
					model_2.addElement(textField_Item_2.getText()+","+textField_Price_2.getText());
					list_2.setModel(model_2);
				}
				else
				{
					new ErrorTextField();
				}
				textField_Item_2.setText("");
				textField_Price_2.setText("");
			}
		});
		
		btnNewButton_6.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnNewButton_6.setBounds(266, 15, 89, 23);
		panelCenterN_S_S.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("REMOVE");
		btnNewButton_7.setBackground(Color.WHITE);
		btnNewButton_7.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				model_2.removeElementAt(list_2.getSelectedIndex());	
			}
		});
		btnNewButton_7.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnNewButton_7.setBounds(365, 15, 89, 23);
		panelCenterN_S_S.add(btnNewButton_7);
		
		textField_Price_2 = new JTextField();
		textField_Price_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) 
			{
				char c = e.getKeyChar();
				if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) 
				{
					e.consume();
				}
			}
		});
		textField_Price_2.setColumns(10);
		textField_Price_2.setBounds(174, 12, 71, 20);
		panelCenterN_S_S.add(textField_Price_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("ITEM");
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setBounds(93, 32, 73, 14);
		panelCenterN_S_S.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("PRICE");
		lblNewLabel_1_1_2.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setBounds(174, 32, 73, 14);
		panelCenterN_S_S.add(lblNewLabel_1_1_2);

		JPanel panelCenterS = new JPanel();
		panelCenterS.setBackground(Color.PINK);
		panelCenterS.setPreferredSize(new Dimension(0, 350));
		panelCenter.add(panelCenterS,BorderLayout.SOUTH);
		panelCenterS.setLayout(new BorderLayout(0, 0));
		panelCenterS.setPreferredSize(new Dimension(0, 350));
		panelCenterS.setBackground(Color.PINK);
		
		JPanel panelCenterS_N = new JPanel();
		panelCenterS_N.setBackground(Color.PINK);
		panelCenterS.add(panelCenterS_N, BorderLayout.NORTH);
		panelCenterS_N.setPreferredSize(new Dimension(0, 120));
		panelCenterS_N.setLayout(null);
		
		JLabel lblSides_1_1 = new JLabel("DESSERTS");
		lblSides_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSides_1_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblSides_1_1.setBounds(10, 11, 81, 23);
		panelCenterS_N.add(lblSides_1_1);
		
		textField_Item_3 = new JTextField();
		textField_Item_3.setColumns(10);
		textField_Item_3.setBounds(95, 12, 71, 20);
		panelCenterS_N.add(textField_Item_3);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(66, 51, 355, 54);
		panelCenterS_N.add(scrollPane_3);
		
		JList list_3 = new JList();
		list_3.setFont(new Font("Segoe UI", Font.BOLD, 11));
		scrollPane_3.setViewportView(list_3);
		
		DefaultListModel model_3 = new DefaultListModel();
		size = i.dessertsList.size();
		
		for (int a = 0; a< size; a++)
		{
			model_3.addElement(i.dessertsList.get(a)+","+i.dessertsPriceList.get(a));
		}
		list_3.setModel(model_3);
		
		JButton btnNewButton_8 = new JButton("ADD");
		btnNewButton_8.setBackground(Color.WHITE);
		btnNewButton_8.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(textField_Item_3.getText().trim().isEmpty() == false && textField_Price_3.getText().trim().isEmpty() == false)
				{
					model_3.addElement(textField_Item_3.getText()+","+textField_Price_3.getText());
					list_3.setModel(model_3);
				}
				else
				{
					new ErrorTextField();
				}
				textField_Item_3.setText("");
				textField_Price_3.setText("");
			}
		});
		btnNewButton_8.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnNewButton_8.setBounds(258, 11, 89, 23);
		panelCenterS_N.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("REMOVE");
		btnNewButton_9.setBackground(Color.WHITE);
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				model_3.removeElementAt(list_3.getSelectedIndex());	
			}
		});
		btnNewButton_9.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnNewButton_9.setBounds(357, 11, 89, 23);
		panelCenterS_N.add(btnNewButton_9);
		
		textField_Price_3 = new JTextField();
		textField_Price_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) 
			{
				char c = e.getKeyChar();
				if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) 
				{
					e.consume();
				}
			}
		});
		textField_Price_3.setColumns(10);
		textField_Price_3.setBounds(174, 12, 71, 20);
		panelCenterS_N.add(textField_Price_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("ITEM");
		lblNewLabel_1_4.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setBounds(93, 36, 73, 14);
		panelCenterS_N.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("PRICE");
		lblNewLabel_1_1_3.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3.setBounds(174, 36, 73, 14);
		panelCenterS_N.add(lblNewLabel_1_1_3);
		
		JButton btnNewButton = new JButton("PRESS HERE TO CONFIRM CHANGES");
		btnNewButton.setContentAreaFilled(true);
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				 
				 
				 ArrayList<String> riceMealAll = new ArrayList<String>(list.getModel().getSize());
				 ArrayList<String> riceMealList = new ArrayList<String>(list.getModel().getSize());
				 ArrayList<String> riceMealPriceList = new ArrayList<String>(list.getModel().getSize());
				 for (int i = 0; i < list.getModel().getSize(); i++)
				 {
					 riceMealAll.add((String) list.getModel().getElementAt(i)+","); 
				 }
				 String listString = String.join("", riceMealAll);
				 String [] token = listString.split(",");
				 for (int i = 0; i < list.getModel().getSize()*2; i++) 
				 {
					 
					 if(i%2 == 0)
					 {
					 riceMealList.add(token[i]);
					 }
					 if(i%2 == 1)
					 {
					 riceMealPriceList.add(token[i]); 
					 }
					
				 }
				 
				 try {
					i.writeList(i.riceMealFile, riceMealList);
					i.writePriceList(i.riceMealPriceFile, riceMealPriceList);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
				 ArrayList<String> sidesAll = new ArrayList<String>(list_1.getModel().getSize());
				 ArrayList<String> sidesList = new ArrayList<String>(list_1.getModel().getSize());
				 ArrayList<String> sidesPriceList = new ArrayList<String>(list_1.getModel().getSize());
				 for (int i = 0; i < list_1.getModel().getSize(); i++)
				 {
					 sidesAll.add((String) list_1.getModel().getElementAt(i)+","); 
				 }
				 String listString_1 = String.join("", sidesAll);
				 String[] token_1 = listString_1.split(",");
				 for (int i = 0; i < list_1.getModel().getSize()*2; i++) 
				 {
					 
					 if(i%2 == 0)
					 {
					 sidesList.add(token_1[i]);
					 }
					 if(i%2 == 1)
					 {
					 sidesPriceList.add(token_1[i]); 
					 }
					
				 }
				 
				 try {
						i.writeList(i.sidesFile, sidesList);
						i.writePriceList(i.sidesPriceFile, sidesPriceList);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					 
				 ArrayList<String> beverageAll = new ArrayList<String>(list_2.getModel().getSize());
				 ArrayList<String> beverageList = new ArrayList<String>(list_2.getModel().getSize());
				 ArrayList<String> beveragePriceList = new ArrayList<String>(list_2.getModel().getSize());
				 for (int i = 0; i < list_2.getModel().getSize(); i++)
				 {
					 beverageAll.add((String) list_2.getModel().getElementAt(i)+","); 
				 }
				 String listString_2 = String.join("", beverageAll);
				 String[] token_2 = listString_2.split(",");
				 for (int i = 0; i < list_2.getModel().getSize()*2; i++) 
				 {
					 
					 if(i%2 == 0)
					 {
					 beverageList.add(token_2[i]);
					 }
					 if(i%2 == 1)
					 {
					 beveragePriceList.add(token_2[i]); 
					 }
					
				 }
				 
				 try {
						i.writeList(i.beverageFile, beverageList);
						i.writePriceList(i.beveragePriceFile, beveragePriceList);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				 
				 ArrayList<String> dessertsAll = new ArrayList<String>(list_3.getModel().getSize());
				 ArrayList<String> dessertsList = new ArrayList<String>(list_3.getModel().getSize());
				 ArrayList<String> dessertsPriceList = new ArrayList<String>(list_3.getModel().getSize());
				 for (int i = 0; i < list_3.getModel().getSize(); i++)
				 {
					 dessertsAll.add((String) list_3.getModel().getElementAt(i)+","); 
				 }
				 String listString_3 = String.join("", dessertsAll);
				 String[] token_3 = listString_3.split(",");
				 for (int i = 0; i < list_3.getModel().getSize()*2; i++) 
				 {
					 
					 if(i%2 == 0)
					 {
					 dessertsList.add(token_3[i]);
					 }
					 if(i%2 == 1)
					 {
					 dessertsPriceList.add(token_3[i]); 
					 }
					
				 }
				
				 try {
						i.writeList(i.dessertsFile, dessertsList);
						i.writePriceList(i.dessertsPriceFile, dessertsPriceList);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				 
				 frame.setVisible(false);
				 new DigitalBoard_6();
				 
				
			}
		});
		btnNewButton.setBackground(new Color(255, 175, 175));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(true);
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
		panelCenterS.add(btnNewButton, BorderLayout.CENTER);
		btnNewButton.setContentAreaFilled(true);
		
	
		
		
		
		
		
		
		
		
		
		
		
	}
}