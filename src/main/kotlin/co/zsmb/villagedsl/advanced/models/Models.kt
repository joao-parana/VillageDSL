package co.zsmb.villagedsl.advanced.models

data class Village(val houses: List<House>)

data class House(val people: List<Person>, val items: List<Item>)

interface Item

data class Person(val name: String, val age: Int): Item

data class Gold(val amount: Int) : Item

interface Weapon : Item

data class Sword(val strength: Double) : Weapon

interface Armor : Item

data class Shield(val defense: Double) : Armor
