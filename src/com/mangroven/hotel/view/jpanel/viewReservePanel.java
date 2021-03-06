/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangroven.hotel.view.jpanel;

import com.mangroven.hotel.controller.ControllerFactory;
import com.mangroven.hotel.controller.custom.GuestController;
import com.mangroven.hotel.controller.custom.ReservationController;
import com.mangroven.hotel.dto.GuestDTO;
import com.mangroven.hotel.dto.ReservationDTO;
import java.awt.Color;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.codejava.swing.mail.Backup;

/**
 *
 * @author tharindu
 */
public class viewReservePanel extends javax.swing.JPanel {

    private ReservationController cntl;
    private GuestController guestCntrl;

    /**
     * Creates new form viewReservePanel
     */
    public viewReservePanel() {
        initComponents();
        cntl = (ReservationController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.RESERVATION);
        guestCntrl = (GuestController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.GUEST);
        view();
        lblRoom2.setForeground(Color.red);
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
        jPanel1 = new javax.swing.JPanel();
        lblRoom2 = new javax.swing.JLabel();
        lblRoom = new javax.swing.JLabel();
        lblRoom3 = new javax.swing.JLabel();
        mainPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnView2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(254, 254, 254));

        mainPanel.setBackground(new java.awt.Color(254, 254, 254));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        lblRoom2.setBackground(new java.awt.Color(254, 254, 254));
        lblRoom2.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblRoom2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoom2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/down.png"))); // NOI18N
        lblRoom2.setText("                          View Rooms Reservation");
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
        jPanel1.add(lblRoom2);

