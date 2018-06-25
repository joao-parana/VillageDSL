package dsl.dsg

import dsl.dsg.model.Item

object item

@DSLBuilder("dsl.dsg.model.Item")
class ItemListBuilder {
    private var currentItem: Item? = null
    private val itens = mutableListOf<Item>()

    fun build(): List<Item> = itens

    infix fun item.name(n: String): item {
        currentItem = Item(n)
        itens += currentItem!!
        dslSingleton.itens = itens
        dslSingleton.stackOfItens.push(itens)
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
        val builder = ItemListBuilder()
        builder.actions()
        return builder.build()
    }
}

// Usado quando itens aparecem como um dos elements (só deve aparecer uma única vez)
fun itens(actions: ItemListBuilder.() -> Unit): List<Item> {
    val builder = ItemListBuilder()
    builder.actions()
    return builder.build()
}
