package games

import levels.rhythmdoctor.Chapter1

class Adokad {
    /*
    Main Game
     */
    suspend fun startchapter1andlevel1() {
        run {
            Chapter1().level1()
        }
    }
}
