<html>
<body>

<h1>${city}</h1>

<table style="width:100%">
  <tr>
    <th>time</th>
    <th>weather</th> 
    <th>min</th>
    <th>max</th>
 </tr>
 
 <#list message as i>
     <tr>
	   <td>${i.time}</td>
	   <td>${i.weather}</td>
	   <td>${i.min}</td>
	   <td>${i.max}</td>
	 </tr>
 </#list>

</body>
</html>