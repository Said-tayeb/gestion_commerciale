package com.example.safesoftapplication.backend.api.bdLocal

import java.text.ParsePosition
import java.text.SimpleDateFormat
import java.util.*

class DateConverter {

    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }

    fun stringToDate(aDate: String?, aFormat: String?): Date? {
        if (aDate == null) return null
        val pos = ParsePosition(0)
        val simpledateformat = SimpleDateFormat(aFormat)
        return simpledateformat.parse(aDate, pos)
    }
}