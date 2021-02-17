import kotlin.random.Random

class Wizard(
    val name: String,
    val power: Int,
    val phrase: String,
    val spell: String,
    val color: Boolean)

class WizardGroupGenerator{
    fun countGenerator() {

        //Генерим волшебников
        fun createWizard(minWizardCount: Int, maxWizardCount: Int) {

            val listName = listOf("Шут", "Варрик", "Луна", "Фитц")

            val startPhrase = listOf("Эй, ты! ", "Отродье. ", "Смерть глупцам. ", "Чёртов эльф! ", "Ничтожное существо. ")
            val middlePhrase = listOf("Умри! ", "Вызываю тебя на поединок. ", "Тебе не победить. ")
            val endPhrase = listOf("Я сражаюсь во имя Королевы.", "Мой клинок пронзит тебя.", " ")

            fun generateSpell(size: Int): String {
                val source = "A1BCDEF4G0H8IJKLM7NOPQ3RST9UVWX52YZab1cd60ef2ghij3klmn49opq5rst6uvw7xyz8"
                return (source).map { it }.shuffled().subList(0, size).joinToString("")
            }

            fun colorWizard(power: Int): Boolean{
                return power <= 666
            /*
                if (power <= 666) return true
                else return false
            */
            }

            println("Мы создали волшебников, вот они, сверху вниз:" + "\n")

            repeat(Random.nextInt(minWizardCount, maxWizardCount)) {

                val power = Random.nextInt(0, 999)

                val wizard = Wizard(
                    listName[Random.nextInt(0, listName.size)],
                    power,
                    (startPhrase.random() + middlePhrase.random() + endPhrase.random()),
                    generateSpell(Random.nextInt(1, 10)),
                    colorWizard(power)
                )
                println(wizard.name + " говорит: " + wizard.phrase)
                println("Кастует случайное заклинание: " + wizard.spell)
                println("Затем атакует с силой: " + wizard.power)
                println("Светлый волшебник: " + wizard.color)
                println(" ")
            }
        }

        //Определяем верхние и нижние границы

        fun checkInput(): Int {
            val num = readLine()?.toIntOrNull()
            return if(num!=null && num>0) num else 1
        }

        println("Минимальное количество: ")
        var minWizardCount = checkInput()
        println("Максимальное количество: ")
        var maxWizardCount = checkInput()

        if (minWizardCount == maxWizardCount) {
            maxWizardCount += 1
        }
        if (minWizardCount > maxWizardCount) {
            minWizardCount = maxWizardCount.also { maxWizardCount = minWizardCount }
        }

        createWizard(minWizardCount, maxWizardCount)
    }
}

fun main() {
    println("Введите числа для генерации Волшебников")
    val wizardGenerator = WizardGroupGenerator()
    return wizardGenerator.countGenerator()
}

