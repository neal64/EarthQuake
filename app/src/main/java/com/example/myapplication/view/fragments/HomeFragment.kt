package com.example.myapplication.view.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.Result
import com.example.myapplication.di.BaseApplication
import com.example.myapplication.model.Earthquakes
import com.example.myapplication.view.MyRecycleViewAdapter
import com.example.myapplication.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.home_fragment.view.*
import javax.inject.Inject


@Suppress("DEPRECATION")
@SuppressLint("ShowToast")
class HomeFragment : Fragment() {
    lateinit var viewModel: HomeViewModel
    lateinit var root: View
    var mList: MutableList<Earthquakes> = ArrayList()
    lateinit var rv: RecyclerView

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.home_fragment, container, false)
        ( activity?.application as BaseApplication).getAppComponent()?.inject(this)
        init()
        return root
    }

    fun init() {
        viewModel = ViewModelProvider(this, mViewModelFactory).get(HomeViewModel::class.java)
        getEarthQuakesData()
        rv = root.recycle_view.apply {
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
        }
    }

    fun getEarthQuakesData(){
        lifecycleScope.launchWhenCreated {
            val result = viewModel.getEarthQuakesData()
            when (result) {
                is Result.Success -> {
                    mList = result.data
                    rv.adapter =
                        MyRecycleViewAdapter( mList)
                }
                is Result.Error -> {
                    Toast.makeText(activity, "${result.exception}", Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}