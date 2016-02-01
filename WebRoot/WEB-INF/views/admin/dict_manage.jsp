<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.threebody.com/page" prefix="page" %>

<c:set var="path" value="<%=request.getContextPath() %>" scope="page"/>
<c:set var="basePath" scope="page">
	<%=request.getScheme()+"://"+request.getServerName()+":"
		+request.getServerPort()+request.getContextPath()+"/" %>
</c:set>
<div class="btn-header">
	<button id="btn" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="addDict()">添加字典</button>
</div>
<table class="bordered" >
	<tr>
		<th style="width:5%">序号</th>
		<th style="width:15%;">字典编码</th>
		<th style="width:15%;">字典名称</th>
		<th style="width:30%;">备注</th>
		<th style="width:10%;">操作</th>
	</tr>
	<% int i=0; %>
	<c:forEach var="dict" items="${dicts}" >
	<tr>
		<td><%=++i %></td>
		<td>${dict.dictCode}</td>
		<td>${dict.dictName}</td>
		<td>${dict.remark}</td>
		<td style="text-align:center;">
			
		</td>
	</tr>
	</c:forEach>
</table>
<div class="pageSplit">
	<page:htmlPage page="${page}" />
</div>
<script type="text/javascript" >
$(function(){
	//给分页按钮添加点击事件
	$("a.page").on("click",jumpPage);
	//给删除添加委托事件
// 	$("table.bordered").on("click","a.delUser",{url:"admin/userManage.html"},delRecord);
});
function addDict() {
	//打开新增用户页面
	alert("aaa");
// 	addTab("新增数据字典","${basePath}"+"page/addOrUpdateUser.html",null);
}
</script>