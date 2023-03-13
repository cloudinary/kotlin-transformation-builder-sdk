package com.cloudinary.transformation.effect

import com.cloudinary.transformation.gravity.IAutoGravityObject
import com.cloudinary.transformation.gravity.IGravityObject

class ForegroundObject(private val value: String) {
        companion object {
            private val airplane = ForegroundObject("airplane")
            fun airplane() = airplane
            private val bus = ForegroundObject("bus")
            fun bus() = bus
            private val dining_table = ForegroundObject("dining_table")
            fun dining_table() = dining_table
            private val sheep = ForegroundObject("sheep")
            fun sheep() = sheep
            private val bicycle = ForegroundObject("bicycle")
            fun bicycle() = bicycle
            private val car = ForegroundObject("car")
            fun car() = car
            private val dog = ForegroundObject("dog")
            fun dog() = dog
            private val sofa = ForegroundObject("sofa")
            fun sofa() = sofa
            private val bird = ForegroundObject("bird")
            fun bird() = bird
            private val cat = ForegroundObject("cat")
            fun cat() = cat
            private val horse = ForegroundObject("horse")
            fun horse() = horse
            private val train = ForegroundObject("train")
            fun train() = train
            private val boat = ForegroundObject("boat")
            fun boat() = boat
            private val chair = ForegroundObject("chair")
            fun chair() = chair
            private val person = ForegroundObject("person")
            fun person() = person
            private val tv = ForegroundObject("tv")
            fun tv() = tv
            private val bottle = ForegroundObject("bottle")
            fun bottle() = bottle
            private val cow = ForegroundObject("cow")
            fun cow() = cow
            private val potted_plant = ForegroundObject("potted_plant")
            fun potted_plant() = potted_plant
            private val motorbike = ForegroundObject("motorbike")
            fun motorbike() = motorbike
        }

        override fun toString() = value
}