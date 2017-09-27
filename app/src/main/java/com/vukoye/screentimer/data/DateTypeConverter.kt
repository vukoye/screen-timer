package com.vukoye.screentimer.data

import android.arch.persistence.room.TypeConverter
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;




class DateTypeConverter {

    @TypeConverter
    fun toDate(timestamp : Long) : LocalDateTime {
        return LocalDateTime.ofEpochSecond(timestamp, 0, ZoneOffset.ofTotalSeconds(0))
    }

    @TypeConverter
    fun toTimestamp(date: LocalDateTime): Long {
        return date.toInstant(ZoneOffset.ofTotalSeconds(0)).epochSecond
    }
}
