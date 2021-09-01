package games

import com.soywiz.korge.Korge
import com.soywiz.korge.view.View
import com.soywiz.korge.view.ktree.readKTree
import com.soywiz.korim.color.Colors
import com.soywiz.korio.file.std.resourcesVfs
import levels.rhythmdoctor.Chapter1
import modules.RhythmNote

class Adokad {
    /*
    Main Game
     */
    suspend fun start() = Korge(width = 1920, height = 1080, bgcolor = Colors["#D3D3D3"], title="title", iconPath="logo.png") {
        val doctor: View = resourcesVfs["myTree.ktree"].readKTree(views)
        val input = views.input
        addChild(doctor)

        val noteclass = RhythmNote(doctor, input, DEAFULT_HP)
        Chapter1().level1(noteclass)
    }
    companion object {
        private const val DEAFULT_HP = (100).toDouble()
    }
}
