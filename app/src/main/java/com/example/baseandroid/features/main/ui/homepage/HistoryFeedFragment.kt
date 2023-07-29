package com.example.baseandroid.features.main.ui.homepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.baseandroid.R
import com.example.baseandroid.features.main.adapter.DeliveryHistoryAdapter
import com.example.baseandroid.features.main.adapter.DeliveryItem

class HistoryFeedFragment : Fragment() {

    private lateinit var historyRecyclerView: RecyclerView
    private lateinit var adapter: DeliveryHistoryAdapter
    private lateinit var deliveryItemList: List<DeliveryItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_explore_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Dummy data for demonstration purposes
        deliveryItemList = createDummyData()

        historyRecyclerView = view.findViewById(R.id.historyRecyclerView)
        historyRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = DeliveryHistoryAdapter(deliveryItemList)
        historyRecyclerView.adapter = adapter
    }

    private fun createDummyData(): List<DeliveryItem> {
        val dummyData = ArrayList<DeliveryItem>()

        dummyData.add(DeliveryItem("Restaurant A", "2023-07-29", "Delivered"))
        dummyData.add(DeliveryItem("Restaurant B", "2023-07-28", "Delivered"))
        dummyData.add(DeliveryItem("Restaurant C", "2023-07-27", "Delivered"))
        dummyData.add(DeliveryItem("Restaurant D", "2023-07-23", "Delivered"))
        dummyData.add(DeliveryItem("Restaurant E", "2023-07-24", "Delivered"))

        // Add more dummy data as needed

        return dummyData
    }
}