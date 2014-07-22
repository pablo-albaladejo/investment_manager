import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_investmentManager_emailadd_mobile_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/email/add_mobile.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("mobile")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('textField','g',15,['name':("name"),'value':(fieldValue(bean:email,field:'name'))],-1)
printHtmlPart(6)
invokeTag('textField','g',19,['name':("surname"),'value':(fieldValue(bean:email,field:'surname'))],-1)
printHtmlPart(7)
invokeTag('textField','g',23,['name':("address"),'value':(fieldValue(bean:email,field:'address'))],-1)
printHtmlPart(8)
invokeTag('actionSubmit','g',25,['value':("Save")],-1)
printHtmlPart(9)
})
invokeTag('form','g',25,['controller':("email"),'action':("save")],2)
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('renderErrors','g',30,['bean':(email),'as':("list")],-1)
printHtmlPart(12)
})
invokeTag('hasErrors','g',32,['bean':(email)],2)
printHtmlPart(13)
})
invokeTag('captureBody','sitemesh',33,[:],1)
printHtmlPart(14)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1405953912091L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
