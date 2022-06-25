package com.nurettingorsoy.recyclerviewadapter.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nurettingorsoy.recyclerviewadapter.Model.Manzara;
import com.nurettingorsoy.recyclerviewadapter.R;

import java.util.ArrayList;
import java.util.List;

public class ManzaraAdapter extends RecyclerView.Adapter<ManzaraAdapter.MyViewHolder>{

    List<Manzara> manzara; // veri kaynağını tutacak
    LayoutInflater inflater;


    public ManzaraAdapter() {
    }

    public ManzaraAdapter(List<Manzara> manzara, Context context){
        //inflater servisini çağırmamız lazım onu da context nesnesiyle çağırabiliriz.
        //inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.manzara=manzara;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //uygulamayı ılk açtıgımızda 7 tane eleman için inflater işleminin yapacak ve bir daha yapmayacak


        View v = inflater.inflate(R.layout.list_item,parent,false);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    //inflate ettği viewları ilgili tıklanan ögeleri dolduracak

    //hangisine hangi veriye atayacağız ?? hangi öğeye tıklanıyor

        Manzara tiklanilanManzara = manzara.get(position);
        holder.setData(tiklanilanManzara,position);
    }

    @Override
    public int getItemCount() {
        //listenin eleman sayısı
        return manzara.size();
    }



    //bu sınıfı ben kendim manuel yazdım
    class MyViewHolder extends RecyclerView.ViewHolder{
    //tum ögeleri burada tanımlayacaz
        
        TextView mManzaraBaslik,mManzaraAciklama;
        ImageView mManzaraResmi,mSilResmi,mKopyalaResmi;

        int tiklanilanOgeninPositionDegeri = 0;
        Manzara kopyalanacakManzara;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mManzaraBaslik = itemView.findViewById(R.id.tvManzaraBaslik);
            mManzaraAciklama = itemView.findViewById(R.id.tvManzaraAciklama);
            mManzaraResmi = (ImageView) itemView.findViewById(R.id.imgManzara);
            mSilResmi  = (ImageView) itemView.findViewById(R.id.imgSil);
            mKopyalaResmi  = (ImageView) itemView.findViewById(R.id.imgKopyala);

            mSilResmi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                deleteItem(tiklanilanOgeninPositionDegeri);
                }
            });
            mKopyalaResmi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                addItem(tiklanilanOgeninPositionDegeri,kopyalanacakManzara);
                }
            });

        }

        public void setData(Manzara tiklanilanManzara, int position) {
            this.mManzaraBaslik.setText(tiklanilanManzara.getBaslik());
            this.mManzaraAciklama.setText(tiklanilanManzara.getTanim());

            this.tiklanilanOgeninPositionDegeri=position;
            this.kopyalanacakManzara=tiklanilanManzara;
            Glide
                    .with(itemView.getContext())
                    .load(manzara.get(position).getImageurl())
                    .into(mManzaraResmi);
        }
    }


    public void deleteItem(int position){
        manzara.remove(position);
        notifyItemRemoved(position);//güncelle
        notifyItemRangeChanged(position,manzara.size()); //eleman sayıları guncel tut poziyonları düzenle


    }
    public void addItem(int position,Manzara kopyalanacakManzara){
        manzara.add(position,kopyalanacakManzara);
        notifyItemInserted(position);//güncelle
        notifyItemRangeChanged(position,manzara.size());

        //notifyDataSetChanged(); yukarıdakilerin yaptığı işi tek seferde yapar.
    }
}
