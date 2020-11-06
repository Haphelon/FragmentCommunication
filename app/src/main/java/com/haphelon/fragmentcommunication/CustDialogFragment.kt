package com.haphelon.fragmentcommunication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment

class CustomDialogFragment : DialogFragment() {

    internal var listener: DialogFragmentListener? = null

    fun newInstance(title: String?): CustomDialogFragment? {
        val frag = CustomDialogFragment()
        val args = Bundle()
        args.putString("title", title)
        frag.arguments = args
        return frag
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_cust_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btn_delete).setOnClickListener {
            listener?.onDelete()
            dismiss()
        }
        view.findViewById<Button>(R.id.btn_download).setOnClickListener {
            listener?.onDownload()
            dismiss()
        }
    }

    interface DialogFragmentListener {
        fun onDelete()
        fun onDownload()
    }

}
