package com.github.lsj8367.redis.prize.infrastructure

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors


@SpringBootTest
class PrizeRedisTest(
        @Autowired
        private val prizeRedis: PrizeRedis
) {

    @Test
    fun test() {
        val count = 1
        val executorService = Executors.newFixedThreadPool(count)
        val countDownLatch = CountDownLatch(count)

        val list = ArrayList<Long>()
        // when
        for (i in 0 until count) {
            executorService.execute {
                try {
//                    val prize = prizeRedis.getPrize()
//                    Thread.sleep(1000)
//                    if (prize >= 100) {
//                        prizeRedis.updatePrize(prize.toLong())
//                    }
                    list.add(prizeRedis.luaScript(100))
                } catch (e: Exception) {
                    print(e)
                } finally {
                    countDownLatch.countDown()
                }
            }
        }
        countDownLatch.await()
        executorService.shutdown()

        for (l in list) {
            print(l)
        }
    }
}