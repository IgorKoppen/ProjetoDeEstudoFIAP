<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Novo Usuario</title>
</head>
<body>
    Novo Usuário:
    <br>
    <br>
    <form action="CriaUsuario" method="post">
        <label>Nome</label> <br> <input type=text name="nome"> <br>
        <label>Senha</label><br> <input type=password name="senha"> <br>
        <label>Email</label><br> <input type=text name="email"> <br>
        <label>Telefone</label><br> <input type=text name="telefone"> 
        <br><br> 
        <input type="submit" name="enviar" value="Enviar">
        <input type="reset" name= "limpar" value="Limpar">
    </form>
</body>
</html>