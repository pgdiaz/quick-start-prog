Algoritmo Carrito
	PRIMER_DESCUENTO <- 0.1
	SEGUNDO_DESCUENTO <- 0.12
	TERCER_DESCUENTO <- 0.15
	costoTotal <- 0
	Escribir 'Ingrese 0 (cero) para finalizar'
	Repetir
		Escribir 'Ingrese el precio del articulo: '
		Leer precio
		Si precio > 0 Entonces
			descuento <- SEGUNDO_DESCUENTO
			Si precio >= 200 Entonces
				descuento <- TERCER_DESCUENTO
			FinSi
			Si precio <= 100 Entonces
				descuento <- PRIMER_DESCUENTO
			FinSi
			costo <- precio * (1 - descuento)
			Escribir 'El costo del articulo es: ', costo
			Escribir 'El descuento aplicado es: ', (precio * descuento), ' (%', (descuento * 100), ')'
			costoTotal <- costoTotal + costo
		FinSi
	Hasta Que precio == 0
	Escribir 'El costo total es: ', costoTotal
FinAlgoritmo
