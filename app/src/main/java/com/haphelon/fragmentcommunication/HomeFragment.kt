package com.haphelon.fragmentcommunication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class HomeFragment : Fragment(), CustomDialogFragment.DialogFragmentListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btn_dialog).setOnClickListener {
            CustomDialogFragment().newInstance("Test Dialog")?.show(childFragmentManager, "Test")
        }
    }

    override fun onAttachFragment(childFragment: Fragment) {
        if (childFragment is CustomDialogFragment) {
            childFragment.listener = this
        }
    }

    override fun onDelete() {
        Toast.makeText(context, "Delete", Toast.LENGTH_LONG).show()
    }

    override fun onDownload() {
        Toast.makeText(context, "Download", Toast.LENGTH_LONG).show()
    }
}
