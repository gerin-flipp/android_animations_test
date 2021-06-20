package com.example.animations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.animations.databinding.FragmentFirstBinding


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var isChecked1 = false
    private var isChecked2 = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        binding.checkbox.setOnClickListener { check: View ->
            isChecked1 = !isChecked1;
            val stateSet = intArrayOf(android.R.attr.state_checked * if (isChecked1) 1 else -1)
            (check as ImageView).setImageState(stateSet, true)
        }
        binding.animButton.setOnClickListener { check: View ->
            isChecked2 = !isChecked2
            val stateSet = intArrayOf(android.R.attr.state_checked * if (isChecked2) 1 else -1)
            (check as ImageButton).setImageState(stateSet, true)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}