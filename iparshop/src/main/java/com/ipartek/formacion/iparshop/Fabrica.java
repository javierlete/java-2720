package com.ipartek.formacion.iparshop;

import com.ipartek.formacion.iparshop.negocio.UsuarioNegocio;
import com.ipartek.formacion.iparshop.negocio.UsuarioNegocioImpl;

public class Fabrica {
	public static UsuarioNegocio getUsuarioNegocio() {
		return new UsuarioNegocioImpl();
	}
}
