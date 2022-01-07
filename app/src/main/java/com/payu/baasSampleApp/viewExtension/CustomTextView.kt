package com.payu.baasSampleApp.viewExtension

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Typeface
import android.os.Build
import android.util.AttributeSet
import android.widget.TextView
import com.payu.baasSampleApp.R
import com.payu.baasSampleApp.viewExtension.FontCache.getTypeface


@SuppressLint("AppCompatCustomView")
class CustomTextView : TextView {
    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        setCustomFont(context!!, attrs!!)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        setCustomFont(context!!, attrs!!)
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        setCustomFont(context!!, attrs!!)
    }

    private fun setCustomFont(context: Context, attrs: AttributeSet) {
        val array: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.PTextView)
        val fontPath: String? = array.getString(R.styleable.PTextView_custFont)
        setCustomFont(context, fontPath)
        array.recycle()
    }

    fun setCustomFont(context: Context?, fontPath: String?): Boolean {
        val typeface: Typeface? = com.payu.baasSampleApp.viewExtension.FontCache.getTypeface(context!!,
            fontPath!!
        )
        setTypeface(typeface)
        return true
    }
}