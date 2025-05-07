package com.github.lsj8367.redis.prize.infrastructure

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.script.RedisScript
import org.springframework.stereotype.Component

private const val KEY = "prize:amount"

@Component
class PrizeRedis(
        private val redisTemplate: RedisTemplate<String, Any>
) {
    private val logger: Logger = LoggerFactory.getLogger(PrizeRedis::class.java)


    fun getPrize(): Int {
        val pointAmount = redisTemplate.opsForValue().get(KEY) ?: return 0
        return pointAmount as Int
    }

    fun updatePrize(pointAmount: Long): Long {
        val subtract = redisTemplate.opsForValue().decrement(KEY, pointAmount) ?: return 0
        logger.info("subtract : {}", subtract)
        if (subtract < 0) {
            val newPrizeAmount = pointAmount - Math.abs(subtract)
            logger.info("newPrizeAmount : {}", newPrizeAmount)
            redisTemplate.opsForValue().increment(KEY, pointAmount)
            return newPrizeAmount
        }

        logger.info("prizeAmount : {}", pointAmount)
        return pointAmount
    }

    //Lua script 로 get 부터 조건까지 넣어서 반환한다
    fun luaScript(pointAmount: Long): Long {
        val luaScript = """
            local current_amount = tonumber(redis.call('GET', KEYS[1]))
            local prize = tonumber(ARGV[1])
            
            if current_amount == nil then
                return redis.error_reply("Key does not exist")
            end
            
            if prize < 100 then
                return current_amount
            end
            
            if current_amount < prize then
                return redis.error_reply("Not enough prize amount")
            end
            
            redis.call('DECRBY', KEYS[1], prize)
            return current_amount - prize

        """.trimIndent()

        val redisScript = RedisScript.of(luaScript, Long::class.java)

        return redisTemplate.execute(
                redisScript,
                listOf(KEY),
                pointAmount
        )
    }
}