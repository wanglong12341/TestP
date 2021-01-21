<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
      <c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <meta http-equiv="X-UA-Compatible" content="ie=edge">
      <title>信e佳平台运营系统</title>
      <script src="${ctx}/statics/vendor/jquery-1.12.4/jquery.min.js"></script>
      <link rel="icon" href="${ctx}/statics/images/favicon.ico">
      <style>
        .notFound {
          width: 900px;
        }
        .notFound img {
          margin-top: 80px;
        }
        .notFound span {
          display: inline-block;
          width: 250px;
          margin-top: 200px;
        }
        .notFound span p {
          margin-top: 0;
          margin-bottom: 20px;
        }
        .notFound span input {
          width: 88px;
          height: 32px;
          font-size: 12px;
          font-weight: bold;
        }
      </style>
  </head>
  <body>
    <div class="notFound text-center">
      <img src="${ctx}/statics/images/404.png" alt="">
      <span class="pull-right">
          <p style="font-size: 50px; font-weight: bold; color: #434e59">404</p>
          <p style="font-size: 30px; font-weight: bold; color: #434e59">Not Found</p>
          <p style="font-size: 20px;color: #878889">抱歉您访问的页面不存在</p>
          <p><input type="button" class="btn btn-primary" value="返回首页"></p>
        </span>
    </div>
  </body>
  <script type="text/javascript">
      $("input[type='button']").click(function(){
          window.location.href = "${ctx}/index.do";
      });
  </script>
</html>
