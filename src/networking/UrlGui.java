package networking;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class UrlGui implements ActionListener {

	private JFrame frame;
	private JTextField urlinput;
	private JLabel authority;
	private JLabel file;
	private JLabel host;
	private JLabel path;
	private JLabel port;
	private JLabel protocol;
	private JLabel query;
	private JLabel ref;
	private JLabel userinfo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UrlGui window = new UrlGui();
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
	public UrlGui() {
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
		
		JLabel lblNewLabel = new JLabel("Enter Website Name");
		frame.getContentPane().add(lblNewLabel);
		
		urlinput = new JTextField();
		frame.getContentPane().add(urlinput);
		urlinput.setColumns(15);
		
		JButton getresult = new JButton("Get");
		frame.getContentPane().add(getresult);
		
		authority = new JLabel("Authority");
		frame.getContentPane().add(authority);
		
		file = new JLabel("File");
		frame.getContentPane().add(file);
		
		host = new JLabel("Host");
		frame.getContentPane().add(host);
		
		path = new JLabel("Path");
		frame.getContentPane().add(path);
		
		port = new JLabel("Port");
		frame.getContentPane().add(port);
		
		protocol = new JLabel("Protocol");
		frame.getContentPane().add(protocol);
		
		query = new JLabel("Query");
		frame.getContentPane().add(query);
		
		ref = new JLabel("Ref");
		frame.getContentPane().add(ref);
		
		userinfo = new JLabel("User Info");
		frame.getContentPane().add(userinfo);
		getresult.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		try {
			URL url=new URL(urlinput.getText());
			authority.setText("Authority :"+url.getAuthority());
		    file.setText("File = "+url.getFile());
		    host.setText("Host = "+url.getHost());
		    path.setText("Path = "+url.getPath());
		    port.setText("Port = "+url.getPort());
		    protocol.setText("Protocol = "+url.getProtocol());
		    query.setText("Query = "+url.getQuery());
		    ref.setText("Ref = "+url.getRef());
		    userinfo.setText("User Info = "+url.getUserInfo());
		    
		    InputStream is=url.openStream();
		    int ch;
		    while((ch=is.read())!=-1)
		    	System.out.println((char)ch);
	            is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
