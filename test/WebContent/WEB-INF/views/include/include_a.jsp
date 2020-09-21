<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="공통디자인을 사용하는 페이지"
    %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"href="http://211.238.142.26/spring_mvc_template/common/css/main.css">
<title>Insert title here</title>
<style type="text/css">
#wrap{width: 900px;height: 930px;margin: 0px auto}
#header{width: 900px;height: 210px}
#headerTop{width: 900px;height: 140px;position: relative;
         background: #FFFFFF url("http://211.238.142.26/spring_mvc_template/common/images/header_bg.png")}
#mainText{font-family: 고딕,godic,Sans-serif;font-size: 35px;font-weight:bold; width:140px;height:50;
         margin: 0px auto;padding-top: 20px}
#naviBar{width: 900px;height: 60px; margin-top: 10px}
/* container */
#container{width:900px;height:600px;position:relative;}
/* footer */
#footer{width:900px;height:120}
#footerLogo{width:170px;height:60px;margin-left:10px; margin-top:10px}
#footerContnent{width:700px;height:100;margin-left:200px;margin-top: 10px;
            margin-right:20px;
            font-family: 고딕,godic;font-size: 14px;text-align: right;}
</style>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

<!-- Google CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

<script type="text/javascript">
   $(function(){
      
   });//ready
</script>
</head>
<body>
<div id="wrap">
   <div id="header">
      <div id="headerTop">
         <div id="mainText" title="클라쓰 A">Class A</div>
      </div>
      <div id="naviBar">
      <!--web content 안에 존재하는 do를 거치지 않는 jsp의 include  -->
         <c:import url="/common/jsp/menu.jsp"/>
         
      </div>
   </div>
   <div id="container">
   <!-- WEB-INF/views/에 존재하는 jsp 를 include 한 경우 -->
      <c:import url="/WEB-INF/views/include/include_b.jsp"/>
      
      <div>
      <c:import url="/use_include_c.do"/>
      
      </div>
      
   </div>
   <div id="footer">
      <div id="footerLogo"> </div>
      <div id="footerContnent">
         &copy;CopyRight. All Right Reserved. Class A
      </div>
   </div>
</div>
</body>
</html>