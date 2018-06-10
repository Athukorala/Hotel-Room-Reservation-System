/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.view.jpanel;

import com.mangroven.hotel.view.jpanel.addGuestPanel1;
import com.mangroven.hotel.view.jpanel.ModifyPayment;
import com.jidesoft.swing.AutoCompletion;
import com.mangroven.hotel.controller.ControllerFactory;
import com.mangroven.hotel.controller.custom.GuestController;
import com.mangroven.hotel.controller.custom.PaymentController;
import com.mangroven.hotel.controller.custom.ReservationController;
import com.mangroven.hotel.controller.custom.RoomController;
import com.mangroven.hotel.controller.custom.ValidationController;
import com.mangroven.hotel.dto.GuestDTO;
import com.mangroven.hotel.dto.PaymentDTO;
import com.mangroven.hotel.dto.ReservationDTO;
import com.mangroven.hotel.dto.RoomDTO;
import com.mangroven.hotel.idGenerator.IDGenerator;
import com.mangroven.hotel.jasper.main.JasperReportView;
import email.Gmail;
import email.GoogleMail;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author tharindu
 */
public class publicPanel extends javax.swing.JPanel {

    private static String dob;

    private PaymentController payCntrl;
    private ValidationController cntrlValidation;
    private GuestController guestCntrl;
    private ReservationController resvCntrl;
    private RoomController roomCntrl;
    private String rid, in, out;
    public long x;

    /**
     * Creates new form publicPanel
     */
    public publicPanel(String rid, String in, String out) throws IOException, Exception {

        this.in = in;
        this.out = out;
        this.rid = rid;
        //System.out.println(in + " " + out + " " + rid);
        initComponents();
        cntrlValidation = (ValidationController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.VALIDATION);
        payCntrl = (PaymentController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.PAYMENT);
        roomCntrl = (RoomController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.ROOM);
        guestCntrl = (GuestController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.GUEST);
        resvCntrl = (ReservationController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.RESERVATION);
        btnAddGuest.setEnabled(true);
        btnNic.setVisible(false);
        guestIDGeneratorGuest();
        loadNewIDPayment();
        loadGuestGIdReserve();
        //btnAddGuest.setEnabled(false);
        txtTel.setEnabled(false);
        rsIDReserve();
        txtRsID.requestFocus();
        setReserve();
        AutoCompletion ac = new AutoCompletion(comboGID);
        AutoCompletion ac1 = new AutoCompletion(comboPerson);

        dateCountReserve();

        lookReserve();
        editReserve();

        setPayment();
        viewPayment();
        showTime();
        enabledPayment();
        loadNewIDPayment();
        jPanel33.setVisible(false);
        //txtAdvance.setText(grandTotal+"");
        //txtAdvance.setEnabled(false);

    }

