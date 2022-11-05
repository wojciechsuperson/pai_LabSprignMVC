<%-- 
    Document   : editForm
    Created on : 10 lis 2020, 19:17:05
    Author     : Michał
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edytuj pracownika</h1>
         <div>
         <a href="../viewAll">Pokaż pracowników</a>
      
        <form:form method="post" action="editSave">
        <table >
        <tr>
        <td> </td>
        <td> <form:hidden path="id" /> </td>
        </tr>
        <tr>
        <td>Nazwisko : </td>
        <td> <form:input path="nazwisko" /> </td>
        </tr>
        <tr>
        <td>Pensja :</td>
        <td> <form:input path="pensja" /> </td>
        </tr>
        <tr>
        <td>Firma :</td>
        <td> <form:input path="firma" /> </td>
        </tr>
        <tr>
        <td> </td>
        <td> <input type="submit" value="Zapisz" /> </td>
        </tr>
        </table>
        </form:form>
        </div>
    </body>
</html>