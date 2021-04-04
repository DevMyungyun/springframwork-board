package com.sist.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.dao.BoardDAO;
import com.sist.dao.BoardVO;

@RestController
public class BoardRestController {
	
	@Autowired
	private BoardDAO dao;
	@RequestMapping("main/update_ok.do")
	public String update_ok(BoardVO vo) {
		String data="";
		boolean bCheck=dao.boardUpdate(vo);
		if(bCheck==true) {
			data="<script>location.href=\"content.do?no="+vo.getNo()+"\";"
					+ "<script>";
		}else{
			data="<script>alert(\"잘못된 비밀번호입니다.\");"
					+ "history.back();<script>";
		}
				
		return data;
	}
	
	@RequestMapping("main/delete_ok.do")
	public String board_delete_ok(int no,String pwd){
		String data="";
		boolean bCheck=dao.boardDelete(no, pwd);
		if(bCheck==true){
			data="<script>location.href=\"list.do\";"
					+ "</script>";
		}else{
			data="<script>alert(\"잘못된 비밀번호입니다.\""
					+ "history.back();</script>";
				
		}
		return data;
	}
}
