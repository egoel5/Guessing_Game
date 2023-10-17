package com.example.c323_midtermproject

import androidx.recyclerview.widget.DiffUtil

/**
 * Compare items and return if they are same or aren't
 * Compare content and return if the content in both items is same or not
 */
class ScoreDiffItemCallback : DiffUtil.ItemCallback<Score>() {
    override fun areItemsTheSame(oldItem: Score, newItem: Score) =
        (oldItem.scoreId == newItem.scoreId)
    override fun areContentsTheSame(oldItem: Score, newItem: Score) = (oldItem == newItem)
}