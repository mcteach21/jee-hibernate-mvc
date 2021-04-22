
<div class="row">
	<div class="col-sm-6 infos" style="background-color: lavender;">
		Web Application Context Path = ${pageContext.request.contextPath}<br />
		Request Context Path:
		<%=request.getContextPath()%><br /> Request URI:
		<%=request.getRequestURI()%><br /> Request URL:
		<%=request.getRequestURL()%><br />
	</div>
	<div class="col-sm-4 infos" style="background-color: lavenderblush;">
		Page : ${page}<br /> Error : ${error}<br />
	</div>
</div>