package com.kimhj.toy.member.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kimhj.toy.member.vo.MemberVO;

@Repository
public class MemberDAO {

	private static final String NAME_SPACE = "com.kimhj.toy.member";
	
	@Resource
	private SqlSession sqlSession;
	
	public int userSign(MemberVO memberVO) throws Exception {
		return sqlSession.insert(NAME_SPACE+".memberInsert", memberVO);
	}

}
