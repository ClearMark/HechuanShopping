package com.kedom.authService.service;

import com.kedom.authService.entity.MailMessage;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.mail.MessagingException;
import java.util.Date;

/**
 * 邮件业务类
 * @author qzz
 */
@Service
public class MailService {

    /**
     * 注入邮件工具类
     */
    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @Autowired
    RedissonClient redissonClient;

    @Value("${spring.mail.username}")
    private String sendMailer;

    /**
     * 检测邮件信息类
     * @param to
     * @param subject
     * @param text
     */
    private void checkMail(String to,String subject,String text){
        if(StringUtils.isEmpty(to)){
            throw new RuntimeException("邮件收信人不能为空");
        }
        if(StringUtils.isEmpty(subject)){
            throw new RuntimeException("邮件主题不能为空");
        }
        if(StringUtils.isEmpty(text)){
            throw new RuntimeException("邮件内容不能为空");
        }
    }

/**
 * @description: TODO
 * @params: [mailMessage]
 * @return: void
 * @author: kedom
 * @dateTime: 2022/11/20 14:53
 */

    public void mailCodeUploadRedis(MailMessage mailMessage,String code){
        RBucket<String> bucket = redissonClient.getBucket(mailMessage.getTo()+mailMessage.getType());
        bucket.set(code);
        bucket.expireAt(new Date(System.currentTimeMillis()+1000*60*5));
    }

    public String mailCodeDownloadRedis(String to,Integer type){
        RBucket<String> bucket = redissonClient.getBucket(to+type);
        return bucket.get();
    }



    @Async("emailThreadPool")
    public void sendTextMailMessage(MailMessage mailMessage){
        try {
            System.out.println("邮件发送线程"+Thread.currentThread());

            //true 代表支持复杂的类型
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(javaMailSender.createMimeMessage(),true);
            //邮件发信人
            mimeMessageHelper.setFrom(sendMailer);
            //邮件收信人  1或多个
            mimeMessageHelper.setTo(mailMessage.getTo().split(","));
            //邮件主题
            mimeMessageHelper.setSubject(mailMessage.getSubject());
            //邮件内容
            mimeMessageHelper.setText(mailMessage.getText());
            //邮件发送时间
            mimeMessageHelper.setSentDate(new Date());

            //发送邮件
            javaMailSender.send(mimeMessageHelper.getMimeMessage());

            System.out.println("发送邮件成功："+sendMailer+"->"+mailMessage.getTo());

        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("发送邮件失败："+e.getMessage());
        }
    }
}


