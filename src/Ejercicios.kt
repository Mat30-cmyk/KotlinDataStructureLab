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