import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;//////////
import javax.swing.JLabel;
import javax.swing.ImageIcon;////////�߰�
import java.awt.color.*;/////////////
import java.awt.Dimension;////////////
import javax.swing.SwingUtilities;///////////
import javax.swing.UIManager;/////////////




public class Server extends JFrame implements ActionListener {
   
   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   private final int PORT = 10000;
   
   //����
   final String MESSAGE_wordCopy = "wordCopy";
   final String MESSAGE_wordPaste = "wordPaste";
   final String MESSAGE_wordCreate = "wordCreate";
   final String MESSAGE_wordSaveAname = "wordSaveAname";
   final String MESSAGE_wordPrint = "wordPrint";
   final String MESSAGE_wordPrintlook = "wordPrintlook";
   final String MESSAGE_wordCut = "wordCut";
   final String MESSAGE_wordBlockSet = "wordBlockSet";
   final String MESSAGE_wordFormCopy = "wordFormCopy";
   final String MESSAGE_wordFormPaste = "wordFormPaste";
   final String MESSAGE_wordtoTheMemo = "wordtoTheMemo";
   final String MESSAGE_wordBookIn ="wordBookIn";
   final String MESSAGE_wordMijoo = "wordMijoo";
   final String MESSAGE_wordGakjoo = "wordGakjoo";
   final String MESSAGE_wordDandiverse = "wordDandiverse";
   final String MESSAGE_wordTimeField = "wordTimeField";
   final String MESSAGE_wordPageField = "wordPageField";
   final String MESSAGE_wordMotionChange = "wordMotionChange";
   final String MESSAGE_wordMotionSizeChange = "wordMotionSizeChange";
   final String MESSAGE_wordStyleChange = "wordStyleChange";
   final String MESSAGE_wordleftCenter = "wordletfCenter";
   final String MESSAGE_wordrightCenter = "wordrightCenter";
   final String MESSAGE_wordCenter = "wordCenter";
   final String MESSAGE_wordCapWord = "wordCapWord";
   final String MESSAGE_wordCheck = "wordCheck";
   final String MESSAGE_wordWindowDiv = "wordWindowDiv";
   final String MESSAGE_wordTotalWindow = "wordTotalWindow";
   final String MESSAGE_wordClose = "wordClose";
   final String MESSAGE_wordBold = "wordBold";
   final String MESSAGE_wordTotalSelect = "wordTotalSelect";
   
   // �߰� �ڵ�
   final String MESSAGE_wordOpen = "wordOpen";
   final String MESSAGE_wordFound = "wordFound";
   final String MESSAGE_wordCancle = "wordCancle";
   final String MESSAGE_wordRePlay = "wordRePlay";
   final String MESSAGE_wordSave = "wordSave";
   final String MESSAGE_wordPlusOne = "wordPlusOne";
   final String MESSAGE_wordDownOne = "wordDownOne";
   final String MESSAGE_wordMotionSet = "wordMotionSet";
   final String MESSAGE_wordlineOne = "wordlineOne";
   final String MESSAGE_wordlineTwo = "wordlineTwo";
   final String MESSAGE_wordlineOneTwo = "wordlineOneTwo";
   final String MESSAGE_wordAdopt = "wordAdopt";
   final String MESSAGE_wordAdoptCancel = "wordAdoptCancle";
   final String MESSAGE_wordHelp ="wordHelp";
   final String MESSAGE_wordFinalRe = "wordFinalRe";
   final String MESSAGE_wordSynonym = "wordSynonym";
   final String MESSAGE_wordUnderline = "wordUnderline";
   final String MESSAGE_wordMotionLean = "wordMotionLean";
   final String MESSAGE_wordInitial = "wordInitial";
   final String MESSAGE_wordFullScreen = "wordFullScreen";

   
   final String MESSAGE_A1 = "A1";
   final String MESSAGE_B1 = "B1";
   final String MESSAGE_C1 = "C1";
   final String MESSAGE_D1 = "D1";
   
   
   //���콺 ����Ű ��ġ�е�
   final String MESSAGE_FULL = "FULL";
   final String MESSAGE_SOUNDUP = "SOUNDUP";
   final String MESSAGE_SOUNDDOWN = "SOUNDDOWN";
   final String MESSAGE_LEFT = "LEFT";
   final String MESSAGE_RIGHT = "RIGHT";
   final String MESSAGE_MOUSELEFT = "MOUSELEFT";
   final String MESSAGE_MOUSERIGHT = "MOUSERIGHT";
   final String MOUSE = "MOUSE";
   
