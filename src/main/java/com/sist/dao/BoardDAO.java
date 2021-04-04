	package com.sist.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	@Autowired
	private BoardMapper mapper;
	public List<BoardVO> boardListData(Map map) {
		return mapper.boardListData(map);
	}
	
	public void boardInsert(BoardVO vo){
		mapper.boardInsert(vo);
	}
	
	public BoardVO boardContentData(int no){
		mapper.boardHitIncrement(no);
		return mapper.boardContentData(no);
	}
	
	public int boardTotalPage(){
		return mapper.boardTotalPage();
	}
	
	public BoardVO boardUpdateData(int no){
		return mapper.boardContentData(no);
	}
	
	public boolean boardUpdate(BoardVO vo){
		boolean bCheck=false;
		String pwd=mapper.boardPwdComfirm(vo.getNo());
		if(pwd.equals(vo.getPwd())){
			bCheck=true;
			mapper.boardUpdate(vo);
		}
		return bCheck;
	}
	
	public boolean boardDelete(int no,String pwd){
		boolean bCheck=false;
		String db_pwd=mapper.boardPwdComfirm(no);
		if(db_pwd.equals(pwd)){
			bCheck=true;
			mapper.boardDelete(no);
		}
		return bCheck;
	}
	
}
