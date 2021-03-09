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
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    val viewModel by viewModels<MainViewModel>()
    var spinner1 : Spinner? = null
    var spinner2 : Spinner? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        spinner1 = view.findViewById<Spinner>(R.id.spinner_1)
        spinner2 = view.findViewById<Spinner>(R.id.spinner_2)
        viewModel.getExchangeRate()
        viewModel.currencyStrings.observe(viewLifecycleOwner, Observer{
            it?.let{
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
        spinner1?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
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
        spinner2?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
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
        view.findViewById<EditText>(R.id.text_area_1).addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
               s?.toString()?.let{
                   if (it.isNotEmpty())
                   {
                       it.toDouble()?.let{
                           //convert it to euro

                           view.findViewById<EditText>(R.id.text_area_2).setText(viewModel.getExchangeValue(it))
                       }
                   }
               }
            }

        })

    }

}