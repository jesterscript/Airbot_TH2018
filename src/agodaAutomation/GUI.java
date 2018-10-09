package agodaAutomation;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.xml.sax.SAXException;

import com.sun.glass.events.MouseEvent;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class GUI {
	public static String path="girili degil";
	public static String type="single";
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
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
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 520, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnStartTest = new JButton("Start Test");
		btnStartTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TestListenerAdapter tla = new TestListenerAdapter();
				TestNG testng = new TestNG();
				ArrayList<String> suites = new ArrayList<>();
				suites.add(GUI.path);//path to xml..
				testng.setTestSuites(suites);
				testng.run();
				try {
					Thread.sleep(15000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				WebDriver wb = new ChromeDriver();
				wb.get("C:\\Users\\melihbugra.oguzer\\Pictures\\Airbot_TH2018-master\\test-output\\emailable-report.html");
				try {
					Thread.sleep(15000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				wb.quit();
				
			}
		});
		btnStartTest.setBounds(344, 189, 133, 47);
		frame.getContentPane().add(btnStartTest);
	
		String[] messageStrings = {"Select","Firefox","Chrome","Edge","Cross"};
		JComboBox comboBox = new JComboBox(messageStrings);
	
		comboBox.addActionListener(new ActionListener() {
			 
		    public void actionPerformed(ActionEvent event) {
		        JComboBox<String> combo = (JComboBox<String>) event.getSource();
		        String selectedBook = (String) combo.getSelectedItem();
		 
		        if (selectedBook.equals("Firefox")) {
		           type = "firefox";
		           System.out.println(type + "secildi");
		        } else if (selectedBook.equals("Chrome")) {
		           type= "chrome";
		           System.out.println(type + "secildi");
		        }else if (selectedBook.equals("Edge")) {
		           type= "edge";
		           System.out.println(type + "secildi");
		        }
		        
		        else if (selectedBook.equals("Cross")) {
			           type= "cross";
			           System.out.println(type + "secildi");
			        }
		        
		        OpenFile file = new OpenFile();
				try {
					file.okuma(GUI.path,type);
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (TransformerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		        
		    }
		});
	
		
		comboBox.setBounds(185, 139, 93, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblSelectABrowser = new JLabel("Select a browser");
		lblSelectABrowser.setBounds(25, 135, 123, 28);
		frame.getContentPane().add(lblSelectABrowser);
		
		JButton btnNewButton = new JButton("Select XML file");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FileChooser deneme = new FileChooser();
				path = deneme.pick();
				
				
			}
		});
		btnNewButton.setBounds(147, 188, 141, 49);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblselectXmlFile = new JLabel("1-Select XML file");
		lblselectXmlFile.setBounds(25, 24, 123, 28);
		frame.getContentPane().add(lblselectXmlFile);
		
		JLabel lblSelectTestBrowser = new JLabel("2-Select Test Browser");
		lblSelectTestBrowser.setBounds(25, 54, 123, 28);
		frame.getContentPane().add(lblSelectTestBrowser);
	}
}
