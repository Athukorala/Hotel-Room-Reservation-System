/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.view.jpanel;

import com.mangroven.hotel.view.jpanel.ModifyPayment;
import com.mangroven.hotel.view.jpanel.addGuestPanel1;
import com.jidesoft.swing.AutoCompletion;
import com.mangroven.hotel.controller.ControllerFactory;
import com.mangroven.hotel.controller.custom.Food_PackageController;
import com.mangroven.hotel.controller.custom.OrderContoller;
import com.mangroven.hotel.controller.custom.PaymentController;
import com.mangroven.hotel.controller.custom.ReservationController;
import com.mangroven.hotel.controller.custom.ValidationController;
import com.mangroven.hotel.dto.OrderDTO;
import com.mangroven.hotel.dto.Order_DetailDTO;
import com.mangroven.hotel.dto.PaymentDTO;
import com.mangroven.hotel.dto.ReservationDTO;
import com.mangroven.hotel.idGenerator.IDGenerator;
import com.mangroven.hotel.jasper.main.JasperReportView;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author tharindu
 */
public class publicPackage1 extends javax.swing.JPanel {

    double grandTotal;
    private ReservationController cntrl;
    private Food_PackageController packCntrl;
    private OrderContoller orderCntrl;
    private PaymentController payCntrl;
    private ValidationController valiCntrl;

    /**
     * Creates new form publicPackage1
     */
    public publicPackage1() throws IOException, Exception {

        initComponents();
        // mainPanel2.setVisible(false);

        valiCntrl = (ValidationController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.VALIDATION);
        payCntrl = (PaymentController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.PAYMENT);
        packCntrl = (Food_PackageController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.FOOD_PACKAGE);
        cntrl = (ReservationController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.RESERVATION);
        orderCntrl = (OrderContoller) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.ORDER);

        lblRoom2.setForeground(Color.red);
        setSize(1105, 665);
        AutoCompletion ac = new AutoCompletion(comboRes);
        AutoCompletion ac1 = new AutoCompletion(comboPack);
        AutoCompletion ac3 = new AutoCompletion(comboPeriod);
        editOrder();
        oidOrder();
        RsIDOrder();
        pidOrder();
        dateOrder();

