package com.vukoye.screentimer.data

import android.arch.persistence.room.TypeConverter
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;




class LocalDateConverter {
        @TypeConverter
        fun toDate(timestamp: Long?): LocalDateTime? {
            return if (timestamp == null) LocalDateTime.MIN else LocalDateTime.ofEpochSecond(timestamp, 0, ZoneOffset.ofTotalSeconds(0))

        }

        @TypeConverter
        fun toTimestamp(date: LocalDateTime): Long? {
            return if (date == null) 0 else date.toInstant(ZoneOffset.ofTotalSeconds(0)).epochSecond
        }
}
