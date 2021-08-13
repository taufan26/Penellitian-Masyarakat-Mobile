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
import app.ppip.penelitian_mobile.model.usulanPenelitian.UsulanPenelitianItem;

public class UsulanPenelitianAdapter extends RecyclerView.Adapter<UsulanPenelitianAdapter.RecyclerViewAdapter> {

    private Context context;
    private List<UsulanPenelitianItem> datas;
    private UsulanPenelitianAdapter.ItemClickListener itemClickListener;
    String Status;

    public UsulanPenelitianAdapter(Context context, List<UsulanPenelitianItem> data, UsulanPenelitianAdapter.ItemClickListener itemClickListener) {
        this.context = context;
        this.datas = data;
        this.itemClickListener = itemClickListener;
    }


    @NonNull
    @Override
    public UsulanPenelitianAdapter.RecyclerViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_usulan,
                parent, false);
        return new RecyclerViewAdapter(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull UsulanPenelitianAdapter.RecyclerViewAdapter holder, int position) {

        UsulanPenelitianItem datausulanpenelitian = datas.get(position);
        holder.tv_judul.setText(datausulanpenelitian.getUsulanPenelitianJudul());
        holder.tv_tahun.setText(datausulanpenelitian.getUsulanPenelitianTahun());
        holder.tv_hari.setText(datausulanpenelitian.getUsulanPenelitianLamaKegiatan());
        holder.tv_anggota.setText(datausulanpenelitian.getAnggotaPenelitianRole());
        Status = datausulanpenelitian.getUsulanPenelitianStatus();
        if (Status.equals("diterima")){
            holder.tv_status.setText("Diterima");
        }else if (Status.equals("dikirim")) {
            holder.tv_status.setText("Dikirim");
        }else if (Status.equals("ditolak")) {
            holder.tv_status.setText("Ditolak");
        }else if (Status.equals("dinilai")) {
            holder.tv_status.setText("Dinilai");
        }else if (Status.equals("pending")) {
            holder.tv_status.setText("Pending");
        }else if (Status.equals("revisi")) {
            holder.tv_status.setText("Revisi");
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class RecyclerViewAdapter extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tv_judul,  tv_tahun, tv_hari, tv_status, tv_anggota;
        CardView card_item;
        UsulanPenelitianAdapter.ItemClickListener itemClickListener;

        RecyclerViewAdapter(@NonNull View itemView, UsulanPenelitianAdapter.ItemClickListener itemClickListener) {
            super(itemView);

            tv_judul = itemView.findViewById(R.id.usulan_judul);
            tv_tahun = itemView.findViewById(R.id.usulan_tahun);
            tv_hari = itemView.findViewById(R.id.usulan_hari);
            tv_status = itemView.findViewById(R.id.usulan_status);
            tv_anggota = itemView.findViewById(R.id.usulan_anggota);
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
