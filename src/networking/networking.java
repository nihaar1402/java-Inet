package networking;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class networking implements ActionListener {

	private JFrame frame;
	private JTextField textField;
	private JLabel address;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					networking window = new networking();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public networking() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Enter Website Name : ");
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		frame.getContentPane().add(textField);
		textField.setColumns(15);
		
		button = new JButton("Get Address");
		frame.getContentPane().add(button);
		button.addActionListener(this);
		
		address = new JLabel("Address");
		frame.getContentPane().add(address);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		try {
			InetAddress ad=InetAddress.getByName(textField.getText());
			address.setText("The Address of Your Website is : "+ad.toString());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
