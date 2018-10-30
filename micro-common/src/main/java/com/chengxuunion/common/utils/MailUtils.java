package com.chengxuunion.common.utils;

import java.io.File;
import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.LoggerFactory;

import com.chengxuunion.common.utils.properties.MailPropertiesUtils;
import com.chengxuunion.common.utils.properties.PropertiesReader;
import com.sun.mail.util.MailSSLSocketFactory;

/**
 * 邮件工具类
 *
 * @author kutome
 * @date 2018年8月29日
 * @version V1.0
 */
public class MailUtils {
	
	private static PropertiesReader instance = MailPropertiesUtils.getInstance();

	/**
	 * 邮件发送协议
	 */
	private final static String PROTOCOL = instance.getValue("mail.transport.protocol");
	
	/**
	 * SMTP邮件服务器  
	 */
	private final static String HOST = instance.getValue("mail.smtp.host");
	
	/**
	 * SMTP邮件服务器端口
	 */
	private final static String PORT = instance.getValue("mail.smtp.port");
	
	/**
	 * 是否要求身份认证
	 */
	private final static String IS_AUTH = instance.getValue("mail.smtp.auth");
	
	/**
	 * 发送人地址
	 */
	private final static String FROM = instance.getValue("from");
	
	/**
	 * 登录授权码
	 */
	private final static String LOGIN_AUTH_CODE = instance.getValue("login.authcode");
	
	/**
	 * 发送文本格式邮件
	 * 
	 * @param receiver	接收人地址
	 * @param emailSubject	邮件主题
	 * @param emailContent	邮件内容
	 * @param emailContentType	邮件内容类型，支持纯文本:"text/plain;charset=utf-8";,带有Html格式的内容:"text/html;charset=utf-8" 
	 * @return	发送成功返回1，否则返回0
	 */
	public static int sendTextEmail(String receiver, String emailSubject, String emailContent, String emailContentType) {
		int res = 0;
		
		//跟smtp服务器建立一个连接
        Properties p = new Properties();
        
        //设置邮件服务器主机名
        p.setProperty("mail.smtp.host", HOST);
        
        //邮件服务器主机端口号
        p.setProperty("mail.smtp.port", PORT);  
        
        //发送服务器需要身份验证,要采用指定用户名密码的方式去认证
        p.setProperty("mail.smtp.auth", IS_AUTH);
        
        //发送邮件协议名称
        p.setProperty("mail.transport.protocol", PROTOCOL);
        
        //开启SSL加密，否则会失败
        MailSSLSocketFactory sf;
		try {
			sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
			p.put("mail.smtp.starttls.enable", "true");
	        p.put("mail.smtp.ssl.enable", "true");
	        //p.put("mail.smtp.ssl.socketFactory", sf);
	        //p.put("mail.smtp.socketFactory.fallback", "false");
			p.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			p.setProperty("mail.smtp.socketFactory.fallback", "false");
			p.setProperty("mail.smtp.socketFactory.port", PORT);
	        
	        
	        // 创建session
            Session session = Session.getDefaultInstance(p, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    //用户名可以用QQ账号也可以用邮箱的别名:第一个参数为邮箱账号,第二个为授权码
                    PasswordAuthentication pa = new PasswordAuthentication(FROM, LOGIN_AUTH_CODE);
                    return pa;
                }
            });
            
            //声明一个Message对象(代表一封邮件),从session中创建
            MimeMessage msg = new MimeMessage(session);
            //邮件信息封装
            //1发件人
            msg.setFrom(new InternetAddress(FROM));
            
            //2收件人
            msg.setRecipient(RecipientType.TO, new InternetAddress(receiver));

            //3邮件内容:主题、内容
            msg.setSubject(emailSubject);
            msg.setContent(emailContent,emailContentType);//发html格式的文本
            
            //发送动作
            Transport.send(msg);
            
