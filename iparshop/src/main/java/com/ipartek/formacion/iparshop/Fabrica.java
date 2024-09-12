package com.ipartek.formacion.iparshop;

import com.ipartek.formacion.iparshop.accesodatos.DaoCliente;
import com.ipartek.formacion.iparshop.accesodatos.DaoClienteJpa;
import com.ipartek.formacion.iparshop.accesodatos.DaoFactura;
import com.ipartek.formacion.iparshop.accesodatos.DaoFacturaJpa;
import com.ipartek.formacion.iparshop.accesodatos.DaoProducto;
import com.ipartek.formacion.iparshop.accesodatos.DaoProductoJpa;
import com.ipartek.formacion.iparshop.negocio.AdminNegocio;
import com.ipartek.formacion.iparshop.negocio.AdminNegocioImplJpa;
import com.ipartek.formacion.iparshop.negocio.UsuarioNegocio;
import com.ipartek.formacion.iparshop.negocio.UsuarioNegocioImplJpa;

public class Fabrica {
	
	private static final UsuarioNegocio usuarioNegocio = new UsuarioNegocioImplJpa();
	private static final AdminNegocio adminNegocio = new AdminNegocioImplJpa();
	private static final DaoProducto daoProducto = new DaoProductoJpa();
	private static final DaoFactura daoFactura = new DaoFacturaJpa();
	private static final DaoCliente daoCliente = new DaoClienteJpa();
	
	public static UsuarioNegocio getUsuarioNegocio() {
		return usuarioNegocio;
	}
	
	public static DaoProducto getDaoProducto() {
		return daoProducto;
	}

	public static AdminNegocio getAdminNegocio() {
		return adminNegocio;
	}

	public static DaoFactura getDaoFactura() {
		return daoFactura ;
	}

	public static DaoCliente getDaoCliente() {
		return daoCliente ;
	}
}
