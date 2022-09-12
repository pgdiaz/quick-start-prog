Algoritmo Temperaturas
	Escribir '¿Cual es el total de temperaturas que desea registrar?'
	Leer totalTemperaturas
	mayorTemperatura <- 0
	Para i<-1 Hasta totalTemperaturas Hacer
		Escribir 'Ingrese una temperatura: '
		Leer temperatura
		Si temperatura>mayorTemperatura Entonces
			mayorTemperatura <- temperatura
		FinSi
	FinPara
	Escribir 'La mayor temperatura registrada es ',mayorTemperatura
FinAlgoritmo
