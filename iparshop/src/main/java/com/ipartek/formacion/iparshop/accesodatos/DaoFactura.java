package com.ipartek.formacion.iparshop.accesodatos;

import com.ipartek.formacion.iparshop.entidades.Factura;

public interface DaoFactura extends Dao<Factura> {

	String obtenerUltimoNumero();

}
