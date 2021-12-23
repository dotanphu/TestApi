package com.dotanphu.testapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.dotanphu.testapi.adapter.CategoryItemAdapter
import com.dotanphu.testapi.databinding.ActivityMainBinding
import com.dotanphu.testapi.model.CategoryItem
import com.dotanphu.testapi.network.CategoryItemClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CategoryItemAdapter
    private var category = arrayListOf<CategoryItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = CategoryItemAdapter(category, this)
        binding.rvCategory.adapter = adapter
        binding.rvCategory.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        getAllCategoryItem()

    }

    private fun getAllCategoryItem() {
        lifecycleScope.launch(Dispatchers.IO) {
            var response: Response<List<CategoryItem>> =
                CategoryItemClient().getAllCategoryItem().execute()
            if (response.isSuccessful) {
                response.body()?.let {
                    category.addAll(it)
                }
                withContext(Dispatchers.Main){
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }
}