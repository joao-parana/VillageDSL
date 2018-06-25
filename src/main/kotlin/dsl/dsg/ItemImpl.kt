package dsl.dsg

import dsl.dsg.model.Item

fun summary(itens : List<Item>):String {

    val sb = StringBuilder()
    for (il in itens) {
        sb.append("\"${il.name}\" ")
    }
    return sb.toString()
}
object item

@DSLBuilder("dsl.dsg.model.Item")
class ItemListBuilder {
    private var currentItem: Item? = null
    private var itens = mutableListOf<Item>()

    fun build(): List<Item> = itens

    infix fun item.name(n: String): item {
        dslSingleton.previusItem = currentItem
        currentItem = Item(n)
        itens = itens.plus(currentItem!!).toMutableList()
        return item
    }

    infix fun item.title(t: String): item {
        currentItem!!.title = t
        return item
    }

    infix fun item.desc(t: String): item {
        currentItem!!.desc = t
        return item
    }

    infix fun item.term(t: String): item {
        currentItem!!.term = t
        return item
    }

    // Usado quando itens aparecem como um filho de item (refer6encia recursiva)
    infix fun item.contains(actions: ItemListBuilder.() -> Unit): List<Item> {
        val parentItem = currentItem
        println("Inicio da Lista de Itens relacionada ao método contains. A pilha contém ${dslSingleton.stackOfItens.size} elementos")
        dslSingleton.stackOfItens.push(itens)
        val builder = ItemListBuilder()
        builder.actions()
        println("Fim da Lista de Itens relacionada ao método contains. Pilha: ${dslSingleton.stackSummary()}")
        itens = dslSingleton.stackOfItens.pop()
        println("Itens neste ultimo contains: ${summary(itens)} com dono: ${parentItem} | ${dslSingleton.previusItem}")
        return builder.build()
    }
}

// Usado quando itens aparecem como um dos elements (só deve aparecer uma única vez)
fun itens(actions: ItemListBuilder.() -> Unit): List<Item> {
    println("Inicio da Lista de Itens. A pilha está vazia")
    val builder = ItemListBuilder()
    builder.actions()
    // Aqui o elemento itens já está completo !
    println("Fim da Lista relacionado ao método itens. Pilha: ${dslSingleton.stackSummary()}")
    return builder.build()
}
