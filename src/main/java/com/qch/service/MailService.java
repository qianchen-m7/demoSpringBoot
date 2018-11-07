package com.qch.service;

/**
 * Created by BF100499 on 2018/11/2.
 */
public interface MailService {


        public void sendSimpleMail(String to, String subject, String content);

        public void sendHtmlMail(String to, String subject, String content);

        public void sendAttachmentsMail(String to, String subject, String content, String filePath);

        public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);


}
