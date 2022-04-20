package com.examen.pokemonapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.examen.pokemonapp.databinding.ItemPokemonBinding

class AdapterPokemon : RecyclerView.Adapter<AdapterPokemon.PokemonViewHolder>(){

    class PokemonViewHolder(val pokemonBinding: ItemPokemonBinding): RecyclerView.ViewHolder(pokemonBinding.root)

    var pokemons = ListaPokemon()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val pokemonBinding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context))
        return PokemonViewHolder(pokemonBinding)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.pokemonBinding.tvPokemon.text = pokemons.listaPokemon[position].name

        Picasso.get().load(pokemons.listaPokemon[position].sprites.frontDefault).into(holder.pokemonBinding.ivPokemon);
    }

    override fun getItemCount(): Int {
        return pokemons.listaPokemon.size
    }
}