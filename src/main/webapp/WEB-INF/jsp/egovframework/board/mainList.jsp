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
	function add() {
		location.href = "<c:url value='/mgmt.do'/>";
	}
	function view() {
		location.href = "<c:url value='/view.do'/>";
	}
</script>
</head>
<body>
	<div class="container mt-5">
		<h1 class="mb-4">메인화면</h1>

		<div class="card mb-4">
			<div class="card-header">로그인</div>
			<div class="card-body">
				<form class="row g-3" action="/mainList.do">
					<div class="col-md-4">
						<label for="id" class="form-label">아이디</label> <input type="text"
							class="form-control" id="id" name="id">
					</div>
					<div class="col-md-4">
						<label for="pwd" class="form-label">Password</label> <input
							type="password" class="form-control" id="pwd" name="pwd">
					</div>
					<div class="col-md-4 d-flex align-items-end">
						<button type="submit" class="btn btn-primary">로그인</button>
					</div>
				</form>
			</div>
		</div>

		<div class="card mb-4">
			<div class="card-header">테이블 검색</div>
			<div class="card-body">
				<form class="row g-3" action="/search.do">
					<div class="col-md-6">
						<label for="searchName" class="form-label">제목</label> <input
							type="text" class="form-control" id="searchName"
							name="searchName">
					</div>
					<div class="col-md-6 d-flex align-items-end">
						<button type="submit" class="btn btn-secondary">검색</button>
					</div>
				</form>
			</div>
		</div>

		<div class="table-responsive">
			<table class="table table-hover">
				<thead class="table-light">
					<tr>
						<th>게시물번호</th>
						<th>제목</th>
						<th>조회수</th>
						<th>등록자</th>
						<th>등록일</th>
				</thead>
				<tbody>
					<tr>
						<td><a href="javascript:view();">1</a></td>
						<td><a href="javascript:view();">안녕하세요. 게시판공지 입니다</a></td>
						<td>1</td>
						<td>관리자</td>
						<td>2025-05-24</td>
					</tr>
				</tbody>
			</table>
		</div>

		<div class="card-footer text-end">
			<button type="button" class="btn btn-outline-secondary"
				onclick="add();">등록</button>
		</div>
	</div>
</body>
</html>