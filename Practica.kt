class Event(
    val titulo: String,
    val descripcion: String? = null,
    val segDia: Daypart,
    val duracion: Int
)

// Enum que define las franjas horarias (mañana, tarde, noche)
enum class Daypart {
    MORNING,
    AFTERNOON,
    EVENING
}
val Event.durationOfEvent: String
    get() = if (this.duracion < 60) {
        "short"
    } else {
        "long"
    }

// Se crean las instancias de eventos
val event1 = Event(titulo = "Wake up", descripcion = "Time to get up", segDia = Daypart.MORNING, duracion = 0)
val event2 = Event(titulo = "Eat breakfast", segDia = Daypart.MORNING, duracion = 15)
val event3 = Event(titulo = "Learn about Kotlin", segDia = Daypart.AFTERNOON, duracion = 30)
val event4 = Event(titulo = "Practice Compose", segDia = Daypart.AFTERNOON, duracion = 60)
val event5 = Event(titulo = "Watch latest DevBytes video", segDia = Daypart.AFTERNOON, duracion = 10)
val event6 = Event(titulo = "Check out latest Android Jetpack library", segDia = Daypart.EVENING, duracion = 45)

// Lista que contiene todos los eventos
val events = mutableListOf(event1, event2, event3, event4, event5, event6)

fun main() {

// Filtrar eventos cortos (<60 minutos)
val shortEvents = events.filter { it.duracion < 60 }
println("You have ${shortEvents.size} short events.")

// Agrupar eventos por franja horaria
val groupedEvents = events.groupBy { it.segDia }
groupedEvents.forEach { (segDia, events) ->
    println("$segDia: ${events.size} events")
}
// Último evento del día
println("Last event of the day: ${events.last().titulo}")

// Ejemplo de uso de la propiedad de extensión
println("Duration of first event of the day: ${events[0].durationOfEvent}")

}
