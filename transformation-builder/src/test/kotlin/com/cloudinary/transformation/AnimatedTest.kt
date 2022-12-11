package com.cloudinary.transformation

import com.cloudinary.cldAssert
import com.cloudinary.transformation.animated.Animated
import org.junit.Test

class AnimatedTest {
    @Test
    fun testAnimatedEdit() {
        cldAssert("dl_200,e_loop:2", Animated.edit {
            delay(200)
            loop(2)
        })
        cldAssert("dl_50", Animated.edit {
            delay(50)
        })
        cldAssert("e_loop:3", Animated.edit {
            loop(3)
        })
    }
}