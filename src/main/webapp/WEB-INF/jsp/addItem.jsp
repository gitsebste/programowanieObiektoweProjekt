<%-- 
    Document   : add
    Created on : 2018-01-15, 16:05:32
    Author     : device02
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add/Update</title>
    </head>
    <body>
        <h1>Add/Update</h1>
        
        <form:form commandName="item" action="save.htm" method="POST">            
            
            name        <form:input path="name"/>       <form:errors path="name"/>  <br/>
            code   <form:input path="code"/>   <form:errors path="code"/>  <br/>            
            description   <form:input path="description"/>   <form:errors path="description"/>  <br/>   
            unitShortName <form:input path="unitShortName"/> <br/>
            personEmail <form:input path="personEmail"/>   <form:errors path="personEmail"/>  <br/>   
            locationName <form:input path="locationName"/> <br/>
            <form:button>Zapisz</form:button>
                
            
        </form:form>
        
    </body>
</html>