            res = 1;
		} catch (GeneralSecurityException | MessagingException e) {
			LoggerFactory.getLogger(MailUtils.class).error("发送邮件失败", e);
			res = 0;
		}
		
		return res;
	}
	
	/**
	 * 发送HTML格式邮件(带图片)
	 * 
	 * @param receiver	接收人地址
	 * @param emailSubject	邮件主题
	 * @param emailContent	邮件内容
	 * @param emailContentType	邮件内容类型，支持纯文本:"text/plain;charset=utf-8";,带有Html格式的内容:"text/html;charset=utf-8" 
	 * @return	发送成功返回1，否则返回0
	 */
	public static int sendHtmlImageEmail(String receiver, String emailSubject, String emailContent, String emailContentType, String cid, String filePath) {
		int res = 0;
		
		//跟smtp服务器建立一个连接
        Properties p = new Properties();
        
        //设置邮件服务器主机名
        p.setProperty("mail.smtp.host", HOST);
        
        //邮件服务器主机端口号
        p.setProperty("mail.smtp.port", PORT);  
        
        //发送服务器需要身份验证,要采用指定用户名密码的方式去认证
        p.setProperty("mail.smtp.auth", IS_AUTH);
        
        //发送邮件协议名称
        p.setProperty("mail.transport.protocol", PROTOCOL);
        
        //开启SSL加密，否则会失败
        MailSSLSocketFactory sf;
		try {
			sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
			p.put("mail.smtp.starttls.enable", "true");
	        p.put("mail.smtp.ssl.enable", "true");
	        //p.put("mail.smtp.ssl.socketFactory", sf);
	        //p.put("mail.smtp.socketFactory.fallback", "false");
			p.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			p.setProperty("mail.smtp.socketFactory.fallback", "false");
			p.setProperty("mail.smtp.socketFactory.port", PORT);
	        
	        
	        // 创建session
            Session session = Session.getDefaultInstance(p, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    //用户名可以用QQ账号也可以用邮箱的别名:第一个参数为邮箱账号,第二个为授权码
                    PasswordAuthentication pa = new PasswordAuthentication(FROM, LOGIN_AUTH_CODE);
                    return pa;
                }
            });
            
            //声明一个Message对象(代表一封邮件),从session中创建
            MimeMessage msg = new MimeMessage(session);
            //邮件信息封装
            //1发件人
            msg.setFrom(new InternetAddress(FROM));
            
            //2收件人
            msg.setRecipient(RecipientType.TO, new InternetAddress(receiver));

            //3邮件内容:主题、内容
            msg.setSubject(emailSubject);
            //msg.setContent(emailContent,emailContentType);//发html格式的文本
            
            //创建图片"节点"
            MimeBodyPart image = new MimeBodyPart();
            //读取本地文件
            DataHandler dh = new DataHandler(new FileDataSource(new File(filePath)));
            //将图片数据添加到"节点"
            image.setDataHandler(dh);
            // 为"节点"设置一个唯一编号（在文本"节点"将引用该ID）
            image.setContentID(cid);    
            
            //创建文本"节点"
            MimeBodyPart text = new MimeBodyPart();
            text.setContent(emailContent, emailContentType); 
            
            //（文本+图片）设置 文本 和 图片"节点"的关系（将 文本 和 图片"节点"合成一个混合"节点"）
            MimeMultipart mm_text_image = new MimeMultipart();
            mm_text_image.addBodyPart(text);
            mm_text_image.addBodyPart(image);
            mm_text_image.setSubType("related");    // 关联关系
            
            msg.setContent(mm_text_image);
            
            //发送动作
            Transport.send(msg);
            
            res = 1;
		} catch (GeneralSecurityException | MessagingException e) {
			LoggerFactory.getLogger(MailUtils.class).error("发送邮件失败", e);
			res = 0;
		}
		
		return res;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(MailUtils.sendTextEmail("992425124@qq.com", "test", "test", "text/plain;charset=utf-8"));
	}
	
}