        // =================== payment =====================
        //set();
        viewPayment();
        showTime();
        enabledPament();
        loadNewIDPament();
        txtAdvance.selectAll();
         Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE,0);
        datePickerIn.getMonthView().setLowerBound(cal.getTime());
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
                date.setText(formatDate);
                //txtDated.setText(formatDate);

                int AM_PM = cal.get(Calendar.AM_PM);

                String day_night = "";
                if (AM_PM == 1) {
                    day_night = "PM";
                } else {
                    day_night = "AM";
                }
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
                String formattedTime = sdf.format(d);
                txtTime.setText(formattedTime);
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

        mainPanel = new javax.swing.JPanel();
        mainPanel1 = new javax.swing.JPanel();
        mainPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        txtPName = new javax.swing.JTextField();
        jSeparator18 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        txtQty = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        jPanel12 = new javax.swing.JPanel();
        txtDated = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        datePickerIn = new org.jdesktop.swingx.JXDatePicker();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        txtPPrice = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        comboPeriod = new javax.swing.JComboBox<String>();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        txtGrandTot = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        txtOrderID = new javax.swing.JTextField();
        jSeparator14 = new javax.swing.JSeparator();
        comboRes = new javax.swing.JComboBox<String>();
        comboPack = new javax.swing.JComboBox<String>();
        jLabel13 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        txtGID = new javax.swing.JTextField();
        jSeparator15 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        txtRID = new javax.swing.JTextField();
        jSeparator16 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAddPayment = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jSeparator17 = new javax.swing.JSeparator();
        date = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jSeparator19 = new javax.swing.JSeparator();
        txtAmount = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jSeparator20 = new javax.swing.JSeparator();
        txtRID1 = new javax.swing.JTextField();
        jPanel22 = new javax.swing.JPanel();
        jSeparator21 = new javax.swing.JSeparator();
        txtOID = new javax.swing.JTextField();
        jPanel23 = new javax.swing.JPanel();
        jSeparator22 = new javax.swing.JSeparator();
        txtRsID = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jSeparator23 = new javax.swing.JSeparator();
        txtAdvance = new javax.swing.JTextField();
        txtPyid = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jSeparator24 = new javax.swing.JSeparator();
        txtTime = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblRoom2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(254, 254, 254));
        setLayout(new java.awt.CardLayout());

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        mainPanel1.setBackground(new java.awt.Color(254, 254, 254));
        mainPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mainPanel1.setPreferredSize(new java.awt.Dimension(1094, 544));
        mainPanel1.setLayout(new java.awt.CardLayout());

        mainPanel4.setBackground(new java.awt.Color(243, 243, 243));
        mainPanel4.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        mainPanel4.setForeground(new java.awt.Color(254, 254, 254));

        jLabel18.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(9, 1, 184));
        jLabel18.setText("Guest ID");

        jLabel19.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(185, 1, 1));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/image1.gif"))); // NOI18N
        jLabel19.setText("    Reserve Package");
        jLabel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane3.setBackground(new java.awt.Color(254, 254, 254));
        jScrollPane3.setBorder(null);

        jTable3.setBackground(new java.awt.Color(254, 254, 254));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "  Package ID", "  Package Name", "  Qty", "  Price"
            }
        ));
        jTable3.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable3);

        jLabel20.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(9, 1, 184));
        jLabel20.setText("Reservation ID   ");

        jPanel19.setBackground(new java.awt.Color(236, 236, 236));
        jPanel19.setOpaque(false);

        txtPName.setBackground(new java.awt.Color(236, 236, 236));
        txtPName.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        txtPName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtPName.setOpaque(false);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator18)
                    .addComponent(txtPName, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(txtPName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jLabel10.setBackground(new java.awt.Color(0, 153, 0));
        jLabel10.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("OK");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.setOpaque(true);
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel10MouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(9, 1, 184));
        jLabel6.setText("Period   ");

        jLabel4.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(9, 1, 184));
        jLabel4.setText("Date     ");

        jPanel11.setBackground(new java.awt.Color(236, 236, 236));
        jPanel11.setOpaque(false);

        txtQty.setBackground(new java.awt.Color(236, 236, 236));
        txtQty.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        txtQty.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtQty.setOpaque(false);
        txtQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtyActionPerformed(evt);
            }
        });
        txtQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQtyKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jPanel12.setBackground(new java.awt.Color(236, 236, 236));
        jPanel12.setOpaque(false);

        txtDated.setBackground(new java.awt.Color(236, 236, 236));
        txtDated.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        txtDated.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtDated.setEnabled(false);
        txtDated.setOpaque(false);
        txtDated.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDatedActionPerformed(evt);
            }
        });

        datePickerIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datePickerInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator11)
                    .addComponent(txtDated, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(datePickerIn, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDated, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datePickerIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jLabel5.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(9, 1, 184));
        jLabel5.setText("Package Name");

        jLabel7.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(9, 1, 184));
        jLabel7.setText("Qty");

        jPanel13.setBackground(new java.awt.Color(236, 236, 236));
        jPanel13.setOpaque(false);

        txtPPrice.setBackground(new java.awt.Color(236, 236, 236));
        txtPPrice.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        txtPPrice.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtPPrice.setOpaque(false);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator12)
                    .addComponent(txtPPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(txtPPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jLabel8.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(9, 1, 184));
        jLabel8.setText("Package Price");

        comboPeriod.setBackground(new java.awt.Color(236, 236, 236));
        comboPeriod.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        comboPeriod.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Breakfast", "Lunch", "Dinner" }));
        comboPeriod.setOpaque(false);
        comboPeriod.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboPeriodMouseClicked(evt);
            }
        });
        comboPeriod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPeriodActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(253, 7, 2));
        jLabel11.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(254, 254, 254));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Remove");
        jLabel11.setOpaque(true);
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(4, 1, 156));
        jLabel9.setText("Grand Total");

        jPanel14.setBackground(new java.awt.Color(236, 236, 236));
        jPanel14.setOpaque(false);

        txtGrandTot.setBackground(new java.awt.Color(236, 236, 236));
        txtGrandTot.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        txtGrandTot.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtGrandTot.setOpaque(false);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGrandTot, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtGrandTot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel12.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(9, 1, 184));
        jLabel12.setText("Order ID");

        jPanel15.setBackground(new java.awt.Color(236, 236, 236));
        jPanel15.setOpaque(false);

        txtOrderID.setBackground(new java.awt.Color(236, 236, 236));
        txtOrderID.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        txtOrderID.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtOrderID.setOpaque(false);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(txtOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        comboRes.setBackground(new java.awt.Color(236, 236, 236));
        comboRes.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        comboRes.setOpaque(false);
        comboRes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboResItemStateChanged(evt);
            }
        });
        comboRes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboResActionPerformed(evt);
            }
        });

        comboPack.setBackground(new java.awt.Color(236, 236, 236));
        comboPack.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        comboPack.setOpaque(false);
        comboPack.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboPackItemStateChanged(evt);
            }
        });
        comboPack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboPackMouseClicked(evt);
            }
        });
        comboPack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPackActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(9, 1, 184));
        jLabel13.setText("Package ID        ");

        jPanel16.setBackground(new java.awt.Color(236, 236, 236));
        jPanel16.setOpaque(false);

        txtGID.setBackground(new java.awt.Color(236, 236, 236));
        txtGID.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        txtGID.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtGID.setOpaque(false);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator15)
                    .addComponent(txtGID, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(txtGID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jLabel14.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(9, 1, 184));
        jLabel14.setText("Room ID");

        jPanel17.setBackground(new java.awt.Color(236, 236, 236));
        jPanel17.setOpaque(false);

        txtRID.setBackground(new java.awt.Color(236, 236, 236));
        txtRID.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        txtRID.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtRID.setOpaque(false);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator16)
                    .addComponent(txtRID, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(txtRID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jLabel15.setBackground(new java.awt.Color(205, 161, 1));
        jLabel15.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(254, 254, 254));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Clear");
        jLabel15.setOpaque(true);
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel15MouseExited(evt);
            }
        });

        javax.swing.GroupLayout mainPanel4Layout = new javax.swing.GroupLayout(mainPanel4);
        mainPanel4.setLayout(mainPanel4Layout);
        mainPanel4Layout.setHorizontalGroup(
            mainPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(mainPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainPanel4Layout.createSequentialGroup()
                        .addGroup(mainPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboPack, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(mainPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanel4Layout.createSequentialGroup()
                                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(246, 246, 246)))
                        .addGroup(mainPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanel4Layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(104, 104, 104)
                                .addComponent(comboPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanel4Layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanel4Layout.createSequentialGroup()
                        .addGroup(mainPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(96, 96, 96)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(mainPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(comboRes, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(160, 160, 160)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(166, 166, 166)
                        .addGroup(mainPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(mainPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(mainPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1036, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(493, 493, 493)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanel4Layout.setVerticalGroup(
            mainPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanel4Layout.createSequentialGroup()
                .addGroup(mainPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanel4Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(mainPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboRes, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(mainPanel4Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(mainPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(mainPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanel4Layout.createSequentialGroup()
                        .addGroup(mainPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanel4Layout.createSequentialGroup()
                                .addGroup(mainPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(mainPanel4Layout.createSequentialGroup()
                                        .addGroup(mainPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(mainPanel4Layout.createSequentialGroup()
                                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(41, 41, 41)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(mainPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(mainPanel4Layout.createSequentialGroup()
                                        .addGroup(mainPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(mainPanel4Layout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addGroup(mainPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(mainPanel4Layout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addGroup(mainPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(mainPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(5, 5, 5)))
                                .addGroup(mainPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(comboPack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        mainPanel1.add(mainPanel4, "card2");

        jPanel2.setBackground(new java.awt.Color(243, 243, 243));

        jLabel16.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(95, 16, 162));
        jLabel16.setText("  Amount    ");

        jLabel17.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(95, 16, 162));
        jLabel17.setText("Order ID");

        jLabel2.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(95, 16, 162));
        jLabel2.setText("Reservation  ID");

        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
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

        btnAddPayment.setBackground(new java.awt.Color(0, 153, 0));
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

        jPanel18.setBackground(new java.awt.Color(236, 236, 236));
        jPanel18.setOpaque(false);

        date.setBackground(new java.awt.Color(236, 236, 236));
        date.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        date.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        date.setOpaque(false);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(date)
                .addGap(28, 28, 28))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator17)
                .addContainerGap())
        );

        jLabel22.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(95, 16, 162));
        jLabel22.setText("Time");

        jPanel20.setBackground(new java.awt.Color(236, 236, 236));
        jPanel20.setOpaque(false);

        txtAmount.setBackground(new java.awt.Color(236, 236, 236));
        txtAmount.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        txtAmount.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtAmount.setOpaque(false);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(196, 18, 2));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/image1.gif"))); // NOI18N
        jLabel3.setText("   Payment");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel21.setBackground(new java.awt.Color(236, 236, 236));
        jPanel21.setOpaque(false);

        txtRID1.setBackground(new java.awt.Color(236, 236, 236));
        txtRID1.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        txtRID1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtRID1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRID1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator20)
                    .addComponent(txtRID1, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtRID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel22.setBackground(new java.awt.Color(236, 236, 236));
        jPanel22.setOpaque(false);

        txtOID.setBackground(new java.awt.Color(236, 236, 236));
        txtOID.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        txtOID.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtOID.setOpaque(false);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtOID, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addComponent(jSeparator21))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtOID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator21, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel23.setBackground(new java.awt.Color(236, 236, 236));
        jPanel23.setOpaque(false);

        txtRsID.setBackground(new java.awt.Color(236, 236, 236));
        txtRsID.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        txtRsID.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtRsID.setOpaque(false);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtRsID, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addComponent(jSeparator22))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtRsID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator22)
                .addContainerGap())
        );

        jLabel23.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(95, 16, 162));
        jLabel23.setText("Advance / Payment");

        jPanel24.setBackground(new java.awt.Color(236, 236, 236));
        jPanel24.setOpaque(false);

        txtAdvance.setBackground(new java.awt.Color(236, 236, 236));
        txtAdvance.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        txtAdvance.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtAdvance.setDisabledTextColor(new java.awt.Color(128, 128, 128));
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

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator23, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAdvance, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(txtAdvance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtPyid.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        txtPyid.setForeground(new java.awt.Color(1, 42, 164));
        txtPyid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtPyid.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel25.setBackground(new java.awt.Color(236, 236, 236));
        jPanel25.setOpaque(false);

        txtTime.setBackground(new java.awt.Color(236, 236, 236));
        txtTime.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        txtTime.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtTime.setOpaque(false);

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator24, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel24.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(95, 16, 162));
        jLabel24.setText("Date       ");

        jPanel3.setOpaque(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(104, 104, 104)
                                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnAddPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtPyid, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1012, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(388, 388, 388)))
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(txtPyid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(290, 290, 290))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(66, 66, 66))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(btnAddPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(47, 47, 47)))))))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        mainPanel1.add(jPanel2, "card3");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());

        lblRoom2.setBackground(new java.awt.Color(254, 254, 254));
        lblRoom2.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblRoom2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoom2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/down.png"))); // NOI18N
        lblRoom2.setText("                                             Package Reserve");
        lblRoom2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblRoom2.setOpaque(true);
        lblRoom2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRoom2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblRoom2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRoom2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblRoom2, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblRoom2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mainPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mainPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(mainPanel, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked

        if (txtGrandTot.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please Complete This Order", "Save and Payment?", JOptionPane.WARNING_MESSAGE);
        } else {
            addOrder();
        }
        /*String rsid = (String) comboRes.getSelectedItem();
         String oid = txtOrderID.getText();
         double price = Double.parseDouble(txtGrandTot.getText());

         paymentPanel fc1 = null;
         try {
         fc1 = new paymentPanel(rsid, oid, price);
         } catch (IOException ex) {
         Logger.getLogger(reservePackage.class.getName()).log(Level.SEVERE, null, ex);
         } catch (Exception ex) {
         Logger.getLogger(skipPanelPackage.class.getName()).log(Level.SEVERE, null, ex);
         }
         mainPanel1.removeAll();
         mainPanel1.repaint();
         mainPanel1.revalidate();

         fc1.setSize(mainPanel1.getSize());
         mainPanel1.add(fc1);
         }*/// TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
        jLabel10.setForeground(java.awt.Color.white);  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseExited

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
        jLabel10.setForeground(java.awt.Color.BLACK);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseEntered

    private void txtQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtyActionPerformed
        try {
            String qty1 = txtQty.getText();
            boolean b = valiCntrl.qty(qty1);
            if (!b) {
                JOptionPane.showMessageDialog(null, "Invalid Type");
            } else {

                comboPack.requestFocus();

                DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel();
                String Pid = (String) comboPack.getSelectedItem();
                String name = txtPName.getText();
                int Qty = Integer.parseInt(txtQty.getText());
                double price = Double.parseDouble(txtPPrice.getText());

                for (int i = 0; i < dtm.getRowCount(); i++) {
                    String pid = (String) dtm.getValueAt(i, 0);
                    if (pid.equals(Pid)) {
                        int qty = (int) dtm.getValueAt(i, 2);
                        double amountTemp = (double) dtm.getValueAt(i, 3);
                        Qty += qty;
                        grandTotal -= amountTemp;
                        txtGrandTot.setText("" + grandTotal);
                        dtm.removeRow(i);
                        //break;
                    }
                }
                double amount = Qty * price;
                grandTotal += amount;
                txtGrandTot.setText("" + grandTotal);
                Object[] rowData = {Pid, name, Qty, amount};
                dtm.addRow(rowData);
            }// TODO add your handling code here:
        } catch (Exception ex) {
            Logger.getLogger(publicPackage1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtQtyActionPerformed

    private void comboPeriodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPeriodActionPerformed
        comboPack.requestFocus();        // TODO add your handling code here:
    }//GEN-LAST:event_comboPeriodActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel();
        if (jTable3.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Please Select an item to remove", "Remove an item?", JOptionPane.WARNING_MESSAGE);
        } else {

            double amount = (double) dtm.getValueAt(jTable3.getSelectedRow(), 3);
            dtm.removeRow(jTable3.getSelectedRow());
            grandTotal -= amount;
            txtGrandTot.setText("" + grandTotal);

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
        jLabel11.setForeground(Color.white);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseExited

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
        jLabel11.setForeground(Color.black);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseEntered

    private void comboResItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboResItemStateChanged
        String res = (String) comboRes.getSelectedItem();
        try {
            ReservationDTO re = cntrl.search(res);
            txtGID.setText(re.getgID());
            txtRID.setText(re.getrID());
            txtQty.setText(re.getPersons() + "");
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (IOException ex) {
            Logger.getLogger(reservePackage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(skipPanelPackage.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_comboResItemStateChanged

    private void comboResActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboResActionPerformed
//        txtDated.requestFocus();        // TODO add your handling code here:
    }//GEN-LAST:event_comboResActionPerformed

    private void comboPackItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboPackItemStateChanged
        String pack = (String) comboPack.getSelectedItem();
        try {
            com.mangroven.hotel.dto.Food_PackageDTO cust = packCntrl.search(pack);
            txtPName.setText(cust.getPackage_Name());
            txtPPrice.setText(cust.getPackage_Price() + "");
            txtQty.selectAll();
            txtQty.requestFocus();

        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (IOException ex) {
            Logger.getLogger(reservePackage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(skipPanelPackage.class.getName()).log(Level.SEVERE, null, ex);
        }                                   // TODO add your handling code here:
    }//GEN-LAST:event_comboPackItemStateChanged

    private void comboPackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPackActionPerformed
        txtQty.requestFocus();        // TODO add your handling code here:
    }//GEN-LAST:event_comboPackActionPerformed

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        clearOrder();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseExited
   jLabel15.setForeground(Color.WHITE);     // TODO add your handling code here:
    }//GEN-LAST:event_jLabel15MouseExited

    private void jLabel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseEntered
jLabel15.setForeground(new Color(204, 204, 255));

    }//GEN-LAST:event_jLabel15MouseEntered

    private void lblRoom2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRoom2MouseEntered
        lblRoom2.setBackground(new Color(204, 204, 255));
        lblRoom2.setOpaque(true);    // TODO add your handling code here:
    }//GEN-LAST:event_lblRoom2MouseEntered

    private void lblRoom2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRoom2MouseExited
        lblRoom2.setBackground(Color.white);
        lblRoom2.setOpaque(true);// TODO add your handling code here:
    }//GEN-LAST:event_lblRoom2MouseExited

    private void lblRoom2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRoom2MouseClicked
        mainPanel4.setVisible(true);
        jPanel2.setVisible(false);

    }//GEN-LAST:event_lblRoom2MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

    }//GEN-LAST:event_jLabel1MouseClicked

    private void btnAddPaymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddPaymentMouseClicked
        if (txtRsID.getText().equals("") || txtAdvance.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Not Complete", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                //jLabel13.setForeground(Color.black);
                addPament();// TODO add your handling code here:
            } catch (Exception ex) {
                Logger.getLogger(paymentPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAddPaymentMouseClicked

    private void btnAddPaymentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddPaymentMouseExited
        btnAddPayment.setForeground(Color.white);  // TODO add your handling code here:
    }//GEN-LAST:event_btnAddPaymentMouseExited

    private void btnAddPaymentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddPaymentMouseEntered
        btnAddPayment.setForeground(Color.black);    // TODO add your handling code here:;
    }//GEN-LAST:event_btnAddPaymentMouseEntered

    private void txtRID1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRID1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRID1ActionPerformed

    private void txtDatedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDatedActionPerformed
        String txt = txtDated.getText();
        boolean isTel = false;

        if (txt.matches("\\d{4}-\\d{2}-\\d{2}")) {
            isTel = true;
        }

        if (isTel) {
            comboPeriod.requestFocus();
        } else {

            JOptionPane.showMessageDialog(null, "invalid Date");
            txtDated.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDatedActionPerformed

    private void datePickerInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datePickerInActionPerformed
        Date d = datePickerIn.getDate();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formatDate = df.format(d);
        txtDated.setText(formatDate);
        // TODO add your handling code here:
    }//GEN-LAST:event_datePickerInActionPerformed

    private void comboPackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboPackMouseClicked
        validationDate();        // TODO add your handling code here:
    }//GEN-LAST:event_comboPackMouseClicked

    private void comboPeriodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboPeriodMouseClicked
        validationDate();   // TODO add your handling code here:
    }//GEN-LAST:event_comboPeriodMouseClicked

    private void txtQtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtyKeyReleased
        int key = evt.getKeyCode();

        if ((key >= evt.VK_0 && key <= evt.VK_9) || (key >= evt.VK_NUMPAD0 && key <= evt.VK_NUMPAD9) || key == evt.VK_MINUS) {
            // JOptionPane.showMessageDialog(null, "Invalid Type");
            //txtName.setText("");
        } else {
            txtQty.setText("");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtyKeyReleased

    private void txtAdvanceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdvanceKeyReleased
        int key = evt.getKeyCode();

        if ((key >= evt.VK_0 && key <= evt.VK_9) || (key >= evt.VK_NUMPAD0 && key <= evt.VK_NUMPAD9) || key == evt.VK_BACK_SPACE || key == evt.VK_PERIOD || key == evt.VK_DELETE || key == evt.VK_HOME || key == evt.VK_END || key == evt.VK_LEFT || key == evt.VK_CAPS_LOCK) {
            double x = Double.parseDouble(txtAdvance.getText());
            double y = Double.parseDouble(txtAmount.getText());
            if (x > y) {
                txtAdvance.setText("");
            }

        } else {
            txtAdvance.setText("");

        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdvanceKeyReleased

    private void txtAdvanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAdvanceMouseClicked
        txtAdvance.selectAll();        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdvanceMouseClicked

    private void txtAdvanceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdvanceKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdvanceKeyTyped

    private void txtAdvanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdvanceActionPerformed
        if (txtRsID.getText().equals("") || txtAdvance.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Not Complete", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                //jLabel13.setForeground(Color.black);
                addPament();// TODO add your handling code here:
            } catch (Exception ex) {
                Logger.getLogger(paymentPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdvanceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAddPayment;
    private javax.swing.JComboBox<String> comboPack;
    private javax.swing.JComboBox<String> comboPeriod;
    private javax.swing.JComboBox<String> comboRes;
    private javax.swing.JTextField date;
    private org.jdesktop.swingx.JXDatePicker datePickerIn;
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
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
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
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel lblRoom2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel mainPanel1;
    private javax.swing.JPanel mainPanel4;
    private javax.swing.JTextField txtAdvance;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtDated;
    private javax.swing.JTextField txtGID;
    private javax.swing.JTextField txtGrandTot;
    private javax.swing.JTextField txtOID;
    private javax.swing.JTextField txtOrderID;
    private javax.swing.JTextField txtPName;
    private javax.swing.JTextField txtPPrice;
    private javax.swing.JLabel txtPyid;
    private javax.swing.JTextField txtQty;
    private javax.swing.JTextField txtRID;
    private javax.swing.JTextField txtRID1;
    private javax.swing.JTextField txtRsID;
    private javax.swing.JTextField txtTime;
    // End of variables declaration//GEN-END:variables
// =============================  Order Detail ===========================================================

    public void validationDate() {
        String txt = txtDated.getText();
        boolean isTel = false;

        if (txt.matches("\\d{4}-\\d{2}-\\d{2}")) {
            isTel = true;
        }

        if (isTel) {
            comboPeriod.requestFocus();
        } else {

            JOptionPane.showMessageDialog(null, "invalid Date");
            txtDated.requestFocus();
        }
    }

    private void dateOrder() {
        Date d1 = new Date(); //java.util.Date ->get Current date and time
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formatDate = df.format(d1);
        //checkIN.setText(formatDate);
        // checkOut.setText(formatDate);
        txtDated.setText(formatDate);

    }

    private void RsIDOrder() throws IOException, Exception {
        try {
            ArrayList<ReservationDTO> reserveList = cntrl.getAllID();
            for (int i = 0; i < reserveList.size(); i++) {
                ReservationDTO reserve = (ReservationDTO) reserveList.get(i);
                comboRes.addItem(reserve.getRsID());
            }
        } catch (SQLException ex) {
            Logger.getLogger(reservePackage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(reservePackage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pidOrder() throws IOException, ClassNotFoundException, SQLException, Exception {
        ArrayList<com.mangroven.hotel.dto.Food_PackageDTO> packageList = packCntrl.getAllID();
        for (int i = 0; i < packageList.size(); i++) {
            com.mangroven.hotel.dto.Food_PackageDTO reserve = (com.mangroven.hotel.dto.Food_PackageDTO) packageList.get(i);
            comboPack.addItem(reserve.getPID());
        }
    }

    private void oidOrder() throws IOException {
        try {
            String oid;
            oid = IDGenerator.getNewID("Orders", "OID", "O");
            txtOrderID.setText(oid);
        } catch (SQLException ex) {
            Logger.getLogger(addGuestPanel1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addGuestPanel1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addOrder() {
        String rsid = (String) comboRes.getSelectedItem();
        String oid = txtOrderID.getText();
        String date = txtDated.getText();
        String period = (String) comboPeriod.getSelectedItem();
        double price = Double.parseDouble(txtGrandTot.getText());

        ArrayList<Order_DetailDTO> odList = new ArrayList<>();
        DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel();
        for (int i = 0; i < dtm.getRowCount(); i++) {
            String pid = (String) dtm.getValueAt(i, 0);
            int qty = (int) dtm.getValueAt(i, 2);
            Order_DetailDTO od = new Order_DetailDTO(oid, pid, qty);
            odList.add(od);
        }
        // System.out.println(rsid+" "+oid+" "+date+" "+period+" "+price);
        OrderDTO odto = new OrderDTO(oid, rsid, date, period, price, odList);

        try {
            boolean added = orderCntrl.transaction(odto);
            if (added) {
                JOptionPane.showMessageDialog(null, "Added Success");

                paymentOrder();
                clearOrder();
                oidOrder();
            } else {
                JOptionPane.showMessageDialog(null, "Added Failed");
            }
        } catch (Exception ex) {
            Logger.getLogger(reservePackage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void paymentOrder() {
        jPanel21.setVisible(false);
        String rsid = (String) comboRes.getSelectedItem();
        txtRsID.setText(rsid);
        String oid = txtOrderID.getText();
        txtOID.setText(oid);

        double price = Double.parseDouble(txtGrandTot.getText());
        txtAmount.setText(price + "");
        txtAdvance.setText(price + "");
        txtAdvance.setForeground(Color.red);

        jPanel2.setVisible(true);
        mainPanel4.setVisible(false);
        txtAdvance.requestFocus();
        txtAdvance.selectAll();

    }

    private void editOrder() {
        txtGID.setEnabled(false);
        txtGID.setDisabledTextColor(new Color(128, 128, 128));
        txtRID.setEnabled(false);
        txtRID.setDisabledTextColor(new Color(128, 128, 128));
        txtOrderID.setEnabled(false);
        txtOrderID.setDisabledTextColor(new Color(128, 128, 128));
        txtGrandTot.setEnabled(false);
        txtGrandTot.setDisabledTextColor(new Color(128, 128, 128));
        txtPName.setEnabled(false);
        txtPName.setDisabledTextColor(new Color(128, 128, 128));
        txtPPrice.setEnabled(false);
        txtPPrice.setDisabledTextColor(new Color(128, 128, 128));
        txtTime.setEnabled(false);
        txtTime.setDisabledTextColor(new Color(128, 128, 128));
    }

    private void clearOrder() {
        try {
            oidOrder();
            txtGrandTot.setText("");
            DefaultTableModel dtm = (DefaultTableModel) jTable3.getModel();
            dtm.setRowCount(0);
            jTable3.removeAll();
        } catch (IOException ex) {
            Logger.getLogger(skipPanelPackage.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // ================================== Payment ================================================
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
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);

        }
    }

    private void addPament() throws Exception, Exception, Exception {
        String RID = null;
        String OID = txtOID.getText();

        // String OID=txtOID.getText();
        String pyid = txtPyid.getText();
        String RsID = txtRsID.getText();
        String Date = date.getText();
        String time = txtTime.getText();
        double advance = Double.parseDouble(txtAdvance.getText());
        double price = Double.parseDouble(txtAmount.getText());
        //System.out.println(RsID + " " + RID + " " + OID + " " + Date + " " + time + " " + price);
        PaymentDTO pay = new PaymentDTO(pyid, RsID, RID, OID, Date, time, price, advance);

        boolean add = payCntrl.add(pay);
        if (add) {
            JOptionPane.showMessageDialog(null, "Payment Successfull");
            viewPayment();
            orderPaymentReport();
            mainPanel4.setVisible(true);
            jPanel2.setVisible(false);
            clearPament();
            loadNewIDPament();
        } else {
            JOptionPane.showMessageDialog(null, "Payment Failed");
        }
    }

    private void clearPament() {
        txtRID.setText("");
        txtRsID.setText("");
        txtOID.setText("");
        txtAdvance.setText("");
        txtAmount.setText("");
    }

    private void enabledPament() {
        txtRsID.setEnabled(false);
        txtRsID.setDisabledTextColor(new Color(128, 128, 128));
        txtRID.setEnabled(false);
        txtRID.setDisabledTextColor(new Color(128, 128, 128));
        txtOID.setEnabled(false);
        txtOID.setDisabledTextColor(new Color(128, 128, 128));
        txtAmount.setEnabled(false);
        txtAmount.setDisabledTextColor(new Color(128, 128, 128));
        date.setEnabled(false);
        date.setDisabledTextColor(new Color(128, 128, 128));
        date.setEnabled(false);
        date.setDisabledTextColor(new Color(128, 128, 128));
    }

    private void loadNewIDPament() {

        try {
            String pyid;
            pyid = IDGenerator.getNewID("Payment", "PYID", "PY");
            txtPyid.setText(pyid);
        } catch (SQLException ex) {
            Logger.getLogger(ModifyPayment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModifyPayment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ModifyPayment.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void orderPaymentReport() {
        try {
            JasperReport main = (JasperReport) JRLoader.loadObject(backup.class.getResourceAsStream("/com/mangroven/hotel/jasper/reports/orderPayment.jasper"));
            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/MangrovenNew", "root", "4241");

            HashMap<String, Object> parameters = new HashMap<>();
            parameters.put("oid", txtOID.getText());
             parameters.put("orderprice",txtAmount.getText());
              parameters.put("advance",txtAdvance.getText());
            double advance = Double.parseDouble(txtAdvance.getText());
            double amount = Double.parseDouble(txtAmount.getText());
            double balance = amount - advance;
            
            parameters.put("pay",txtPyid.getText());
           
            parameters.put("arrears", balance + "");

            JasperPrint fill = JasperFillManager.fillReport(main, parameters, conn);
            //JasperPrint filledReport = JasperFillManager.fillReport(mainReport, parameters, new JREmptyDataSource());
            JasperReportView view = new JasperReportView(fill);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(backup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(backup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(backup.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
