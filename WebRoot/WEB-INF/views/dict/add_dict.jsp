<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head></head>
<body>
<div style="padding:10px;">
	<form class="addDictForm" method="post" action="dict/save.html" onSubmit="return $css.ajaxSubmit(this)">
		<input type="hidden" name="id" value="${dict.id}" />
		字典编码<input type="text" name="dictCode" value="${dict.dictCode}" />
		<br/>
		字典名称<input type="text" name="dictName" value="${dict.dictName}" />
		<br/>
		备注<textarea name="remark" >${dict.remark}</textarea>
		<br/>
		<input type="submit" value="保存" />
	</form>
</div>
</body>
</html>