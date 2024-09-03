package com.ipartek.formacion.iparshop;

import com.ipartek.formacion.iparshop.accesodatos.DaoProducto;
import com.ipartek.formacion.iparshop.accesodatos.DaoProductoJpa;
import com.ipartek.formacion.iparshop.negocio.UsuarioNegocio;
import com.ipartek.formacion.iparshop.negocio.UsuarioNegocioImplJpa;

public class Fabrica {
	public static UsuarioNegocio getUsuarioNegocio() {
		return new UsuarioNegocioImplJpa();
	}
	
	public static DaoProducto getDaoProducto() {
		return new DaoProductoJpa();
	}
}
