package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
public interface BoardMapper {
	@Select("SELECT no,subject,name,regdate,hit,num "
			+ "FROM (SELECT no,subject,name,regdate,hit,rownum as num "
			+ "FROM (SELECT no,subject,name,regdate,hit "
			+ "FROM springboard ORDER BY no DESC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(Map map);
	
	//½ÃÄö½º
	@SelectKey(keyProperty="no",resultType=int.class,
				before=true,statement="SELECT NVL(MAX(no)+1,1) as no FROM springBoard")
	@Insert("INSERT INTO springBoard values("
			+ "#{no},#{name},#{subject},#{content},"
			+ "#{pwd},SYSDATE,0)")
	public void boardInsert(BoardVO vo);
	
	@Update("UPDATE springBoard SET "
			+ "hit=hit+1 "
			+ "WHERE no=#{no}")
	public void boardHitIncrement(int no);
	
	@Select("SELECT no,name,subject,content,regdate,hit "
			+ "FROM springBoard "
			+ "WHERE no=#{no}")
	public BoardVO boardContentData(int no);
	
	@Select("SELECT CEIL(COUNT(*)/10) FROM springboard")
	public int boardTotalPage();
	
	@Select("SELECT pwd FROM springBoard WHERE no=#{no}")
	public String boardPwdComfirm(int no);
	
	@Update("UPDATE springBoard "
			+ "SET name=#{name},subject=#{subject},content=#{content} "
			+ "WHERE no=#{no}")
	public void boardUpdate(BoardVO vo);
	
	@Delete("DELETE FROM springBoard "
			+ "WHERE no=#{no}")
	public void boardDelete(int no);
}









