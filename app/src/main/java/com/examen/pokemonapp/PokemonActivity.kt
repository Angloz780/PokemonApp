package com.examen.pokemonapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.examen.pokemonapp.databinding.ActivityPokemonBinding
import com.examen.pokemonapp.databinding.ItemPokemonBinding

class PokemonActivity : AppCompatActivity() {

    companion object{
        const val POKEMON_TAG = "Pokemon"
        fun start(pokemon: Pokemon, context: Context){
            val intent = Intent(context, PokemonActivity::class.java)
            intent.putExtra(POKEMON_TAG, pokemon.toJson())
            context.startActivity(intent)
        }
    }

    private lateinit var binding: ActivityPokemonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pokemonJson = intent.getStringExtra(POKEMON_TAG)
        if(pokemonJson != null) {
            var pokemon = Pokemon.fromJson(pokemonJson)
            binding.tvPokemonNombre.text = pokemon.nameCapitalized()
        }
    }
}