/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codejava.swing.mail;

import com.mangroven.hotel.view.jpanel.skipPanel;
import com.mangroven.hotel.view.jpanel.viewReservePanel;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Athukorala
 */
public class Backup {

    public static void BackupDbToSql() {

        try {
            CodeSource codeSource = viewReservePanel.class.getProtectionDomain().getCodeSource();
            File jarFile = new File(codeSource.getLocation().toURI().getPath());

            String jarDir = jarFile.getParentFile().getPath();
            String dbName = "MangrovenNew";
            String dbUser = "root";
            String dbPass = "4241";
            System.out.println(jarDir);
            String foldePath = jarDir + "\\Backup";

            File f1 = new File(foldePath);
            f1.mkdir();

            String savePath = "\"" + jarDir + "\\Backup\\" + "backup.sql\"";
            //System.out.println(savePath);
            String executeCmd = "mysqldump -u " + dbUser + " -p" + dbPass + " " + dbName + " -r " + savePath;
            System.out.println(executeCmd);
            Process runtimeprocess = Runtime.getRuntime().exec(executeCmd);

            int processComplete = runtimeprocess.waitFor();

            if (processComplete == 0) {
                JOptionPane.showMessageDialog(null, "Backup Success");
                String email = "tharinduathukorala1@gmail.com";
                String path = savePath;
                EmailAttachmentSender send = new EmailAttachmentSender();
                send.attachment(email, path);
            } else {
                JOptionPane.showMessageDialog(null, "Backup Failed");

            }

        } catch (URISyntaxException | IOException | InterruptedException ex) {

            JOptionPane.showMessageDialog(null, "Error at backup" + ex.getMessage());

        }
    }
}
