package com.melnik.mvplesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import com.melnik.mvplesson.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
	private lateinit var vb: ActivityMainBinding
	private val counter = mutableListOf(0, 0, 0)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		vb = ActivityMainBinding.inflate(layoutInflater)
		setContentView(vb.root)

		init()
		with(vb) {
			button1.setOnClickListener {
				txtView1.text = (++counter[0]).toString()
			}
			button2.setOnClickListener {
				txtView2.text = (++counter[1]).toString()
			}
			button3.setOnClickListener {
				txtView3.text = (++counter[2]).toString()
			}
		}

	}

	private fun init() {
		with(vb) {
			txtView1.text = counter[0].toString()
			txtView2.text = counter[1].toString()
			txtView3.text = counter[2].toString()

		}
	}

	override fun onSaveInstanceState(outState: Bundle) {
		super.onSaveInstanceState(outState)
		outState.putIntArray("counters", counter.toIntArray())
	}

	override fun onRestoreInstanceState(savedInstanceState: Bundle) {
		super.onRestoreInstanceState(savedInstanceState)
		val array = savedInstanceState.getIntArray("counters")
		counter.let { list ->
			list.clear()
			array?.toList()?.let {
				list.addAll(it)
			}
		}
		init()
	}
}