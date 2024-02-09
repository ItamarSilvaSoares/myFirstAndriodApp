package br.com.trybe.mycalc

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private val fieldLike: TextInputEditText by lazy { findViewById(R.id.input_wylike) }
    private val buttonClickHere: Button by lazy { findViewById(R.id.button_ckick_here) }
    private val viewMessage: TextView by lazy { findViewById(R.id.textView) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setButtonListener()
        showMessage(false)
    }

    private fun setButtonListener() {
        this.buttonClickHere.setOnClickListener {
            if (this.viewMessage.isGone and this.fieldLike.text!!.isNotEmpty() and this.fieldLike.text!!.isNotBlank()) {
                this.viewMessage.text =
                    resources.getString(R.string.welcome_messages, this.fieldLike.text.toString())
                showMessage(true)
                this.buttonClickHere.text = resources.getString(R.string.clear_button)
            } else {
                this.buttonClickHere.text = resources.getString(R.string.click_here)
                this.fieldLike.text?.clear()
                showMessage(false)
            }
        }
    }

    private fun showMessage(show: Boolean) {
        if (show) {
            this.viewMessage.visibility = View.VISIBLE
        } else {
            this.viewMessage.visibility = View.GONE
        }
    }
}