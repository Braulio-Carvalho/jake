package com.example.controller

import com.example.model.Watch
import com.example.model.dto.WatchDTO
import com.example.service.WatchService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*


@Controller("/watches")
class WatchController(private val watchService: WatchService) {

    @Post
    fun saveWatch(@Body watch: Watch): HttpResponse<Watch> {
        return HttpResponse.created(watchService.createWatch(watch))
    }

    @Get("/get")
    fun listWatches(): List<Watch> {
        return watchService.getWatch()
    }

    @Delete("/{id}")
    fun deleteWatchById(@PathVariable id: Long) {
        watchService.deleteWatchById(id)
    }

    @Get("/{id}")
    fun listWatches(@PathVariable id: Long): Watch {
        return watchService.getWatchById(id)
    }

    @Put("/{id}")
    fun updateWatch(@PathVariable id: Long, @Body watch: WatchDTO): HttpResponse<Watch> {
        return HttpResponse.created(watchService.updateWatch(id, watch))
    }


}