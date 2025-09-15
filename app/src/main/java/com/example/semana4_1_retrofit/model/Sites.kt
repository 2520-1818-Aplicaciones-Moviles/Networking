package com.example.semana4_1_retrofit.model

/**
* This is a data class representing a site with its details.
* It includes properties for the site's ID, name, description, and image URL.
* Most commonly knew as Data Transfer Object (DTO).
*
* Data class includes constructor, getters, setters,
* equals, hashCode, and toString methods.
 *
 * @param idSitio
 * @param descripcion
 * @param nombre
 * @param pais
 * @param imagen
 *
* */

data class Sites(
    val idSitio: String,
    val descripcion: String,
    val nombre: String,
    var pais: String,
    val imagen: String
)