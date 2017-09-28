package com.vukoye.screentimer.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import org.threeten.bp.LocalDateTime


@Entity
class ScreenInterval(@ColumnInfo(name = "start_date") var startDate: LocalDateTime,
                     @ColumnInfo(name = "end_date") var endDate: LocalDateTime,
                     @ColumnInfo(name = "type") val type: Int,
                     @ColumnInfo(name = "comment") val comment: String) {

    companion object {
        val TYPE_SCREEN_OFF = 0
        val TYPE_SCREEN_ON = 1
        val TYPE_SCREEN_OFF_SLEEPING = 2
    }

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0


}

