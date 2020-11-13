<%@page import="com.bean.LoginBean"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.dao.DAO"%>
<%@page import="com.bean.StudentBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%  StudentBean data=(StudentBean) request.getAttribute("data"); 

List<LoginBean> l= DAO.callProcedure(); 
    


%>

<h1>welcome <%= data.getSname() %></h1>
<table border="1">
    <tr>
       <th>Id</th>
       <th>Name</th>
       <th>Contact</th>
       
     </tr>
   
              <% for(LoginBean b: l)
              { %>
            
            <tr> <td><%=b.getId() %></td>
             <td><%=b.getName() %></td>
             <td><%=b.getContact() %></td>
            </tr>
        
              <%} %>
        
       
     
     
     
  

</table>


</body>
</html>