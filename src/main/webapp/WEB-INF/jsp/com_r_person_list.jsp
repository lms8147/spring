<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.1.min.js"></script>
<script type="text/javascript">
	//<![CDATA[

	function check_all() {
		var checkedLength = $("input:checkbox[name=itemCHK]:checked").length;
		var isCheck = false;
		if (checkedLength == 0) {
			isCheck = true;
		}
		$("input:checkbox[name=itemCHK]").each(function() {
			this.checked = isCheck;
		});
		$("input[name=itemAllCHK]:checkbox").prop("checked", false);
	};

	function logging_selected() {

		var checkedLength = $("input:checkbox[name=itemCHK]:checked").length;
		console.log(checkedLength);

		$("input[name=itemCHK]:checked").each(function() {

			var checkedValue = $(this).val();

			console.log(checkedValue);

		});
	};

	function check_each(attrID) {
		$("input[name=itemCHK]").attr("checked", false);
		var item = "input[name=itemCHK][value=" + attrID + "]";
		var isChecked = $(item).is(":checked");
		//toggle
		$(item).attr("checked", !isChecked);
	};

	//]]>
</script>
</head>
<body>
	<form>
		<li><input type="checkbox" name="itemAllCHK" onclick="javascript:check_all();" /><label>전체
				체크 checkbox</label></li>
		<div></div>
		<li><input type="checkbox" name="itemCHK" value="A" /><label
			onclick="javascript:check_each('A');">1번째 checkbox</label></li>
		<li><input type="checkbox" name="itemCHK" value="B" /><label
			onclick="javascript:check_each('B');">2번째 checkbox</label></li>
		<li><input type="checkbox" name="itemCHK" value="C" /><label
			onclick="javascript:check_each('C');">3번째 checkbox</label></li>
		<li><input type="checkbox" name="itemCHK" value="D" /><label
			onclick="javascript:check_each('D');">4번째 checkbox</label></li>
	</form>
	<button id="logging_selected_btn" onclick="javascript:logging_selected();">Button</button>
</body>
</html>