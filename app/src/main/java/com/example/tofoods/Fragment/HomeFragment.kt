package com.example.tofoods.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tofoods.Adapter.CategoryAdapter
import com.example.tofoods.Adapter.MakananAdapter
import com.example.tofoods.Adapter.MakananUnikAdapter
import com.example.tofoods.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var rvCategory: RecyclerView
    private lateinit var categoryAdapter: CategoryAdapter

    private lateinit var rvMakanan: RecyclerView
    private lateinit var makananAdapter: MakananAdapter

    private lateinit var rvMakananUnik: RecyclerView
    private lateinit var makananUnikAdapter: MakananUnikAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvCategory = view.findViewById(R.id.rv_category)
        categoryAdapter = CategoryAdapter()

        rvMakanan = view.findViewById(R.id.rv_makanan)
        makananAdapter = MakananAdapter()

        rvMakananUnik = view.findViewById(R.id.rv_makanan_unik)
        makananUnikAdapter = MakananUnikAdapter()

        categoryView()
        makananView()
        makananUnikView()

    }

    private fun makananView() {
        rvMakanan.layoutManager = GridLayoutManager(activity, 2)
        rvMakanan.adapter = makananAdapter
    }

    private fun categoryView() {
        rvCategory.layoutManager = GridLayoutManager(activity, 3)
        rvCategory.adapter = categoryAdapter
    }

    private fun makananUnikView() {
        rvMakananUnik.layoutManager = GridLayoutManager(activity, 2)
        rvMakananUnik.adapter = makananUnikAdapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}