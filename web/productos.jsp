<%-- 
    Document   : productos
    Created on : 14-03-2020, 13:34:32
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Store</title>
        <link href="bootstrap-4.4.1-dist/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="templates/menu.jsp"></jsp:include>

        <div class="container margen">

            <form>
                <div class="form-row align-items-center">
                    <div class="col-sm-6">
                        <input type="text" class="form-control col-auto" name="nombre" placeholder="Ingrese el nombre del producto a buscar"/>
                    </div>

                    <div class="col-auto">
                        <select name="categoria" class="form-control">
                            <option disabled selected>Seleccione una categoria</option>
                        </select>
                    </div>
                    <div class="col-auto">
                        <button type="submit" class="btn btn-warning">Buscar</button>
                    </div>
                </div>
            </form>

            <table class="table margen">
                <thead class="thead-dark">
                    <tr>
                        <th>ID</th>
                        <th>Imagen</th>
                        <th>Producto</th>
                        <th>Precio</th>
                        <th>Categoria</th>
                        <th>Fecha Creación</th>
                        <th>Accion</th>
                    </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
    </body>
</html>
