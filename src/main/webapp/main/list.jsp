<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%--
    	문자열 제어
    	${fn:substring("aaa",1,3)}
    	fn => 문자열(String),List
     --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<style type="text/css">
.row{
	margin: 0px auto;
	width:700px;
}
</style>
<body>
	<div class="container">
		<div class="row">
			<center>
				<h3>아무거나 게시판</h3>
			</center>
			<table class="table talbe-hover" width=700>
				<tr>
					<td class="text-left">
						<a href="insert.do" class="btn btn-sm btn-primary">새글</a>
					</td>
				</tr>
			</table>
			<table class="table table-hover" width=700>
				<tr class="danger">
					<th class="text-center" width=10%>번호</th>
					<th class="text-center" width=45%>제목</th>
					<th class="text-center" width=15%>이름</th>
					<th class="text-center" width=20%>작성일</th>
					<th class="text-center" width=10%>조회수</th>
				</tr>
				<c:set var="color" value="default" />
				<c:forEach var="vo" items="${list }" varStatus="s">
				
				<c:if test="${s.index%2==0 }">
					<c:set var="color" value="default" />	
				</c:if>
				<c:if test="${s.index%2!=0 }">
					<c:set var="color" value="warning" />	
				</c:if>
					<tr class="${color }">
					<td class="text-center" width=10%>${vo.no }</td>
					<td class="text-left" width=45%>
						<a href="content.do?no=${vo.no }">${vo.subject }</a>
					</td>
					<td class="text-center" width=15%>${vo.name }</td>
					<td class="text-center" width=20%>
						<fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd"/>
					</td>
					<td class="text-center" width=10%>${vo.hit }</td>
					</tr>
				</c:forEach>
			</table>
			
			<table class="table table-hover" width="700">
				<tr>
					<td class="text-right">
						<a href="list.do?page=${curpage>1?curpage-1:curpage }" class="btn btn-sm btn-primary">이전</a>
						<a href="list.do?page=${curpage<totalpage?curpage+1:curpage }" class="btn btn-sm btn-primary">다음</a>
						&nbsp;&nbsp;${curpage } page / ${totalpage } pages
					</td>
				</tr>
			
			</table>
		</div>
	</div>
</body>
</html>

























