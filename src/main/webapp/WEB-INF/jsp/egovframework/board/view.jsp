<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>상세화면</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/board/css/bootstrap/css/bootstrap.min.css">
<script src="/board/js/jquery.min.js"></script>
<script src="/board/css/bootstrap/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">
    function list(){
        location.href = "<c:url value='/mainList.do'/>";
    }
    function modify(){
        location.href = "<c:url value='/mgmt.do'/>?idx=${boardVO.idx}";
    }
    function del(){
        if(!confirm("삭제하시겠습니까?")){ return; }
        location.href = "<c:url value='/mgmt.do'/>?idx=${boardVO.idx}&mode=del";
    }
    </script>
</head>
<body>
	<div class="container my-4">
		<h1>상세화면</h1>
		<div class="card mb-4">
			<div class="card-header">
				<label>${sessionScope.userName} 님이 로그인 하셨습니다.</label>
			</div>
			<div class="card-body">
				<div class="row mb-3">
					<label class="col-sm-2 col-form-label">게시물아이디:</label>
					<div class="col-sm-10 d-flex align-items-center">
						<div>${boardVO.idx}</div>
					</div>
				</div>
				<div class="row mb-3">
					<label class="col-sm-2 col-form-label">제목:</label>
					<div class="col-sm-10 d-flex align-items-center">
						<div>${boardVO.title}</div>
					</div>
				</div>
				<div class="row mb-3">
					<label class="col-sm-2 col-form-label">등록자/등록일:</label>
					<div class="col-sm-10 d-flex align-items-center">
						<div>${boardVO.writer}/ ${boardVO.indate}</div>
					</div>
				</div>
				<div class="row mb-3">
					<label class="col-sm-2 col-form-label">내용:</label>
					<div class="col-sm-10 d-flex align-items-center">
						<div>${boardVO.contents}</div>
					</div>
				</div>
			</div>
			<div class="card-footer text-end">
				<c:if test="${!empty sessionScope.userId}">
					<button type="button" class="btn btn-secondary" onclick="modify();">수정</button>
					<button type="button" class="btn btn-danger" onclick="del();">삭제</button>
				</c:if>
				<button type="button" class="btn btn-outline-secondary"
					onclick="list();">목록</button>
			</div>
		</div>
	</div>
</body>
</html>