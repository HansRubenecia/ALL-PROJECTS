package finals;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;

public class AdminPasswordField {
	private JTextField textField;

	public AdminPasswordField()
	{
		JFrame frame_Password = new JFrame();
		frame_Password.setTitle("");
		frame_Password.setSize(300,130);

		frame_Password.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JButton btnNewButton_Password = new JButton("CONFIRM");
		btnNewButton_Password.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnNewButton_Password.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(textField_Password.getText().equals("admin123"))
				{
					
					frame_Password.setVisible(false);
					new DigitalBoard_2();
				}
				else
				{
					
					System.out.print(textField_Password.getText());
				}
			}
		});
		btnNewButton_Password.setBounds(155, 30, 89, 23);
		panel_Password.add(btnNewButton_Password);
		
		JLabel lblPleaseTryAgain = new JLabel("PASSWORD INCORRECT\r\n");
		lblPleaseTryAgain.setForeground(Color.RED);
		lblPleaseTryAgain.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseTryAgain.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblPleaseTryAgain.setBounds(53, 66, 179, 15);
		panel_Password.add(lblPleaseTryAgain);
		frame_Password.setVisible(true);
		frame_Password.setLocationRelativeTo(null);
		
		
	}
}