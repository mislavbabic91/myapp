import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.podcastland.R
import com.example.podcastland.data.Podcast

class PodcastAdapter(private val context: android.content.Context, private var items: List<Podcast>): RecyclerView.Adapter<PodcastAdapter.PodcastViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PodcastAdapter.PodcastViewHolder {
        return PodcastViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.podcast_fragment,
            parent, false)
        )
    }
    override fun onBindViewHolder(holder: PodcastAdapter.PodcastViewHolder, position: Int) {
        val currentItem = items[position]

        holder.podcastName.text = currentItem.title
        holder.podcastAuthor.text = currentItem.author
        holder.podcastGenre.text = currentItem.genre
        holder.podcastDescription.text = currentItem.description

        Glide.with(context).load(currentItem.imageUrl).into(holder.photoImage)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun postItemsList(data: ArrayList<Podcast>) {
        items = data
    }

    class PodcastViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val photoImage: ImageView = itemView.findViewById(R.id.ivItemImage)
        val podcastName: TextView = itemView.findViewById(R.id.tvPrimary)
        val podcastAuthor: TextView = itemView.findViewById(R.id.tvSecondary)
        val podcastGenre: TextView = itemView.findViewById(R.id.tvGenre)
        val podcastDescription: TextView = itemView.findViewById(R.id.tvDescription)

    }
}

