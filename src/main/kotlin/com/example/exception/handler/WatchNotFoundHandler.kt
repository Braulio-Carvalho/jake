package com.example.exception.handler


import com.example.exception.WatchNotFoundException
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.server.exceptions.ExceptionHandler
import javax.inject.Singleton


@Singleton
class WatchNotFoundHandler : ExceptionHandler<WatchNotFoundException, HttpResponse<Any>> {

    override fun handle(request: HttpRequest<*>?, exception: WatchNotFoundException?): HttpResponse<Any> {
        return HttpResponse.status<Any>(HttpStatus.NOT_FOUND).body(exception?.message!!)
    }


}

