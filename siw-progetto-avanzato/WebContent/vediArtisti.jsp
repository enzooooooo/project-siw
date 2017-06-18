
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


</style>



<body>
<div class="title">
<h2>Welcome to Art Gallery</h2>
</div>
<div class="topnav">
  <a class="active" href="gestioneGalleria.jsp">Home</a>
  <a href="vediOpere.jsp">Vedi opere</a>
  <a href="controllerArtista?op=1">Inserisci nuova opera</a>
  <a href="controllerArtista?op=0">Vedi artisti</a>
  <a href="nuovoArtista.jsp">Inserisci nuovo artista </a>
</div>

<div style="padding-left:16px; text-align: center; margin-top: 5%; color: white;">
  <table>
  	<tr><th>nome</th><th>cognome</th><th>data di nascita</th><th>data di morte</th><th>nazionalita</th></tr>
  	<c:forEach var = "artista" items = "${artisti}" step = "1">
      <tr><td>${artista.nome}</td><td>${artista.cognome}</td><td>${artista.dataNascita}</td><td>${artista.dataMorte}</td><td>${artista.nazionalita}</td><td>
      <c:if test="${artista.opere.size() == 0}">
      <a href = "controllerArtista?id=${artista.id}">
     	 elimina
      	</a>
      	</c:if></td></tr>
	  </c:forEach>
  </table>
</div>

</body>
</html>