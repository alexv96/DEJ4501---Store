<%-- 
    Document   : crearProducto
    Created on : 14-03-2020, 13:34:24
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

            <main>
                <h1>Cree y Edite Productos</h1>

                <fotm>
                    <div class="form-group col-md-6">
                        <label for="id">ID</label>
                        <input type="text" name="id" id="id" class="form-control"/>
                    </div>

                    <div class="form-group col-md-6">
                        <label for="producto">Producto</label>
                        <input type="text" name="producto" id="producto" class="form-control"/>
                    </div>

                    <div class="form-group col-md-6">
                        <label for="categoria">Categoría:</label>
                        <select id="categoria" name="categoria" class="form-control">

                        </select>
                    </div>

                    <div class="form-group col-md-6">
                        <label for="precio">Precio</label>
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="basic-addon1">$</span>
                            </div>
                            <input type="tel" class="form-control" placeholder="Ingrese el precio del producto" aria-label="Username" aria-describedby="basic-addon1" id="precio" name="precio">
                            <small>Ejemplo:Ingresa el precio solo con números, no comas, puntos ni otro tipo de caracteres.</small>
                        </div>
                    </div>

                    <div class="form-group col-md-6">
                        <label for="url">Imagen</label>
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="basic-addon1">http://</span>
                            </div>
                            <input type="text" class="form-control" placeholder="Ingrese la URL de la imagen" aria-label="Username" aria-describedby="basic-addon1" id="url" name="url">
                        </div>
                        <small>Ejemplo: http://www.img.com/imagen1.jpg</small>
                    </div>

                    <div class="form-group col-md-6">
                        <input type="submit" name="accion" value="Guardar" id="accion" class="btn btn-primary boton"/>
                    </div>
                </fotm>
            </main>

        </div>
    </body>
</html>
