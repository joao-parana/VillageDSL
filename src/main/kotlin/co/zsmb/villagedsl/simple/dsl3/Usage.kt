package co.zsmb.villagedsl.simple.dsl3

fun main(args: Array<String>) {

    val forty = 40
    val v = village containing houses {

        house with people {
            "Emily" age 31
            "Hannah" age 27
            "Alex" age 21
            "Daniel" age 17
        }

        house with person {
            "Joe" age 48
        }

        house without people

        house with people {
            "Sarah" age forty
            "Tom" age 26
            "Holly" age 52
        }

    }

    print(v)

}
