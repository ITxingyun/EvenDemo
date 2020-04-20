package com.xingyun.evendemo.thread

import org.junit.Test
import java.nio.channels.SelectionKey
import java.nio.channels.Selector
import java.nio.channels.ServerSocketChannel

class NioTest {


    @Test
    fun test_nio() {
        val selector = Selector.open()
        val ssc = ServerSocketChannel.open()
                .apply {
                    configureBlocking(false)
                    register(selector, SelectionKey.OP_ACCEPT)
                }

    }
}