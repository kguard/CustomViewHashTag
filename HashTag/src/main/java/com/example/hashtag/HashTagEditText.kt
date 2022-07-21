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
import java.util.regex.Pattern

class HashTagEditText(context: Context, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatEditText(context,attrs)
{
        private val mContext: Context = context
    init
    {
        mContext.theme.obtainStyledAttributes(attrs,R.styleable.HashTagEditText,0,0).apply {
            try {
                val HashColor=getString(R.styleable.HashTagEditText_HashTag_Color)
            }
            finally {
                recycle()
            }
        }
    }

   /*fun HashTag(editText: EditText){
        val hashtag="^#\\w*"
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val a = editText.text.toString().split(" ")
                for (i in a) {
                    val p = Pattern.matches(hashtag, i)
                    if (p) {
                        editText.text.setSpan(
                            UnderlineSpan(),
                            editText.text.indexOf(i),
                            editText.text.indexOf(i) + i.length,
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                        )
                        editText.text.setSpan(
                            ForegroundColorSpan(Color.BLUE),
                            editText.text.indexOf(i),
                            editText.text.indexOf(i) + i.length,
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                        )
                    }
                }
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })
    }*/
}