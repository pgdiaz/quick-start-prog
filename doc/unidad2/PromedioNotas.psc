Algoritmo PromedioNotas
	Escribir 'Registro de notas de un alumno. Rango de [0, 100]'
	promedio <- 0
	Para indice<-1 Hasta 3 Hacer
		Escribir 'Ingrese la nota: '
		Leer nota
		promedio <- promedio+nota
	FinPara
	Escribir 'El promedio del alumno es ',promedio/3
FinAlgoritmo
