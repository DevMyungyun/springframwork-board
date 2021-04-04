<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<style type="text/css">
.row{
	margin: 0px auto;
	width:700px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<center>
				<h3>스프링 게시판</h3>
			</center>
		
	<form action="insert_ok.do" method="post">
	<table class="table table-hover" width="600">
		<tr>
			<td width="15%" class="text-right">이름</td>
			<td width="85%">
				<input type="text" name="name" size="15">
			</td>
		</tr>
		<tr>
			<td width="15%" class="text-right">제목</td>
			<td width="85%">
				<input type="text" name="subject" size="15">
			</td>
		</tr>
		<tr>
			<td width="15%" class="text-right">내용</td>
			<td width="85%">
				<textarea rows="10" cols="55" name="content"></textarea>
			</td>
		</tr>
		<tr>
			<td width="15%" class="text-right">비밀번호</td>
			<td width="85%">
				<input type="password" name="pwd" size="10">
			</td>
		</tr>
		<tr>
			<td colspan="2" class="text-right">
				<input type="submit" value="글쓰기" class="btn btn-info">
				<input type="button" value="취소" class="btn btn-danger"
					onclick="javascript.history.back()">
			</td>
		</tr>
	
	</table>
	</form>
	</div>
</div>
</body>
</html>