package levels.rhythmdoctor

import com.soywiz.korau.sound.readMusic
import com.soywiz.korio.file.std.resourcesVfs
import kotlinx.coroutines.delay
import modules.RhythmNote
import modules.makeshortlist

class Chapter1 {
    suspend fun level1(note: RhythmNote) { // Samurai Techno
        val list1: MutableList<Short> = makeshortlist(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9))
        val list2: MutableList<Short> = makeshortlist(listOf(1, 2, 3, 4, 5, 6, 7, 8))
        val beat1 = 0.27F
        val beat2 = 0.15F
        val music = resourcesVfs["musics/rhythmdoctor/samurai techno.mp3"].readMusic()
        music.play()
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
