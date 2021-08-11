package com.example.service

import com.example.model.Watch
import com.example.model.dto.WatchDTO


interface WatchService {

    fun createWatch(watch: Watch): Watch

    fun getWatchById(id: Long): Watch

    fun getWatch(): List<Watch>

    fun deleteWatchById(id: Long)

    fun updateWatch(id: Long, newWatch: WatchDTO): Watch

}