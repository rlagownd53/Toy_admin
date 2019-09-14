package com.kimhj.toy.member.controller;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kimhj.toy.member.service.MemberService;
import com.kimhj.toy.member.vo.MemberVO;

/* 
 * controller -> service -> daoimpl
 * */

@Controller
@RequestMapping("/accounts")
public class MemberController {

	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource
	MemberService memberService;
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String goLoginPg(HttpServletRequest request) {
		return "member/login";
	}
	@RequestMapping(value="/loginAjax.do", method=RequestMethod.POST)
	public String loginAjax(HttpServletRequest request, ModelMap model) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		
		//로그인 체크 후 세션에 사용자 정보 담
		return "/";
	}
 	@RequestMapping(value="/sign.do", method=RequestMethod.GET)
 	public String goSignPg() {
 		return "member/sign";
 	}
 	@RequestMapping(value="/sign.do", method=RequestMethod.POST)
 	public ModelMap sign(HttpServletRequest request, MemberVO memberVO, ModelMap model) {
 		int result = 0;
 		try {
 			log.debug("### memberVO ==> "+memberVO.toString());
 			result = memberService.userSign(memberVO);
 		}catch(Exception e) {
 			log.error("error ==> "+e);
 		}
 		
 		model.put("result", result);
		return model;
 		
 	}
}
