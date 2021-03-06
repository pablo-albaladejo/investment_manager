import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_investmentManager_layoutsmobile_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/mobile.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge,chrome=1")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('layoutTitle','g',6,['default':("Investment Manager")],-1)
})
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1.0")],-1)
printHtmlPart(2)
expressionOut.print(assetPath(src: 'favicon.ico'))
printHtmlPart(3)
expressionOut.print(assetPath(src: 'apple-touch-icon.png'))
printHtmlPart(4)
expressionOut.print(assetPath(src: 'apple-touch-icon-retina.png'))
printHtmlPart(5)
invokeTag('stylesheet','asset',11,['src':("mobile.css")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',12,['src':("application.js")],-1)
printHtmlPart(1)
invokeTag('layoutHead','g',13,[:],-1)
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',14,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
invokeTag('image','asset',16,['src':("investmentmanager_logo.png"),'alt':("Investment Manager")],-1)
printHtmlPart(8)
createClosureForHtmlPart(9, 2)
invokeTag('link','g',19,['uri':("/mobile")],2)
printHtmlPart(10)
createClosureForHtmlPart(11, 2)
invokeTag('link','g',22,['controller':("report"),'action':("overall")],2)
printHtmlPart(12)
createClosureForHtmlPart(13, 2)
invokeTag('link','g',23,['controller':("report"),'action':("json")],2)
printHtmlPart(14)
createClosureForHtmlPart(15, 2)
invokeTag('link','g',27,['controller':("email"),'action':("add")],2)
printHtmlPart(12)
createClosureForHtmlPart(16, 2)
invokeTag('link','g',28,['controller':("email"),'action':("list")],2)
printHtmlPart(17)
expressionOut.print(assetPath(src: 'spinner.gif'))
printHtmlPart(18)
invokeTag('message','g',31,['code':("spinner.alt"),'default':("Loading&hellip;")],-1)
printHtmlPart(19)
invokeTag('layoutBody','g',32,[:],-1)
printHtmlPart(20)
})
invokeTag('captureBody','sitemesh',36,['onload':("onLoadFunction()")],1)
printHtmlPart(21)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1405965342486L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
