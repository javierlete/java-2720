package com.ipartek.formacion.iparshop.presentacion.listeners;

import com.ipartek.formacion.iparshop.modelos.Carrito;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SesionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent se)  { 
    	se.getSession().setAttribute("carrito", new Carrito());
    }
}
