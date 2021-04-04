package com.sist.board;
import java.util.*;
import java.io.*;
import com.sist.dao.*;
import com.sist.r.RManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	@Autowired
	private BoardDAO dao;
	@Autowired
	private RManager rm;
	@RequestMapping("main/list.do")
	public String board_list(String page,Model model) {
		//초기값은 null이기 때문에 int no을 사용하지 않음
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=10;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		List<BoardVO> list=dao.boardListData(map);
		model.addAttribute("list", list);
		
		int totalpage=dao.boardTotalPage();
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("curpage", curpage);
		
		return "list";
	}
	
	@RequestMapping("main/insert.do")
	public String board_insert(BoardVO vo){
		
		return "insert";
	}
	
	@RequestMapping("main/insert_ok.do")
	public String board_insert_ok(BoardVO vo){
		dao.boardInsert(vo);
		//sendRedirect
		return "redirect:/main/list.do";
	}
	
	@RequestMapping("main/content.do")
	public String board_content(int no,Model model) {
		BoardVO vo=dao.boardContentData(no);
		try{
			//파일에 덮어씌우기
			FileWriter fw=new FileWriter("c:\\data\\board.txt");
			//파일 아래에 붙이기
			//FileWriter fw=new FileWriter("c:\\data\\board.txt");
			fw.write(vo.getContent());
			fw.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		rm.rGraph();
		model.addAttribute("vo", vo);
		return "content";
	}
	
	@RequestMapping("main/update.do")
	public String board_update(int no,Model model){
		BoardVO vo=dao.boardUpdateData(no);
		model.addAttribute("vo", vo);
		
		return "update";
	}
	
	@RequestMapping("main/delete.do")
	public String board_delete(int no,Model model){
		model.addAttribute("no", no);
		return "delete";
	}
}


















