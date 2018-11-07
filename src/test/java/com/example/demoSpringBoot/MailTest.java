package com.example.demoSpringBoot;

import com.qch.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by BF100499 on 2018/11/2.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTest {
    @Autowired
    private MailService mailService;


    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testSimpleMail() throws Exception {
        mailService.sendAttachmentsMail("1901487661@qq.com","test simple mail"," 尝试附件发送","e:\\city.xml");
    }
    @Test
    public void testHtmlMail() throws Exception {
        String rsId="00ce1";
        String content="<html><body><div><h3>这是有图片的邮件：</h3><img src=\'cid:" + rsId + "\' ></div></body></html>";
        String imgPath = "C:\\Users\\Public\\Pictures\\Sample Pictures\\菊花.jpg";
        mailService.sendInlineResourceMail("1901487661@qq.com","test simple mail",content,rsId,imgPath);
    }

    @Test
    public void sendTemplateMail() {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("id", "006");
        String emailContent = templateEngine.process("emailTemplate", context);

        mailService.sendHtmlMail("1901487661@qq.com","主题：这是模板邮件",emailContent);
    }
}
