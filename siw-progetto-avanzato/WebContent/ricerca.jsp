<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>



div.title{
    display: block;
    text-align: center;

}

h2{

	display: inline-block;
    margin-left: auto;
    margin-right: auto;
    text-align: left;
    color: white;
}


p {
	color: white;

}

body {
	
	margin:0;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
    background-color: #4CAF50;
    color: white;
}

body { 
	width: 100%;
	height:100%;
	font-family: 'Open Sans', sans-serif;
	background: #092756;
	background: -moz-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%),-moz-linear-gradient(top,  rgba(57,173,219,.25) 0%, rgba(42,60,87,.4) 100%), -moz-linear-gradient(-45deg,  #670d10 0%, #092756 100%);
	background: -webkit-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), -webkit-linear-gradient(top,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), -webkit-linear-gradient(-45deg,  #670d10 0%,#092756 100%);
	background: -o-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), -o-linear-gradient(top,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), -o-linear-gradient(-45deg,  #670d10 0%,#092756 100%);
	background: -ms-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), -ms-linear-gradient(top,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), -ms-linear-gradient(-45deg,  #670d10 0%,#092756 100%);
	background: -webkit-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), linear-gradient(to bottom,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), linear-gradient(135deg,  #670d10 0%,#092756 100%);
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#3E1D6D', endColorstr='#092756',GradientType=1 );
}

html { width: 100%; height:100%; overflow:scroll; }
	
	.button{
	border: solid medium forestgreen;
	background-color: #32CD32;
	background-image: -webkit-gradient(linear, left top, left bottom, from(#e9ede8), to(#32CD32),color-stop(0.4, #008800));
	color: white;
	
}

	input:focus { box-shadow: inset 0 -5px 45px rgba(100,100,100,0.4), 0 1px 1px rgba(255,255,255,0.2); }
	
table{
	color:white;
}


</style>
<body>
	<div class="title">
<h2>ricerca un opera</h2>
</div>

	
	<div class="topnav">
  <a href="indexUtente.jsp">Home</a>
  <a href="controllerArtista?op=2">Autori</a>
  <a href="controllerOpera?isUtente=true">Opere</a>
  <a class="active" href="ricerca.jsp">Ricerca</a>
  <a href="index.jsp">Logout</a>
</div>


	<div id = "section">
		<h2>Ricerca per nome</h2>
		<form action = "controllerOpera" method="post">
			<p>nome : <input type="text" name="nomeRicerca"></p>
			<input type="submit" class="button" value="cerca">
		</form>
		
	<c:if test = "${operePerNome.size() > 0}">
		<table>
  	<tr><th>titolo</th><th>anno</th><th>tecnica</th><th>dimensioni</th><th>autore</th></tr>
  	<c:forEach var = "opera" items = "${operePerNome}" step = "1">
      <tr><td>${opera.titolo}</td><td>${opera.anno}</td><td>${opera.tecnica}</td>
      <td>${opera.dimensioni}</td><td>${opera.autore.getNome()} ${opera.autore.getCognome()}</td></tr>
	  </c:forEach>
  </table>
		</c:if>
		<c:if test="${operePerNome.size() == 0}">
			<p>Nessun opera trovata</p>
		</c:if>
	</div>
	
	<div id = "section">
		<h2>Ricerca per anno</h2>
		<form action = "controllerOpera" method="post">
			<p>anno : 
			<input type="text" name="annoRicerca"> ${errAnno}</p>
			<input type="submit" class="button" value="cerca">
		</form>
	<c:if test = "${operePerAnno.size() > 0}">
		<table>
  	<tr><th>titolo</th><th>anno</th><th>tecnica</th><th>dimensioni</th><th>autore</th></tr>
  	<c:forEach var = "opera" items = "${operePerAnno}" step = "1">
      <tr><td>${opera.titolo}</td><td>${opera.anno}</td><td>${opera.tecnica}</td>
      <td>${opera.dimensioni}</td><td>${opera.autore.getNome()} ${opera.autore.getCognome()}</td></tr>
	  </c:forEach>
  </table>
		</c:if>
		<c:if test="${operePerAnno.size() == 0}">
			<p>Nessun opera trovata</p>
		</c:if>
	</div>

	

</body>
</html>