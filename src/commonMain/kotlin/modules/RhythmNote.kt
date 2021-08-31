
package modules

import com.soywiz.korev.Key
import com.soywiz.korge.input.Input
import com.soywiz.korge.view.QView
import com.soywiz.korge.view.View
import com.soywiz.korge.view.get
import com.soywiz.korge.view.setText
import kotlinx.coroutines.delay

/**
 *Rhythm Note Class
 *@param view note object
 *@param input Input object cause keyboard input.
 *@param hp just default hp
 */
class RhythmNote(private val view: View, input: Input, private var hp: Double) {
    private val defaulthp = hp
    private val note: QView = view["note"]
    private val keys = input.keys
    /**
     * Set Note Position
     * @param position limit = 1~8 (8 is invisible note and no position) (position 1 not mean x=1)
     * @param y just y
     * @return Boolean? (null mean no effect, True mean up HP, False mean down HP)
     */
    private fun setNotePosition(position: Short, y: Int = 520): Boolean? {
        note.y = (y).toDouble()
        val position2 = position.toInt()
        note.visible = position2 != 8
        if (position2 == 1) {
            note.x = positionone
        }
        if (position2 == 2) {
            note.x = positiontwo
        }
        if (position2 == 3) {
            note.x = positionthree
        }
        if (position2 == 4) {
            note.x = positionfour
        }
        if (position2 == 5) {
            note.x = positionfive
        }
        if (position2 == 6) {
            note.x = positionsix
        }
        if (position2 == 7) {
            note.x = positionseven
        }
        var a: Boolean? = null
        val notcomplex = position2 == 7 && !keys.pressing(Key.SPACE)
        val notcomplex2 = position2 != 7 && keys.pressing(Key.SPACE)
        if (notcomplex || notcomplex2) {
            a = false
        } else if (position2 == 7 && keys.pressing(Key.SPACE)) {
            a = true
        }
        return a
    }
    /**
     * note position with list and control hp, refresh hp
     * @param list Note Position list
     * @param repeat How many repeat
     * @param cooltime cooltime in each note
     */
    suspend fun listnoteposition(list: List<Short>, repeat: Long, cooltime: Float) {
        val cooltime2: Long = (cooltime * 1000F).toLong()
        for (_i2 in 1..repeat)
            for (i in list) {

                val a = setNotePosition(i)
                controlhp(a)
                refreshHP()
                delay(cooltime2)
            }
    }

    /**
     *refresh hp text
     */
    private fun refreshHP() {
        view["hp"].setText(hp.toString())
    }

    /**
     * control hp (plus or minus)
     * @param a noteposition
     */
    private fun controlhp(a: Boolean?) {
        if (a != null) {
            if (a && hp <= (defaulthp - 1)) {
                hp += 1
            } else if (!a) {
                hp -= 1
            }
        }
    }
    companion object {
        private const val positionone = (140).toDouble()
        private const val positiontwo = (280).toDouble()
        private const val positionthree = (428).toDouble()
        private const val positionfour = (576).toDouble()
        private const val positionfive = (722).toDouble()
        private const val positionsix = (854).toDouble()
        private const val positionseven = (1360).toDouble()
    }
}

/**
 * Make List<Number> to MutableList<Short>
 * @param list List<Number>
 * @return converted list
 */
fun makeshortlist(list: List<Number>): MutableList<Short> {
    val list2 = mutableListOf<Short>()
    for (i in list) {
        list2.add(i.toShort())
    }
    return list2
}
