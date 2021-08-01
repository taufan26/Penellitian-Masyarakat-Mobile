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
import app.ppip.penelitian_mobile.model.LaporanKemajuanPengabdian.LaporanKemajuanPengabdianItem;
import app.ppip.penelitian_mobile.model.laporanKemajuanPenelitian.LaporanKemeajuanPenelitianItem;

public class LaporanKemajuanPengabdianAdapter extends RecyclerView.Adapter<LaporanKemajuanPengabdianAdapter.RecyclerViewAdapter>{

    private Context context;
    private List<LaporanKemajuanPengabdianItem> datas;
    private LaporanKemajuanPengabdianAdapter.ItemClickListener itemClickListener;

    public LaporanKemajuanPengabdianAdapter(Context context, List<LaporanKemajuanPengabdianItem> data, LaporanKemajuanPengabdianAdapter.ItemClickListener itemClickListener) {
        this.context = context;
        this.datas = data;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public LaporanKemajuanPengabdianAdapter.RecyclerViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_laporan_kemajuan,
                parent, false);
        return new LaporanKemajuanPengabdianAdapter.RecyclerViewAdapter(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull LaporanKemajuanPengabdianAdapter.RecyclerViewAdapter holder, int position) {
        LaporanKemajuanPengabdianItem datalaporan = datas.get(position);
        holder.tv_judul.setText(datalaporan.getUsulanPengabdianJudul());
        holder.tv_tahun.setText(datalaporan.getLaporanKemajuanDate());
        holder.tv_nama.setText(datalaporan.getLaporanKemajuanBaseName());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class RecyclerViewAdapter extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tv_judul,  tv_tahun,  tv_nama;
        CardView card_item;
        LaporanKemajuanPengabdianAdapter.ItemClickListener itemClickListener;

        public RecyclerViewAdapter(@NonNull View itemView, LaporanKemajuanPengabdianAdapter.ItemClickListener itemClickListener) {
            super(itemView);
            tv_judul = itemView.findViewById(R.id.laporan_kemajuan_judul);
            tv_tahun = itemView.findViewById(R.id.laporan_kemajuan_tanggal);
            tv_nama = itemView.findViewById(R.id.laporan_kemajuan_nama);
            card_item = itemView.findViewById(R.id.card_laporan_kemajuan);

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
