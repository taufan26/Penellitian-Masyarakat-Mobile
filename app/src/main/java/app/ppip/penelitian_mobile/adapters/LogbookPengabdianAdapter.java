package app.ppip.penelitian_mobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.ppip.penelitian_mobile.R;
import app.ppip.penelitian_mobile.model.logbookPenelitian.LogbookPenelitianItem;
import app.ppip.penelitian_mobile.model.logbookPengabdian.LogbookPengabdianItem;

public class LogbookPengabdianAdapter extends RecyclerView.Adapter<LogbookPengabdianAdapter.RecyclerViewAdapter>{

    private Context context;
    private List<LogbookPengabdianItem> datas;
    private LogbookPengabdianAdapter.ItemClickListener itemClickListener;

    public LogbookPengabdianAdapter(Context context, List<LogbookPengabdianItem> data, LogbookPengabdianAdapter.ItemClickListener itemClickListener) {
        this.context = context;
        this.datas = data;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public LogbookPengabdianAdapter.RecyclerViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_logbook,
                parent, false);
        return new LogbookPengabdianAdapter.RecyclerViewAdapter(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull LogbookPengabdianAdapter.RecyclerViewAdapter holder, int position) {
        LogbookPengabdianItem datalogbook = datas.get(position);
        holder.tv_judul.setText(datalogbook.getUsulanPengabdianJudul());
        holder.tv_tahun.setText(datalogbook.getLogbookDate());
        holder.tv_presentase.setText(datalogbook.getLogbookPresentase());
        holder.tv_kegiatan.setText(datalogbook.getLogbookUraianKegiatan());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class RecyclerViewAdapter extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tv_judul,  tv_tahun, tv_presentase, tv_kegiatan;
        CardView card_item;
        LogbookPengabdianAdapter.ItemClickListener itemClickListener;

        public RecyclerViewAdapter(@NonNull View itemView, LogbookPengabdianAdapter.ItemClickListener itemClickListener) {
            super(itemView);
            tv_judul = itemView.findViewById(R.id.logbook_judul);
            tv_tahun = itemView.findViewById(R.id.logbook_tahun);
            tv_presentase = itemView.findViewById(R.id.logbook_persentase);
            tv_kegiatan = itemView.findViewById(R.id.logbook_kegiatan);
            card_item = itemView.findViewById(R.id.card_logbook);

            this.itemClickListener = itemClickListener;
            card_item.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onItemClick(v, getAdapterPosition());
        }
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
