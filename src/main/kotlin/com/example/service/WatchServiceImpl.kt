package com.example.service

import com.example.model.Watch
import com.example.model.dto.WatchDTO
import com.example.repository.WatchRepository
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.PathVariable
import javax.inject.Singleton
import javax.persistence.EntityNotFoundException

@Singleton
class WatchServiceImpl(private val watchRepository: WatchRepository) : WatchService {


    override fun createWatch(watch: Watch): Watch {
        return watchRepository.save(watch)
    }

    override fun getWatchById(id: Long): Watch {
        return watchRepository.findById(id).get()
    }

    override fun getWatch(): List<Watch> {
        return watchRepository.findAll()
    }

    override fun deleteWatchById(id: Long) {
        val watch = watchRepository.findById(id)
        watchRepository.delete(watch.get())
    }

    override fun updateWatch(id: Long, newWatch: WatchDTO): Watch {
        var watch = watchRepository.findById(id).orElseThrow { RuntimeException() }
        watch.apply {
            this.model = newWatch.model
            this.gender = newWatch.gender
        }
        return watchRepository.save(watch)
    }


}