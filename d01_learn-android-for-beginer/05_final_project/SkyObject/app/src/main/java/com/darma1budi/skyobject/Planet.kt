package com.darma1budi.skyobject

data class Planet(
    var name: String = "",
    var description: String = "",
    var picture: Int = 0,
    var video: Int = 0,
    var averageRadius: Double = 0.0,
    var mass: Double = 0.0,
    var surfaceArea: Double = 0.0,
    var gravity: Double = 0.0,
    var distanceFromSun: Double = 0.0,
    var rotationTime: String = "",
    var moon: String = ""
)