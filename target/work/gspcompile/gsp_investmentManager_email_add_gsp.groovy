import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_investmentManager_email_add_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/email/_add.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(2)
invokeTag('textField','g',10,['name':("name"),'value':(fieldValue(bean:email,field:'name'))],-1)
printHtmlPart(3)
invokeTag('textField','g',14,['name':("surname"),'value':(fieldValue(bean:email,field:'surname'))],-1)
printHtmlPart(4)
invokeTag('textField','g',18,['name':("address"),'value':(fieldValue(bean:email,field:'address'))],-1)
printHtmlPart(5)
invokeTag('actionSubmit','g',20,['value':("Save")],-1)
printHtmlPart(6)
})
invokeTag('form','g',20,['controller':("email"),'action':("save")],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('renderErrors','g',25,['bean':(email),'as':("list")],-1)
printHtmlPart(9)
})
invokeTag('hasErrors','g',27,['bean':(email)],2)
printHtmlPart(10)
})
invokeTag('captureBody','sitemesh',28,[:],1)
printHtmlPart(0)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1405954545519L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
