package finals;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ErrorTextField implements ActionListener {
	JButton btnNewButton;
	JFrame frame; 
	public ErrorTextField()
	{
		JFrame frame = new JFrame();
		frame.setTitle("Error");
		frame.setSize(300,130);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MAKE SURE ALL TEXT FIELD ARE FILLED");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(9, 11, 262, 34);
		panel.add(lblNewLabel);
		
		btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(this);
			
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnNewButton.setBounds(112, 50, 60, 23);
		panel.add(btnNewButton);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == btnNewButton)
		{
			frame.setVisible(false);
		}
		
	}
	
}