package com.example.daynight

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.google.android.material.internal.TextWatcherAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val textWatcher = object : TextWatcherAdapter() {
        override fun afterTextChanged(s: Editable) {
            s.toString().let { string ->
                if (string.isNotEmpty()) {
                    string.toDouble().let {
                        viewModel.getExchangeValue(it)
                    }
                }
            }
        }
    }
    private var textArea1: EditText? = null
    private var textArea2: EditText? = null
    var resultTextView: EditText? = null
    val viewModel by viewModels<MainViewModel>()
    private var spinner1: Spinner? = null
    private var spinner2: Spinner? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        spinner1 = view.findViewById(R.id.spinner_1)
        spinner2 = view.findViewById(R.id.spinner_2)
        textArea1 = view.findViewById(R.id.text_area_1)
        textArea2 = view.findViewById(R.id.text_area_2)
        viewModel.getExchangeRate()
        viewModel.currencyStrings.observe(viewLifecycleOwner, {
            it?.let {
                val adapter1: ArrayAdapter<String> = ArrayAdapter(
                    view.context,
                    android.R.layout.simple_spinner_item, it
                )
                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                val adapter2: ArrayAdapter<String> = ArrayAdapter(
                    view.context,
                    android.R.layout.simple_spinner_item, it
                )
                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner1?.adapter = adapter1
                spinner2?.adapter = adapter2
            }
        })
        viewModel.currentExchangeRate.observe(viewLifecycleOwner, {
            it?.let {
                if (it.isFinite()) {
                    resultTextView?.setText(String.format("%.2f",it))
                }
            }

        })
        spinner1?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                viewModel.setSelectedCurrency1(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
        spinner2?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                viewModel.setSelectedCurrency2(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
        textArea1?.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                textArea1?.addTextChangedListener(textWatcher)
                textArea2?.removeTextChangedListener(textWatcher)
                viewModel.setConversionMode(2)
                resultTextView = textArea2
            }
        }
        textArea2?.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                textArea2?.addTextChangedListener(textWatcher)
                textArea1?.removeTextChangedListener(textWatcher)
                viewModel.setConversionMode(1)
                resultTextView = textArea1
            }
        }
    }

}