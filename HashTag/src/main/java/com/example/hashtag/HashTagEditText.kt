package com.example.hashtag

import android.content.Context
import android.graphics.Color
import android.text.Editable
import android.text.Spannable
import android.text.TextWatcher
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.util.AttributeSet
import android.widget.EditText
import androidx.appcompat.widget.AppCompatEditText
import java.util.regex.Pattern

class HashTagEditText(context: Context, attrs: AttributeSet?) : AppCompatEditText(context,attrs)
{
    init {
        initAttr(attrs)
        HashTag()
    }
    private fun initAttr(attrs: AttributeSet?){
        context.theme.obtainStyledAttributes(
            attrs,R.styleable.HashTagEditText,0,0).apply {
                try {
                   val editcolor = getString(R.styleable.HashTagEditText_HashTag_Color)
                }
                finally {
                    recycle()
                }
        }
    }
    fun HashTag(){
        val hashtag="^#\\w*"
        this@HashTagEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val a = this@HashTagEditText.text.toString().split(" ")
                for (i in a) {
                    val p = Pattern.matches(hashtag, i)
                    if (p) {
                        this@HashTagEditText.text?.indexOf(i)?.let {
                            this@HashTagEditText.text?.setSpan(
                                UnderlineSpan(),
                                it,
                                it+ i.length,
                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                            )
                        this@HashTagEditText.text?.setSpan(
                            ForegroundColorSpan(Color.BLUE),
                            it,
                            it+ i.length,
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                        )
                        }
                    }
                }
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })
    }
}