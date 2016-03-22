package MainWindow;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;  
  
class Windows extends JFrame   
{  
    MenuBar menubar;  
    Menu menu;  
    MenuItem item1, item2;  
    Windows(String s)  
    {  
        setTitle(s);
        Toolkit tool = getToolkit();  
        Dimension dim = tool.getScreenSize();  
        setBounds(0, 0, dim.width/2, dim.height/2);  
        menubar = new MenuBar();  
        menu = new Menu("文件");  
        item1 = new MenuItem("打开");  
        item2 = new MenuItem("保存");  
        menu.add(item1);  
        menu.add(item2);  
        menubar.add(menu);  
        setMenuBar(menubar); 
        JButton videoButton = new JButton("开启摄像头");
        this.add(videoButton);
        videoButton.setBounds(0, 0, 10, 10);
        
        
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }  
}  
public class MainWindow {  
    public static void main(String args[])  
    {  
        Windows win = new Windows("RealTimeDetector");  
    }  
  
}  