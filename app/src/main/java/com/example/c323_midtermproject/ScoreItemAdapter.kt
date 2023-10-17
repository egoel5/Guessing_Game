package com.example.c323_midtermproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.c323_midtermproject.databinding.ScoreItemBinding
class ScoreItemAdapter (val deleteClickListener: (scoreId: Long) -> Unit)
    : ListAdapter<Score, ScoreItemAdapter.ScoreItemViewHolder>(ScoreDiffItemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : ScoreItemViewHolder = ScoreItemViewHolder.inflateFrom(parent)

    override fun onBindViewHolder(holder: ScoreItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, deleteClickListener)
    }

    class ScoreItemViewHolder(val binding: ScoreItemBinding)
        : RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun inflateFrom(parent: ViewGroup): ScoreItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ScoreItemBinding.inflate(layoutInflater, parent, false)
                return ScoreItemViewHolder(binding)
            }
        }

        fun bind(item: Score, deleteClickListener: (scoreId: Long) -> Unit) {
            binding.score = item
            binding.delButton.setOnClickListener { deleteClickListener(item.scoreId) }
        }
    }
}