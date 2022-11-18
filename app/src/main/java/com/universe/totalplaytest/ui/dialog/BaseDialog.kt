package com.universe.totalplaytest.ui.dialog

import android.app.Dialog
import android.content.Context
import android.view.WindowManager
import com.universe.totalplaytest.R

abstract class BaseDialog: Dialog {
    protected var iContext: Context

    /**
     * @param context
     * @param layoutResID
     * @param gravity
     * @Title:BaseDialog
     */
    constructor(context: Context, layoutResID: Int, gravity: Int) : super(context, R.style.DialogStyle) {
        iContext = context
        setContentView(layoutResID)
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val dialogWindow = window
        val lp = dialogWindow!!.attributes
        dialogWindow.setGravity(gravity)
        lp.width = wm.defaultDisplay.width
        dialogWindow.attributes = lp
        //Set the animation
        show()
    }

    /**
     * @param context
     * @param layoutResID
     * @param gravity
     * @param fullscreen
     * @Title:BaseDialog
     */
    constructor(context: Context, layoutResID: Int, gravity: Int, fullscreen: Boolean) : super(context, R.style.DialogStyle) {
        iContext = context
        setContentView(layoutResID)
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val dialogWindow = window
        // dialogWindow.clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        val lp = dialogWindow!!.attributes
        dialogWindow.setGravity(gravity)
        lp.width = wm.defaultDisplay.width
        if (fullscreen)
            lp.height = wm.defaultDisplay.height
        dialogWindow.attributes = lp
        show()
    }

    /**
     * @param context
     * @param layoutResID
     * @param x
     * @param gravity
     * @Title:BaseDialog
     */
    constructor(context: Context, layoutResID: Int, x: Int, y: Int, gravity: Int) : super(context, R.style.DialogStyle) {
        iContext = context
        setContentView(layoutResID)
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val dialogWindow = window
        // dialogWindow.clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        val lp = dialogWindow!!.attributes
        dialogWindow.setGravity(gravity)
        lp.x = x
        lp.y = y
        dialogWindow.attributes = lp
        show()
    }
}