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
    document.form1.mode.value = "del";
    document.form1.submit();
}
</script>
</head>
<body>
	<div class="container my-4">
		<h1>상세화면</h1>
		<form name="form1" method="post" action="<c:url value='/mgmt.do'/>">
			<input type="hidden" name="mode" value=""> <input
				type="hidden" name="idx" value="${boardVO.idx}">
		</form>
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
						<div>${boardVO.writer}/${boardVO.indate}</div>
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
			<!-- 댓글 영역 -->
			<div class="card mb-4">
				<div class="card-header">댓글</div>
				<div class="card-body">
					<c:forEach var="reply" items="${replyList}" varStatus="status">
						<div
							class="d-flex justify-content-between align-items-center border-bottom py-2">
							<div>
								<b>${reply['writer']}</b> : ${reply['reply']} <small
									class="text-muted">(${reply['indate']})</small>
							</div>
							<c:if test="${!empty sessionScope.userId}">
								<form method="post" action="<c:url value='/deleteReply.do'/>">
									<input type="hidden" name="seq" value="${reply['seq']}">
									<input type="hidden" name="idx" value="${reply['idx']}">
									<button type="submit" class="btn btn-sm btn-danger">삭제</button>
								</form>
							</c:if>
						</div>
					</c:forEach>
				</div>
				<c:if test="${!empty sessionScope.userId}">
					<div class="card-footer">
						<form method="post" action="<c:url value='/insertReply.do'/>">
							<input type="hidden" name="idx" value="${boardVO['idx']}">
							<div class="input-group">
								<input type="text" class="form-control" name="reply"
									placeholder="댓글을 입력하세요">
								<button type="submit" class="btn btn-primary">등록</button>
							</div>
						</form>
					</div>
				</c:if>
			</div>

		</div>
	</div>
</body>
</html>