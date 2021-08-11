package com.example.service

import com.example.exception.WatchNotFoundException
import com.example.exception.WatchNotFoundException.Companion.WATCH_NOT_FOUND
import com.example.model.Watch
import com.example.model.dto.WatchDTO
import com.example.repository.WatchRepository
import javax.inject.Singleton

@Singleton
class WatchServiceImpl(private val watchRepository: WatchRepository) : WatchService {


    override fun createWatch(watch: Watch): Watch {
        return watchRepository.save(watch)
    }

    override fun getWatchById(id: Long): Watch {
        return watchRepository.findById(id).orElseThrow { WatchNotFoundException(WATCH_NOT_FOUND) }
    }

    override fun getWatch(): List<Watch> {
        return watchRepository.findAll()
    }

    override fun deleteWatchById(id: Long) {
        val watch = watchRepository.findById(id).orElseThrow { WatchNotFoundException(WATCH_NOT_FOUND) }
        with(watchRepository) {
            delete(watch)
        }
    }

    override fun updateWatch(id: Long, newWatch: WatchDTO): Watch {
        var watch = watchRepository.findById(id).orElseThrow { WatchNotFoundException(WATCH_NOT_FOUND) }
        watch.apply {
            this.model = newWatch.model
            this.gender = newWatch.gender
        }
        return watchRepository.update(watch)
    }


}