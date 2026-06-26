<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>메인화면</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/board/css/bootstrap/css/bootstrap.min.css">
<script src="/board/js/jquery.min.js"></script>
<script src="/board/css/bootstrap/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    <c:if test="${!empty msg}">
        alert("${msg}");
    </c:if>
});
function add(){
    location.href = "<c:url value='/mgmt.do'/>";
}
function view(idx){
    location.href = "<c:url value='/view.do'/>?idx="+idx;
}
function out(){
    location.href = "<c:url value='/logout.do'/>";
}
</script>
</head>
<body>
	<div class="container my-4">
		<h1 class="mb-4">메인화면</h1>
		<div class="card mb-4">

			<div class="card-header">
				<c:if test="${empty sessionScope.userId}">
					<form class="row g-3 align-items-end" method="post"
						action="<c:url value='/login.do'/>">
						<div class="col-md-4">
							<label class="form-label">아이디</label> <input type="text"
								class="form-control" id="user_id" name="user_id">
						</div>
						<div class="col-md-4">
							<label class="form-label">Password</label> <input type="password"
								class="form-control" id="password" name="password">
						</div>
						<div class="col-md-4 d-flex align-items-end">
							<button type="submit" class="btn btn-primary">로그인</button>
						</div>
					</form>
				</c:if>
				<c:if test="${!empty sessionScope.userId}">
					<div class="d-flex justify-content-between align-items-center">
						<div>
							<b>${sessionScope.userName}</b>님 환영합니다!
						</div>
						<button type="button" class="btn btn-secondary" onclick="out();">로그아웃</button>
					</div>
				</c:if>
			</div>

			<div class="card-body">
				<form class="row g-3 mb-4" method="post"
					action="<c:url value='/mainList.do'/>">
					<div class="col-md-6">
						<label class="form-label">제목</label> <input type="text"
							class="form-control" id="searchKeyword" name="searchKeyword"
							value="${boardVO.searchKeyword}">
					</div>
					<div class="col-md-6 d-flex align-items-end">
						<button type="submit" class="btn btn-secondary">검색</button>
					</div>
				</form>
				<table class="table table-hover">
					<thead class="table-light">
						<tr>
							<th>게시물번호</th>
							<th>제목</th>
							<th>조회수</th>
							<th>댓글수</th> <!-- 댓글수 컬럼 추가 -->
							<th>등록자</th>
							<th>등록일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="result" items="${resultList}" varStatus="status">
							<tr>
								<td><a href="javascript:view('${result.idx}');">${result.idx}</a></td>
								<td><a href="javascript:view('${result.idx}');">${result.title}</a></td>
								<td>${result.count}</td>
								<td>${result['replyCnt']}</td>  <!-- 댓글수 출력 -->
								<td>${result.writer}</td>
								<td>${result.indate}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<div class="card-footer text-end">
				<c:if test="${!empty sessionScope.userId}">
					<button type="button" class="btn btn-outline-secondary"
						onclick="add();">등록</button>
				</c:if>
			</div>

		</div>
	</div>
</body>
</html>