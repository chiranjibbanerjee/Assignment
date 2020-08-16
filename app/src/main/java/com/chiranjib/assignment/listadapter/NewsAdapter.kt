package com.chiranjib.assignment.listadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.chiranjib.assignment.R
import com.chiranjib.assignment.model.RowsItem
import kotlinx.android.synthetic.main.custom_view.view.*

/**
 *Class extending The RecyclerView widget is a more advanced and flexible version of ListView.
 */
class NewsAdapter(val list:List<RowsItem?>, val cntx: Context):RecyclerView.Adapter<NewsAdapter.VViewHolder>() {

    var requestOptions: RequestOptions

    init {
        requestOptions = RequestOptions()
        requestOptions.placeholder(R.drawable.loading)
        requestOptions.error(R.drawable.noimage)
    }


    class VViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        val titleText=itemView.tv_title
        val descriptionText=itemView.tv_description
        val newsImage=itemView.img_newsimage
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VViewHolder {
        val v: View = LayoutInflater.from(parent?.context)
            .inflate(R.layout.custom_view, parent, false)

        // Return the view holder
        return VViewHolder(
            v
        )
    }

    override fun getItemCount(): Int {
        return list?.size
    }

    override fun onBindViewHolder(holder: VViewHolder, position: Int) {
        holder.titleText.text=list?.get(position)?.title
        holder.descriptionText.text=list?.get(position)?.description
        Glide.with(holder?.newsImage.context)
            .load(
                list.get(position)?.imageHref?.replace(
                    cntx.resources.getString(R.string.http),
                    cntx.resources.getString(R.string.https)
                )
            )
            .apply(requestOptions) /// Placeholder
            .override(
                cntx.resources.getInteger(R.integer.image_height),
                cntx.resources.getInteger(R.integer.image_width)
            )
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(holder?.newsImage);

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}