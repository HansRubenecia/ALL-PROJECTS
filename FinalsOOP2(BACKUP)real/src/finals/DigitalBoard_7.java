package finals;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.CardLayout;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;

public class DigitalBoard_7 {
	int counter = 1;
	ArrayList<String> checkoutList = new ArrayList<String>();
	String checkoutItem;
	int checkoutCounter;
	ArrayList<String> checkoutListReceipt = new ArrayList<String>();
	int total = 0;
	DefaultListModel model_CheckoutList = new DefaultListModel();
	ArrayList<Integer>checkoutItemPriceList = new ArrayList<Integer>();
	String receipt;
	HashSet<Integer> hsetPrice;
	ArrayList<Integer>checkoutItemPrice = new ArrayList<Integer>();
	
	public DigitalBoard_7() throws IOException
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
		adminButton.setBackground(UIManager.getColor("Button.darkShadow"));
		adminButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
		panelNorth.add(adminButton);
		
		
		adminButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				frame.setVisible(false);
				DigitalBoard_1 db1 = new DigitalBoard_1();
			}
		});

		JPanel panelSouth = new JPanel();
		panelSouth.setBackground(Color.LIGHT_GRAY);
		panelSouth.setPreferredSize(new Dimension(0,50));
		frame.getContentPane().add(panelSouth,BorderLayout.SOUTH);
		panelSouth.setLayout(null);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("TOTAL:\u20B10");
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(160, 7, 141, 38);
		panelSouth.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		
		
		JPanel panelCenter = new JPanel();
		panelCenter.setBackground(Color.GREEN);
		panelNorth.setPreferredSize(new Dimension(50,50));
		frame.getContentPane().add(panelCenter,BorderLayout.CENTER);
		panelCenter.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCenterLeft = new JPanel();
		panelCenterLeft.setBorder(UIManager.getBorder("Button.border"));
		panelCenter.add(panelCenterLeft, BorderLayout.WEST);
		panelCenterLeft.setPreferredSize(new Dimension(100, 325));
		panelCenterLeft.setLayout(null);
		panelCenterLeft.setBackground(Color.PINK);
		
		JPanel panelCenterSouth = new JPanel();
		panelCenter.add(panelCenterSouth, BorderLayout.SOUTH);
		panelCenterSouth.setPreferredSize(new Dimension(0, 100));
		panelCenterSouth.setLayout(null);
		
		JScrollPane scrollPane_All_1 = new JScrollPane();
		scrollPane_All_1.setBounds(0, 0, 464, 100);
		panelCenterSouth.add(scrollPane_All_1);
		
		JList list_CheckoutList = new JList();
		scrollPane_All_1.setViewportView(list_CheckoutList);
		    
		
		JPanel panelCenterRight = new JPanel();
		panelCenter.add(panelCenterRight, BorderLayout.EAST);
		panelCenterRight.setPreferredSize(new Dimension(365, 0));
		panelCenterRight.setLayout(new CardLayout(0, 0));
		
		
		JPanel panelCenterRight_All = new JPanel();
		panelCenterRight.add(panelCenterRight_All, "name_46602320793300");
		panelCenterRight_All.setBackground(Color.WHITE);
		panelCenterRight_All.setLayout(null);
		
		
		JPanel panelCenterRight_RiceMeal = new JPanel();
		panelCenterRight_RiceMeal.setBackground(Color.WHITE);
		panelCenterRight.add(panelCenterRight_RiceMeal, "name_46934604657400");
		panelCenterRight_RiceMeal.setLayout(null);
		
		breakfastMenuList i = new breakfastMenuList();
		i.readList();
		i.readPriceList();
		
		
		DefaultListModel model_4 = new DefaultListModel();
		
		JScrollPane scrollPane_All = new JScrollPane();
		scrollPane_All.setBounds(0, 0, 365, 613);
		panelCenterRight_All.add(scrollPane_All);
		
		JList list_All = new JList();
		list_All.setBackground(Color.WHITE);
		list_All.setFont(new Font("Segoe UI", Font.BOLD, 25));
		scrollPane_All.setViewportView(list_All);
		
		int size_1 = i.riceMealList.size();
		int size_2 = i.sidesList.size();
		int size_3 = i.beverageList.size();
		int size_4 = i.dessertsList.size();
		
		for (int a = 0; a < size_1; a++)
		{
			model_4.addElement(i.riceMealList.get(a)+","+i.riceMealPriceList.get(a));
		}
		for (int a = 0; a < size_2; a++)
		{
			model_4.addElement(i.sidesList.get(a)+","+i.sidesPriceList.get(a));
		}
		for (int a = 0; a < size_3; a++)
		{
			model_4.addElement(i.beverageList.get(a)+","+i.beveragePriceList.get(a));
		}
		for (int a = 0; a < size_4; a++)
		{
			model_4.addElement(i.dessertsList.get(a)+","+i.dessertsPriceList.get(a));
		}
		
		list_All.setModel(model_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 365, 613);
		panelCenterRight_RiceMeal.add(scrollPane);
		
		JList list = new JList();
		list.setBackground(Color.WHITE);
		list.setFont(new Font("Segoe UI", Font.BOLD, 25));
		scrollPane.setViewportView(list);
		
		DefaultListModel model = new DefaultListModel();
		
		
		for (int a = 0; a< size_1; a++)
		{
			model.addElement(i.riceMealList.get(a)+","+i.riceMealPriceList.get(a));
		}
		
		list.setModel(model);
		
		
		JPanel panelCenterRight_Sides = new JPanel();
		panelCenterRight_Sides.setBackground(Color.WHITE);
		panelCenterRight.add(panelCenterRight_Sides, "name_46936089570400");
		panelCenterRight_Sides.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 365, 613);
		panelCenterRight_Sides.add(scrollPane_1);
		
		JList list_1 = new JList();
		list_1.setFont(new Font("Segoe UI", Font.BOLD, 25));
		scrollPane_1.setViewportView(list_1);
		
		DefaultListModel model_1 = new DefaultListModel();
	
		
		for (int a = 0; a< size_2; a++)
		{
			model_1.addElement(i.sidesList.get(a)+","+i.sidesPriceList.get(a));
		}
		list_1.setModel(model_1);
		
		JPanel panelCenterRight_Beverage = new JPanel();
		panelCenterRight_Beverage.setBackground(Color.WHITE);
		panelCenterRight.add(panelCenterRight_Beverage, "name_46937464494300");
		panelCenterRight_Beverage.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 365, 613);
		panelCenterRight_Beverage.add(scrollPane_2);
		
		JList list_2 = new JList();
		list_2.setFont(new Font("Segoe UI", Font.BOLD, 25));
		scrollPane_2.setViewportView(list_2);
		
		DefaultListModel model_2 = new DefaultListModel();

		
		for (int a = 0; a< size_3; a++)
		{
			model_2.addElement(i.beverageList.get(a)+","+i.beveragePriceList.get(a));
		}
		list_2.setModel(model_2);
		
		JPanel panelCenterRight_Desserts = new JPanel();
		panelCenterRight_Desserts.setBackground(Color.WHITE);
		panelCenterRight.add(panelCenterRight_Desserts, "name_46937464494300");
		panelCenterRight_Desserts.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 0, 365, 613);
		panelCenterRight_Desserts.add(scrollPane_3);
		
		JList list_3 = new JList();
		list_3.setFont(new Font("Segoe UI", Font.BOLD, 25));
		scrollPane_3.setViewportView(list_3);
		
		DefaultListModel model_3 = new DefaultListModel();
		
		for (int a = 0; a< size_4; a++)
		{
			model_3.addElement(i.dessertsList.get(a)+","+i.dessertsPriceList.get(a));
		}
		list_3.setModel(model_3);
		
		JButton btnNewButton = new JButton("ALL");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(2, 11, 95, 40);
		panelCenterLeft.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				panelCenterRight_All.show(true);
				panelCenterRight_RiceMeal.show(false);
				panelCenterRight_Sides.show(false);
				panelCenterRight_Beverage.show(false);
				panelCenterRight_Desserts.show(false);
				
				list.clearSelection();
				list_1.clearSelection();
				list_2.clearSelection();
				list_3.clearSelection();
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		JButton btnNewButton_1 = new JButton("RICE MEAL");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				panelCenterRight_All.show(false);
				panelCenterRight_RiceMeal.show(true);
				panelCenterRight_Sides.show(false);
				panelCenterRight_Beverage.show(false);
				panelCenterRight_Desserts.show(false);
				
				list_All.clearSelection();
				list_1.clearSelection();
				list_2.clearSelection();
				list_3.clearSelection();
				
			}
		});
		btnNewButton_1.setBounds(2, 62, 95, 40);
		panelCenterLeft.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		JButton btnNewButton_2 = new JButton("SIDES");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				panelCenterRight_All.show(false);
				panelCenterRight_RiceMeal.show(false);
				panelCenterRight_Sides.show(true);
				panelCenterRight_Beverage.show(false);
				panelCenterRight_Desserts.show(false);
				list.clearSelection();
				list_All.clearSelection();
				list_2.clearSelection();
				list_3.clearSelection();
			}
		});
		btnNewButton_2.setBounds(2, 113, 95, 40);
		panelCenterLeft.add(btnNewButton_2);
		btnNewButton_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		JButton btnNewButton_3 = new JButton("BEVERAGE");
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				panelCenterRight_All.show(false);
				panelCenterRight_RiceMeal.show(false);
				panelCenterRight_Sides.show(false);
				panelCenterRight_Beverage.show(true);
				panelCenterRight_Desserts.show(false);
				
				list.clearSelection();
				list_1.clearSelection();
				list_All.clearSelection();
				list_3.clearSelection();
			}
		});
		btnNewButton_3.setBounds(2, 163, 95, 40);
		panelCenterLeft.add(btnNewButton_3);
		btnNewButton_3.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		JButton btnNewButton_4 = new JButton("DESSERTS");
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				panelCenterRight_All.show(false);
				panelCenterRight_RiceMeal.show(false);
				panelCenterRight_Sides.show(false);
				panelCenterRight_Beverage.show(false);
				panelCenterRight_Desserts.show(true);
				
				list.clearSelection();
				list_1.clearSelection();
				list_2.clearSelection();
				list_All.clearSelection();
			}
		});
		btnNewButton_4.setBounds(2, 213, 95, 40);
		panelCenterLeft.add(btnNewButton_4);
		btnNewButton_4.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		JLabel lblNewLabel = new JLabel("1");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(2, 560, 95, 40);
		panelCenterLeft.add(lblNewLabel);
		
		
		JButton btnNewButton_6 = new JButton("+");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				counter ++;
				lblNewLabel.setText(Integer.toString(counter));
			}
		});
		btnNewButton_6.setBackground(Color.WHITE);
		btnNewButton_6.setFont(new Font("Segoe UI", Font.BOLD, 10));
		btnNewButton_6.setBounds(3, 527, 47, 23);
		panelCenterLeft.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("-");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (counter>1)
				{
					counter --;
				}
				
				lblNewLabel.setText(Integer.toString(counter));
			}
		});
		btnNewButton_7.setBackground(Color.WHITE);
		btnNewButton_7.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnNewButton_7.setBounds(53, 527, 45, 23);
		panelCenterLeft.add(btnNewButton_7);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(2, 560, 95, 40);
		panelCenterLeft.add(panel);
		
		JButton btnNewButton_8 = new JButton("ADD\r\n");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ArrayList<String>checkoutList = new ArrayList<String>();

				for(int a = 1 ; a < counter+1; a++)
				{
					
					if(list.isSelectionEmpty()&& list_1.isSelectionEmpty()&&list_2.isSelectionEmpty()&&list_3.isSelectionEmpty())
					{
						
						checkoutList.add((String) list_All.getModel().getElementAt(list_All.getSelectedIndex())+",");

					}
					if(list_All.isSelectionEmpty() && list_1.isSelectionEmpty()&&list_2.isSelectionEmpty()&&list_3.isSelectionEmpty())
					{
						checkoutList.add((String) list.getModel().getElementAt(list.getSelectedIndex())+",");
					}
						
					
					if(list_All.isSelectionEmpty() && list.isSelectionEmpty()&&list_2.isSelectionEmpty()&&list_3.isSelectionEmpty())
					{
						checkoutList.add((String) list_1.getModel().getElementAt(list_1.getSelectedIndex())+",");
					
					}
						
					if(list_All.isSelectionEmpty() && list.isSelectionEmpty()&&list_1.isSelectionEmpty()&&list_3.isSelectionEmpty())
					{
						
						checkoutList.add((String) list_2.getModel().getElementAt(list_2.getSelectedIndex())+",");
						
					}
					if(list_All.isSelectionEmpty() && list.isSelectionEmpty()&&list_2.isSelectionEmpty()&&list_1.isSelectionEmpty())
					{
						checkoutList.add((String) list_3.getModel().getElementAt(list_3.getSelectedIndex())+",");
						
					}
					
				}
				
				String listString_1 = String.join("", checkoutList);
				String[] checkoutToken = listString_1.split(",");
				for(int a = 0; a < checkoutToken.length;a++)
				{
					if(a%2 == 0)
					{
						model_CheckoutList.addElement(checkoutToken[a]);
						checkoutListReceipt.add(checkoutToken[a]);
					}
					if(a%2 ==1)
					{
						int checkoutItemPrice = Integer.parseInt(checkoutToken[a]);
						checkoutItemPriceList.add(checkoutItemPrice);
						total = total + checkoutItemPrice;
					}
					list_CheckoutList.setModel(model_CheckoutList);
					
				}
				lblNewLabel_2.setText("TOTAL:\u20B1"+total);
				counter = 1;
				lblNewLabel.setText(Integer.toString(counter));
				
			}
		});
		btnNewButton_8.setBackground(Color.WHITE);
		btnNewButton_8.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnNewButton_8.setBounds(2, 475, 95, 40);
		panelCenterLeft.add(btnNewButton_8);
		
		JButton btnNewButton_5_1 = new JButton("REMOVE\r\n");
		btnNewButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				total = total - checkoutItemPriceList.get(list_CheckoutList.getSelectedIndex());
				checkoutItemPriceList.remove(list_CheckoutList.getSelectedIndex());
				checkoutListReceipt.remove(list_CheckoutList.getSelectedIndex());
				model_CheckoutList.removeElementAt(list_CheckoutList.getSelectedIndex());

				lblNewLabel_2.setText("TOTAL:\u20B1"+total);
			
				
			}
		});
		
		btnNewButton_5_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnNewButton_5_1.setBackground(Color.WHITE);
		btnNewButton_5_1.setBounds(10, 7, 110, 38);
		panelSouth.add(btnNewButton_5_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(160, 7, 141, 38);
		panelSouth.add(panel_1);
		
		JButton btnNewButton_5 = new JButton("CHECKOUT");
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(model_CheckoutList.isEmpty())
				{
					
				}
				else
				{
					frame.setVisible(false);
					try {
						new DigitalBoard_10(checkoutListReceipt,total,checkoutItemPriceList);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnNewButton_5.setBounds(323, 7, 141, 38);
		panelSouth.add(btnNewButton_5);
		
		
		
		
		
		
		
		
		
		
	}
}