    public void showTime() {
        Timer tTimer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                Calendar cal = new GregorianCalendar();
                Date d1 = new Date(); //java.util.Date ->get Current date and time
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
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
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
                String formattedTime = sdf.format(d);
                Time.setText(formattedTime);
            }

        });
        tTimer.start();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        mainPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lblRoom1 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        mainGuest = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jSeparator6 = new javax.swing.JSeparator();
        txtAddress = new javax.swing.JTextField();
        Clear = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        txtDOB = new com.toedter.calendar.JDateChooser();
        jPanel11 = new javax.swing.JPanel();
        txtEmail = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        txtCountry = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        jPanel14 = new javax.swing.JPanel();
        txtTel = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();
        jPanel15 = new javax.swing.JPanel();
        txtName = new javax.swing.JTextField();
        jSeparator14 = new javax.swing.JSeparator();
        radioMale = new javax.swing.JRadioButton();
        radioFemale = new javax.swing.JRadioButton();
        jPanel16 = new javax.swing.JPanel();
        txtGID = new javax.swing.JTextField();
        jSeparator15 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel27 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        txtNic = new javax.swing.JTextField();
        jSeparator26 = new javax.swing.JSeparator();
        jLabel28 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        txtPassport = new javax.swing.JTextField();
        jSeparator27 = new javax.swing.JSeparator();
        txtDob = new javax.swing.JTextField();
        btnAddGuest = new javax.swing.JLabel();
        btnNic = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        roomReserve = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        lblRoom3 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        mainGuest1 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jSeparator7 = new javax.swing.JSeparator();
        jPanel19 = new javax.swing.JPanel();
        txtCheckOut = new javax.swing.JTextField();
        jSeparator16 = new javax.swing.JSeparator();
        jPanel20 = new javax.swing.JPanel();
        txtCheckIn = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        btnAddReserve = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        comboGID = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        txtRsID = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        txtRoom = new javax.swing.JTextField();
        jSeparator17 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        txtTot = new javax.swing.JTextField();
        jSeparator18 = new javax.swing.JSeparator();
        comboPerson = new javax.swing.JComboBox<>();
        jPanel24 = new javax.swing.JPanel();
        lblRoomIcon = new javax.swing.JLabel();
        lblRoomName = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtRoomPrice = new javax.swing.JTextField();
        txtDays = new javax.swing.JTextField();
        txtGName = new javax.swing.JLabel();
        paymentPanel = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        lblRoom4 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        mainGuest2 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jSeparator19 = new javax.swing.JSeparator();
        txtDate = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAddPayment = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jSeparator20 = new javax.swing.JSeparator();
        Time = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jSeparator21 = new javax.swing.JSeparator();
        txtAmount = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jSeparator22 = new javax.swing.JSeparator();
        txtRID1 = new javax.swing.JTextField();
        jPanel33 = new javax.swing.JPanel();
        jSeparator23 = new javax.swing.JSeparator();
        txtOID = new javax.swing.JTextField();
        jPanel34 = new javax.swing.JPanel();
        jSeparator24 = new javax.swing.JSeparator();
        txtRsID1 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jSeparator25 = new javax.swing.JSeparator();
        txtAdvance = new javax.swing.JTextField();
        txtPyid = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        jPanel1.setLayout(new java.awt.CardLayout());

        mainPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(254, 254, 254));

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        lblRoom1.setBackground(new java.awt.Color(254, 254, 254));
        lblRoom1.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblRoom1.setForeground(new java.awt.Color(255, 0, 15));
        lblRoom1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoom1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/down.png"))); // NOI18N
        lblRoom1.setText("                                                           Enter Guest Detail");
        lblRoom1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblRoom1.setOpaque(true);
        lblRoom1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRoom1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRoom1MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblRoom1MouseEntered(evt);
            }
        });
        jPanel5.add(lblRoom1);

        jLabel33.setBackground(new java.awt.Color(254, 254, 254));
        jLabel33.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/down.png"))); // NOI18N
        jLabel33.setText("                                                                        Room Reservation");
        jLabel33.setOpaque(true);
        jLabel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel33MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel33MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel33MouseExited(evt);
            }
        });
        jPanel5.add(jLabel33);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1088, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1029, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
        );

        mainGuest.setBackground(new java.awt.Color(243, 243, 243));
        mainGuest.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(93, 16, 144));
        jLabel3.setText("Name    ");

        jLabel4.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(93, 16, 144));
        jLabel4.setText("Address        ");

        jPanel9.setBackground(new java.awt.Color(236, 236, 236));
        jPanel9.setOpaque(false);

        txtAddress.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        txtAddress.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtAddress.setOpaque(false);
        txtAddress.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAddressMouseClicked(evt);
            }
        });
        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });
        txtAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAddressKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator6)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.DEFAULT_SIZE, 8, Short.MAX_VALUE)
                .addContainerGap())
        );

        Clear.setBackground(new java.awt.Color(255, 0, 12));
        Clear.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        Clear.setForeground(new java.awt.Color(255, 255, 255));
        Clear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Clear.setText("Clear");
        Clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Clear.setOpaque(true);
        Clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ClearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ClearMouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(93, 16, 144));
        jLabel6.setText("Gender     ");

        jPanel10.setBackground(new java.awt.Color(236, 236, 236));
        jPanel10.setOpaque(false);

        txtDOB.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txtDOBAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        txtDOB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDOBMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtDOB, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel11.setBackground(new java.awt.Color(236, 236, 236));
        jPanel11.setOpaque(false);

        txtEmail.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        txtEmail.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtEmail.setOpaque(false);
        txtEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEmailMouseClicked(evt);
            }
        });
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jLabel7.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(93, 16, 144));
        jLabel7.setText("Date of Birth     ");

        jLabel10.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(93, 16, 144));
        jLabel10.setText("Passport");

        jLabel11.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(93, 16, 144));
        jLabel11.setText("Mobile      ");

        jLabel12.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(93, 16, 144));
        jLabel12.setText("E-mail   ");

        jLabel2.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(93, 16, 144));
        jLabel2.setText("Guest ID        ");

        jPanel13.setBackground(new java.awt.Color(236, 236, 236));
        jPanel13.setOpaque(false);

        txtCountry.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        txtCountry.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtCountry.setOpaque(false);
        txtCountry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCountryMouseClicked(evt);
            }
        });
        txtCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCountryActionPerformed(evt);
            }
        });
        txtCountry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCountryKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCountryKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCountryKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jPanel14.setBackground(new java.awt.Color(236, 236, 236));
        jPanel14.setOpaque(false);

        txtTel.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        txtTel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtTel.setOpaque(false);
        txtTel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTelMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtTelMouseReleased(evt);
            }
        });
        txtTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelActionPerformed(evt);
            }
        });
        txtTel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator13)
                    .addComponent(txtTel, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jPanel15.setBackground(new java.awt.Color(236, 236, 236));
        jPanel15.setOpaque(false);

        txtName.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        txtName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtName.setOpaque(false);
        txtName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNameMouseClicked(evt);
            }
        });
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNameKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator14)
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        buttonGroup1.add(radioMale);
        radioMale.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        radioMale.setText("   Male");
        radioMale.setOpaque(false);
        radioMale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioMaleMouseClicked(evt);
            }
        });
        radioMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioMaleActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioFemale);
        radioFemale.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        radioFemale.setText("    Female");
        radioFemale.setOpaque(false);
        radioFemale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioFemaleMouseClicked(evt);
            }
        });
        radioFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioFemaleActionPerformed(evt);
            }
        });

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setOpaque(false);

        txtGID.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        txtGID.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtGID.setDisabledTextColor(new java.awt.Color(33, 33, 33));
        txtGID.setEnabled(false);
        txtGID.setOpaque(false);
        txtGID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator15, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(txtGID))
                .addGap(20, 20, 20)
                .addComponent(jLabel1))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(txtGID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jLabel5.setBackground(new java.awt.Color(1, 1, 1));
        jLabel5.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(164, 1, 1));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/image1.gif"))); // NOI18N
        jLabel5.setText("  Enter Guest Details");
        jLabel5.setToolTipText("");
        jLabel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txtSearch.setText(" Search Guest Details");
        txtSearch.setBorder(null);
        txtSearch.setOpaque(false);
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

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/search.png"))); // NOI18N

        jScrollPane2.setBorder(null);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " Guest ID", " Name", " NIC", " Passport", " DOB", " Tel"
            }
        ));
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel27.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(93, 16, 144));
        jLabel27.setText("Country       ");

        jPanel37.setBackground(new java.awt.Color(236, 236, 236));
        jPanel37.setOpaque(false);

        txtNic.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        txtNic.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtNic.setOpaque(false);
        txtNic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNicMouseClicked(evt);
            }
        });
        txtNic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNicActionPerformed(evt);
            }
        });
        txtNic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNicKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator26, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNic, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addComponent(txtNic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator26, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jLabel28.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(93, 16, 144));
        jLabel28.setText("NIC");

        jPanel38.setBackground(new java.awt.Color(236, 236, 236));
        jPanel38.setOpaque(false);

        txtPassport.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        txtPassport.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtPassport.setOpaque(false);
        txtPassport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPassportMouseClicked(evt);
            }
        });
        txtPassport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassportActionPerformed(evt);
            }
        });
        txtPassport.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPassportKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator27, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassport, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addComponent(txtPassport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator27, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        txtDob.setText("jTextField1");

        btnAddGuest.setBackground(new java.awt.Color(2, 188, 2));
        btnAddGuest.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        btnAddGuest.setForeground(new java.awt.Color(255, 255, 255));
        btnAddGuest.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAddGuest.setText("Add");
        btnAddGuest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddGuest.setOpaque(true);
        btnAddGuest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddGuestMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddGuestMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddGuestMouseExited(evt);
            }
        });

        btnNic.setBackground(new java.awt.Color(204, 204, 0));
        btnNic.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        btnNic.setForeground(new java.awt.Color(255, 255, 255));
        btnNic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNic.setText("Check NIC Number");
        btnNic.setOpaque(true);
        btnNic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNicMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNicMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNicMouseExited(evt);
            }
        });

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/leftArrow.png"))); // NOI18N
        jLabel34.setToolTipText("Back");
        jLabel34.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel34MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout mainGuestLayout = new javax.swing.GroupLayout(mainGuest);
        mainGuest.setLayout(mainGuestLayout);
        mainGuestLayout.setHorizontalGroup(
            mainGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainGuestLayout.createSequentialGroup()
                .addGroup(mainGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainGuestLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addGroup(mainGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(mainGuestLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51)
                .addGroup(mainGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(mainGuestLayout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addGroup(mainGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainGuestLayout.createSequentialGroup()
                        .addGroup(mainGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(mainGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2)
                    .addGroup(mainGuestLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainGuestLayout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(radioMale, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(radioFemale, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainGuestLayout.createSequentialGroup()
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(mainGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainGuestLayout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addGroup(mainGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainGuestLayout.createSequentialGroup()
                                .addGroup(mainGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel23))
                            .addGroup(mainGuestLayout.createSequentialGroup()
                                .addComponent(btnAddGuest, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainGuestLayout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainGuestLayout.createSequentialGroup()
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(51, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainGuestLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(mainGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainGuestLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainGuestLayout.createSequentialGroup()
                                .addComponent(btnNic, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainGuestLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtDob, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );
        mainGuestLayout.setVerticalGroup(
            mainGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainGuestLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainGuestLayout.createSequentialGroup()
                        .addGroup(mainGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainGuestLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addGroup(mainGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainGuestLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainGuestLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(mainGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioMale)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioFemale)
                    .addComponent(btnNic, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(mainGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainGuestLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(mainGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainGuestLayout.createSequentialGroup()
                                .addGroup(mainGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainGuestLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(mainGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(mainGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(mainGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(mainGuestLayout.createSequentialGroup()
                                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(24, 24, 24)
                                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(mainGuestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddGuest, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainGuestLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addComponent(txtDob, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout mainPanel1Layout = new javax.swing.GroupLayout(mainPanel1);
        mainPanel1.setLayout(mainPanel1Layout);
        mainPanel1Layout.setHorizontalGroup(
            mainPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanel1Layout.createSequentialGroup()
                .addGroup(mainPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanel1Layout.createSequentialGroup()
                        .addComponent(mainGuest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        mainPanel1Layout.setVerticalGroup(
            mainPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainPanel1Layout.createSequentialGroup()
                        .addComponent(mainGuest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1.add(mainPanel1, "card2");

        roomReserve.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(254, 254, 254));

        jPanel36.setBackground(new java.awt.Color(204, 204, 204));
        jPanel36.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        jPanel36.setLayout(new java.awt.GridLayout(1, 0));

        lblRoom3.setBackground(new java.awt.Color(254, 254, 254));
        lblRoom3.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblRoom3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoom3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/down.png"))); // NOI18N
        lblRoom3.setText("                                                           Enter Guest Detail");
        lblRoom3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblRoom3.setOpaque(true);
        lblRoom3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRoom3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblRoom3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRoom3MouseExited(evt);
            }
        });
        jPanel36.add(lblRoom3);

        jLabel35.setBackground(new java.awt.Color(254, 254, 254));
        jLabel35.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 0, 15));
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/down.png"))); // NOI18N
        jLabel35.setText("                                                                        Room Reservation");
        jLabel35.setOpaque(true);
        jLabel35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel35MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel35MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel35MouseExited(evt);
            }
        });
        jPanel36.add(jLabel35);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, 1088, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        mainGuest1.setBackground(new java.awt.Color(236, 236, 236));
        mainGuest1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel17.setBackground(new java.awt.Color(243, 243, 243));

        jLabel8.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(55, 14, 169));
        jLabel8.setText("Guest ID   ");

        jLabel9.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(55, 14, 169));
        jLabel9.setText("Check In Date   ");

        jLabel13.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(55, 14, 169));
        jLabel13.setText("Check Out Date   ");

        jPanel18.setBackground(new java.awt.Color(236, 236, 236));
        jPanel18.setOpaque(false);

        jPanel19.setBackground(new java.awt.Color(236, 236, 236));
        jPanel19.setOpaque(false);

        txtCheckOut.setBackground(new java.awt.Color(236, 236, 236));
        txtCheckOut.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        txtCheckOut.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtCheckOut.setOpaque(false);
        txtCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCheckOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCheckOut, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                    .addComponent(jSeparator16))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(txtCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jPanel20.setBackground(new java.awt.Color(236, 236, 236));
        jPanel20.setOpaque(false);

        txtCheckIn.setBackground(new java.awt.Color(236, 236, 236));
        txtCheckIn.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        txtCheckIn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtCheckIn.setOpaque(false);
        txtCheckIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCheckInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator8)
                    .addComponent(txtCheckIn, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(txtCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jLabel14.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(55, 14, 169));
        jLabel14.setText("Room ID   ");

        btnAddReserve.setBackground(new java.awt.Color(2, 188, 2));
        btnAddReserve.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        btnAddReserve.setForeground(new java.awt.Color(255, 255, 255));
        btnAddReserve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAddReserve.setText("OK");
        btnAddReserve.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddReserve.setOpaque(true);
        btnAddReserve.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddReserveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddReserveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddReserveMouseExited(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(55, 14, 169));
        jLabel15.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(55, 14, 169));
        jLabel15.setText("Reservation ID   ");

        comboGID.setBackground(new java.awt.Color(236, 236, 236));
        comboGID.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        comboGID.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        comboGID.setOpaque(false);
        comboGID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboGIDItemStateChanged(evt);
            }
        });
        comboGID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboGIDActionPerformed(evt);
            }
        });

        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(152, 22, 1));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/image1.gif"))); // NOI18N
        jLabel17.setText("     Room Reserve");
        jLabel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel21.setBackground(new java.awt.Color(236, 236, 236));
        jPanel21.setOpaque(false);

        txtRsID.setBackground(new java.awt.Color(236, 236, 236));
        txtRsID.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        txtRsID.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtRsID.setOpaque(false);
        txtRsID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRsIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator11)
                    .addComponent(txtRsID, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(txtRsID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jLabel18.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(55, 14, 169));
        jLabel18.setText("Persons");

        jPanel22.setBackground(new java.awt.Color(236, 236, 236));
        jPanel22.setOpaque(false);

        txtRoom.setBackground(new java.awt.Color(236, 236, 236));
        txtRoom.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        txtRoom.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtRoom.setDisabledTextColor(new java.awt.Color(72, 60, 60));
        txtRoom.setOpaque(false);
        txtRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRoomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator17)
                    .addComponent(txtRoom, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(txtRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jLabel19.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(55, 14, 169));
        jLabel19.setText("Price");

        jPanel23.setBackground(new java.awt.Color(236, 236, 236));
        jPanel23.setOpaque(false);

        txtTot.setBackground(new java.awt.Color(236, 236, 236));
        txtTot.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        txtTot.setForeground(new java.awt.Color(230, 1, 1));
        txtTot.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtTot.setOpaque(false);
        txtTot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTot, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                    .addComponent(jSeparator18))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(txtTot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        comboPerson.setBackground(new java.awt.Color(236, 236, 236));
        comboPerson.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        comboPerson.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        comboPerson.setOpaque(false);

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));

        lblRoomIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRoomIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/delux double room c.png"))); // NOI18N
        lblRoomIcon.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        lblRoomIcon.setOpaque(true);

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblRoomIcon, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(lblRoomIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        lblRoomName.setForeground(new java.awt.Color(102, 102, 102));
        lblRoomName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("Selected Days");

        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Room Price");

        txtRoomPrice.setBackground(new java.awt.Color(236, 236, 236));
        txtRoomPrice.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        txtRoomPrice.setForeground(new java.awt.Color(230, 1, 1));
        txtRoomPrice.setBorder(null);
        txtRoomPrice.setOpaque(false);
        txtRoomPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRoomPriceActionPerformed(evt);
            }
        });

        txtDays.setBackground(new java.awt.Color(236, 236, 236));
        txtDays.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        txtDays.setForeground(new java.awt.Color(230, 1, 1));
        txtDays.setBorder(null);
        txtDays.setOpaque(false);

        txtGName.setForeground(new java.awt.Color(102, 102, 102));
        txtGName.setText("jLabel34");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel17Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel17Layout.createSequentialGroup()
                                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel17Layout.createSequentialGroup()
                                                        .addGap(57, 57, 57)
                                                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(jPanel17Layout.createSequentialGroup()
                                                                .addGap(12, 12, 12)
                                                                .addComponent(comboGID, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                    .addGroup(jPanel17Layout.createSequentialGroup()
                                                        .addGap(71, 71, 71)
                                                        .addComponent(comboPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(219, 219, 219))
                                    .addGroup(jPanel17Layout.createSequentialGroup()
                                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(27, 27, 27)
                                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel17Layout.createSequentialGroup()
                                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtRoomPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDays, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblRoomName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(234, 234, 234))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAddReserve, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(330, 330, 330)))
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(405, 405, 405)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtGName, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboGID, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(txtGName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboPerson, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(lblRoomName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtRoomPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDays, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddReserve, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout mainGuest1Layout = new javax.swing.GroupLayout(mainGuest1);
        mainGuest1.setLayout(mainGuest1Layout);
        mainGuest1Layout.setHorizontalGroup(
            mainGuest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainGuest1Layout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 1082, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        mainGuest1Layout.setVerticalGroup(
            mainGuest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(mainGuest1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1034, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(mainGuest1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout roomReserveLayout = new javax.swing.GroupLayout(roomReserve);
        roomReserve.setLayout(roomReserveLayout);
        roomReserveLayout.setHorizontalGroup(
            roomReserveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomReserveLayout.createSequentialGroup()
                .addGroup(roomReserveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        roomReserveLayout.setVerticalGroup(
            roomReserveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomReserveLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(roomReserve, "card2");

        paymentPanel.setBackground(new java.awt.Color(255, 255, 255));

        jPanel25.setBackground(new java.awt.Color(254, 254, 254));

        jPanel26.setBackground(new java.awt.Color(204, 204, 204));
        jPanel26.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        jPanel26.setLayout(new java.awt.GridLayout(1, 0));

        lblRoom4.setBackground(new java.awt.Color(254, 254, 254));
        lblRoom4.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblRoom4.setForeground(new java.awt.Color(255, 0, 15));
        lblRoom4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoom4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/down.png"))); // NOI18N
        lblRoom4.setText("                                                           Payment");
        lblRoom4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblRoom4.setOpaque(true);
        lblRoom4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRoom4MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRoom4MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblRoom4MouseEntered(evt);
            }
        });
        jPanel26.add(lblRoom4);

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, 1091, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));

        mainGuest2.setBackground(new java.awt.Color(236, 236, 236));
        mainGuest2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel28.setBackground(new java.awt.Color(243, 243, 243));

        jLabel22.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(95, 16, 162));
        jLabel22.setText("  Amount    ");

        jLabel24.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(95, 16, 162));
        jLabel24.setText("Reservation  ID");

        jLabel25.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(95, 16, 162));
        jLabel25.setText("Room  ID");

        jPanel29.setBackground(new java.awt.Color(236, 236, 236));
        jPanel29.setOpaque(false);

        txtDate.setBackground(new java.awt.Color(236, 236, 236));
        txtDate.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        txtDate.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtDate.setOpaque(false);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });

        jScrollPane1.setBorder(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pay ID", "Reservation ID", "Room ID", "Package ID", "Date", "Time", "Amount", "Advanced"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        btnAddPayment.setBackground(new java.awt.Color(2, 188, 2));
        btnAddPayment.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        btnAddPayment.setForeground(new java.awt.Color(255, 255, 255));
        btnAddPayment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAddPayment.setText("OK");
        btnAddPayment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddPayment.setOpaque(true);
        btnAddPayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddPaymentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddPaymentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddPaymentMouseExited(evt);
            }
        });

        jPanel30.setBackground(new java.awt.Color(236, 236, 236));
        jPanel30.setOpaque(false);

        Time.setBackground(new java.awt.Color(236, 236, 236));
        Time.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        Time.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Time.setOpaque(false);

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addComponent(jSeparator20, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(48, Short.MAX_VALUE))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addComponent(Time)
                        .addGap(28, 28, 28))))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator20, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel29.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(95, 16, 162));
        jLabel29.setText("Date       ");

        jPanel31.setBackground(new java.awt.Color(236, 236, 236));
        jPanel31.setOpaque(false);

        txtAmount.setBackground(new java.awt.Color(236, 236, 236));
        txtAmount.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        txtAmount.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtAmount.setOpaque(false);
        txtAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator21, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator21, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel30.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(95, 16, 162));
        jLabel30.setText("Time      ");

        jLabel31.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(196, 18, 2));
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/image1.gif"))); // NOI18N
        jLabel31.setText("      Payment");
        jLabel31.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel32.setBackground(new java.awt.Color(236, 236, 236));
        jPanel32.setOpaque(false);

        txtRID1.setBackground(new java.awt.Color(236, 236, 236));
        txtRID1.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        txtRID1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtRID1.setOpaque(false);
        txtRID1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRID1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator22, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRID1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(txtRID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel33.setBackground(new java.awt.Color(236, 236, 236));

        txtOID.setBackground(new java.awt.Color(236, 236, 236));
        txtOID.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        txtOID.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtOID, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addComponent(jSeparator23))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtOID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator23, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel34.setBackground(new java.awt.Color(236, 236, 236));
        jPanel34.setOpaque(false);

        txtRsID1.setBackground(new java.awt.Color(236, 236, 236));
        txtRsID1.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        txtRsID1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtRsID1.setOpaque(false);

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator24, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRsID1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(txtRsID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator24))
        );

        jLabel32.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(95, 16, 162));
        jLabel32.setText("Advance / Payment");

        jPanel35.setBackground(new java.awt.Color(236, 236, 236));
        jPanel35.setOpaque(false);

        txtAdvance.setBackground(new java.awt.Color(236, 236, 236));
        txtAdvance.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        txtAdvance.setForeground(new java.awt.Color(255, 0, 0));
        txtAdvance.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtAdvance.setOpaque(false);
        txtAdvance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAdvanceMouseClicked(evt);
            }
        });
        txtAdvance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdvanceActionPerformed(evt);
            }
        });
        txtAdvance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAdvanceKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAdvanceKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator25, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAdvance, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(txtAdvance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtPyid.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        txtPyid.setForeground(new java.awt.Color(1, 42, 164));
        txtPyid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtPyid.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1057, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel24)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel28Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel28Layout.createSequentialGroup()
                                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(jPanel28Layout.createSequentialGroup()
                                                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnAddPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(27, 27, 27))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtPyid, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel28Layout.createSequentialGroup()
                                .addGap(280, 280, 280)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel28Layout.createSequentialGroup()
                                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel28Layout.createSequentialGroup()
                                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPyid, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel28Layout.createSequentialGroup()
                            .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(290, 290, 290))
                        .addGroup(jPanel28Layout.createSequentialGroup()
                            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel28Layout.createSequentialGroup()
                                    .addGap(11, 11, 11)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel28Layout.createSequentialGroup()
                                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel28Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                            .addComponent(btnAddPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(26, 26, 26)))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(43, 43, 43)))
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout mainGuest2Layout = new javax.swing.GroupLayout(mainGuest2);
        mainGuest2.setLayout(mainGuest2Layout);
        mainGuest2Layout.setHorizontalGroup(
            mainGuest2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainGuest2Layout.createSequentialGroup()
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, 1110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        mainGuest2Layout.setVerticalGroup(
            mainGuest2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainGuest2Layout.createSequentialGroup()
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addComponent(mainGuest2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1006, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addComponent(mainGuest2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout paymentPanelLayout = new javax.swing.GroupLayout(paymentPanel);
        paymentPanel.setLayout(paymentPanelLayout);
        paymentPanelLayout.setHorizontalGroup(
            paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentPanelLayout.createSequentialGroup()
                .addGroup(paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        paymentPanelLayout.setVerticalGroup(
            paymentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentPanelLayout.createSequentialGroup()
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(paymentPanel, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblRoom1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRoom1MouseClicked
        /*        lblRoom.setForeground(Color.red);

         lblRoom2.setForeground(Color.black);

         addGuestPanel1 c1 = null;
         try {
         c1 = new addGuestPanel1();
         } catch (IOException ex) {
         Logger.getLogger(skipPanel.class.getName()).log(Level.SEVERE, null, ex);
         }
         jPanel3.removeAll();
         jPanel3.repaint();
         jPanel3.revalidate();
         c1.setSize(jPanel3.getSize());
         jPanel3.add(c1);*/
    }//GEN-LAST:event_lblRoom1MouseClicked

    private void lblRoom1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRoom1MouseExited
        lblRoom1.setBackground(Color.white);
        lblRoom1.setOpaque(true);// TODO add your handling code here:
    }//GEN-LAST:event_lblRoom1MouseExited

    private void lblRoom1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRoom1MouseEntered
        lblRoom1.setBackground(new Color(204, 204, 255));
        lblRoom1.setOpaque(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_lblRoom1MouseEntered

    private void txtAddressMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAddressMouseClicked
        if (txtName.getText().equals("") | txtAddress.getText().equals("")) {
            txtName.requestFocus();
        } else {
            //txtCountry.requestFocus();
        }
    }//GEN-LAST:event_txtAddressMouseClicked

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        if (txtAddress.getText().equals("")) {
            txtAddress.requestFocus();
        } else {
            // radioMale.setSelected(true);
            // radioMale.requestFocus();
//            buttonGroup1.getSelection().isSelected();

        }      // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void txtAddressKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressKeyReleased
        /*        if (txtEmail.getText().equals("") | txtGID.getText().equals("") | txtName.getText().equals("") | txtAddress.getText().equals("") | txtDOB.getDate().equals("") | txtTel.getText().equals("") | txtCountry.getText().equals("")) {
         if(!txtNic.getText().equals("")|!txtPassport.getText().equals("")){
         btnAddGuest.setEnabled(false);
        
         } else {
         btnAddGuest.setEnabled(true);
        
         }
    }// TODO add your handling code here:*/    }//GEN-LAST:event_txtAddressKeyReleased

    private void ClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearMouseClicked
        try {
            cancelGuest();
        } catch (IOException ex) {
            Logger.getLogger(publicPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ClearMouseClicked

    private void ClearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearMouseExited
        Clear.setForeground(Color.white);      // TODO add your handling code here:
    }//GEN-LAST:event_ClearMouseExited

    private void ClearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearMouseEntered
        Clear.setForeground(Color.black);            // TODO add your handling code here:
    }//GEN-LAST:event_ClearMouseEntered

    private void txtEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmailMouseClicked
        if (txtName.getText().equals("") | txtAddress.getText().equals("")) {
            txtName.requestFocus();
        } else {
            txtCountry.requestFocus();

        }// TODO add your handling code here:
    }//GEN-LAST:event_txtEmailMouseClicked

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        try {
            String email = txtEmail.getText();
            boolean result = cntrlValidation.checkEmail(email);
            if (result) {
                txtTel.setEnabled(true);

                txtTel.requestFocus();
                txtTel.setText("+");
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Email Number");
                txtEmail.requestFocus();

            }
        } catch (Exception ex) {
            Logger.getLogger(publicPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        /*if (txtEmail.getText().equals("") | txtGID.getText().equals("") | txtName.getText().equals("") | txtAddress.getText().equals("") | txtDOB.getDate().equals("") | txtTel.getText().equals("") | txtCountry.getText().equals("")) {
         btnAddGuest.setEnabled(false);
        
         } else {
         btnAddGuest.setEnabled(true);
        
         }        // TODO add your handling code here:
         */
    }//GEN-LAST:event_txtEmailKeyReleased

    private void txtCountryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCountryMouseClicked
        String date = txtDOB.getDate() + "";
        //System.out.println(date);
        txtDob.setText(date);

        if (txtName.getText().equals("") | txtAddress.getText().equals("")) {
            txtName.requestFocus();
        } else if (txtDob.getText().equals("null")) {

            JOptionPane.showMessageDialog(null, "Insert Your DOB");

            txtDOB.requestFocus();
        } else {
            txtCountry.requestFocus();
        }

        //txtName.requestFocus();        // TODO add your handling code here:if
    }//GEN-LAST:event_txtCountryMouseClicked

    private void txtCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCountryActionPerformed
        String date = txtDOB.getDate() + "";
        // System.out.println(date);
        txtDob.setText(date);
        if (txtDob.getText().equals("null")) {

            JOptionPane.showMessageDialog(null, "Insert Your DOB");
            txtCountry.setText("");

            txtCountry.requestFocus();

            //  txtEmail.requestFocus();
        } else {
            try {
                String country = txtCountry.getText();
                boolean result = cntrlValidation.checkName(country);
                if (result) {
                    txtEmail.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Type");

                }

                txtEmail.requestFocus();

                /*
                 String txt = txtCountry.getText();
                 boolean isTel = false;
                
                 if (txt.matches("[A-Za-z]")) {
                 isTel = true;
                 }
                
                 if (isTel) {
                 txtEmail.requestFocus();
                
                 } else {
                
                 JOptionPane.showMessageDialog(null, "invalid Type");
                 txtCountry.requestFocus();
                 }
                
                 }*/
            } catch (Exception ex) {
                Logger.getLogger(publicPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtCountryActionPerformed

    private void txtCountryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCountryKeyReleased


    }//GEN-LAST:event_txtCountryKeyReleased

    private void txtTelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelMouseClicked
        if (txtName.getText().equals("") | txtAddress.getText().equals("")) {
            txtName.requestFocus();
        } else {
            txtCountry.requestFocus();
        }
    }//GEN-LAST:event_txtTelMouseClicked

    private void txtTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelActionPerformed

        try {
            String tel = txtTel.getText();
            boolean result = cntrlValidation.checkTel(tel);
            if (result) {
                txtNic.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Mobile Number");
                txtTel.requestFocus();
            }
        } catch (Exception ex) {
            Logger.getLogger(publicPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtTelActionPerformed

    private void txtTelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelKeyTyped
        char c = evt.getKeyChar();
        int d = evt.getKeyCode();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE || d == evt.VK_PERIOD || d == evt.VK_END || d == evt.VK_HOME || c == evt.VK_ENTER)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtTelKeyTyped

    private void txtTelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelKeyReleased
        /*        if (txtEmail.getText().equals("") | txtGID.getText().equals("") | txtName.getText().equals("") | txtAddress.getText().equals("") | txtDOB.getDate().equals("") | txtTel.getText().equals("") | txtCountry.getText().equals("")) {
         btnAddGuest.setEnabled(false);
        
         } else {
         //btnAdd.setEnabled(true);
    }        // TODO add your handling code here:*/    }//GEN-LAST:event_txtTelKeyReleased

    private void txtNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNameMouseClicked
        if (txtName.getText().equals("") | txtAddress.getText().equals("")) {
            txtName.requestFocus();
        } else {
            //txtCountry.requestFocus();
        }
    }//GEN-LAST:event_txtNameMouseClicked

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        try {
            String name = txtName.getText();
            boolean result = cntrlValidation.checkName(name);
            if (result) {
                txtAddress.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Type");
                txtName.requestFocus();
            }

            /* if(txtName.getText().equals("")){
             txtName.requestFocus();
             }else{
            
             // txtAddress.requestFocus();
             try {
             validationGuestName();
             } catch (Exception ex) {
             Logger.getLogger(publicPanel.class.getName()).log(Level.SEVERE, null, ex);
             }
            
             }*/
 /*
             String txt = txtName.getText();
             boolean isName = false;
            
             if (txt.matches("\\D")) {
             isName = true;
             System.out.println("kdf "+isName);
             }
            
             if (isName) {
             txtAddress.requestFocus();
            
             } else {
             System.out.println(isName);
             JOptionPane.showMessageDialog(null, "invalid Type");
             txtName.requestFocus();
             }*/
            // TODO add your handling code here:
        } catch (Exception ex) {
            Logger.getLogger(publicPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyTyped
        char key = evt.getKeyChar();
        if (Character.isLetter(key) || (key >= KeyEvent.VK_A && key <= KeyEvent.VK_Z) || key == KeyEvent.VK_SHIFT || key == KeyEvent.VK_SPACE || key == evt.VK_BACK_SPACE || key == evt.VK_END || key == evt.VK_DELETE || key == evt.VK_HOME || key == evt.VK_LEFT || key == KeyEvent.VK_CAPS_LOCK || key == evt.VK_RIGHT || key == evt.VK_DOWN || key == evt.VK_UP || key == evt.VK_PERIOD || key == evt.VK_ENTER) {

        } else {
            getToolkit().beep();
            evt.consume();
        }
        /*if (txtEmail.getText().equals("") | txtGID.getText().equals("") | txtName.getText().equals("") | txtAddress.getText().equals("") | txtDOB.getDate().equals("") | txtTel.getText().equals("") | txtCountry.getText().equals("")) {
         btnAddGuest.setEnabled(false);
        
         } else {
         btnAddGuest.setEnabled(true);
        
         }*/        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameKeyTyped

    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased

        /* int key = evt.getKeyCode();
        
         if ((key >= evt.VK_0 && key <= evt.VK_9) || (key >= evt.VK_NUMPAD0 && key <= evt.VK_NUMPAD9)||key==evt.VK_BACK_SLASH||key==evt.VK_COMMA) {
         // JOptionPane.showMessageDialog(null, "Invalid Type");
         txtName.setText("");
         } else {
         }   */
    }  // TODO add your handling code here:*/    }//GEN-LAST:event_txtNameKeyReleased

    private void radioMaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioMaleMouseClicked
        if (txtAddress.getText().equals("")) {
            txtAddress.requestFocus();
        } else {
            txtDOB.requestFocus();

        }        // TODO add your handling code here:
    }//GEN-LAST:event_radioMaleMouseClicked

    private void radioMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioMaleActionPerformed
        if (txtAddress.getText().equals("")) {
            txtAddress.requestFocus();
        } else {
            txtDOB.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_radioMaleActionPerformed

    private void radioFemaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioFemaleMouseClicked
        if (txtAddress.getText().equals("")) {
            txtAddress.requestFocus();
        } else {
            txtDOB.requestFocus();

        }            // TODO add your handling code here:
    }//GEN-LAST:event_radioFemaleMouseClicked

    private void radioFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioFemaleActionPerformed
        if (txtAddress.getText().equals("")) {
            txtAddress.requestFocus();
        } else {
            txtDOB.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_radioFemaleActionPerformed

    private void txtGIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGIDActionPerformed
        try {
            String gid = txtGID.getText();

            GuestDTO c1 = guestCntrl.search(gid);
            if (c1 != null) {
                //txtGID.setText(c1.getName());
                JOptionPane.showMessageDialog(null, " Sorry Duplicate ID");
            } else {
                //JOptionPane.showMessageDialog(null,"Customer not found...");
                txtName.requestFocus();
            }

            //  txtName.requestFocus();//duplicate();
            // TODO add your handling code here:
        } catch (Exception ex) {
            Logger.getLogger(publicPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtGIDActionPerformed

    private void txtCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCheckOutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCheckOutActionPerformed

    private void txtCheckInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCheckInActionPerformed
        txtCheckOut.requestFocus();        // TODO add your handling code here:
    }//GEN-LAST:event_txtCheckInActionPerformed

    private void btnAddReserveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddReserveMouseClicked

        if (txtTot.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Sorry! Incomplete...", "Can't Reserve", JOptionPane.WARNING_MESSAGE);

        } else {

            String rsid = txtRsID.getText();
            String rid = txtRoom.getText();
            double price = Double.parseDouble(txtTot.getText());
            String gid = comboGID.getSelectedItem() + "";
            int persons = Integer.parseInt((String) comboPerson.getSelectedItem());
            //txtTot.getText();
            // int personns = Integer.parseInt(comboPerson.getSelectedItem().toString());

            ReservationDTO res = new ReservationDTO(rsid, gid, rid, persons, in, out, price);

            //System.out.println(rsid + "\n" + gid + "\n" + rid + "\n" + persons + "\n" + in + "\n" + out);
            try {

                boolean isAdded = resvCntrl.add(res);

                //System.out.println(isAdded);
                if (isAdded) {
                    //JOptionPane.showMessageDialog(null, "Added Succes");

                    //clearReserve();
                    mainPanel1.setVisible(false);
                    paymentPanel.setVisible(true);
                    roomReserve.setVisible(false);

                } else {
                    JOptionPane.showMessageDialog(null, "Added Failed");
                }
            } catch (Exception ex) {
                Logger.getLogger(roomReservePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAddReserveMouseClicked

    private void btnAddReserveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddReserveMouseExited
        btnAddReserve.setForeground(Color.WHITE);        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddReserveMouseExited

    private void btnAddReserveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddReserveMouseEntered
        btnAddReserve.setForeground(Color.black);        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddReserveMouseEntered

    private void comboGIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboGIDActionPerformed
        //  comboPerson.requestFocus();//comboRID.requestFocus();        // TODO add your handling code here:
    }//GEN-LAST:event_comboGIDActionPerformed

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked

    }//GEN-LAST:event_jLabel16MouseClicked

    private void txtRsIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRsIDActionPerformed
        comboGID.requestFocus();      // TODO add your handling code here:
    }//GEN-LAST:event_txtRsIDActionPerformed

    private void txtRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRoomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRoomActionPerformed

    private void txtTotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotActionPerformed

    private void txtRoomPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRoomPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRoomPriceActionPerformed

    private void lblRoom4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRoom4MouseClicked

    }//GEN-LAST:event_lblRoom4MouseClicked

    private void lblRoom4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRoom4MouseExited
        lblRoom4.setBackground(Color.white);
        lblRoom4.setOpaque(true);// TODO add your handling code here:
    }//GEN-LAST:event_lblRoom4MouseExited

    private void lblRoom4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRoom4MouseEntered
        lblRoom4.setBackground(new Color(204, 204, 255));
        lblRoom4.setOpaque(true);    // TODO add your handling code here:
    }//GEN-LAST:event_lblRoom4MouseEntered

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked

    }//GEN-LAST:event_jLabel26MouseClicked

    private void btnAddPaymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddPaymentMouseClicked
        btnAdd();
    }//GEN-LAST:event_btnAddPaymentMouseClicked

    private void btnAddPaymentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddPaymentMouseExited
        jLabel13.setForeground(Color.white);  // TODO add your handling code here:
    }//GEN-LAST:event_btnAddPaymentMouseExited

    private void btnAddPaymentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddPaymentMouseEntered
        jLabel13.setForeground(Color.black);    // TODO add your handling code here:;
    }//GEN-LAST:event_btnAddPaymentMouseEntered

    private void txtRID1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRID1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRID1ActionPerformed

    private void jLabel33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MouseClicked
        try {
            mainPanel1.setVisible(false);
            paymentPanel.setVisible(false);
            roomReserve.setVisible(true);

            comboGID.removeAllItems();
            loadGuestGIdReserve();
            //comboGIDItemStateChanged();
        } catch (Exception ex) {
            Logger.getLogger(publicPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel33MouseClicked

    private void lblRoom3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRoom3MouseClicked
        mainPanel1.setVisible(true);
        paymentPanel.setVisible(false);
        roomReserve.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_lblRoom3MouseClicked

    private void lblRoom3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRoom3MouseExited
        lblRoom3.setBackground(Color.white);
        lblRoom3.setOpaque(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_lblRoom3MouseExited

    private void lblRoom3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRoom3MouseEntered
        lblRoom3.setBackground(new Color(204, 204, 255));
        lblRoom3.setOpaque(true);     // TODO add your handling code here:
    }//GEN-LAST:event_lblRoom3MouseEntered

    private void jLabel35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel35MouseClicked

    private void jLabel33MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MouseEntered
        jLabel33.setBackground(new Color(204, 204, 255));
        jLabel33.setOpaque(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel33MouseEntered

    private void jLabel33MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MouseExited
        jLabel33.setBackground(Color.white);
        jLabel33.setOpaque(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel33MouseExited

    private void jLabel35MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseEntered
        jLabel35.setBackground(new Color(204, 204, 255));
        jLabel35.setOpaque(true);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel35MouseEntered

    private void jLabel35MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseExited
        jLabel35.setBackground(Color.white);
        jLabel35.setOpaque(true);        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel35MouseExited

    private void txtTelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelMouseReleased
        boolean isTel = false;

        if (txtTel.getText().matches("\\d{10}")) {
            isTel = true;

        }

        if (isTel) {
            //  btnAddGuest.setEnabled(true);
            //btnAddGuest();
        } else {

            JOptionPane.showMessageDialog(null, "invalid");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelMouseReleased

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        String name = txtSearch.getText();
        ArrayList<GuestDTO> list = guestCntrl.getDetail(name);
        DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
        dtm.setRowCount(0);

        for (GuestDTO c1 : list) {
            Object[] rowData = {c1.getGID(), c1.getName(), c1.getNic(), c1.getPassport(), c1.getDOB(), c1.getTel()};
            dtm.addRow(rowData);

        }
        if (dtm.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Guest Not Yet");

        }
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtNicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNicMouseClicked
        if (txtName.getText().equals("") | txtAddress.getText().equals("")) {
            txtName.requestFocus();
        } else {
            txtCountry.requestFocus();
        }
    }//GEN-LAST:event_txtNicMouseClicked

    private void txtNicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNicActionPerformed
        if (txtNic.getText().equals("")) {
            txtPassport.requestFocus();
        } else {
            try {
                String nic = txtNic.getText();
                boolean result = cntrlValidation.checkNic(nic);
                if (result) {
                    txtPassport.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid NIC Number");
                    txtNic.requestFocus();
                }
            } catch (Exception ex) {
                Logger.getLogger(publicPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_txtNicActionPerformed

    private void txtNicKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNicKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNicKeyReleased

    private void txtPassportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPassportMouseClicked
        if (txtName.getText().equals("") || txtAddress.getText().equals("")) {
            txtName.requestFocus();
        } else {
            txtCountry.requestFocus();
        }
    }//GEN-LAST:event_txtPassportMouseClicked

    private void txtPassportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassportActionPerformed
        if (txtPassport.getText().equals("")) {
            add();
        } else {
            try {
                String passport = txtPassport.getText();
                boolean result = cntrlValidation.checkPasspoert(passport);
                if (result) {
                    add();
                } else {

                    JOptionPane.showMessageDialog(null, "invalid Passport Number");
                    txtPassport.requestFocus();
                }
            } catch (Exception ex) {
                Logger.getLogger(publicPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//        if (txtEmail.getText().equals("") | txtGID.getText().equals("") | txtName.getText().equals("") | txtAddress.getText().equals("") | /*txtDOB.getDate().equals("") |*/ txtTel.getText().equals("") | txtCountry.getText().equals("")) {

        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassportActionPerformed

    private void txtPassportKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassportKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassportKeyReleased

    private void txtDOBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDOBMouseClicked
        Date d = txtDOB.getDate();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formatDate = df.format(d);
        dob = formatDate;
        //System.out.println(dob);
        txtCountry.requestFocus();


    }//GEN-LAST:event_txtDOBMouseClicked

    private void txtDOBAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtDOBAncestorAdded
        /*Date d = txtDOB.getDate();
         SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
         String formatDate = df.format(d);
         dob = formatDate;
         System.out.println(dob);
        txtCountry.requestFocus();*/    }//GEN-LAST:event_txtDOBAncestorAdded

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
        txtSearch.selectAll();
    }//GEN-LAST:event_txtSearchMouseClicked

    private void btnAddGuestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddGuestMouseClicked
        if (txtNic.getText().equals("") && txtPassport.getText().equals("")) {
            // btnAddGuest.setEnabled(false);

            JOptionPane.showMessageDialog(null, " Incomplete ");
            // txtNic.requestFocus();

        } else {
            try {
                addGuest();
            } catch (Exception ex) {
                Logger.getLogger(publicPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAddGuestMouseClicked

    private void btnAddGuestMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddGuestMouseEntered
        btnAddGuest.setForeground(Color.black);        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddGuestMouseEntered

    private void btnAddGuestMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddGuestMouseExited
        btnAddGuest.setForeground(Color.white);        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddGuestMouseExited

    private void comboGIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboGIDItemStateChanged
//comboPerson.requestFocus();
        comboGIDItemStateChanged();
    }//GEN-LAST:event_comboGIDItemStateChanged

    private void txtCountryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCountryKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCountryKeyPressed

    private void txtCountryKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCountryKeyTyped
        char key = evt.getKeyChar();
        if (Character.isLetter(key) || (key >= KeyEvent.VK_A && key <= KeyEvent.VK_Z) || key == KeyEvent.VK_SHIFT || key == KeyEvent.VK_SPACE || key == evt.VK_BACK_SPACE || key == evt.VK_END || key == evt.VK_DELETE || key == evt.VK_HOME || key == evt.VK_LEFT || key == KeyEvent.VK_CAPS_LOCK || key == evt.VK_RIGHT || key == evt.VK_DOWN || key == evt.VK_UP || key == evt.VK_PERIOD || key == evt.VK_ENTER) {

        } else {
            getToolkit().beep();
            evt.consume();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_txtCountryKeyTyped

    private void txtAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAmountActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        mainPanel1.setVisible(false);
        paymentPanel.setVisible(false);
        roomReserve.setVisible(true);
        comboGID.setSelectedItem((String) jTable2.getValueAt(jTable2.getSelectedRow(), 0));

    }//GEN-LAST:event_jTable2MouseClicked

    private void btnNicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNicMouseClicked
        try {
            Runtime.getRuntime().exec("\"C:\\Users\\Athukorala\\Desktop\\NIC.exe\"");
        } catch (IOException ex) {/*\AAAA\Hotel (copy)\src\hotel\icon*/
            Logger.getLogger(publicPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNicMouseClicked

    private void btnNicMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNicMouseEntered
        btnNic.setForeground(Color.black);
    }//GEN-LAST:event_btnNicMouseEntered

    private void btnNicMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNicMouseExited
        btnNic.setForeground(Color.white);        // TODO add your handling code here:
    }//GEN-LAST:event_btnNicMouseExited

    private void jLabel34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MouseClicked

        mainPanel1.removeAll();
        mainPanel1.setVisible(true);
        roomPanel a1 = null;
        try {
            a1 = new roomPanel(in, out);
        } catch (Exception ex) {
            Logger.getLogger(coverPanele.class.getName()).log(Level.SEVERE, null, ex);
        }
        a1.setSize(mainPanel1.getSize());
        mainPanel1.add(a1);
        mainPanel1.repaint();
        mainPanel1.revalidate();
    }//GEN-LAST:event_jLabel34MouseClicked

    private void txtAdvanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdvanceActionPerformed
        if (!txtAdvance.getText().equals("")) {
            btnAdd();

        } else {
            txtAdvance.requestFocus();
        }

    }//GEN-LAST:event_txtAdvanceActionPerformed

    private void txtAdvanceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdvanceKeyReleased
        /* double a = Double.parseDouble(txtAmount.getText());
        double b = Double.parseDouble(txtAdvance.getText());
        double z = a - b;*/

        char c = evt.getKeyChar();
        int d = evt.getKeyCode();
        if (Character.isDigit(c) || c == KeyEvent.VK_PERIOD || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_ENTER/*||(c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE)||d==KeyEvent.VK_PERIOD||d==evt.VK_END||d==evt.VK_HOME*/) {
            double x = Double.parseDouble(txtAdvance.getText());
            double y = Double.parseDouble(txtAmount.getText());
            if (x > y) {
                txtAdvance.setText("");
            }

        } else {
            getToolkit().beep();
            evt.consume();

        }


    }//GEN-LAST:event_txtAdvanceKeyReleased

    private void txtAdvanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAdvanceMouseClicked
        txtAdvance.selectAll();        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdvanceMouseClicked

    private void txtAdvanceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdvanceKeyTyped
        char c = evt.getKeyChar();
        int d = evt.getKeyCode();
        if (Character.isDigit(c) || c == KeyEvent.VK_PERIOD || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_ENTER/*||(c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE)||d==KeyEvent.VK_PERIOD||d==evt.VK_END||d==evt.VK_HOME*/) {

        } else {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtAdvanceKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Clear;
    private javax.swing.JTextField Time;
    private javax.swing.JLabel btnAddGuest;
    private javax.swing.JLabel btnAddPayment;
    private javax.swing.JLabel btnAddReserve;
    private javax.swing.JLabel btnNic;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comboGID;
    private javax.swing.JComboBox<String> comboPerson;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JSeparator jSeparator26;
    private javax.swing.JSeparator jSeparator27;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblRoom1;
    private javax.swing.JLabel lblRoom3;
    private javax.swing.JLabel lblRoom4;
    private javax.swing.JLabel lblRoomIcon;
    private javax.swing.JLabel lblRoomName;
    private javax.swing.JPanel mainGuest;
    private javax.swing.JPanel mainGuest1;
    private javax.swing.JPanel mainGuest2;
    private javax.swing.JPanel mainPanel1;
    private javax.swing.JPanel paymentPanel;
    private javax.swing.JRadioButton radioFemale;
    private javax.swing.JRadioButton radioMale;
    private javax.swing.JPanel roomReserve;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAdvance;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtCheckIn;
    private javax.swing.JTextField txtCheckOut;
    private javax.swing.JTextField txtCountry;
    private com.toedter.calendar.JDateChooser txtDOB;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtDays;
    private javax.swing.JTextField txtDob;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGID;
    private javax.swing.JLabel txtGName;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNic;
    private javax.swing.JTextField txtOID;
    private javax.swing.JTextField txtPassport;
    private javax.swing.JLabel txtPyid;
    private javax.swing.JTextField txtRID1;
    private javax.swing.JTextField txtRoom;
    private javax.swing.JTextField txtRoomPrice;
    private javax.swing.JTextField txtRsID;
    private javax.swing.JTextField txtRsID1;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTel;
    private javax.swing.JTextField txtTot;
    // End of variables declaration//GEN-END:variables

// ========================== Payment Lines ===================================================================    
    public void viewPayment() throws IOException, Exception {
        try {
            ArrayList<PaymentDTO> paymentList = payCntrl.getAllName();
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            for (PaymentDTO c1 : paymentList) {
                Object[] rowData = {c1.getPyid(), c1.getRsid(), c1.getRid(), c1.getOid(), c1.getDate(), c1.getTime(), c1.getAmount(), c1.getAdvance()};
                dtm.addRow(rowData);
            }
        } catch (SQLException e) {
            // System.out.println(e);
        } catch (ClassNotFoundException e) {
            // System.out.println(e);

        }
    }

    public void setPayment() {
        txtRsID1.setText(txtRsID.getText());
        txtRID1.setText(txtRoom.getText());
        txtAmount.setText(txtTot.getText() + "");
        txtAdvance.setText(txtTot.getText() + "");

    }

    private void addPayment() throws Exception, Exception, Exception {
        String RID = txtRID1.getText();
        String OID = txtOID.getText();
        if (txtRID1.getText().equals("")) {
            RID = null;
        } else {
            RID = txtRID1.getText();
        }

        if (txtOID.getText().equals("")) {
            OID = null;

        } else {
            txtOID.getText();
        }

        // String OID=txtOID.getText();
        String pyid = txtPyid.getText();
        String RsID = txtRsID.getText();
        String Date = txtDate.getText();
        String time = Time.getText();
        double advance = Double.parseDouble(txtAdvance.getText());
        double price = Double.parseDouble(txtAmount.getText());
        double cost = price - advance;

        PaymentDTO pay = new PaymentDTO(pyid, RsID, RID, OID, Date, time, cost, price, advance);
        boolean add = payCntrl.add(pay);
        if (add) {
            JOptionPane.showMessageDialog(null, "Payment Successfull");
            reportBill();
            reservationReport();
            viewPayment();
            sendEmail();
            clearPayment();
            loadNewIDPayment();

        } else {
            JOptionPane.showMessageDialog(null, "Payment Failed");
        }
    }

    private void reportBill() {
        try {
            JasperReport mainReport = (JasperReport) JRLoader.loadObject(publicPanel.class.getResourceAsStream("/com/mangroven/hotel/jasper/reports/reserveBill.jasper"));
            HashMap<String, Object> parameters = new HashMap<>();
            parameters.put("gid", comboGID.getSelectedItem());
            parameters.put("gName", txtGName.getText());
            parameters.put("rsid", txtRsID.getText());
            parameters.put("rid", txtRoom.getText());
            parameters.put("in", txtCheckIn.getText());
            parameters.put("out", txtCheckOut.getText());
            parameters.put("txtPay", txtAdvance.getText());
            JasperPrint filledReport = JasperFillManager.fillReport(mainReport, parameters, new JREmptyDataSource());
            JasperReportView view = new JasperReportView(filledReport);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(publicPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void clearPayment() {
        txtRID1.setText("");
        txtRsID1.setText("");
        txtOID.setText("");
        txtAdvance.setText("");
        txtAmount.setText("");
    }

    private void enabledPayment() {
        txtRsID1.setEnabled(false);
        txtRsID1.setDisabledTextColor(new Color(128, 128, 128));
        txtRID1.setEnabled(false);
        txtRID1.setDisabledTextColor(new Color(128, 128, 128));
        txtOID.setEnabled(false);
        txtOID.setDisabledTextColor(new Color(128, 128, 128));
        txtAmount.setEnabled(false);
        txtAmount.setDisabledTextColor(new Color(128, 128, 128));
        txtDate.setEnabled(false);
        txtDate.setDisabledTextColor(new Color(128, 128, 128));
        Time.setEnabled(false);
        Time.setDisabledTextColor(new Color(128, 128, 128));
        //txtAdvance.setEnabled(false);
        // txtAdvance.setDisabledTextColor(new Color(255, 21, 0));
    }

    private void loadNewIDPayment() {

        try {
            String pyid;
            pyid = IDGenerator.getNewID("Payment", "PYID", "PY");
            txtPyid.setText(pyid);

        } catch (SQLException ex) {
            Logger.getLogger(ModifyPayment.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModifyPayment.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(ModifyPayment.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

// ========================== Guest Lines ===================================================================    
    public void add() {
        if (txtNic.getText().equals("") && txtPassport.getText().equals("")) {
            btnAddGuest.setEnabled(false);

            JOptionPane.showMessageDialog(null, "Insert Your Passport Or NIC Number");
            txtNic.requestFocus();

        } else {
            try {
                addGuest();
            } catch (Exception ex) {
                Logger.getLogger(publicPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void addGuest() throws IOException, Exception {
        if (txtGID.getText().equals("") | txtName.getText().equals("") || txtAddress.getText().equals("") || txtTel.getText().equals("") || txtCountry.getText().equals("")) {
            btnAddGuest.setEnabled(false);
            JOptionPane.showMessageDialog(null, " Not complete", "Error!", JOptionPane.WARNING_MESSAGE);
        } else {
            btnAddGuest.setEnabled(true);

            btnAddGuest();
        }
    }

    public void btnAddGuest() throws IOException, Exception {
        GuestDTO guest = new GuestDTO();
        String GID = txtGID.getText();
        String Name = txtName.getText();
        String Address = txtAddress.getText();
        String Tel = txtTel.getText();
        String Email = txtEmail.getText();
        String Country = txtCountry.getText();
        String nic = txtNic.getText();
        String passport = txtPassport.getText();
        String gender;
        if (buttonGroup1.getSelection().isSelected()) {
            if (radioMale.isSelected()) {
                gender = "Male";
            } else {
                gender = "Female";
            }
        } else {
            JOptionPane.showMessageDialog(null, " Gender is not Selected ");
            gender = "";

        }
        //System.out.println(gender);
        Date d = txtDOB.getDate();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formatDate = df.format(d);
        String DOB = formatDate;

        guest = new GuestDTO(GID, Name, Address, Tel, Email, Country, gender, DOB, nic, passport);
        try {
            boolean res = guestCntrl.add(guest);
            if (res) {
                JOptionPane.showMessageDialog((null), " Added Guest Success ");

                mainPanel1.setVisible(false);
                paymentPanel.setVisible(false);
                roomReserve.setVisible(true);

                comboGID.removeAllItems();
                loadGuestGIdReserve();
                comboGID.setSelectedItem(GID);
                comboGIDItemStateChanged();

                //System.out.println(txtGID.getText());
                cancelGuest();
                guestIDGeneratorGuest();
                loadGuestGIdReserve();
            } else {
                JOptionPane.showMessageDialog((null), " Sorry! Try Again ");
                cancelGuest();
                guestIDGeneratorGuest();
            }

        } catch (NumberFormatException e) {
            //System.out.println(e);
            JOptionPane.showMessageDialog(null, "Number Format error");

        }

    }

    private void searchGuest() throws IOException, Exception {
        String gid = txtGID.getText();

        GuestDTO c1 = guestCntrl.search(gid);
        if (c1 != null) {
            //txtGID.setText(c1.getName());
            JOptionPane.showMessageDialog(null, " Sorry Duplicate ID");
        } else {
            //JOptionPane.showMessageDialog(null,"Customer not found...");
            txtName.requestFocus();
        }

    }

    public void cancelGuest() throws IOException {
        txtGID.setText(null);
        txtName.setText(null);
        txtAddress.setText(null);
        txtCountry.setText(null);
        txtEmail.setText(null);
        txtTel.setText(null);
        txtDOB.setDate(null);
        buttonGroup1.remove(radioMale);
        buttonGroup1.remove(radioFemale);
        radioFemale.setSelected(false);
        radioMale.setSelected(false);
        buttonGroup1.isSelected(null);
        txtNic.setText("");
        txtPassport.setText("");
        guestIDGeneratorGuest();
        txtName.requestFocus();
        btnAddGuest.setEnabled(false);

    }

    public void guestIDGeneratorGuest() throws IOException {
        try {
            String gid;
            gid = IDGenerator.getNewID("Guest", "GID", "G");
            txtGID.setText(gid);

        } catch (SQLException ex) {
            Logger.getLogger(addGuestPanel1.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addGuestPanel1.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

// ========================== Resevation Lines ===================================================================
    private void rsIDReserve() throws IOException {
        try {
            String reserve;
            reserve = IDGenerator.getNewID("Reservation", "RsID", "RS");
            txtRsID.setText(reserve);

        } catch (SQLException ex) {
            Logger.getLogger(roomReservePanel.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(roomReservePanel.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void loadGuestGIdReserve() throws IOException, Exception {
        try {

            ArrayList<GuestDTO> guestList = guestCntrl.getAllID();
            for (int i = 0; i < guestList.size(); i++) {
                GuestDTO guest = (GuestDTO) guestList.get(i);
                comboGID.addItem(guest.getGID());
            }
            //comboGIDItemStateChanged();
        } catch (SQLException e) {
            //System.out.println(e);
        } catch (ClassNotFoundException e) {
            //System.out.println(e);
        }
    }

    public void setReserve() {
        txtCheckIn.setText(in);
        txtCheckOut.setText(out);
        txtRoom.setText(rid);
    }

    private void editReserve() {
        txtCheckIn.setEnabled(false);
        txtCheckIn.setDisabledTextColor(new Color(72, 60, 60));
        txtCheckOut.setEnabled(false);
        txtCheckOut.setDisabledTextColor(new Color(72, 60, 60));
        txtRoom.setEnabled(false);
        txtRoom.setDisabledTextColor(new Color(72, 60, 60));
        txtTot.setEnabled(false);
        txtTot.setDisabledTextColor(new Color(230, 1, 1));
        txtRsID.setEnabled(false);
        txtRsID.setDisabledTextColor(new Color(72, 60, 60));
    }

    private void dateCountReserve() {

        try {
            SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd");
            String in1 = in;
            String in2 = out;

            Date d1 = s1.parse(in1);
            Date d2 = s1.parse(in2);

            long diff = d2.getTime() - d1.getTime();
            x = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            //System.out.println("Day : " + x);

        } catch (ParseException ex) {
            Logger.getLogger(publicPanel.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void lookReserve() {

        //System.out.println(rid);
        try {
            RoomDTO c1 = roomCntrl.search(rid);
            txtRoomPrice.setText(c1.getRoom_Price() + "");
            lblRoomName.setText(c1.getRoom_Name());
            // System.out.println(c1.getRoom_Name());
            double roomPrice = c1.getRoom_Price();

            double t = x + 1;
            double y = t * roomPrice;
            //System.out.println(y);
            txtTot.setText(y + "");

        } catch (Exception ex) {
            Logger.getLogger(roomReservePanel.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        int day = (int) x + 1;
        txtDays.setText(day + "");

        if (txtRoom.getText().equals("R01")) {
            lblRoomIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/family suite a.png")));

        } else {
            if (txtRoom.getText().equals("R02")) {
                lblRoomIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/family suite a.png")));

            } else {
                if (txtRoom.getText().equals("R03")) {
                    lblRoomIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/delux villa b.png")));

                } else {
                    if (txtRoom.getText().equals("R04")) {
                        lblRoomIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/delux double room c.png")));
                    } else {
                        if (txtRoom.getText().equals("R06")) {
                            lblRoomIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/Help_48px.png")));
                        } else {
                            if (txtRoom.getText().equals("R05")) {
                                lblRoomIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/Help_48px.png")));
                            }
                        }
                    }
                }

            }
        }

    }

    private void clearReserve() {
        rid = null;
    }

    private void reservationReport() {

        try {
            JasperReport mainReport = (JasperReport) JRLoader.loadObject(publicPanel.class.getResourceAsStream("/com/mangroven/hotel/jasper/reports/ReservationDetails.jasper"));
            HashMap<String, Object> parameters = new HashMap<>();
            double advance = Double.parseDouble(txtAdvance.getText());
            double price = Double.parseDouble(txtAmount.getText());
            double cost = price - advance;

            parameters.put("gid", comboGID.getSelectedItem());
            parameters.put("gName", txtGName.getText());
            parameters.put("rsid", txtRsID.getText());
            parameters.put("rid", txtRoom.getText() + "");
            parameters.put("in", txtCheckIn.getText());
            parameters.put("out", txtCheckOut.getText());
            parameters.put("roomPayment", txtAmount.getText() + "");
            parameters.put("payID", txtPyid.getText());
            parameters.put("advance", txtAdvance.getText() + "");
            parameters.put("arrears", cost + "");
            JasperPrint filledReport = JasperFillManager.fillReport(mainReport, parameters, new JREmptyDataSource());
            JasperReportView view = new JasperReportView(filledReport);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(publicPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void comboGIDItemStateChanged() {
        try {
            String id = (String) comboGID.getSelectedItem();
            GuestDTO dto = guestCntrl.search(id);
            if (dto != null) {
                txtGName.setText(dto.getName());
            }
        } catch (Exception ex) {
            Logger.getLogger(publicPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void comboGIDItemStateChanged1() {
        try {
            String id = (String) comboGID.getSelectedItem();
            GuestDTO dto = guestCntrl.search(id);
            //txtGName.setText(dto.getName());
        } catch (Exception ex) {
            Logger.getLogger(publicPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnAdd() {
        if (txtRsID1.getText().equals("") || txtAdvance.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Not Complete", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                jLabel13.setForeground(Color.black);
                addPayment();// TODO add your handling code here:
            } catch (Exception ex) {
                Logger.getLogger(paymentPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void sendEmail() throws MessagingException {
        //GoogleMail.Send("tharindu.hotelgdse41", "gdse41hotel", "tharinduathukorala1@gmail.com", "test", "keri ponnaya");
        ArrayList<GuestDTO> gst = guestCntrl.getDetail(txtGName.getText());
        for (int i = 0; i < gst.size(); i++) {
            GuestDTO guest = (GuestDTO) gst.get(i);
            String det = "Hi... " + guest.getName() + "\n" + "Your Number is : " + guest.getGID() + "\n" + "Your Check In Date is : " + txtCheckIn.getText() + "  & Check Out Date is : " + txtCheckOut.getText();
            String tit = "Room Reservation - Mangroven Hotel";
            String email = guest.getEmail();
            Gmail mail = new Gmail(email, tit, det);
            /* mail.des = det;
        mail.email = email;
        mail.tit = tit;
        mail.Gmail();
    }*/

        }
    }
}

