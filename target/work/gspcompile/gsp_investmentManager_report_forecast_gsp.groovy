import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_investmentManager_report_forecast_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/report/_forecast.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
loop:{
int i = 0
for( forecast in (list.sort{it.ranking}) ) {
printHtmlPart(1)
if(true && (i == 0)) {
printHtmlPart(2)
expressionOut.print(Integer.parseInt(grailsApplication.config.grails.data.forecast.items))
printHtmlPart(3)
}
printHtmlPart(4)
if(true && (i == Integer.parseInt(grailsApplication.config.grails.data.forecast.items))) {
printHtmlPart(2)
expressionOut.print(Integer.parseInt(grailsApplication.config.grails.data.forecast.items))
printHtmlPart(5)
}
printHtmlPart(6)
expressionOut.print(forecast.asset.company.symbol)
printHtmlPart(7)
invokeTag('formatNumber','g',33,['number':(forecast.asset.stock.capm/100),'type':("percent"),'minFractionDigits':("2"),'maxFractionDigits':("2")],-1)
printHtmlPart(8)
for( investment in (forecast.investments.sort{it.ranking}) ) {
printHtmlPart(9)
invokeTag('formatNumber','g',43,['number':(investment.principal),'type':("currency"),'currencyCode':("USD")],-1)
printHtmlPart(10)
expressionOut.print(investment.days)
printHtmlPart(11)
invokeTag('formatNumber','g',46,['number':(investment.interest),'type':("currency"),'currencyCode':("USD")],-1)
printHtmlPart(12)
invokeTag('formatNumber','g',48,['number':(investment.interest/investment.principal),'type':("percent"),'minFractionDigits':("2"),'maxFractionDigits':("2")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (i == Integer.parseInt(grailsApplication.config.grails.data.forecast.items)-1  || i == (Integer.parseInt(grailsApplication.config.grails.data.forecast.items)*2)-1)) {
printHtmlPart(15)
}
printHtmlPart(16)
i++
}
}
printHtmlPart(17)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1405966374583L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
