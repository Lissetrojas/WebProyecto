<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="java.util.LinkedList,uninorte.Persona,uninorte.Conexion" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenido al Proyecto Web</title>
</head>
<body>
<%  
 
 Conexion conexion =  new Conexion();
if (conexion.abrirConexion()){
	out.println(conexion.consultar("select * from users"));
	conexion.cerrarConexion();
}
out.println("<br>");

Persona persona1 = new Persona("Lisset","Rojas");
Persona persona2 = new Persona("Edward","Sabogal");
Persona persona3 = new Persona("Annie","Rodriguez");
LinkedList<Persona> listaAuxiliar = new LinkedList<Persona>();

listaAuxiliar.add(persona1);
listaAuxiliar.add(persona2);
listaAuxiliar.add(persona3); 

for(Persona p: listaAuxiliar){		  
  /*System.*/
  out.println(p.getNombreCompleto()+"<br>");
}
 %>

</body>
</html>