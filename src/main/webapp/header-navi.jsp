<%@ page pageEncoding="UTF-8"%>
<%@ page import="model.Cart"%>
<%@ page import="model.Store"%>

<%-- 店舗名・ユーザIDの表示 --%>
<%
Store storeHdr = (Store) session.getAttribute("store");
Cart cartHdr = (Cart) session.getAttribute("cart");
if ((storeHdr == null) || cartHdr == null) {
	request.setAttribute("errorMsg", "再ログインをお願いします。");
	request.getRequestDispatcher("login.jsp").forward(request, response);
} else {
%>

<style>
</style>


<h1><%=storeHdr.getName()%></h1>
<hr>

<%-- ナビ表示 --%>
<div id="container">
	<div id="nav">
		<ul class="menu">
			<li class="list"><a class="a" href="select.jsp">商品選択</a></li>
			<li class="list"><a class="a" href="cart.jsp">カート内一覧</a></li>
			<li class="list"><a class="a" href="logout-servlet">ログアウト</a></li>
		</ul>
	</div><%-- nav --%>
	<div class="nav_name">
		ようこそ、<%=cartHdr.getUserId()%>様
	</div>
</div><%-- container --%>
<hr>
<%
}
%>
