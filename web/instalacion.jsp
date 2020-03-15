<%-- 
    Document   : administracion
    Created on : 14-03-2020, 13:33:56
    Author     : Alex
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Store - Instalación</title>
        <link href="bootstrap-4.4.1-dist/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="templates/menu.jsp"></jsp:include>
            <div class="container margen">
                <main>
                <c:if test="${!empty mensajes}">
                    <jsp:include page="alertas/exito.jsp"></jsp:include>
                </c:if>
                <c:if test="${!empty error}">
                    <jsp:include page="alertas/error.jsp"></jsp:include>
                </c:if>

                <form method="GET" action="instalacion">
                    <div class="row">
                        <div class="col-md-4">
                            <div class="card">
                                <img src="img/install.png" class="card-img-top" alt="Instalación">
                                <div class="card-body">
                                    <h3>Instalación</h3>
                                    <p class="card-text">Crea las tablas y datos necesarios en la base de datos del programa.</p>
                                </div>
                                <div class="card-footer">
                                    <button type="submit" class="btn btn-success boton" name="btnAccion" value="instalar">Instalar</button>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-4">
                            <div class="card">
                                <img src="img/uninstall.png" class="card-img-top" alt="Desisntalación">
                                <div class="card-body">
                                    <h3>Desintalación</h3>
                                    <p class="card-text">Borra las tablas y datos en la base de datos del programa.</p>
                                </div>
                                <div class="card-footer">
                                    <button type="submit" class="btn btn-danger boton" name="btnAccion" value="desintalar">Desintalar</button>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-4">
                            <div class="card" >
                                <img src="img/carga.png" class="card-img-top" alt="Cargar Datos">
                                <div class="card-body">
                                    <h3>Cargar Datos</h3>
                                    <p class="card-text">Crea registros de pruebas en las tablas de la base de datos del programa.</p>
                                </div>
                                <div class="card-footer">
                                    <button type="submit" class="btn btn-primary boton" name="btnAccion" value="cargar">Cargar Datos</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </main>
        </div>
    </body>
</html>
