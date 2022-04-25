package com.examen.pokemonapp

import Pokemon
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

class ObtenerPokemonRequest {

    companion object {

        private var gson = Gson()

        fun get(): ListaPokemon {
            val listaPokemon = ListaPokemon()
            val client = OkHttpClient()
            for (i in 1..9) {
                val request = Request.Builder()
                    .url("https://pokeapi.co/api/v2/pokemon/${i}")
                    .build()
                val response = client.newCall(request).execute()

                if (response.isSuccessful) {
                    response.body?.string().let { responseBody ->
                        val pokemon = gson.fromJson(responseBody, Pokemon::class.java)
                        listaPokemon.agregar(pokemon)
                    }
                } else
                    println("Algo ha ido mal")
            }
            return listaPokemon
        }
    }
}