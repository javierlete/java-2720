package com.ipartek.formacion.iparshop.restjersey;

import com.ipartek.formacion.iparshop.Fabrica;
import com.ipartek.formacion.iparshop.entidades.Producto;

import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/productos")
public class ProductosRest {
	@GET
	public Iterable<Producto> get() {
		return Fabrica.getUsuarioNegocio().listarProductos();
	}
	
	@GET
	@Path("/{id}")
	public Producto getId(@PathParam("id") Long id) {
		var producto = Fabrica.getUsuarioNegocio().detalleProducto(id);
		
		if(producto == null) {
			throw new NotFoundException();
		}
		
		return producto;
	}
	
	@POST
	public Response post(Producto producto) {
		Fabrica.getAdminNegocio().agregarProducto(producto);
		
		return Response.status(Status.CREATED).entity(producto).build();
	}
	
	@PUT
	@Path("/{id}")
	public Producto put(Producto producto, @PathParam("id") Long id) {
		if(id != producto.getId()) {
			throw new BadRequestException();
		}
		
		Fabrica.getAdminNegocio().modificarProducto(producto);
		
		return producto;
	}
	
	@DELETE
	@Path("{id}")
	public void delete(@PathParam("id") Long id) {
		Fabrica.getAdminNegocio().borrarProducto(id);
	}
}
