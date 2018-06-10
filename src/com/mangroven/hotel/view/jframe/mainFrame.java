package com.mangroven.hotel.view.jframe;

import com.mangroven.hotel.dao.db.ConnectionFactory;
import com.mangroven.hotel.view.jpanel.backup;
import com.mangroven.hotel.view.jpanel.reports;
import com.mangroven.hotel.view.jpanel.coverPanele;
import com.mangroven.hotel.view.jpanel.fullPaymentPanel;
import com.mangroven.hotel.view.jpanel.modReservePanel;
import com.mangroven.hotel.view.jpanel.modRoomPanel;
import com.mangroven.hotel.view.jpanel.publicPackage1;
import com.mangroven.hotel.view.jpanel.roomPanel;
import com.mangroven.hotel.view.jpanel.skipPanelAssemble;
import com.mangroven.hotel.view.jpanel.viewReservePanel;
import de.javasoft.plaf.synthetica.SyntheticaSilverMoonLookAndFeel;
import java.awt.Color;
import java.awt.DefaultKeyboardFocusManager;
import java.awt.KeyEventPostProcessor;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import net.codejava.swing.mail.Backup;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tharindu
 */
public class mainFrame extends javax.swing.JFrame {

    int xMouse;
    int yMouse;

    int timeRun = 0;
    private Connection conn;

    /**
     * Creates new form mainFrame
     */
    public mainFrame() throws SQLException {
        initComponents();
        try {

            conn = ConnectionFactory.getInstance().getConnection();

            startUi();
            setLocationRelativeTo(null);
            lblReservation.setForeground(Color.red);
            showTime();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        KeyboardFocusManager key = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        key.addKeyEventPostProcessor(new KeyEventPostProcessor() {

            @Override
            public boolean postProcessKeyEvent(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_F1:
                        if (e.getID() == KeyEvent.KEY_PRESSED) {
                            lblReservation();
                        }
                        break;

                    case KeyEvent.VK_F2:
                        if (e.getID() == KeyEvent.KEY_PRESSED) {
                            lblRoom();
                        }
                        break;
                    case KeyEvent.VK_F3:
                        if (e.getID() == KeyEvent.KEY_PRESSED) {
                            lblOrder();
                        }
                        break;
                    case KeyEvent.VK_F4:
                        if (e.getID() == KeyEvent.KEY_PRESSED) {
                            lblPayment();
                        }
                        break;
                    case KeyEvent.VK_F5:
                        if (e.getID() == KeyEvent.KEY_PRESSED) {
                            lblViewReservation();
                        }
                        break;
                        
                    case KeyEvent.VK_F6:
                        if (e.getID() == KeyEvent.KEY_PRESSED) {
                            lblModifyReserve();
                        }
                        break;    
                        
                    case KeyEvent.VK_F7:
                        if (e.getID() == KeyEvent.KEY_PRESSED) {
                            lblModRooms();
                        }
                        break;
                    case KeyEvent.VK_F8:
                        if (e.getID() == KeyEvent.KEY_PRESSED) {
                            lblAssemble();
                        }
                        break;

                    case KeyEvent.VK_F9:
                        if (e.getID() == KeyEvent.KEY_PRESSED) {
                            lblChangePassword();
                        }
                        break;
                    case KeyEvent.VK_F10:
                        if (e.getID() == KeyEvent.KEY_PRESSED) {
                            lblCost();
                        }
                        break;
                    case KeyEvent.VK_F11:
                        if (e.getID() == KeyEvent.KEY_PRESSED) {
                            lblReport();
                        }
                        break;
                }
                return true;
            }
        });

    }

