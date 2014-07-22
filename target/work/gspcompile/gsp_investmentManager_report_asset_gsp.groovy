import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_investmentManager_report_asset_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/report/_asset.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(Integer.parseInt(grailsApplication.config.grails.data.assets.items))
printHtmlPart(1)
for( asset in (list.sort{it.ranking}) ) {
printHtmlPart(2)
expressionOut.print(asset.ranking + 1)
printHtmlPart(3)
expressionOut.print(asset.company.name)
printHtmlPart(4)
expressionOut.print(asset.company.symbol)
printHtmlPart(5)
expressionOut.print(asset.company.marketcap)
printHtmlPart(6)
expressionOut.print(asset.company.state)
printHtmlPart(7)
expressionOut.print(asset.company.zipcode)
printHtmlPart(8)
invokeTag('formatNumber','g',41,['number':(asset.stock.marketprice),'type':("currency"),'currencyCode':("USD")],-1)
printHtmlPart(9)
invokeTag('formatNumber','g',45,['number':(asset.stock.pricechange/100),'type':("percent"),'minFractionDigits':("2"),'maxFractionDigits':("2")],-1)
printHtmlPart(10)
if(true && (asset.stock.beta > 0)) {
printHtmlPart(11)
expressionOut.print(asset.stock.beta)
printHtmlPart(12)
}
else {
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (asset.stock.capm > 0)) {
printHtmlPart(15)
invokeTag('formatNumber','g',58,['number':(asset.stock.capm/100),'type':("percent"),'minFractionDigits':("2"),'maxFractionDigits':("2")],-1)
printHtmlPart(12)
}
else {
printHtmlPart(13)
}
printHtmlPart(16)
}
printHtmlPart(17)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1405961459319L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
