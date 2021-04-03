package ClassAndObject

// interface classes = classes that have methode without bodies
interface inputHandler {

    fun clicked()
    fun doubleclick()
    fun singleclick()

}

class phone: inputHandler{
    override fun clicked() {
        println("phone clicked")
    }

    override fun doubleclick() {
        println("phone doubleclick")
    }

    override fun singleclick() {
        println("phone singleclick")
    }

}

class button: inputHandler{
    override fun clicked() {
        println("button clicked")
    }

    override fun doubleclick() {
        println("button doubleclick")
    }

    override fun singleclick() {
        println("button singleclick")
    }

}

fun main(args: Array<String>) {
    var myButton = button()
    myButton.clicked()
    myButton.doubleclick()

    var myPhone = phone()
    myPhone.clicked()
}