   //��Ʋ�׶���
   final String MESSAGE_A = "A";
   final String MESSAGE_B = "B";
   final String MESSAGE_C = "C";
   final String MESSAGE_D = "D";

   private UIManager.LookAndFeelInfo looks[];////////////
   private Container con;
   private JLabel ipInfo;
   private JButton serverStart;
   private JButton serverStop;
   private JComboBox jcb;
   private GridLayout gl;
   
private JLabel introduce;///////////////
private JPanel pane1;////
private JPanel pane2;////

   private ThreadServer threadServer;
   ImageIcon img = new ImageIcon("./src/hotkey.png");////////// 


   public void serverStart() {
      //gl = new GridLayout(5, 1);
      pane1=new JPanel();/////�����
      pane2=new JPanel();
      pane1.setLayout(new GridLayout(3,1));
      pane2.setLayout(new GridLayout(1,2));////�������
      init();
      start();
      setSize(600, 400);///////
      setVisible(true);
      //this.setLocation(50, 50);
   }

   private void start() {
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      serverStart.addActionListener(this);
      serverStop.addActionListener(this);
   }

   private void init() {
      setupLocalInfo();
      con = getContentPane();
      introduce= new JLabel(img);/////
      looks=UIManager.getInstalledLookAndFeels();/////////////////
      try{UIManager.setLookAndFeel(looks[1].getClassName());
      SwingUtilities.updateComponentTreeUI(this);
      }catch(Exception e){e.printStackTrace();}
      
      //introduce.setBackground(new Color(0,0,0)); �������
      ipInfo = new JLabel("IP");
      serverStart = new JButton("Server Start");
      serverStop = new JButton("Server Stop");
      serverStop.setEnabled(false);
   
      
      pane1.add(introduce);/////////������ con.add����. con.add(gl) �� �־���.
      pane1.add(serverStart);
      pane1.add(serverStop);
      pane2.add(ipInfo);
      pane2.add(jcb);
      con.add(pane1);///////////
      con.add(pane2,BorderLayout.SOUTH);///////
      this.setTitle("HotKey Server");////////�߰�
   }

   private void setupLocalInfo() {
      InetAddress ia[] = null;
      try {
         String hostName = InetAddress.getLocalHost().getHostName();
         ia = InetAddress.getAllByName(hostName);
      } catch (UnknownHostException e) {
         e.printStackTrace();
      }
      jcb = new JComboBox();
      InetAddress ainetaddress[];
      int j = (ainetaddress = ia).length;
      for (int i = 0; i < j; i++) {
         InetAddress inet = ainetaddress[i];
         jcb.addItem((new StringBuilder()).append(inet.getHostAddress()).toString());
      }

   }

   public void actionPerformed(ActionEvent e) {
      if ((JButton) e.getSource() == serverStart) {
         threadServer = new ThreadServer();
         threadServer.start();
         serverStart.setEnabled(false);
         serverStop.setEnabled(true);
      }
      if ((JButton) e.getSource() == serverStop) {
         threadServer.interrupt();
         serverStop.setEnabled(false);
         serverStart.setEnabled(true);
      }
   }
   
   class ThreadServer extends Thread {

      Robot robot;
      PointerInfo a;
      Point b;
      String split[];
      DatagramSocket socket;
      DatagramPacket packet;
      boolean connected;

      public ThreadServer() {
         super();
         connected = false;
         try {
            robot = new Robot();
         } catch (AWTException e) {
            e.printStackTrace();
         }
         try {
            socket = new DatagramSocket(PORT);
            connected = true;
         } catch (SocketException e) {
            e.printStackTrace();
         }
         System.out.println("Server Start");
      }

      public void interrupt() {
         socket.close();
         System.out.println("Server Stop");
      }

