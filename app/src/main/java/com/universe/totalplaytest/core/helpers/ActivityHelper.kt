package com.universe.totalplaytest.core.helpers

import androidx.appcompat.app.AppCompatActivity

/**
 * This class will help us show and hide the loader
 *
 */
open class ActivityHelper: AppCompatActivity(), IActivityHelper {
    override fun showLoader(message: String) {
        DialogStatusHelper.showDialog(this, message)
    }

    override fun hideLoader() {
        DialogStatusHelper.closeDialog()
    }
}