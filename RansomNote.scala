import scala.io.StdIn.readLine

object RansomNote {
    def isValidRansomNote(magazine:String, note: String): Boolean = {
        val magazineMap = scala.collection.mutable.Map[Char, Int]()
        magazine.foreach{letter =>
            val count = if(!magazineMap.contains(letter)) 0 else magazineMap(letter)
            magazineMap(letter) = count + 1
        }

        for(letter <- note) {
            val count = if(!magazineMap.contains(letter)) 0 else magazineMap(letter)
            if(count < 1) {
                return false
            } else {
                magazineMap(letter) = count - 1
            }
        }
        true
    }

    def main(args: Array[String]) {
        print("Magazine:")
        val magazine = readLine
        print("Note:")
        val note = readLine

        val valid = isValidRansomNote(magazine, note)
        println(s"Note $note on magazine $magazine is ${if(valid) "valid" else "invalid"}")
    }
}