<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Web_MVC2 Student Join **</title>
</head>
<body>
   <h2>** Web_MVC2 Student Join **</h2>
<form action="/Web01/join" method="post">
   <table border="1" style="width: 90%">
      <tr height="40">
         <th bgcolor="aquamarine">name</th>
         <td><input type="text" name="name" placeholder="한/영문 입력"
            size="20"></td>
      </tr>
      <tr height="40">
         <th bgcolor="aquamarine">age</th>
         <td><input type="text" name="age" placeholder="숫자 입력" size="20"></td>
      </tr>
      <tr height="40">
         <th bgcolor="aquamarine">jno</th>
         <td>
            <select name = "jno" size = "5">
               <option value = "1">1조 : 119조</option>
               <option value = "2">2조 : 여우조</option>
               <option value = "3">3조 : i4조</option>
               <option value = "4">4조 : 최고조</option>
               <option value = "5">5조 : 오조</option>
               <option value = "6">7조 : 관리자</option>               
            </select>
         </td>
      </tr>
      <tr height="40">
         <th bgcolor="aquamarine">info</th>
         <td><input type="text" name="info" placeholder="자기소개 & 희망사항" size="20"></td>
      </tr>
      <tr height="40">
         <th bgcolor="aquamarine">point</th>
         <td><input type="text" name="point" placeholder="실수 입력" size="20"></td>
      </tr>
      <tr height="40">
         <th bgcolor="aquamarine">birthday</th>
         <td><input type="date" name="birthday" size="20"></td>
      </tr>
	  <tr height="40">
         <td colspan="2" textalign="center"><input type="submit" value="가입">&nbsp;<input type="reset" value="취소"></td>
      </tr>

   </table>
</form>
<hr>
<c:if test="${not empty message}">
=> ${message}
</c:if>
<hr>
&nbsp;<a href="javascript:history.go(-1)">이전으로</a>
&nbsp;<a href="/Web01/index.jsp">Home</a>
</body>
</html>