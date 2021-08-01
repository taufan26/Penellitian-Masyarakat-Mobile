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
import app.ppip.penelitian_mobile.model.laporanAkhirPenelitian.LaporanAkhirPenelitianItem;
import app.ppip.penelitian_mobile.model.laporanAkhirPengabdian.LaporanAkhirPengabdianItem;

public class LaporanAkhirPengabdianAdapter extends RecyclerView.Adapter<LaporanAkhirPengabdianAdapter.RecyclerViewAdapter>{

    private Context context;
    private List<LaporanAkhirPengabdianItem> datas;
    private LaporanAkhirPengabdianAdapter.ItemClickListener itemClickListener;

    public LaporanAkhirPengabdianAdapter(Context context, List<LaporanAkhirPengabdianItem> data, LaporanAkhirPengabdianAdapter.ItemClickListener itemClickListener) {
        this.context = context;
        this.datas = data;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_laporan_akhir,
                parent, false);
        return new LaporanAkhirPengabdianAdapter.RecyclerViewAdapter(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter holder, int position) {
        LaporanAkhirPengabdianItem datalaporan = datas.get(position);
        holder.tv_judul.setText(datalaporan.getUsulanPengabdianJudul());
        holder.tv_tahun.setText(datalaporan.getLaporanAkhirDate());
        holder.tv_nama.setText(datalaporan.getLaporanAkhirBaseName());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class RecyclerViewAdapter extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tv_judul,  tv_tahun,  tv_nama;
        CardView card_item;
        LaporanAkhirPengabdianAdapter.ItemClickListener itemClickListener;

        public RecyclerViewAdapter(@NonNull View itemView, LaporanAkhirPengabdianAdapter.ItemClickListener itemClickListener) {
            super(itemView);
            tv_judul = itemView.findViewById(R.id.laporan_akhir_judul);
            tv_tahun = itemView.findViewById(R.id.laporan_akhir_tanggal);
            tv_nama = itemView.findViewById(R.id.laporan_akhir_nama);
            card_item = itemView.findViewById(R.id.card_laporan_akhir);

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
