/**
 * ==============================================
* Soluciones a los 30 retos de Kotlin - Sesión 3
 * ==============================================
*/

// 1. Control de Gastos Diarios
fun reto1() {
    val misGastos = doubleArrayOf(45.0, 12.5, 30.0, 50.0, 10.0, 5.0, 100.0, 25.0, 15.0, 40.0, 60.0, 5.0, 80.0, 20.0, 35.0)
    var acumulado = 0.0
    var elMasCaro = misGastos[0]
    var elMasBarato = misGastos[0]

    for (i in misGastos.indices) {
        val actual = misGastos[i]
        acumulado += actual
        if (actual > elMasCaro) elMasCaro = actual
        if (actual < elMasBarato) elMasBarato = actual
    }

    println(">>> Reto 1: Control de Gastos <<<")
    println("Resumen: [Total: $acumulado, Promedio: ${acumulado / misGastos.size}, Max: $elMasCaro, Min: $elMasBarato]")
}

// 2. Filtro de Empleados Senior
fun reto2() {
    val nomina = listOf("Ana" to 25, "Carlos" to 35, "Beatriz" to 42, "David" to 28, "Elena" to 31)
    val nombresSenior = mutableListOf<String>()

    for (empleado in nomina) {
        if (empleado.second > 30) {
            nombresSenior.add(empleado.first.uppercase())
        }
    }

    println("\n--- Reto 2: Filtro Senior ---")
    println("Personal con experiencia: $nombresSenior")
}

// 3. Limpieza de Contactos Duplicados
fun reto3() {
    val listaSucia = listOf("300123", "311456", "300123", "320789", "311456", "350111", "300123")
    val listaLimpia = listaSucia.distinct().sorted()

    println("\n--- Reto 3: Agenda Limpia ---")
    println("Contactos procesados: $listaLimpia")
}

// 4. Análisis de Carrito de Compras
fun reto4() {
    val bolsa = listOf("Leche", "Pan", "Leche", "Huevos", "Pan", "Leche", "Café")
    val contadorProductos = mutableMapOf<String, Int>()

    bolsa.forEach { p ->
        contadorProductos[p] = (contadorProductos[p] ?: 0) + 1
    }

    println("\n--- Reto 4: Carrito de Compras ---")
    println("Cantidades: $contadorProductos")
}

// 5. Historial de Navegación Reversible
fun reto5() {
    val paginas = arrayOf("google.com", "github.com", "kotlinlang.org", "stackoverflow.com", "medium.com")
    val paginasInvertidas = paginas.reversedArray()

    println("\n--- Reto 5: Historial Reversible ---")
    println("Viendo hacia atrás: ${paginasInvertidas.contentToString()}")
}

// 6. Compatibilidad de Intereses (Match)
fun reto6() {
    val hobbysA = setOf("Cine", "Música", "Viajes", "Lectura")
    val hobbysB = setOf("Música", "Deportes", "Viajes", "Cocina")

    val loQueTienenIgual = hobbysA.filter { it in hobbysB }
    val loQueFaltaEnB = hobbysA.filterNot { it in hobbysB }

    println("\n--- Reto 6: Match de Intereses ---")
    println("Ambos gustan de: $loQueTienenIgual")
    println("Solo Persona 1: $loQueFaltaEnB")
}

// 7. Inventario de Despensa
fun reto7() {
    val items = mutableMapOf("Arroz" to 5, "Frijol" to 2, "Leche" to 1)

    fun descontar(nombre: String, unidades: Int) {
        val actual = items[nombre] ?: 0
        if (actual > 0) {
            val resta = actual - unidades
            if (resta <= 0) {
                items.remove(nombre)
                println("INFO: $nombre se acabó del todo.")
            } else {
                items[nombre] = resta
            }
        }
    }

    println("\n--- Reto 7: Inventario Despensa ---")
    descontar("Leche", 1)
    descontar("Arroz", 2)
    println("Estado final bodega: $items")
}

// 8. Cálculo de Promedio Académico
fun reto8() {
    val registro = listOf(4.5 to 0.2, 3.8 to 0.3, 4.0 to 0.5)
    var calculo = 0.0
    registro.forEach { calculo += it.first * it.second }

    println("\n--- Reto 8: Promedio Académico ---")
    println("Nota obtenida: $calculo")
}

// 9. Traductor de Códigos de País
fun reto9() {
    val m = mapOf("CO" to "Colombia", "MX" to "México", "AR" to "Argentina", "ES" to "España")

    println("\n--- Reto 9: Traductor de Países ---")
    for (entry in m) {
        println("Sigla: ${entry.key} representa a ${entry.value}")
    }
}

