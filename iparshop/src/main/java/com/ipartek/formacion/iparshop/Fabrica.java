package com.ipartek.formacion.iparshop;

import com.ipartek.formacion.iparshop.accesodatos.DaoProducto;
import com.ipartek.formacion.iparshop.accesodatos.DaoProductoJpa;
import com.ipartek.formacion.iparshop.negocio.UsuarioNegocio;
import com.ipartek.formacion.iparshop.negocio.UsuarioNegocioImplJpa;

public class Fabrica {
	
	private static final UsuarioNegocio usuarioNegocio = new UsuarioNegocioImplJpa();
	private static final DaoProducto daoProducto = new DaoProductoJpa();
	
	public static UsuarioNegocio getUsuarioNegocio() {
		return usuarioNegocio;
	}
	
	public static DaoProducto getDaoProducto() {
		return daoProducto;
	}
}
