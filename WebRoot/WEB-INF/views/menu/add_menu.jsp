<%@ page language="java" pageEncoding="UTF-8"%>

<div style="padding:10px;">
	<form class="addMenuForm" method="post" action="menu/save.html" onSubmit="return ajaxSubmit(this)">
		<input type="hidden" name="id" value="${menu.id}" />
		<table class="zebra">
			<tr>
				<th>菜单名称</th>
				<td><input type="text" name="menuName" value="${menu.menuName}"/></td>
			</tr>
			<tr>
				<th>URL地址</th>
				<td><input type="text" name="url" value="${menu.url}" /></td>
			</tr>
			<tr>
				<th>图标</th>
				<td>
					<input type="text" name="icon" value="${menu.icon}" readonly="readonly"/>
					<span class="fa fa-${menu.icon}"></span>
					<%@ include file="icon_list.jsp" %>
				</td>
			</tr>
			<tr>
				<th>备注</th>
				<td><textarea name="remark">${menu.remark}</textarea></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="保存" /></td>
			</tr>
		</table>
	</form>
</div>
<script type="text/javascript">
$(function(){
	$(".addMenuForm .iconList").css("display","none");
	$(".addMenuForm input[name=icon]").on("focus blur",function(e){
		$(".addMenuForm .iconList").slideToggle("normal");
	});
});
</script>