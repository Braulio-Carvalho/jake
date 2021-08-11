package com.example.exception

class WatchNotFoundException(override val message: String) : RuntimeException(message) {

    companion object {
        private const val serialVersionUID = 1149241039409861914L

        const val WATCH_NOT_FOUND = "Watch not found!"

    }

}

