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
import app.ppip.penelitian_mobile.model.laporanKemajuanPenelitian.LaporanKemeajuanPenelitianItem;
import app.ppip.penelitian_mobile.model.logbookPenelitian.LogbookPenelitianItem;

public class LaporanKemajuanPenelitianAdapter extends RecyclerView.Adapter<LaporanKemajuanPenelitianAdapter.RecyclerViewAdapter>{

    private Context context;
    private List<LaporanKemeajuanPenelitianItem> datas;
    private LaporanKemajuanPenelitianAdapter.ItemClickListener itemClickListener;

    public LaporanKemajuanPenelitianAdapter(Context context, List<LaporanKemeajuanPenelitianItem> data, LaporanKemajuanPenelitianAdapter.ItemClickListener itemClickListener) {
        this.context = context;
        this.datas = data;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public LaporanKemajuanPenelitianAdapter.RecyclerViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_laporan_kemajuan,
                parent, false);
        return new LaporanKemajuanPenelitianAdapter.RecyclerViewAdapter(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull LaporanKemajuanPenelitianAdapter.RecyclerViewAdapter holder, int position) {
        LaporanKemeajuanPenelitianItem datalaporan = datas.get(position);
        holder.tv_judul.setText(datalaporan.getUsulanPenelitianJudul());
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
        LaporanKemajuanPenelitianAdapter.ItemClickListener itemClickListener;

        public RecyclerViewAdapter(@NonNull View itemView, LaporanKemajuanPenelitianAdapter.ItemClickListener itemClickListener) {
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