// 10. Rotación de Turnos de Trabajo
fun reto10() {
    val personal = listOf("Emp1", "Emp2", "Emp3", "Emp4", "Emp5", "Emp6", "Emp7")
    val k = 2
    val nuevaPosicion = List(personal.size) { personal[(it + k) % personal.size] }

    println("\n--- Reto 10: Rotación de Turnos ---")
    println("Orden rotado: $nuevaPosicion")
}

// 11. Organizador de Maleta
fun reto11() {
    val cosas = listOf("Ropa" to 2, "Zapatos" to 1, "Laptop" to 2, "Libro" to 1, "Cámara" to 3)
    val mapaPesos = mutableMapOf<Int, MutableList<String>>()

    for ((nombre, peso) in cosas) {
        if (!mapaPesos.containsKey(peso)) {
            mapaPesos[peso] = mutableListOf()
        }
        mapaPesos[peso]?.add(nombre)
    }

    println("\n--- Reto 11: Organizador de Maleta ---")
    println("Grupos por kg: $mapaPesos")
}

// 12. Verificador de Ruta Reversible
fun reto12() {
    val camino = listOf(1 to 1, 2 to 2, 3 to 3, 2 to 2, 1 to 1)
    val esIgual = camino == camino.asReversed()

    println("\n--- Reto 12: Ruta Espejo ---")
    println("¿Es simétrico el camino?: $esIgual")
}

// 13. Reparto de Pedidos por Camión
fun reto13() {
    val ids = (1..50).map { "Paquete #$it" }
    val grupos = ids.chunked(10)

    println("\n--- Reto 13: Reparto de Pedidos ---")
    for (n in grupos.indices) {
        println("Vehículo ${n + 1} lleva ${grupos[n].size} items")
    }
}

// 14. Identificador de Ticket Único
fun reto14() {
    val tickets = listOf("ERR-01", "ERR-02", "ERR-01", "ERR-03", "ERR-02", "ERR-04")
    val elUnico = tickets.find { t -> tickets.count { it == t } == 1 }

    println("\n--- Reto 14: Ticket Único ---")
    println("Ticket solitario: $elUnico")
}

// 15. Calculadora de IVA Selectiva
fun reto15() {
    val precios = mapOf("Arroz" to 2000.0, "Carne" to 60000.0, "Vino" to 80000.0, "Sal" to 1500.0)
    val finalConIva = precios.mapValues { if (it.value > 50000) it.value * 1.19 else it.value }

    println("\n--- Reto 15: IVA Selectivo ---")
    println("Lista de cobro: $finalConIva")
}

// 16. Mantenimiento de Sensores
fun reto16() {
    val sensores = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    sensores.removeIf { it % 3 == 0 }

    println("\n--- Reto 16: Mantenimiento de Sensores ---")
    println("Quedan activos: $sensores")
}

// 17. Mapa de Almacén (Matriz)
fun reto17() {
    val datos = arrayOf(
        arrayOf(10, 5, 2, 8),
        arrayOf(4, 15, 6, 1),
        arrayOf(7, 3, 20, 9),
        arrayOf(12, 0, 4, 25)
    )
    var s1 = 0
    var s2 = 0
    for (i in datos.indices) {
        s1 += datos[i][i]
        s2 += datos[i][datos.size - 1 - i]
    }

    println("\n--- Reto 17: Matriz Almacén ---")
    println("Suma D1: $s1 | Suma D2: $s2")
}

// 18. Fusión de Recetas
fun reto18() {
    val r1 = mapOf("Sal" to 10.0, "Pimienta" to 5.0, "Harina" to 500.0)
    val r2 = mapOf("Sal" to 5.0, "Azúcar" to 100.0, "Harina" to 200.0)

    val totalIngredientes = mutableMapOf<String, Double>()
    (r1.keys + r2.keys).forEach { k ->
        totalIngredientes[k] = (r1[k] ?: 0.0) + (r2[k] ?: 0.0)
    }

    println("\n--- Reto 18: Fusión de Recetas ---")
    println("Mercado necesario: $totalIngredientes")
}

// 19. Ranking de Apps por Calificación
fun reto19() {
    val apps = mutableListOf("App A" to 4.5, "App B" to 3.8, "App C" to 4.9, "App D" to 4.2)
    apps.sortByDescending { it.second }

    println("\n--- Reto 19: Ranking de Apps ---")
    println("Top List: $apps")
}

// 20. Unión de Agendas Ordenadas
fun reto20() {
    val listA = listOf("Ana", "Carlos", "Elena")
    val listB = listOf("Beatriz", "David", "Fabio")
    val combinada = (listA + listB).sortedBy { it }

    println("\n--- Reto 20: Unión Agendas ---")
    println("Merge completo: $combinada")
}

