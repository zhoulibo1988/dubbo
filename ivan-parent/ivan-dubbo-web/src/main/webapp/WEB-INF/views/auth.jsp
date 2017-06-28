<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>微信支付成功页面</title>
</head>
<body>
   <%-- 你已经支付成功，订单号为:${orderId }. --%>
   <%-- <input type="button"><a href="${authorizationUrl}" type="">授权开始</a></input> --%>
   <a data-role="button" href="javascript:doWeixinPay()" data-theme="e">提交</a>
   <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
  	<script type="text/javascript">
  		function doWeixinPay(){
  			window.location.href="${authorizationUrl}";
  		}
  	</script>	
</body>
</html>