    private void showTime() {
        Timer tTimer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                Calendar cal = new GregorianCalendar();
                Date d1 = new Date(); //java.util.Date ->get Current date and time
                SimpleDateFormat df = new SimpleDateFormat("yyyy - MM - dd");
                String formatDate = df.format(d1);
                //checkIN.setText(formatDate);
                // checkOut.setText(formatDate);
                txtDate.setText(formatDate);

                int AM_PM = cal.get(Calendar.AM_PM);

                String day_night = "";
                if (AM_PM == 1) {
                    day_night = "PM";
                } else {
                    day_night = "AM";
                }
                SimpleDateFormat sdf = new SimpleDateFormat("hh : mm : ss ");
                String formattedTime = sdf.format(d);
                Time.setText(formattedTime + " " + day_night);
            }

        });
        tTimer.start();

    }

    /*public void ShowTime() {
     Thread t = new Thread() {
     public void run() {
     while (timeRun == 0) {
     Calendar cal = new GregorianCalendar();

     Date d1 = new Date(); //java.util.Date ->get Current date and time
     SimpleDateFormat df = new SimpleDateFormat("yyyy - MM - dd");
     String formatDate = df.format(d1);
     //checkIN.setText(formatDate);
     // checkOut.setText(formatDate);
     txtDate.setText(formatDate);

     int h = cal.get(Calendar.HOUR);
     int m = cal.get(Calendar.MINUTE);
     int s = cal.get(Calendar.SECOND);
     int AM_PM = cal.get(Calendar.AM_PM);

     String day_night = "";
     if (AM_PM == 1) {
     day_night = "PM";
     } else {
     day_night = "AM";
     }

     String time = h + " : " + m + " : " + s + " " + day_night;
     Time.setText(time);
     }
     }
     };
     t.start();
     }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHead = new javax.swing.JPanel();
        pnlToolBar = new javax.swing.JPanel();
        lblInvoice = new javax.swing.JLabel();
        lblMenu = new javax.swing.JLabel();
        pnlCloseMin = new javax.swing.JPanel();
        lblClose = new javax.swing.JLabel();
        lblMin = new javax.swing.JLabel();
        lblB = new javax.swing.JLabel();
        pnlCenter = new javax.swing.JPanel();
        pnlBottom = new javax.swing.JPanel();
        Time = new javax.swing.JLabel();
        txtDate = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlButtons = new javax.swing.JPanel();
        pnlButtons1 = new javax.swing.JPanel();
        pnlButtons2 = new javax.swing.JPanel();
        lblRoom = new javax.swing.JLabel();
        lblReservation = new javax.swing.JLabel();
        lblOrder = new javax.swing.JLabel();
        lblPayment = new javax.swing.JLabel();
        lblModifyReserve = new javax.swing.JLabel();
        lblViewReservation = new javax.swing.JLabel();
        lblModRooms = new javax.swing.JLabel();
        lblAssemble = new javax.swing.JLabel();
        lblChangePassword = new javax.swing.JLabel();
        lblCost = new javax.swing.JLabel();
        lblReport = new javax.swing.JLabel();
        sprtrSearch = new javax.swing.JSeparator();
        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        lblLeftArrow = new javax.swing.JLabel();
        sprtrBottom = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        mainPanel = new javax.swing.JPanel();
        lblRiverView = new javax.swing.JLabel();
        sprtrTop = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnlHead.setBackground(new java.awt.Color(255, 255, 255));
        pnlHead.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pnlToolBar.setBackground(new java.awt.Color(102, 102, 102));
        pnlToolBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblInvoice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInvoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/Visible_20px.png"))); // NOI18N
        lblInvoice.setToolTipText("Invoice");
        lblInvoice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblInvoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblInvoiceMouseClicked(evt);
            }
        });
        pnlToolBar.add(lblInvoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, 40, 30));

        lblMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/Menu_35px.png"))); // NOI18N
        lblMenu.setToolTipText("Notification");
        lblMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMenuMouseClicked(evt);
            }
        });
        pnlToolBar.add(lblMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 30));

        pnlCloseMin.setBackground(new java.awt.Color(102, 102, 102));

        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/close.png"))); // NOI18N
        lblClose.setToolTipText("Close");
        lblClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });

        lblMin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/mini.png"))); // NOI18N
        lblMin.setToolTipText("Minimize");
        lblMin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlCloseMinLayout = new javax.swing.GroupLayout(pnlCloseMin);
        pnlCloseMin.setLayout(pnlCloseMinLayout);
        pnlCloseMinLayout.setHorizontalGroup(
            pnlCloseMinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCloseMinLayout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addComponent(lblMin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlCloseMinLayout.setVerticalGroup(
            pnlCloseMinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblMin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlToolBar.add(pnlCloseMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 10, -1, -1));

        lblB.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        lblB.setForeground(new java.awt.Color(255, 255, 255));
        lblB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblB.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lblBMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblBMouseMoved(evt);
            }
        });
        pnlToolBar.add(lblB, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 0, 1420, 50));

        pnlCenter.setBackground(new java.awt.Color(255, 255, 255));
        pnlCenter.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        pnlBottom.setBackground(new java.awt.Color(102, 102, 102));
        pnlBottom.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Time.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        Time.setForeground(new java.awt.Color(255, 255, 255));
        Time.setText("ghgjhhgjhgjkjh");
        pnlBottom.add(Time, new org.netbeans.lib.awtextra.AbsoluteConstraints(1229, 0, 113, 29));

        txtDate.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        txtDate.setForeground(new java.awt.Color(255, 255, 255));
        txtDate.setText("ghgjhhgjhgjkjh");
        pnlBottom.add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 0, 113, 29));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/Calculator_27px.png"))); // NOI18N
        jLabel1.setToolTipText("Calculator");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        pnlBottom.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 0, -1, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/Google Drive_20px.png"))); // NOI18N
        jLabel2.setToolTipText("Backup");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        pnlBottom.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1088, 0, 30, 30));

        pnlButtons.setBackground(new java.awt.Color(254, 254, 254));

        pnlButtons1.setBackground(new java.awt.Color(254, 254, 254));
        pnlButtons1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlButtons1MouseEntered(evt);
            }
        });

        pnlButtons2.setBackground(new java.awt.Color(204, 204, 204));
        pnlButtons2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblRoom.setBackground(new java.awt.Color(254, 254, 254));
        lblRoom.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblRoom.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/folder.gif"))); // NOI18N
        lblRoom.setText("   View Rooms");
        lblRoom.setToolTipText(" View Rooms  (F2)");
        lblRoom.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblRoom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRoom.setOpaque(true);
        lblRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRoomMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblRoomMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRoomMouseExited(evt);
            }
        });

        lblReservation.setBackground(new java.awt.Color(254, 254, 254));
        lblReservation.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblReservation.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblReservation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/folder.gif"))); // NOI18N
        lblReservation.setText("   Select The Date");
        lblReservation.setToolTipText("Select The Date (F1)");
        lblReservation.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblReservation.setOpaque(true);
        lblReservation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblReservationMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblReservationMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblReservationMouseExited(evt);
            }
        });

        lblOrder.setBackground(new java.awt.Color(255, 255, 255));
        lblOrder.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblOrder.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/folder.gif"))); // NOI18N
        lblOrder.setText("   Create Order");
        lblOrder.setToolTipText("Create Order  (F3)");
        lblOrder.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblOrder.setOpaque(true);
        lblOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOrderMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblOrderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblOrderMouseExited(evt);
            }
        });

        lblPayment.setBackground(new java.awt.Color(255, 255, 255));
        lblPayment.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblPayment.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPayment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/folder.gif"))); // NOI18N
        lblPayment.setText("   View Payment");
        lblPayment.setToolTipText(" View  Payment   (F4)");
        lblPayment.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblPayment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblPayment.setOpaque(true);
        lblPayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPaymentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPaymentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblPaymentMouseExited(evt);
            }
        });

        lblModifyReserve.setBackground(new java.awt.Color(255, 255, 255));
        lblModifyReserve.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblModifyReserve.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblModifyReserve.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/folder.gif"))); // NOI18N
        lblModifyReserve.setText("   Modify Reservations");
        lblModifyReserve.setToolTipText("   Modify Reservations");
        lblModifyReserve.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblModifyReserve.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblModifyReserve.setOpaque(true);
        lblModifyReserve.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblModifyReserveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblModifyReserveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblModifyReserveMouseExited(evt);
            }
        });

        lblViewReservation.setBackground(new java.awt.Color(255, 255, 255));
        lblViewReservation.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblViewReservation.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblViewReservation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/folder.gif"))); // NOI18N
        lblViewReservation.setText("   View Reserve Details");
        lblViewReservation.setToolTipText("   View Reserve Details");
        lblViewReservation.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblViewReservation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblViewReservation.setOpaque(true);
        lblViewReservation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblViewReservationMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblViewReservationMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblViewReservationMouseExited(evt);
            }
        });

        lblModRooms.setBackground(new java.awt.Color(255, 255, 255));
        lblModRooms.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblModRooms.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblModRooms.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/folder.gif"))); // NOI18N
        lblModRooms.setText("   Modify Rooms");
        lblModRooms.setToolTipText("   Modify Rooms");
        lblModRooms.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblModRooms.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblModRooms.setOpaque(true);
        lblModRooms.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblModRoomsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblModRoomsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblModRoomsMouseExited(evt);
            }
        });

        lblAssemble.setBackground(new java.awt.Color(255, 255, 255));
        lblAssemble.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblAssemble.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAssemble.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/folder.gif"))); // NOI18N
        lblAssemble.setText("   Assemble Tool");
        lblAssemble.setToolTipText("   Assemble Tool");
        lblAssemble.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblAssemble.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAssemble.setOpaque(true);
        lblAssemble.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAssembleMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAssembleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAssembleMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlButtons2Layout = new javax.swing.GroupLayout(pnlButtons2);
        pnlButtons2.setLayout(pnlButtons2Layout);
        pnlButtons2Layout.setHorizontalGroup(
            pnlButtons2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtons2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlButtons2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblViewReservation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblModifyReserve, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblModRooms, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAssemble, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblReservation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlButtons2Layout.setVerticalGroup(
            pnlButtons2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtons2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lblRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(lblOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(lblPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lblViewReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(lblModifyReserve, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(lblModRooms, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lblAssemble, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        lblChangePassword.setBackground(new java.awt.Color(254, 254, 254));
        lblChangePassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblChangePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/Unlock_30px.png"))); // NOI18N
        lblChangePassword.setToolTipText("Password Tool");
        lblChangePassword.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblChangePassword.setOpaque(true);
        lblChangePassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblChangePasswordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblChangePasswordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblChangePasswordMouseExited(evt);
            }
        });

        lblCost.setBackground(new java.awt.Color(254, 254, 254));
        lblCost.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCost.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/Data Backup_30px.png"))); // NOI18N
        lblCost.setToolTipText("Data Backup Tool");
        lblCost.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblCost.setOpaque(true);
        lblCost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCostMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCostMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCostMouseExited(evt);
            }
        });

        lblReport.setBackground(new java.awt.Color(254, 254, 254));
        lblReport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/Accounting_30px.png"))); // NOI18N
        lblReport.setToolTipText("Reports");
        lblReport.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblReport.setOpaque(true);
        lblReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblReportMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblReportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblReportMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlButtons1Layout = new javax.swing.GroupLayout(pnlButtons1);
        pnlButtons1.setLayout(pnlButtons1Layout);
        pnlButtons1Layout.setHorizontalGroup(
            pnlButtons1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtons1Layout.createSequentialGroup()
                .addComponent(pnlButtons2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlButtons1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(lblChangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCost, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblReport, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        pnlButtons1Layout.setVerticalGroup(
            pnlButtons1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtons1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlButtons2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(pnlButtons1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCost, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(lblChangePassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout pnlButtonsLayout = new javax.swing.GroupLayout(pnlButtons);
        pnlButtons.setLayout(pnlButtonsLayout);
        pnlButtonsLayout.setHorizontalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlButtons1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlButtonsLayout.setVerticalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlButtons1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/Search_30px.png"))); // NOI18N
        lblSearch.setToolTipText(" Search Room Detail");

        txtSearch.setFont(new java.awt.Font("Noto Sans", 2, 12)); // NOI18N
        txtSearch.setText("Enter Room ID"); // NOI18N
        txtSearch.setToolTipText(" Search Room Detail");
        txtSearch.setBorder(null);
        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchMouseClicked(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        lblLeftArrow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLeftArrow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLeftArrowMouseClicked(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        mainPanel.setBackground(new java.awt.Color(243, 243, 243));
        mainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1095, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 643, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlCenterLayout = new javax.swing.GroupLayout(pnlCenter);
        pnlCenter.setLayout(pnlCenterLayout);
        pnlCenterLayout.setHorizontalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlCenterLayout.createSequentialGroup()
                        .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCenterLayout.createSequentialGroup()
                                .addComponent(lblSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sprtrSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(pnlButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1355, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLeftArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(998, Short.MAX_VALUE))
            .addGroup(pnlCenterLayout.createSequentialGroup()
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sprtrBottom, javax.swing.GroupLayout.DEFAULT_SIZE, 1369, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlCenterLayout.setVerticalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCenterLayout.createSequentialGroup()
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCenterLayout.createSequentialGroup()
                        .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlCenterLayout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sprtrSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblLeftArrow, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCenterLayout.createSequentialGroup()
                        .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnlButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBottom, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sprtrBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(347, 347, 347))
        );

        lblRiverView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/IMG-20170324-WA0003.png"))); // NOI18N
        lblRiverView.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblRiverViewMouseMoved(evt);
            }
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lblRiverViewMouseDragged(evt);
            }
        });

        javax.swing.GroupLayout pnlHeadLayout = new javax.swing.GroupLayout(pnlHead);
        pnlHead.setLayout(pnlHeadLayout);
        pnlHeadLayout.setHorizontalGroup(
            pnlHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeadLayout.createSequentialGroup()
                .addGroup(pnlHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sprtrTop)
                    .addGroup(pnlHeadLayout.createSequentialGroup()
                        .addGroup(pnlHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlHeadLayout.createSequentialGroup()
                                .addComponent(lblRiverView, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 1136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pnlCenter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlHeadLayout.setVerticalGroup(
            pnlHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeadLayout.createSequentialGroup()
                .addGroup(pnlHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblRiverView, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sprtrTop, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCenter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlHead, javax.swing.GroupLayout.PREFERRED_SIZE, 1370, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlHead, javax.swing.GroupLayout.PREFERRED_SIZE, 770, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        int i = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Are you Sure?", JOptionPane.YES_NO_OPTION);
        if (i == 0) {
            System.exit(0);
        } else {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }


    }//GEN-LAST:event_lblCloseMouseClicked

    private void lblMinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinMouseClicked
        this.setState(mainFrame.ICONIFIED);// TODO add your handling code here:
    }//GEN-LAST:event_lblMinMouseClicked

    private void lblRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRoomMouseClicked
        lblRoom();

    }//GEN-LAST:event_lblRoomMouseClicked

    private void lblRoomMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRoomMouseExited
        lblRoom.setBackground(Color.white);
        lblRoom.setOpaque(true);      // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_lblRoomMouseExited

    private void lblRoomMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRoomMouseEntered
        lblRoom.setBackground(new Color(204, 204, 255));
        lblRoom.setOpaque(true);        // TODO add your handling code here:
    }//GEN-LAST:event_lblRoomMouseEntered

    private void lblReservationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReservationMouseClicked
        lblReservation();
    }//GEN-LAST:event_lblReservationMouseClicked

    private void lblReservationMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReservationMouseExited
        lblReservation.setBackground(Color.white);
        lblReservation.setOpaque(true);        // TODO add your handling code here:
    }//GEN-LAST:event_lblReservationMouseExited

    private void lblReservationMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReservationMouseEntered
        lblReservation.setBackground(new Color(204, 204, 255));
        lblReservation.setOpaque(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_lblReservationMouseEntered

    private void lblOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOrderMouseClicked
        lblOrder();

    }//GEN-LAST:event_lblOrderMouseClicked

    private void lblOrderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOrderMouseExited
        lblOrder.setBackground(Color.white);
        lblOrder.setOpaque(true);        // TODO add your handling code here:
    }//GEN-LAST:event_lblOrderMouseExited

    private void lblOrderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOrderMouseEntered
        lblOrder.setBackground(new Color(204, 204, 255));
        lblOrder.setOpaque(true);        // TODO add your handling code here:
    }//GEN-LAST:event_lblOrderMouseEntered

    private void lblPaymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPaymentMouseClicked
        lblPayment();

    }//GEN-LAST:event_lblPaymentMouseClicked

    private void lblPaymentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPaymentMouseExited
        lblPayment.setBackground(Color.white);
        lblPayment.setOpaque(true);        // TODO add your handling code here:
    }//GEN-LAST:event_lblPaymentMouseExited

    private void lblPaymentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPaymentMouseEntered
        lblPayment.setBackground(new Color(204, 204, 255));
        lblPayment.setOpaque(true);        // TODO add your handling code here:
    }//GEN-LAST:event_lblPaymentMouseEntered

    private void lblModifyReserveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblModifyReserveMouseClicked
        lblModifyReserve();


    }//GEN-LAST:event_lblModifyReserveMouseClicked

    private void lblModifyReserveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblModifyReserveMouseExited
        lblModifyReserve.setBackground(Color.white);
        lblModifyReserve.setOpaque(true);        // TODO add your handling code here:
    }//GEN-LAST:event_lblModifyReserveMouseExited

    private void lblModifyReserveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblModifyReserveMouseEntered
        lblModifyReserve.setBackground(new Color(204, 204, 255));
        lblModifyReserve.setOpaque(true);        // TODO add your handling code here:
    }//GEN-LAST:event_lblModifyReserveMouseEntered

    private void lblViewReservationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewReservationMouseClicked
        lblViewReservation();

    }//GEN-LAST:event_lblViewReservationMouseClicked

    private void lblViewReservationMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewReservationMouseExited
        lblViewReservation.setBackground(Color.white);
        lblViewReservation.setOpaque(true);        // TODO add your handling code here:
    }//GEN-LAST:event_lblViewReservationMouseExited

    private void lblViewReservationMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewReservationMouseEntered
        lblViewReservation.setBackground(new Color(204, 204, 255));
        lblViewReservation.setOpaque(true);        // TODO add your handling code here:
    }//GEN-LAST:event_lblViewReservationMouseEntered

    private void lblModRoomsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblModRoomsMouseClicked
        lblModRooms();


    }//GEN-LAST:event_lblModRoomsMouseClicked

    private void lblModRoomsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblModRoomsMouseExited
        lblModRooms.setBackground(Color.white);
        lblModRooms.setOpaque(true);        // TODO add your handling code here:
    }//GEN-LAST:event_lblModRoomsMouseExited

    private void lblModRoomsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblModRoomsMouseEntered
        lblModRooms.setBackground(new Color(204, 204, 255));
        lblModRooms.setOpaque(true);        // TODO add your handling code here:
    }//GEN-LAST:event_lblModRoomsMouseEntered

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
        txtSearch.selectAll();        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchMouseClicked

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        if (txtSearch.getText().equals("R01") | txtSearch.getText().equals("R02") | txtSearch.getText().equals("R03") | txtSearch.getText().equals("R04") | txtSearch.getText().equals("R05") | txtSearch.getText().equals("R06") | txtSearch.getText().equals("r01") | txtSearch.getText().equals("r02") | txtSearch.getText().equals("r03") | txtSearch.getText().equals("r04") | txtSearch.getText().equals("r05") | txtSearch.getText().equals("r06")) {
            try {
                aaa();
            } catch (IOException ex) {
                Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Sorry Cannot Find Symbol");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void lblLeftArrowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLeftArrowMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_lblLeftArrowMouseClicked

    private void lblAssembleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAssembleMouseClicked
        lblAssemble();


    }//GEN-LAST:event_lblAssembleMouseClicked

    private void lblAssembleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAssembleMouseExited
        lblAssemble.setBackground(Color.white);  // TODO add your handling code here:
    }//GEN-LAST:event_lblAssembleMouseExited

    private void lblAssembleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAssembleMouseEntered
        lblAssemble.setBackground(new Color(204, 204, 255));
    }//GEN-LAST:event_lblAssembleMouseEntered

    private void pnlButtons1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlButtons1MouseEntered
        pnlButtons2.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_pnlButtons1MouseEntered

    private void lblChangePasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChangePasswordMouseClicked
        lblChangePassword();
    }//GEN-LAST:event_lblChangePasswordMouseClicked

    private void lblChangePasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChangePasswordMouseEntered

        lblChangePassword.setBorder(new LineBorder(Color.black, 3));
        /*setBackground(Color.gray);*/        // TODO add your handling code here:
    }//GEN-LAST:event_lblChangePasswordMouseEntered

    private void lblChangePasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChangePasswordMouseExited
        lblChangePassword.setBorder(new LineBorder(Color.black, 1)); // jLabel1.setBackground(Color.white);        // TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_lblChangePasswordMouseExited

    private void lblBMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBMouseMoved
        /*xMouse = evt.getX();
         yMouse = evt.getY();   */
    }//GEN-LAST:event_lblBMouseMoved

    private void lblBMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBMouseDragged
        /*        int x = evt.getXOnScreen();
         int y = evt.getYOnScreen();
         this.setLocation(x - xMouse, y - yMouse);   */
    }//GEN-LAST:event_lblBMouseDragged

    private void lblRiverViewMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRiverViewMouseMoved
        /*xMouse = evt.getX();
         yMouse = evt.getY();        */
    }//GEN-LAST:event_lblRiverViewMouseMoved

    private void lblRiverViewMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRiverViewMouseDragged
        /*int x = evt.getXOnScreen();
         int y = evt.getYOnScreen();
         this.setLocation(x - xMouse, y - yMouse);   */
    }//GEN-LAST:event_lblRiverViewMouseDragged

    private void lblCostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCostMouseClicked
        lblCost();


    }//GEN-LAST:event_lblCostMouseClicked

    private void lblCostMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCostMouseExited
        lblCost.setBorder(new LineBorder(Color.black, 1)); // TODO add your handling code here:
    }//GEN-LAST:event_lblCostMouseExited

    private void lblCostMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCostMouseEntered
        lblCost.setBorder(new LineBorder(Color.black, 3));        // TODO add your handling code here:
    }//GEN-LAST:event_lblCostMouseEntered

    private void lblReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReportMouseClicked
        lblReport();


    }//GEN-LAST:event_lblReportMouseClicked

    private void lblReportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReportMouseExited
        lblReport.setBorder(new LineBorder(Color.black, 1));  // TODO add your handling code here:
    }//GEN-LAST:event_lblReportMouseExited

    private void lblReportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReportMouseEntered
        lblReport.setBorder(new LineBorder(Color.black, 3));    // TODO add your handling code here:
    }//GEN-LAST:event_lblReportMouseEntered

    private void lblMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenuMouseClicked
        NotificationForm n1 = new NotificationForm();
        n1.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_lblMenuMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
 try {
            Runtime.getRuntime().exec("calc.exe");
        } catch (IOException ex) {
            Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void lblInvoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInvoiceMouseClicked
invoice in=new invoice();
in.setVisible(true);
    }//GEN-LAST:event_lblInvoiceMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
