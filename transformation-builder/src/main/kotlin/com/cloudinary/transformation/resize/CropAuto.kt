package com.cloudinary.transformation.resize

import com.cloudinary.transformation.Param
import com.cloudinary.transformation.gravity.Gravity

class CropAuto(
        dimensions: Dimensions,
        val gravity: Gravity? = null
    ) :
        Resize(dimensions, null, null) {
        override val actionType = "auto"

        override fun params(): Collection<Param?> {
            return super.params() + listOfNotNull(
                gravity?.let { Param("g", it) }
            )
        }

        class Builder : BaseBuilder<Builder>() {
            private var gravity: Gravity? = null

            fun gravity(gravity: Gravity) = apply {
                this.gravity = gravity
            }

            override fun getThis() = this

            override fun build() = CropAuto(
                Dimensions(width, height, aspectRatio),
                gravity
            )
        }
    }