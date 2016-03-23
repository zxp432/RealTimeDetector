package MainWindow;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.GridLayout;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

import javax.media.Player;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.border.LineBorder;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {
	
   	 private Player player; // 播放器对象   
	 private Component visualMedia; // 视频显示组件   
	 private Component mediaControl; // 视频播放控制组件   
	 private File mediaFile; //媒体文件   
	 private URL fileURL; //媒体文件URL地址   	
	 /*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		
		this.setMinimumSize(new Dimension(800, 500));//设置最小值
		getContentPane().setBackground(Color.LIGHT_GRAY);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 10, 5, 10));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(624, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
					.addGap(0))
		);
		
		JButton cameraButton = new JButton("\u6444\u50CF\u5934\u68C0\u6D4B");
		cameraButton.setBounds(22, 68, 105, 23);
		cameraButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent event) {   
	                JFileChooser fileChooser = new JFileChooser(); //实例化文件选择器   
	                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);//设置文件打开模式为仅打开文件       
	                int result = fileChooser.showOpenDialog(MainWindow.this);//显示对话框       
	                if (result == JFileChooser.APPROVE_OPTION) { //得到用户行为   
	                    mediaFile = fileChooser.getSelectedFile(); //得到选择的文件   
	                }   
	                if (mediaFile != null) {   
	                    try {   
	                        fileURL = mediaFile.toURL(); //得到文件的URL地址   
	                    } catch (MalformedURLException ex) {   
	                          ex.printStackTrace(); //输出错误信息   
	                          showMessage("打开错误"); //显示错误信息   
	                    }   
	                  //  startPlayer(fileURL.toString()); //开始播放打开的文件   
	                }   
	           }
		});
		panel.setLayout(null);
		panel.add(cameraButton);
		
		JButton videoButton = new JButton("\u89C6\u9891\u68C0\u6D4B");
		videoButton.setBounds(22, 168, 105, 23);
		panel.add(videoButton);
		
		JButton pictureButton = new JButton("\u56FE\u7247\u68C0\u6D4B");
		pictureButton.setBounds(22, 268, 104, 23);
		pictureButton.setToolTipText("");
		panel.add(pictureButton);
		
		getContentPane().setLayout(groupLayout);
		setBackground(Color.WHITE);
		setTitle("RealTimeDetector");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.GRAY);
		menuBar.setToolTipText("");
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u83DC\u5355");
		mnNewMenu.setBackground(Color.WHITE);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u6253\u5F00");
		mntmNewMenuItem.setBackground(Color.WHITE);
		mnNewMenu.add(mntmNewMenuItem);
	}
	
	public void showMessage(String s) {   
		  JOptionPane.showMessageDialog(this, s); //显示提示信息   
		 }
}