        lblRoom.setBackground(new java.awt.Color(254, 254, 254));
        lblRoom.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblRoom.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/down.png"))); // NOI18N
        lblRoom.setText("                                         View Orders");
        lblRoom.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblRoom.setOpaque(true);
        lblRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRoomMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRoomMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblRoomMouseEntered(evt);
            }
        });
        jPanel1.add(lblRoom);

        lblRoom3.setBackground(new java.awt.Color(254, 254, 254));
        lblRoom3.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        lblRoom3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRoom3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/down.png"))); // NOI18N
        lblRoom3.setText("                                 View Guest Details");
        lblRoom3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblRoom3.setOpaque(true);
        lblRoom3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRoom3MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRoom3MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblRoom3MouseEntered(evt);
            }
        });
        jPanel1.add(lblRoom3);

        mainPanel1.setBackground(new java.awt.Color(254, 254, 254));

        jPanel2.setBackground(new java.awt.Color(254, 254, 254));

        jPanel3.setBackground(new java.awt.Color(236, 236, 236));
        jPanel3.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());

        jScrollPane1.setBackground(new java.awt.Color(254, 254, 254));
        jScrollPane1.setBorder(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "  Reservation ID", "  Guest ID", "  Room ID", "  Persons", " Check In", " Check Out", "  Price"
            }
        ));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        btnView2.setBackground(new java.awt.Color(28, 141, 198));
        btnView2.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        btnView2.setForeground(new java.awt.Color(255, 255, 255));
        btnView2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnView2.setText("View");
        btnView2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnView2.setOpaque(true);
        btnView2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnView2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnView2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnView2MouseExited(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(168, 1, 1));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/image1.gif"))); // NOI18N
        jLabel1.setText("    View Room Reserve  ");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setOpaque(true);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel23)
                .addGap(31, 31, 31))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(txtSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(914, 914, 914)
                        .addComponent(btnView2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1611, 1611, 1611))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnView2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1091, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1557, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        mainPanel1.add(jPanel2);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1097, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblRoom3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRoom3MouseEntered
        lblRoom3.setBackground(new Color(204, 204, 255));
    }//GEN-LAST:event_lblRoom3MouseEntered

    private void lblRoom3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRoom3MouseExited
        lblRoom3.setBackground(Color.white);   // TODO add your handling code here:
    }//GEN-LAST:event_lblRoom3MouseExited

    private void lblRoom3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRoom3MouseClicked
        lblRoom3.setForeground(Color.red);
        lblRoom.setForeground(Color.black);
        lblRoom2.setForeground(Color.black);

        viewGuestList c1 = new viewGuestList();
        //jPanel3.setVisible(false);
        mainPanel1.removeAll();
        mainPanel1.repaint();
        mainPanel1.revalidate();
        c1.setSize(mainPanel1.getSize());
        mainPanel1.add(c1);        // TODO add your handling code here:
    }//GEN-LAST:event_lblRoom3MouseClicked

    private void lblRoomMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRoomMouseEntered
        lblRoom.setBackground(new Color(204, 204, 255));
        lblRoom.setOpaque(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_lblRoomMouseEntered

    private void lblRoomMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRoomMouseExited
        lblRoom.setBackground(Color.white);
        lblRoom.setOpaque(true);        // TODO add your handling code here:
    }//GEN-LAST:event_lblRoomMouseExited

    private void lblRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRoomMouseClicked
        lblRoom.setForeground(Color.red);
        lblRoom2.setForeground(Color.black);
        lblRoom3.setForeground(Color.black);

        viewPackageReserve c1 = new viewPackageReserve();
        mainPanel1.removeAll();
        mainPanel1.repaint();
        mainPanel1.revalidate();
        c1.setSize(mainPanel1.getSize());
        mainPanel1.add(c1);
    }//GEN-LAST:event_lblRoomMouseClicked

    private void lblRoom2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRoom2MouseEntered
        lblRoom2.setBackground(new Color(204, 204, 255));
        lblRoom2.setOpaque(true);    // TODO add your handling code here:
    }//GEN-LAST:event_lblRoom2MouseEntered

    private void lblRoom2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRoom2MouseExited
        lblRoom2.setBackground(Color.white);
        lblRoom2.setOpaque(true);// TODO add your handling code here:
    }//GEN-LAST:event_lblRoom2MouseExited

    private void lblRoom2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRoom2MouseClicked
        lblRoom2.setForeground(Color.red);
        lblRoom.setForeground(Color.black);
        lblRoom3.setForeground(Color.black);

        viewRoomReserve c1 = new viewRoomReserve();
        // jPanel2.setVisible(false);
        mainPanel1.removeAll();
        mainPanel1.removeAll();
        mainPanel1.repaint();
        mainPanel1.revalidate();
        c1.setSize(mainPanel1.getSize());
        mainPanel1.add(c1);

    }//GEN-LAST:event_lblRoom2MouseClicked

    private void btnView2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnView2MouseClicked
        view();        // TODO add your handling code here:
    }//GEN-LAST:event_btnView2MouseClicked

    private void btnView2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnView2MouseExited
        btnView2.setForeground(Color.white); // TODO add your handling code here:
    }//GEN-LAST:event_btnView2MouseExited

    private void btnView2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnView2MouseEntered
        btnView2.setForeground(Color.black);        // TODO add your handling code here:
    }//GEN-LAST:event_btnView2MouseEntered

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
        txtSearch.selectAll();        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchMouseClicked

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        String name = txtSearch.getText();
        ArrayList<GuestDTO> list = guestCntrl.getDetail(name);
        for (GuestDTO list1 : list) {
            try {
                
                ArrayList<ReservationDTO> dto = cntl.fillForm(list1.getGID());
                for (ReservationDTO c1 : dto) {
                    Object[] rowData = {c1.getRsID(), c1.getgID(), c1.getrID(), c1.getPersons(), c1.getCheck_In(), c1.getCheck_Out(), c1.getPrice()};
                    dtm.addRow(rowData);

                }
                //System.out.println(c1.getRsID());

            } catch (Exception ex) {
                Logger.getLogger(viewReservePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_txtSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnView2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblRoom;
    private javax.swing.JLabel lblRoom2;
    private javax.swing.JLabel lblRoom3;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel mainPanel1;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private void view() {
        try {
            ArrayList<ReservationDTO> reserve = cntl.getAllName();
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            for (ReservationDTO c1 : reserve) {
                Object[] rowData = {c1.getRsID(), c1.getgID(), c1.getrID(), c1.getPersons(), c1.getCheck_In(), c1.getCheck_Out(), c1.getPrice()};
                dtm.addRow(rowData);

            }
        } catch (Exception ex) {
            Logger.getLogger(viewGuestList.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

   
}
