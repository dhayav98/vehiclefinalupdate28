<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
var req;
function update()
{
	var number=document.form1.vehicleno.value;
	var url="Updatedetails?vehicleno="+number;
	if(window.XMLHttpRequest) req=new XMLHttpRequest();
	else if(window.ActiveXObject) req=new ActiveXobject("Microsoft.XMLHTTP");
	try
	{
		req.onreadystatechange=function()
		{
			if(req.readystate==4)
				{
					var val=req.responseText;
					document.getElementByID("id1").innerHTML=val;
				}
		}
		req.open("GET",url,true);
		req.send();
	}
	catch(e)
	{
		alert("Unable to connect Server");
	}
}
</script>
</head>
<body>
<form name="form1">
<input type="text" name="vehicleno" >
<input type="button" onclick="update()" value="search">
</form>
<span id="id1"></span>
</body>
</html>