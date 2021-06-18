package com.codermonkeys.recyclerviewdemo.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.codermonkeys.recyclerviewdemo.adapter.ListItemAdapter
import com.codermonkeys.recyclerviewdemo.databinding.FragmentListBinding
import com.codermonkeys.recyclerviewdemo.model.ListItem

class ListFragment : Fragment(), ListItemAdapter.OnItemClickListener {

    private lateinit var listFragmentBinding: FragmentListBinding
    private lateinit var listAdapter: ListItemAdapter
    private val listItems = mutableListOf<ListItem>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listFragmentBinding = FragmentListBinding.inflate(inflater, container, false)
        return listFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listFragmentBinding.rvList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = setUpAdapter()
            setHasFixedSize(true)
        }
    }

    private fun setData(): MutableList<ListItem> {
        listItems.addAll(
            listOf(
                ListItem(
                    "https://images.unsplash.com/photo-1522992319-0365e5f11656?ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8Y29mZmVlfGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60",
                    "Make Coffee",
                    "Make coffe for night study"
                ),
                ListItem(
                    "https://images.unsplash.com/photo-1521572163474-6864f9cf17ab?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8dHNoaXJ0fGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60",
                    "Buy t-shirt",
                    "Buy t-shirt for friends birthday"
                ),
                ListItem(
                    "https://images.unsplash.com/photo-1468436139062-f60a71c5c892?ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8bWFjfGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60",
                    "Buy mac",
                    "My pc getting old. Buy new one"
                ),
                ListItem(
                    "https://images.unsplash.com/photo-1522992319-0365e5f11656?ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8Y29mZmVlfGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60",
                    "Make Coffee",
                    "Make coffe for night study"
                ),
                ListItem(
                    "https://images.unsplash.com/photo-1521572163474-6864f9cf17ab?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8dHNoaXJ0fGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60",
                    "Buy t-shirt",
                    "Buy t-shirt for friends birthday"
                ),
                ListItem(
                    "https://images.unsplash.com/photo-1468436139062-f60a71c5c892?ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8bWFjfGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60",
                    "Buy mac",
                    "My pc getting old. Buy new one"
                ),
                ListItem(
                    "https://images.unsplash.com/photo-1522992319-0365e5f11656?ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8Y29mZmVlfGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60",
                    "Make Coffee",
                    "Make coffe for night study"
                ),
                ListItem(
                    "https://images.unsplash.com/photo-1521572163474-6864f9cf17ab?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8dHNoaXJ0fGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60",
                    "Buy t-shirt",
                    "Buy t-shirt for friends birthday"
                ),
                ListItem(
                    "https://images.unsplash.com/photo-1468436139062-f60a71c5c892?ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8bWFjfGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60",
                    "Buy mac",
                    "My pc getting old. Buy new one"
                )
            )
        )
        return listItems
    }

    private fun setUpAdapter(): ListItemAdapter {
        listAdapter = ListItemAdapter(
            setData(),
            this
        )
        return listAdapter
    }

    override fun onItemClick(position: Int) {
        val action = ListFragmentDirections.actionListFragmentToDetailFragment(listItems[position])
        findNavController().navigate(action)
    }

}