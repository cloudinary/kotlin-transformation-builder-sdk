package com.cloudinary.transformation.layer

import com.cloudinary.cldAssert
import com.cloudinary.transformation.Color
import com.cloudinary.transformation.Transformation
import com.cloudinary.transformation.gravity.FocusOn
import com.cloudinary.transformation.gravity.Gravity
import com.cloudinary.transformation.layer.BlendMode.Companion.multiply
import com.cloudinary.transformation.layer.position.Position
import com.cloudinary.transformation.layer.source.Size
import com.cloudinary.transformation.layer.source.Source.Companion.fetch
import com.cloudinary.transformation.layer.source.Source.Companion.image
import com.cloudinary.transformation.layer.source.Stroke
import com.cloudinary.transformation.resize.Resize.Companion.scale
import org.junit.Test

class OverlayTest {
    private val position = Position.Builder().gravity(Gravity.focusOn(FocusOn.cat())).offsetX(20).build()

    @Test
    fun testOverlay() {
        var overlay = Overlay.source(image("sample")) {
            blendMode(multiply())
        }

        cldAssert("l_sample/e_multiply,fl_layer_apply", overlay)

        overlay = Overlay.source(image("sample") {
            transformation { resize(scale { width(250) }) }
        }) {
            position(position)
            blendMode(multiply())
        }

        cldAssert("l_sample/c_scale,w_250/e_multiply,fl_layer_apply,g_cat,x_20", overlay)

        overlay = Overlay.source(fetch("https://res.cloudinary.com/demo/image/upload/sample")) {
            position(position)
        }

        cldAssert(
            "l_fetch:aHR0cHM6Ly9yZXMuY2xvdWRpbmFyeS5jb20vZGVtby9pbWFnZS91cGxvYWQvc2FtcGxl/fl_layer_apply,g_cat,x_20",
            overlay
        )
        overlay = Overlay.text {
            source("hello world!") {
                style("Arial", 17)
                textColor(Color.RED)
                backgroundColor(Color.GREEN)
                transformation { resize(scale { width(250) }) }
            }
            position(position)
        }

        cldAssert("b_green,co_red,l_text:Arial_17:hello world!/c_scale,w_250/fl_layer_apply,g_cat,x_20", overlay)
    }

    @Test
    fun testTextFit() {
        var overlay = Overlay.text {
            source("hello world") {
                style("Arial", 17)
                textFit(200)
            }
        }
        cldAssert("c_fit,l_text:Arial_17:hello world,w_200/fl_layer_apply", overlay)

        overlay = Overlay.text {
            source("hello world") {
                style("Arial", 17)
                textFit(200) {
                    height(100)
                }
            }
        }
        cldAssert("c_fit,h_100,l_text:Arial_17:hello world,w_200/fl_layer_apply", overlay)
        overlay = Overlay.text {
            source("hello world") {
                style("Arial", 17)
                textFit {
                    size(Size(150,300))
                }
            }
        }
        cldAssert("c_fit,h_300,l_text:Arial_17:hello world,w_150/fl_layer_apply", overlay)
    }

    @Test
    fun testOverlayWithUserVariables() {
        var transformation = Transformation()
            .addVariable("style", "Arial_17")
            .addVariable("myColor","red")
            .overlay(Overlay.text {
                source("hello-world") {
                    style("\$style")
                    textColor("\$myColor")
                }
            })

        cldAssert("\$style_!Arial_17!/\$myColor_!red!/co_\$myColor,l_text:\$style:hello-world/fl_layer_apply", transformation)
    }

    @Test
    fun testTextOverlayWithStroke() {
        var overlay = Overlay.text {
            source("hello world!") {
                style("Arial", 17)
                textColor(Color.RED)
                backgroundColor(Color.GREEN)
                stroke(Stroke.solid(2, "white"))
                transformation { resize(scale { width(250) }) }
            }
            position(position)
        }

        cldAssert("b_green,bo_2px_solid_white,co_red,l_text:Arial_17:hello world!:stroke/c_scale,w_250/fl_layer_apply,g_cat,x_20", overlay)

        overlay = Overlay.text {
            source("hello world!") {
                style("Arial", 17)
                textColor(Color.RED)
                backgroundColor(Color.GREEN)
                stroke("2px_solid_white")
                transformation { resize(scale { width(250) }) }
            }
            position(position)
        }

        cldAssert("b_green,bo_2px_solid_white,co_red,l_text:Arial_17:hello world!:stroke/c_scale,w_250/fl_layer_apply,g_cat,x_20", overlay)
    }
}
