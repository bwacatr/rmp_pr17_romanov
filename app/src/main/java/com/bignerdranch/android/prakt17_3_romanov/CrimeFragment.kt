package com.bignerdranch.android.prakt17_3_romanov

import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CrimeFragment : Fragment() {
    private lateinit var crime: Crime
    private lateinit var name : EditText
    private lateinit var status : CheckBox
    private lateinit var dateButton: Button
    override fun onCreate(savedInstanceState: Bundle?)
    {

        super.onCreate(savedInstanceState)
        crime = Crime()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?) : View?
    {
        val view = inflater.inflate(R.layout.fragment_crime,container,false)
        name = view.findViewById(R.id.crime_title) as EditText
        status = view.findViewById(R.id.status) as CheckBox

        dateButton = view.findViewById(R.id.crime_date) as Button
        dateButton.apply {text = crime.date.toString()
        isEnabled = false
        }


        return view
    }
    fun updateButton()
    {
        if (crime.name.isNotEmpty() == true && crime.status == true)
        {
            dateButton.isEnabled = true
        }
        else
        {
            dateButton.isEnabled = false
            var a = Toast.makeText(context,"Введите текст и поставьте галочку, чтобы продолжить", Toast.LENGTH_SHORT)
            a.show()
        }
    }

    fun SendToast()
    {
        if (crime.name.isNotEmpty() == true && crime.status == true)
        {

            var a = Toast.makeText(context,"Успешно", Toast.LENGTH_SHORT)
            a.show()
        }
        else
        {

            var a = Toast.makeText(context,"Введите текст и поставьте галочку, чтобы продолжить", Toast.LENGTH_SHORT)
            a.show()
        }
    }
    override fun onStart()
    {
        super.onStart()
        val titleWatcher = object : TextWatcher
        {
            override fun beforeTextChanged(sequence: CharSequence?, start: Int, count: Int, after: Int){}
            override fun onTextChanged(sequence: CharSequence?, start: Int, before: Int, count: Int)
            {
                crime.name = sequence.toString()

            }

            override fun afterTextChanged(s: Editable?) {
                updateButton() //обновление кнопки при введении текста
            }

        }
        name.addTextChangedListener(titleWatcher)
        status.apply {setOnCheckedChangeListener{_,isChecked ->
            crime.status = isChecked}

        }
        status.setOnClickListener {//Обновление кнопки при нажатии на checkbox
            updateButton()
        }
        dateButton.setOnClickListener {
            SendToast()
        }

    }
}