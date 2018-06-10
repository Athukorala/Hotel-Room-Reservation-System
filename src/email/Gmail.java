/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email;

import javax.mail.MessagingException;

/**
 *
 * @author Athukorala
 */
public class Gmail {

    /**
     * @param args the command line arguments
     */
    public Gmail(String email,String tit,String des) throws MessagingException {
        GoogleMail.Send("tharindu.hotelgdse41", "gdse41hotel", email/*"tharinduathukorala1@gmail.com"*/, tit/*"test"*/,des/* "adow"*/);
    }
    
}