      public void run() {
         try {
            do {
               byte data[] = new byte[100];
               packet = new DatagramPacket(data, data.length);
               if(!socket.isClosed()){
                  socket.receive(packet);
               }
               process((new String(packet.getData())).trim());
            } while (true);
         } catch (IOException e) {
            e.printStackTrace();
         }
      }

      
      // �۵��κ� 
      private void process(String message) {
    	  //System.out.println(message);
         a = MouseInfo.getPointerInfo();
         b = a.getLocation();
         int x = (int) b.getX();
         int y = (int) b.getY();
         split = message.split(":");
         //System.out.println(split[1]);

         // ctrl + c ����
         if (split[1].compareTo(MESSAGE_wordCopy) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
        	 robot.keyPress(KeyEvent.VK_C);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_C);
         }
         // ctrl + v �ٿ�����
         else if (split[1].compareTo(MESSAGE_wordPaste) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
        	 robot.keyPress(KeyEvent.VK_V);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_V);
         }
         // ctrl + n ���� �����
         else if (split[1].compareTo(MESSAGE_wordCreate) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
        	 robot.keyPress(KeyEvent.VK_N);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_N);
         }
         // ctrl + p �μ� �ϱ�
         else if (split[1].compareTo(MESSAGE_wordPrint) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
        	 robot.keyPress(KeyEvent.VK_P);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_P);
         }
         // ctrl + x �߶󳻱�
         else if (split[1].compareTo(MESSAGE_wordCut) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
        	 robot.keyPress(KeyEvent.VK_X);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_X);
         }
         // F12 �ٸ��̸����� ����
         else if (split[1].compareTo(MESSAGE_wordSaveAname) == 0) {
        	 robot.keyPress(KeyEvent.VK_F12);
        	 robot.keyRelease(KeyEvent.VK_F12);
         }
         // ctrl + F2 �μ�̸�����
         else if (split[1].compareTo(MESSAGE_wordPrintlook) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
        	 robot.keyPress(KeyEvent.VK_F2);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_F2);
         }
         /*
         // shift + ȭ��ǥ    ��� ����
         else if (split[1].compareTo(MESSAGE_wordBlockSet) == 0) {
        	 robot.keyPress(KeyEvent.VK_SHIFT);
        	 robot.keyPress(KeyEvent.VK_LEFT);
        	 robot.keyRelease(KeyEvent.VK_SHIFT);
        	 robot.keyRelease(KeyEvent.VK_LEFT);
         }
         */
         // ctrl + shift + c  ���ĺ���
         else if (split[1].compareTo(MESSAGE_wordFormCopy) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
        	 robot.keyPress(KeyEvent.VK_SHIFT);
        	 robot.keyPress(KeyEvent.VK_C);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_SHIFT);
        	 robot.keyRelease(KeyEvent.VK_C);
         }
         // ctrl + shift + v  ���ĺٿ��ֱ�
         else if (split[1].compareTo(MESSAGE_wordFormPaste) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
        	 robot.keyPress(KeyEvent.VK_SHIFT);
        	 robot.keyPress(KeyEvent.VK_V);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_SHIFT);
        	 robot.keyRelease(KeyEvent.VK_V);
         }
         // ctrl + Alt + m  �޸�ֱ�
         else if (split[1].compareTo(MESSAGE_wordtoTheMemo) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
        	 robot.keyPress(KeyEvent.VK_ALT);
        	 robot.keyPress(KeyEvent.VK_M);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_ALT);
        	 robot.keyRelease(KeyEvent.VK_M);
         }
         // ctrl + shift + F5  å���� �ֱ�
         else if (split[1].compareTo(MESSAGE_wordBookIn) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
        	 robot.keyPress(KeyEvent.VK_SHIFT);
        	 robot.keyPress(KeyEvent.VK_F5);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_SHIFT);
        	 robot.keyRelease(KeyEvent.VK_F5);
         }
         // ctrl + Alt + d  ���ֱֳ�
         else if (split[1].compareTo(MESSAGE_wordMijoo) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
        	 robot.keyPress(KeyEvent.VK_ALT);
        	 robot.keyPress(KeyEvent.VK_D);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_ALT);
        	 robot.keyRelease(KeyEvent.VK_D);
         }
         // ctrl + Alt + f  ���ֱֳ�
         else if (split[1].compareTo(MESSAGE_wordtoTheMemo) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
        	 robot.keyPress(KeyEvent.VK_ALT);
        	 robot.keyPress(KeyEvent.VK_F);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_ALT);
        	 robot.keyRelease(KeyEvent.VK_F);
         }
         // ctrl + shift + enter  �� ������
         else if (split[1].compareTo(MESSAGE_wordDandiverse) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
        	 robot.keyPress(KeyEvent.VK_SHIFT);
        	 robot.keyPress(KeyEvent.VK_ENTER);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_SHIFT);
        	 robot.keyRelease(KeyEvent.VK_ENTER);
         }
         // Alt + shift + t  �ð� �ʵ� �ֱ�
         else if (split[1].compareTo(MESSAGE_wordTimeField) == 0) {
        	 robot.keyPress(KeyEvent.VK_ALT);
        	 robot.keyPress(KeyEvent.VK_SHIFT);
        	 robot.keyPress(KeyEvent.VK_T);
        	 robot.keyRelease(KeyEvent.VK_ALT);
        	 robot.keyRelease(KeyEvent.VK_SHIFT);
        	 robot.keyRelease(KeyEvent.VK_T);
         }
         // Alt + shift + p  ������ �ʵ� �ֱ�
         else if (split[1].compareTo(MESSAGE_wordPageField) == 0) {
        	 robot.keyPress(KeyEvent.VK_ALT);
        	 robot.keyPress(KeyEvent.VK_SHIFT);
        	 robot.keyPress(KeyEvent.VK_P);
        	 robot.keyRelease(KeyEvent.VK_ALT);
        	 robot.keyRelease(KeyEvent.VK_SHIFT);
        	 robot.keyRelease(KeyEvent.VK_P);
         }
         // ctrl + shift + f  �۲� �ٲٱ�
         else if (split[1].compareTo(MESSAGE_wordMotionChange) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
        	 robot.keyPress(KeyEvent.VK_SHIFT);
        	 robot.keyPress(KeyEvent.VK_F);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_SHIFT);
        	 robot.keyRelease(KeyEvent.VK_F);
         }
         // ctrl + shift + p  �۲� ũ�� �ٲٱ�
         else if (split[1].compareTo(MESSAGE_wordMotionSizeChange) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
        	 robot.keyPress(KeyEvent.VK_SHIFT);
        	 robot.keyPress(KeyEvent.VK_P);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_SHIFT);
        	 robot.keyRelease(KeyEvent.VK_P);
         }
         // ctrl + shift + s  ��Ÿ�� �ٲٱ�
         else if (split[1].compareTo(MESSAGE_wordStyleChange) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
        	 robot.keyPress(KeyEvent.VK_SHIFT);
        	 robot.keyPress(KeyEvent.VK_S);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_SHIFT);
        	 robot.keyRelease(KeyEvent.VK_S);
         }
         // ctrl + r  ���� ����
         else if (split[1].compareTo(MESSAGE_wordleftCenter) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
        	 robot.keyPress(KeyEvent.VK_R);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_R);
         }
         // ctrl + e  ��� ����
         else if (split[1].compareTo(MESSAGE_wordrightCenter) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
        	 robot.keyPress(KeyEvent.VK_E);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_E);
         }
         // ctrl + j  ���� ����
         else if (split[1].compareTo(MESSAGE_wordCenter) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
        	 robot.keyPress(KeyEvent.VK_J);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_J);
        	 System.out.println("hello");
         }
         // ctrl + shift + a  ��� �빮�ڷ�
         else if (split[1].compareTo(MESSAGE_wordCapWord) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
        	 robot.keyPress(KeyEvent.VK_SHIFT);
        	 robot.keyPress(KeyEvent.VK_A);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_SHIFT);
        	 robot.keyRelease(KeyEvent.VK_A);
         }
         // F7  ����� �˻�
         else if (split[1].compareTo(MESSAGE_wordCheck) == 0) {
        	 robot.keyPress(KeyEvent.VK_F7);
        	 robot.keyRelease(KeyEvent.VK_F7);
         }
         // alt + control + s  â��Ȱ
         else if (split[1].compareTo(MESSAGE_wordWindowDiv) == 0) {
        	 robot.keyPress(KeyEvent.VK_ALT);
        	 robot.keyPress(KeyEvent.VK_CONTROL);
        	 robot.keyPress(KeyEvent.VK_S);
        	 robot.keyRelease(KeyEvent.VK_ALT);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_S);
         }
         // alt + F5 ������üȭ��
         else if (split[1].compareTo(MESSAGE_wordTotalWindow) == 0) {
        	 robot.keyPress(KeyEvent.VK_ALT);
        	 robot.keyPress(KeyEvent.VK_F5);
        	 robot.keyRelease(KeyEvent.VK_ALT);
        	 robot.keyRelease(KeyEvent.VK_F5);
         }
         // ctrl + F4 �ݱ�
         else if (split[1].compareTo(MESSAGE_wordClose) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
        	 robot.keyPress(KeyEvent.VK_F4);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_F4);
         }
         // ctrl + b ���� ����
         else if (split[1].compareTo(MESSAGE_wordBold) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
        	 robot.keyPress(KeyEvent.VK_B);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_B);
         }
         // ctrl + a ��ü����
         else if (split[1].compareTo(MESSAGE_wordTotalSelect) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
        	 robot.keyPress(KeyEvent.VK_A);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_A);
         }
         // ctrl + o ��������
         else if (split[1].compareTo(MESSAGE_wordOpen) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
          	 robot.keyPress(KeyEvent.VK_O);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_O);
         }
         // ctrl + f ã��
         else if (split[1].compareTo(MESSAGE_wordFound) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
          	 robot.keyPress(KeyEvent.VK_F);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_F);
         }
         // ctrl + z �۾� ���� ���
         else if (split[1].compareTo(MESSAGE_wordCancle) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
          	 robot.keyPress(KeyEvent.VK_Z);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_Z);
         }
         // ctrl + y �۾� �����
         else if (split[1].compareTo(MESSAGE_wordRePlay) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
          	 robot.keyPress(KeyEvent.VK_Y);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_Y);
         }
         // ctrl + s ���� ����
         else if (split[1].compareTo(MESSAGE_wordSave) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
          	 robot.keyPress(KeyEvent.VK_S);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_S);
         }
         // ctrl + ] �۲�ũ�� 1����Ʈ �ø�
         else if (split[1].compareTo(MESSAGE_wordPlusOne) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
          	 robot.keyPress(KeyEvent.VK_CLOSE_BRACKET);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_CLOSE_BRACKET);
         }
         // ctrl + [ �۲�ũ�� 1����Ʈ ����
         else if (split[1].compareTo(MESSAGE_wordDownOne) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
          	 robot.keyPress(KeyEvent.VK_OPEN_BRACKET);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_OPEN_BRACKET);
         }
         // ctrl + D �۲� ����
         else if (split[1].compareTo(MESSAGE_wordMotionSet) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
          	 robot.keyPress(KeyEvent.VK_D);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_D);
         }
         // ctrl + 1 1�� ����
         else if (split[1].compareTo(MESSAGE_wordlineOne) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
          	 robot.keyPress(KeyEvent.VK_1);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_1);
         }
         // ctrl + 2 2�� ����
         else if (split[1].compareTo(MESSAGE_wordlineTwo) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
          	 robot.keyPress(KeyEvent.VK_2);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_2);
         }
         // ctrl + 5 1.5�� ����
         else if (split[1].compareTo(MESSAGE_wordlineOneTwo) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
          	 robot.keyPress(KeyEvent.VK_5);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_5);
         }
         // ctrl + m �鿩����
         else if (split[1].compareTo(MESSAGE_wordAdopt) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
          	 robot.keyPress(KeyEvent.VK_M);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_M);
         }
         // F1 ����
         else if (split[1].compareTo(MESSAGE_wordHelp) == 0) {
        	 robot.keyPress(KeyEvent.VK_F1);
        	 robot.keyRelease(KeyEvent.VK_F1);
         }
         // F4 ������ �۾� �ݺ��ϱ� 
         else if (split[1].compareTo(MESSAGE_wordFinalRe) == 0) {
        	 robot.keyPress(KeyEvent.VK_F4);
        	 robot.keyRelease(KeyEvent.VK_F4);
         }
         // shift + F7 ���Ǿ� ����
         else if (split[1].compareTo(MESSAGE_wordSynonym) == 0) {
        	 robot.keyPress(KeyEvent.VK_SHIFT);
        	 robot.keyPress(KeyEvent.VK_F7);
        	 robot.keyRelease(KeyEvent.VK_SHIFT);
        	 robot.keyRelease(KeyEvent.VK_F7);
         }
         // ctrl + u ���� ����
         else if (split[1].compareTo(MESSAGE_wordUnderline) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
          	 robot.keyPress(KeyEvent.VK_U);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_U);
         }
         // ctrl + l �۲� ����̱�
         else if (split[1].compareTo(MESSAGE_wordMotionLean) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
          	 robot.keyPress(KeyEvent.VK_L);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_L);
         }
         // ctrl + alt + n �⺻ȭ�� ����
         else if (split[1].compareTo(MESSAGE_wordInitial) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
          	 robot.keyPress(KeyEvent.VK_ALT);
          	 robot.keyPress(KeyEvent.VK_N);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_ALT);
        	 robot.keyRelease(KeyEvent.VK_N);
         }
         // ctrl + F10 ����â�� �� �� ȭ��
         else if (split[1].compareTo(MESSAGE_wordFullScreen) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
          	 robot.keyPress(KeyEvent.VK_F10);
        	 robot.keyRelease(KeyEvent.VK_CONTROL);
        	 robot.keyRelease(KeyEvent.VK_F10);
         }
  
         
         
         
         
         // mouse pad
         else if (split[1].compareTo(MESSAGE_MOUSELEFT) == 0) {
            robot.mousePress(16);
            robot.mouseRelease(16);
         } else if (split[1].compareTo(MESSAGE_MOUSERIGHT) == 0) {
            robot.mousePress(4);
            robot.mouseRelease(4);
         } else if (split[1].compareTo(MESSAGE_LEFT) == 0) {
            robot.keyPress(37);
            robot.keyRelease(37);
         } else if (split[1].compareTo(MESSAGE_RIGHT) == 0) {
            robot.keyPress(39);
            robot.keyRelease(39);
         } else if (split[1].compareTo(MESSAGE_FULL) == 0) {
            robot.keyPress(10);
            robot.keyRelease(10);
         } else if (split[1].compareTo(MESSAGE_SOUNDUP) == 0) {
            robot.keyPress(38);
            robot.keyRelease(38);
         } else if (split[1].compareTo(MESSAGE_SOUNDDOWN) == 0) {
            robot.keyPress(40);
            robot.keyRelease(40);
         } else if (split[1].compareTo(MOUSE) == 0) {
            robot.mouseMove(x + Integer.parseInt(split[2]), y + Integer.parseInt(split[3]));
         } else if (split[1].compareTo(MESSAGE_A) == 0) {
             robot.keyPress(KeyEvent.VK_7);
             robot.keyRelease(KeyEvent.VK_7);
         }
         else if (split[1].compareTo(MESSAGE_B) == 0) {
             robot.keyPress(KeyEvent.VK_8);
             robot.keyRelease(KeyEvent.VK_8);
         }
         else if (split[1].compareTo(MESSAGE_C) == 0) {
             robot.keyPress(KeyEvent.VK_9);
             robot.keyRelease(KeyEvent.VK_9);
         }
         else if (split[1].compareTo(MESSAGE_D) == 0) {
             robot.keyPress(KeyEvent.VK_0);
             robot.keyRelease(KeyEvent.VK_0);
         }
         
         else if (split[1].compareTo(MESSAGE_A1) == 0) {
             robot.keyPress(KeyEvent.VK_CONTROL);
             robot.keyPress(KeyEvent.VK_B);
             robot.keyRelease(KeyEvent.VK_CONTROL);
             robot.keyRelease(KeyEvent.VK_B);
         }
         /*
         else if (split[1].compareTo(MESSAGE_B1) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
             robot.keyPress(KeyEvent.VK_A);
             robot.keyRelease(KeyEvent.VK_CONTROL);
             robot.keyRelease(KeyEvent.VK_A);
         }
         else if (split[1].compareTo(MESSAGE_C1) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
             robot.keyPress(KeyEvent.VK_C);
             robot.keyRelease(KeyEvent.VK_CONTROL);
             robot.keyRelease(KeyEvent.VK_C);
         }
         else if (split[1].compareTo(MESSAGE_D1) == 0) {
        	 robot.keyPress(KeyEvent.VK_CONTROL);
             robot.keyPress(KeyEvent.VK_V);
             robot.keyRelease(KeyEvent.VK_CONTROL);
             robot.keyRelease(KeyEvent.VK_V);
         }
         */
      }
   }
}

