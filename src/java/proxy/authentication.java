package proxy;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class authentication {
    
    public static void setProxy(String protocol, final String authUser, final String authPassword,
            String proxyHost, String proxyPort){
    
        System.setProperty(protocol+".proxyHost", proxyHost);
        System.setProperty(protocol+".proxyPort",proxyPort);
        System.setProperty(protocol+".proxyUser", authUser);
        System.setProperty(protocol+".proxyPassword", authPassword);

        Authenticator.setDefault(
          new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
              return new PasswordAuthentication(authUser, authPassword.toCharArray());
            }
          });
        }
}
