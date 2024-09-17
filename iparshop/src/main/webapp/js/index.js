'use strict';

const URL = 'http://localhost:8080/iparshop/apiv2/productos/';

window.addEventListener('DOMContentLoaded', async () => {
	const form = document.querySelector('form');
	const ul = document.querySelector('ul');

	form.addEventListener('submit', async evento => {
		evento.preventDefault();

		const producto = { nombre: form.nombre.value, precio: +form.precio.value };

		console.log(producto);

		const respuesta = await fetch(URL, {
			method: 'POST',
			body: JSON.stringify(producto),
			headers: {
				'content-type': 'application/json'
			}
		});

		if (respuesta.ok) {
			const productoRecibido = await respuesta.json();

			console.log(productoRecibido);

			const li = document.createElement('li');
			li.innerText = productoRecibido.nombre;

			ul.appendChild(li);
		} else {
			alert('No se ha podido insertar el producto');
		}

	});

	const respuesta = await fetch(URL);
	const productos = await respuesta.json();

	console.log(productos);


	ul.innerHTML = '';

	productos.forEach(producto => {
		const li = document.createElement('li');
		li.innerText = producto.nombre;

		ul.appendChild(li);
	});
});