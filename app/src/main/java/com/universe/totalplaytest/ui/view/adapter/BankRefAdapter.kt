package com.universe.totalplaytest.ui.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import com.universe.totalplaytest.R
import com.universe.totalplaytest.domain.model.BankArrayReference

class BankRefAdapter(private var bankRefList: List<BankArrayReference>): RecyclerView.Adapter<BankRefAdapter.ViewHolderReference>() {

    class ViewHolderReference(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvAliasBank: TextView = itemView.findViewById(R.id.tvAliasBank)
        val tvReference: TextView = itemView.findViewById(R.id.tvReference)
        val ivBank: SimpleDraweeView = itemView.findViewById(R.id.ivBank)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderReference {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_bank_reference, parent, false)
        return ViewHolderReference(view)
    }

    override fun onBindViewHolder(holder: ViewHolderReference, position: Int) {
        holder.tvAliasBank.text = bankRefList[position].aliasbank
        holder.tvReference.text = bankRefList[position].reference
        bankRefList[position]?.images?.get(0)?.url3X3.let { image->
            holder.ivBank.setImageURI(image)
        }

    }

    override fun getItemCount() = bankRefList.size
}