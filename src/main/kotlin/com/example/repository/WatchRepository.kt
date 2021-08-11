package com.example.repository

import com.example.model.Watch
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface WatchRepository : JpaRepository<Watch, Long> {

}