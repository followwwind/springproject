package com.wind.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.codec.binary.Base64;

import com.wind.entity.Email;

//import sun.misc.BASE64Encoder;

/**
 * 邮件发送工具
 * 
 * @author followwwind
 *
 */
public class EmailUtils {
	
	/**
	 * 发送邮件
	 * @param email 邮件信息
	 */
	public static void sendEmail(Email email) {
		Properties props = email.getProps(); // 邮件配置信息
		Session session = Session.getInstance(props);// 根据属性新建一个邮件会话
		// session.setDebug(true); //有他会打印一些调试信息。
		String sender = email.getSender();
		String recevier = email.getReceiver();
		String title = email.getTitle();
		String content = email.getContent();
		String username = email.getUsername();
		String password = email.getPassword();
		List<DataSource> attachs = email.getAttachments();
		MimeMessage message = new MimeMessage(session);// 由邮件会话新建一个消息对象
		try {
			message.setFrom(new InternetAddress(sender));// 设置发件人的地址
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recevier));// 设置收件人,并设置其接收类型为TO
			message.setSubject(title);// 设置标题
			// 设置信件内容
			// message.setText(mailContent); //发送 纯文本 邮件 todo
			//message.setContent(mailContent, "text/html;charset=utf-8"); // 发送HTML邮件，内容样式比较丰富
			
			// 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
            Multipart multipart = new MimeMultipart("mixed");

            // 设置邮件的文本内容
            BodyPart contentPart = new MimeBodyPart();
            //contentPart.setText(content);
            contentPart.setContent(content,"text/html;charset=utf-8");
            multipart.addBodyPart(contentPart);
            Base64 base64=new Base64(); 
            //BASE64Encoder enc = new BASE64Encoder(); 
            for(DataSource attach : attachs){
            	// 添加附件
                BodyPart messageAttachs = new MimeBodyPart();
                // 添加附件的内容
                messageAttachs.setDataHandler(new DataHandler(attach));
                // 添加附件的标题
                byte[] b = base64.encode(attach.getName().getBytes("GBK"));
                System.out.println(new String(b));
                messageAttachs.setFileName("=?GBK?B?" + b + "?=");
                multipart.addBodyPart(messageAttachs);
            }
            // 将multipart对象放到message中
            message.setContent(multipart);
			message.setSentDate(new Date());// 设置发信时间
			message.saveChanges();// 存储邮件信息

			// 发送邮件
			// Transport transport = session.getTransport("smtp");
			Transport transport = session.getTransport();
			transport.connect(username, password);
			transport.sendMessage(message, message.getAllRecipients());// 发送邮件,其中第二个参数是所有已设好的收件人地址
			transport.close();
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
