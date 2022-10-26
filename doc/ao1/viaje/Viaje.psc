Algoritmo Viaje
	Escribir 'Ingrese la cantidad de alumnos que viajarán: '
	Leer cantidadAlumnos
	costoPorAlumno <- 0
	costoTotal <- 0
	Si cantidadAlumnos < 30 Entonces
		costoTotal <- 4000.00
		costoPorAlumno <- costoTotal / cantidadAlumnos
	SiNo
		Si cantidadAlumnos < 50 Entonces
			costoPorAlumno <- 95.00
		SiNo
			Si cantidadAlumnos < 100 Entonces
				costoPorAlumno <- 70.00
			SiNo
				costoPorAlumno <- 65.00
			Fin Si
		Fin Si
		costoTotal <- cantidadAlumnos * costoPorAlumno
	Fin Si
	Escribir 'El costo total del viaje es $', costoTotal
	Escribir 'Cada alumno debe pagar $', costoPorAlumno
FinAlgoritmo
