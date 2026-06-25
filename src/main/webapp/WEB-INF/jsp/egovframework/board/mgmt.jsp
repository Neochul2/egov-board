<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>등록/수정화면</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/board/css/bootstrap/css/bootstrap.min.css">
<script src="/board/js/jquery.min.js"></script>
<script src="/board/css/bootstrap/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">
    function cancel(){
        location.href = "<c:url value='/mainList.do'/>";
    }
    </script>
</head>
<body>
	<div class="container my-4">
		<h1>등록/수정화면</h1>
		<div class="card mb-4">
			<div class="card-header">
				<label>생각중:</label>
			</div>
			<div class="card-body">
				<form method="post" action="/">
					<div class="row mb-3">
						<label class="col-sm-2 col-form-label">게시물아이디:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="idx" name="idx"
								placeholder="자동발번">
						</div>
					</div>
					<div class="row mb-3">
						<label class="col-sm-2 col-form-label">제목:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="title" name="title"
								placeholder="제목을 입력하세요" maxlength="100">
						</div>
					</div>
					<div class="row mb-3">
						<label class="col-sm-2 col-form-label">등록자/등록일:</label>
						<div class="col-sm-5 mb-2">
							<input type="text" class="form-control" id="writer" name="writer"
								placeholder="등록자를 입력하세요" maxlength="15">
						</div>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="indate" name="indate"
								placeholder="등록일을 입력하세요" maxlength="10">
						</div>
					</div>
					<div class="row mb-3">
						<label class="col-sm-2 col-form-label">내용:</label>
						<div class="col-sm-10">
							<textarea class="form-control" rows="5" id="contents"
								name="contents" maxlength="1000"></textarea>
						</div>
					</div>
				</form>
			</div>
			<div class="card-footer text-end">
				<button type="button" class="btn btn-secondary">등록</button>
				<button type="button" class="btn btn-secondary">수정</button>
				<button type="button" class="btn btn-secondary" onclick="cancel();">취소</button>
			</div>
		</div>
	</div>
</body>
</html>