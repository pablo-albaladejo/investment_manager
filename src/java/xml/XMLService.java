package xml;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class XMLService {
    
    public static Object getObject(Class objectClass, String url){
        try{
            JAXBContext context = JAXBContext.newInstance(objectClass);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            
            URL urlObject = new URL(url);
            URLConnection urlConnection = urlObject.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            
            //http://stackoverflow.com/questions/5138696/org-xml-sax-saxparseexception-content-is-not-allowed-in-prolog            
            Reader reader = new InputStreamReader(in,"UTF-8");
            return unmarshaller.unmarshal(reader);
            
        } catch (Exception ex) {
            System.out.println(ex);
            return null;    
        }
    }
}
