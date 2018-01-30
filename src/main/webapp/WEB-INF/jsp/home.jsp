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
        <h1>Create Read Update Delete</h1>        
        
        <br/>

        <form:form commandName="person" action="item/add.htm" method="POST">                                       
            <form:button>Add item</form:button>                            
        </form:form>
            <form:form commandName="person" action="person/add.htm" method="POST">                                       
            <form:button>Add person</form:button>                            
        </form:form>
            <form:form commandName="person" action="location/add.htm" method="POST">                                       
            <form:button>Add location</form:button>                            
        </form:form>
            <form:form commandName="person" action="unit/add.htm" method="POST">                                       
            <form:button>Add unit</form:button>                            
        </form:form>
            <form:form commandName="person" action="/item/getByUnitShortName.htm" method="POST">                                       
            Get items by unitShortName <form:input path="name"/><form:button>Show items of that unit</form:button>                            
        </form:form>
            

            
            <form:form commandName="person" action="/item/get/byCode.htm" method="POST">                                       
            Get item by code <form:input path="name"/><form:button>Get this item</form:button>                            
        </form:form>
 
        <form:form commandName="person" action="/item/get/all.htm" method="POST">                                       
            Get all items <form:button>Get all items</form:button>                            
        </form:form>
            
            <form:form commandName="person" action="/unit/get/all.htm" method="POST">                                       
            Get all units <form:button>Get all units</form:button>                            
        </form:form>
            
            <form:form commandName="person" action="/location/get/all.htm" method="POST">                                       
            Get all locations <form:button>Get all locations</form:button>                            
        </form:form>
            
            <form:form commandName="person" action="/person/getByUnitShortName.htm" method="POST">                                       
            Get person by unitShortName <form:input path="name"/><form:button>Get person by unitShortName</form:button>                            
        </form:form>
            
            <form:form commandName="person" action="/item/update/byCode.htm" method="POST">                                       
            Update item by code <form:input path="name"/><form:button>Update this item</form:button>                            
        </form:form>
            
            <form:form commandName="person" action="/location/update/byName.htm" method="POST">                                       
            Update location by name <form:input path="name"/><form:button>Update this location</form:button>                            
        </form:form>
            <form:form commandName="person" action="/person/update/byEmail.htm" method="POST">                                       
            Update person by email <form:input path="name"/><form:button>Update this person</form:button>                            
        </form:form>

            <form:form commandName="person" action="/unit/update/byShortName.htm" method="POST">                                       
            Update unit by shortName <form:input path="name"/><form:button>Update this unit</form:button>                            
        </form:form>
            
            <form:form commandName="person" action="/item/deleteByCode.htm" method="POST">                                       
            Delete item by code <form:input path="name"/><form:button>Delete this by code</form:button>                            
        </form:form>
            
            <form:form commandName="person" action="/location/deleteByName.htm" method="POST">                                       
            Delete location by name <form:input path="name"/><form:button>Delete this by name</form:button>                            
        </form:form>
            
             <form:form commandName="person" action="/person/deleteByEmail.htm" method="POST">                                       
            Delete person by email <form:input path="name"/><form:button>Delete this by email</form:button>                            
        </form:form>
            <form:form commandName="person" action="/unit/deleteByShortName.htm" method="POST">                                       
            Delete unit by shortName <form:input path="name"/><form:button>Delete this by shortName</form:button>                            
        </form:form>
            
    </body>
</html>
