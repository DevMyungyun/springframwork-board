<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
				<h3>���뺸��</h3>
			</center>
			<table class="table table-hover" width="600">
				<tr>
					<td width="20%" class="text-center success">��ȣ</td>
					<td width="30%" class="text-center ">${vo.no }</td>
					<td width="20%" class="text-center ">�ۼ���</td>
					<td width="40%" class="text-center ">
						<fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd"/>
					</td>
				</tr>
				<tr>
					<td width="20%" class="text-center success">�̸�</td>
					<td width="30%" class="text-center ">${vo.name }</td>
					<td width="20%" class="text-center ">��ȸ��</td>
					<td width="30%" class="text-center ">${vo.hit }</td>
				</tr>
				<tr>
					<td width="20%" class="text-center success">����</td>
					<td colspan="3" class="text-left ">${vo.subject }</td>
				</tr>
				<tr>
					<td colspan="4" height="150" class="text-left" valign="top">${vo.content }</td>
				</tr>
				<tr>
					<td colspan="4" class="text-right">
						<a href="update.do?no=${vo.no }" class="btn btn-sm btn-success">����</a>
						<a href="delete.do?no=${vo.no }" class="btn btn-sm btn-primary">����</a>
						<a href="list.do" class="btn btn-sm btn-info">���</a>
					</td>
				</tr>
			</table>
			<table class="table" width="600">
				<tr>
					<td class="text-center">
						<img scr="r.png">
					</td>
				</tr>
			</table>
		</div>
	</div>
	

</body>
</html>