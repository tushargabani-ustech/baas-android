package com.payu.baasSampleApp.viewExtension

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Typeface
import android.os.Build
import android.util.AttributeSet
import android.view.Gravity
import android.view.View.TEXT_ALIGNMENT_GRAVITY
import android.widget.Button
import com.payu.baasSampleApp.R
import com.payu.baasSampleApp.viewExtension.FontCache.getTypeface


@SuppressLint("AppCompatCustomView")
class CustomButton : Button {
    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        setFontAndBgColor()
        setCustomFont(context!!, attrs!!)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        setFontAndBgColor()
        //        setCustomFont(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        setFontAndBgColor()
        setCustomFont(context!!, attrs!!)
    }

    private fun setFontAndBgColor() {
        this.setTextColor(getResources().getColor(R.color.black))
        this.setGravity(Gravity.CENTER)
        this.setTextAlignment(TEXT_ALIGNMENT_GRAVITY)
        //        this.setTextSize(TypedValue.COMPLEX_UNIT_DIP,getResources().getDimension(R.dimen.subTitleTextSize));
//        this.setTextSize(getResources().getDimension(R.dimen.subTitleTextSize));
        this.setBackground(getResources().getDrawable(R.drawable.button_bg))
    }

    private fun setCustomFont(context: Context, attrs: AttributeSet) {
        val array: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.PTextView)
        val fontPath: String? = array.getString(R.styleable.PTextView_custFont)
        setCustomFont(context, fontPath)
        array.recycle()
    }

    fun setCustomFont(context: Context?, fontPath: String?): Boolean {
        val typeface: Typeface? = getTypeface(
            context!!,
            fontPath!!
        )
        setTypeface(typeface)
        return true
    }
}