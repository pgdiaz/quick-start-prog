Algoritmo Multiplos
	Escribir 'Determinar los múltiplos mediante el ciclo para'
	suma <- 0
	Para i<-1 Hasta 100 Hacer
		Si i MOD 5==0 Entonces
			suma <- suma+i
			Escribir 'Múltiplo: ',i
		FinSi
	FinPara
	Escribir 'La suma de los múltiplos de 5 es ',suma
	Escribir 'Determinar los múltiplos mediante el ciclo repetir'
	suma <- 0
	num <- 1
	Repetir
		Si num MOD 5==0 Entonces
			suma <- suma+num
			Escribir 'Múltiplo: ',num
		FinSi
		num <- num+1
	Hasta Que num>100
	Escribir 'La suma de los múltiplos de 5 es ',suma
FinAlgoritmo
