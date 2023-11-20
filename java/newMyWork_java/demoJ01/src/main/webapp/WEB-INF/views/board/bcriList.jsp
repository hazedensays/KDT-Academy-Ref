<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Board CriList SpringBoot **</title>

<script>
	//1. 검색조건 입력 후 버튼클릭
	// => 입력된 값들을 서버로 전송요청: location
	function searchDB() {
		self.location = 'bcriList' + '${pageMaker.makeQuery(1)}'
				+ '&searchType=' + document.getElementById('searchType').value
				+ '&keyword=' + document.getElementById('keyword').value;
	} //searchDB() 

	// => 검색조건 입력 후 첫 Page 요청
	//    이때는 서버에 searchType, keyword 가 전달되기 이전이므로 
	//     searchType, keyword 가 없는 makeQuery 메서드사용
	// => self.location="bcrilist?currPage=?????" : 해당 요청을 서버로 전달    

	// *** JS 코드 내부에서 el Tag 사용시 주의사항
	// => JS 코드의 스트링 내에서 사용한 el Tag 는 JSP 가 처리해주므로   
	//    사용가능 하지만, 이 스크립트가 외부 문서인 경우에는 처리해주지 않으므로 주의
	//    이 코드를 외부문서로 작성하면 "${pageMaker.makeQuery(1)}" 이 글자 그대로 적용되어 404 발생 

	// ** self.location   
	// 1) location 객체 직접사용 Test : url로 이동, 히스토리에 기록됨
	// 2) location 객체의 메서드
	// => href, replace('...'), reload() 

	// 2. searchType 을 '전체' 로 변경하면 keyword는 clear 
	function keywordClear() {
		if (document.getElementById('searchType').value == 'all')
			document.getElementById('keyword').value = '';
	}
</script>

</head>
<body>
	<h2>** Board CriList SpringBoot **</h2>
	<hr>

	<c:if test="${not empty requestScope.message}">${requestScope.message}</c:if>
	<hr>

	<div id="searchBar">
		<select name="searchType" id="searchType" onchange="keywordClear()">
			<option value="all" ${pageMaker.cri.searchType=='all' ? 'selected' : ''}>전체</option>
			<option value="title" ${pageMaker.cri.searchType=='title' ? 'selected' : ''}>Title</option>
			<option value="content" ${pageMaker.cri.searchType=='content' ? 'selected' : ''}>Content</option>
			<option value="id" ${pageMaker.cri.searchType=='id' ? 'selected' : ''}>ID(글쓴이)</option>
			<option value="regdate" ${pageMaker.cri.searchType=='regdate' ? 'selected' : ''}>RegDate</option>
			<option value="tc"
				${pageMaker.cri.searchType=='tc' ? 'selected' : ''}>Title
				or Content</option>
			<option value="tci"
				${pageMaker.cri.searchType=='tci' ? 'selected' : ''}>Title
				or Content or ID</option>
		</select> <input type="text" name="keyword" id="keyword"
			value="${pageMaker.cri.keyword}">
		<button id="searchBtn" onclick="searchDB()">Search</button>
	</div>
	<hr>

	<c:if test="${not empty sessionScope.loginID}">
		<a href="boardInsert" style="text-align: right">새글 등록</a>
	</c:if>

	<table border="1" style="width: 90%">
		<tr bgcolor="skyblue">
			<th>Seq</th>
			<th>Title</th>
			<th>Id</th>
			<th>Regdate</th>
			<th>조회수</th>
		</tr>


		<c:if test="${not empty requestScope.bList}">
			<c:forEach var="list" items="${requestScope.bList}">
				<tr>
					<td>${list.seq}</td>
					<!--    Title
					=> 로그인한 경우에만 글 내용을 볼 수 있도록 Link 추가
					=> 댓글 작성 후에는 indent값에 따른 들여쓰기 기능						-->
					<td><c:if test="${list.indent > 0 }">
							<c:forEach begin="1" end="${list.indent}">
								<span>&nbsp;&nbsp;</span>
							</c:forEach>
							<span style="color: blue">↳</span>
						</c:if> <c:if test="${not empty sessionScope.loginID}">
							<a href="bdetail?seq=${list.seq}">${list.title}</a>
						</c:if> <c:if test="${empty sessionScope.loginID}">
							${list.title}
						</c:if></td>

					<td>${list.id}</td>
					<td>${list.regdate}</td>
					<td>${list.cnt}</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty requestScope.bList}">
			<tr>
				<td colspan="5">출력할 데이터 없음</td>
			</tr>
		</c:if>
	</table>
	<hr>

	<!-- ** Cri_Paging ** 
     1) FirstPage, Prev  -->
     <c:choose>
		<c:when test="${pageMaker.prev && pageMaker.spageNo>1}">
			<%-- Ver01 : OLD_Version 
			<a href="bcriList?currPage=1&rowsPerPage=5">FP</a>&nbsp;
       		<a href="bcriList?currPage=${pageMaker.spageNo-1}&rowsPerPage=5">&lt;</a>&nbsp;&nbsp;
       		 --%>
       		 
       		<!-- Ver02 : Ver01 + 검색조건 -> searchQuery() 메서드 적용 -->
			<a href="bcriList${pageMaker.searchQuery(1)}">FP</a>&nbsp;
       		<a href="bcriList${pageMaker.searchQuery(pageMaker.spageNo-1)}">&lt;</a>&nbsp;&nbsp;
     	</c:when>

		<c:otherwise>
			<font color="Gray">FP&nbsp;&LT;&nbsp;&nbsp;</font>
     	</c:otherwise>
     </c:choose>
     

	<!-- 2) Display PageNo -->
	<c:forEach var="i" begin="${pageMaker.spageNo}" end="${pageMaker.epageNo}">
		<c:if test="${i==pageMaker.cri.currPage}">
			<font color="Orange" size="5"><b>${i}</b></font>&nbsp;
		</c:if>
		
		<c:if test="${i != pageMaker.cri.currPage}">
			<%-- <a href = "bcriList?currPage=${i}&rowsPerPage=5">${i}</a> 
			  => pageMaker의 makeQuery() 메서드 적용 : ver01
			<a href="bcriList${pageMaker.makeQuery(i)}">${i}</a>&nbsp;
			--%>
			
			<!-- ver 02 -->
			<a href="bcriList${pageMaker.searchQuery(i)}">${i}</a>&nbsp;
		</c:if>
	</c:forEach>

	<!-- 3) Next, LastPage
	     => ver01 : makeQuery() 메서드 사용
	     => ver02 : searchQuery() 메서드 사용  -->
	<c:choose>
		<c:when test="${pageMaker.next && pageMaker.epageNo > 0}">
			&nbsp;<a href="bcriList${pageMaker.searchQuery(pageMaker.epageNo + 1)}">&GT;</a>
			&nbsp;<a href="bcriList${pageMaker.searchQuery(pageMaker.lastPageNo)}">LP</a>
		</c:when>
		
		<c:otherwise>
			&nbsp;<font color="Gray">&nbsp;&GT;&nbsp;LP</font>
		</c:otherwise>
	</c:choose>

	<a href="/home">go home</a>
	<br>
</body>
</html>