// 21. Días de Mantenimiento (Primos)
fun reto21() {
    // Versión sin imports: verificando hasta la mitad (num / 2)
    fun esPrimoSinMath(num: Int): Boolean {
        if (num <= 1) return false
        for (i in 2..(num / 2)) {
            if (num % i == 0) return false
        }
        return true
    }

    val primos = (1..100).filter { esPrimoSinMath(it) }

    println("\n--- Reto 21: Pisos Primos ---")
    println("Días con labor: $primos")
}

// 22. Pila de Platos Sucios
fun reto22() {
    val platos = mutableListOf<String>()
    platos.add("Plato Base")
    platos.add("Plato Sopa")

    val fuera = if (platos.isNotEmpty()) platos.removeAt(platos.lastIndex) else null

    println("\n--- Reto 22: Pila de Platos ---")
    println("Se retiró para lavar: $fuera")
    println("En la pila queda: $platos")
}

// 23. Seguimiento de Dieta
fun reto23() {
    val historial = listOf(2000.0, 2200.0, 1800.0, 2100.0, 2500.0)
    val variaciones = mutableListOf<Double>()

    for (i in historial.indices) {
        val promedioAnterior = if (i == 0) 0.0 else historial.subList(0, i).average()
        variaciones.add(if (i == 0) 0.0 else historial[i] - promedioAnterior)
    }

    println("\n--- Reto 23: Seguimiento Dieta ---")
    println("Variaciones calculadas: $variaciones")
}

// 24. Organización de Contenedores
fun reto24() {
    val txt = "(()(())())"
    var p = 0
    var error = false
    for (c in txt) {
        if (c == '(') p++ else p--
        if (p < 0) error = true
    }
    if (p != 0) error = true

    println("\n--- Reto 24: Contenedores Balanceados ---")
    println("Analizando: $txt | ¿Es correcto?: ${!error}")
}

// 25. Rendimiento de Maratón
fun reto25() {
    val tiempos = mutableListOf(120.0, 115.0, 140.0, 110.0, 130.0)
    tiempos.sort()
    val filtrados = tiempos.slice(1 until tiempos.size - 1)

    println("\n--- Reto 25: Rendimiento Maratón ---")
    println("Media sin extremos: ${filtrados.average()}")
}

// 26. Compresión de Logs
fun reto26() {
    val logs = listOf("UP", "UP", "DOWN", "UP", "DOWN", "DOWN")
    val comprimido = mutableListOf<String>()

    if (logs.isNotEmpty()) {
        var cursor = logs[0]
        var cuenta = 0
        for (item in logs) {
            if (item == cursor) cuenta++
            else {
                comprimido.add("$cursor($cuenta)")
                cursor = item
                cuenta = 1
            }
        }
        comprimido.add("$cursor($cuenta)")
    }

    println("\n--- Reto 26: Compresión Logs ---")
    println("Resumen: $comprimido")
}

// 27. Premios a Vendedores
fun reto27() {
    val vendedores = mapOf("Juan" to 5000.0, "Ana" to 8000.0, "Luis" to 4000.0, "Marta" to 9000.0)
    val promedio = vendedores.values.average()
    val ganadores = vendedores.filter { it.value > promedio }.keys

    println("\n--- Reto 27: Premios Vendedores ---")
    println("Vendedores sobre el promedio: $ganadores")
}

// 28. Calculadora de Tarifas de Parking
fun reto28() {
    val h = 5
    val valorFinal = h * 2000.0

    println("\n--- Reto 28: Parking ---")
    println("Deuda por $h horas: $$valorFinal")
}

// 29. Parejas de Viaje por Peso
fun reto29() {
    val maletas = listOf(10, 15, 20, 5, 25)
    val meta = 30
    var res: String = "No hay pareja"

    for (i in maletas.indices) {
        for (j in i + 1 until maletas.size) {
            if (maletas[i] + maletas[j] == meta) {
                res = "Pareja: ${maletas[i]} y ${maletas[j]}"
                break
            }
        }
    }

    println("\n--- Reto 29: Parejas de Carga ---")
    println(res)
}

// 30. Espejo de Layout de Tienda
fun reto30() {
    val plano = arrayOf(
        arrayOf("A1", "A2"),
        arrayOf("B1", "B2"),
        arrayOf("C1", "C2")
    )
    val r = plano[0].size
    val c = plano.size
    val espejo = Array(r) { i -> Array(c) { j -> plano[j][i] } }

    println("\n--- Reto 30: Layout Transpuesto ---")
    espejo.forEach { fila -> println(fila.joinToString(" | ")) }
}