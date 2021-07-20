package app.ppip.penelitian_mobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.ppip.penelitian_mobile.model.biodata.Biodata;
import app.ppip.penelitian_mobile.model.usulanPengabdian.DataUsulanPengabdian;

public class UsulanAdapter extends RecyclerView.Adapter<UsulanAdapter.RecyclerViewAdapter> {

    private Context context;
    private List<DataUsulanPengabdian> datas;
    private ItemClickListener itemClickListener;

    public UsulanAdapter(Context context, List<DataUsulanPengabdian> data, ItemClickListener itemClickListener) {
        this.context = context;
        this.datas = data;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_usulan,
                parent, false);
        return new RecyclerViewAdapter(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter holder, int position) {

        DataUsulanPengabdian datausulan = datas.get(position);
        holder.tv_judul.setText(datausulan.getUsulanPengabdianJudul());
        holder.tv_kategori.setText(datausulan.getUsulanPengabdianKategori());
        holder.tv_tahun.setText(datausulan.getUsulanPengabdianTahun());
        holder.tv_hari.setText(datausulan.getUsulanPengabdianLamaKegiatan());
        holder.tv_status.setText(datausulan.getUsulanPengabdianStatus());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class RecyclerViewAdapter extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tv_judul, tv_kategori, tv_tahun, tv_hari, tv_status;
        CardView card_item;
        ItemClickListener itemClickListener;

        RecyclerViewAdapter(@NonNull View itemView, ItemClickListener itemClickListener) {
            super(itemView);

            tv_judul = itemView.findViewById(R.id.usulan_judul);
            tv_kategori = itemView.findViewById(R.id.usulan_kategori);
            tv_tahun = itemView.findViewById(R.id.usulan_tahun);
            tv_hari = itemView.findViewById(R.id.usulan_hari);
            tv_status = itemView.findViewById(R.id.usulan_status);
            card_item = itemView.findViewById(R.id.card_usulan);

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