Backup b1=new Backup();
b1.BackupDbToSql();// TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String args[]) throws ClassNotFoundException {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(loginNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new mainFrame().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    //</editor-fold>
    //</editor-fold>

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Time;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblAssemble;
    private javax.swing.JLabel lblB;
    private javax.swing.JLabel lblChangePassword;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblCost;
    private javax.swing.JLabel lblInvoice;
    private javax.swing.JLabel lblLeftArrow;
    private javax.swing.JLabel lblMenu;
    private javax.swing.JLabel lblMin;
    private javax.swing.JLabel lblModRooms;
    private javax.swing.JLabel lblModifyReserve;
    private javax.swing.JLabel lblOrder;
    private javax.swing.JLabel lblPayment;
    private javax.swing.JLabel lblReport;
    private javax.swing.JLabel lblReservation;
    private javax.swing.JLabel lblRiverView;
    private javax.swing.JLabel lblRoom;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblViewReservation;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel pnlBottom;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlButtons1;
    private javax.swing.JPanel pnlButtons2;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlCloseMin;
    private javax.swing.JPanel pnlHead;
    private javax.swing.JPanel pnlToolBar;
    private javax.swing.JSeparator sprtrBottom;
    private javax.swing.JSeparator sprtrSearch;
    private javax.swing.JSeparator sprtrTop;
    private javax.swing.JLabel txtDate;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    public void startUi() {
        
        coverPanele c1 = new coverPanele();
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        c1.setSize(mainPanel.getSize());
        mainPanel.add(c1);
    }

    public void aaa() throws IOException {
        String s = txtSearch.getText();
        switch (s) {
            case "R01":
                book b1 = new book();
                b1.setVisible(true);
                ;
                break;
            case "r01":
                book b11 = new book();
                b11.setVisible(true);
                ;
                break;

            case "R02":
                bookB b2 = new bookB();
                b2.setVisible(true);
                ;
                break;
            case "r02":
                bookB b22 = new bookB();
                b22.setVisible(true);
                ;
                break;

            case "R03":
                BookC b3 = new BookC();
                b3.setVisible(true);
                ;
                break;
            case "r03":
                BookC b33 = new BookC();
                b33.setVisible(true);
                ;
                break;

            case "R04":
                bookD b4 = new bookD();
                b4.setVisible(true);
                ;
                break;
            case "r04":
                bookD b44 = new bookD();
                b44.setVisible(true);
                ;
                break;
            case "R05":
                BookE b41 = new BookE();
                b41.setVisible(true);
                ;
                break;
            case "r05":
                BookE b641 = new BookE();
                b641.setVisible(true);
                ;
                break;
            case "r06":
                bookF bg41 = new bookF();
                bg41.setVisible(true);
                ;
                break;
            case "R06":
                bookF b241 = new bookF();
                b241.setVisible(true);
                ;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Sorry Cannot find Symbole");

        }
    }
    /*  KeyboardFocusManager key=DefaultKeyboardFocusManager.getCurrentKeyboardFocusManager();
     key.addKeyEventPostProcessor(new KeyEventPostProcessor() {

     @Override
     public boolean postProcessKeyEvent(KeyEvent e) {
     switch(e.getKeyCode()){
     case KeyEvent.VK_F1:
     if(e.getID()== KeyEvent.KEY_PRESSED){
     jPanel4.setVisible(true);
     }
     break;
                        
     case KeyEvent.VK_F2: 
     if(e.getID()== KeyEvent.KEY_PRESSED){
     jPanel6.setVisible(true);
     }
     break;   
     case KeyEvent.VK_F3:
     if(e.getID()== KeyEvent.KEY_PRESSED){
     jPanel7.setVisible(true);
     }
     break;
     case KeyEvent.VK_F4:
     if(e.getID()==KeyEvent.KEY_PRESSED){
     jPanel8.setVisible(true);
     }
     break;    
     }
     return true;
     }
     });
    
     */

    private void settleAutoCommit() {
        try {
            conn.setAutoCommit(false);
            conn.rollback();
            conn.setAutoCommit(true);
        } catch (SQLException ex) {
            Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void lblReservation() {
        settleAutoCommit();

        lblReservation.setForeground(Color.RED);
        lblOrder.setForeground(Color.BLACK);
        lblPayment.setForeground(Color.BLACK);
        lblViewReservation.setForeground(Color.BLACK);
        lblModifyReserve.setForeground(Color.BLACK);
        lblModRooms.setForeground(Color.BLACK);
        lblAssemble.setForeground(Color.BLACK);
        lblRoom.setForeground(Color.black);
        coverPanele c1 = new coverPanele();
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        c1.setSize(mainPanel.getSize());
        mainPanel.add(c1);
    }

    private void lblRoom() {
        settleAutoCommit();


        /* A.setForeground(Color.black);
         B.setForeground(Color.black);
         C.setForeground(Color.black);*/
        lblReservation.setForeground(Color.BLACK);
        lblOrder.setForeground(Color.BLACK);
        lblPayment.setForeground(Color.BLACK);
        lblViewReservation.setForeground(Color.BLACK);
        lblModifyReserve.setForeground(Color.BLACK);
        lblModRooms.setForeground(Color.BLACK);
        //lblFaci.setForeground(Color.BLACK);
        lblAssemble.setForeground(Color.BLACK);
        lblRoom.setForeground(Color.red);

        roomPanel c1 = null;
        try {
            c1 = new roomPanel();
        } catch (Exception ex) {
            Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        c1.setSize(mainPanel.getSize());
        mainPanel.add(c1);

    }

    private void lblOrder() {
        settleAutoCommit();

        /*A.setForeground(Color.black);
         B.setForeground(Color.black);
         C.setForeground(Color.black);*/
        try {
            lblReservation.setForeground(Color.BLACK);
            lblOrder.setForeground(Color.red);
            lblPayment.setForeground(Color.BLACK);
            lblViewReservation.setForeground(Color.BLACK);
            lblModifyReserve.setForeground(Color.BLACK);
            lblModRooms.setForeground(Color.BLACK);
            // lblFaci.setForeground(Color.BLACK);
            lblAssemble.setForeground(Color.BLACK);
            lblRoom.setForeground(Color.black);

            /* skipPanelPackage c1 = null;
             try {
             c1 = new skipPanelPackage();
             } catch (IOException ex) {
             Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
             } catch (Exception ex) {
             Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
             }*/
            publicPackage1 c1 = new publicPackage1();

            mainPanel.removeAll();
            mainPanel.repaint();
            mainPanel.revalidate();
            c1.setSize(mainPanel.getSize());
            mainPanel.add(c1);    // TODO add your handling code here:
        } catch (Exception ex) {
            Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void lblPayment() {
        settleAutoCommit();

        lblReservation.setForeground(Color.BLACK);
        lblOrder.setForeground(Color.BLACK);
        lblPayment.setForeground(Color.red);
        lblViewReservation.setForeground(Color.BLACK);
        lblModifyReserve.setForeground(Color.BLACK);
        lblModRooms.setForeground(Color.BLACK);
        // lblFaci.setForeground(Color.BLACK);
        lblAssemble.setForeground(Color.BLACK);
        lblRoom.setForeground(Color.black);

        fullPaymentPanel c1 = null;
        try {
            c1 = new fullPaymentPanel();
        } catch (Exception ex) {
            Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        c1.setSize(mainPanel.getSize());
        mainPanel.add(c1);
    }

    private void lblViewReservation() {
        settleAutoCommit();

        lblReservation.setForeground(Color.BLACK);
        lblOrder.setForeground(Color.BLACK);
        lblPayment.setForeground(Color.BLACK);
        lblViewReservation.setForeground(Color.red);
        lblModifyReserve.setForeground(Color.BLACK);
        lblModRooms.setForeground(Color.BLACK);
        lblAssemble.setForeground(Color.BLACK);
        lblRoom.setForeground(Color.black);
        viewReservePanel c1 = new viewReservePanel();
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        c1.setSize(mainPanel.getSize());
        mainPanel.add(c1);
    }

    private void lblModifyReserve() {
        try {
            /* A.setForeground(Color.black);
             B.setForeground(Color.black);
             C.setForeground(Color.black);*/

            settleAutoCommit();

            lblReservation.setForeground(Color.BLACK);
            lblOrder.setForeground(Color.BLACK);
            lblPayment.setForeground(Color.BLACK);
            lblViewReservation.setForeground(Color.BLACK);
            lblModifyReserve.setForeground(Color.red);
            lblModRooms.setForeground(Color.BLACK);
            //   lblFaci.setForeground(Color.BLACK);
            lblAssemble.setForeground(Color.BLACK);
            lblRoom.setForeground(Color.black);

            modReservePanel c1 = new modReservePanel();

            mainPanel.removeAll();
            mainPanel.repaint();
            mainPanel.revalidate();
            c1.setSize(mainPanel.getSize());
            mainPanel.add(c1);
// TODO add your handling code here:
        } catch (Exception ex) {
            Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void lblModRooms() {
        settleAutoCommit();

        /* A.setForeground(Color.black);
         B.setForeground(Color.black);
         C.setForeground(Color.black);*/
        lblReservation.setForeground(Color.BLACK);
        lblOrder.setForeground(Color.BLACK);
        lblPayment.setForeground(Color.BLACK);
        lblViewReservation.setForeground(Color.BLACK);
        lblModifyReserve.setForeground(Color.BLACK);
        lblModRooms.setForeground(Color.red);
        // lblFaci.setForeground(Color.BLACK);
        lblAssemble.setForeground(Color.BLACK);
        lblRoom.setForeground(Color.black);

        modRoomPanel c1 = null;
        try {
            c1 = new modRoomPanel();
        } catch (Exception ex) {
            Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        c1.setSize(mainPanel.getSize());
        mainPanel.add(c1);
    }

    private void lblAssemble() {
        settleAutoCommit();

        /* A.setForeground(Color.black);
         B.setForeground(Color.black);
         C.setForeground(Color.black);*/
        lblReservation.setForeground(Color.BLACK);
        lblOrder.setForeground(Color.BLACK);
        lblPayment.setForeground(Color.BLACK);
        lblViewReservation.setForeground(Color.BLACK);
        lblModifyReserve.setForeground(Color.BLACK);
        lblModRooms.setForeground(Color.BLACK);
        //lblFaci.setForeground(Color.BLACK);
        lblAssemble.setForeground(Color.red);
        lblRoom.setForeground(Color.black);

        skipPanelAssemble c1 = null;
        try {
            c1 = new skipPanelAssemble();
        } catch (IOException ex) {
            Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        c1.setSize(mainPanel.getSize());
        mainPanel.add(c1);

    }

    private void lblChangePassword() {

        settleAutoCommit();

        lblReservation.setForeground(Color.BLACK);
        lblOrder.setForeground(Color.BLACK);
        lblPayment.setForeground(Color.BLACK);
        lblViewReservation.setForeground(Color.BLACK);
        lblModifyReserve.setForeground(Color.BLACK);
        lblModRooms.setForeground(Color.BLACK);
        //lblFaci.setForeground(Color.BLACK);
        lblAssemble.setForeground(Color.BLACK);
        lblRoom.setForeground(Color.BLACK);

        lblReport.setBorder(new LineBorder(Color.black, 1));
        lblCost.setBorder(new LineBorder(Color.black, 1));
        lblChangePassword.setBorder(new LineBorder(Color.black, 3));
        /* A.setForeground(Color.red);
         B.setForeground(Color.black);
         C.setForeground(Color.black);*/

        lblChangePassword.setBorder(new LineBorder(Color.black, 3));
        LoginEdit n1 = new LoginEdit();
        n1.setVisible(true);
    }

    private void lblCost() {
        settleAutoCommit();

        lblReservation.setForeground(Color.BLACK);
        lblOrder.setForeground(Color.BLACK);
        lblPayment.setForeground(Color.BLACK);
        lblViewReservation.setForeground(Color.BLACK);
        lblModifyReserve.setForeground(Color.BLACK);
        lblModRooms.setForeground(Color.BLACK);
        //lblFaci.setForeground(Color.BLACK);
        lblAssemble.setForeground(Color.BLACK);
        lblRoom.setForeground(Color.BLACK);

        lblReport.setBorder(new LineBorder(Color.black, 1));
        lblCost.setBorder(new LineBorder(Color.black, 3));
        lblChangePassword.setBorder(new LineBorder(Color.black, 1));

        try {
            lblCost.setBorder(new LineBorder(Color.black, 3));
            backup c1 = new backup();
            mainPanel.removeAll();
            mainPanel.repaint();
            mainPanel.revalidate();
            c1.setSize(mainPanel.getSize());
            mainPanel.add(c1);
        } catch (IOException ex) {
            Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void lblReport() {
        settleAutoCommit();

        lblReservation.setForeground(Color.BLACK);
        lblOrder.setForeground(Color.BLACK);
        lblPayment.setForeground(Color.BLACK);
        lblViewReservation.setForeground(Color.BLACK);
        lblModifyReserve.setForeground(Color.BLACK);
        lblModRooms.setForeground(Color.BLACK);
        //lblFaci.setForeground(Color.BLACK);
        lblAssemble.setForeground(Color.BLACK);
        lblRoom.setForeground(Color.BLACK);

        lblReport.setBorder(new LineBorder(Color.black, 3));
        lblCost.setBorder(new LineBorder(Color.black, 1));
        lblChangePassword.setBorder(new LineBorder(Color.black, 1));

        reports c1 = new reports();
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        c1.setSize(mainPanel.getSize());
        mainPanel.add(c1);

    }

}
