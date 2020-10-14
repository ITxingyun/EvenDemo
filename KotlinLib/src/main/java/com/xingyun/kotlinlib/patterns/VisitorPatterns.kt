package com.xingyun.kotlinlib.patterns

fun main() {
    val objectStructure = ObjectStructure()
    objectStructure.addBook(Chemistry("初中化学"))
    objectStructure.addBook(Physical("初中物理"))

    objectStructure.accept(ChemistryTeacher())
    objectStructure.accept(PhysicalTeacher())
}


interface People {
    fun visitor(chemistry: Chemistry)

    fun visitor(physical: Physical)
}

interface Book {
    fun accept(people: People)
}

class ObjectStructure {
    private val elements = mutableListOf<Book>()

    fun addBook(book: Book) {
        elements.add(book)
    }

    fun accept(people: People) {
        elements.forEach { it.accept(people) }
    }
}

class Chemistry(val bookName: String): Book {

    override fun accept(people: People) {
        people.visitor(this)
    }
}

class Physical(val bookName: String): Book {

    override fun accept(people: People) {
        people.visitor(this)
    }
}

class PhysicalTeacher: People {

    override fun visitor(chemistry: Chemistry) {
        println("物理老师教不了${chemistry.bookName}")
    }

    override fun visitor(physical: Physical) {
        println("物理老师可以教${physical.bookName}")
    }

}

class ChemistryTeacher: People {

    override fun visitor(chemistry: Chemistry) {
        println("化学老师可以教${chemistry.bookName}")
    }

    override fun visitor(physical: Physical) {
        println("化学老师教不了${physical.bookName}")
    }

}


