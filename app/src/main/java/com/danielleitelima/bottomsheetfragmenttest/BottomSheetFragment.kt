package com.danielleitelima.bottomsheetfragmenttest

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.danielleitelima.bottomsheetfragmenttest.base.BottomSheetBehaviorDialogFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior

class BottomSheetFragment() : BottomSheetBehaviorDialogFragment() {
    override fun createContentView(): View {
        val vi = requireContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v: View = vi.inflate(R.layout.bottom_sheet_layout, null)
        return v
    }

    override fun getStateStart(): Int {
        return BottomSheetBehavior.STATE_COLLAPSED
    }

    override fun setupBehavior(behavior: BottomSheetBehavior<View>) {
        super.setupBehavior(behavior)
        behavior.peekHeight = Resources.getSystem().getDisplayMetrics().heightPixels/3
    }

    override fun onStateChanged(bottomSheet: View, newState: Int) {
        super.onStateChanged(bottomSheet, newState)
        Toast.makeText(requireContext(),"State changed to : $newState",Toast.LENGTH_SHORT).show()
    }
}