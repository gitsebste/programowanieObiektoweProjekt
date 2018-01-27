<%-- 
    Document   : home
    Created on : 2013-03-03, 14:57:19
    Author     : Adrian Lapierre <alapierre@softproject.com.pl>
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>        
        
        <br/>

        <form:form commandName="person" action="item/add.htm" method="POST">                                       
            <form:button>Add item</form:button>                            
        </form:form>
            <form:form commandName="person" action="person/add.htm" method="POST">                                       
            <form:button>Add person</form:button>                            
        </form:form>
            <form:form commandName="person" action="/item/getByUnitShortName.htm" method="POST">                                       
            Get items by unitShortName <form:input path="name"/><form:button>Show items of that unit</form:button>                            
        </form:form>
            
              <form:form commandName="person" action="/item/update/byCode.htm" method="POST">                                       
            Update item by code <form:input path="name"/><form:button>Update this item</form:button>                            
        </form:form>
            
            <form:form commandName="person" action="/item/get/byCode.htm" method="POST">                                       
            Get item by code <form:input path="name"/><form:button>Get this item</form:button>                            
        </form:form>
 
                        <form:form commandName="person" action="/item/get/all.htm" method="POST">                                       
            Get all items <form:button>Get all items</form:button>                            
        </form:form>
    </body>
</html>
