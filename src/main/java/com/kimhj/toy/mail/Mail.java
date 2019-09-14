package com.kimhj.toy.mail;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.kimhj.toy.member.vo.MemberVO;

public class Mail {
	
	private JavaMailSender mail;
	private MimeMessage msg;
	private MimeMessageHelper msgHelper;
	
	public void send(MemberVO memberVO) {
		msg = mail.createMimeMessage();
		
		try {
			String text = "가입신 정상적으로 완료되었습니다 <br>"
					+ "관리자의 승인 처리 후 사이트틀 정상적으로 이용하실 수 있습니다.";
			
			
			msgHelper = new MimeMessageHelper(msg, true, "UTF-8");
			msgHelper.setSubject("가입신이 정상적으로 완료되었습니다.");
			msgHelper.setText(text, true);
			msgHelper.setFrom("rlagownd113@naver.com");
			msgHelper.setTo(memberVO.getEmail());
			
			mail.send(msg);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}







