package xml;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import xml.bounds.com.microsoft.schemas.ado._2007._08.dataservices.metadata.Properties;
import xml.bounds.org.w3._2005.atom.Feed;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */
public class TreasuryXML {
    
    private static class Bound{
        String caption;
        int days;
        Float rate;

        public Bound() {
            caption = "";
            days = Integer.MIN_VALUE;
            rate = Float.NaN;
        }

        public String getCaption() {
            return caption;
        }

        public void setCaption(String caption) {
            this.caption = caption;
        }

        public int getDays() {
            return days;
        }

        public void setDays(int days) {
            this.days = days;
        }

        public Float getRate() {
            return rate;
        }

        public void setRate(Float rate) {
            this.rate = rate;
        }

        @Override
        public String toString() {
            return "Bound{" + "caption=" + caption + ", days=" + days + ", rate=" + rate + '}';
        }
        
    }
       
    public static List getDailyTreasuryBonds(String baseUrl, Date date){
        List list = new ArrayList();
            
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        String treasuryUrl = baseUrl;
            treasuryUrl += "$filter=month(NEW_DATE) eq "+calendar.get(Calendar.MONTH)+" and year(NEW_DATE) eq "+(calendar.get(Calendar.YEAR));
            treasuryUrl = treasuryUrl.replace(" ", "%20");
        
        Feed feed = (Feed)XMLService.getObject(Feed.class, treasuryUrl);
        if(feed != null){
            Properties properties = feed.getEntry().get(feed.getEntry().size()-1).getContent().getProperties();

            //1-Year
            Bound oneYear = new Bound();
            oneYear.setRate(properties.getBC1YEAR().getValue().floatValue());
            list.add(oneYear);

            //5-Year
            Bound fiveYear = new Bound();
            fiveYear.setRate(properties.getBC5YEAR().getValue().floatValue());
            list.add(fiveYear);

            //10-Year
            Bound tenYear = new Bound();
            tenYear.setRate(properties.getBC10YEAR().getValue().floatValue());
            list.add(tenYear);

        }else{ //Error at server, default value
            Bound oneYear = new Bound();
            oneYear.setRate(0.11f);
            list.add(oneYear);
        }
        return list;
    }
}
