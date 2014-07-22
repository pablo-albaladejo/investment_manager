import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_investmentManager_report_summary_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/report/_summary.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('formatDate','g',7,['date':(summary.date),'type':("datetime"),'style':("LONG"),'timeStyle':("LONG"),'locale':("US")],-1)
printHtmlPart(1)
invokeTag('formatNumber','g',9,['number':(summary.riskFree/100),'type':("percent"),'minFractionDigits':("2"),'maxFractionDigits':("2")],-1)
printHtmlPart(2)
invokeTag('formatNumber','g',10,['number':(summary.marketReturn/100),'type':("percent"),'minFractionDigits':("2"),'maxFractionDigits':("2")],-1)
printHtmlPart(3)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1405940593190L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
