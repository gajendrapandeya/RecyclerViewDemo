package com.codermonkeys.recyclerviewdemo.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import com.codermonkeys.recyclerviewdemo.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    private lateinit var detailFragmentBinding: FragmentDetailBinding

    private val args by navArgs<DetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        detailFragmentBinding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return detailFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailFragmentBinding.ivNoteImage.load(args.listItemData.image)
        detailFragmentBinding.tvNoteTtile.text = args.listItemData.title
        detailFragmentBinding.tvNoteDesc.text = args.listItemData.description
    }
}