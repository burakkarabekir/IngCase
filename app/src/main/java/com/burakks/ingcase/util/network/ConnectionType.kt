package com.burakks.ingcase.util.network

sealed class ConnectionType {
    data class Initialise(val connected: Boolean = false) : ConnectionType()
    data class Available(val connected: Boolean = false) : ConnectionType()
    data class Lost(val connected: Boolean = false) : ConnectionType()
}