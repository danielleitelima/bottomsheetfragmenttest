package com.danielleitelima.bottomsheetfragmenttest.base

import android.app.Dialog
import android.os.Bundle
import android.view.View
import com.danielleitelima.bottomsheetfragmenttest.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class BottomSheetBehaviorDialogFragment: BottomSheetDialogFragment(){
    private var behavior: BottomSheetBehavior<View>? = null

    abstract fun createContentView(): View

    open fun getStateStart(): Int = BottomSheetBehavior.STATE_EXPANDED

    open fun onSlide(bottomSheet: View, slideOffset: Float) = Unit

    open fun onStateChanged(bottomSheet: View, newState: Int) = Unit

    open fun setupBehavior(behavior: BottomSheetBehavior<View>) = Unit

    open fun isBackgroundTransparent() = false

    fun getBehavior() = behavior

    override fun getTheme(): Int = if (isBackgroundTransparent()) R.style.BottomSheetDialogTransparent else super.getTheme()

    override fun onStart() {
        super.onStart()
        behavior?.state = getStateStart()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog

        val contentView = createContentView()

        dialog.setContentView(contentView)

        behavior = BottomSheetBehavior.from(contentView.parent as View)?.also {

            setupBehavior(it)

            it.setBottomSheetCallback(object: BottomSheetBehavior.BottomSheetCallback(){
                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                    this@BottomSheetBehaviorDialogFragment.onSlide(bottomSheet, slideOffset)
                }

                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                        dismissAllowingStateLoss()
                    } else {
                        this@BottomSheetBehaviorDialogFragment.onStateChanged(bottomSheet, newState)
                    }
                }
            })
        }
        return dialog
    }
}