
<form action="registro" method="post">
	<input type="hidden" name="id" value="${cliente.id}">
	<div class="row mb-3">
		<label for="email" class="col-sm-2 col-form-label">Email</label>
		<div class="col-sm-10">
			<input type="email" name="email" value="${cliente.email}"
				class="form-control ${errores.email != null ? 'is-invalid' : '' }"
				id="email">
			<div class="invalid-feedback">Debes rellenar el email y debe
				tener @</div>
		</div>
	</div>
	<div class="row mb-3">
		<label for="password" class="col-sm-2 col-form-label">Contraseña</label>
		<div class="col-sm-10">
			<input type="password" name="password" value=""
				class="form-control ${errores.password != null ? 'is-invalid' : '' }"
				id="password">
			<div class="invalid-feedback">Es obligatorio rellenar la
				contraseña y debe tener al menos un dígito, una letra minúscula, una
				letra mayúscula, un símbolo y debe ser de al menos 8 caracteres</div>
		</div>
	</div>

	<div class="row mb-3">
		<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
		<div class="col-sm-10">
			<input type="text" name="nombre" value="${cliente.nombre}"
				class="form-control ${errores.nombre != null ? 'is-invalid' : '' }"
				id="nombre">
			<div class="invalid-feedback">El nombre es obligatorio</div>

		</div>
	</div>

	<div class="row mb-3">
		<label for="direccion" class="col-sm-2 col-form-label">Dirección</label>
		<div class="col-sm-10">
			<input type="text" name="direccion" value="${cliente.direccion}"
				class="form-control ${errores.direccion != null ? 'is-invalid' : '' }"
				id="direccion">
			<div class="invalid-feedback">La dirección es obligatorio
				rellenarla</div>

		</div>
	</div>

	<div class="row mb-3">
		<label for="codigo-postal" class="col-sm-2 col-form-label">Código
			Postal</label>
		<div class="col-sm-10">
			<input type="text" name="codigo-postal"
				value="${cliente.codigoPostal}"
				class="form-control ${errores.codigoPostal != null ? 'is-invalid' : '' }"
				id="codigo-postal">
			<div class="invalid-feedback">Debes rellenar el código postal y
				deben ser 5 dígitos</div>

		</div>
	</div>

	<div class="row mb-3">
		<label for="ciudad" class="col-sm-2 col-form-label">Ciudad</label>
		<div class="col-sm-10">
			<input type="text" name="ciudad" value="${cliente.ciudad}"
				class="form-control ${errores.ciudad != null ? 'is-invalid' : '' }"
				id="ciudad">
			<div class="invalid-feedback">Debes rellenar la ciudad</div>

		</div>
	</div>

	<div class="row mb-3">
		<label for="nif" class="col-sm-2 col-form-label">NIF</label>
		<div class="col-sm-10">
			<input type="text" name="nif" value="${cliente.nif}"
				class="form-control ${errores.nif != null ? 'is-invalid' : '' }"
				id="nif">
			<div class="invalid-feedback">Debes rellenar el NIF con el
				formato 12345678A ó X1234567B</div>

		</div>
	</div>


	<button type="submit" class="btn btn-primary">Guardar</button>
	<div class="text-danger">${errores}</div>
</form>
