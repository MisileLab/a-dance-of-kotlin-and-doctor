package levels.rhythmdoctor

import com.soywiz.korau.sound.readMusic
import com.soywiz.korio.file.std.resourcesVfs
import kotlinx.coroutines.delay
import modules.RhythmNote
import modules.makeshortlist

class Chapter1 {
    suspend fun level1(note: RhythmNote) { // Samurai Techno
        val list1: MutableList<Short> = makeshortlist(listOf(1, 2, 3, 4, 5, 6, 7))
        val beat1 = 0.27F
        val beat2 = 0.21F
        val music = resourcesVfs["musics/rhythmdoctor/samurai techno.mp3"].readMusic()
        music.play()
        delay(1000L * 9L)
        note.listnoteposition(list1, 3, beat1)
        note.listnoteposition(list1, 2, beat2)
        note.listnoteposition(list1, 3, beat1)
        note.listnoteposition(list1, 2, beat1)
        note.listnoteposition(list1, 29, beat2)
        delay(1L * 1000L)
        note.listnoteposition(list1, 3, beat2)
        delay(3L * 1000L)
        note.listnoteposition(list1, 1, beat2)
    }
}
