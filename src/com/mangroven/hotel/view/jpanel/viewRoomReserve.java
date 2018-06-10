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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tharindu
 */
public class viewRoomReserve extends javax.swing.JPanel {
private ReservationController cntrl;
private GuestController guestCntrl;    
     /* Creates new form viewRoomReserve
     */
    public viewRoomReserve() {
        initComponents();
        guestCntrl = (GuestController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.GUEST);
        cntrl=(ReservationController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.RESERVATION);
        view();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnView2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtSearch1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(254, 254, 254));

        jPanel2.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());

        jScrollPane1.setBackground(new java.awt.Color(254, 254, 254));
        jScrollPane1.setBorder(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "  Reservation ID", "  Guest ID", "  Room ID", "  Persons", " Check In", " Check Out"
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
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnView2MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnView2MouseEntered(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(168, 1, 1));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/image1.gif"))); // NOI18N
        jLabel1.setText("    View Room Reservation  ");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtSearch1.setText(" Search Guest Details");
        txtSearch1.setBorder(null);
        txtSearch1.setOpaque(false);
        txtSearch1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearch1MouseClicked(evt);
            }
        });
        txtSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearch1ActionPerformed(evt);
            }
        });

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/icon/search.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator2)
                    .addComponent(txtSearch1, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(txtSearch1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1070, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(922, 922, 922)
                        .addComponent(btnView2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1600, 1600, 1600))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnView2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1094, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1554, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnView2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnView2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnView2MouseClicked

    private void btnView2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnView2MouseExited
        btnView2.setForeground(Color.white); // TODO add your handling code here:
    }//GEN-LAST:event_btnView2MouseExited

    private void btnView2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnView2MouseEntered
        btnView2.setForeground(Color.black);        // TODO add your handling code here:
    }//GEN-LAST:event_btnView2MouseEntered

    private void txtSearch1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearch1MouseClicked
        txtSearch1.selectAll();        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch1MouseClicked

    private void txtSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch1ActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        String name = txtSearch1.getText();
        ArrayList<GuestDTO> list = guestCntrl.getDetail(name);
        for (GuestDTO list1 : list) {
            try {
                
                ArrayList<ReservationDTO> dto = cntrl.fillForm(list1.getGID());
                for (ReservationDTO c1 : dto) {
                    Object[] rowData = {c1.getRsID(), c1.getgID(), c1.getrID(), c1.getPersons(), c1.getCheck_In(), c1.getCheck_Out(), c1.getPrice()};
                    dtm.addRow(rowData);

                }
                //System.out.println(c1.getRsID());

            } catch (Exception ex) {
                Logger.getLogger(viewReservePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_txtSearch1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnView2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtSearch1;
    // End of variables declaration//GEN-END:variables

public void view(){
try {
            ArrayList<ReservationDTO> reserve = cntrl.getAllName();
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            for (ReservationDTO c1 : reserve) {
                Object[] rowData = {c1.getRsID(), c1.getgID(), c1.getrID(), c1.getPersons(), c1.getCheck_In(), c1.getCheck_Out()};
                dtm.addRow(rowData);
            }
        } catch (Exception ex) {
            Logger.getLogger(viewGuestList.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}