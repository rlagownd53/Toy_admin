package com.kimhj.toy.member.service;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.kimhj.toy.mail.Mail;
import com.kimhj.toy.member.dao.MemberDAO;
import com.kimhj.toy.member.vo.MemberVO;
import com.kimhj.toy.security.SecuritySHA256;

@Service
public class MemberServiceImpl implements MemberService {

	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Inject
	private SecuritySHA256 sec;
	 
	@Resource
	private MemberDAO mdao;
	
	@Resource
	private Mail mail; 
	
	@Override
	public int userSign(MemberVO memberVO) throws Exception {
		if(memberVO.getPassword() != "" || memberVO.getPassword() != null) {
			memberVO.setPassword(sec.hashPassword(memberVO.getPassword()));
		}
		
		int result = mdao.userSign(memberVO);
		
		if(result > 0 ) {
			mail.send(memberVO);
		}
		return result;
	}

}
