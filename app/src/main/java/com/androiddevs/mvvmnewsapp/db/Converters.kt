package com.androiddevs.mvvmnewsapp.db

import androidx.room.TypeConverter
import com.androiddevs.mvvmnewsapp.models.Source


//use to convert coming source from dao, eg- string to source or source to string
class Converters {

    @TypeConverter
    fun fromSource(source: Source): String {

        //convert source to string just taking name of the source
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }
}