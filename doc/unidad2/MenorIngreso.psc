Algoritmo MenorIngreso
	Escribir 'Ingrese un número entero: '
	Leer num1
	Escribir 'Ingrese un número entero: '
	Leer num2
	Si num1=num2 Entonces
		Escribir 'Los números ingresados deben ser distintos.'
	SiNo
		Si num1 < num2 Entonces
			Escribir 'El menor valor es ', num1
		SiNo
			Escribir 'El menor valor es ', num2
		FinSi
	FinSi
FinAlgoritmo
