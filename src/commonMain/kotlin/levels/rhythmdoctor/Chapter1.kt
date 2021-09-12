package levels.rhythmdoctor

import com.soywiz.korau.sound.readMusic
import com.soywiz.korge.Korge
import com.soywiz.korge.view.View
import com.soywiz.korge.view.ktree.readKTree
import com.soywiz.korim.color.Colors
import com.soywiz.korio.file.std.resourcesVfs
import kotlinx.coroutines.delay
import modules.RhythmNote
import modules.makeshortlist

class Chapter1 {
    suspend fun level1() = Korge(width = 1920, height = 1080, bgcolor = Colors.WHITE, title = "a dance of kotlin and doctor", iconPath = "logo.png") { // Samurai Techno
        val doctor: View = resourcesVfs["ktrees/rhythmdoctor/SamuraiTechno.ktree"].readKTree(views)
        val input = views.input
        val note = RhythmNote(doctor, input, (100).toDouble())
        val list1: MutableList<Short> = makeshortlist(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9))
        val list2: MutableList<Short> = makeshortlist(listOf(1, 2, 3, 4, 5, 6, 7, 8))
        val beat1 = 0.27F
        val beat2 = 0.15F
        val music = resourcesVfs["musics/rhythmdoctor/samurai techno.mp3"].readMusic()
        music.play()
        addChild(doctor)
        delay(9900L)
        note.listnoteposition(list1, 2, beat1)
        note.listnoteposition(list2, 1, beat1)
        note.listnoteposition(list2, 2, beat2)
        note.listnoteposition(list1, 2, beat1)
        note.listnoteposition(list2, 1, beat1)
        note.listnoteposition(list2, 2, beat2)
        delay(150L)
        note.listnoteposition(list1, 27, beat2)
        delay(300L)
        note.listnoteposition(list1, 3, beat2)
        delay(1800L)
        note.listnoteposition(list1, 1, beat2)
    }
}
