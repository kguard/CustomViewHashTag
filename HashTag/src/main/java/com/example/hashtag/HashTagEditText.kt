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
        //HashTag()
    }
    private fun initAttr(attrs: AttributeSet?){
        context.theme.obtainStyledAttributes(
            attrs,R.styleable.HashTagEditText,0,0).apply {
                try {
                   val editcolor = getString(R.styleable.HashTagEditText_HashTag_Color)
                    HashTag(Color.parseColor(editcolor))
                }
                finally {
                    recycle()
                }
        }
    }
    fun HashTag(color:Int){
        val hashtag="^#\\S*"
        this@HashTagEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val a = this@HashTagEditText.text.toString().split(" ")
                var count=0
                for (i in a) {
                    val p = Pattern.matches(hashtag, i)
                    this@HashTagEditText.text?.indexOf(i,count)?.let {
                        if (p) {
                            /*this@HashTagEditText.text?.setSpan(
                                UnderlineSpan(),
                                it,
                                it+i.length,
                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                            )*/
                            this@HashTagEditText.text?.setSpan(
                                ForegroundColorSpan(color),
                                it,
                                it + i.length,
                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                            )
                            count += i.length+1
                        }
                        else {
                            this@HashTagEditText.text?.setSpan(
                                ForegroundColorSpan(Color.BLACK),
                                it,
                                it + i.length,
                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                            )
                            count += i.length+1
                        }
                    }
                }
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })
    }
}